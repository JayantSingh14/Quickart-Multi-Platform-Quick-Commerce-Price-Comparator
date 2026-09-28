package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzenx implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzejj f29929a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29930b;

    public zzenx(zzenz zzenzVar, zzejj zzejjVar, zzfhr zzfhrVar) {
        this.f29929a = zzejjVar;
        this.f29930b = zzfhrVar;
        Objects.requireNonNull(zzenzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final void a(boolean z, Context context, zzdax zzdaxVar) throws zzfir, zzdlg {
        try {
            zzfji zzfjiVar = (zzfji) this.f29929a.f29463b;
            zzfjiVar.b(z);
            try {
                zzfjiVar.f31270a.e1();
            } catch (Throwable th) {
                throw new zzfir(th);
            }
        } catch (zzfir e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot show rewarded video.", e2);
            throw new zzdlg(e2.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29930b;
    }
}
