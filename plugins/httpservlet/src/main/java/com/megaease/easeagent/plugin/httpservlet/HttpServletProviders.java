/*
 * Copyright (c) 2017, MegaEase
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

package com.megaease.easeagent.plugin.httpservlet;

import com.megaease.easeagent.plugin.Interceptor;
import com.megaease.easeagent.plugin.Provider;
import com.megaease.easeagent.plugin.annotation.ProviderBean;
import com.megaease.easeagent.plugin.httpservlet.advice.DoFilterAdvice;
import com.megaease.easeagent.plugin.httpservlet.interceptor.DoFilterMetricInterceptor;
import com.megaease.easeagent.plugin.httpservlet.interceptor.DoFilterTraceInterceptor;

import java.util.function.Supplier;

public class HttpServletProviders {
    @ProviderBean
    public static class DoFilterProvider implements Provider {
        @Override
        public Supplier<Interceptor> getInterceptorProvider() {
            return DoFilterTraceInterceptor::new;
        }

        @Override
        public String getAdviceTo() {
            return DoFilterAdvice.class.getCanonicalName()
                + ":default";
        }

        @Override
        public String getPluginClassName() {
            return HttpServletPlugin.class.getCanonicalName();
        }
    }

    @ProviderBean
    public static class DoFilterMetricProvider implements Provider {
        @Override
        public Supplier<Interceptor> getInterceptorProvider() {
            return new Supplier<Interceptor>() {
                @Override
                public Interceptor get() {
                    return new DoFilterMetricInterceptor();
                }
            };
        }

        @Override
        public String getAdviceTo() {
            return DoFilterAdvice.class.getCanonicalName()
                + ":default";
        }

        @Override
        public String getPluginClassName() {
            return HttpServletPlugin.class.getCanonicalName();
        }
    }

}