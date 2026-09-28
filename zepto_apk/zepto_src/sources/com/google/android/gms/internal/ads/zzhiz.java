package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzhiz {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhiz f33874b = new zzhiz();

    /* renamed from: c, reason: collision with root package name */
    public static final zzhiy f33875c = new zzhiy();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f33876a = new AtomicReference();

    public final zzhir a() {
        zzhir zzhirVar = (zzhir) this.f33876a.get();
        return zzhirVar == null ? f33875c : zzhirVar;
    }
}
