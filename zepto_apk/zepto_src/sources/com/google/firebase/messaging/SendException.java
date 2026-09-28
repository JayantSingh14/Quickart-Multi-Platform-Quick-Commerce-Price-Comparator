package com.google.firebase.messaging;

import java.util.Locale;

/* loaded from: classes4.dex */
public final class SendException extends Exception {
    public SendException(String str) {
        super(str);
        if (str == null) {
            return;
        }
        str.toLowerCase(Locale.US).getClass();
    }
}
