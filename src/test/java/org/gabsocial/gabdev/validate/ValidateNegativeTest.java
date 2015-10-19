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

package org.gabsocial.gabdev.validate;

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
public class ValidateNegativeTest
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
    public void testIsNotNull()
    {
        
        try
        {
            Validate.isNotNull(
                    ValidateNegativeTest.class,
                    "The parameter should not be null.  You should not see this message.",
                    null);
            
            Assert.fail("THe test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testIsTrue()
    {
        
        try
        {
            Validate.isTrue(
                    ValidateNegativeTest.class,
                    "The parameter should be true.  You should not see this message.",
                    false);
            
            Assert.fail("THe test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testIsNotNullOrEmpty1()
    {
        
        try
        {
            Validate.isNotNullOrEmpty(
                    ValidateNegativeTest.class,
                    "The parameter should be 'HelloWorld'.  You should not see this message.",
                    "");
            
            Assert.fail("THe test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testIsNotNullOrEmpty2()
    {
        
        try
        {
            Validate.isNotNullOrEmpty(
                    ValidateNegativeTest.class,
                    "The parameter should be 'HelloWorld'.  You should not see this message.",
                    "");
            
            Assert.fail("THe test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testIsNotEmpty()
    {
        
        try
        {
            Validate.isNotEmpty(
                    ValidateNegativeTest.class,
                    "The parameter should be 'C'.  You should not see this message.",
                    '\0');
            
            Assert.fail("THe test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testIsNotZero()
    {
        
        try
        {
            Validate.isNotZero(
                    ValidateNegativeTest.class,
                    "The parameter should be 1.  You should not see this message.",
                    0);
            
            Assert.fail("THe test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void testIsGreaterEqualZero()
    {
        
        try
        {
            Validate.isGreaterEqualZero(
                    ValidateNegativeTest.class,
                    "The parameter should be 1.  You should not see this message.",
                    -1);
            
            Assert.fail("THe test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
}
