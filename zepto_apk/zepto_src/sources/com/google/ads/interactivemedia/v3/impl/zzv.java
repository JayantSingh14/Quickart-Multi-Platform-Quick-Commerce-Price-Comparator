package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzcu;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public final class zzv extends zzac implements AdsManager, AdErrorEvent.AdErrorListener {

    @Nullable
    private final List zza;

    @Nullable
    private zzbw zzb;

    @Nullable
    private zzah zzc;

    @Nullable
    private zzai zzd;

    private zzv(String str, zzav zzavVar, AdDisplayContainer adDisplayContainer, @Nullable List list, zzbd zzbdVar, @Nullable zzai zzaiVar, zzb zzbVar, zzbw zzbwVar, zzbm zzbmVar, zzak zzakVar, Context context, boolean z) {
        super(str, zzavVar, zzbdVar, adDisplayContainer, zzbVar, zzbmVar, zzakVar, context, z);
        this.zza = list;
        this.zzd = zzaiVar;
        this.zzb = zzbwVar;
    }

    public static zzv zza(String str, zzav zzavVar, AdDisplayContainer adDisplayContainer, @Nullable zzai zzaiVar, @Nullable List list, @Nullable SortedSet sortedSet, zzbm zzbmVar, zzak zzakVar, Context context, boolean z) {
        zzv zzvVar = new zzv(str, zzavVar, adDisplayContainer, list, new zzbd(str, zzavVar, zzakVar, adDisplayContainer, context), zzaiVar, new zzb(str, zzavVar, adDisplayContainer.getAdContainer()), new zzbw(zzavVar.zza(), adDisplayContainer.getAdContainer()), zzbmVar, zzakVar, context, z);
        zzai zzaiVar2 = zzvVar.zzd;
        if (zzaiVar2 != null) {
            zzah zzahVar = new zzah(zzavVar, sortedSet, str);
            zzvVar.zzc = zzahVar;
            zzaiVar2.zzc(zzahVar);
            zzvVar.zzd.zze();
        }
        zzvVar.addAdErrorListener(zzvVar);
        return zzvVar;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void clicked() {
        zzp(JavaScriptMessage.MsgType.click);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzac, com.google.ads.interactivemedia.v3.api.BaseManager
    public final void destroy() {
        super.destroy();
        zzai zzaiVar = this.zzd;
        if (zzaiVar != null) {
            zzaiVar.zzf();
            this.zzd = null;
        }
        zzbw zzbwVar = this.zzb;
        if (zzbwVar != null) {
            zzbwVar.zza();
            this.zzb = null;
        }
        zzp(JavaScriptMessage.MsgType.destroy);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void discardAdBreak() {
        zzp(JavaScriptMessage.MsgType.discardAdBreak);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final List<Float> getAdCuePoints() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final boolean isCustomPlaybackUsed() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
        zzbw zzbwVar = this.zzb;
        if (zzbwVar != null) {
            zzbwVar.zza();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void pause() {
        zzp(JavaScriptMessage.MsgType.pause);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void requestNextAdBreak() {
        zzai zzaiVar = this.zzd;
        if (zzaiVar != null) {
            zzo(JavaScriptMessage.MsgChannel.contentTimeUpdate, JavaScriptMessage.MsgType.contentTimeUpdate, zzcu.create(zzaiVar.zza()));
            zzp(JavaScriptMessage.MsgType.requestNextAdBreak);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void resume() {
        zzp(JavaScriptMessage.MsgType.resume);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void skip() {
        zzp(JavaScriptMessage.MsgType.skip);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void start() {
        zzp(JavaScriptMessage.MsgType.start);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzac
    public final Map zzb(AdsRenderingSettings adsRenderingSettings) {
        Map mapZzb = super.zzb(adsRenderingSettings);
        zzai zzaiVar = this.zzd;
        if (zzaiVar != null) {
            VideoProgressUpdate videoProgressUpdateZza = zzaiVar.zza();
            if (!videoProgressUpdateZza.equals(VideoProgressUpdate.VIDEO_TIME_NOT_READY)) {
                float currentTimeMs = videoProgressUpdateZza.getCurrentTimeMs();
                StringBuilder sb = new StringBuilder("AdsManager.init -> Setting contentStartTime ");
                double d2 = currentTimeMs / 1000.0f;
                sb.append(d2);
                zzeo.zzc(sb.toString());
                mapZzb.put("contentStartTime", Double.valueOf(d2));
            }
        }
        return mapZzb;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzac, com.google.ads.interactivemedia.v3.impl.zzat
    public final void zzc(zzas zzasVar) {
        zzbw zzbwVar;
        zzbd zzbdVar = (zzbd) zzd();
        AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int iOrdinal = zzasVar.zza.ordinal();
        if (iOrdinal == 0) {
            super.destroy();
            zzai zzaiVar = this.zzd;
            if (zzaiVar != null) {
                zzaiVar.zzf();
                this.zzd = null;
            }
            zzbw zzbwVar2 = this.zzb;
            if (zzbwVar2 != null) {
                zzbwVar2.zza();
                this.zzb = null;
            }
            zzp(JavaScriptMessage.MsgType.destroy);
            super.zzc(zzasVar);
            zzn();
            return;
        }
        if (iOrdinal == 5) {
            zzai zzaiVar2 = this.zzd;
            if (zzaiVar2 != null) {
                zzaiVar2.zzf();
            }
        } else if (iOrdinal == 6) {
            zzbw zzbwVar3 = this.zzb;
            if (zzbwVar3 != null) {
                zzbwVar3.zza();
            }
            zzbdVar.zze();
            zzai zzaiVar3 = this.zzd;
            if (zzaiVar3 != null) {
                zzaiVar3.zze();
            }
        } else if (iOrdinal == 14) {
            zzbw zzbwVar4 = this.zzb;
            if (zzbwVar4 != null) {
                zzbwVar4.zza();
            }
        } else if (iOrdinal == 15 && (zzbwVar = this.zzb) != null) {
            zzbwVar.zzb();
        }
        super.zzc(zzasVar);
    }
}
