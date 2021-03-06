/*
Copyright (c) 2016 Red Hat, Inc.

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

package types;

import org.ovirt.api.metamodel.annotations.Type;

@Type
public enum StorageFormat {
    V1,
    V2,
    V3,

    /**
     * Version 4 of the storage domain format.
     *
     * @author Maor Lipchuk <mlipchuk@redhat.com>
     * @date 14 Dec 2016
     * @status added
     * @since 4.1
     */
    V4;
}
