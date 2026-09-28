package com.google.ads.interactivemedia.v3.impl.data;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.impl.AdsRequestImpl;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqh;
import com.google.ads.interactivemedia.v3.internal.zzqi;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class zzbr {
    private static final boolean SUPPORTS_NATIVE_NETWORKING = true;

    public static zzbq builder() {
        return new zzz();
    }

    public static zzbr create(AdsRequest adsRequest, String str, Map<String, String> map, List<zzcq> list, @Nullable Map<String, String> map2, String str2, zzcy zzcyVar, ImaSdkSettings imaSdkSettings, com.google.ads.interactivemedia.v3.impl.zzs zzsVar, boolean z, boolean z2, String str3, zzbv zzbvVar, AdDisplayContainer adDisplayContainer) {
        String adTagUrl = adsRequest.getAdTagUrl();
        String adsResponse = adsRequest.getAdsResponse();
        AdsRequestImpl adsRequestImpl = (AdsRequestImpl) adsRequest;
        AdsRequestImpl.AutoPlayState autoPlayStateZzb = adsRequestImpl.zzb();
        AdsRequestImpl.MutePlayState mutePlayStateZzd = adsRequestImpl.zzd();
        AdsRequestImpl.ContinuousPlayState continuousPlayStateZzc = adsRequestImpl.zzc();
        Float fZze = adsRequestImpl.zze();
        List<String> listZzi = adsRequestImpl.zzi();
        String strZzh = adsRequestImpl.zzh();
        String contentUrl = adsRequest.getContentUrl();
        Float fZzg = adsRequestImpl.zzg();
        Float fZzf = adsRequestImpl.zzf();
        Map<String, String> companionSlots = getCompanionSlots((com.google.ads.interactivemedia.v3.impl.zzc) adDisplayContainer);
        ViewGroup adContainer = adDisplayContainer.getAdContainer();
        zzbq zzbqVarBuilder = builder();
        zzbqVarBuilder.adTagUrl(adTagUrl);
        zzbqVarBuilder.adsResponse(adsResponse);
        zzbqVarBuilder.companionSlots(companionSlots);
        zzbqVarBuilder.consentSettings(map);
        zzbqVarBuilder.contentDuration(fZze);
        zzbqVarBuilder.contentKeywords(listZzi);
        zzbqVarBuilder.contentTitle(strZzh);
        zzbqVarBuilder.contentUrl(contentUrl);
        zzbqVarBuilder.env(str);
        zzbqVarBuilder.secureSignals(list);
        zzbqVarBuilder.identifierInfo(zzbvVar);
        Boolean boolValueOf = Boolean.valueOf(z);
        zzbqVarBuilder.isTv(boolValueOf);
        zzbqVarBuilder.isAndroidTvAdsFramework(Boolean.valueOf(z2));
        zzbqVarBuilder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        zzbqVarBuilder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        zzbqVarBuilder.liveStreamPrefetchSeconds(fZzf);
        zzbqVarBuilder.marketAppInfo(zzsVar);
        zzbqVarBuilder.msParameter(str3);
        zzbqVarBuilder.network(str2);
        zzbqVarBuilder.videoEnvironment(zzcyVar);
        Boolean bool = Boolean.TRUE;
        zzbqVarBuilder.omidAdSessionsOnStartedOnly(bool);
        zzbqVarBuilder.platformSignals(map2);
        zzbqVarBuilder.settings(imaSdkSettings);
        zzbqVarBuilder.supportsExternalNavigation(Boolean.valueOf(!z));
        zzbqVarBuilder.supportsIconClickFallback(boolValueOf);
        zzbqVarBuilder.supportsNativeNetworking(bool);
        zzbqVarBuilder.supportsResizing(Boolean.valueOf(adDisplayContainer.getPlayer() instanceof ResizablePlayer));
        zzbqVarBuilder.usesCustomVideoPlayback(bool);
        zzbqVarBuilder.vastLoadTimeout(fZzg);
        zzbqVarBuilder.videoContinuousPlay(continuousPlayStateZzc);
        zzbqVarBuilder.videoPlayActivation(autoPlayStateZzb);
        zzbqVarBuilder.videoPlayMuted(mutePlayStateZzd);
        return zzbqVarBuilder.build();
    }

    public static zzbr createFromStreamRequest(StreamRequest streamRequest, String str, Map<String, String> map, List<zzcq> list, @Nullable Map<String, String> map2, String str2, zzcy zzcyVar, ImaSdkSettings imaSdkSettings, com.google.ads.interactivemedia.v3.impl.zzs zzsVar, boolean z, boolean z2, String str3, zzbv zzbvVar, StreamDisplayContainer streamDisplayContainer) {
        Map<String, String> companionSlots = getCompanionSlots((com.google.ads.interactivemedia.v3.impl.zzbq) streamDisplayContainer);
        ViewGroup adContainer = streamDisplayContainer.getAdContainer();
        StreamRequest.StreamFormat format = streamRequest.getFormat();
        StreamRequest.StreamFormat streamFormat = StreamRequest.StreamFormat.DASH;
        zzbq zzbqVarBuilder = builder();
        zzbqVarBuilder.adTagParameters(streamRequest.getAdTagParameters());
        zzbqVarBuilder.apiKey(streamRequest.getApiKey());
        zzbqVarBuilder.assetKey(streamRequest.getAssetKey());
        zzbqVarBuilder.authToken(streamRequest.getAuthToken());
        zzbqVarBuilder.companionSlots(companionSlots);
        zzbqVarBuilder.consentSettings(map);
        zzbqVarBuilder.contentSourceId(streamRequest.getContentSourceId());
        zzbqVarBuilder.contentUrl(streamRequest.getContentUrl());
        zzbqVarBuilder.customAssetKey(streamRequest.getCustomAssetKey());
        zzbqVarBuilder.enableNonce(Boolean.valueOf(streamRequest.getEnableNonce()));
        zzbqVarBuilder.env(str);
        zzbqVarBuilder.secureSignals(list);
        zzbqVarBuilder.format(format == streamFormat ? "dash" : "hls");
        zzbqVarBuilder.identifierInfo(zzbvVar);
        Boolean boolValueOf = Boolean.valueOf(z);
        zzbqVarBuilder.isTv(boolValueOf);
        zzbqVarBuilder.isAndroidTvAdsFramework(Boolean.valueOf(z2));
        zzbqVarBuilder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        zzbqVarBuilder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        zzbqVarBuilder.liveStreamEventId(streamRequest.getLiveStreamEventId());
        zzbqVarBuilder.marketAppInfo(zzsVar);
        zzbqVarBuilder.msParameter(str3);
        zzbqVarBuilder.network(str2);
        zzbqVarBuilder.videoEnvironment(zzcyVar);
        zzbqVarBuilder.networkCode(streamRequest.getNetworkCode());
        zzbqVarBuilder.contentSourceUrl(streamRequest.getContentSourceUrl());
        zzbqVarBuilder.adTagUrl(streamRequest.getAdTagUrl());
        zzbqVarBuilder.oAuthToken(streamRequest.getOAuthToken());
        Boolean bool = Boolean.TRUE;
        zzbqVarBuilder.omidAdSessionsOnStartedOnly(bool);
        zzbqVarBuilder.platformSignals(map2);
        zzbqVarBuilder.projectNumber(streamRequest.getProjectNumber());
        zzbqVarBuilder.region(streamRequest.getRegion());
        zzbqVarBuilder.settings(imaSdkSettings);
        zzbqVarBuilder.streamActivityMonitorId(streamRequest.getStreamActivityMonitorId());
        zzbqVarBuilder.supportsExternalNavigation(Boolean.valueOf(!z));
        zzbqVarBuilder.supportsIconClickFallback(boolValueOf);
        zzbqVarBuilder.supportsNativeNetworking(bool);
        zzbqVarBuilder.supportsResizing(Boolean.valueOf(streamDisplayContainer.getVideoStreamPlayer() instanceof ResizablePlayer));
        zzbqVarBuilder.useQAStreamBaseUrl(streamRequest.getUseQAStreamBaseUrl());
        zzbqVarBuilder.videoId(streamRequest.getVideoId());
        zzbqVarBuilder.vodConfigId(streamRequest.getVodConfigId());
        return zzbqVarBuilder.build();
    }

    @Nullable
    private static Map<String, String> getCompanionSlots(com.google.ads.interactivemedia.v3.impl.zzab zzabVar) {
        Map mapZza = zzabVar.zza();
        if (mapZza == null || mapZza.isEmpty()) {
            return null;
        }
        zzqh zzqhVar = new zzqh();
        for (String str : mapZza.keySet()) {
            CompanionAdSlot companionAdSlot = (CompanionAdSlot) mapZza.get(str);
            zzqhVar.zza(str, companionAdSlot.getWidth() + "x" + companionAdSlot.getHeight());
        }
        return zzqhVar.zzc();
    }

    @Nullable
    public abstract zzqi<String, String> adTagParameters();

    @Nullable
    public abstract String adTagUrl();

    @Nullable
    public abstract String adsResponse();

    @Nullable
    public abstract String apiKey();

    @Nullable
    public abstract String assetKey();

    @Nullable
    public abstract String authToken();

    @Nullable
    public abstract zzqi<String, String> companionSlots();

    @Nullable
    public abstract zzqi<String, String> consentSettings();

    @Nullable
    public abstract Float contentDuration();

    @Nullable
    public abstract zzqf<String> contentKeywords();

    @Nullable
    public abstract String contentSourceId();

    @Nullable
    public abstract String contentSourceUrl();

    @Nullable
    public abstract String contentTitle();

    @Nullable
    public abstract String contentUrl();

    @Nullable
    public abstract String customAssetKey();

    @Nullable
    public abstract Boolean enableNonce();

    @Nullable
    public abstract String env();

    @Nullable
    public abstract String format();

    @Nullable
    public abstract zzbv identifierInfo();

    @Nullable
    public abstract Boolean isAndroidTvAdsFramework();

    @Nullable
    public abstract Boolean isTv();

    @Nullable
    public abstract Integer linearAdSlotHeight();

    @Nullable
    public abstract Integer linearAdSlotWidth();

    @Nullable
    public abstract String liveStreamEventId();

    @Nullable
    public abstract Float liveStreamPrefetchSeconds();

    @Nullable
    public abstract com.google.ads.interactivemedia.v3.impl.zzs marketAppInfo();

    @Nullable
    public abstract String msParameter();

    @Nullable
    public abstract String network();

    @Nullable
    public abstract String networkCode();

    @Nullable
    public abstract String oAuthToken();

    @Nullable
    public abstract Boolean omidAdSessionsOnStartedOnly();

    @Nullable
    public abstract zzqi<String, String> platformSignals();

    @Nullable
    public abstract String projectNumber();

    @Nullable
    public abstract String region();

    @Nullable
    public abstract zzqf<zzcq> secureSignals();

    @Nullable
    public abstract ImaSdkSettings settings();

    @Nullable
    public abstract String streamActivityMonitorId();

    @Nullable
    public abstract Boolean supportsExternalNavigation();

    @Nullable
    public abstract Boolean supportsIconClickFallback();

    @Nullable
    public abstract Boolean supportsNativeNetworking();

    @Nullable
    public abstract Boolean supportsResizing();

    @Nullable
    public abstract Boolean useQAStreamBaseUrl();

    @Nullable
    public abstract Boolean usesCustomVideoPlayback();

    @Nullable
    public abstract Float vastLoadTimeout();

    @Nullable
    public abstract AdsRequestImpl.ContinuousPlayState videoContinuousPlay();

    @Nullable
    public abstract zzcy videoEnvironment();

    @Nullable
    public abstract String videoId();

    @Nullable
    public abstract AdsRequestImpl.AutoPlayState videoPlayActivation();

    @Nullable
    public abstract AdsRequestImpl.MutePlayState videoPlayMuted();

    @Nullable
    public abstract String vodConfigId();
}
