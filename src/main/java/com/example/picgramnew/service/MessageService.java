package com.example.picgramnew.service;


import com.example.picgramnew.model.Message;
import com.example.picgramnew.model.User;
import com.example.picgramnew.repository.MessageRepository;
import com.example.picgramnew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;

    }

    private MessageRepository messageRepository;

    private UserRepository userRepository;




    public List<Message> getAllMessage() {
        List<Message> message = messageRepository.findAll();
        return message;

    }

    public Message getMessages(@PathVariable Long messageId) {
        Message message = (Message) messageRepository.getById(messageId);
        return  message;
    }

    public Message createMessage(Message body) {
        return (Message) messageRepository.save(body);
    }

    public Message updateMessages(@PathVariable(value = "messageId") Long messageId, @RequestBody Message body) {
        Message message = (Message) messageRepository.getById(messageId);
        message.setUser_Name(body.getUser_Name());
        return (Message) userRepository.save(message);
    }

    public String deleteMessages(@PathVariable(value = "messageId") Long messageId) {
        messageRepository.deleteById(messageId);
        return "deleted Message " + messageId;
    }
}
