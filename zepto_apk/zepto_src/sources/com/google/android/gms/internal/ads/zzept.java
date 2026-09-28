package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzept implements zzere {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzepu f30068a;

    public zzept(zzepu zzepuVar) {
        Objects.requireNonNull(zzepuVar);
        this.f30068a = zzepuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void a(zzcvk zzcvkVar) {
        zzcze zzczeVar;
        zzepu zzepuVar = this.f30068a;
        zzctc zzctcVar = (zzctc) zzcvkVar;
        synchronized (zzepuVar) {
            try {
                zzctc zzctcVar2 = zzepuVar.f30077i;
                if (zzctcVar2 != null) {
                    zzcze zzczeVar2 = zzctcVar.f27236j;
                    if (zzczeVar2 != null && (zzczeVar = zzctcVar2.f27236j) != null) {
                        zzczeVar2.a(zzczeVar.f27458a.get());
                    }
                    zzdbj zzdbjVar = zzepuVar.f30077i.f27229c;
                    zzdbjVar.getClass();
                    zzdbjVar.v0(new zzdbh(null));
                }
                zzepuVar.f30077i = zzctcVar;
                zzctcVar.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void zza() {
        zzepu zzepuVar = this.f30068a;
        synchronized (zzepuVar) {
            zzepuVar.f30077i = null;
        }
    }
}
