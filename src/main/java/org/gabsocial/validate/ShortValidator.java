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
 * This is a short validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 *      Validate.defineShort(short).testNotNull().validate();
 *
 * If the throwExceptionOnFailedValidation() method has been called and if the validate fails
 * then a ValidateException will be thrown.
 * 
 *      Validate.defineShort(short).testEquals(short)
 *          .throwExceptionOnFailedValidation().validate();
 *
 * If no test method is called, validate() returns a false.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ShortValidator extends BaseValidator<ShortValidator>
{
    /*
     * The value to use if the testEquals(boolean) method has been called.
     */
    private short       _equalsValue              = 0;
    
    /*
     * A flag indicating if an "equals" test will be performed when the
     * validate() method is called.
     */
    private boolean     _isTestEquals             = false;
    
    /*
     * A flag indicating that a max value test will be performed when the
     * validate() method is called.
     */
    private boolean     _isTestMaxValue           = false;
    
    /*
     * A flag indicating that a min value test will be performed when the
     * validate() method is called.
     */
    private boolean     _isTestMinValue           = false;
    
    /*
     * The max value to test for. Defaults to Long.MAX_VALUE.
     */
    private short       _maxValue                 = Short.MAX_VALUE;
    
    /*
     * The min value to test for. Defaults to Long.MIN_VALUE.
     */
    private short       _minValue                 = Short.MIN_VALUE;
    
    /*
     * The value that will be tested.
     */
    private final short _value;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected ShortValidator(final short value)
    {
        this._value = value;
    }
    
    /**
     * Gets the value that was used to initialize this validator.
     * 
     * @return A short value.
     */
    public short getValue()
    {
        return (this._value);
    }
    
    /**
     * A method to mark that an "equals" test will be performed when the
     * validate() method is called.
     * 
     * @param value
     *            The value to perform the equate with.
     * @return The same ShortValidator instance. This allows for method
     *         chaining.
     */
    public ShortValidator testEquals(final short value)
    {
        this._isTestEquals = true;
        this._equalsValue = value;
        return (this);
    }
    
    /**
     * A method to mark that an "max value" test will be performed when the
     * validate() method is called. Tests if the value is less than or equal to
     * the max value when the validate method is called.
     * 
     * @param maxValue
     *            The value to perform the test with.
     * @return The same ShortValidator instance. This allows for method
     *         chaining.
     */
    public ShortValidator testMaxValue(final short maxValue)
    {
        this._isTestMaxValue = true;
        this._maxValue = maxValue;
        return (this);
    }
    
    /**
     * A method to mark that an "min value" test will be performed when the
     * validate() method is called. Tests if the value is greater than or equal
     * to the min value when the validate method is called.
     * 
     * @param minValue
     *            The value to perform the test with.
     * @return The same ShortValidator instance. This allows for method
     *         chaining.
     */
    public ShortValidator testMinValue(final short minValue)
    {
        this._isTestMinValue = true;
        this._minValue = minValue;
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
        
        if (this._isTestEquals)
        {
            isTested = true;
            isValid &= this._value == this._equalsValue;
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                .throwValidateException("The value does not equal the expected value (value = '"
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
                .throwValidateException("The value must be greater than or equal to the min value (value = '"
                        + this._value
                        + "' min value = '"
                        + this._minValue
                        + "').");
            }
            
        }
        
        if (this._isTestMaxValue)
        {
            isTested = true;
            isValid &= (this._value <= this._maxValue);
            if (this._isTestThrowOnNotValidate && !isValid)
            {
                BaseValidator
                .throwValidateException("The value must be less than or equal to the max value (value = '"
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
