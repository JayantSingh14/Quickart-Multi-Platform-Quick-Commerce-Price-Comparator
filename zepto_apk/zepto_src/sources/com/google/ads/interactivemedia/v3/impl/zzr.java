package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.impl.data.zzby;
import java.util.List;
import java.util.SortedSet;

/* loaded from: classes3.dex */
final class zzr implements zzar {
    final /* synthetic */ zzu zza;

    public zzr(zzu zzuVar) {
        this.zza = zzuVar;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzar
    public final void zza(String str, AdError.AdErrorType adErrorType, int i2, String str2) {
        this.zza.zze.zzc(new zzd(new AdError(adErrorType, i2, str2), this.zza.zzg.get(str) != null ? ((AdsRequest) this.zza.zzg.get(str)).getUserRequestContext() : this.zza.zzh.get(str) != null ? ((StreamRequest) this.zza.zzh.get(str)).getUserRequestContext() : new Object()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzar
    public final void zzb(String str, AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str2) {
        this.zza.zze.zzc(new zzd(new AdError(adErrorType, adErrorCode, "adsLoaded message did not contain cue points."), this.zza.zzg.get(str) != null ? ((AdsRequest) this.zza.zzg.get(str)).getUserRequestContext() : this.zza.zzh.get(str) != null ? ((StreamRequest) this.zza.zzh.get(str)).getUserRequestContext() : new Object()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzar
    public final void zzc(String str, List list, SortedSet sortedSet, boolean z) {
        zzu zzuVar = this.zza;
        AdDisplayContainer adDisplayContainer = (AdDisplayContainer) zzuVar.zzk;
        AdsRequest adsRequest = (AdsRequest) zzuVar.zzg.get(str);
        if (adsRequest == null) {
            this.zza.zze.zzc(new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Request not found for session id: ".concat(String.valueOf(str))), new Object()));
            return;
        }
        ContentProgressProvider contentProgressProvider = adsRequest.getContentProgressProvider();
        AdError adError = null;
        zzai zzaiVar = contentProgressProvider != null ? new zzai(contentProgressProvider, 200L) : null;
        this.zza.zzi.zze(adsRequest.getContentUrl());
        if (sortedSet != null && !sortedSet.isEmpty() && zzaiVar == null) {
            adError = new AdError(AdError.AdErrorType.PLAY, AdError.AdErrorCode.PLAYLIST_NO_CONTENT_TRACKING, "Unable to handle cue points, no content progress provider configured.");
        }
        if (adError != null) {
            this.zza.zze.zzc(new zzd(adError, adsRequest.getUserRequestContext()));
            return;
        }
        zzu zzuVar2 = this.zza;
        zzu.zzl(this.zza, new zzw(zzv.zza(str, zzuVar2.zzc, adDisplayContainer, zzaiVar, list, sortedSet, zzuVar2.zzi, new zzak(zzuVar2.zzp), this.zza.zza, z), adsRequest.getUserRequestContext()));
        this.zza.zzp.zzg(zzby.EVENT_NATIVE_REQUEST_READY, str);
        this.zza.zzp.zzb(str);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzar
    public final void zzd(String str, String str2, boolean z) {
        zzu zzuVar = this.zza;
        StreamDisplayContainer streamDisplayContainer = (StreamDisplayContainer) zzuVar.zzk;
        StreamRequest streamRequest = (StreamRequest) zzuVar.zzh.get(str);
        if (streamRequest == null) {
            this.zza.zze.zzc(new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Request not found for session id: ".concat(String.valueOf(str))), new Object()));
            return;
        }
        this.zza.zzi.zze(streamRequest.getContentUrl());
        this.zza.zzi.zzf(true);
        zzu zzuVar2 = this.zza;
        zzav zzavVar = zzuVar2.zzc;
        String manifestSuffix = streamRequest.getManifestSuffix();
        zzbm zzbmVar = zzuVar2.zzi;
        zzak zzakVar = new zzak(zzuVar2.zzp);
        Context context = this.zza.zza;
        zzu.zzl(zzuVar2, new zzw(new zzbr(str, zzavVar, streamDisplayContainer, new zzbu(str, zzavVar, zzakVar, streamDisplayContainer, manifestSuffix, context), new zzb(str, zzavVar, streamDisplayContainer.getAdContainer()), zzbmVar, zzakVar, context, str2, z), streamRequest.getUserRequestContext()));
        this.zza.zzp.zzg(zzby.EVENT_NATIVE_REQUEST_READY, str);
        this.zza.zzp.zzb(str);
    }
}
