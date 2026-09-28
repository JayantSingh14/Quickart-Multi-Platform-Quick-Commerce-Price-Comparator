package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzexn implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30535a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30536b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f30537c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30538d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f30539e;

    public zzexn(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f30535a = str;
        this.f30536b = z;
        this.f30537c = z2;
        this.f30538d = z3;
        this.f30539e = z4;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        String str = this.f30535a;
        if (!str.isEmpty()) {
            bundle.putString("inspector_extras", str);
        }
        boolean z = this.f30536b;
        bundle.putInt("test_mode", z ? 1 : 0);
        boolean z2 = this.f30537c;
        bundle.putInt("linked_device", z2 ? 1 : 0);
        if (z || z2) {
            zzbgb zzbgbVar = zzbgk.qa;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                bundle.putInt("risd", !this.f30538d ? 1 : 0);
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.ua)).booleanValue()) {
                bundle.putBoolean("collect_response_logs", this.f30539e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zzb(Object obj) {
        Bundle bundle = ((zzczm) obj).f27482b;
        String str = this.f30535a;
        if (!str.isEmpty()) {
            bundle.putString("inspector_extras", str);
        }
        boolean z = this.f30536b;
        bundle.putInt("test_mode", z ? 1 : 0);
        boolean z2 = this.f30537c;
        bundle.putInt("linked_device", z2 ? 1 : 0);
        if (z || z2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ua)).booleanValue()) {
                bundle.putBoolean("collect_response_logs", this.f30539e);
            }
        }
    }
}
