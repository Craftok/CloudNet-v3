/*
 * Copyright 2019-2021 CloudNetService team & contributors
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

package de.dytanic.cloudnet.network.listener.cluster;

import de.dytanic.cloudnet.CloudNet;
import de.dytanic.cloudnet.cluster.IClusterNodeServer;
import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.network.INetworkChannel;
import de.dytanic.cloudnet.driver.network.cluster.NetworkClusterNodeInfoSnapshot;
import de.dytanic.cloudnet.driver.network.protocol.IPacket;
import de.dytanic.cloudnet.driver.network.protocol.IPacketListener;
import de.dytanic.cloudnet.event.network.NetworkClusterNodeInfoUpdateEvent;

public final class PacketServerClusterNodeInfoUpdateListener implements IPacketListener {

  @Override
  public void handle(INetworkChannel channel, IPacket packet) {
    NetworkClusterNodeInfoSnapshot snapshot = packet.getBuffer().readObject(NetworkClusterNodeInfoSnapshot.class);
    IClusterNodeServer clusterNodeServer = CloudNet.getInstance().getClusterNodeServerProvider()
      .getNodeServer(snapshot.getNode().getUniqueId());

    if (clusterNodeServer != null) {
      clusterNodeServer.setNodeInfoSnapshot(snapshot);
      CloudNetDriver.getInstance().getEventManager()
        .callEvent(new NetworkClusterNodeInfoUpdateEvent(channel, snapshot));
    }
  }

}
