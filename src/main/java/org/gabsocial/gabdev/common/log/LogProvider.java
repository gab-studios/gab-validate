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

package org.gabsocial.gabdev.common.log;

import java.util.HashMap;
import java.util.Map;


public abstract class LogProvider
{
    /*
     * The fully qualified class name.  Used as the property key to get the LogProvider implementation.
     */
    private static final String                   FQCN             = "org.gabsocial.gabdev.common.log.LogProvider";
    
    /*
     * The default LogProvider implementation. 
     */
    private static final String                   DEFAULT_LOG_FQCN = "org.gabsocial.gabdev.common.log.impl.JavaLogProviderImpl";
    
    /*
     * A cache that holds onto the different LogProvider implementation as they are used.
     */
    private static final Map<String, LogProvider> LOG_PROVIDER_MAP;
    
    static
    {
        LOG_PROVIDER_MAP = new HashMap<String, LogProvider>();
    }
    
    /**
     * Protected class.
     */
    protected LogProvider()
    {
        // void - do nothing.
    }
    
    /**
     * Gets the current log provider. A provider can be based on a type of
     * service.
     * 
     * @return A <code>LogProvider</code> instance.
     */
    public static final LogProvider getProvider()
    {
        String logProviderFQCN = System.getProperty(FQCN);
        if (logProviderFQCN == null || logProviderFQCN.length() == 0)
        {
            logProviderFQCN = DEFAULT_LOG_FQCN;
        }
        
        LogProvider logProvider = LOG_PROVIDER_MAP.get(logProviderFQCN);
        if (logProvider == null)
        {
            logProvider = loadLogProvider(logProviderFQCN);
            LOG_PROVIDER_MAP.put(logProviderFQCN, logProvider);
        }
        
        return (logProvider);
    }
    
    /**
     * Gets the Log service provided by the Log Provider.
     * 
     * @return A <code>LogService</code> instance.
     */
    public abstract LogService getService();
    
    /**
     * Clears cached <code>LogProvider</code> implementions from the
     * LogProvider.
     */
    public void clear()
    {
        LOG_PROVIDER_MAP.clear();
    }
    
    /*
     * Dynamically loads a LogProvider implementation.
     */
    protected final static LogProvider loadLogProvider(final String className)
    {
        assert (className != null) : "loadLogProvider() - the parameter 'className' should not be null or empty";
        
        try
        {
            final LogProvider logProvider = (LogProvider) Class.forName(
                    className).newInstance();
            return (logProvider);
        }
        catch (final IllegalAccessException e)
        {
            throw (new LogProviderSysException(
                    "Illegal access to class name - " + className, e));
        }
        catch (final ClassNotFoundException e)
        {
            throw (new LogProviderSysException(
                    "Unable to locate the class name - " + className, e));
        }
        catch (final InstantiationException e)
        {
            throw (new LogProviderSysException(
                    "Unable to instantiate the class name - " + className, e));
        }
    }
    
}
