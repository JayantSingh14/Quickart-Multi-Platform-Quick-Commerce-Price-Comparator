package org.shadow.apache.commons.lang3;

/* loaded from: classes5.dex */
public class CharUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f57701a = new String[128];

    static {
        char c2 = 0;
        while (true) {
            String[] strArr = f57701a;
            if (c2 >= strArr.length) {
                return;
            }
            strArr[c2] = String.valueOf(c2);
            c2 = (char) (c2 + 1);
        }
    }
}
