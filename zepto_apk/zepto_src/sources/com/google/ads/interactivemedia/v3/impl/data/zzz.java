package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.AdsRequestImpl;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqi;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzz implements zzbq {
    private zzqi<String, String> adTagParameters;
    private String adTagUrl;
    private String adsResponse;
    private String apiKey;
    private String assetKey;
    private String authToken;
    private zzqi<String, String> companionSlots;
    private zzqi<String, String> consentSettings;
    private Float contentDuration;
    private zzqf<String> contentKeywords;
    private String contentSourceId;
    private String contentSourceUrl;
    private String contentTitle;
    private String contentUrl;
    private String customAssetKey;
    private Boolean enableNonce;
    private String env;
    private String format;
    private zzbv identifierInfo;
    private Boolean isAndroidTvAdsFramework;
    private Boolean isTv;
    private Integer linearAdSlotHeight;
    private Integer linearAdSlotWidth;
    private String liveStreamEventId;
    private Float liveStreamPrefetchSeconds;
    private com.google.ads.interactivemedia.v3.impl.zzs marketAppInfo;
    private String msParameter;
    private String network;
    private String networkCode;
    private String oAuthToken;
    private Boolean omidAdSessionsOnStartedOnly;
    private zzqi<String, String> platformSignals;
    private String projectNumber;
    private String region;
    private zzqf<zzcq> secureSignals;
    private ImaSdkSettings settings;
    private String streamActivityMonitorId;
    private Boolean supportsExternalNavigation;
    private Boolean supportsIconClickFallback;
    private Boolean supportsNativeNetworking;
    private Boolean supportsResizing;
    private Boolean useQAStreamBaseUrl;
    private Boolean usesCustomVideoPlayback;
    private Float vastLoadTimeout;
    private AdsRequestImpl.ContinuousPlayState videoContinuousPlay;
    private zzcy videoEnvironment;
    private String videoId;
    private AdsRequestImpl.AutoPlayState videoPlayActivation;
    private AdsRequestImpl.MutePlayState videoPlayMuted;
    private String vodConfigId;

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq adTagParameters(Map<String, String> map) {
        this.adTagParameters = map == null ? null : zzqi.zzc(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq adTagUrl(String str) {
        this.adTagUrl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq adsResponse(String str) {
        this.adsResponse = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq apiKey(String str) {
        this.apiKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq assetKey(String str) {
        this.assetKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq authToken(String str) {
        this.authToken = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbr build() {
        return new zzab(this.adTagParameters, this.adTagUrl, this.adsResponse, this.apiKey, this.assetKey, this.authToken, this.companionSlots, this.contentDuration, this.contentKeywords, this.contentSourceUrl, this.contentTitle, this.contentUrl, this.contentSourceId, this.consentSettings, this.customAssetKey, this.enableNonce, this.env, this.secureSignals, this.format, this.identifierInfo, this.isTv, this.isAndroidTvAdsFramework, this.linearAdSlotWidth, this.linearAdSlotHeight, this.liveStreamEventId, this.liveStreamPrefetchSeconds, this.marketAppInfo, this.msParameter, this.network, this.videoEnvironment, this.networkCode, this.oAuthToken, this.omidAdSessionsOnStartedOnly, this.platformSignals, this.projectNumber, this.region, this.settings, this.supportsExternalNavigation, this.supportsIconClickFallback, this.supportsNativeNetworking, this.streamActivityMonitorId, this.supportsResizing, this.useQAStreamBaseUrl, this.usesCustomVideoPlayback, this.vastLoadTimeout, this.videoId, this.videoPlayActivation, this.videoContinuousPlay, this.videoPlayMuted, this.vodConfigId);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq companionSlots(Map<String, String> map) {
        this.companionSlots = map == null ? null : zzqi.zzc(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq consentSettings(Map<String, String> map) {
        this.consentSettings = map == null ? null : zzqi.zzc(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq contentDuration(Float f2) {
        this.contentDuration = f2;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq contentKeywords(List<String> list) {
        this.contentKeywords = list == null ? null : zzqf.zzk(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq contentSourceId(String str) {
        this.contentSourceId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq contentSourceUrl(String str) {
        this.contentSourceUrl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq contentTitle(String str) {
        this.contentTitle = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq contentUrl(String str) {
        this.contentUrl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq customAssetKey(String str) {
        this.customAssetKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq enableNonce(Boolean bool) {
        this.enableNonce = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq env(String str) {
        this.env = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq format(String str) {
        this.format = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq identifierInfo(zzbv zzbvVar) {
        this.identifierInfo = zzbvVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq isAndroidTvAdsFramework(Boolean bool) {
        this.isAndroidTvAdsFramework = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq isTv(Boolean bool) {
        this.isTv = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq linearAdSlotHeight(Integer num) {
        this.linearAdSlotHeight = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq linearAdSlotWidth(Integer num) {
        this.linearAdSlotWidth = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq liveStreamEventId(String str) {
        this.liveStreamEventId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq liveStreamPrefetchSeconds(Float f2) {
        this.liveStreamPrefetchSeconds = f2;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq marketAppInfo(com.google.ads.interactivemedia.v3.impl.zzs zzsVar) {
        this.marketAppInfo = zzsVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq msParameter(String str) {
        this.msParameter = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq network(String str) {
        this.network = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq networkCode(String str) {
        this.networkCode = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq oAuthToken(String str) {
        this.oAuthToken = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq omidAdSessionsOnStartedOnly(Boolean bool) {
        this.omidAdSessionsOnStartedOnly = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq platformSignals(@Nullable Map<String, String> map) {
        this.platformSignals = map == null ? null : zzqi.zzc(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq projectNumber(String str) {
        this.projectNumber = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq region(String str) {
        this.region = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq secureSignals(List<zzcq> list) {
        this.secureSignals = list == null ? null : zzqf.zzk(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq settings(ImaSdkSettings imaSdkSettings) {
        this.settings = imaSdkSettings;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq streamActivityMonitorId(String str) {
        this.streamActivityMonitorId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq supportsExternalNavigation(Boolean bool) {
        this.supportsExternalNavigation = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq supportsIconClickFallback(Boolean bool) {
        this.supportsIconClickFallback = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq supportsNativeNetworking(Boolean bool) {
        this.supportsNativeNetworking = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq supportsResizing(Boolean bool) {
        this.supportsResizing = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq useQAStreamBaseUrl(Boolean bool) {
        this.useQAStreamBaseUrl = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq usesCustomVideoPlayback(Boolean bool) {
        this.usesCustomVideoPlayback = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq vastLoadTimeout(Float f2) {
        this.vastLoadTimeout = f2;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq videoContinuousPlay(AdsRequestImpl.ContinuousPlayState continuousPlayState) {
        this.videoContinuousPlay = continuousPlayState;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq videoEnvironment(zzcy zzcyVar) {
        this.videoEnvironment = zzcyVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq videoId(String str) {
        this.videoId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq videoPlayActivation(AdsRequestImpl.AutoPlayState autoPlayState) {
        this.videoPlayActivation = autoPlayState;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq videoPlayMuted(AdsRequestImpl.MutePlayState mutePlayState) {
        this.videoPlayMuted = mutePlayState;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbq
    public zzbq vodConfigId(String str) {
        this.vodConfigId = str;
        return this;
    }
}
