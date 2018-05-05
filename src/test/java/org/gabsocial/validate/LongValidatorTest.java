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
 * A test class for the LongValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class LongValidatorTest
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
    public void testToString()
    {
    	long x = 5L;
        try
        {
            String desc = Validate.defineLong(x).toString();
            Assert.assertTrue(desc != null && desc.length() != 0);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testGetValue()
    {
    	long x = 5L;
        try
        {
            long retVal = Validate.defineLong(x).getValue();
            Assert.assertEquals(x, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    
    @Test
    public void testNoTest()
    {
    	long x = 5L;
        try
        {
            boolean retVal = Validate.defineLong(x).throwValidationExceptionOnFail().validate();
            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testNoTest2()
    {
    	long x = 5L;
        try
        {
            boolean retVal = Validate.defineLong(x).validate();
            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    } 
    
    @Test
    public void testMaxValue()
    {

        try
        {
        	long x = 5L;
            long max = 10L;
            boolean retVal = Validate.defineLong(x).testMaxValue(max)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testMinLength()
    {
        
        try
        {
        	long x = 5L;
            long min = 4L;
            boolean retVal = Validate.defineLong(x).testMinValue(min)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    
    @Test
    public void testEquals()
    {
        
        try
        {
        	long x = 5L;
        	long y = 5L;
            boolean retVal = Validate.defineLong(x).testEquals(y)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
}
