package com.google.android.gms.internal.auth;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public abstract class zzdc {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f36319b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f36320a;

    static {
        new AtomicReference();
        f36319b = new AtomicInteger();
    }

    public /* synthetic */ zzdc(zzcz zzczVar, Object obj) {
        if (zzczVar.f36315a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f36320a = obj;
    }
}
