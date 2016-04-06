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
 * A test class for the StringValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class StringValidatorTest
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
            boolean retVal = Validate.defineString("HelloWorld").testMaxLength(10)
                    .throwExceptionOnFailedValidation().validate();

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
            boolean retVal = Validate.defineString("HelloWorld").testMinLength(8)
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testNotNullEmpty()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testNotNullEmpty()
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    

    @Test
    public void testNotNull()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testNotNull()
                    .throwExceptionOnFailedValidation().validate();

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
            boolean retVal = Validate.defineString("HelloWorld").testEquals("HelloWorld")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testEqualsNoCase()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testEqualsNoCase("hELLOwORLD")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testMatch()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testMatch("HelloWorld")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testMatch2()
    {

        try
        {
            boolean retVal = Validate.defineString("HelloWorld").testMatch("[A-Za-z]*")
                    .throwExceptionOnFailedValidation().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
        
}