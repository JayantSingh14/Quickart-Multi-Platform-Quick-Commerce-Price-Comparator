package org.xbill.DNS.dnssec;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes5.dex */
public final class R {
    private static ResourceBundle rb;
    private static boolean useNeutral;

    private R() {
    }

    public static String get(String str, Object... objArr) {
        if (useNeutral) {
            return getNeutral(str, objArr);
        }
        try {
            if (rb == null) {
                rb = ResourceBundle.getBundle("messages");
            }
            return MessageFormat.format(rb.getString(str), objArr);
        } catch (MissingResourceException unused) {
            return getNeutral(str, objArr);
        }
    }

    private static String getNeutral(String str, Object[] objArr) {
        StringBuilder sb = new StringBuilder(str);
        for (Object obj : objArr) {
            sb.append(":");
            sb.append(obj);
        }
        return sb.toString();
    }

    public static void setBundle(ResourceBundle resourceBundle) {
        rb = resourceBundle;
    }

    public static void setUseNeutralMessages(boolean z) {
        useNeutral = z;
    }
}
