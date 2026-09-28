package com.google.android.gms.internal.ads;

import android.graphics.Color;

/* loaded from: classes4.dex */
final class zzamr {

    /* renamed from: a, reason: collision with root package name */
    public final String f23631a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23632b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f23633c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f23634d;

    /* renamed from: e, reason: collision with root package name */
    public final float f23635e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f23636f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f23637g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f23638h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f23639i;

    /* renamed from: j, reason: collision with root package name */
    public final int f23640j;

    public zzamr(String str, int i2, Integer num, Integer num2, float f2, boolean z, boolean z2, boolean z3, boolean z4, int i3) {
        this.f23631a = str;
        this.f23632b = i2;
        this.f23633c = num;
        this.f23634d = num2;
        this.f23635e = f2;
        this.f23636f = z;
        this.f23637g = z2;
        this.f23638h = z3;
        this.f23639i = z4;
        this.f23640j = i3;
    }

    public static Integer a(String str) {
        try {
            long j2 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzgqa.a(j2 <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgwx.a(((j2 >> 24) & 255) ^ 255), zzgwx.a(j2 & 255), zzgwx.a((j2 >> 8) & 255), zzgwx.a((j2 >> 16) & 255)));
        } catch (IllegalArgumentException e2) {
            zzee.d("SsaStyle", android.support.v4.media.b.s(new StringBuilder(String.valueOf(str).length() + 36), "Failed to parse color expression: '", str, "'"), e2);
            return null;
        }
    }

    public static boolean b(String str) throws NumberFormatException {
        try {
            int i2 = Integer.parseInt(str);
            return i2 == 1 || i2 == -1;
        } catch (NumberFormatException e2) {
            zzee.d("SsaStyle", android.support.v4.media.b.s(new StringBuilder(String.valueOf(str).length() + 33), "Failed to parse boolean value: '", str, "'"), e2);
            return false;
        }
    }
}
