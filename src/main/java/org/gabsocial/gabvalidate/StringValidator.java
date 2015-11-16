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

package org.gabsocial.gabvalidate;

import java.util.regex.Pattern;


/**
 * This is a String validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 *
 * If the throwOnNotValidate() method has been called and if the validate fails
 * then Fan ValidateException will be thrown.
 *
 * If no test method is called, validate() returns a false.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class StringValidator extends BaseValidator<StringValidator>
{
    /*
     * The value to use if the testEquals(boolean) method has been called.
     */
    private String       _equalsValue;
    
    /*
     * The value to use if the testMatch(String) method has been called.
     */
    private String       _matchValue;
    
    /*
     * A flag indicating if an "equals" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestEquals             = false;
    
    /*
     * A flag indicating if an "equals no case" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestEqualsNoCase       = false;
    
    /*
     * A flag indicating that a max length test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestMaxLength          = false;
    
    /*
     * A flag indicating that a min length test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestMinLength          = false;
    
    /*
     * A flag indicating if an "not empty" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestNotEmpty           = false;
    
    /*
     * A flag indicating if an "not null" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestNotNull            = false;
    
    /*
     * A flag indicating if an exception should be thrown if the validate fails.
     */
    private boolean      _isTestThrowOnNotValidate = false;
    
    /*
     * A flag inicating if a "match" will be performed using regrex expressions
     * when the validate() method is called.
     */
    private boolean      _isTestMatch              = false;
    
    /*
     * The max length to test for. Defaults to -1.
     */
    private int          _maxLength                = -1;
    
    /*
     * The min length to test for. Defaults to -1.
     */
    private int          _minLength                = -1;
    
    /*
     * The String that will be tested.
     */
    private final String _value;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated. This value can be null or
     *            empty.
     */
    protected StringValidator(final String value)
    {
        this._value = value;
    }
    
    /**
     * Gets the value that was used to initialize this validator.
     * 
     * @return A String value.
     */
    public String getValue()
    {
        return (this._value);
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
    public StringValidator testEquals(final String equalsValue)
    {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestEquals = true;
        this._isTestEqualsNoCase = false;
        this._equalsValue = equalsValue;
        return (this);
    }
    
    /**
     * A method to mark that an "equals no case" test will be performed when the
     * validate() method is called.
     * 
     * @param value
     *            The value to perform the equate with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator testEqualsNoCase(final String value)
    {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestEqualsNoCase = true;
        this._isTestEquals = false;
        this._equalsValue = value;
        return (this);
    }
    
    /**
     * A method to mark that an "match" test using regex will be performed when
     * the validate() method is called.
     * 
     * @param value
     *            A regular expression that be used to see if the String value
     *            is a match.
     * 
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator testMatch(String value)
    {
        // have to test for null if match is selected.
        this._isTestNotNull = true;
        this._isTestMatch = true;
        this._matchValue = value;
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
    public StringValidator testMaxLength(final int maxLength)
    {
        if (maxLength < 0)
        {
            BaseValidator
                    .throwIllegalArgumentException("The parameter 'maxLength' must be greater than zero (0).");
        }
        else if (maxLength < this._minLength)
        {
            BaseValidator
                    .throwIllegalArgumentException("The parameter 'maxLength' must be greater than the min length value.");
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
    public StringValidator testMinLength(final int minLength)
    {
        if (minLength < 0)
        {
            BaseValidator
                    .throwIllegalArgumentException("The parameter 'minLength' must be greater than zero (0).");
        }
        else if ((minLength > this._maxLength) && (this._maxLength != -1))
        {
            BaseValidator
                    .throwIllegalArgumentException("The parameter 'minLength' must be less than the max length value.");
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
    public StringValidator testNotNull()
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
    public StringValidator testNotNullEmpty()
    {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestNotEmpty = true;
        return (this);
    }
    
    /**
     * A method to mark that an IllegalArgumentException should be thrown if the
     * validate method returns false.
     *
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator throwExceptionOnFailedValidation()
    {
        this._isTestThrowOnNotValidate = true;
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
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The String must not be null");
            }
        }
        
        if (this._isTestNotEmpty)
        {
            
            isTested = true;
            isValid &= this._value.length() > 0;
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value must not be empty.");
            }
        }
        
        if (this._isTestEqualsNoCase)
        {
            isTested = true;
            isValid &= this._value.equalsIgnoreCase(this._equalsValue);
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The String does not equal the expected value (string value = '"
                                + this._value
                                + "' expected value = '"
                                + this._equalsValue + "').");
            }
        }
        
        if (this._isTestEquals)
        {
            isTested = true;
            isValid &= this._value == this._equalsValue;
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value does not equal the expected value (value = '"
                                + this._value
                                + "' expected value = '"
                                + this._equalsValue + "').");
            }
        }
        
        if (this._isTestMinLength)
        {
            isTested = true;
            isValid &= (this._value.length() >= this._minLength);
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value must be greater than or equal to the min value (value = '"
                                + this._value
                                + "' min value = '"
                                + this._minLength + "').");
            }
            
        }
        
        if (this._isTestMaxLength)
        {
            isTested = true;
            isValid &= (this._value.length() <= this._maxLength);
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value must be less than or equal to the max value (value = '"
                                + this._value
                                + "' max value = '"
                                + this._maxLength + "').");
            }
        }
        
        if (this._isTestMatch)
        {
            isTested = true;
            isValid &= (Pattern.matches(this._matchValue, this._value));
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value does not match the reqular expression (value = '"
                                + this._value
                                + "' regex = '"
                                + this._matchValue + "').");
            }
        }
        
        if (!isTested)
        {
            isValid = false;
        }
        
        return (isValid);
        
    }
}
