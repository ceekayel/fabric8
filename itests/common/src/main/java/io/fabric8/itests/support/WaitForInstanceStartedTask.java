/**
 *  Copyright 2005-2014 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.itests.support;

import java.util.concurrent.Callable;

import org.apache.karaf.admin.AdminService;
import org.apache.karaf.admin.Instance;
import org.jboss.gravia.runtime.ModuleContext;
import org.jboss.gravia.runtime.RuntimeLocator;
import org.jboss.gravia.runtime.ServiceLocator;

/**
 * A {@link java.util.concurrent.Callable} that waits for the {@link io.fabric8.api.Container} to get created.
 */
public class WaitForInstanceStartedTask implements Callable<Boolean> {

    private final AdminService adminService;
    private final Long provisionTimeOut;
    private final String name;

    public WaitForInstanceStartedTask(String name, Long provisionTimeOut) {
        ModuleContext moduleContext = RuntimeLocator.getRequiredRuntime().getModuleContext();
        this.adminService = ServiceLocator.awaitService(moduleContext, AdminService.class);
        this.provisionTimeOut = provisionTimeOut;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        for (long t = 0; (!instanceStarted() && t < provisionTimeOut); t += 2000L) {
            Thread.sleep(2000L);
            System.out.println("Instance:" + name + " Started:" + instanceStarted());
        }
        return instanceStarted();
    }

    private boolean instanceStarted() {
        try {
            String state = adminService.getInstance(name).getState();
            return Instance.STARTED.equals(state);
        } catch (Exception ex) {
            return false;
        }
    }
}
