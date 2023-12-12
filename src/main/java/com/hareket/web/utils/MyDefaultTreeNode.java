package com.hareket.web.utils;

import com.hareket.web.controller.MessageController;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;

public class MyDefaultTreeNode extends DefaultTreeNode {
    private String code = "";

    public MyDefaultTreeNode(String code, String data, TreeNode parent) {
        super(data, parent);
        this.code = code;
    }

    public MyDefaultTreeNode(MyDefaultTreeNodeObj data, TreeNode parent) {
        super(data, parent);
        this.code = code;
    }

    public void addChildren(DefaultTreeNode child) {
        this.getChildren ().add (child);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
