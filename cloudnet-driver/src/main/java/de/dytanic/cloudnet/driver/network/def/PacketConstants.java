package de.dytanic.cloudnet.driver.network.def;

public final class PacketConstants {

    public static final int
            INTERNAL_AUTHORIZATION_CHANNEL = 1,
            INTERNAL_WRAPPER_TO_NODE_INFO_CHANNEL = 2,
            INTERNAL_CALLABLE_CHANNEL = 3,
            INTERNAL_H2_DATABASE_UPDATE_MODULE = 5,
            INTERNAL_DEBUGGING_CHANNEL = 6,
            INTERNAL_DRIVER_API_CHANNEL = 7,
            INTERNAL_DATABASE_API_CHANNEL = 8;

    //cluster
    public static final int
            CLUSTER_SERVICE_INFO_LIST_CHANNEL = 9,
            CLUSTER_GROUP_CONFIG_LIST_CHANNEL = 10,
            CLUSTER_TASK_LIST_CHANNEL = 11,
            CLUSTER_PERMISSION_DATA_CHANNEL = 12,
            CLUSTER_TEMPLATE_DEPLOY_CHANNEL = 13,
            CLUSTER_NODE_INFO_CHANNEL = 14;

    //events
    public static final int
            SERVICE_INFO_PUBLISH_CHANNEL = 15,
            PERMISSIONS_PUBLISH_CHANNEL = 16,
            CHANNEL_MESSAGING_CHANNEL = 17;

    public static final String SYNC_PACKET_CHANNEL_PROPERTY = "synchronized_packet_channel_name", SYNC_PACKET_ID_PROPERTY = "synchronized_packet_id";
    public static final String CLUSTER_NODE_SYNC_PACKET_CHANNEL_NAME = "synchronized_cluster_node_sync_channel";

    private PacketConstants() {
        throw new UnsupportedOperationException();
    }

}