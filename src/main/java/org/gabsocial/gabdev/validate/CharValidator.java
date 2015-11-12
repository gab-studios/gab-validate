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
 * This is a char validator. After this class is created, call the testXXXX()
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
public class CharValidator extends BaseValidator
{
    
    /*
     * The value to use if the testEquals(boolean) method has been called.
     */
    private char       _equalsValue;
    
    /*
     * A flag indicating if an "equals" test will be performed when the
     * validate() method is called.
     */
    private boolean    _isTestEquals             = false;
    
    /*
     * A flag indicating that a max value test will be performed when the
     * validate() method is called.
     */
    private boolean    _isTestMaxValue           = false;
    
    /*
     * A flag indicating that a min value test will be performed when the
     * validate() method is called.
     */
    private boolean    _isTestMinValue           = false;
    
    /*
     * A flag indicating if an "not empty" test will be performed when the
     * validate() method is called.
     */
    private boolean    _isTestNotEmpty           = false;
    
    /*
     * A flag indicating if an exception should be thrown if the validate fails.
     */
    private boolean    _isTestThrowOnNotValidate = false;
    
    /*
     * The max value to test for. Defaults to Character.MAX_VALUE.
     */
    private char       _maxValue                 = Character.MAX_VALUE;
    
    /*
     * The min value to test for. Defaults to Character.MIN_VALUE.
     */
    private char       _minValue                 = Character.MIN_VALUE;
    
    /*
     * The value that will be tested.
     */
    private final char _value;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected CharValidator(final char value)
    {
        this._value = value;
    }
    
    /**
     * Gets the value that was used to initialize this validator.
     * 
     * @return A char value.
     */
    public char getValue()
    {
        return (this._value);
    }
    
    /**
     * A method to mark that an "equals" test will be performed when the
     * validate() method is called.
     * 
     * @param value
     *            The value to perform the equate with.
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator testEquals(final char value)
    {
        this._isTestEquals = true;
        this._equalsValue = value;
        return (this);
    }
    
    /**
     * A method to mark that a max value test will be performed when the
     * validate() method is called. The value must be less than or equal to the
     * maxValue.
     *
     * @param maxValue
     *            The max value to compare to.
     *
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator testMaxValue(final char maxValue)
    {
        this._isTestMaxValue = true;
        this._maxValue = maxValue;
        return (this);
    }
    
    /**
     * A method to mark that a min value test will be performed when the
     * validate() method is called. The value must be less than or equal to the
     * minValue.
     *
     * @param minValue
     *            The min value to compare to.
     *
     * @return The same ByteValidator instance. This allows for method chaining.
     */
    public CharValidator testMinValue(final char minValue)
    {
        this._isTestMinValue = true;
        this._minValue = minValue;
        return (this);
    }
    
    /**
     * A method to mark that an "not empty" test will be performed when
     * the validate() method is called.
     * 
     * @return The same CharValidator instance. This allows for method
     *         chaining.
     */
    public CharValidator testNotEmpty()
    {
        this._isTestNotEmpty = true;
        return (this);
    }
    
    /**
     * A method to mark that an IllegalArgumentException should be thrown if the
     * validate method returns false.
     *
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator throwOnNotValidate()
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
        
        if (this._isTestNotEmpty)
        {
            
            
            isValid &= this._value != '\0';
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                        .throwIllegalArgumentException("The value must not be empty.");
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
                
        if (this._isTestMinValue)
        {
            isTested = true;
            isValid &= (this._value >= this._minValue);
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                .throwIllegalArgumentException("The value must be greater than or equal to the min value (value = '"
                        + this._value
                        + "' min value = '"
                        + this._minValue
                        + "').");
            }
            
        }
        
        if (this._isTestMaxValue)
        {
            isTested = true;
            isValid |= (this._value <= this._maxValue);
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                .throwIllegalArgumentException("The value must be less than or equal to the max value (value = '"
                        + this._value
                        + "' max value = '"
                        + this._maxValue
                        + "').");
            }
        }
        
        if( !isTested )
        {
            isValid = false;
        }
       
        return (isValid);
        
    }
}