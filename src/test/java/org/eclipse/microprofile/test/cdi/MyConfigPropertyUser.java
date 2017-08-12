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

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.test.cdi.custom.Duck2;

/**
 * Created by starksm on 6/2/17.
 */
public class MyConfigPropertyUser {
    @Inject
    @ConfigProperty(defaultValue = "emptyID")
    private String myID;
    @Inject
    @ConfigProperty(defaultValue = "expectedValue")
    private String wantDefault;
    @Inject
    @ConfigProperty(name = "cdi.MyConfigPropertyUser.username")
    private String username;
    @Inject
    @ConfigProperty
    private boolean booleanValue;
    @Inject
    @ConfigProperty(defaultValue = "101")
    private short shortValue = 1;
    @Inject
    @ConfigProperty
    private int intValue;
    @Inject
    @ConfigProperty
    private long longValue;
    @Inject
    @ConfigProperty(defaultValue = "3.14")
    private float floatValue;
    @Inject
    @ConfigProperty(defaultValue = "3.141590")
    private float myPI;
    @Inject
    @ConfigProperty
    private double doubleValue;
    @Inject
    @ConfigProperty
    private LocalDateTime ldtValue;
    @Inject
    @ConfigProperty
    private Duration durationValue;
    @Inject
    @ConfigProperty
    private Duck2 duckValue;

    @PostConstruct
    private void init() {
        System.out.printf("MyConfigPropertyUser.init\n");
    }
    public String getMyID() {
        return myID;
    }

    public void setMyID(String myID) {
        this.myID = myID;
    }

    public String getUsername() {
        return username;
    }

    public String getWantDefault() {
        return wantDefault;
    }

    public short getShortValue() {
        return shortValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public float getMyPI() {
        return myPI;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public LocalDateTime getLdtValue() {
        return ldtValue;
    }

    public Duration getDurationValue() {
        return durationValue;
    }

    public Duck2 getDuckValue() {
        return duckValue;
    }
}
