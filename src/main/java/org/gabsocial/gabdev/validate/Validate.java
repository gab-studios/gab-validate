/*****************************************************************************************
 * 
 * Copyright 2014 Gregory Brown. All Rights Reserved.
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
 * 
 * A class to help validate parameters for development.
 * 
 * @author Gregory Brown (sysdevone)
 */
public class Validate
{
    
    /**
     * Tests if a parameter is not null. If null then an
     * <code>IllegalArgumentException</code> is thrown.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param param
     *            The parameter to verify.
     * @param <T>
     *            The runtime class type of the parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is null.
     */
    public static <T> void isNotNull(final Class<?> clazz, final T param)
            throws IllegalArgumentException
    {
        
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else if (param == null)
        {
            Validate.throwIllegalArgumentException(
                    "The parameter must not be null or empty.", clazz,
                    "isNotNull()");
        }
        
    }
    
    /**
     * Tests if a parameter is a boolean true value. If false then an
     * <code>IllegalArgumentException</code> is thrown.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param expression
     *            The expression to test.
     * 
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is null.
     */
    public static void isTrue(final Class<?> clazz, boolean expression)
            throws IllegalArgumentException
    {
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else if (!expression)
        {
            Validate.throwIllegalArgumentException(
                    "The parameter is not true.", clazz, "isTrue()");
        }
    }
    
    /**
     * Tests if a parameter is not null or empty.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param params
     *            The parameters to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is null or empty.
     */
    public static void isNotNullOrEmpty(final Class<?> clazz,
            final String... params) throws IllegalArgumentException
    {
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else if ((params == null) || (params.length == 0))
        {
            Validate.throwIllegalArgumentException(
                    "The parameter must not be null or empty.", clazz,
                    "isNotNullOrEmpty()");
        }
        else if (params.length > 0)
        {
            for (String param : params)
            {
                if (param == null || param.length() == 0)
                {
                    Validate.throwIllegalArgumentException(
                            "The parameter must not be null or empty.", clazz,
                            "isNotNullOrEmpty()");
                }
            }
        }
        
    }
    
    /**
     * Tests if a parameter is not null or empty.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param maxLength
     *            The error message to include in an exception if it is created.
     * @param params
     *            The parameters to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is null or empty.
     */
    public static void isLessThanMaxLength(final Class<?> clazz,
            final int maxLength, final String... params)
            throws IllegalArgumentException
    {
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else if ((maxLength < 0))
        {
            throw (new IllegalArgumentException(
                    "The parameter 'maxLength' must not be less than zero."));
        }
        else if ((params == null) || (params.length == 0))
        {
            Validate.throwIllegalArgumentException(
                    "The parameter must not be null or empty.", clazz,
                    "isLessThanMaxLength()");
        }
        else if (params.length > 0)
        {
            for (String param : params)
            {
                if (param == null)
                {
                    Validate.throwIllegalArgumentException(
                            "The parameter must not be null or empty.", clazz,
                            "isLessThanMaxLength()");
                }
                else if (param.length() > maxLength)
                {
                    Validate.throwIllegalArgumentException(
                            "The parameters length must be less than the maxlength.",
                            clazz, "isLessThanMaxLength()");
                }
            }
            
        }
    }
    
