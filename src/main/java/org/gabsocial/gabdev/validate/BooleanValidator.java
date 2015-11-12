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

package org.gabsocial.gabdev.validate;

/**
 * This is a boolean validator. After this class is created, call the testXXXX()
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
public class BooleanValidator extends BaseValidator
{
    
    /*
     * The value to use if the testEquals(boolean) method has been called.
     */
    private boolean       _equalsValue;
    
    /*
     * A flag indicating if an "equals" test will be performed when the
     * validate() method is called.
     */
    private boolean       _isTestEquals             = false;
    
    /*
     * A flag indicating if a "false" test will be performed when the validate()
     * method is called.
     */
    private boolean       _isTestFalse              = false;
    
    /*
     * A flag indicating if a "true" test will be performed when the validate()
     * method is called.
     */
    private boolean       _isTestTrue               = false;
    
    /*
     * A flag indicating if an exception should be thrown if the validate fails.
     */
    private boolean       _isTestThrowOnNotValidate = false;
    
    /*
     * The value that will be tested.
     */
    private final boolean _value;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected BooleanValidator(final boolean value)
    {
        this._value = value;
    }
    
    /**
     * Gets the value that was used to initialize this validator.
     * 
     * @return A boolean value.
     */
    public boolean getValue()
    {
        return (this._value);
    }
    
    /**
     * A method to mark that an "equals" test will be performed when the
     * validate() method is called.
     * 
     * @param equalsValue
     *            The value to perform the equate with.
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    public BooleanValidator testEquals(final boolean equalsValue)
    {
        this._isTestEquals = true;
        this._equalsValue = equalsValue;
        return (this);
    }
    
    /**
     * A method to mark that a "false" test will be performed when the
     * validate() method is called.
     *
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    public BooleanValidator testFalse()
    {
        this._isTestFalse = true;
        return (this);
    }
    
    /**
     * A method to mark that a "true" test will be performed when the validate()
     * method is called.
     *
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    public BooleanValidator testTrue()
    {
        this._isTestTrue = true;
        return (this);
    }
    
    /**
     * A method to mark that an IllegalArgumentException should be thrown if the
     * validate method returns false.
     *
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    public BooleanValidator throwOnNotValidate()
    {
        this._isTestThrowOnNotValidate = true;
        return (this);
    }
    
    /**
     * Performs a validation test based on the methods that were called.If the
     * method throwOnNotValidate has been called, then an
     * ValidateException will be thrown.
     * 
     * If no test method is called, this method returns a false.
     *
     * @return A boolean value that is true if the value is valid. Otherwise
     *         false is return.
     * @see throwOnNotValidate
     */
    public boolean validate()
    {
        boolean isTested = false;
        boolean isValid = true;
        
        if (this._isTestFalse)
        {
            isTested = true;
            isValid &= this._value == Boolean.FALSE;
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value is not false. (value = '"
                                + this._value + "').");
            }
        }
        
        if (this._isTestTrue)
        {
            isTested = true;
            isValid &= this._value == Boolean.TRUE;
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value is not true. (value = '"
                                + this._value + "').");
            }
        }
        
        if (this._isTestEquals)
        {
            isTested = true;
            isValid &= (this._value == this._equalsValue);
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value does not equal the expected value (value = '"
                                + this._value
                                + "' expected value = '"
                                + this._equalsValue + "').");
            }
            
        }
        
        if( !isTested )
        {
            isValid = false;
        }
        
        return (isValid);
    }
    
}
