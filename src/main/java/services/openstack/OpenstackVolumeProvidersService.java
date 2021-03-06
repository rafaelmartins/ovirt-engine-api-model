/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package services.openstack;

import annotations.Area;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import types.OpenStackVolumeProvider;

@Service
@Area("Storage")
public interface OpenstackVolumeProvidersService {
    /**
     * Adds a new volume provider.
     *
     * For example:
     *
     * [source]
     * ----
     * POST /ovirt-engine/api/openstackvolumeproviders
     * ----
     *
     * With a request body like this:
     *
     * [source,xml]
     * ----
     * <openstack_volume_provider>
     *   <name>mycinder</name>
     *   <url>https://mycinder.example.com:8776</url>
     *   <data_center>
     *     <name>mydc</name>
     *   </data_center>
     *   <requires_authentication>true</requires_authentication>
     *   <username>admin</username>
     *   <password>mypassword</password>
     *   <tenant_name>mytenant</tenant_name>
     * </openstack_volume_provider>
     * ----
     *
     * @author Daniel Erez <derez@redhat.com>
     * @date 14 Sep 2016
     * @status added
     */
    interface Add {
        @In @Out OpenStackVolumeProvider provider();
    }

    /**
     * Retrieves the list of volume providers.
     *
     * @author Daniel Erez <derez@redhat.com>
     * @date 14 Sep 2016
     * @status added
     */
    interface List {
        @Out OpenStackVolumeProvider[] providers();

        /**
         * Sets the maximum number of providers to return. If not specified all the providers are returned.
         */
        @In Integer max();
    }

    @Service OpenstackVolumeProviderService provider(String id);
}
