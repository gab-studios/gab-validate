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

package org.gabsocial.gabdev.common.log.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.gabsocial.gabdev.common.log.LogService;
import org.gabsocial.gabdev.validate.Validate;


/**
 * A service to handle logging. This uses the java logging.
 *
 * @author Gregory Brown (sysdevone)
 */
public class JavaLogServiceImpl implements LogService
{
    private static String createJSONLogMethodMessage(final String fqcn,
            final String methodName, final Long timeInMillis,
            final String messageString)
    {
        
        assert (fqcn != null) : "The parameter 'fqcn' is NULL.";
        assert (fqcn.length() > 0) : "The parameter 'fqcn' is empty.";
        assert (methodName != null) : "The parameter 'methodName' is NULL.";
        assert (methodName.length() > 0) : "The parameter 'methodName' is empty.";
        assert (timeInMillis > -1L) : "The parameter 'timeInMillis' less than zero.";
        assert (messageString != null) : "The parameter 'messageString' is NULL.";
        assert (messageString.length() > 0) : "The parameter 'messageString' is empty.";
        
        final StringBuilder message = new StringBuilder();
        message.append("{");
        message.append("'fqcn':'" + fqcn + "',");
        message.append("'method':'" + methodName + "',");
        message.append("'threadId':'" + Thread.currentThread().getId() + "',");
        try
        {
            message.append("'ipAddress':'" + InetAddress.getLocalHost() + "',");
        }
        catch (UnknownHostException e)
        {
            message.append("'ipAddress':'unknown',");
        }
        message.append("'message':'" + messageString + "',");
        message.append("'timeInMillis':" + timeInMillis + ",");
        
        message.append("}");
        return (message.toString());
    }
    
    /**
     * Protected class. Should only be created by LogProvider.
     */
    protected JavaLogServiceImpl()
    {
        // void - protectes class scope.
    }
    
    /**
     * Call when you want to log detailed information for debugging or tracing.
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     * @param message
     *            The message to send to the log.
     */
    public final void logDetail(final Class<?> clazz, final String methodName,
            final String message)
    {
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'message' is null or empty.", message);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.FINEST))
        {
            logger.logp(Level.FINEST, fqcn, methodName, message);
        }
    }
    
    /**
     * Call when you want to log a failure message.
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     * @param message
     *            The message to send to the log.
     */
    public final void logFailure(final Class<?> clazz, final String methodName,
            final String message)
    {
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'message' is null or empty.", message);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.SEVERE))
        {
            logger.logp(Level.SEVERE, fqcn, methodName, message);
        }
    }
    
    /**
     * Call when you want to log a failure with throwable details.
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     * @param message
     *            The message to send to the log.
     * @param thrown
     *            The throwable to log details about.
     */
    public final void logFailure(final Class<?> clazz, final String methodName,
            final String message, final Throwable thrown)
    {
        
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'message' is null or empty.", message);
        Validate.isNotNull(JavaLogServiceImpl.class, "The parameter 'thrown' is null.", thrown);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.SEVERE))
        {
            logger.logp(Level.SEVERE, fqcn, methodName, message, thrown);
        }
    }
    
    /**
     * Call when you want to log standard messages.
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     * @param message
     *            The message to send to the log.
     */
    public final void logMessage(final Class<?> clazz, final String methodName,
            final String message)
    {
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'message' is null or empty.", message);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.INFO))
        {
            logger.logp(Level.INFO, fqcn, methodName, message);
        }
    }
    
    /**
     * Logs a message containing the class name, method name and starting
     * timestamp;
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     */
    public final void logMethodBegin(final Class<?> clazz,
            final String methodName)
    {
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.INFO))
        {
            final Long startTimeInMillis = Calendar.getInstance()
                    .getTimeInMillis();
            
            final String message = JavaLogServiceImpl
                    .createJSONLogMethodMessage(fqcn, methodName,
                            startTimeInMillis, "Method Begin");
            
            logger.logp(Level.INFO, fqcn, methodName, message);
        }
    }
    
    /**
     * Logs a message containing the class name, method name, endinging
     * timestamp and difference time;
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     */
    public final void logMethodEnd(final Class<?> clazz, final String methodName)
    {
        
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.INFO))
        {
            final Long endTimeInMillis = Calendar.getInstance()
                    .getTimeInMillis();
            
            final String message = JavaLogServiceImpl
                    .createJSONLogMethodMessage(fqcn, methodName,
                            endTimeInMillis, "Method End");
            
            logger.logp(Level.INFO, fqcn, methodName, message);
        }
    }
    
    /**
     * Call when you want to log a warning message.
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     * @param message
     *            The message to send to the log.
     */
    public final void logWarning(final Class<?> clazz, final String methodName,
            final String message)
    {
        
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'message' is null or empty.", message);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.WARNING))
        {
            logger.logp(Level.WARNING, fqcn, methodName, message);
        }
    }
    
    /**
     * Call when you want to log a warning message with a throwable details.
     *
     * @param clazz
     *            The class that is calling this log method.
     * @param methodName
     *            The name of the class method that is calling this log method.
     * @param message
     *            The message to send to the log.
     * @param thrown
     *            The throwable to log details about.
     */
    public final void logWarning(final Class<?> clazz, final String methodName,
            final String message, final Throwable thrown)
    {
        
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'clazz' is null or empty.", clazz.getName());
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'methodName' is null or empty.", methodName);
        Validate.isNotNullOrEmpty(JavaLogServiceImpl.class, "The parameter 'message' is null or empty.", message);
        Validate.isNotNull(JavaLogServiceImpl.class, "The parameter 'thrown' is null.", thrown);
        
        final String fqcn = clazz.getName();
        final Logger logger = Logger.getLogger(fqcn);
        if (logger.isLoggable(Level.WARNING))
        {
            logger.logp(Level.WARNING, fqcn, methodName, message, thrown);
        }
    }
    
}
