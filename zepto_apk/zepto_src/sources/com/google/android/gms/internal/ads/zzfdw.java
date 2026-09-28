package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfdw implements zzere {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfdz f30910a;

    public zzfdw(zzfdz zzfdzVar) {
        Objects.requireNonNull(zzfdzVar);
        this.f30910a = zzfdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void a(zzcvk zzcvkVar) {
        zzcsw zzcswVar = (zzcsw) zzcvkVar;
        zzfdz zzfdzVar = this.f30910a;
        synchronized (zzfdzVar) {
            try {
                zzcsw zzcswVar2 = zzfdzVar.f30923k;
                if (zzcswVar2 != null) {
                    zzcswVar2.d();
                }
                zzfdzVar.f30923k = zzcswVar;
                zzcir zzcirVar = zzcswVar.f27074l;
                if (zzcirVar != null) {
                    zzcirVar.y0(zzfdzVar);
                }
                zzfdzVar.f30918f.b(new zzcsx(zzcswVar, zzfdzVar, zzfdzVar.f30918f, zzfdzVar.f30920h));
                zzcswVar.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void zza() {
        zzfdz zzfdzVar = this.f30910a;
        synchronized (zzfdzVar) {
            zzfdzVar.f30923k = null;
        }
    }
}
