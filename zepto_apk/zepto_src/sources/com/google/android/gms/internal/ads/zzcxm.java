package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzcxm implements zzdgf, zzdby {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f27351a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcxo f27352b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfik f27353c;

    /* renamed from: d, reason: collision with root package name */
    public final String f27354d;

    public zzcxm(Clock clock, zzcxo zzcxoVar, zzfik zzfikVar, String str) {
        this.f27351a = clock;
        this.f27352b = zzcxoVar;
        this.f27353c = zzfikVar;
        this.f27354d = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final void g() {
        this.f27352b.f27361c.put(this.f27354d, Long.valueOf(this.f27351a.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        long jElapsedRealtime = this.f27351a.elapsedRealtime();
        String str = this.f27353c.f31219g;
        zzcxo zzcxoVar = this.f27352b;
        ConcurrentHashMap concurrentHashMap = zzcxoVar.f27361c;
        String str2 = this.f27354d;
        Long l2 = (Long) concurrentHashMap.get(str2);
        if (l2 == null) {
            return;
        }
        concurrentHashMap.remove(str2);
        zzcxoVar.f27362d.put(str, Long.valueOf(jElapsedRealtime - l2.longValue()));
    }
}
