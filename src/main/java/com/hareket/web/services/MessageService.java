package com.hareket.web.services;

import antlr.debug.MessageAdapter;
import com.hareket.web.model.Message;
import com.hareket.web.model.Region;
import com.hareket.web.repository.CompanyRepository;
import com.hareket.web.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message findById(Integer id) {
        return messageRepository.findById(id).get ();
    }

    public List<Message> findAll() {
        List<Message> list = new ArrayList<> ();
        messageRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public Message save(Message company) {
        return messageRepository.save (company);
    }

    public void delete(Message company) {
        messageRepository.delete (company);
    }

    public void deleteById(Integer id) {
        messageRepository.deleteById (id);
    }

    public List<Message> getAll() { return messageRepository.getAll ();}
}
