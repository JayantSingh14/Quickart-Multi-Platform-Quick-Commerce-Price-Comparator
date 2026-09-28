package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes4.dex */
public class zzgtl<K, V> extends zzgrx<K, V> implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public final transient zzgtg f33199d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f33200e;

    public zzgtl(zzgtg zzgtgVar, int i2) {
        this.f33199d = zzgtgVar;
        this.f33200e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgrw
    public final Map a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.ads.zzgrw
    public final boolean b(Object obj) {
        return obj != null && super.b(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgrw, com.google.android.gms.internal.ads.zzgul
    public /* synthetic */ Map c() {
        return this.f33199d;
    }
}
