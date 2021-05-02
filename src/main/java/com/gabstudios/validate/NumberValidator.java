/*****************************************************************************************
 *
 * Copyright 2018 Gregory Brown. All Rights Reserved.
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

package com.gabstudios.validate;

/**
 * This is an abstract Number validator. It is used to add number based
 * validators.
 *
 * @author Gregory Brown (sysdevone)
 * 
 * @param <C>
 *            An object class such as String, Boolean, Character, Short,
 *            Integer, etc.
 *
 */
public abstract class NumberValidator<C extends Number> extends ObjectValidator<C> {

	/*
	 * A flag indicating that a max value test will be performed when the validate()
	 * method is called.
	 */
	protected boolean _isTestMaxValue = false;

	/*
	 * A flag indicating that a min value test will be performed when the validate()
	 * method is called.
	 */
	protected boolean _isTestMinValue = false;

	/*
	 * The max value to test for. Defaults to Float.MAX_VALUE.
	 */
	protected C _maxValue;

	/*
	 * The min value to test for. Defaults to Float.MIN_VALUE.
	 */
	protected C _minValue;

	/**
	 * Protected constructor. Use Validate static method to create validator.
	 *
	 * @param value
	 *            The value that will be validated.
	 * @param minValue
	 *            The min value to use in tests.
	 * @param maxValue
	 *            The max value to use in tests.
	 */
	protected NumberValidator(final C value, final C minValue, final C maxValue) {
		super(value);
		this._minValue = minValue;
		this._maxValue = maxValue;
	}

	/**
	 * A method to mark that an "max value" test will be performed when the
	 * validate() method is called. Tests if the value is less than or equal to the
	 * max value when the validate method is called.
	 * 
	 * @param maxValue
	 *            The value to perform the test with.
	 * @return The same FloatValidator instance. This allows for method chaining.
	 */
	public NumberValidator<C> testMaxValue(final C maxValue) {
		this._isTestMaxValue = true;
		this._maxValue = maxValue;
		return (this);
	}

	/**
	 * A method to mark that an "min value" test will be performed when the
	 * validate() method is called. Tests if the value is greater than or equal to
	 * the min value when the validate method is called.
	 * 
	 * @param minValue
	 *            The value to perform the test with.
	 * @return The same FloatValidator instance. This allows for method chaining.
	 */
	public NumberValidator<C> testMinValue(final C minValue) {
		this._isTestMinValue = true;
		this._minValue = minValue;
		return (this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gabstudios.gabvalidate.Validator#validate()
	 */
	protected boolean validate(boolean isInhertited) {

		// call ObjectValidator validate method.
		boolean isValid = super.validate(true);
		// System.out.println( "Super.validate: " + isValid);
		if (this._isTestMinValue) {
			this._isTested = true;
			isValid &= (((Comparable) this._value).compareTo((Comparable) this._minValue) >= 0);
			if (this._isValidationExceptionThrownOnFail && !isValid) {
				ObjectValidator
						.throwValidateException("The value must be greater than or equal to the min value (value = '"
								+ this._value + "' min value = '" + this._minValue + "').");
			}

		}

		if (this._isTestMaxValue) {
			this._isTested = true;
			isValid &= (((Comparable) this._value).compareTo((Comparable) this._maxValue) <= 0);
			if (this._isValidationExceptionThrownOnFail && !isValid) {
				ObjectValidator
						.throwValidateException("The value must be less than or equal to the max value (value = '"
								+ this._value + "' max value = '" + this._maxValue + "').");
			}
		}

		if (!isInhertited && !this._isTested) {
			isValid = false;
		}

		return (isValid);
	}
}
