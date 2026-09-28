package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzblw extends zzblb {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbly f25304a;

    public /* synthetic */ zzblw(zzbly zzblyVar) {
        Objects.requireNonNull(zzblyVar);
        this.f25304a = zzblyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void K7(zzbks zzbksVar, String str) {
        zzbkt zzbktVar;
        zzbly zzblyVar = this.f25304a;
        if (zzblyVar.f25307b == null) {
            return;
        }
        synchronized (zzblyVar) {
            zzbktVar = zzblyVar.f25308c;
            if (zzbktVar == null) {
                zzbktVar = new zzbkt(zzbksVar);
                zzblyVar.f25308c = zzbktVar;
            }
        }
        zzblyVar.f25307b.c(zzbktVar, str);
    }
}
