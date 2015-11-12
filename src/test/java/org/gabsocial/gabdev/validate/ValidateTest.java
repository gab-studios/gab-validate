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
 * Basic positive tests for the Validator class.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ValidateTest
{
    
    /*
     * Tests the defineString method.
     */
    @Test
    public void defineString()
    {
        
        try
        {
            StringValidator stringValidator = Validate
                    .defineString("HelloWorld");
            Assert.assertTrue(stringValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineBoolean method.
     */
    @Test
    public void defineBoolean()
    {
        
        try
        {
            BooleanValidator booleanValidator = Validate.defineBoolean(true);
            Assert.assertTrue(booleanValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineByte method.
     */
    @Test
    public void defineByte()
    {
        
        try
        {
            ByteValidator byteValidator = Validate.defineByte((byte) 0xa);
            Assert.assertTrue(byteValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineChar method.
     */
    @Test
    public void defineChar()
    {
        
        try
        {
            CharValidator charValidator = Validate.defineChar('C');
            Assert.assertTrue(charValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineDouble method.
     */
    @Test
    public void defineDouble()
    {
        
        try
        {
            DoubleValidator doubleValidator = Validate.defineDouble(1.5);
            Assert.assertTrue(doubleValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineFloat method.
     */
    @Test
    public void defineFloat()
    {
        
        try
        {
            FloatValidator floatValidator = Validate.defineFloat(1.0F);
            Assert.assertTrue(floatValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineInteger method.
     */
    @Test
    public void defineInteger()
    {
        
        try
        {
            IntegerValidator intValidator = Validate.defineInteger(55);
            Assert.assertTrue(intValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineShort method.
     */
    @Test
    public void defineShort()
    {
        
        try
        {
            ShortValidator shortValidator = Validate.defineShort((short) 100);
            Assert.assertTrue(shortValidator != null);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineLong method.
     */
    @Test
    public void defineLong()
    {
        
        try
        {
            LongValidator longValidator = Validate.defineLong(100L);
            Assert.assertTrue(longValidator != null);
        }
        catch (final Exception e)
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
    
}
