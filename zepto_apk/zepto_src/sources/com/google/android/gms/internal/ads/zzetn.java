package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzetn implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30287a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30288b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30289c;

    /* renamed from: d, reason: collision with root package name */
    public final long f30290d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcxa f30291e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfjs f30292f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfik f30293g;

    /* renamed from: h, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f30294h = com.google.android.gms.ads.internal.zzt.C.f21684h.g();

    /* renamed from: i, reason: collision with root package name */
    public final zzdwy f30295i;

    /* renamed from: j, reason: collision with root package name */
    public final zzcxo f30296j;

    public zzetn(Context context, String str, String str2, zzcxa zzcxaVar, zzfjs zzfjsVar, zzfik zzfikVar, zzdwy zzdwyVar, zzcxo zzcxoVar, long j2) {
        this.f30287a = context;
        this.f30288b = str;
        this.f30289c = str2;
        this.f30291e = zzcxaVar;
        this.f30292f = zzfjsVar;
        this.f30293g = zzfikVar;
        this.f30295i = zzdwyVar;
        this.f30296j = zzcxoVar;
        this.f30290d = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        Bundle bundle = new Bundle();
        zzdwy zzdwyVar = this.f30295i;
        ConcurrentHashMap concurrentHashMap = zzdwyVar.f28712a;
        String str = this.f30288b;
        concurrentHashMap.put("seq_num", str);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue()) {
            zzdwyVar.b("tsacc", String.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - this.f30290d));
            zzdwyVar.b("foreground", true != com.google.android.gms.ads.internal.util.zzs.g(this.f30287a) ? "1" : "0");
        }
        zzcxa zzcxaVar = this.f30291e;
        zzfik zzfikVar = this.f30293g;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfikVar.f31216d;
        zzccu zzccuVar = zzcxaVar.f27336b;
        synchronized (zzccuVar.f25899d) {
            long jElapsedRealtime = zzccuVar.f25896a.elapsedRealtime();
            zzccuVar.f25905j = jElapsedRealtime;
            zzcdf zzcdfVar = zzccuVar.f25897b;
            synchronized (zzcdfVar.f25962a) {
                zzcdfVar.f25965d.a(zzmVar, jElapsedRealtime);
            }
        }
        bundle.putAll(this.f30292f.a());
        return zzgym.a(new zzeto(this.f30287a, bundle, str, this.f30289c, this.f30294h, zzfikVar.f31219g, this.f30296j));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 12;
    }
}
