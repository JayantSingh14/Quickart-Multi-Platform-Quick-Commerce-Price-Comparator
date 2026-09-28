package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzwi implements Map.Entry {
    zzwi zza;
    zzwi zzb;
    zzwi zzc;
    zzwi zzd;
    zzwi zze;
    final Object zzf;
    final boolean zzg;
    Object zzh;
    int zzi;

    public zzwi(boolean z) {
        this.zzf = null;
        this.zzg = z;
        this.zze = this;
        this.zzd = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.zzf;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.zzh;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zzf;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzh;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.zzf;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzh;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.zzh;
        this.zzh = obj;
        return obj2;
    }

    public final String toString() {
        return b.l(String.valueOf(this.zzf), "=", String.valueOf(this.zzh));
    }

    public zzwi(boolean z, zzwi zzwiVar, Object obj, zzwi zzwiVar2, zzwi zzwiVar3) {
        this.zza = zzwiVar;
        this.zzf = obj;
        this.zzg = z;
        this.zzi = 1;
        this.zzd = zzwiVar2;
        this.zze = zzwiVar3;
        zzwiVar3.zzd = this;
        zzwiVar2.zze = this;
    }
}
