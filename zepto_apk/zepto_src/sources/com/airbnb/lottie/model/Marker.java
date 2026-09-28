package com.airbnb.lottie.model;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class Marker {

    /* renamed from: a, reason: collision with root package name */
    public final String f14471a;

    /* renamed from: b, reason: collision with root package name */
    public final float f14472b;

    /* renamed from: c, reason: collision with root package name */
    public final float f14473c;

    public Marker(String str, float f2, float f3) {
        this.f14471a = str;
        this.f14473c = f3;
        this.f14472b = f2;
    }

    public final boolean a(String str) {
        String str2 = this.f14471a;
        if (str2.equalsIgnoreCase(str)) {
            return true;
        }
        return str2.endsWith(StringUtils.CR) && str2.substring(0, str2.length() - 1).equalsIgnoreCase(str);
    }
}
