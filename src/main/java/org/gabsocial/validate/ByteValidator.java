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
 * This is a byte validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 *      Validate.defineByte(byte).testNotNull().validate();
 *
 * If the throwValidationExceptionOnFail() method has been called and if the validate fails
 * then a ValidateException will be thrown.
 * 
 *      Validate.defineByte(byte).testEquals(expectedByte)
 *          .throwValidationExceptionOnFail().validate();
 *
 * If no test method is called, validate() returns a false.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ByteValidator extends ObjectValidator<Byte>
{
    
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
     * The max value to test for. Defaults to Byte.MAX_VALUE.
     */
    private byte       _maxValue                 = Byte.MAX_VALUE;

    /*
     * The min value to test for. Defaults to Byte.MIN_VALUE.
     */
    private byte       _minValue                 = Byte.MIN_VALUE;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected ByteValidator(final byte value)
    {
        super( value );
    }
    
    /**
     * A method to mark that a max value test will be performed when the
     * validate() method is called. The value must be less than or equal to the
     * maxValue.
     *
     * @param maxValue
     *            The max value to compare to.
     *
     * @return The same ByteValidator instance. This allows for method chaining.
     */
    public ByteValidator testMaxValue(final byte maxValue)
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
    public ByteValidator testMinValue(final byte minValue)
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
    	
		// call ObjectValidator validate method.
        boolean isValid = super.validate(true);
                
        if (this._isTestMinValue)
        {
			this._isTested = true;
            isValid &= (this._value >= this._minValue);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                .throwValidateException("The value must be greater than or equal to the min value (value = '"
                        + this._value
                        + "' min value = '"
                        + this._minValue
                        + "').");
            }
            
        }
        
        if (this._isTestMaxValue)
        {
			this._isTested = true;
            isValid &= (this._value <= this._maxValue);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                .throwValidateException("The value must be less than or equal to the max value (value = '"
                        + this._value
                        + "' max value = '"
                        + this._maxValue
                        + "').");
            }
        }
        
        if( !this._isTested )
        {
            isValid = false;
        }
       
        return (isValid);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"ByteValidator [_isTestMaxValue=%s, _isTestMinValue=%s, _maxValue=%s, _minValue=%s, _isValidationExceptionThrownOnFail=%s, _equalsValue=%s, _isTestEquals=%s, _isTestNotNull=%s, _isTested=%s, _value=%s]",
				_isTestMaxValue, _isTestMinValue, _maxValue, _minValue, _isValidationExceptionThrownOnFail,
				_equalsValue, _isTestEquals, _isTestNotNull, _isTested, _value);
	}
    
    
}
