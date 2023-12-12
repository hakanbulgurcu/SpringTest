package com.hareket.web.controller;

import com.hareket.web.model.Message;
import com.hareket.web.services.MessageService;
import com.hareket.web.utils.JSFUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Scope("session")
@Controller("msgs")
public class MessageController {

    private static Map<String, Map<String, String>> messages;

    @Autowired
    MessageService messageService;

    @PostConstruct
    public void init() {
        for(Message msg : messageService.getAll ()) {
            addMessage (msg.getTextId (),  "tr", msg.getTurkish ());
            addMessage (msg.getTextId (),  "en", msg.getEnglish ());
        }

    }

    public static String getText(String textId) {
        if(messages.containsKey (textId)) {
            String value = getMessage (textId, JSFUtils.getViewRoot ().getLocale ().getLanguage ());
            if(value != null) {
                return value;
            } else {
                return "Tercüme Edilmemiş";
            }
        } else {
            return 	"Id Tanımlı Değil";
        }
    }

    public String getText(String textId, Map<String, String> params) {
        String msg = getText (textId);

        for(String param : params.keySet()) {
            msg.replace(param, params.get(param));
        }

        return msg;
    }

    public void addMessage(String code, String language, String msg) {
        if (messages == null)
            messages = new HashMap<String, Map<String, String>> ();

        Map<String, String> data = messages.get(code);
        if (data == null) {
            data = new HashMap<String, String>();
            messages.put(code, data);
        }

        data.put(language, msg);
    }

    public static String getMessage(String code, String language) {
        Map<String, String> data = messages.get(code);
        return data != null ? data.get(language) : null;
    }
}