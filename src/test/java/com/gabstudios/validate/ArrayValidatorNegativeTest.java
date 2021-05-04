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
public class ArrayValidatorNegativeTest {
    @Before
    public void setUp() {
        //
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testMaxLength() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };

        ArrayValidator validator = Validate.defineArray(strArray1).testMaxLength(2).throwValidationExceptionOnFail();
        Assert.assertThrows(ValidateException.class, () -> validator.validate());

    }

    @Test
    public void testMaxLengthLessThanZero() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        Assert.assertThrows(IllegalArgumentException.class, () -> Validate.defineArray(strArray1).testMaxLength(-11));
    }

    public void testMaxLengthGreaterThanMin() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        Assert.assertThrows(IllegalArgumentException.class,
                () -> Validate.defineArray(strArray1).testMinLength(11).testMaxLength(5));

    }

    @Test
    public void testMinLength() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        ArrayValidator validator = Validate.defineArray(strArray1).testMinLength(5).throwValidationExceptionOnFail();
        Assert.assertThrows(ValidateException.class, () -> validator.validate());

    }

    @Test
    public void testMinLength2() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        Assert.assertThrows(IllegalArgumentException.class, () -> Validate.defineArray(strArray1).testMinLength(-5));

    }

    @Test
    public void testMinLength3() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        Assert.assertThrows(IllegalArgumentException.class,
                () -> Validate.defineArray(strArray1).testMinLength(11).testMaxLength(10));

    }

    @Test
    public void testMinLengthLessThanZero() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        Assert.assertThrows(IllegalArgumentException.class, () -> Validate.defineArray(strArray1).testMinLength(-10));

    }

    @Test
    public void testMinLengthLessThanMax() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        Assert.assertThrows(IllegalArgumentException.class,
                () -> Validate.defineArray(strArray1).testMaxLength(5).testMinLength(11));

    }

    @Test
    public void testNotNullEmpty() {

        String[] strArray1 = null;
        ArrayValidator validator = Validate.defineArray(strArray1).testNotNullEmpty().throwValidationExceptionOnFail();
        Assert.assertThrows(ValidateException.class, () -> validator.validate());

    }

    @Test
    public void testNotNullEmpty2() {

        String[] strArray1 = {};
        ArrayValidator validator = Validate.defineArray(strArray1).testNotNullEmpty().throwValidationExceptionOnFail();
        Assert.assertThrows(ValidateException.class, () -> validator.validate());

    }

    @Test
    public void testNotNull() {

        String[] strArray1 = null;
        ArrayValidator validator = Validate.defineArray(strArray1).testNotNull().throwValidationExceptionOnFail();
        Assert.assertThrows(ValidateException.class, () -> validator.validate());

    }

    @Test
    public void testEquals() {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        String[] strArray2 = { "Hello", "World", "is", "crazy" };
        ArrayValidator validator = Validate.defineArray(strArray1).testEquals(strArray2)
                .throwValidationExceptionOnFail();

        Assert.assertThrows(ValidateException.class, () -> validator.validate());

    }

}
