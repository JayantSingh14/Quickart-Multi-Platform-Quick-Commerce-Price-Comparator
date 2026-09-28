package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface StreamManager extends BaseManager {
    @Deprecated
    double getContentTimeForStreamTime(double d2);

    long getContentTimeMsForStreamTimeMs(long j2);

    @NonNull
    List<CuePoint> getCuePoints();

    @NonNull
    @Deprecated
    CuePoint getPreviousCuePointForStreamTime(double d2);

    @NonNull
    CuePoint getPreviousCuePointForStreamTimeMs(long j2);

    @NonNull
    String getStreamId();

    @Deprecated
    double getStreamTimeForContentTime(double d2);

    long getStreamTimeMsForContentTimeMs(long j2);

    void loadThirdPartyStream(@NonNull String str, @NonNull List<? extends Map<String, String>> list);

    void replaceAdTagParameters(@NonNull Map<String, String> map);
}
