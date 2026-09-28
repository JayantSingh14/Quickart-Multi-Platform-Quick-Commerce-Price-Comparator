package com.google.android.gms.internal.atv_ads_framework;

import java.io.Serializable;

/* loaded from: classes4.dex */
public enum zzds {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(zzcn.class, zzcn.f36095b),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* renamed from: a, reason: collision with root package name */
    public final Serializable f36138a;

    zzds(Class cls, Serializable serializable) {
        this.f36138a = serializable;
    }
}
