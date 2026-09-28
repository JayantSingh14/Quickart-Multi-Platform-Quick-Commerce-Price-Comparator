package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;

/* loaded from: classes3.dex */
public interface StreamDisplayContainer extends BaseDisplayContainer {
    @NonNull
    VideoStreamPlayer getVideoStreamPlayer();

    @Deprecated
    void setVideoStreamPlayer(@NonNull VideoStreamPlayer videoStreamPlayer);
}
