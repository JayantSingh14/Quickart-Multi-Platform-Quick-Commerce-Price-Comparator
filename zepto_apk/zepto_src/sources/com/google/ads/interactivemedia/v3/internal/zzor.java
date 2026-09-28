package com.google.ads.interactivemedia.v3.internal;

import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzor extends zzoy {
    static final zzor zza = new zzor();

    private zzor() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final Object zzb(Object obj) {
        return obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    @CheckForNull
    public final Object zzc() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final boolean zzd() {
        return false;
    }
}
