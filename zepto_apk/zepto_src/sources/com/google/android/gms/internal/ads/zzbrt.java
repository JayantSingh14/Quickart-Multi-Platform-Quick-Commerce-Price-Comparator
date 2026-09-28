package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzbrt implements zzbqk, zzbrs {

    /* renamed from: a, reason: collision with root package name */
    public final zzbqu f25497a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f25498b = new HashSet();

    public zzbrt(zzbqu zzbquVar) {
        this.f25497a = zzbquVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final void A0(String str, zzbnn zzbnnVar) {
        this.f25497a.A0(str, zzbnnVar);
        this.f25498b.add(new AbstractMap.SimpleEntry(str, zzbnnVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbqk, com.google.android.gms.internal.ads.zzbqv
    public final void a(String str) {
        this.f25497a.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final void x0(String str, zzbnn zzbnnVar) {
        this.f25497a.x0(str, zzbnnVar);
        this.f25498b.remove(new AbstractMap.SimpleEntry(str, zzbnnVar));
    }
}
