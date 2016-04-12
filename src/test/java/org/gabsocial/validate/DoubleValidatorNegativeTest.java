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
 * A test class for the DoubleValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class DoubleValidatorNegativeTest
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
            double x = 5;
            double max = 4;
            boolean retVal = Validate.defineDouble(x).testMaxValue(max)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMaxValue2()
    {

        try
        {
            double x = 5;
            double max = 4;
            boolean retVal = Validate.defineDouble(x).testMaxValue(max)
                    .validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(false);
        }

    }
    
    @Test
    public void testMinLength()
    {
        
        try
        {
            double x = 5;
            double min = 7;
            boolean retVal = Validate.defineDouble(x).testMinValue(min)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testMinLength2()
    {
        
        try
        {
            double x = 5;
            double min = 7;
            boolean retVal = Validate.defineDouble(x).testMinValue(min)
                    .validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(false);
        }
        
    }
    
    
    @Test
    public void testEquals()
    {
        
        try
        {
            double x = 5;
            double y = 6;
            boolean retVal = Validate.defineDouble(x).testEquals(y)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testEquals2()
    {
        
        try
        {
            double x = 5;
            double y = 6;
            boolean retVal = Validate.defineDouble(x).testEquals(y)
                    .validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(false);
        }
        
    }
    
}
