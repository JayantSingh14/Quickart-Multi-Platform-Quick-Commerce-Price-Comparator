package io.sentry.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface PropertiesProvider {
    default Long a(String str) {
        String strB = b(str);
        if (strB == null) {
            return null;
        }
        try {
            return Long.valueOf(strB);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    String b(String str);

    Map c();

    default Double d(String str) {
        String strB = b(str);
        if (strB == null) {
            return null;
        }
        try {
            return Double.valueOf(strB);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    default List e(String str) {
        String strB = b(str);
        return strB != null ? Arrays.asList(strB.split(",")) : Collections.EMPTY_LIST;
    }

    default Boolean f(String str) {
        String strB = b(str);
        if (strB != null) {
            return Boolean.valueOf(strB);
        }
        return null;
    }
}
