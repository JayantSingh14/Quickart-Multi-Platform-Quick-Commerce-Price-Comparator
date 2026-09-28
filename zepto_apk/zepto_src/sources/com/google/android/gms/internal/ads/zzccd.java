package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzccd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f25881a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcbq f25882b;

    public zzccd(zzijh zzijhVar, zzcbq zzcbqVar) {
        this.f25881a = zzijhVar;
        this.f25882b = zzcbqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f25881a.f34899a;
        zzcbq zzcbqVar = this.f25882b;
        return new zzccc(context, new zzcbp((Clock) zzcbqVar.f25846a.f34899a, (zzcbn) zzcbqVar.f25847b.zzb()));
    }
}
