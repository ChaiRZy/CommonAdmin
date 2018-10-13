package com.qfedu.commonadmin.vo;

import com.qfedu.commonadmin.domain.Permission;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/14 15:49
 */
public class MenuVo {
    private Permission parent;
    private List<Permission> childrens;

    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }

    public List<Permission> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Permission> childrens) {
        this.childrens = childrens;
    }
}
