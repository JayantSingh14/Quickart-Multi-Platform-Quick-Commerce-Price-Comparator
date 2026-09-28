package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzak.class)
/* loaded from: classes3.dex */
public abstract class zzch {
    public static zzch create(String str, String str2) {
        return new zzak(str, str2);
    }

    @Nullable
    public abstract String message();

    @Nullable
    public abstract String name();

    public static zzch create(Throwable th) {
        return new zzak(th.getClass().getName(), th.getMessage());
    }
}