    /**
     * Tests if a parameter length is between or equal to the minimum and
     * maximum values.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param minLength
     *            The minimum length of the parameters allowed. Must not be greater than maxLength.
     * @param maxLength
     *            The maximum length of the parameters allowed. Must not be less than minLength.
     * @param params
     *            The parameters to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is null or empty.
     */
    public static void isMinMaxLength(final Class<?> clazz,
            final int minLength, final int maxLength, final String... params)
            throws IllegalArgumentException
    {
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else if ((minLength < 0))
        {
            throw (new IllegalArgumentException(
                    "The parameter 'minLength' must not be less than zero (minLength="
                            + minLength + ")"));
        }
        else if ((maxLength < 0))
        {
            throw (new IllegalArgumentException(
                    "The parameter 'maxLength' must not be less than zero (maxLength="
                            + maxLength + ")"));
        }
        else if ((maxLength < minLength))
        {
            throw (new IllegalArgumentException(
                    "The parameter 'maxLength' must not be less than the min length (maxLength="
                            + maxLength + ", minLength=" + minLength + ")"));
        }
        else if ((maxLength == minLength))
        {
            throw (new IllegalArgumentException(
                    "The parameter 'minLength' and 'maxLength' should not be the same value (maxLength="
                            + maxLength + ", minLength=" + minLength + ")"));
        }
        else if ((params == null) || (params.length == 0))
        {
            Validate.throwIllegalArgumentException(
                    "The parameter must not be null or empty.", clazz,
                    "isMinMaxLength()");
        }
        else if (params.length > 0)
        {
            for (String param : params)
            {
                if (param == null)
                {
                    Validate.throwIllegalArgumentException(
                            "The parameter must not be null or empty.", clazz,
                            "isMinMaxLength()");
                }
                else if (param.length() < minLength)
                {
                    Validate.throwIllegalArgumentException(
                            "The parameter length must not be less than or equal to the minLength (length="
                                    + param.length() + ", minLength="
                                    + minLength + ")",
                            
                            clazz, "isMinMaxLength()");
                }
                else if (param.length() > maxLength)
                {
                    Validate.throwIllegalArgumentException(
                            "The parameter length must not be greater than the maxLength.(length="
                                    + param.length() + ", maxLength="
                                    + maxLength + ")", clazz,
                            "isMinMaxLength()");
                }
                
            }
            
            // todo throw a single exception that lists all of the parameters
            // that fail this test.
        }
    }
    
    /**
     * Tests if the char param is not empty. If it is then an exception is
     * thrown.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param param
     *            A char parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the paramter is empty.
     */
    public static void isCharNotEmpty(final Class<?> clazz, final char param)
            throws IllegalArgumentException
    {
        
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else if (param == '\0')
        {
            Validate.throwIllegalArgumentException(
                    "The parameter char must not be empty.", clazz,
                    "isCharNotEmpty()");
        }
    }
    
    /**
     * Tests if a param is zero.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param param
     *            The parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is zero.
     */
    public static void isNotZero(final Class<?> clazz, final int param)
            throws IllegalArgumentException
    {
        
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else
        {
            if (param == 0)
            {
                Validate.throwIllegalArgumentException(
                        "The parameter must not be zero.", clazz, "isNotZero()");
            }
        }
        
    }
    
    /**
     * Tests if a param is greater than or equal to zero.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param param
     *            The parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is less than zero.
     */
    public static void isGreaterEqualZero(final Class<?> clazz, final int param)
            throws IllegalArgumentException
    {
        
        if (clazz == null)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'clazz' must not be null."));
        }
        else
        {
            if (param < 0)
            {
                Validate.throwIllegalArgumentException(
                        "The parameter must bet greater than or equal to zero.",
                        clazz, "isGreaterEqualZero()");
            }
        }
        
    }
    
    /*
     * Forces an IllegalArgumentException to be thrown.
     * 
     * @param errorMessage The error message to include in an exception if it is
     * created.
     * 
     * @param clazz The class throwing the exception.
     */
    private static void throwIllegalArgumentException(
            final String errorMessage, final Class<?> clazz, final String method)
    {
        assert (errorMessage != null) : "The parameter 'errorMessage' is NULL.";
        assert (errorMessage.length() > 0) : "The parameter 'errorMessage' must not be empty.";
        assert (clazz != null) : "The parameter 'clazz' is NULL.";
        assert (method != null) : "The parameter 'method' is NULL.";
        assert (method.length() > 0) : "The parameter 'method' must not be empty.";
        
        final StringBuilder message = new StringBuilder();
        message.append(clazz);
        message.append(".");
        message.append(method);
        message.append(": ");
        message.append(errorMessage);
        
        throw (new IllegalArgumentException(message.toString()));
    }
}
