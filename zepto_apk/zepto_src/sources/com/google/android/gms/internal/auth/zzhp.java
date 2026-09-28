package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* loaded from: classes4.dex */
public enum zzhp {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzef.f36336b),
    ENUM(null),
    MESSAGE(null);


    /* renamed from: a, reason: collision with root package name */
    public final Serializable f36443a;

    zzhp(Serializable serializable) {
        this.f36443a = serializable;
    }
}
