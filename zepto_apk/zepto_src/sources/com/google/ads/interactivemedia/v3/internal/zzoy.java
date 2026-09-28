package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public abstract class zzoy implements Serializable {
    public static zzoy zze() {
        return zzor.zza;
    }

    public static zzoy zzf(@CheckForNull Object obj) {
        return obj == null ? zzor.zza : new zzpe(obj);
    }

    public static zzoy zzg(Object obj) {
        obj.getClass();
        return new zzpe(obj);
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract Object zza();

    public abstract Object zzb(Object obj);

    @CheckForNull
    public abstract Object zzc();

    public abstract boolean zzd();
}
