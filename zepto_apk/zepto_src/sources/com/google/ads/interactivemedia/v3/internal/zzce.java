package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: classes3.dex */
public final class zzce {

    @SuppressLint({"StaticFieldLeak"})
    private static final zzce zza = new zzce();
    private Context zzb;

    private zzce() {
    }

    public static zzce zzb() {
        return zza;
    }

    public final Context zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zzb = context != null ? context.getApplicationContext() : null;
    }
}
