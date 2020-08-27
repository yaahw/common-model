package com.ynding.cloud.common.model.bo;

/**
 * 服务实例名称
 *
 * @author ynding
 * @version 2020/08/27
 */
public final class CloudServiceInfo {

    /**
     * 构造器私有化
     */
    private CloudServiceInfo() {
        throw new AssertionError();
    }

    /**
     * core-server-bus
     */
    public final static String CORE_SERVER_BUS = "core-server-bus";

    /**
     * book服务
     */
    public final static String PHYSICAL_BOOK_META = "physical-book-meta";
}
