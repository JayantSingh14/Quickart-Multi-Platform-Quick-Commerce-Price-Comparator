package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzekk implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29547a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcuh f29548b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f29549c;

    public zzekk(Context context, zzcuh zzcuhVar, Executor executor) {
        this.f29547a = context;
        this.f29548b = zzcuhVar;
        this.f29549c = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, final zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        zzfir zzfirVar;
        final View view;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P8)).booleanValue();
        Object obj = zzejjVar.f29463b;
        if (zBooleanValue && zzfhrVar.g0) {
            try {
                zzbti zzbtiVarO = ((zzfji) obj).f31270a.O();
                if (zzbtiVarO == null) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.c("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                    throw new zzfir(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
                }
                try {
                    view = (View) ObjectWrapper.z0(zzbtiVarO.zze());
                    boolean zZzf = zzbtiVarO.zzf();
                    if (view == null) {
                        throw new zzfir(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                    }
                    if (zZzf) {
                        try {
                            view = (View) ((zzgxf) zzgym.h(zzgyq.f33377b, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzeki
                                @Override // com.google.android.gms.internal.ads.zzgxu
                                public final /* synthetic */ ListenableFuture zza(Object obj2) {
                                    return zzgym.a(zzcuw.a(this.f29543a.f29547a, view, zzfhrVar));
                                }
                            }, zzcdo.f25987f)).get();
                        } catch (InterruptedException | ExecutionException e2) {
                            throw new zzfir(e2);
                        }
                    }
                } catch (RemoteException e22) {
                    throw new zzfir(e22);
                }
            } finally {
            }
        } else {
            try {
                view = (View) ObjectWrapper.z0(((zzfji) obj).f31270a.zzf());
            } finally {
            }
        }
        final zzfji zzfjiVar = (zzfji) obj;
        zzctd zzctdVarD = this.f29548b.d(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzctj(view, null, new zzcvi() { // from class: com.google.android.gms.internal.ads.zzekj
            @Override // com.google.android.gms.internal.ads.zzcvi
            public final com.google.android.gms.ads.internal.client.zzed zza() throws zzfir {
                try {
                    return zzfjiVar.f31270a.t();
                } catch (Throwable th) {
                    throw new zzfir(th);
                }
            }
        }, (zzfhs) zzfhrVar.u.get(0)));
        zzctdVarD.i().w0(view);
        zzctdVarD.a().t0(new zzcqq(zzfjiVar), this.f29549c);
        ((zzekv) zzejjVar.f29464c).Yb(zzctdVarD.e());
        return zzctdVarD.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws JSONException, IOException {
        com.google.android.gms.ads.internal.client.zzr zzrVarA;
        zzfir zzfirVar;
        zzfik zzfikVar = zzficVar.f31193a.f31185a;
        com.google.android.gms.ads.internal.client.zzr zzrVar = zzfikVar.f31218f;
        boolean z = zzrVar.n;
        boolean z2 = zzfhrVar.g0;
        Context context = this.f29547a;
        int i2 = zzrVar.f21282b;
        int i3 = zzrVar.f21285e;
        if (z) {
            AdSize adSize = new AdSize(i3, i2);
            adSize.f21007d = true;
            adSize.f21008e = i2;
            zzrVarA = new com.google.android.gms.ads.internal.client.zzr(context, adSize);
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P8)).booleanValue() && z2) {
                AdSize adSize2 = new AdSize(i3, i2);
                adSize2.f21009f = true;
                adSize2.f21010g = i2;
                zzrVarA = new com.google.android.gms.ads.internal.client.zzr(context, adSize2);
            } else {
                zzrVarA = zzfiq.a(context, zzfhrVar.u);
            }
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar2 = zzrVarA;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P8)).booleanValue();
        zzfhw zzfhwVar = zzfhrVar.s;
        JSONObject jSONObject = zzfhrVar.v;
        IInterface iInterface = zzejjVar.f29464c;
        Object obj = zzejjVar.f29463b;
        if (zBooleanValue && z2) {
            zzfji zzfjiVar = (zzfji) obj;
            try {
                zzfjiVar.f31270a.K2(new ObjectWrapper(context), zzrVar2, zzfikVar.f31216d, jSONObject.toString(), com.google.android.gms.ads.internal.util.zzbp.i(zzfhwVar), (zzbtf) iInterface);
                return;
            } finally {
            }
        }
        zzfji zzfjiVar2 = (zzfji) obj;
        try {
            zzfjiVar2.f31270a.b4(new ObjectWrapper(context), zzrVar2, zzfikVar.f31216d, jSONObject.toString(), com.google.android.gms.ads.internal.util.zzbp.i(zzfhwVar), (zzbtf) iInterface);
        } finally {
        }
    }
}
