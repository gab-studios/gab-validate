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

package com.gabstudios.validate;

/**
 * This is a char validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 *      Validate.defineChar(char).testNotNull().validate();
 *
 * If the throwValidationExceptionOnFail() method has been called and if the validate fails
 * then a ValidateException will be thrown.
 * 
 *      Validate.defineChar(char).testEquals(char)
 *          .throwValidationExceptionOnFail().validate();
 *
 * If no test method is called, validate() returns a false.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class CharValidator extends ObjectValidator<Character>
{
    
    /*
     * A flag indicating if an "is the character a digit/number" test will be
     * performed when the validate() method is called.
     */
    private boolean    _testIsDigit      = false;
    
    /*
     * A flag indicating if an "is the character lower case" test will be
     * performed when the validate() method is called.
     */
    private boolean    _testIsLowerCase  = false;
    
    /*
     * A flag indicating that a max value test will be performed when the
     * validate() method is called.
     */
    private boolean    _isTestMaxValue   = false;
    
    /*
     * A flag indicating that a min value test will be performed when the
     * validate() method is called.
     */
    private boolean    _isTestMinValue   = false;
    
    /*
     * A flag indicating if an "not empty" test will be performed when the
     * validate() method is called.
     */
    private boolean    _isTestNotEmpty   = false;
    
    /*
     * A flag indicating if an "is the character upper case" test will be
     * performed when the validate() method is called.
     */
    private boolean    _testIsUpperCase  = false;
    
    /*
     * A flag indicating if an "is the character a white space" test will be
     * performed when the validate() method is called.
     */
    private boolean    _testIsWhitespace = false;
    
    /*
     * The max value to test for. Defaults to Character.MAX_VALUE.
     */
    private char       _maxValue         = Character.MAX_VALUE;
    
    /*
     * The min value to test for. Defaults to Character.MIN_VALUE.
     */
    private char       _minValue         = Character.MIN_VALUE;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected CharValidator(final char value)
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
     * A method to mark that an "not empty" test will be performed when the
     * validate() method is called.
     *
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator testNotEmpty()
    {
        this._isTestNotEmpty = true;
        return (this);
    }
    
    /**
     * A method to mark if an "is the character a digit/number" test will be
     * performed when the validate() method is called.
     *
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator testIsDigit()
    {
        this._testIsDigit = true;
        return (this);
    }
    
    /**
     * A method to mark if an "is the character lower case" test will be
     * performed when the validate() method is called. Calling this method will
     * de-active the isUpperCase test.
     *
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator testIsLowerCase()
    {
        this._testIsLowerCase = true;
        this._testIsUpperCase = false;
        return (this);
    }
    
    /**
     * A method to mark if an "is the character upper case" test will be
     * performed when the validate() method is called. Calling this method will
     * de-active the isLowerCase test.
     *
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator testIsUpperCase()
    {
        this._testIsUpperCase = true;
        this._testIsLowerCase = false;
        return (this);
    }
    
    /**
     * A method to mark if an "is the character a whitecase" test will be
     * performed when the validate() method is called. Calling this method will
     * de-active the isLowerCase test.
     *
     * @return The same CharValidator instance. This allows for method chaining.
     */
    public CharValidator testIsWhitespace()
    {
        this._testIsWhitespace = true;
        return (this);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.gabstudios.gabvalidate.Validator#validate()
     */
    @Override
    public boolean validate()
    {
    	
		// call ObjectValidator validate method.
        boolean isValid = super.validate(true);
        
        if (this._isTestNotEmpty)
        {
			this._isTested = true;
            isValid &= this._value != '\0';
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The char must not be empty.");
            }
        }
        
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
                                + this._minValue + "').");
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
                                + this._maxValue + "').");
            }
        }
        
        if (this._testIsDigit)
        {
			this._isTested = true;
            isValid &= (Character.isDigit(this._value));
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The char is not a digit (value = '"
                                + this._value + "').");
            }
        }
        
        if (this._testIsLowerCase)
        {
			this._isTested = true;
            isValid &= (Character.isLowerCase(this._value));
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The char is not lower case (value = '"
                                + this._value + "').");
            }
        }
        
        if (this._testIsUpperCase)
        {
			this._isTested = true;
            isValid &= (Character.isUpperCase(this._value));
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The char is not upper case (value = '"
                                + this._value + "').");
            }
        }
        
        if (this._testIsWhitespace)
        {
			this._isTested = true;
            isValid &= (Character.isWhitespace(this._value));
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The char is not a whitespace (value = '"
                                + this._value + "').");
            }
        }
        
        if (!this._isTested)
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
				"CharValidator [_testIsDigit=%s, _testIsLowerCase=%s, _isTestMaxValue=%s, _isTestMinValue=%s, _isTestNotEmpty=%s, _testIsUpperCase=%s, _testIsWhitespace=%s, _maxValue=%s, _minValue=%s, _isValidationExceptionThrownOnFail=%s, _equalsValue=%s, _isTestEquals=%s, _isTestNotNull=%s, _isTested=%s, _value=%s]",
				_testIsDigit, _testIsLowerCase, _isTestMaxValue, _isTestMinValue, _isTestNotEmpty, _testIsUpperCase,
				_testIsWhitespace, _maxValue, _minValue, _isValidationExceptionThrownOnFail, _equalsValue,
				_isTestEquals, _isTestNotNull, _isTested, _value);
	}
    
    
}
