package com.epam.utils.providers;

import com.epam.model.MessageEntity;
import com.epam.utils.json.JsonParser;

import java.util.Objects;
import java.util.Random;

public class MessageEntityProvider {
    public static MessageEntity message;
    private static final int MINIMUM = 0;

    public static MessageEntity getMessageEntity() {
        message = Objects.requireNonNull(JsonParser.getGmailJsonEntity()).getMessage();
        message.setLetterText(message.getLetterText() +
                new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM);
        return message;
    }
}
