package com.example.sweater.service;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MessageService {

    public List<Message> sortMessage(Iterable<Message> messages) {
        List<Message> messageList = StreamSupport
                .stream(messages.spliterator(), false)
                .collect(Collectors.toList());
        Collections.sort(messageList, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        return messageList;
    }
}
