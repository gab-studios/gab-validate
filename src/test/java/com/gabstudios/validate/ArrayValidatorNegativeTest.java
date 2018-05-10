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
 * A test class for the ArrayValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ArrayValidatorNegativeTest
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMaxLength(2)
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMaxLength(-11)
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMinLength(11).testMaxLength(5)
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMinLength(5)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testMinLength2()
    {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMinLength(-5)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

    }
    
    @Test
    public void testMinLength3()
    {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMinLength(11).testMaxLength(10)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

    }
    
    @Test
    public void testMinLengthLessThanZero()
    {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMinLength(-10)
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Validate.defineArray(strArray1).testMaxLength(5).testMinLength(11)
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

        String[] strArray1 = null;
        try
        {
            Validate.defineArray(strArray1).testNotNullEmpty()
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
    @Test
    public void testNotNullEmpty2()
    {

        String[] strArray1 = { };
        try
        {
            Validate.defineArray(strArray1).testNotNullEmpty()
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

        String[] strArray1 = null;
        try
        {
            Validate.defineArray(strArray1).testNotNull()
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        String[] strArray2 = { "Hello", "World", "is", "crazy" };
        try
        {
            Validate.defineArray(strArray1).testEquals(strArray2)
                    .throwValidationExceptionOnFail().validate();

            Assert.fail();
        }
        catch (final ValidateException e)
        {
            Assert.assertTrue(true);
        }

    }
    
        
}
