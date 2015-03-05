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
     * @param errorMessage
     *            The error message to include in an exception if it is created.
     * @param param
     *            The parameter to verify.
     * @param <T>
     *            The runtime class type of the parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is null.
     */
    public static <T> void isNotNull(final Class<?> clazz,
            final String errorMessage, final T param)
            throws IllegalArgumentException
    {
        if (param == null)
        {
            Validate.throwIllegalArgumentException(errorMessage, clazz);
        }
    }
    
    /**
     * Tests if a parameter is not null or empty.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param errorMessage
     *            The error message to include in an exception if it is created.
     * @param param
     *            The parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is null or empty.
     */
    public static void isNotNullOrEmpty(final Class<?> clazz,
            final String errorMessage, final String... param)
            throws IllegalArgumentException
    {
        if ((param == null) || (param.length == 0))
        {
            Validate.throwIllegalArgumentException(errorMessage, clazz);
        }
        else if (param.length == 1)
        {
            if (param[0].trim().length() == 0)
            {
                Validate.throwIllegalArgumentException(errorMessage, clazz);
            }
        }
        
    }
    
    /**
     * Tests if the param is not empty. If it is then an exception is thrown.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param errorMessage
     *            The error message to include in an exception if it is created.
     * @param param
     *            The parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the paramter is empty.
     */
    public static void isNotEmpty(final Class<?> clazz,
            final String errorMessage, final char param)
            throws IllegalArgumentException
    {
        if (param == '\0')
        {
            Validate.throwIllegalArgumentException(errorMessage, clazz);
        }
    }
    
    /**
     * Tests if a param is zero.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param errorMessage
     *            The error message to include in an exception if it is created.
     * @param param
     *            The parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is zero.
     */
    public static void isNotZero(final Class<?> clazz,
            final String errorMessage, final int param)
            throws IllegalArgumentException
    {
        if (param != 0)
        {
            Validate.throwIllegalArgumentException(errorMessage, clazz);
        }
    }
    
    /**
     * Tests if a param is greater than or equal to zero.
     * 
     * @param clazz
     *            The class throwing the exception.
     * @param errorMessage
     *            The error message to include in an exception if it is created.
     * @param param
     *            The parameter to verify.
     * @throws IllegalArgumentException
     *             This exception is thrown if the parameter is less than zero.
     */
    public static void isGreaterEqualZero(final Class<?> clazz,
            final String errorMessage, final int param)
            throws IllegalArgumentException
    {
        if (param < 0)
        {
            Validate.throwIllegalArgumentException(errorMessage, clazz);
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
            final String errorMessage, final Class<?> clazz)
    {
        final StringBuilder message = new StringBuilder();
        message.append(clazz);
        message.append(": ");
        message.append(errorMessage);
        
        throw (new IllegalArgumentException(message.toString()));
    }
}
