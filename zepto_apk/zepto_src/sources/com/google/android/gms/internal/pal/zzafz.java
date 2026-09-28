package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* loaded from: classes4.dex */
public enum zzafz {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzaby.f37363b),
    ENUM(null),
    MESSAGE(null);


    /* renamed from: a, reason: collision with root package name */
    public final Serializable f37518a;

    zzafz(Serializable serializable) {
        this.f37518a = serializable;
    }
}
