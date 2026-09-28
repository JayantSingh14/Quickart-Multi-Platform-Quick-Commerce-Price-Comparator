package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzqz extends zzqk {
    private final transient zzqi zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzqz(zzqi zzqiVar, Object[] objArr, int i2, int i3) {
        this.zza = zzqiVar;
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zza(Object[] objArr, int i2) {
        return zzd().zza(objArr, 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb
    /* renamed from: zze */
    public final zzrl iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk
    public final zzqf zzk() {
        return new zzqy(this);
    }
}
