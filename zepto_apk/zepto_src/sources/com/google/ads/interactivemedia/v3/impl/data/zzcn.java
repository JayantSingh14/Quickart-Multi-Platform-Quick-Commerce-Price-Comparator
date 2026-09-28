package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzas.class)
/* loaded from: classes3.dex */
public abstract class zzcn {
    public static zzcm builder() {
        return new zzaq();
    }

    public abstract boolean attached();

    public abstract zzbh bounds();

    @Nullable
    public abstract String detailedReason();

    public abstract boolean hidden();

    public abstract FriendlyObstructionPurpose purpose();

    public abstract String type();
}
