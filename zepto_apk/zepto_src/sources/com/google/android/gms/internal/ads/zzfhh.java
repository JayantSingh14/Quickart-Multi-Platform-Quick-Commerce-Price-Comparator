package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfhh implements zzere {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfhi f31114a;

    public zzfhh(zzfhi zzfhiVar) {
        Objects.requireNonNull(zzfhiVar);
        this.f31114a = zzfhiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void a(zzcvk zzcvkVar) {
        zzfhi zzfhiVar = this.f31114a;
        zzdte zzdteVar = (zzdte) zzcvkVar;
        synchronized (zzfhiVar) {
            try {
                zzfhiVar.f31123j = zzdteVar;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.i4)).booleanValue()) {
                    zzdteVar.u.f31197a = zzfhiVar.f31118e;
                }
                zzfhiVar.f31123j.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void zza() {
        zzfhi zzfhiVar = this.f31114a;
        synchronized (zzfhiVar) {
            zzfhiVar.f31123j = null;
        }
    }
}
