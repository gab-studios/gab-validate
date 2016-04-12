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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * A test class for the FloatValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class FloatValidatorNegativeTest
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
            float max = 4;
            boolean retVal = Validate.defineFloat(x).testMaxValue(max)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMinLength()
    {
        
        try
        {
            float x = 5;
            float min = 7;
            boolean retVal = Validate.defineFloat(x).testMinValue(min)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }
    }
    
    @Test
    public void testEquals()
    {
        
        try
        {
            float x = 5;
            float y = 6;
            boolean retVal = Validate.defineFloat(x).testEquals(y)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }
    }
}
