package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfhm implements zzere {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfho f31133a;

    public zzfhm(zzfho zzfhoVar) {
        Objects.requireNonNull(zzfhoVar);
        this.f31133a = zzfhoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void a(zzcvk zzcvkVar) {
        zzfho zzfhoVar = this.f31133a;
        zzdte zzdteVar = (zzdte) zzcvkVar;
        synchronized (zzfhoVar) {
            try {
                zzfhoVar.f31139d = zzdteVar;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.i4)).booleanValue()) {
                    zzdteVar.u.f31197a = zzfhoVar.f31138c;
                }
                zzfhoVar.f31139d.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void zza() {
        zzfho zzfhoVar = this.f31133a;
        synchronized (zzfhoVar) {
            zzfhoVar.f31139d = null;
        }
    }
}
