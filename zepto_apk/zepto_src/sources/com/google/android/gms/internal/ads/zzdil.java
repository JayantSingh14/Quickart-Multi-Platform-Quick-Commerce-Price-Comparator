package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public final class zzdil extends zzdgi implements zzbck {

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f27787b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f27788c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfhr f27789d;

    public zzdil(Context context, Set set, zzfhr zzfhrVar) {
        super(set);
        this.f27787b = new WeakHashMap(1);
        this.f27788c = context;
        this.f27789d = zzfhrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final synchronized void u0(final zzbcj zzbcjVar) {
        v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdik
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final /* synthetic */ void zza(Object obj) {
                ((zzbck) obj).u0(zzbcjVar);
            }
        });
    }

    public final synchronized void w0(View view) {
        zzbcm zzbcmVar;
        try {
            WeakHashMap weakHashMap = this.f27787b;
            zzbcmVar = (zzbcm) weakHashMap.get(view);
            if (zzbcmVar == null) {
                zzbcm zzbcmVar2 = new zzbcm(this.f27788c, view);
                zzbcmVar2.f24721l.add(this);
                zzbcmVar2.d(3);
                weakHashMap.put(view, zzbcmVar2);
                zzbcmVar = zzbcmVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
        if (this.f27789d.X) {
            zzbgb zzbgbVar = zzbgk.K1;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                long jLongValue = ((Long) zzbdVar.f21153c.a(zzbgk.J1)).longValue();
                com.google.android.gms.ads.internal.util.zzbu zzbuVar = zzbcmVar.f24718i;
                synchronized (zzbuVar.f21546c) {
                    zzbuVar.f21544a = jLongValue;
                }
                return;
            }
            throw th;
        }
        com.google.android.gms.ads.internal.util.zzbu zzbuVar2 = zzbcmVar.f24718i;
        long j2 = zzbcm.o;
        synchronized (zzbuVar2.f21546c) {
            zzbuVar2.f21544a = j2;
        }
    }
}
