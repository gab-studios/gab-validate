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

/**
 * This is a Object validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 *      Validate.defineObject(myObject).testNotNull().validate();
 *
 * If the throwExceptionOnFailedValidation() method has been called and if the validate fails
 * then a ValidateException will be thrown.
 * 
 *      Validate.defineObject(myObject).testEquals(expectedObject).throwExceptionOnFailedValidation().validate();
 *
 * If no test method is called, validate() returns a false.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ObjectValidator extends BaseValidator<ObjectValidator>
{
    
    /*
     * The value to use if the testEquals(boolean) method has been called.
     */
    private Object       _equalsValue;
    
    /*
     * A flag indicating if an "equals" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestEquals             = false;
    
    /*
     * A flag indicating if an "not null" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestNotNull            = false;
    
    /*
     * The value that will be tested.
     */
    private final Object _value;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected ObjectValidator(final Object value)
    {
        this._value = value;
    }
    
    /**
     * Gets the value that was used to initialize this validator.
     *
     * @return An Object value.
     */
    public Object getValue()
    {
        return (this._value);
    }
    
    /**
     * A method to mark that an "equals" test will be performed when the
     * validate() method is called.
     *
     * @param value
     *            The value to perform the equate with.
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    public ObjectValidator testEquals(final Object value)
    {
        this._isTestNotNull = true;
        this._isTestEquals = true;
        this._equalsValue = value;
        return (this);
    }
    
    /**
     * A method to mark that an "not null" test will be performed when the
     * validate() method is called.
     *
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public ObjectValidator testNotNull()
    {
        this._isTestNotNull = true;
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
        
        if (this._isTestEquals)
        {
            isTested = true;
            isValid &= this._value == this._equalsValue;
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
                BaseValidator
                        .throwValidateException("The value does not equal the expected value (value = '"
                                + this._value
                                + "' expected value = '"
                                + this._equalsValue + "').");
            }
        }
        
        if (!isTested)
        {
            isValid = false;
        }
        
        return (isValid);
    }
    
}
