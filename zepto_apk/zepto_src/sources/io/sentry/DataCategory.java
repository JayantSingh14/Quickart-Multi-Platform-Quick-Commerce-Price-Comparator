package io.sentry;

import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.android.gms.common.Scopes;
import in.juspay.hypersdk.analytics.LogConstants;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
/* loaded from: classes.dex */
public enum DataCategory {
    All("__all__"),
    Default(LogConstants.DEFAULT_CHANNEL),
    Error("error"),
    Session("session"),
    Attachment("attachment"),
    Monitor("monitor"),
    Profile(Scopes.PROFILE),
    MetricBucket("metric_bucket"),
    Transaction("transaction"),
    Replay("replay"),
    Span("span"),
    Security("security"),
    UserReport("user_report"),
    Unknown(zzck.UNKNOWN_CONTENT_TYPE);

    private final String category;

    DataCategory(@NotNull String str) {
        this.category = str;
    }

    public String getCategory() {
        return this.category;
    }
}
