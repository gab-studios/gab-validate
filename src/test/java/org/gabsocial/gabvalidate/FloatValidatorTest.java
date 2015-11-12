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
public class FloatValidatorTest
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
            float x = 5;
            float max = 10;
            boolean retVal = Validate.defineFloat(x).testMaxValue(max)
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
            float x = 5;
            float min = 4;
            boolean retVal = Validate.defineFloat(x).testMinValue(min)
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
            float x = 5;
            float y = 5;
            boolean retVal = Validate.defineFloat(x).testEquals(y)
                    .throwOnNotValidate().validate();

            Assert.assertTrue(retVal);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
}
