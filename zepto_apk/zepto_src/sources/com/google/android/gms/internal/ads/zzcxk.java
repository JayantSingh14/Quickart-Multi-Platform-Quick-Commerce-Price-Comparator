package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzcxk implements com.google.android.gms.ads.internal.client.zza {

    /* renamed from: a, reason: collision with root package name */
    public final zzcxo f27347a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f27348b;

    public zzcxk(zzcxo zzcxoVar, zzfik zzfikVar) {
        this.f27347a = zzcxoVar;
        this.f27348b = zzfikVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        zzfik zzfikVar = this.f27348b;
        zzcxo zzcxoVar = this.f27347a;
        String str = zzfikVar.f31219g;
        synchronized (zzcxoVar.f27359a) {
            try {
                ConcurrentHashMap concurrentHashMap = zzcxoVar.f27360b;
                Integer num = (Integer) concurrentHashMap.get(str);
                concurrentHashMap.put(str, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
