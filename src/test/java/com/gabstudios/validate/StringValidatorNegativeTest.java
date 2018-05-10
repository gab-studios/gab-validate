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

package com.gabstudios.validate;

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
            Validate.defineString("HelloWorld").testMaxLength(5)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMaxLengthLessThanZero()
    {

        try
        {
             Validate.defineString("HelloWorld").testMaxLength(-1)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMaxLengthGreaterThanMin()
    {

        try
        {
             Validate.defineString("HelloWorld").testMinLength(11).testMaxLength(5)
            .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testMinLength()
    {

        try
        {
             Validate.defineString("HelloWorld").testMinLength(11)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMinLengthLessThanZero()
    {

        try
        {
             Validate.defineString("HelloWorld").testMinLength(-10)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMinLengthLessThanMax()
    {

        try
        {
            Validate.defineString("HelloWorld").testMaxLength(5).testMinLength(11)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testNotNullEmpty()
    {

        try
        {
            Validate.defineString("").testNotNullEmpty()
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
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
             Validate.defineString(null).testNotNull()
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
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
             Validate.defineString("HelloWorld").testEquals("1HelloWorld1")
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
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
             Validate.defineString("HelloWorld").testEqualsNoCase("1hELLOwORLD1")
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
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
             Validate.defineString("HelloWorld").testMatch("HelloWorld1")
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
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
            Validate.defineString("HelloWorld").testMatch("[A-Z]*")
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
        
}
