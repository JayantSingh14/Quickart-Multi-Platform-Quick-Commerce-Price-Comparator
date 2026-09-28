package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzbb.class)
/* loaded from: classes3.dex */
public abstract class zzcu {
    private static final String DEFAULT_TIME_UNIT = "ms";

    public static zzcu create(VideoProgressUpdate videoProgressUpdate) {
        return new zzbb(videoProgressUpdate.getCurrentTimeMs(), videoProgressUpdate.getDurationMs(), DEFAULT_TIME_UNIT);
    }

    public abstract long currentTime();

    public abstract long duration();

    public abstract String timeUnit();
}
