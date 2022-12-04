package com.example.common;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageContext implements Loggable{
    private static MessageContext instance;
    private static final String BUNDLE_NAME = "language/message";
    private ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

    public MessageContext() {
        this.messageSource.setBasenames(new String[]{"language/message"});
        this.messageSource.setDefaultEncoding("UTF-8");
    }

    public static MessageContext getInstance() {
        if (instance == null) {
            instance = new MessageContext();
        }

        return instance;
    }

    public static String getMessage(String key) {
        try {
            return getInstance().getMessageSource() != null ? getInstance().getMessageSource().getMessage(key, (Object[])null, LocaleContextHolder.getLocale()) : key;
        } catch (Exception var2) {
            return key;
        }
    }

    public static String getMessage(String key, Locale locale) {
        try {
            return getInstance().getMessageSource() != null ? getInstance().getMessageSource().getMessage(key, (Object[])null, locale == null ? LocaleContextHolder.getLocale() : locale) : key;
        } catch (Exception var3) {
            return key;
        }
    }

    public static String getMessage(String key, Object[] args) {
        try {
            return getInstance().getMessageSource() != null ? getInstance().getMessageSource().getMessage(key, args, LocaleContextHolder.getLocale()) : key;
        } catch (Exception var3) {
            return key;
        }
    }

    public ResourceBundleMessageSource getMessageSource() {
        return this.messageSource;
    }
}
