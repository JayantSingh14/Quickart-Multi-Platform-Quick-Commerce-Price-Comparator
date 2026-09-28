package com.google.ads.interactivemedia.v3.internal;

import java.util.Set;

/* loaded from: classes3.dex */
public final class zzuf extends zzuc {
    private final zzwj zza = new zzwj(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzuf) && ((zzuf) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Set zza() {
        return this.zza.entrySet();
    }

    public final void zzb(String str, zzuc zzucVar) {
        this.zza.put(str, zzucVar);
    }
}
