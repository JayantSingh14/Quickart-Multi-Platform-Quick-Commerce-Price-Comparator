package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzapn implements zzapg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeq f24082a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzapq f24083b;

    public zzapn(zzapq zzapqVar) {
        Objects.requireNonNull(zzapqVar);
        this.f24083b = zzapqVar;
        this.f24082a = new zzeq(new byte[4], 4);
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void a(zzfg zzfgVar, zzaer zzaerVar, zzapu zzapuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void b(zzer zzerVar) {
        if (zzerVar.K() != 0 || (zzerVar.K() & 128) == 0) {
            return;
        }
        zzerVar.G(6);
        int iB = zzerVar.B() / 4;
        int i2 = 0;
        while (true) {
            zzapq zzapqVar = this.f24083b;
            if (i2 >= iB) {
                zzapqVar.f24096g.remove(0);
                return;
            }
            zzeq zzeqVar = this.f24082a;
            zzerVar.H(0, zzeqVar.f30084a, 4);
            zzeqVar.d(0);
            int iH = zzeqVar.h(16);
            zzeqVar.f(3);
            if (iH == 0) {
                zzeqVar.f(13);
            } else {
                int iH2 = zzeqVar.h(13);
                if (zzapqVar.f24096g.get(iH2) == null) {
                    zzapqVar.f24096g.put(iH2, new zzaph(new zzapo(zzapqVar, iH2)));
                }
            }
            i2++;
        }
    }
}
