package com.google.ads.interactivemedia.v3.impl;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzcu;
import com.google.ads.interactivemedia.v3.internal.zzok;
import java.util.SortedSet;

/* loaded from: classes3.dex */
final class zzah implements zzbo {
    private final SortedSet zza;
    private final zzav zzb;
    private final String zzc;
    private long zzd;
    private VideoProgressUpdate zze;
    private final zzok zzf;

    public zzah(zzav zzavVar, SortedSet sortedSet, String str) {
        zzok zzokVar = new zzok();
        this.zzd = 0L;
        this.zze = new VideoProgressUpdate(0L, 0L);
        this.zza = sortedSet;
        this.zzf = zzokVar;
        this.zzb = zzavVar;
        this.zzc = str;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbo
    public final void zza(VideoProgressUpdate videoProgressUpdate) {
        if (videoProgressUpdate == null || videoProgressUpdate.getDuration() < 0.0f || videoProgressUpdate.equals(this.zze)) {
            return;
        }
        float currentTime = this.zze.getCurrentTime();
        float currentTime2 = videoProgressUpdate.getCurrentTime();
        if (!(currentTime < currentTime2 ? this.zza.subSet(Float.valueOf(currentTime), Float.valueOf(currentTime2)) : this.zza.subSet(Float.valueOf(currentTime2), Float.valueOf(currentTime))).isEmpty() || this.zza.contains(Float.valueOf(videoProgressUpdate.getCurrentTime())) || System.currentTimeMillis() - this.zzd >= 1000) {
            this.zzd = System.currentTimeMillis();
            this.zze = videoProgressUpdate;
            this.zzb.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.contentTimeUpdate, JavaScriptMessage.MsgType.contentTimeUpdate, this.zzc, zzcu.create(videoProgressUpdate)));
        }
    }
}
