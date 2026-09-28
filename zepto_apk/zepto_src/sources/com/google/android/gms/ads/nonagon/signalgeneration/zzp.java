package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbip;
import com.google.android.gms.internal.ads.zzdxj;

/* loaded from: classes4.dex */
public final class zzp extends QueryInfoGenerationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final zzo f21922a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxj f21923b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21924c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21925d;

    /* renamed from: e, reason: collision with root package name */
    public final long f21926e = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();

    /* renamed from: f, reason: collision with root package name */
    public final Boolean f21927f;

    public zzp(zzo zzoVar, boolean z, int i2, Boolean bool, zzdxj zzdxjVar) {
        this.f21922a = zzoVar;
        this.f21924c = z;
        this.f21925d = i2;
        this.f21927f = bool;
        this.f21923b = zzdxjVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void a(String str) {
        Pair pair = new Pair("sgf_reason", str);
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair("ad_format", "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        Pair pair6 = new Pair("lat_ms", Long.toString(zztVar.f21687k.currentTimeMillis() - this.f21926e));
        int i2 = this.f21925d;
        Pair pair7 = new Pair("sgpc_rn", Integer.toString(i2));
        Pair pair8 = new Pair("sgpc_lsu", String.valueOf(this.f21927f));
        boolean z = this.f21924c;
        zzaa.d(this.f21923b, "sgpcf", pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, new Pair("tpc", true != z ? "0" : "1"));
        this.f21922a.b(z, new zzq(null, str, ((Long) zzbip.f25202h.c()).longValue() + zztVar.f21687k.currentTimeMillis(), i2));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void b(QueryInfo queryInfo) {
        Pair pair = new Pair("se", "query_g");
        Pair pair2 = new Pair("ad_format", "BANNER");
        Pair pair3 = new Pair("rtype", Integer.toString(6));
        Pair pair4 = new Pair("scar", "true");
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        Pair pair5 = new Pair("lat_ms", Long.toString(zztVar.f21687k.currentTimeMillis() - this.f21926e));
        int i2 = this.f21925d;
        Pair pair6 = new Pair("sgpc_rn", Integer.toString(i2));
        Pair pair7 = new Pair("sgpc_lsu", String.valueOf(this.f21927f));
        boolean z = this.f21924c;
        zzaa.d(this.f21923b, "sgpcs", pair, pair2, pair3, pair4, pair5, pair6, pair7, new Pair("tpc", true != z ? "0" : "1"));
        this.f21922a.b(z, new zzq(queryInfo, "", ((Long) zzbip.f25202h.c()).longValue() + zztVar.f21687k.currentTimeMillis(), i2));
    }
}
