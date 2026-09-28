package com.google.ads.interactivemedia.v3.impl;

import androidx.annotation.NonNull;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.internal.zzed;
import com.google.ads.interactivemedia.v3.internal.zzef;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class AdsRequestImpl implements AdsRequest {
    private String zza;
    private String zzb;
    private ContentProgressProvider zzc;
    private AutoPlayState zzd = AutoPlayState.UNKNOWN;
    private MutePlayState zze = MutePlayState.UNKNOWN;
    private ContinuousPlayState zzf = ContinuousPlayState.UNKNOWN;
    private Float zzg;
    private List zzh;
    private String zzi;
    private String zzj;
    private Float zzk;
    private Float zzl;
    private SecureSignals zzm;
    private transient Object zzn;

    public enum AutoPlayState {
        AUTO,
        CLICK,
        UNKNOWN
    }

    public enum ContinuousPlayState {
        OFF,
        ON,
        UNKNOWN
    }

    public enum MutePlayState {
        MUTED,
        UNKNOWN,
        UNMUTED
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    @NonNull
    public final String getAdTagUrl() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    @NonNull
    public final String getAdsResponse() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    @NonNull
    public final ContentProgressProvider getContentProgressProvider() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseRequest
    @NonNull
    public final String getContentUrl() {
        return this.zzj;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    @NonNull
    public final String getExtraParameter(@NonNull String str) {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    @NonNull
    public final Map<String, String> getExtraParameters() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseRequest
    @NonNull
    public final SecureSignals getSecureSignals() {
        return this.zzm;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseRequest
    @NonNull
    public final Object getUserRequestContext() {
        return this.zzn;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdTagUrl(@NonNull String str) {
        this.zza = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdWillAutoPlay(boolean z) {
        this.zzd = z ? AutoPlayState.AUTO : AutoPlayState.CLICK;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdWillPlayMuted(boolean z) {
        this.zze = z ? MutePlayState.MUTED : MutePlayState.UNMUTED;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdsResponse(@NonNull String str) {
        this.zzb = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentDuration(float f2) {
        this.zzg = Float.valueOf(f2);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentKeywords(@NonNull List<String> list) {
        this.zzh = list;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentProgressProvider(@NonNull ContentProgressProvider contentProgressProvider) {
        this.zzc = contentProgressProvider;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentTitle(@NonNull String str) {
        this.zzi = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseRequest
    public final void setContentUrl(@NonNull String str) {
        this.zzj = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContinuousPlayback(boolean z) {
        this.zzf = z ? ContinuousPlayState.ON : ContinuousPlayState.OFF;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setExtraParameter(@NonNull String str, @NonNull String str2) {
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setLiveStreamPrefetchSeconds(float f2) {
        this.zzl = Float.valueOf(f2);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseRequest
    public final void setSecureSignals(@NonNull SecureSignals secureSignals) {
        this.zzm = secureSignals;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseRequest
    public final void setUserRequestContext(@NonNull Object obj) {
        this.zzn = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setVastLoadTimeout(float f2) {
        this.zzk = Float.valueOf(f2);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseRequest
    public final zzef zza() {
        return new zzed(this.zza);
    }

    @NonNull
    public final AutoPlayState zzb() {
        return this.zzd;
    }

    @NonNull
    public final ContinuousPlayState zzc() {
        return this.zzf;
    }

    @NonNull
    public final MutePlayState zzd() {
        return this.zze;
    }

    @NonNull
    public final Float zze() {
        return this.zzg;
    }

    @NonNull
    public final Float zzf() {
        return this.zzl;
    }

    @NonNull
    public final Float zzg() {
        return this.zzk;
    }

    @NonNull
    public final String zzh() {
        return this.zzi;
    }

    @NonNull
    public final List zzi() {
        return this.zzh;
    }
}
