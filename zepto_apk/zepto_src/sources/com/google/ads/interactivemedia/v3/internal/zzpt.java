package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzpt extends zzpx {
    public zzpt(zzpy zzpyVar) {
        super(zzpyVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iZzd = this.zzb.zzd(key, zzpz.zzc(key));
            if (iZzd != -1 && zzox.zza(this.zzb.zza[iZzd], value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        int iZzc = zzpz.zzc(key);
        int iZzd = this.zzb.zzd(key, iZzc);
        if (iZzd == -1 || !zzox.zza(this.zzb.zza[iZzd], value)) {
            return false;
        }
        this.zzb.zzm(iZzd, iZzc);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpx
    public final /* bridge */ /* synthetic */ Object zza(int i2) {
        return new zzpq(this.zzb, i2);
    }
}
