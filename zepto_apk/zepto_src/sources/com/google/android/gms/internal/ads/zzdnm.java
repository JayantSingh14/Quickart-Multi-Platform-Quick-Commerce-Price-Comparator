package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzdnm {

    /* renamed from: a, reason: collision with root package name */
    public int f28026a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzec f28027b;

    /* renamed from: c, reason: collision with root package name */
    public zzbjr f28028c;

    /* renamed from: d, reason: collision with root package name */
    public View f28029d;

    /* renamed from: e, reason: collision with root package name */
    public List f28030e;

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzez f28032g;

    /* renamed from: h, reason: collision with root package name */
    public Bundle f28033h;

    /* renamed from: i, reason: collision with root package name */
    public zzcir f28034i;

    /* renamed from: j, reason: collision with root package name */
    public zzcir f28035j;

    /* renamed from: k, reason: collision with root package name */
    public zzcir f28036k;

    /* renamed from: l, reason: collision with root package name */
    public zzejb f28037l;

    /* renamed from: m, reason: collision with root package name */
    public ListenableFuture f28038m;
    public zzcdt n;
    public View o;
    public View p;
    public IObjectWrapper q;
    public double r;
    public zzbjy s;
    public zzbjy t;
    public String u;
    public float x;
    public String y;
    public final SimpleArrayMap v = new SimpleArrayMap();
    public final SimpleArrayMap w = new SimpleArrayMap();

    /* renamed from: f, reason: collision with root package name */
    public List f28031f = Collections.EMPTY_LIST;

    public static zzdnm l(zzbto zzbtoVar) {
        zzdnl zzdnlVar;
        zzbto zzbtoVar2;
        try {
            com.google.android.gms.ads.internal.client.zzed zzedVarZzn = zzbtoVar.zzn();
            if (zzedVarZzn == null) {
                zzbtoVar2 = zzbtoVar;
                zzdnlVar = null;
            } else {
                zzbtoVar2 = zzbtoVar;
                zzdnlVar = new zzdnl(zzedVarZzn, zzbtoVar2);
            }
            return m(zzdnlVar, zzbtoVar2.zzo(), (View) n(zzbtoVar2.zzp()), zzbtoVar2.zze(), zzbtoVar2.zzf(), zzbtoVar2.zzg(), zzbtoVar2.bb(), zzbtoVar2.zzi(), (View) n(zzbtoVar2.zzq()), zzbtoVar2.zzr(), zzbtoVar2.zzl(), zzbtoVar2.zzm(), zzbtoVar2.zzk(), zzbtoVar2.zzh(), zzbtoVar2.zzj(), zzbtoVar2.I());
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to get native ad assets from unified ad mapper", e2);
            return null;
        }
    }

    public static zzdnm m(zzdnl zzdnlVar, zzbjr zzbjrVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d2, zzbjy zzbjyVar, String str6, float f2) {
        zzdnm zzdnmVar = new zzdnm();
        zzdnmVar.f28026a = 6;
        zzdnmVar.f28027b = zzdnlVar;
        zzdnmVar.f28028c = zzbjrVar;
        zzdnmVar.f28029d = view;
        zzdnmVar.o("headline", str);
        zzdnmVar.f28030e = list;
        zzdnmVar.o("body", str2);
        zzdnmVar.f28033h = bundle;
        zzdnmVar.o("call_to_action", str3);
        zzdnmVar.o = view2;
        zzdnmVar.q = iObjectWrapper;
        zzdnmVar.o("store", str4);
        zzdnmVar.o("price", str5);
        zzdnmVar.r = d2;
        zzdnmVar.s = zzbjyVar;
        zzdnmVar.o("advertiser", str6);
        synchronized (zzdnmVar) {
            zzdnmVar.x = f2;
        }
        return zzdnmVar;
    }

    public static Object n(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.z0(iObjectWrapper);
    }

    public final synchronized String a() {
        return p("headline");
    }

    public final zzbjy b() {
        List list = this.f28030e;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.f28030e.get(0);
        if (obj instanceof IBinder) {
            return zzbjx.Xb((IBinder) obj);
        }
        return null;
    }

    public final synchronized String c() {
        return p("body");
    }

    public final synchronized Bundle d() {
        try {
            if (this.f28033h == null) {
                this.f28033h = new Bundle();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f28033h;
    }

    public final synchronized String e() {
        return p("call_to_action");
    }

    public final synchronized String f() {
        return p("advertiser");
    }

    public final synchronized String g() {
        return this.u;
    }

    public final synchronized zzcir h() {
        return this.f28034i;
    }

    public final synchronized zzcir i() {
        return this.f28035j;
    }

    public final synchronized zzcir j() {
        return this.f28036k;
    }

    public final synchronized zzejb k() {
        return this.f28037l;
    }

    public final synchronized void o(String str, String str2) {
        if (str2 == null) {
            this.w.remove(str);
        } else {
            this.w.put(str, str2);
        }
    }

    public final synchronized String p(String str) {
        return (String) this.w.get(str);
    }

    public final synchronized int q() {
        return this.f28026a;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzed r() {
        return this.f28027b;
    }

    public final synchronized zzbjr s() {
        return this.f28028c;
    }
}
