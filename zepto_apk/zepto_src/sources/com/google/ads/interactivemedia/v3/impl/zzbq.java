package com.google.ads.interactivemedia.v3.impl;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;

/* loaded from: classes3.dex */
public final class zzbq extends zzab implements StreamDisplayContainer {

    @Nullable
    private VideoStreamPlayer zza;

    public zzbq(@Nullable ViewGroup viewGroup, @Nullable VideoStreamPlayer videoStreamPlayer) {
        super(viewGroup);
        this.zza = videoStreamPlayer;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamDisplayContainer
    @Nullable
    public final VideoStreamPlayer getVideoStreamPlayer() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamDisplayContainer
    public final void setVideoStreamPlayer(VideoStreamPlayer videoStreamPlayer) {
        videoStreamPlayer.getClass();
        this.zza = videoStreamPlayer;
    }
}
