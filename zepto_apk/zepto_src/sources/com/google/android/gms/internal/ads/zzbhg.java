package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbhg extends CustomTabsCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbhj f25054a;

    public zzbhg(zzbhj zzbhjVar) {
        Objects.requireNonNull(zzbhjVar);
        this.f25054a = zzbhjVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void g(final int i2, Bundle bundle) {
        final zzbhj zzbhjVar = this.f25054a;
        zzbhjVar.getClass();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.n5)).booleanValue() || zzbhjVar.f25060d == null) {
            return;
        }
        ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzdxe zzdxeVar = zzbhjVar.f25060d;
                if (zzdxeVar != null) {
                    zzdxd zzdxdVarA = zzdxeVar.a();
                    zzdxdVarA.b("action", "cct_nav");
                    zzdxdVarA.b("cct_navs", String.valueOf(i2));
                    zzdxdVarA.c();
                }
            }
        });
    }
}
