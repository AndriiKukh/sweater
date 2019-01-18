package com.example.sweater.controller;

import com.example.sweater.AmazonS3.S3Services;
import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.repos.MessageRepo;
import com.example.sweater.repos.UserRepo;
import com.example.sweater.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MessageService messageService;
    @Autowired
    private S3Services s3Services;
    @Value("${jsa.s3.uploadfile}")
    private String uploadFilePath;
    @Value("${jsa.s3.key}")
    private String downloadKey;

    @GetMapping("/")
    public String greeting(){

        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Message> messages = messageRepo.findAll();
        if(filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        } else{
            messages = messageRepo.findAll();
        }
        List<Message> messageList = messageService.sortMessage(messages);
        model.addAttribute("messages", messageList);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Message message,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {
                message.setAuthor(user);

                if(bindingResult.hasErrors()){
                    Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

                    model.mergeAttributes(errorsMap);
                    model.addAttribute("message", message);
                }else {
                    if (file != null && !file.getOriginalFilename().isEmpty()) {
                        File uploadDir = new File(uploadPath);

                        if (!uploadDir.exists()) {
                            uploadDir.mkdir();
                        }

                        String uuidFile = UUID.randomUUID().toString();
                        String resultFilename = uuidFile + "." + file.getOriginalFilename();

                        file.transferTo(new File(uploadPath + "/" + resultFilename));
                        message.setFilename(resultFilename);
                    }

                    model.addAttribute("message", null);
                    messageRepo.save(message);
                }
        Iterable<Message> messages = messageRepo.findAll();
        List<Message> messageList = messageService.sortMessage(messages);
        model.addAttribute("messages", messageList);
        return "main";
    }
}
