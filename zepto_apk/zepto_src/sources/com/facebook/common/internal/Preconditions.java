package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public final class Preconditions {
    public static void a(Boolean bool) {
        if (!bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void c(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(f(str, objArr));
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(str));
        }
    }

    public static void e(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static String f(String str, Object... objArr) {
        int iIndexOf;
        StringBuilder sb = new StringBuilder((objArr.length * 16) + str.length());
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (iIndexOf = str.indexOf("%s", i3)) != -1) {
            sb.append(str.substring(i3, iIndexOf));
            sb.append(objArr[i2]);
            i3 = iIndexOf + 2;
            i2++;
        }
        sb.append(str.substring(i3));
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i4 = i2 + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
