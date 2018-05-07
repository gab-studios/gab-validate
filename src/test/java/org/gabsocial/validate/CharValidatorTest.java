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
 * A test class for the  CharValidator
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
    public void testToString()
    {
    	char x = '5';
        try
        {
            String desc = Validate.defineChar(x).toString();
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
        char x = '5';
        try
        {
            char retVal = Validate.defineChar(x).getValue();
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

        try
        {
            char x = '5';
            boolean retVal = Validate.defineChar(x).throwValidationExceptionOnFail().validate();
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

        try
        {
            char x = '5';
            boolean retVal = Validate.defineChar(x).validate();
            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testNotEmpty()
    {

        try
        {
            char x = '5';
            boolean retVal = Validate.defineChar(x).testNotEmpty().throwValidationExceptionOnFail().validate();
            Assert.assertTrue(retVal);
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
            char x = '5';
            char max = '8';
            boolean retVal = Validate.defineChar(x).testMaxValue(max)
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
            char x = '5';
            char min = '4';
            boolean retVal = Validate.defineChar(x).testMinValue(min)
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
            char x = '5';
            char y = '5';
            boolean retVal = Validate.defineChar(x).testEquals(y)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsDigit()
    {
        
        try
        {
            char x = '5';
            boolean retVal = Validate.defineChar(x).testIsDigit()
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    
    @Test
    public void testIsLowerCase()
    {
        
        try
        {
            char x = 'a';
            boolean retVal = Validate.defineChar(x).testIsLowerCase()
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsUpperCase()
    {
        
        try
        {
            char x = 'A';
            boolean retVal = Validate.defineChar(x).testIsUpperCase()
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    @Test
    public void testIsWhitespace()
    {
        
        try
        {
            char x = ' ';
            boolean retVal = Validate.defineChar(x).testIsWhitespace()
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    
    
    
}
