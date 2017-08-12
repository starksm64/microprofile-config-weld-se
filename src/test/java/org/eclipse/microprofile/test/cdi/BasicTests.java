/*
 *  Copyright (c) 2011-2017 Contributors to the Eclipse Foundation
 *
 *  See the NOTICE file(s) distributed with this work for additional
 *  information regarding copyright ownership.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Contributors:
 */

package org.eclipse.microprofile.test.cdi;


import java.time.Duration;
import java.time.LocalDateTime;

import javax.inject.Inject;

import org.eclipse.microprofile.config.Config;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 *
 */
@RunWith(WeldJUnit4Runner.class)
public class BasicTests {
    @Inject
    private Config config;
    @Inject
    private MyConfigPropertyUser configUser;

    /**
     * Test the String based values
     */
    @Test
    public void testStringConfigProperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("Expect microprofile-config.properties value",
            "ID-microprofile-config.properties", configUser.getMyID());
        Assert.assertEquals("Expect microprofile-config.properties/cdi.MyConfigPropertyUser.username value",
            "customprop-microprofile-config.properties", configUser.getUsername());
        Assert.assertEquals("Expect @ConfigProperty defaultValue", "expectedValue", configUser.getWantDefault());
    }

    /**
     * Test the Float based values
     */
    @Test
    public void testFloatConfigProperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("getFloatValue", 12.345, configUser.getFloatValue(), 0.0001);
        Assert.assertEquals("getMyPI", 3.141590, configUser.getMyPI(), 5E-7);
    }

    /**
     * Test the Double based values
     */
    @Test
    public void testDoubleConfigProperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("getDoubleValue", 12.34567890, configUser.getDoubleValue(), 1E-9);
    }

    /**
     * Test the Short based values
     */
    @Test
    public void testShortProperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("getShortValue", 101, configUser.getShortValue());
    }
    /**
     * Test the Integer based values
     */
    @Test
    public void testIntegerProperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("getIntValue", 12345678, configUser.getIntValue());
    }
    /**
     * Test the Long based values
     */
    @Test
    public void testLongProperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("getLongValue", 123456789012345L, configUser.getLongValue());
    }
    /**
     * Test the LocalDateTime based values
     */
    @Test
    public void testLocalDateTimeProperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("getLdtValue", LocalDateTime.parse("2017-06-03T10:18:29"), configUser.getLdtValue());
    }
    /**
     * Test the Duration based values
     */
    @Test
    public void testDurationroperty() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertEquals("getDurationValue", Duration.parse("PT15M"), configUser.getDurationValue());
    }

    @Test
    public void testDuck2Property() {
        Assert.assertNotNull("MyConfigPropertyUser", configUser);
        Assert.assertNotNull("getDuckValue", configUser.getDuckValue());
        Assert.assertEquals("getDuckValue.name", "Howard", configUser.getDuckValue().getName());

    }
}
