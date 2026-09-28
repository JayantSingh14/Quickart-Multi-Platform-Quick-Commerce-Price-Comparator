package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdsa extends zzblr {

    /* renamed from: a, reason: collision with root package name */
    public final String f28396a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdnh f28397b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdnm f28398c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdxe f28399d;

    public zzdsa(String str, zzdnh zzdnhVar, zzdnm zzdnmVar, zzdxe zzdxeVar) {
        this.f28396a = str;
        this.f28397b = zzdnhVar;
        this.f28398c = zzdnmVar;
        this.f28399d = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void H4(Bundle bundle) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.fe)).booleanValue()) {
            zzdnh zzdnhVar = this.f28397b;
            final zzcir zzcirVarH = zzdnhVar.f28007m.h();
            if (zzcirVarH == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.c("Video webview is null");
                return;
            }
            try {
                final JSONObject jSONObject = new JSONObject();
                for (String str : bundle.keySet()) {
                    jSONObject.put(str, bundle.get(str));
                }
                zzdnhVar.f28006l.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdne
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzgtd zzgtdVar = zzdnh.J;
                        zzcirVarH.m("onVideoEvent", jSONObject);
                    }
                });
            } catch (JSONException e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error reading event signals", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final List I() {
        List list;
        com.google.android.gms.ads.internal.client.zzez zzezVar;
        List list2;
        zzdnm zzdnmVar = this.f28398c;
        synchronized (zzdnmVar) {
            list = zzdnmVar.f28031f;
        }
        if (!list.isEmpty()) {
            synchronized (zzdnmVar) {
                zzezVar = zzdnmVar.f28032g;
            }
            if (zzezVar != null) {
                zzdnm zzdnmVar2 = this.f28398c;
                synchronized (zzdnmVar2) {
                    list2 = zzdnmVar2.f28031f;
                }
                return list2;
            }
        }
        return Collections.EMPTY_LIST;
    }

    public final void Xb(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        zzdnh zzdnhVar = this.f28397b;
        synchronized (zzdnhVar) {
            zzdnhVar.n.a0(zzdjVar);
        }
    }

    public final void Yb(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        zzdnh zzdnhVar = this.f28397b;
        synchronized (zzdnhVar) {
            zzdnhVar.n.g0(zzdfVar);
        }
    }

    public final void Zb(zzblp zzblpVar) {
        zzdnh zzdnhVar = this.f28397b;
        synchronized (zzdnhVar) {
            zzdnhVar.n.f0(zzblpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final IObjectWrapper c() {
        return new ObjectWrapper(this.f28397b);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final IObjectWrapper h() {
        IObjectWrapper iObjectWrapper;
        zzdnm zzdnmVar = this.f28398c;
        synchronized (zzdnmVar) {
            iObjectWrapper = zzdnmVar.q;
        }
        return iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final com.google.android.gms.ads.internal.client.zzea m() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s7)).booleanValue()) {
            return this.f28397b.f27232f;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zze() {
        return this.f28398c.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final List zzf() {
        List list;
        zzdnm zzdnmVar = this.f28398c;
        synchronized (zzdnmVar) {
            list = zzdnmVar.f28030e;
        }
        return list;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzg() {
        return this.f28398c.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final zzbjy zzh() {
        zzbjy zzbjyVar;
        zzdnm zzdnmVar = this.f28398c;
        synchronized (zzdnmVar) {
            zzbjyVar = zzdnmVar.s;
        }
        return zzbjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzi() {
        return this.f28398c.e();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzj() {
        return this.f28398c.f();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final double zzk() {
        double d2;
        zzdnm zzdnmVar = this.f28398c;
        synchronized (zzdnmVar) {
            d2 = zzdnmVar.r;
        }
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzl() {
        String strP;
        zzdnm zzdnmVar = this.f28398c;
        synchronized (zzdnmVar) {
            strP = zzdnmVar.p("store");
        }
        return strP;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzm() {
        String strP;
        zzdnm zzdnmVar = this.f28398c;
        synchronized (zzdnmVar) {
            strP = zzdnmVar.p("price");
        }
        return strP;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final com.google.android.gms.ads.internal.client.zzed zzn() {
        return this.f28398c.r();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final zzbjr zzq() {
        return this.f28398c.s();
    }
}
