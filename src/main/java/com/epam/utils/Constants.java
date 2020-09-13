package com.epam.utils;

import com.epam.model.MessageEntity;
import com.epam.model.UserEntity;
import com.epam.utils.json.JsonParser;
import com.epam.utils.properties.ConfigProperties;
import com.epam.utils.providers.MessageEntityProvider;

import java.util.List;
import java.util.Objects;

public interface Constants {
    String DRIVER_NAME = ConfigProperties.getDriverName();
    String DRIVER_PATH = ConfigProperties.getDriverPath();
    String BASE_URL = ConfigProperties.getBaseUrl();
    int TIME_WAIT = ConfigProperties.getTimeWait();
    int EXPLICIT_WAIT = ConfigProperties.getExplicitWait();

    List<UserEntity> USERS = Objects.requireNonNull(JsonParser.getGmailJsonEntity()).getUsers();

    MessageEntity TEST_MESSAGE = MessageEntityProvider.getMessageEntity();
    String TEST_RECEIVER_EMAIL = TEST_MESSAGE.getReceiver();
    String TEST_CC_EMAIL = TEST_MESSAGE.getCc();
    String TEST_BCC_EMAIL = TEST_MESSAGE.getBcc();
    String TEST_LETTER_TOPIC = TEST_MESSAGE.getTopic();
    String TEST_LETTER_TEXT = TEST_MESSAGE.getLetterText();

    String WRONG_LOGIN = "Wrong login.";
    String WRONG_SAVED_DRAFT = "Fields of last draft letter doesn't saved properly.";
}