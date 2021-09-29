package com.jason.modal;

public class SmsMsg {

    private String msgId;
    private String mobile;
    private String content;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SmsMsg{" +
                "msgId='" + msgId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
