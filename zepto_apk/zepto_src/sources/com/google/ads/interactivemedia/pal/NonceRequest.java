package com.google.ads.interactivemedia.pal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class NonceRequest {

    public static abstract class Builder {
        @NonNull
        public abstract NonceRequest build();

        @NonNull
        public abstract Builder continuousPlayback(@Nullable Boolean bool);

        @NonNull
        public abstract Builder descriptionURL(@NonNull String str);

        @NonNull
        public abstract Builder iconsSupported(@NonNull Boolean bool);

        @NonNull
        public abstract Builder nonceLengthLimit(@Nullable Integer num);

        @NonNull
        public abstract Builder omidPartnerName(@NonNull String str);

        @NonNull
        public abstract Builder omidPartnerVersion(@NonNull String str);

        @NonNull
        public abstract Builder omidVersion(@NonNull String str);

        @NonNull
        public abstract Builder platformSignalCollector(@Nullable PlatformSignalCollector platformSignalCollector);

        @NonNull
        public abstract Builder playerType(@NonNull String str);

        @NonNull
        public abstract Builder playerVersion(@NonNull String str);

        @NonNull
        public abstract Builder ppid(@NonNull String str);

        @NonNull
        public abstract Builder sessionId(@NonNull String str);

        @NonNull
        public abstract Builder supportedApiFrameworks(@NonNull Set<Integer> set);

        @NonNull
        public abstract Builder videoPlayerHeight(@Nullable Integer num);

        @NonNull
        public abstract Builder videoPlayerWidth(@Nullable Integer num);

        @NonNull
        public abstract Builder willAdAutoPlay(@Nullable Boolean bool);

        @NonNull
        public abstract Builder willAdPlayMuted(@Nullable Boolean bool);
    }

    @NonNull
    public static Builder builder() {
        zzl zzlVar = new zzl();
        zzlVar.willAdPlayMuted(null);
        zzlVar.willAdAutoPlay(null);
        zzlVar.continuousPlayback(null);
        zzlVar.iconsSupported(Boolean.FALSE);
        zzlVar.nonceLengthLimit(null);
        zzlVar.videoPlayerHeight(null);
        zzlVar.videoPlayerWidth(null);
        zzlVar.platformSignalCollector(null);
        zzlVar.descriptionURL("");
        zzlVar.omidPartnerName("");
        zzlVar.omidPartnerVersion("");
        zzlVar.omidVersion("");
        zzlVar.playerType("");
        zzlVar.playerVersion("");
        zzlVar.ppid("");
        zzlVar.supportedApiFrameworks(new TreeSet());
        zzlVar.sessionId(UUID.randomUUID().toString());
        return zzlVar;
    }

    @NonNull
    public abstract Builder toBuilder();

    @Nullable
    public abstract PlatformSignalCollector zza();

    @Nullable
    public abstract Boolean zzb();

    @NonNull
    public abstract Boolean zzc();

    @Nullable
    public abstract Boolean zzd();

    @Nullable
    public abstract Boolean zze();

    @Nullable
    public abstract Integer zzf();

    @Nullable
    public abstract Integer zzg();

    @Nullable
    public abstract Integer zzh();

    @NonNull
    public abstract String zzi();

    @NonNull
    public abstract String zzj();

    @NonNull
    public abstract String zzk();

    @NonNull
    public abstract String zzl();

    @NonNull
    public abstract String zzm();

    @NonNull
    public abstract String zzn();

    @NonNull
    public abstract String zzo();

    @NonNull
    public abstract String zzp();

    @NonNull
    public abstract Set zzq();
}
