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
public class ValidateTest
{
    
    @Test
    public void isLessThanMaxLength()
    {
        
        try
        {
            Validate.isLessThanMaxLength(ValidateTest.class, 10, "HelloWorld");
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void isMinMaxLength()
    {
        
        try
        {
            Validate.isMinMaxLength(ValidateTest.class, 8, 10, "HelloWorld");
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
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
    public void testIsGreaterEqualZero()
    {
        
        try
        {
            Validate.isGreaterEqualZero(ValidateTest.class, 1);
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsNotEmpty()
    {
        
        try
        {
            Validate.isCharNotEmpty(ValidateTest.class, 'C');
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsNotNull()
    {
        
        try
        {
            Validate.isNotNull(ValidateTest.class, "HelloWorld");
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsNotNullOrEmpty1()
    {
        
        try
        {
            Validate.isNotNullOrEmpty(ValidateTest.class, "HelloWorld");
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsNotNullOrEmpty2()
    {
        
        try
        {
            Validate.isNotNullOrEmpty(ValidateTest.class, "H");
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsNotZero()
    {
        
        try
        {
            Validate.isNotZero(ValidateTest.class, 1);
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsTrue()
    {
        
        try
        {
            Validate.isTrue(ValidateTest.class, true);
            
            Assert.assertTrue(true);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail(e.toString());
        }
        
    }
}
