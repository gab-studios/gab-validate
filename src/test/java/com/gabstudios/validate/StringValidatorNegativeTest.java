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
public class StringValidatorNegativeTest {
    @Before
    public void setUp() {
        //
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testMaxLength() {
        Assert.assertThrows(ValidateException.class,
                () -> Validate.defineString("HelloWorld").testMaxLength(5).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMaxLengthLessThanZero() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Validate.defineString("HelloWorld").testMaxLength(-1)
                .throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMaxLengthGreaterThanMin() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Validate.defineString("HelloWorld").testMinLength(11)
                .testMaxLength(5).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMinLength() {

        Assert.assertThrows(ValidateException.class, () -> Validate.defineString("HelloWorld").testMinLength(11)
                .throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMinLengthLessThanZero() {

        Assert.assertThrows(IllegalArgumentException.class, () -> Validate.defineString("HelloWorld").testMinLength(-10)
                .throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMinLengthLessThanMax() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Validate.defineString("HelloWorld").testMaxLength(5)
                .testMinLength(11).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testNotNullEmpty() {

        Assert.assertThrows(ValidateException.class,
                () -> Validate.defineString("").testNotNullEmpty().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testNotNull() {

        Assert.assertThrows(ValidateException.class,
                () -> Validate.defineString(null).testNotNull().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testEquals() {

        Assert.assertThrows(ValidateException.class, () -> Validate.defineString("HelloWorld")
                .testEquals("1HelloWorld1").throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testEqualsNoCase() {

        Assert.assertThrows(ValidateException.class, () -> Validate.defineString("HelloWorld")
                .testEqualsNoCase("1hELLOwORLD1").throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMatch() {

        Assert.assertThrows(ValidateException.class, () -> Validate.defineString("HelloWorld").testMatch("HelloWorld1")
                .throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMatch2() {

        Assert.assertThrows(ValidateException.class, () -> Validate.defineString("HelloWorld").testMatch("[A-Z]*")
                .throwValidationExceptionOnFail().validate());

    }

}
