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
public class ByteValidator extends NumberValidator<Byte>
{
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected ByteValidator(final byte value)
    {
        super( value, Byte.MIN_VALUE, Byte.MAX_VALUE);
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
