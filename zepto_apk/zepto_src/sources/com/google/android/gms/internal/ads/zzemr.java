package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzemr {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f29801a;

    /* renamed from: b, reason: collision with root package name */
    public final zzemt f29802b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfpi f29803c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f29804d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final boolean f29805e = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.x7)).booleanValue();

    /* renamed from: f, reason: collision with root package name */
    public final zzejl f29806f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f29807g;

    /* renamed from: h, reason: collision with root package name */
    public long f29808h;

    /* renamed from: i, reason: collision with root package name */
    public long f29809i;

    public zzemr(Clock clock, zzemt zzemtVar, zzejl zzejlVar, zzfpi zzfpiVar) {
        this.f29801a = clock;
        this.f29802b = zzemtVar;
        this.f29806f = zzejlVar;
        this.f29803c = zzfpiVar;
    }

    public final synchronized void a(List list) {
        this.f29809i = this.f29801a.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfhr zzfhrVar = (zzfhr) it.next();
            String str = zzfhrVar.w;
            if (!TextUtils.isEmpty(str)) {
                this.f29804d.put(zzfhrVar, new zzemq(str, zzfhrVar.f0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0L, null));
            }
        }
    }

    public final synchronized void b(zzfic zzficVar, zzfhr zzfhrVar, ListenableFuture listenableFuture, zzfpe zzfpeVar) {
        zzfhu zzfhuVar = zzficVar.f31194b.f31190b;
        long jElapsedRealtime = this.f29801a.elapsedRealtime();
        String str = zzfhrVar.w;
        if (str != null) {
            this.f29804d.put(zzfhrVar, new zzemq(str, zzfhrVar.f0, 9, 0L, null));
            zzemp zzempVar = new zzemp(this, jElapsedRealtime, zzfhuVar, zzfhrVar, str, zzfpeVar, zzficVar);
            listenableFuture.q(new zzgyk(listenableFuture, zzempVar), zzcdo.f25988g);
        }
    }

    public final synchronized void c(zzfhr zzfhrVar) {
        zzemq zzemqVar = (zzemq) this.f29804d.get(zzfhrVar);
        if (zzemqVar == null || this.f29807g) {
            return;
        }
        zzemqVar.f29798c = 8;
    }

    public final synchronized String d() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f29804d.entrySet().iterator();
            while (it.hasNext()) {
                zzemq zzemqVar = (zzemq) ((Map.Entry) it.next()).getValue();
                if (zzemqVar.f29798c != Integer.MAX_VALUE) {
                    arrayList.add(zzemqVar.toString());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return TextUtils.join(Attributes.PREDEFINED_ATTRIBUTE_PREFIX, arrayList);
    }
}
