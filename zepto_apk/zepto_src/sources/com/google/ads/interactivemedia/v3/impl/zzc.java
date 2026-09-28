package com.google.ads.interactivemedia.v3.impl;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;

/* loaded from: classes3.dex */
public class zzc extends zzab implements AdDisplayContainer {

    @Nullable
    private VideoAdPlayer zza;

    public zzc(@Nullable ViewGroup viewGroup, @Nullable VideoAdPlayer videoAdPlayer) {
        super(viewGroup);
        this.zza = videoAdPlayer;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdDisplayContainer
    @Nullable
    public final VideoAdPlayer getPlayer() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdDisplayContainer
    public final void setPlayer(VideoAdPlayer videoAdPlayer) {
        videoAdPlayer.getClass();
        this.zza = videoAdPlayer;
    }
}
