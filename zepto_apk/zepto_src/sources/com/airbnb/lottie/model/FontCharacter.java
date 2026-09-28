package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import androidx.fragment.app.e;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class FontCharacter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14461a;

    /* renamed from: b, reason: collision with root package name */
    public final char f14462b;

    /* renamed from: c, reason: collision with root package name */
    public final double f14463c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14464d;

    /* renamed from: e, reason: collision with root package name */
    public final String f14465e;

    public FontCharacter(ArrayList arrayList, char c2, double d2, String str, String str2) {
        this.f14461a = arrayList;
        this.f14462b = c2;
        this.f14463c = d2;
        this.f14464d = str;
        this.f14465e = str2;
    }

    public static int a(char c2, String str, String str2) {
        return str2.hashCode() + e.e(c2 * 31, 31, str);
    }

    public final int hashCode() {
        return a(this.f14462b, this.f14465e, this.f14464d);
    }
}
