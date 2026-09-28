package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public class zzfw {

    /* renamed from: a, reason: collision with root package name */
    public final int f31964a;

    public static String a(int i2) {
        char c2 = (char) ((i2 >> 24) & 255);
        char c3 = (char) ((i2 >> 16) & 255);
        char c4 = (char) ((i2 >> 8) & 255);
        char c5 = (char) (i2 & 255);
        StringBuilder sb = new StringBuilder(android.support.v4.media.b.b(String.valueOf(c2).length(), String.valueOf(c3).length(), String.valueOf(c4).length(), String.valueOf(c5).length()));
        sb.append(c2);
        sb.append(c3);
        sb.append(c4);
        sb.append(c5);
        return sb.toString();
    }

    public String toString() {
        return a(this.f31964a);
    }
}
