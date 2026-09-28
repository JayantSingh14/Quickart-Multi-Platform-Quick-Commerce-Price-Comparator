package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdgl implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdgk f27748a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijs f27749b;

    public zzdgl(zzdgk zzdgkVar, zzijs zzijsVar) {
        this.f27748a = zzdgkVar;
        this.f27749b = zzijsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Set setZzb = this.f27749b.zzb();
        zzdgk zzdgkVar = this.f27748a;
        if (zzdgkVar.p == null) {
            zzdgkVar.p = new zzdam(setZzb);
        }
        zzdam zzdamVar = zzdgkVar.p;
        zzijo.a(zzdamVar);
        return zzdamVar;
    }
}
