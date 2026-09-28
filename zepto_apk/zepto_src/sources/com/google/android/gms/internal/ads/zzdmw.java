package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdmw implements zzbck {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f27985a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdnh f27986b;

    public zzdmw(zzdnh zzdnhVar, String str) {
        this.f27985a = str;
        Objects.requireNonNull(zzdnhVar);
        this.f27986b = zzdnhVar;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    @Override // com.google.android.gms.internal.ads.zzbck
    public final void u0(zzbcj zzbcjVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.e2)).booleanValue()) {
            if (zzbcjVar.f24707j) {
                zzdnh zzdnhVar = this.f27986b;
                if (zzdnhVar.w != null) {
                    zzdnhVar.H.put(this.f27985a, Boolean.TRUE);
                    ?? r0 = zzdnhVar.w;
                    if (r0 == 0) {
                        return;
                    }
                    zzdnhVar.t(r0.Z8(), r0.zzj(), r0.zzk(), true);
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this) {
            try {
                if (zzbcjVar.f24707j) {
                    zzdnh zzdnhVar2 = this.f27986b;
                    if (zzdnhVar2.w != null) {
                        zzdnhVar2.H.put(this.f27985a, Boolean.TRUE);
                        ?? r02 = zzdnhVar2.w;
                        if (r02 == 0) {
                        } else {
                            zzdnhVar2.t(r02.Z8(), zzdnhVar2.w.zzj(), zzdnhVar2.w.zzk(), true);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
