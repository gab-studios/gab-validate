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
 * Validate.defineObject(myObject).testNotNull().validate();
 *
 * If the throwValidationExceptionOnFail() method has been called and if the
 * validate fails then a ValidateException will be thrown.
 * 
 * Validate.defineObject(myObject).testEquals(expectedObject).throwValidationExceptionOnFail().validate();
 *
 * If no test method is called, validate() returns a false.
 *
 * @author Gregory Brown (sysdevone)
 * 
 * @param <C> An object class such as String, Boolean, Character, Short, Integer, etc.
 *
 */
public class ObjectValidator<C> implements Validator
{
	
    /*
     * A flag indicating if an exception should be thrown if the validate fails.
     */
    protected boolean _isValidationExceptionThrownOnFail = false;

	/*
	 * The value to use if the testEquals(boolean) method has been called.
	 */
	protected C _equalsValue;

	/*
	 * A flag indicating if an "equals" test will be performed when the validate()
	 * method is called.
	 */
	protected boolean _isTestEquals = false;

	/*
	 * A flag indicating if an "not null" test will be performed when the validate()
	 * method is called.
	 */
	protected boolean _isTestNotNull = false;
	
	/*
	 * A flag to indicate if a test was flagged during validation.
	 */
	protected boolean _isTested = false;

	/*
	 * The value that will be tested.
	 */
	protected final C _value;

	/**
	 * Protected constructor. Use Validate static method to create validator.
	 *
	 * @param value
	 *            The value that will be validated.
	 */
	protected ObjectValidator(final C value) {
		this._value = value;
	}

	/**
	 * Gets the value that was used to initialize this validator.
	 *
	 * @return An Object value.
	 */
	public C getValue() {
		return (this._value);
	}

	/**
	 * A method to mark that an "equals" test will be performed when the validate()
	 * method is called.
	 *
	 * @param value
	 *            The value to perform the equate with.
	 * @return The same BooleanValidator instance. This allows for method chaining.
	 */
	public ObjectValidator<C> testEquals(final C value) {
		this._isTestNotNull = true;
		this._isTestEquals = true;
		this._equalsValue = value;
		return (this);
	}

	/**
	 * A method to mark that an "not null" test will be performed when the
	 * validate() method is called.
	 *
	 * @return The same StringValidator instance. This allows for method chaining.
	 */
	public ObjectValidator<C> testNotNull() {
		this._isTestNotNull = true;
		return (this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gabsocial.gabvalidate.Validator#validate()
	 */
	public boolean validate() {
		boolean isValid = this.validate( false );
		return (isValid);
	}
	
	protected boolean notNullValue()
	{
		return( this._value != null );
	}

	protected boolean equalsValue()
	{
		return( this._value != null && this._value.equals(this._equalsValue) );
	}
	
	/*
	 * 
	 */
	protected boolean validate(boolean isInhertited) 
	{
		boolean isValid = true;

        if (this._isTestNotNull)
        {
        		this._isTested = true;
            isValid &= notNullValue();
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The value must not be null");
            }
        }
        
        if (this._isTestEquals)
        {
        		this._isTested = true;
            isValid &= equalsValue();
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The value does not equal the expected value (value = '"
                                + this._value
                                + "' expected value = '"
                                + this._equalsValue + "').");
            }
        }

		if (!isInhertited && !this._isTested) {
			isValid = false;
		}
		
		return (isValid);
	}
    
    /*
     * Forces an ValidateException to be thrown.
     * 
     * @param errorMessage The error message to include in an exception if it is
     * created.
     */
    protected static void throwValidateException(
            final String errorMessage)
    {
        assert (errorMessage != null) : "The parameter 'errorMessage' is NULL.";
        assert (errorMessage.length() > 0) : "The parameter 'errorMessage' must not be empty.";
        
        throw (new ValidateException(errorMessage));
    }
    
    /**
     * A method to mark that an IllegalArgumentException should be thrown if the
     * validate method returns false.
     * @param <T> A type of validator.
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    @SuppressWarnings({ "hiding", "unchecked" })
	@Override
    public <T extends Validator> T throwValidationExceptionOnFail()
    {
        this._isValidationExceptionThrownOnFail = true;
        return ((T)this);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"ObjectValidator [_isValidationExceptionThrownOnFail=%s, _equalsValue=%s, _isTestEquals=%s, _isTestNotNull=%s, _isTested=%s, _value=%s]",
				_isValidationExceptionThrownOnFail, _equalsValue, _isTestEquals, _isTestNotNull, _isTested, _value);
	}



    
}
