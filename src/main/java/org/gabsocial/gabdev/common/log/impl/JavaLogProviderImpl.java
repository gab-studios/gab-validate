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

import org.gabsocial.gabdev.common.log.LogProvider;
import org.gabsocial.gabdev.common.log.LogService;


/**
 *
 * 
 * @author Gregory Brown (sysdevone)
 *
 */
public class JavaLogProviderImpl extends LogProvider
{
    
    /**
     * Gets the Log service provided by the Log Provider.
     * 
     * @return A <code>LogService</code> instance.
     */
    public LogService getService()
    {
        return (new JavaLogServiceImpl());
        
    }
}
