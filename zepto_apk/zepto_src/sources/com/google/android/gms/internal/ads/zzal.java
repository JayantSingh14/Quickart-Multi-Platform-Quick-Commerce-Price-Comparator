package com.google.android.gms.internal.ads;

import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzal {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f23451a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static String f23452b = "media3.common";

    public static synchronized void a(String str) {
        if (f23451a.add(str)) {
            String str2 = f23452b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + str.length());
            sb.append(str2);
            sb.append(", ");
            sb.append(str);
            f23452b = sb.toString();
        }
    }
}
