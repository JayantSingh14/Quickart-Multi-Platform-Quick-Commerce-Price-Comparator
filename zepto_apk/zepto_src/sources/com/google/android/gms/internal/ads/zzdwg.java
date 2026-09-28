package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
public final class zzdwg implements zzfmv {

    /* renamed from: a, reason: collision with root package name */
    public final Map f28658a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbfj f28659b;

    public zzdwg(zzbfj zzbfjVar, Map map) {
        this.f28658a = map;
        this.f28659b = zzbfjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void c(zzfmo zzfmoVar, String str) {
        Map map = this.f28658a;
        if (map.containsKey(zzfmoVar)) {
            this.f28659b.b(((zzdwf) map.get(zzfmoVar)).f28655a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void j(zzfmo zzfmoVar, String str, Throwable th) {
        Map map = this.f28658a;
        if (map.containsKey(zzfmoVar)) {
            this.f28659b.b(((zzdwf) map.get(zzfmoVar)).f28657c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void t(zzfmo zzfmoVar, String str) {
        Map map = this.f28658a;
        if (map.containsKey(zzfmoVar)) {
            this.f28659b.b(((zzdwf) map.get(zzfmoVar)).f28656b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void m(String str) {
    }
}
