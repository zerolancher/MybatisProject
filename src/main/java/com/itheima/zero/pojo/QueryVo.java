package com.itheima.zero.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * 把list集合或者数组放入pojo中，然后把pojo传入mybatis
 */
public class QueryVo {

    private List<Integer> idsList;

    private Integer[] idsArray;

    public List<Integer> getIdsList() {
        return idsList;
    }

    public void setIdsList(List<Integer> idsList) {
        this.idsList = idsList;
    }

    public Integer[] getIdsArray() {
        return idsArray;
    }

    public void setIdsArray(Integer[] idsArray) {
        this.idsArray = idsArray;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "idsList=" + idsList +
                ", idsArray=" + Arrays.toString(idsArray) +
                '}';
    }
}
