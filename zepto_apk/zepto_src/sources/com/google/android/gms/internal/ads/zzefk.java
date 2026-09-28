package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final /* synthetic */ class zzefk implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfaz f29220a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbza f29221b;

    public /* synthetic */ zzefk(zzfaz zzfazVar, zzbza zzbzaVar) {
        this.f29220a = zzfazVar;
        this.f29221b = zzbzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        return this.f29220a.a().a(com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.m((Bundle) obj), this.f29221b.f25732m, false);
    }
}
