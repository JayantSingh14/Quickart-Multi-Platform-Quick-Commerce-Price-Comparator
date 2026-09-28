package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzcf;
import com.google.ads.interactivemedia.v3.impl.data.zzcp;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzes;
import com.google.ads.interactivemedia.v3.internal.zzpy;

/* loaded from: classes3.dex */
public final class zzbd implements zzbv, zzf {
    private final AdDisplayContainer zza;
    private final VideoAdPlayer zzb;
    private final zzak zzc;
    private final zzav zzd;
    private final String zze;
    private final zzg zzf;
    private final zzpy zzg = zzpy.zzf(2);

    public zzbd(String str, zzav zzavVar, zzak zzakVar, AdDisplayContainer adDisplayContainer, Context context) {
        this.zza = adDisplayContainer;
        VideoAdPlayer player = adDisplayContainer.getPlayer();
        this.zzb = player;
        this.zzc = zzakVar;
        this.zzd = zzavVar;
        this.zze = str;
        zzg zzgVar = new zzg();
        this.zzf = zzgVar;
        zzgVar.zza(this);
        player.addCallback(zzgVar);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.zzb.getAdProgress();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzf
    public final void zza(JavaScriptMessage.MsgChannel msgChannel, JavaScriptMessage.MsgType msgType) {
        this.zzd.zzp(new JavaScriptMessage(msgChannel, msgType, "*", null));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzf
    public final void zzb(JavaScriptMessage.MsgType msgType, AdMediaInfo adMediaInfo, Object obj) {
        JavaScriptMessage.MsgChannel msgChannel = (JavaScriptMessage.MsgChannel) this.zzg.zze().get(adMediaInfo);
        if (msgChannel != null) {
            this.zzd.zzp(new JavaScriptMessage(msgChannel, msgType, this.zze, obj));
            return;
        }
        zzeo.zzd("The adMediaInfo for the " + String.valueOf(msgType) + " event is not active. This may occur if callbacks are triggered after the ad is unloaded.");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzc() {
        zzeo.zzc("Destroying NativeVideoDisplay");
        this.zzb.removeCallback(this.zzf);
        this.zzb.release();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzd() {
    }

    public final void zze() {
        this.zzf.zzc();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzf(JavaScriptMessage.MsgChannel msgChannel, JavaScriptMessage.MsgType msgType, zzcf zzcfVar) {
        AdMediaInfo adMediaInfo = (AdMediaInfo) this.zzg.get(msgChannel);
        JavaScriptMessage.MsgType msgType2 = JavaScriptMessage.MsgType.activate;
        int iOrdinal = msgType.ordinal();
        if (iOrdinal != 34) {
            if (iOrdinal == 45) {
                if (zzcfVar == null || zzcfVar.videoUrl == null) {
                    this.zzc.zzc(new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
                    return;
                }
                this.zzf.zzb();
                AdMediaInfo adMediaInfo2 = new AdMediaInfo(zzcfVar.videoUrl);
                com.google.ads.interactivemedia.v3.impl.data.zzd zzdVar = zzcfVar.adPodInfo;
                if (zzdVar == null) {
                    zzdVar = null;
                }
                this.zzg.put(msgChannel, adMediaInfo2);
                this.zzb.loadAd(adMediaInfo2, zzdVar);
                return;
            }
            if (iOrdinal != 75) {
                if (iOrdinal == 55) {
                    this.zzb.pauseAd(adMediaInfo);
                    return;
                } else {
                    if (iOrdinal != 56) {
                        return;
                    }
                    this.zzb.playAd(adMediaInfo);
                    this.zzf.zzb();
                    return;
                }
            }
        }
        this.zzb.stopAd(adMediaInfo);
        this.zzg.remove(msgChannel);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzg(zzcp zzcpVar) {
        if (!(this.zzb instanceof ResizablePlayer)) {
            zzeo.zza("Video player does not support resizing.");
            return;
        }
        if (!zzes.zza(this.zza, zzcpVar)) {
            zzeo.zza("Creative resize parameters were not within the containers bounds.");
            return;
        }
        int width = this.zza.getAdContainer().getWidth();
        int height = this.zza.getAdContainer().getHeight();
        ((ResizablePlayer) this.zzb).resize(zzcpVar.x().intValue(), zzcpVar.y().intValue(), (width - zzcpVar.x().intValue()) - zzcpVar.width().intValue(), (height - zzcpVar.y().intValue()) - zzcpVar.height().intValue());
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzh() {
        VideoAdPlayer videoAdPlayer = this.zzb;
        if (videoAdPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoAdPlayer).resize(0, 0, 0, 0);
        }
    }
}
