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
 * Base validator that all validator extend from.
 * 
 * @author Gregory Brown (sysdevone)
 *
 */
public abstract class BaseValidator<T> implements Validator<T>
{
    
    /*
     * A flag indicating if an exception should be thrown if the validate fails.
     */
    protected boolean _isTestThrowOnNotValidate = false;
    
    /*
     * Forces an ValidateException to be thrown.
     * 
     * @param errorMessage The error message to include in an exception if it is
     * created.
     */
    protected static void throwIllegalArgumentException(
            final String errorMessage)
    {
        assert (errorMessage != null) : "The parameter 'errorMessage' is NULL.";
        assert (errorMessage.length() > 0) : "The parameter 'errorMessage' must not be empty.";
        
        throw (new ValidateException(errorMessage));
    }
    
    /**
     * A method to mark that an IllegalArgumentException should be thrown if the
     * validate method returns false.
     *
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    @Override
    public T throwExceptionOnFailedValidation()
    {
        this._isTestThrowOnNotValidate = true;
        return ((T)this);
    }
    
}
