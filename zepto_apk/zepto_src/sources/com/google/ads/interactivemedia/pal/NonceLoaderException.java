package com.google.ads.interactivemedia.pal;

import android.support.v4.media.b;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class NonceLoaderException extends Exception {
    private final int zza;

    public NonceLoaderException(int i2, @NonNull Exception exc) {
        super(b.f(i2, "NonceLoader exception, errorCode : "), exc);
        this.zza = i2;
    }

    @NonNull
    public static NonceLoaderException zzb(int i2) {
        return new NonceLoaderException(i2, new Exception());
    }

    public final int zza() {
        return this.zza;
    }
}
