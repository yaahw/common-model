package com.ynding.cloud.common.model.bo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * GET请求参数
 * @author ynding
 * @version 2020/08/27
 */
public class Query extends LinkedHashMap<String, Object> {
    private int page = 1;
    private int limit = 10;
    private int offset = 0;

    /**
     * page
     */
    private final static String PAGE = "page";
    private final static String OFFSET = "offset";
    private final static String START = "start";
    private final static String LIMIT = "limit";
    private final static String FILTER = "filter";


    public Query() {
    }

    public Query(Map<String, Object> params) {
        this.putAll(params);
        if (params.get(PAGE) != null) {
            this.page = Integer.parseInt(params.get(PAGE).toString());
            this.put(PAGE, this.page);
        }

        if (params.get(OFFSET) != null) {
            this.offset = Integer.parseInt(params.get(OFFSET).toString());
            this.put(OFFSET, this.offset);
        }

        if (params.get(START) != null) {
            this.offset = Integer.parseInt(params.get(START).toString());
            this.put(OFFSET, this.offset);
            this.remove(START);
        }

        if (params.get(LIMIT) != null) {
            this.limit = Integer.parseInt(params.get(LIMIT).toString());
            this.put(LIMIT, this.limit);
        }

        if (this.limit > 0) {
            if (params.get(PAGE) != null) {
                this.offset = (this.page - 1) * this.limit;
            } else {
                this.page = this.offset / this.limit + 1;
            }
        }

        if (params.get(FILTER) != null) {
            this.put(FILTER, ((String) params.get(FILTER)).split("[\\s]"));
        }

    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
