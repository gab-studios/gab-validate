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

package org.gabsocial.gabvalidate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class CharValidatorTest
{
    @Before
    public void setUp()
    {
        //
    }
    
    @After
    public void tearDown()
    {
        
    }
    
    @Test
    public void testMaxValue()
    {

        try
        {
            char x = '5';
            char max = '8';
            boolean retVal = Validate.defineChar(x).testMaxValue(max)
                    .throwOnNotValidate().validate();

            Assert.assertTrue(retVal);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testMinLength()
    {
        
        try
        {
            char x = '5';
            char min = '4';
            boolean retVal = Validate.defineChar(x).testMinValue(min)
                    .throwOnNotValidate().validate();

            Assert.assertTrue(retVal);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    
    @Test
    public void testEquals()
    {
        
        try
        {
            char x = '5';
            char y = '5';
            boolean retVal = Validate.defineChar(x).testEquals(y)
                    .throwOnNotValidate().validate();

            Assert.assertTrue(retVal);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
}
