package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzcux implements zzdby, zzdbe {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27186a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcir f27187b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhr f27188c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f27189d;

    /* renamed from: e, reason: collision with root package name */
    public zzejb f27190e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f27191f;

    /* renamed from: g, reason: collision with root package name */
    public final zzeiz f27192g;

    public zzcux(Context context, zzcir zzcirVar, zzfhr zzfhrVar, VersionInfoParcel versionInfoParcel, zzeiz zzeizVar) {
        this.f27186a = context;
        this.f27187b = zzcirVar;
        this.f27188c = zzfhrVar;
        this.f27189d = versionInfoParcel;
        this.f27192g = zzeizVar;
    }

    public final synchronized void a() {
        zzcir zzcirVar;
        zzeiy zzeiyVar;
        zzeix zzeixVar;
        try {
            zzfhr zzfhrVar = this.f27188c;
            if (zzfhrVar.T && (zzcirVar = this.f27187b) != null) {
                Context context = this.f27186a;
                com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                if (zztVar.x.a(context)) {
                    VersionInfoParcel versionInfoParcel = this.f27189d;
                    int i2 = versionInfoParcel.f21401b;
                    int i3 = versionInfoParcel.f21402c;
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 1 + String.valueOf(i3).length());
                    sb.append(i2);
                    sb.append(CLConstants.DOT_SALT_DELIMETER);
                    sb.append(i3);
                    String string = sb.toString();
                    zzfin zzfinVar = zzfhrVar.V;
                    String str = zzfinVar.a() + (-1) != 1 ? "javascript" : null;
                    if (zzfinVar.a() == 1) {
                        zzeixVar = zzeix.VIDEO;
                        zzeiyVar = zzeiy.DEFINED_BY_JAVASCRIPT;
                    } else {
                        int i4 = zzfhrVar.f31153e;
                        zzeix zzeixVar2 = zzeix.HTML_DISPLAY;
                        zzeiyVar = i4 == 1 ? zzeiy.ONE_PIXEL : zzeiy.BEGIN_TO_RENDER;
                        zzeixVar = zzeixVar2;
                    }
                    zzejb zzejbVarB = zztVar.x.b(zzcirVar.k(), zzeixVar, zzeiyVar, string, str, zzfhrVar.l0);
                    this.f27190e = zzejbVarB;
                    if (zzejbVarB != null) {
                        zzfrl zzfrlVar = zzejbVarB.f29453a;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.X5)).booleanValue()) {
                            zztVar.x.e(zzfrlVar, zzcirVar.k());
                            Iterator it = zzcirVar.w().iterator();
                            while (it.hasNext()) {
                                com.google.android.gms.ads.internal.zzt.C.x.d(zzfrlVar, (View) it.next());
                            }
                        } else {
                            zztVar.x.e(zzfrlVar, zzcirVar.x());
                        }
                        zzcirVar.r0(this.f27190e);
                        com.google.android.gms.ads.internal.zzt.C.x.c(zzfrlVar);
                        this.f27191f = true;
                        zzcirVar.g("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final synchronized void f() {
        boolean z;
        zzcir zzcirVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Y5)).booleanValue()) {
            zzeiz zzeizVar = this.f27192g;
            synchronized (zzeizVar) {
                z = zzeizVar.f29447f != null;
            }
        }
        if (z) {
            this.f27192g.c();
            return;
        }
        if (!this.f27191f) {
            a();
        }
        if (!this.f27188c.T || this.f27190e == null || (zzcirVar = this.f27187b) == null) {
            return;
        }
        zzcirVar.g("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final synchronized void zzg() {
        boolean z;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Y5)).booleanValue()) {
            zzeiz zzeizVar = this.f27192g;
            synchronized (zzeizVar) {
                z = zzeizVar.f29447f != null;
            }
        }
        if (z) {
            this.f27192g.b();
        } else {
            if (this.f27191f) {
                return;
            }
            a();
        }
    }
}
