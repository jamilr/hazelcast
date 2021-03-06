/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client;

import com.hazelcast.nio.Address;
import com.hazelcast.spi.InvocationBuilder;
import com.hazelcast.spi.Operation;

/**
 * @author mdogan 5/13/13
 */
public abstract class InvocationClientRequest extends ClientRequest {

    final void process() throws Exception {
        invoke();
    }

    protected abstract void invoke();

    protected final InvocationBuilder createInvocationBuilder(String serviceName, Operation op, final int partitionId) {
        return clientEngine.createInvocationBuilder(serviceName, op, partitionId);
    }

    protected final InvocationBuilder createInvocationBuilder(String serviceName, Operation op, Address target) {
        return clientEngine.createInvocationBuilder(serviceName, op, target);
    }

}
