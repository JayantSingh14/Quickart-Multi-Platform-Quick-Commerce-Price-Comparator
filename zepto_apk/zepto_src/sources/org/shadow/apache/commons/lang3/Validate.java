package org.shadow.apache.commons.lang3;

/* loaded from: classes5.dex */
public class Validate {
    public static void a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
    }
}
