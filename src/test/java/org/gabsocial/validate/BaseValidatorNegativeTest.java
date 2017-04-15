/*****************************************************************************************
 *
 * Copyright 2017 Gregory Brown. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *****************************************************************************************
 */
package org.gabsocial.validate;

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
public class BaseValidatorNegativeTest
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
    public void testEmptyThrowValidateExceptionMessage()
    {
        try
        {
            BaseValidatorTester validator = new BaseValidatorTester("");
            validator.validate();
            
            Assert.fail();
        }
        catch (final AssertionError e)
        {
            Assert.assertTrue(true);
        }

    }
    
    
    @Test
    public void testNullThrowValidateExceptionMessage()
    {
        try
        {
            BaseValidatorTester validator = new BaseValidatorTester(null);
            validator.validate();
            
            Assert.fail();
        }
        catch (final AssertionError e)
        {
            Assert.assertTrue(true);
        }

    }
}

class BaseValidatorTester extends BaseValidator<BaseValidatorTester>
{

    String _message;
    
    public BaseValidatorTester(String message )
    {
        this._message = message;
    }
    
    /* (non-Javadoc)
     * @see org.gabsocial.validate.Validator#validate()
     */
    @Override
    public boolean validate()
    {
        BaseValidator
        .throwValidateException(this._message);
        
        return false;
    }
    
}
