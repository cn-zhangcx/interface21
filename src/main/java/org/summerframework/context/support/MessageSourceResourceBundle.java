/*
 * Copyright (c) 2011-2025 PiChen
 */

package org.summerframework.context.support;

import java.util.ResourceBundle;
import java.util.Enumeration;
import java.util.Locale;

import org.summerframework.context.MessageSource;
import org.summerframework.context.NoSuchMessageException;

/**
 * Allows for accessing a MessageSource as a ResourceBundle.
 *
 * @author Juergen Hoeller
 * @since 27.02.2003
 */
public class MessageSourceResourceBundle extends ResourceBundle {

    private MessageSource source;
    private Locale locale;

    public MessageSourceResourceBundle(MessageSource source, Locale locale) {
        this.source = source;
        this.locale = locale;
    }

    protected Object handleGetObject(String code) {
        try {
            return source.getMessage(code, null, locale);
        } catch (NoSuchMessageException e) {
            return null;
        }
    }

    public Enumeration getKeys() {
        return null;
    }
}