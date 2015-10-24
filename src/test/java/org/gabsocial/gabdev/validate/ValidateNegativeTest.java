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
            Validate.isNotNull(ValidateNegativeTest.class, null);
            
            Assert.fail("The test exeception was not thrown");
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
            Validate.isTrue(ValidateNegativeTest.class, false);
            
            Assert.fail("The test exeception was not thrown");
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
            Validate.isNotNullOrEmpty(ValidateNegativeTest.class, "");
            
            Assert.fail("The test exeception was not thrown");
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
            Validate.isNotNullOrEmpty(ValidateNegativeTest.class, "");
            
            Assert.fail("The test exeception was not thrown");
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
            Validate.isCharNotEmpty(ValidateNegativeTest.class, '\0');
            
            Assert.fail("The test exeception was not thrown");
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
            Validate.isNotZero(ValidateNegativeTest.class, 0);
            
            Assert.fail("The test exeception was not thrown");
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
            Validate.isGreaterEqualZero(ValidateNegativeTest.class, -1);
            
            Assert.fail("The test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void isLessThanMaxLength()
    {
        
        try
        {
            Validate.isLessThanMaxLength(ValidateTest.class, 6, "HelloWorld");
            
            Assert.fail("The test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void isMinMaxLength1()
    {
        
        try
        {
            Validate.isMinMaxLength(ValidateTest.class, 11, 12, "HelloWorld");
            
            Assert.fail("The test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void isMinMaxLength2()
    {
        
        try
        {
            Validate.isMinMaxLength(ValidateTest.class, 3, 7, "HelloWorld");
            
            Assert.fail("The test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void isMinMaxLength3()
    {
        
        try
        {
            Validate.isMinMaxLength(ValidateTest.class, 10, 8, "HelloWorld");
            
            Assert.fail("The test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void isMinMaxLength4()
    {
        
        try
        {
            Validate.isMinMaxLength(ValidateTest.class, -1, -1, "HelloWorld");
            
            Assert.fail("The test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
    
    @Test
    public void isMinMaxLength5()
    {
        
        try
        {
            Validate.isMinMaxLength(ValidateTest.class, 0, 0, "HelloWorld");
            
            Assert.fail("The test exeception was not thrown");
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        
    }
}
