package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* loaded from: classes4.dex */
public enum zzadj {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(zzaby.class, zzaby.f37363b),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* renamed from: a, reason: collision with root package name */
    public final Serializable f37423a;

    zzadj(Class cls, Serializable serializable) {
        this.f37423a = serializable;
    }
}
