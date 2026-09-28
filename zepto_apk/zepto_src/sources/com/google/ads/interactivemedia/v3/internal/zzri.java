package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzri extends zzqk {
    final transient Object zza;

    public zzri(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzqq(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return b.D("[", this.zza.toString(), "]");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zza(Object[] objArr, int i2) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb
    public final zzqf zzd() {
        int i2 = zzqf.zzd;
        Object[] objArr = {this.zza};
        zzqv.zzb(objArr, 1);
        return zzqf.zzj(objArr, 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb
    /* renamed from: zze */
    public final zzrl iterator() {
        return new zzqq(this.zza);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return false;
    }
}
