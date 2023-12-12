package com.hareket.web.utils;

import com.hareket.web.controller.MessageController;
import org.springframework.beans.factory.annotation.Autowired;

public class MyDefaultTreeNodeObj {
    private String code;
    private String textId;
    private boolean authority = false;

    /**
     * @param code
     * @param textId
     * @param authority
     */
    public MyDefaultTreeNodeObj(String code, String textId, boolean authority) {
        this.textId = textId;
        this.code = code;
        this.authority = authority;
    }

    public MyDefaultTreeNodeObj(String code, String textId) {
        this.textId = textId;
        this.code = code;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @return the textId
     */
    public String getTextId() {
        return textId;
    }
    /**
     * @param textId the textId to set
     */
    public void setId(String textId) {
        this.textId = textId;
    }
    /**
     * @return the authority
     */
    public boolean isAuthority() {
        return authority;
    }
    /**
     * @param authority the authority to set
     */
    public void setAuthority(boolean authority) {
        this.authority = authority;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MessageController.getText(textId);
    }
}
