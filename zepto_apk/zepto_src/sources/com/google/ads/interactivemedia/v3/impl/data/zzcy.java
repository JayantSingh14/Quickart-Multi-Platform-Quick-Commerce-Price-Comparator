package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzbc.class)
/* loaded from: classes3.dex */
public abstract class zzcy {
    public static zzcy create(@Nullable Integer num, boolean z) {
        return new zzbc(num, z);
    }

    @Nullable
    public abstract Integer downloadBandwidthKbps();

    public abstract boolean rendersUiNatively();
}
