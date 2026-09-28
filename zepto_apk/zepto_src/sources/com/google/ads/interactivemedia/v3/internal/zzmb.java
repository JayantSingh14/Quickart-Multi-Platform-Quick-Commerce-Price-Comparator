package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes3.dex */
public final class zzmb extends Exception {
    private final int zza;

    public zzmb(int i2) {
        super(b.f(i2, "Signal SDK error code: "));
        this.zza = i2;
    }

    public final int zza() {
        return this.zza;
    }
}
