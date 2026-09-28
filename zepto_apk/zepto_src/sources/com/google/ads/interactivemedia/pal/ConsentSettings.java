package com.google.ads.interactivemedia.pal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes3.dex */
public abstract class ConsentSettings {

    public static abstract class Builder {
        @NonNull
        public abstract Builder allowStorage(@NonNull Boolean bool);

        @NonNull
        public abstract ConsentSettings build();

        @NonNull
        public abstract Builder directedForChildOrUnknownAge(@NonNull Boolean bool);

        @NonNull
        @KeepForSdk
        public abstract Builder enableCookiesFor3pServerSideAdInsertion(@Nullable Boolean bool);
    }

    @NonNull
    public static Builder builder() {
        zzb zzbVar = new zzb();
        zzbVar.enableCookiesFor3pServerSideAdInsertion(null);
        Boolean bool = Boolean.FALSE;
        zzbVar.allowStorage(bool);
        zzbVar.directedForChildOrUnknownAge(bool);
        return zzbVar;
    }

    @NonNull
    public abstract Builder toBuilder();

    public abstract Boolean zza();

    public abstract Boolean zzb();

    @Nullable
    public abstract Boolean zzc();
}
