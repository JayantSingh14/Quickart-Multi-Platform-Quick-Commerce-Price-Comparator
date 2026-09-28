package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Map;

/* loaded from: classes3.dex */
public interface StreamRequest extends BaseRequest {

    public enum StreamFormat {
        DASH,
        HLS
    }

    @Nullable
    Map<String, String> getAdTagParameters();

    @Nullable
    String getAdTagUrl();

    @NonNull
    String getApiKey();

    @Nullable
    String getAssetKey();

    @NonNull
    String getAuthToken();

    @Nullable
    String getContentSourceId();

    @Nullable
    String getContentSourceUrl();

    @Nullable
    String getCustomAssetKey();

    @KeepForSdk
    boolean getEnableNonce();

    @NonNull
    StreamFormat getFormat();

    @Nullable
    @KeepForSdk
    String getLiveStreamEventId();

    @NonNull
    String getManifestSuffix();

    @Nullable
    String getNetworkCode();

    @Nullable
    @KeepForSdk
    String getOAuthToken();

    @Nullable
    @KeepForSdk
    String getProjectNumber();

    @Nullable
    @KeepForSdk
    String getRegion();

    @NonNull
    @KeepForSdk
    String getStreamActivityMonitorId();

    @NonNull
    @KeepForSdk
    Boolean getUseQAStreamBaseUrl();

    @Nullable
    String getVideoId();

    @Nullable
    String getVodConfigId();

    void setAdTagParameters(@NonNull Map<String, String> map);

    void setAuthToken(@NonNull String str);

    @KeepForSdk
    void setEnableNonce(boolean z);

    void setFormat(@NonNull StreamFormat streamFormat);

    void setManifestSuffix(@NonNull String str);

    void setStreamActivityMonitorId(@NonNull String str);

    @KeepForSdk
    void setUseQAStreamBaseUrl(@NonNull Boolean bool);
}
