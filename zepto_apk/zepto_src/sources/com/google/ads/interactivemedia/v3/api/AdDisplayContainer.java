package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;

/* loaded from: classes3.dex */
public interface AdDisplayContainer extends BaseDisplayContainer {
    @NonNull
    VideoAdPlayer getPlayer();

    @Deprecated
    void setPlayer(@NonNull VideoAdPlayer videoAdPlayer);
}
