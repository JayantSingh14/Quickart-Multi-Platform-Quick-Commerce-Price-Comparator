package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzpr extends zzpx {
    final /* synthetic */ zzpy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpr(zzpy zzpyVar) {
        super(zzpyVar);
        this.zza = zzpyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iZzc = this.zza.zzc(key, zzpz.zzc(key));
            if (iZzc != -1 && zzox.zza(value, this.zza.zzb[iZzc])) {
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
        int iZzc2 = this.zza.zzc(key, iZzc);
        if (iZzc2 == -1 || !zzox.zza(value, this.zza.zzb[iZzc2])) {
            return false;
        }
        this.zza.zzl(iZzc2, iZzc);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpx
    public final /* bridge */ /* synthetic */ Object zza(int i2) {
        return new zzpp(this.zza, i2);
    }
}
