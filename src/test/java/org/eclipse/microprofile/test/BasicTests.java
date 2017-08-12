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

package org.eclipse.microprofile.test;

import java.util.ArrayList;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.spi.ConfigBuilder;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Basic test to validate that the application Config has the expected behaviors
 */
public class BasicTests {
    @Test
    public void testGetConfig() {
        Config config = ConfigProvider.getConfig();
        Assert.assertNotNull("ConfigProvider.getConfig()", config);
    }
    @Test
    public void testExpect3ConfigSources() {
        Config config = ConfigProvider.getConfig();
        Assert.assertNotNull("ConfigProvider.getConfig()", config);

        // Validate that there are 3 ConfigSources
        int count = 0;
        for(ConfigSource cs : config.getConfigSources()) {
            count ++;
            System.out.printf("Saw ConfigSource: %s\n", cs.getName());
        }
        Assert.assertEquals("Expected 3 ConfigSources", 3, count);

    }
    @Test
    public void testExpect3ConfigSourcesConfigBuilder() {
        ConfigBuilder builder = ConfigProviderResolver.instance().getBuilder();
        Assert.assertNotNull("ConfigProviderResolver.getBuilder()", builder);
        Config config = builder.addDefaultSources()
            .addDiscoveredConverters()
            .addDiscoveredSources()
            .build();
        Assert.assertNotNull("ConfigBuilder.build()", config);

        // Validate that there are 3 ConfigSources
        int count = 0;
        for(ConfigSource cs : config.getConfigSources()) {
            count ++;
            System.out.printf("Saw ConfigSource: %s\n", cs.getName());
        }
        Assert.assertEquals("Expected 3 ConfigSources", 3, count);

    }

    @Test
    public void testFindSystemProperties() {
        Config config = ConfigProvider.getConfig();
        Assert.assertNotNull("ConfigProvider.getConfig()", config);

        // Validate all system properties are found
        ArrayList<String> missing = new ArrayList<>();
        for(String key : System.getProperties().stringPropertyNames()) {
            String value = config.getValue(key, String.class);
            if(value == null) {
                missing.add(key);
            }
        }
        Assert.assertEquals("No missing system properties", 0, missing.size());
    }

    @Test
    public void testFindSystemPropertiesConfigBuilder() {
        ConfigBuilder builder = ConfigProviderResolver.instance().getBuilder();
        Assert.assertNotNull("ConfigProviderResolver.getBuilder()", builder);
        Config config = builder.addDefaultSources()
            .addDiscoveredConverters()
            .addDiscoveredSources()
            .build();
        Assert.assertNotNull("ConfigBuilder.build()", config);

        // Validate all system properties are found
        ArrayList<String> missing = new ArrayList<>();
        for(String key : System.getProperties().stringPropertyNames()) {
            String value = config.getValue(key, String.class);
            if(value == null) {
                missing.add(key);
            }
        }
        Assert.assertEquals("No missing system properties", 0, missing.size());
    }

    @Test
    public void testFindSystemEnvironVars() {
        Config config = ConfigProvider.getConfig();
        Assert.assertNotNull("ConfigProvider.getConfig()", config);

        // Validate all system properties are found
        ArrayList<String> missing = new ArrayList<>();
        for(String key : System.getenv().keySet()) {
            String value = config.getValue(key, String.class);
            if(value == null) {
                missing.add(key);
            }
        }
        Assert.assertEquals("No missing environment variables", 0, missing.size());
    }

    @Test
    public void testFindSystemEnvironVarsConfigBuilder() {
        ConfigBuilder builder = ConfigProviderResolver.instance().getBuilder();
        Assert.assertNotNull("ConfigProviderResolver.getBuilder()", builder);
        Config config = builder.addDefaultSources()
            .addDiscoveredConverters()
            .addDiscoveredSources()
            .build();
        Assert.assertNotNull("ConfigBuilder.build()", config);

        // Validate all system properties are found
        ArrayList<String> missing = new ArrayList<>();
        for(String key : System.getenv().keySet()) {
            String value = config.getValue(key, String.class);
            if(value == null) {
                missing.add(key);
            }
        }
        Assert.assertEquals("No missing environment variables", 0, missing.size());
    }
}
