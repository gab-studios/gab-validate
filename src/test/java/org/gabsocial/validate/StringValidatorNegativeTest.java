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
 * A negative test class for the StringValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class StringValidatorNegativeTest
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
    public void testMaxLength()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testMaxLength(5)
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertEquals(retVal, false);
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
            boolean retVal = Validate.defineString("HelloWorld").testMinLength(11)
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testNotNullEmpty()
    {

        try
        {
            boolean retVal = Validate.defineString("").testNotNullEmpty()
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    

    @Test
    public void testNotNull()
    {

        try
        {
            boolean retVal = Validate.defineString(null).testNotNull()
                    .throwExceptionOnFailedValidation().validate();

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
            boolean retVal = Validate.defineString("HelloWorld").testEquals("1HelloWorld1")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testEqualsNoCase()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testEqualsNoCase("1hELLOwORLD1")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMatch()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testMatch("HelloWorld1")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMatch2()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testMatch("[A-Z]*")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertEquals(false, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
        
}
