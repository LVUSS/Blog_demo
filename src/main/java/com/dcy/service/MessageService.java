package com.dcy.service;

import com.dcy.po.Message;

import java.util.List;

public interface MessageService {



    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);






}
