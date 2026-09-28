package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
abstract class zzqj extends zzqk {
    @Override // com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = zzh().get(entry.getKey());
            if (obj2 != null && obj2.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzrh.zza(zzh().entrySet());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zzh().size();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return zzh().zzk();
    }

    public abstract zzqi zzh();

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk
    public final boolean zzi() {
        return false;
    }
}
