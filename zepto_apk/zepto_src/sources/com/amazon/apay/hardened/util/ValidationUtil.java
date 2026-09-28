package com.amazon.apay.hardened.util;

import android.support.v4.media.b;
import java.net.URI;

/* loaded from: classes3.dex */
public final class ValidationUtil {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str.concat(" cannot be null"));
        }
    }

    public static void b(String str) {
        try {
            c(str, "payUrl");
            URI uri = new URI(str);
            if ("amazonpay.amazon.in".equalsIgnoreCase(uri.getHost()) && "https".equalsIgnoreCase(uri.getScheme())) {
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception unused) {
            throw new IllegalArgumentException(b.D("The supplied pay url (", String.valueOf(str), ") is invalid"));
        }
    }

    public static void c(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(str2.concat(" cannot be null or empty"));
        }
    }
}
