package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzblx extends zzble {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbly f25305a;

    public /* synthetic */ zzblx(zzbly zzblyVar) {
        Objects.requireNonNull(zzblyVar);
        this.f25305a = zzblyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final void Na(zzbks zzbksVar) {
        zzbkt zzbktVar;
        zzbly zzblyVar = this.f25305a;
        com.google.android.gms.ads.formats.zze zzeVar = zzblyVar.f25306a;
        synchronized (zzblyVar) {
            zzbktVar = zzblyVar.f25308c;
            if (zzbktVar == null) {
                zzbktVar = new zzbkt(zzbksVar);
                zzblyVar.f25308c = zzbktVar;
            }
        }
        zzeVar.a(zzbktVar);
    }
}
