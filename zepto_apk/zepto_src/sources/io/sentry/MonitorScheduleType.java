package io.sentry;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Experimental
/* loaded from: classes3.dex */
public enum MonitorScheduleType {
    CRONTAB,
    INTERVAL;

    @NotNull
    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
