package io.pumelo.im.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.web.socket.TextMessage;

import java.util.UUID;

@Data
public class Message {
    private String messageId;
    private String code="0";
    private String msgType;//SYS ,USER ,GROUP,HEART
    private String contentType;//内容类型, //PICTURE,TEXT,FILE,ASKUSER,ASKGROUP
    private String content;
    private String from;
    private String to;//由类型决定是好友消息还是群组消息
    private long sentAt;//发送时间

    public static Message makeHeartMsg(){
        Message message = new Message();
        message.msgType = "HEART";
        message.from = "SYS";
        message.sentAt = System.currentTimeMillis();
        return message;
    }

    public static Message makeSysMsg(String to,String content,String contentType,String code){
        Message message = new Message();
        message.messageId = UUID.randomUUID().toString();
        message.msgType = "SYS";
        message.from = "SYS";
        message.sentAt = System.currentTimeMillis();
        message.to = to;
        message.content = content;
        message.contentType =contentType;
        message.code = code;
        return message;
    }

    public static Message makeUserMsg(String from, String to,String content,String contentType){
        Message message = new Message();
        message.messageId = UUID.randomUUID().toString();
        message.msgType = "USER";
        message.sentAt = System.currentTimeMillis();
        message.from =from;
        message.to = to;
        message.content = content;
        message.contentType =contentType;
        return message;
    }

    public static Message makeGroupMsg(String from, String to,String content,String contentType){
        Message message = new Message();
        message.messageId = UUID.randomUUID().toString();
        message.msgType = "GROUP";
        message.sentAt = System.currentTimeMillis();
        message.from =from;
        message.to = to;
        message.content = content;
        message.contentType =contentType;
        return message;
    }

    public String toJSON(){
        return JSON.toJSONString(this);
    }

    public TextMessage toTextMessage(){
        return new TextMessage(this.toJSON());
    }

    /**
     * 检查消息体
     * @return
     */
    public boolean check(){
        return true;
    }

    /**
     * 把消息体拼装完整
     * @param from
     */
    public void makeComplete(String from){
        this.sentAt = System.currentTimeMillis();
        this.messageId = UUID.randomUUID().toString();
        this.from = from;
    }
}
