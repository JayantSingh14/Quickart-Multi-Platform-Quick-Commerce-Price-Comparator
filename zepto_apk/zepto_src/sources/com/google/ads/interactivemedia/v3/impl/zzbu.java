package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzcf;
import com.google.ads.interactivemedia.v3.impl.data.zzcp;
import com.google.ads.interactivemedia.v3.impl.data.zzcu;
import com.google.ads.interactivemedia.v3.impl.data.zzda;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzes;
import com.google.ads.interactivemedia.v3.internal.zzfk;
import com.google.ads.interactivemedia.v3.internal.zzpg;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzbu implements VideoStreamPlayer.VideoStreamPlayerCallback, zzbv, zzbo {
    private final VideoStreamPlayer zza;
    private final zzav zzb;
    private final zzak zzc;
    private boolean zzd;
    private final zzai zze;
    private final zzbw zzf;
    private final String zzg;
    private final String zzh;
    private final StreamDisplayContainer zzi;

    public zzbu(String str, zzav zzavVar, zzak zzakVar, StreamDisplayContainer streamDisplayContainer, String str2, Context context) {
        zzai zzaiVar = new zzai(streamDisplayContainer.getVideoStreamPlayer(), 200L);
        zzbw zzbwVar = new zzbw(zzavVar.zza(), streamDisplayContainer.getAdContainer());
        this.zzd = false;
        this.zza = streamDisplayContainer.getVideoStreamPlayer();
        this.zzc = zzakVar;
        this.zzg = str;
        this.zzb = zzavVar;
        this.zzh = str2;
        this.zzd = false;
        this.zzi = streamDisplayContainer;
        this.zze = zzaiVar;
        this.zzf = zzbwVar;
    }

    private final void zzo(JavaScriptMessage.MsgType msgType, Object obj) {
        this.zzb.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.videoDisplay1, msgType, this.zzg, obj));
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.zza.getContentProgress();
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onContentComplete() {
        this.zzb.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsLoader, JavaScriptMessage.MsgType.contentComplete, "*", null));
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onPause() {
        zzo(JavaScriptMessage.MsgType.pause, null);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onResume() {
        zzo(JavaScriptMessage.MsgType.play, null);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onUserTextReceived(String str) {
        if (zzpg.zzc(str)) {
            return;
        }
        zzo(JavaScriptMessage.MsgType.timedMetadata, zzbt.create(str));
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onVolumeChanged(int i2) {
        zzo(JavaScriptMessage.MsgType.volumeChange, zzda.builder().volumePercentage(i2).build());
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbo
    public final void zza(VideoProgressUpdate videoProgressUpdate) {
        if (!this.zzd) {
            zzo(JavaScriptMessage.MsgType.start, zzda.builder().volumePercentage(this.zza.getVolume()).build());
            this.zzd = true;
        }
        zzo(JavaScriptMessage.MsgType.timeupdate, zzcu.create(videoProgressUpdate));
    }

    public final void zzb() {
        this.zza.onAdBreakEnded();
        this.zzf.zza();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzc() {
        zzeo.zzc("Destroying StreamVideoDisplay");
        this.zza.removeCallback(this);
        this.zze.zzf();
        this.zze.zzd(this);
        this.zzf.zza();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzd() {
        this.zze.zzc(this);
        this.zze.zze();
    }

    public final void zze() {
        this.zza.onAdBreakStarted();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzf(JavaScriptMessage.MsgChannel msgChannel, JavaScriptMessage.MsgType msgType, zzcf zzcfVar) {
        String string;
        JavaScriptMessage.MsgType msgType2 = JavaScriptMessage.MsgType.activate;
        int iOrdinal = msgType.ordinal();
        if (iOrdinal != 47) {
            if (iOrdinal == 55) {
                this.zza.pause();
                return;
            } else {
                if (iOrdinal != 56) {
                    return;
                }
                this.zza.resume();
                return;
            }
        }
        if (zzcfVar == null || (string = zzcfVar.streamUrl) == null) {
            this.zzc.zzc(new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
            return;
        }
        int i2 = 0;
        this.zzd = false;
        String str = this.zzh;
        if (str != null && str.length() != 0) {
            String string2 = "";
            String strReplaceAll = str.trim().replaceAll("\\s+", "");
            if (strReplaceAll.charAt(0) == '?') {
                strReplaceAll = strReplaceAll.substring(1);
            }
            if (strReplaceAll.length() != 0) {
                Map mapZza = zzfk.zza(Uri.parse(string));
                HashMap map = new HashMap();
                Uri.Builder builderBuildUpon = Uri.parse(string).buildUpon();
                builderBuildUpon.clearQuery();
                Map mapZza2 = zzfk.zza(Uri.parse("http://www.dom.com/path?".concat(strReplaceAll)));
                map.putAll(mapZza2);
                if (!mapZza.isEmpty()) {
                    for (String str2 : mapZza.keySet()) {
                        if (!mapZza2.containsKey(str2)) {
                            map.put(str2, (String) mapZza.get(str2));
                        }
                    }
                }
                if (!map.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : map.entrySet()) {
                        String str3 = (String) entry.getKey();
                        String str4 = (String) entry.getValue();
                        sb.append(str3);
                        sb.append("=");
                        sb.append(str4);
                        if (i2 < map.size() - 1) {
                            sb.append("&");
                        }
                        i2++;
                    }
                    string2 = sb.toString();
                }
                builderBuildUpon.encodedQuery(string2);
                string = builderBuildUpon.build().toString();
            }
        }
        this.zza.loadUrl(string, zzcfVar.subtitles);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzg(zzcp zzcpVar) {
        if (!(this.zza instanceof ResizablePlayer)) {
            zzeo.zza("Stream player does not support resizing.");
            return;
        }
        if (!zzes.zza(this.zzi, zzcpVar)) {
            zzeo.zza("Video resize parameters were not within the container bounds.");
            return;
        }
        int width = this.zzi.getAdContainer().getWidth();
        int height = this.zzi.getAdContainer().getHeight();
        ((ResizablePlayer) this.zza).resize(zzcpVar.x().intValue(), zzcpVar.y().intValue(), (width - zzcpVar.x().intValue()) - zzcpVar.width().intValue(), (height - zzcpVar.y().intValue()) - zzcpVar.height().intValue());
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbv
    public final void zzh() {
        VideoStreamPlayer videoStreamPlayer = this.zza;
        if (videoStreamPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoStreamPlayer).resize(0, 0, 0, 0);
        }
    }

    public final void zzi() {
        this.zza.onAdPeriodEnded();
    }

    public final void zzj() {
        this.zza.onAdPeriodStarted();
    }

    public final void zzk() {
        this.zza.addCallback(this);
    }

    public final void zzl(long j2) {
        this.zza.seek(j2);
    }

    public final void zzm(com.google.ads.interactivemedia.v3.impl.data.zzc zzcVar) {
        if (zzcVar.isLinear()) {
            this.zzf.zzb();
        }
    }

    public final void zzn() {
        this.zzf.zza();
    }
}
