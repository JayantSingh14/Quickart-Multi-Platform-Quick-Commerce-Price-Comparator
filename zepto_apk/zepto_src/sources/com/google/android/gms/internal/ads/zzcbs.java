package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
final class zzcbs extends zzcbx {

    /* renamed from: b, reason: collision with root package name */
    public final Clock f25852b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f25853c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f25854d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f25855e;

    public zzcbs(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzj zzjVar, zzcbw zzcbwVar) {
        this.f25852b = clock;
        zzijh zzijhVarA = zzijh.a(context);
        zzijh zzijhVarA2 = zzijh.a(zzjVar);
        this.f25853c = zzijf.a(new zzcbm(zzijhVarA, zzijhVarA2));
        zzijh zzijhVarA3 = zzijh.a(clock);
        zzijf zzijfVarA = zzijf.a(new zzcbo(zzijhVarA3, zzijhVarA2, zzijh.a(zzcbwVar)));
        this.f25854d = zzijfVarA;
        this.f25855e = zzijf.a(new zzccd(zzijhVarA, new zzcbq(zzijfVarA, zzijhVarA3)));
    }

    @Override // com.google.android.gms.internal.ads.zzcbx
    public final zzcbp a() {
        return new zzcbp(this.f25852b, (zzcbn) this.f25854d.zzb());
    }
}
