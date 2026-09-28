package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzqm extends zzqj {
    final /* synthetic */ zzqn zza;

    public zzqm(zzqn zzqnVar) {
        this.zza = zzqnVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb
    /* renamed from: zze */
    public final zzrl iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqj
    public final zzqi zzh() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk
    public final zzqf zzk() {
        return new zzql(this);
    }
}
