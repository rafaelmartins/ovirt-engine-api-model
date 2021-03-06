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

package services;

import annotations.Area;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import types.Cluster;
import types.StorageDomain;
import types.Template;
import types.Vm;

@Service
@Area("Storage")
public interface StorageDomainTemplateService {
    interface Get {
        @Out Template template();
    }

    /**
     * Action to import a template from an export storage domain.
     *
     * For example, to import the template `456` from the storage domain `123` send the following request:
     *
     * [source]
     * ----
     * POST /ovirt-engine/api/storagedomains/123/templates/456/import
     * ----
     *
     * With the following request body:
     *
     * [source, xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>myexport</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </action>
     * ----
     *
     * @author Amit Aviram <aaviram@redhat.com>
     * @date 16 Sep 2016
     * @status added
     */
    interface Import {
        /**
         * Use the optional `clone` parameter to generate new UUIDs for the imported template and its entities.
         *
         * The user might want to import a template with the `clone` parameter set to `false` when importing a template
         * from an export domain, with templates that was exported by a different {product-name} environment.
         *
         * @author Amit Aviram <aaviram@redhat.com>
         * @date 16 Sep 2016
         * @status added
         */
        @In Boolean clone();
        @In Cluster cluster();
        @In Boolean exclusive();
        @In StorageDomain storageDomain();
        @In Template template();
        @In Vm vm();

        /**
         * Indicates if the import should be performed asynchronously.
         */
        @In Boolean async();
    }

    interface Register {
        @In Boolean clone();
        @In Cluster cluster();
        @In Boolean exclusive();
        @In Template template();

        /**
         * Indicates whether a template is allowed to be registered with only some of its disks.
         *
         * If this flag is `true`, the engine will not fail in the validation process if an image is not found, but
         * instead it will allow the template to be registered without the missing disks. This is mainly used during
         * registration of a template when some of the storage domains are not available. The default value is `false`.
         *
         * @author Maor Lipchuk <mlipchuk@redhat.com>
         * @date 17 Nov 2016
         * @status added
         * @since 4.1
         */
        @In Boolean allowPartialImport();

        /**
         * Indicates if the registration should be performed asynchronously.
         */
        @In Boolean async();
    }

    interface Remove {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        @In Boolean async();
    }

    @Service StorageDomainContentDisksService disks();
}
