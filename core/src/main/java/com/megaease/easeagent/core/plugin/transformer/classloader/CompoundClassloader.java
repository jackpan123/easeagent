/*
 * Copyright (c) 2021, MegaEase
 * All rights reserved.
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
 */

package com.megaease.easeagent.core.plugin.transformer.classloader;

import com.megaease.easeagent.core.plugin.matcher.MethodTransformation;
import com.megaease.easeagent.log4j2.Logger;
import com.megaease.easeagent.log4j2.LoggerFactory;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class CompoundClassloader {
    private final static Logger log = LoggerFactory.getLogger(MethodTransformation.class);
    private static ConcurrentHashMap<ClassLoader, ClassLoader> loaders = new ConcurrentHashMap<>();

    public static ClassLoader compound(ClassLoader parent, ClassLoader external) {
        if (loaders.putIfAbsent(external, external) != null) {
            return parent;
        }

        try {
            parent.getClass().getDeclaredMethod("add", ClassLoader.class).invoke(parent, external);
        } catch (Exception e) {
            log.warn("{}, this may be a bug if it was running in production", e.toString());
        }
        return parent;
    }
}