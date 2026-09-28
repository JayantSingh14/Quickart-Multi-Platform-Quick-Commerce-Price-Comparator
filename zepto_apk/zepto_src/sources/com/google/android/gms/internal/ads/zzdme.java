package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzdme implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f27931a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f27932b;

    public zzdme(zzdmg zzdmgVar, View view) {
        this.f27931a = new WeakReference(zzdmgVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.be)).booleanValue()) {
            this.f27932b = new WeakReference(view);
        } else {
            this.f27932b = new WeakReference(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        String str;
        zzdmg zzdmgVar = (zzdmg) this.f27931a.get();
        if (zzdmgVar == null) {
            return;
        }
        zzdmgVar.f27943g.g();
        zzbgb zzbgbVar = zzbgk.be;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            View view = (View) this.f27932b.get();
            zzdon zzdonVar = zzdmgVar.E;
            zzdonVar.getClass();
            if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() || view == null) {
                return;
            }
            ViewParent parent = view.getParent();
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
            zzdxd zzdxdVarA = zzdonVar.f28118a.a();
            zzdxdVarA.b("action", "hcp");
            zzdxdVarA.b("hcp", str);
            zzdxdVarA.a(zzdmgVar.f27946j);
            zzdxdVarA.c();
        }
    }
}
