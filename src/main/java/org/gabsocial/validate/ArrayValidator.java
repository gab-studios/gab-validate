/*****************************************************************************************
 *
 * Copyright 2015 Gregory Brown. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 *****************************************************************************************
 */

package org.gabsocial.validate;

import java.util.Arrays;


/**
 * This is a String validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 * Validate.defineString(String).testNotNull().validate();
 *
 * If the throwExceptionOnFailedValidation() method has been called and if the
 * validate fails then a ValidateException will be thrown.
 * 
 * Validate.defineString(String).testEquals(String)
 * .throwExceptionOnFailedValidation().validate();
 *
 * If no test method is called, validate() returns a false.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ArrayValidator extends BaseValidator<ArrayValidator>
{
    /*
     * The value to use if the testEquals(boolean) method has been called.
     */
    private Object[] _equalsValue;
    
    /*
     * A flag indicating if an "equals" test will be performed when the
     * validate() method is called.
     */
    private boolean  _isTestEquals    = false;
    
    /*
     * A flag indicating that a max length test will be performed when the
     * validate() method is called.
     */
    private boolean  _isTestMaxLength = false;
    
    /*
     * A flag indicating that a min length test will be performed when the
     * validate() method is called.
     */
    private boolean  _isTestMinLength = false;
    
    /*
     * A flag indicating if an "not empty" test will be performed when the
     * validate() method is called.
     */
    private boolean  _isTestNotEmpty  = false;
    
    /*
     * A flag indicating if an "not null" test will be performed when the
     * validate() method is called.
     */
    private boolean  _isTestNotNull   = false;
    
    /*
     * The max length to test for. Defaults to -1.
     */
    private int      _maxLength       = -1;
    
    /*
     * The min length to test for. Defaults to -1.
     */
    private int      _minLength       = -1;
    
    /*
     * The String that will be tested.
     */
    private Object[] _value;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated. This value can be null or
     *            empty.
     */
    protected ArrayValidator(final Object[] value)
    {
        this._value = value;
    }
    
    /**
     * Gets the value that was used to initialize this validator.
     * 
     * @return A String value.
     */
    public Object[] getValue()
    {
        Object[] retVal = null;
        if( this._value != null )
        {
            retVal = Arrays.copyOf(this._value, this._value.length);
        }
        
        return (retVal);
    }
    
    /**
     * A method to mark that an "equals" test will be performed when the
     * validate() method is called.
     * 
     * @param equalsValue
     *            The value to perform the equate with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public ArrayValidator testEquals(final Object[] equalsValue)
    {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestEquals = true;
        
        if( equalsValue != null )
        {
            this._equalsValue = Arrays.copyOf(equalsValue, this._value.length);
        }
        
        return (this);
    }
    
    /**
     * A method to mark that an "max length" test will be performed when the
     * validate() method is called. Tests if the length is less than or equal to
     * the max value when the validate method is called.
     * 
     * @param maxLength
     *            The value to perform the test with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public ArrayValidator testMaxLength(final int maxLength)
    {
        if (maxLength < 0)
        {
            throw( new IllegalArgumentException("The parameter 'maxLength' must be greater than zero (0)."));
        }
        else if (maxLength < this._minLength)
        {
            throw( new IllegalArgumentException("The parameter 'maxLength' must be greater than the min length value."));
        }
        else
        {
            // have to test for null if empty is selected.
            this._isTestNotNull = true;
            this._isTestMaxLength = true;
            this._maxLength = maxLength;
        }
        return (this);
    }
    
    /**
     * A method to mark that an "min length" test will be performed when the
     * validate() method is called. Tests if the value is greater than or equal
     * to the min value when the validate method is called.
     * 
     * @param minLength
     *            The value to perform the test with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public ArrayValidator testMinLength(final int minLength)
    {
        if (minLength < 0)
        {
            throw( new IllegalArgumentException("The parameter 'minLength' must be greater than zero (0)."));
        }
        else if ((minLength > this._maxLength) && (this._maxLength != -1))
        {
            throw( new IllegalArgumentException("The parameter 'minLength' must be less than the max length value."));
        }
        else
        {
            // have to test for null if empty is selected.
            this._isTestNotNull = true;
            this._isTestMinLength = true;
            this._minLength = minLength;
        }
        return (this);
    }
    
    /**
     * A method to mark that an "not null" test will be performed when the
     * validate() method is called.
     * 
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public ArrayValidator testNotNull()
    {
        this._isTestNotNull = true;
        return (this);
    }
    
    /**
     * A method to mark that an "not null or empty" test will be performed when
     * the validate() method is called.
     * 
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public ArrayValidator testNotNullEmpty()
    {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestNotEmpty = true;
        return (this);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.gabsocial.gabvalidate.Validator#validate()
     */
    public boolean validate()
    {
        boolean isTested = false;
        boolean isValid = true;
        
        if (this._isTestNotNull)
        {
            isTested = true;
            isValid &= (this._value != null);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
                BaseValidator
                        .throwValidateException("The String must not be null");
            }
        }
        
        if (this._isTestNotEmpty)
        {
            
            isTested = true;
            isValid &= (this._value != null && this._value.length > 0);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
                BaseValidator
                        .throwValidateException("The value must not be empty.");
            }
        }
        
        if (this._isTestMinLength)
        {
            isTested = true;
            isValid &= (this._value.length >= this._minLength);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
                BaseValidator
                        .throwValidateException("The value must be greater than or equal to the min value.");
//                                + " (value = '"
//                                + this._value
//                                + "' min value = '"
//                                + this._minLength + "').");
            }
            
        }
        
        if (this._isTestMaxLength)
        {
            isTested = true;
            isValid &= (this._value.length <= this._maxLength);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
                BaseValidator
                        .throwValidateException("The value must be less than or equal to the max value.");
//                                + " (value = '"
//                                + this._value
//                                + "' max value = '"
//                                + this._maxLength + "').");
            }
        }
        
        if (this._isTestEquals)
        {
            
            isTested = true;
            // test only if they are not the same object.
            if (this._value != this._equalsValue)
            {
                isValid &= Arrays.equals(this._value, this._equalsValue);
                
                if (this._isValidationExceptionThrownOnFail && !isValid)
                {
                    BaseValidator
                            .throwValidateException("The value does not equal the expected value.");
//                    (value = '"
//                                    + this._value
//                                    + "' expected value = '"
//                                    + this._equalsValue + "').");
                }
            }
        }
        
        if (!isTested)
        {
            isValid = false;
        }
        
        return (isValid);
        
    }
}
