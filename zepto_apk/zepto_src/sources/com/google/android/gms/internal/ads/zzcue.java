package com.google.android.gms.internal.ads;

import android.view.ViewParent;

/* loaded from: classes4.dex */
public final class zzcue implements zzdbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzcir f27161a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxe f27162b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhr f27163c;

    public zzcue(zzcir zzcirVar, zzdxe zzdxeVar, zzfhr zzfhrVar) {
        this.f27161a = zzcirVar;
        this.f27162b = zzdxeVar;
        this.f27163c = zzfhrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        zzcir zzcirVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.be)).booleanValue() || (zzcirVar = this.f27161a) == null) {
            return;
        }
        ViewParent parent = zzcirVar.x().getParent();
        while (true) {
            if (parent == null) {
                str = "0";
                break;
            } else {
                if (parent.getClass().getName().startsWith("androidx.compose.ui")) {
                    str = "1";
                    break;
                }
                parent = parent.getParent();
            }
        }
        zzdxd zzdxdVarA = this.f27162b.a();
        zzdxdVarA.b("action", "hcp");
        zzdxdVarA.b("hcp", str);
        zzdxdVarA.a(this.f27163c);
        zzdxdVarA.c();
    }
}
