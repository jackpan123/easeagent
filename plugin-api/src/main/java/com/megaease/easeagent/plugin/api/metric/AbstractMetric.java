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

package com.megaease.easeagent.plugin.api.metric;

import com.megaease.easeagent.plugin.api.Context;
import com.megaease.easeagent.plugin.api.config.Config;
import com.megaease.easeagent.plugin.api.metric.name.NameFactory;
import com.megaease.easeagent.plugin.api.metric.name.Tags;

public abstract class AbstractMetric {
    protected MetricRegistry metricRegistry;

    protected NameFactory nameFactory;

    protected Tags tags;

    public AbstractMetric(Config config, Tags tags) {
        this.tags = tags;
    }

    public abstract NameFactory getNameFactory();

    public abstract void collectMetric(String key, boolean success, Context ctx);

    public void shutdown() {
        // this.metricRegistry.remove(tags.)
    }
}