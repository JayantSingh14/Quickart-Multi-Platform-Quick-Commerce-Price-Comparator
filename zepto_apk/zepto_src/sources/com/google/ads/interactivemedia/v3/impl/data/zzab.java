package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.AdsRequestImpl;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqi;

/* loaded from: classes3.dex */
final class zzab extends zzbr {

    @Nullable
    private final zzqi<String, String> adTagParameters;

    @Nullable
    private final String adTagUrl;

    @Nullable
    private final String adsResponse;

    @Nullable
    private final String apiKey;

    @Nullable
    private final String assetKey;

    @Nullable
    private final String authToken;

    @Nullable
    private final zzqi<String, String> companionSlots;

    @Nullable
    private final zzqi<String, String> consentSettings;

    @Nullable
    private final Float contentDuration;

    @Nullable
    private final zzqf<String> contentKeywords;

    @Nullable
    private final String contentSourceId;

    @Nullable
    private final String contentSourceUrl;

    @Nullable
    private final String contentTitle;

    @Nullable
    private final String contentUrl;

    @Nullable
    private final String customAssetKey;

    @Nullable
    private final Boolean enableNonce;

    @Nullable
    private final String env;

    @Nullable
    private final String format;

    @Nullable
    private final zzbv identifierInfo;

    @Nullable
    private final Boolean isAndroidTvAdsFramework;

    @Nullable
    private final Boolean isTv;

    @Nullable
    private final Integer linearAdSlotHeight;

    @Nullable
    private final Integer linearAdSlotWidth;

    @Nullable
    private final String liveStreamEventId;

    @Nullable
    private final Float liveStreamPrefetchSeconds;

    @Nullable
    private final com.google.ads.interactivemedia.v3.impl.zzs marketAppInfo;

    @Nullable
    private final String msParameter;

    @Nullable
    private final String network;

    @Nullable
    private final String networkCode;

    @Nullable
    private final String oAuthToken;

    @Nullable
    private final Boolean omidAdSessionsOnStartedOnly;

    @Nullable
    private final zzqi<String, String> platformSignals;

    @Nullable
    private final String projectNumber;

    @Nullable
    private final String region;

    @Nullable
    private final zzqf<zzcq> secureSignals;

    @Nullable
    private final ImaSdkSettings settings;

    @Nullable
    private final String streamActivityMonitorId;

    @Nullable
    private final Boolean supportsExternalNavigation;

    @Nullable
    private final Boolean supportsIconClickFallback;

    @Nullable
    private final Boolean supportsNativeNetworking;

    @Nullable
    private final Boolean supportsResizing;

    @Nullable
    private final Boolean useQAStreamBaseUrl;

    @Nullable
    private final Boolean usesCustomVideoPlayback;

    @Nullable
    private final Float vastLoadTimeout;

    @Nullable
    private final AdsRequestImpl.ContinuousPlayState videoContinuousPlay;

    @Nullable
    private final zzcy videoEnvironment;

    @Nullable
    private final String videoId;

    @Nullable
    private final AdsRequestImpl.AutoPlayState videoPlayActivation;

    @Nullable
    private final AdsRequestImpl.MutePlayState videoPlayMuted;

    @Nullable
    private final String vodConfigId;

    private zzab(@Nullable zzqi<String, String> zzqiVar, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable zzqi<String, String> zzqiVar2, @Nullable Float f2, @Nullable zzqf<String> zzqfVar, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable zzqi<String, String> zzqiVar3, @Nullable String str10, @Nullable Boolean bool, @Nullable String str11, @Nullable zzqf<zzcq> zzqfVar2, @Nullable String str12, @Nullable zzbv zzbvVar, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num, @Nullable Integer num2, @Nullable String str13, @Nullable Float f3, @Nullable com.google.ads.interactivemedia.v3.impl.zzs zzsVar, @Nullable String str14, @Nullable String str15, @Nullable zzcy zzcyVar, @Nullable String str16, @Nullable String str17, @Nullable Boolean bool4, @Nullable zzqi<String, String> zzqiVar4, @Nullable String str18, @Nullable String str19, @Nullable ImaSdkSettings imaSdkSettings, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable String str20, @Nullable Boolean bool8, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable Float f4, @Nullable String str21, @Nullable AdsRequestImpl.AutoPlayState autoPlayState, @Nullable AdsRequestImpl.ContinuousPlayState continuousPlayState, @Nullable AdsRequestImpl.MutePlayState mutePlayState, @Nullable String str22) {
        this.adTagParameters = zzqiVar;
        this.adTagUrl = str;
        this.adsResponse = str2;
        this.apiKey = str3;
        this.assetKey = str4;
        this.authToken = str5;
        this.companionSlots = zzqiVar2;
        this.contentDuration = f2;
        this.contentKeywords = zzqfVar;
        this.contentSourceUrl = str6;
        this.contentTitle = str7;
        this.contentUrl = str8;
        this.contentSourceId = str9;
        this.consentSettings = zzqiVar3;
        this.customAssetKey = str10;
        this.enableNonce = bool;
        this.env = str11;
        this.secureSignals = zzqfVar2;
        this.format = str12;
        this.identifierInfo = zzbvVar;
        this.isTv = bool2;
        this.isAndroidTvAdsFramework = bool3;
        this.linearAdSlotWidth = num;
        this.linearAdSlotHeight = num2;
        this.liveStreamEventId = str13;
        this.liveStreamPrefetchSeconds = f3;
        this.marketAppInfo = zzsVar;
        this.msParameter = str14;
        this.network = str15;
        this.videoEnvironment = zzcyVar;
        this.networkCode = str16;
        this.oAuthToken = str17;
        this.omidAdSessionsOnStartedOnly = bool4;
        this.platformSignals = zzqiVar4;
        this.projectNumber = str18;
        this.region = str19;
        this.settings = imaSdkSettings;
        this.supportsExternalNavigation = bool5;
        this.supportsIconClickFallback = bool6;
        this.supportsNativeNetworking = bool7;
        this.streamActivityMonitorId = str20;
        this.supportsResizing = bool8;
        this.useQAStreamBaseUrl = bool9;
        this.usesCustomVideoPlayback = bool10;
        this.vastLoadTimeout = f4;
        this.videoId = str21;
        this.videoPlayActivation = autoPlayState;
        this.videoContinuousPlay = continuousPlayState;
        this.videoPlayMuted = mutePlayState;
        this.vodConfigId = str22;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzqi<String, String> adTagParameters() {
        return this.adTagParameters;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String adTagUrl() {
        return this.adTagUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String adsResponse() {
        return this.adsResponse;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String apiKey() {
        return this.apiKey;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String assetKey() {
        return this.assetKey;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String authToken() {
        return this.authToken;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzqi<String, String> companionSlots() {
        return this.companionSlots;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzqi<String, String> consentSettings() {
        return this.consentSettings;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Float contentDuration() {
        return this.contentDuration;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzqf<String> contentKeywords() {
        return this.contentKeywords;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String contentSourceId() {
        return this.contentSourceId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String contentSourceUrl() {
        return this.contentSourceUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String contentTitle() {
        return this.contentTitle;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String contentUrl() {
        return this.contentUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String customAssetKey() {
        return this.customAssetKey;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean enableNonce() {
        return this.enableNonce;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String env() {
        return this.env;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbr) {
            zzbr zzbrVar = (zzbr) obj;
            zzqi<String, String> zzqiVar = this.adTagParameters;
            if (zzqiVar != null ? zzqiVar.equals(zzbrVar.adTagParameters()) : zzbrVar.adTagParameters() == null) {
                String str = this.adTagUrl;
                if (str != null ? str.equals(zzbrVar.adTagUrl()) : zzbrVar.adTagUrl() == null) {
                    String str2 = this.adsResponse;
                    if (str2 != null ? str2.equals(zzbrVar.adsResponse()) : zzbrVar.adsResponse() == null) {
                        String str3 = this.apiKey;
                        if (str3 != null ? str3.equals(zzbrVar.apiKey()) : zzbrVar.apiKey() == null) {
                            String str4 = this.assetKey;
                            if (str4 != null ? str4.equals(zzbrVar.assetKey()) : zzbrVar.assetKey() == null) {
                                String str5 = this.authToken;
                                if (str5 != null ? str5.equals(zzbrVar.authToken()) : zzbrVar.authToken() == null) {
                                    zzqi<String, String> zzqiVar2 = this.companionSlots;
                                    if (zzqiVar2 != null ? zzqiVar2.equals(zzbrVar.companionSlots()) : zzbrVar.companionSlots() == null) {
                                        Float f2 = this.contentDuration;
                                        if (f2 != null ? f2.equals(zzbrVar.contentDuration()) : zzbrVar.contentDuration() == null) {
                                            zzqf<String> zzqfVar = this.contentKeywords;
                                            if (zzqfVar != null ? zzqfVar.equals(zzbrVar.contentKeywords()) : zzbrVar.contentKeywords() == null) {
                                                String str6 = this.contentSourceUrl;
                                                if (str6 != null ? str6.equals(zzbrVar.contentSourceUrl()) : zzbrVar.contentSourceUrl() == null) {
                                                    String str7 = this.contentTitle;
                                                    if (str7 != null ? str7.equals(zzbrVar.contentTitle()) : zzbrVar.contentTitle() == null) {
                                                        String str8 = this.contentUrl;
                                                        if (str8 != null ? str8.equals(zzbrVar.contentUrl()) : zzbrVar.contentUrl() == null) {
                                                            String str9 = this.contentSourceId;
                                                            if (str9 != null ? str9.equals(zzbrVar.contentSourceId()) : zzbrVar.contentSourceId() == null) {
                                                                zzqi<String, String> zzqiVar3 = this.consentSettings;
                                                                if (zzqiVar3 != null ? zzqiVar3.equals(zzbrVar.consentSettings()) : zzbrVar.consentSettings() == null) {
                                                                    String str10 = this.customAssetKey;
                                                                    if (str10 != null ? str10.equals(zzbrVar.customAssetKey()) : zzbrVar.customAssetKey() == null) {
                                                                        Boolean bool = this.enableNonce;
                                                                        if (bool != null ? bool.equals(zzbrVar.enableNonce()) : zzbrVar.enableNonce() == null) {
                                                                            String str11 = this.env;
                                                                            if (str11 != null ? str11.equals(zzbrVar.env()) : zzbrVar.env() == null) {
                                                                                zzqf<zzcq> zzqfVar2 = this.secureSignals;
                                                                                if (zzqfVar2 != null ? zzqfVar2.equals(zzbrVar.secureSignals()) : zzbrVar.secureSignals() == null) {
                                                                                    String str12 = this.format;
                                                                                    if (str12 != null ? str12.equals(zzbrVar.format()) : zzbrVar.format() == null) {
                                                                                        zzbv zzbvVar = this.identifierInfo;
                                                                                        if (zzbvVar != null ? zzbvVar.equals(zzbrVar.identifierInfo()) : zzbrVar.identifierInfo() == null) {
                                                                                            Boolean bool2 = this.isTv;
                                                                                            if (bool2 != null ? bool2.equals(zzbrVar.isTv()) : zzbrVar.isTv() == null) {
                                                                                                Boolean bool3 = this.isAndroidTvAdsFramework;
                                                                                                if (bool3 != null ? bool3.equals(zzbrVar.isAndroidTvAdsFramework()) : zzbrVar.isAndroidTvAdsFramework() == null) {
                                                                                                    Integer num = this.linearAdSlotWidth;
                                                                                                    if (num != null ? num.equals(zzbrVar.linearAdSlotWidth()) : zzbrVar.linearAdSlotWidth() == null) {
                                                                                                        Integer num2 = this.linearAdSlotHeight;
                                                                                                        if (num2 != null ? num2.equals(zzbrVar.linearAdSlotHeight()) : zzbrVar.linearAdSlotHeight() == null) {
                                                                                                            String str13 = this.liveStreamEventId;
                                                                                                            if (str13 != null ? str13.equals(zzbrVar.liveStreamEventId()) : zzbrVar.liveStreamEventId() == null) {
                                                                                                                Float f3 = this.liveStreamPrefetchSeconds;
                                                                                                                if (f3 != null ? f3.equals(zzbrVar.liveStreamPrefetchSeconds()) : zzbrVar.liveStreamPrefetchSeconds() == null) {
                                                                                                                    com.google.ads.interactivemedia.v3.impl.zzs zzsVar = this.marketAppInfo;
                                                                                                                    if (zzsVar != null ? zzsVar.equals(zzbrVar.marketAppInfo()) : zzbrVar.marketAppInfo() == null) {
                                                                                                                        String str14 = this.msParameter;
                                                                                                                        if (str14 != null ? str14.equals(zzbrVar.msParameter()) : zzbrVar.msParameter() == null) {
                                                                                                                            String str15 = this.network;
                                                                                                                            if (str15 != null ? str15.equals(zzbrVar.network()) : zzbrVar.network() == null) {
                                                                                                                                zzcy zzcyVar = this.videoEnvironment;
                                                                                                                                if (zzcyVar != null ? zzcyVar.equals(zzbrVar.videoEnvironment()) : zzbrVar.videoEnvironment() == null) {
                                                                                                                                    String str16 = this.networkCode;
                                                                                                                                    if (str16 != null ? str16.equals(zzbrVar.networkCode()) : zzbrVar.networkCode() == null) {
                                                                                                                                        String str17 = this.oAuthToken;
                                                                                                                                        if (str17 != null ? str17.equals(zzbrVar.oAuthToken()) : zzbrVar.oAuthToken() == null) {
                                                                                                                                            Boolean bool4 = this.omidAdSessionsOnStartedOnly;
                                                                                                                                            if (bool4 != null ? bool4.equals(zzbrVar.omidAdSessionsOnStartedOnly()) : zzbrVar.omidAdSessionsOnStartedOnly() == null) {
                                                                                                                                                zzqi<String, String> zzqiVar4 = this.platformSignals;
                                                                                                                                                if (zzqiVar4 != null ? zzqiVar4.equals(zzbrVar.platformSignals()) : zzbrVar.platformSignals() == null) {
                                                                                                                                                    String str18 = this.projectNumber;
                                                                                                                                                    if (str18 != null ? str18.equals(zzbrVar.projectNumber()) : zzbrVar.projectNumber() == null) {
                                                                                                                                                        String str19 = this.region;
                                                                                                                                                        if (str19 != null ? str19.equals(zzbrVar.region()) : zzbrVar.region() == null) {
                                                                                                                                                            ImaSdkSettings imaSdkSettings = this.settings;
                                                                                                                                                            if (imaSdkSettings != null ? imaSdkSettings.equals(zzbrVar.settings()) : zzbrVar.settings() == null) {
                                                                                                                                                                Boolean bool5 = this.supportsExternalNavigation;
                                                                                                                                                                if (bool5 != null ? bool5.equals(zzbrVar.supportsExternalNavigation()) : zzbrVar.supportsExternalNavigation() == null) {
                                                                                                                                                                    Boolean bool6 = this.supportsIconClickFallback;
                                                                                                                                                                    if (bool6 != null ? bool6.equals(zzbrVar.supportsIconClickFallback()) : zzbrVar.supportsIconClickFallback() == null) {
                                                                                                                                                                        Boolean bool7 = this.supportsNativeNetworking;
                                                                                                                                                                        if (bool7 != null ? bool7.equals(zzbrVar.supportsNativeNetworking()) : zzbrVar.supportsNativeNetworking() == null) {
                                                                                                                                                                            String str20 = this.streamActivityMonitorId;
                                                                                                                                                                            if (str20 != null ? str20.equals(zzbrVar.streamActivityMonitorId()) : zzbrVar.streamActivityMonitorId() == null) {
                                                                                                                                                                                Boolean bool8 = this.supportsResizing;
                                                                                                                                                                                if (bool8 != null ? bool8.equals(zzbrVar.supportsResizing()) : zzbrVar.supportsResizing() == null) {
                                                                                                                                                                                    Boolean bool9 = this.useQAStreamBaseUrl;
                                                                                                                                                                                    if (bool9 != null ? bool9.equals(zzbrVar.useQAStreamBaseUrl()) : zzbrVar.useQAStreamBaseUrl() == null) {
                                                                                                                                                                                        Boolean bool10 = this.usesCustomVideoPlayback;
                                                                                                                                                                                        if (bool10 != null ? bool10.equals(zzbrVar.usesCustomVideoPlayback()) : zzbrVar.usesCustomVideoPlayback() == null) {
                                                                                                                                                                                            Float f4 = this.vastLoadTimeout;
                                                                                                                                                                                            if (f4 != null ? f4.equals(zzbrVar.vastLoadTimeout()) : zzbrVar.vastLoadTimeout() == null) {
                                                                                                                                                                                                String str21 = this.videoId;
                                                                                                                                                                                                if (str21 != null ? str21.equals(zzbrVar.videoId()) : zzbrVar.videoId() == null) {
                                                                                                                                                                                                    AdsRequestImpl.AutoPlayState autoPlayState = this.videoPlayActivation;
                                                                                                                                                                                                    if (autoPlayState != null ? autoPlayState.equals(zzbrVar.videoPlayActivation()) : zzbrVar.videoPlayActivation() == null) {
                                                                                                                                                                                                        AdsRequestImpl.ContinuousPlayState continuousPlayState = this.videoContinuousPlay;
                                                                                                                                                                                                        if (continuousPlayState != null ? continuousPlayState.equals(zzbrVar.videoContinuousPlay()) : zzbrVar.videoContinuousPlay() == null) {
                                                                                                                                                                                                            AdsRequestImpl.MutePlayState mutePlayState = this.videoPlayMuted;
                                                                                                                                                                                                            if (mutePlayState != null ? mutePlayState.equals(zzbrVar.videoPlayMuted()) : zzbrVar.videoPlayMuted() == null) {
                                                                                                                                                                                                                String str22 = this.vodConfigId;
                                                                                                                                                                                                                if (str22 != null ? str22.equals(zzbrVar.vodConfigId()) : zzbrVar.vodConfigId() == null) {
                                                                                                                                                                                                                    return true;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String format() {
        return this.format;
    }

    public int hashCode() {
        zzqi<String, String> zzqiVar = this.adTagParameters;
        int iHashCode = zzqiVar == null ? 0 : zzqiVar.hashCode();
        String str = this.adTagUrl;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        int i2 = iHashCode ^ 1000003;
        String str2 = this.adsResponse;
        int iHashCode3 = ((((i2 * 1000003) ^ iHashCode2) * 1000003) ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.apiKey;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.assetKey;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.authToken;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        zzqi<String, String> zzqiVar2 = this.companionSlots;
        int iHashCode7 = (iHashCode6 ^ (zzqiVar2 == null ? 0 : zzqiVar2.hashCode())) * 1000003;
        Float f2 = this.contentDuration;
        int iHashCode8 = (iHashCode7 ^ (f2 == null ? 0 : f2.hashCode())) * 1000003;
        zzqf<String> zzqfVar = this.contentKeywords;
        int iHashCode9 = (iHashCode8 ^ (zzqfVar == null ? 0 : zzqfVar.hashCode())) * 1000003;
        String str6 = this.contentSourceUrl;
        int iHashCode10 = (iHashCode9 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.contentTitle;
        int iHashCode11 = (iHashCode10 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.contentUrl;
        int iHashCode12 = (iHashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.contentSourceId;
        int iHashCode13 = (iHashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        zzqi<String, String> zzqiVar3 = this.consentSettings;
        int iHashCode14 = (iHashCode13 ^ (zzqiVar3 == null ? 0 : zzqiVar3.hashCode())) * 1000003;
        String str10 = this.customAssetKey;
        int iHashCode15 = (iHashCode14 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Boolean bool = this.enableNonce;
        int iHashCode16 = (iHashCode15 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str11 = this.env;
        int iHashCode17 = (iHashCode16 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        zzqf<zzcq> zzqfVar2 = this.secureSignals;
        int iHashCode18 = (iHashCode17 ^ (zzqfVar2 == null ? 0 : zzqfVar2.hashCode())) * 1000003;
        String str12 = this.format;
        int iHashCode19 = (iHashCode18 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        zzbv zzbvVar = this.identifierInfo;
        int iHashCode20 = (iHashCode19 ^ (zzbvVar == null ? 0 : zzbvVar.hashCode())) * 1000003;
        Boolean bool2 = this.isTv;
        int iHashCode21 = (iHashCode20 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.isAndroidTvAdsFramework;
        int iHashCode22 = (iHashCode21 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        Integer num = this.linearAdSlotWidth;
        int iHashCode23 = (iHashCode22 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.linearAdSlotHeight;
        int iHashCode24 = (iHashCode23 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str13 = this.liveStreamEventId;
        int iHashCode25 = (iHashCode24 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        Float f3 = this.liveStreamPrefetchSeconds;
        int iHashCode26 = (iHashCode25 ^ (f3 == null ? 0 : f3.hashCode())) * 1000003;
        com.google.ads.interactivemedia.v3.impl.zzs zzsVar = this.marketAppInfo;
        int iHashCode27 = (iHashCode26 ^ (zzsVar == null ? 0 : zzsVar.hashCode())) * 1000003;
        String str14 = this.msParameter;
        int iHashCode28 = (iHashCode27 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.network;
        int iHashCode29 = (iHashCode28 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        zzcy zzcyVar = this.videoEnvironment;
        int iHashCode30 = (iHashCode29 ^ (zzcyVar == null ? 0 : zzcyVar.hashCode())) * 1000003;
        String str16 = this.networkCode;
        int iHashCode31 = (iHashCode30 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.oAuthToken;
        int iHashCode32 = (iHashCode31 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        Boolean bool4 = this.omidAdSessionsOnStartedOnly;
        int iHashCode33 = (iHashCode32 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        zzqi<String, String> zzqiVar4 = this.platformSignals;
        int iHashCode34 = (iHashCode33 ^ (zzqiVar4 == null ? 0 : zzqiVar4.hashCode())) * 1000003;
        String str18 = this.projectNumber;
        int iHashCode35 = (iHashCode34 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.region;
        int iHashCode36 = (iHashCode35 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        ImaSdkSettings imaSdkSettings = this.settings;
        int iHashCode37 = (iHashCode36 ^ (imaSdkSettings == null ? 0 : imaSdkSettings.hashCode())) * 1000003;
        Boolean bool5 = this.supportsExternalNavigation;
        int iHashCode38 = (iHashCode37 ^ (bool5 == null ? 0 : bool5.hashCode())) * 1000003;
        Boolean bool6 = this.supportsIconClickFallback;
        int iHashCode39 = (iHashCode38 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
        Boolean bool7 = this.supportsNativeNetworking;
        int iHashCode40 = (iHashCode39 ^ (bool7 == null ? 0 : bool7.hashCode())) * 1000003;
        String str20 = this.streamActivityMonitorId;
        int iHashCode41 = (iHashCode40 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        Boolean bool8 = this.supportsResizing;
        int iHashCode42 = (iHashCode41 ^ (bool8 == null ? 0 : bool8.hashCode())) * 1000003;
        Boolean bool9 = this.useQAStreamBaseUrl;
        int iHashCode43 = (iHashCode42 ^ (bool9 == null ? 0 : bool9.hashCode())) * 1000003;
        Boolean bool10 = this.usesCustomVideoPlayback;
        int iHashCode44 = (iHashCode43 ^ (bool10 == null ? 0 : bool10.hashCode())) * 1000003;
        Float f4 = this.vastLoadTimeout;
        int iHashCode45 = (iHashCode44 ^ (f4 == null ? 0 : f4.hashCode())) * 1000003;
        String str21 = this.videoId;
        int iHashCode46 = (iHashCode45 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
        AdsRequestImpl.AutoPlayState autoPlayState = this.videoPlayActivation;
        int iHashCode47 = (iHashCode46 ^ (autoPlayState == null ? 0 : autoPlayState.hashCode())) * 1000003;
        AdsRequestImpl.ContinuousPlayState continuousPlayState = this.videoContinuousPlay;
        int iHashCode48 = (iHashCode47 ^ (continuousPlayState == null ? 0 : continuousPlayState.hashCode())) * 1000003;
        AdsRequestImpl.MutePlayState mutePlayState = this.videoPlayMuted;
        int iHashCode49 = (iHashCode48 ^ (mutePlayState == null ? 0 : mutePlayState.hashCode())) * 1000003;
        String str22 = this.vodConfigId;
        return iHashCode49 ^ (str22 != null ? str22.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzbv identifierInfo() {
        return this.identifierInfo;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean isAndroidTvAdsFramework() {
        return this.isAndroidTvAdsFramework;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean isTv() {
        return this.isTv;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Integer linearAdSlotHeight() {
        return this.linearAdSlotHeight;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Integer linearAdSlotWidth() {
        return this.linearAdSlotWidth;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String liveStreamEventId() {
        return this.liveStreamEventId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Float liveStreamPrefetchSeconds() {
        return this.liveStreamPrefetchSeconds;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public com.google.ads.interactivemedia.v3.impl.zzs marketAppInfo() {
        return this.marketAppInfo;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String msParameter() {
        return this.msParameter;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String network() {
        return this.network;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String networkCode() {
        return this.networkCode;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String oAuthToken() {
        return this.oAuthToken;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean omidAdSessionsOnStartedOnly() {
        return this.omidAdSessionsOnStartedOnly;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzqi<String, String> platformSignals() {
        return this.platformSignals;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String projectNumber() {
        return this.projectNumber;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String region() {
        return this.region;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzqf<zzcq> secureSignals() {
        return this.secureSignals;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public ImaSdkSettings settings() {
        return this.settings;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String streamActivityMonitorId() {
        return this.streamActivityMonitorId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean supportsExternalNavigation() {
        return this.supportsExternalNavigation;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean supportsIconClickFallback() {
        return this.supportsIconClickFallback;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean supportsNativeNetworking() {
        return this.supportsNativeNetworking;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean supportsResizing() {
        return this.supportsResizing;
    }

    public String toString() {
        AdsRequestImpl.MutePlayState mutePlayState = this.videoPlayMuted;
        AdsRequestImpl.ContinuousPlayState continuousPlayState = this.videoContinuousPlay;
        AdsRequestImpl.AutoPlayState autoPlayState = this.videoPlayActivation;
        ImaSdkSettings imaSdkSettings = this.settings;
        zzqi<String, String> zzqiVar = this.platformSignals;
        zzcy zzcyVar = this.videoEnvironment;
        com.google.ads.interactivemedia.v3.impl.zzs zzsVar = this.marketAppInfo;
        zzbv zzbvVar = this.identifierInfo;
        zzqf<zzcq> zzqfVar = this.secureSignals;
        zzqi<String, String> zzqiVar2 = this.consentSettings;
        zzqf<String> zzqfVar2 = this.contentKeywords;
        zzqi<String, String> zzqiVar3 = this.companionSlots;
        String strValueOf = String.valueOf(this.adTagParameters);
        String strValueOf2 = String.valueOf(zzqiVar3);
        String strValueOf3 = String.valueOf(zzqfVar2);
        String strValueOf4 = String.valueOf(zzqiVar2);
        String strValueOf5 = String.valueOf(zzqfVar);
        String strValueOf6 = String.valueOf(zzbvVar);
        String strValueOf7 = String.valueOf(zzsVar);
        String strValueOf8 = String.valueOf(zzcyVar);
        String strValueOf9 = String.valueOf(zzqiVar);
        String strValueOf10 = String.valueOf(imaSdkSettings);
        String strValueOf11 = String.valueOf(autoPlayState);
        String strValueOf12 = String.valueOf(continuousPlayState);
        String strValueOf13 = String.valueOf(mutePlayState);
        StringBuilder sbY = b.y("GsonAdsRequest{adTagParameters=", strValueOf, ", adTagUrl=");
        sbY.append(this.adTagUrl);
        sbY.append(", adsResponse=");
        sbY.append(this.adsResponse);
        sbY.append(", apiKey=");
        sbY.append(this.apiKey);
        sbY.append(", assetKey=");
        sbY.append(this.assetKey);
        sbY.append(", authToken=");
        b.B(sbY, this.authToken, ", companionSlots=", strValueOf2, ", contentDuration=");
        sbY.append(this.contentDuration);
        sbY.append(", contentKeywords=");
        sbY.append(strValueOf3);
        sbY.append(", contentSourceUrl=");
        sbY.append(this.contentSourceUrl);
        sbY.append(", contentTitle=");
        sbY.append(this.contentTitle);
        sbY.append(", contentUrl=");
        sbY.append(this.contentUrl);
        String str = this.videoId;
        Float f2 = this.vastLoadTimeout;
        Boolean bool = this.usesCustomVideoPlayback;
        Boolean bool2 = this.useQAStreamBaseUrl;
        Boolean bool3 = this.supportsResizing;
        String str2 = this.streamActivityMonitorId;
        Boolean bool4 = this.supportsNativeNetworking;
        Boolean bool5 = this.supportsIconClickFallback;
        Boolean bool6 = this.supportsExternalNavigation;
        String str3 = this.region;
        String str4 = this.projectNumber;
        Boolean bool7 = this.omidAdSessionsOnStartedOnly;
        String str5 = this.oAuthToken;
        String str6 = this.networkCode;
        String str7 = this.network;
        String str8 = this.msParameter;
        Float f3 = this.liveStreamPrefetchSeconds;
        String str9 = this.liveStreamEventId;
        Integer num = this.linearAdSlotHeight;
        Integer num2 = this.linearAdSlotWidth;
        Boolean bool8 = this.isAndroidTvAdsFramework;
        Boolean bool9 = this.isTv;
        String str10 = this.format;
        String str11 = this.env;
        Boolean bool10 = this.enableNonce;
        String str12 = this.customAssetKey;
        b.B(sbY, ", contentSourceId=", this.contentSourceId, ", consentSettings=", strValueOf4);
        sbY.append(", customAssetKey=");
        sbY.append(str12);
        sbY.append(", enableNonce=");
        sbY.append(bool10);
        b.B(sbY, ", env=", str11, ", secureSignals=", strValueOf5);
        b.B(sbY, ", format=", str10, ", identifierInfo=", strValueOf6);
        sbY.append(", isTv=");
        sbY.append(bool9);
        sbY.append(", isAndroidTvAdsFramework=");
        sbY.append(bool8);
        sbY.append(", linearAdSlotWidth=");
        sbY.append(num2);
        sbY.append(", linearAdSlotHeight=");
        sbY.append(num);
        sbY.append(", liveStreamEventId=");
        sbY.append(str9);
        sbY.append(", liveStreamPrefetchSeconds=");
        sbY.append(f3);
        b.B(sbY, ", marketAppInfo=", strValueOf7, ", msParameter=", str8);
        b.B(sbY, ", network=", str7, ", videoEnvironment=", strValueOf8);
        b.B(sbY, ", networkCode=", str6, ", oAuthToken=", str5);
        sbY.append(", omidAdSessionsOnStartedOnly=");
        sbY.append(bool7);
        sbY.append(", platformSignals=");
        sbY.append(strValueOf9);
        b.B(sbY, ", projectNumber=", str4, ", region=", str3);
        sbY.append(", settings=");
        sbY.append(strValueOf10);
        sbY.append(", supportsExternalNavigation=");
        sbY.append(bool6);
        sbY.append(", supportsIconClickFallback=");
        sbY.append(bool5);
        sbY.append(", supportsNativeNetworking=");
        sbY.append(bool4);
        sbY.append(", streamActivityMonitorId=");
        sbY.append(str2);
        sbY.append(", supportsResizing=");
        sbY.append(bool3);
        sbY.append(", useQAStreamBaseUrl=");
        sbY.append(bool2);
        sbY.append(", usesCustomVideoPlayback=");
        sbY.append(bool);
        sbY.append(", vastLoadTimeout=");
        sbY.append(f2);
        sbY.append(", videoId=");
        sbY.append(str);
        String str13 = this.vodConfigId;
        b.B(sbY, ", videoPlayActivation=", strValueOf11, ", videoContinuousPlay=", strValueOf12);
        b.B(sbY, ", videoPlayMuted=", strValueOf13, ", vodConfigId=", str13);
        sbY.append("}");
        return sbY.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean useQAStreamBaseUrl() {
        return this.useQAStreamBaseUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Boolean usesCustomVideoPlayback() {
        return this.usesCustomVideoPlayback;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public Float vastLoadTimeout() {
        return this.vastLoadTimeout;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public AdsRequestImpl.ContinuousPlayState videoContinuousPlay() {
        return this.videoContinuousPlay;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public zzcy videoEnvironment() {
        return this.videoEnvironment;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String videoId() {
        return this.videoId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public AdsRequestImpl.AutoPlayState videoPlayActivation() {
        return this.videoPlayActivation;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public AdsRequestImpl.MutePlayState videoPlayMuted() {
        return this.videoPlayMuted;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbr
    @Nullable
    public String vodConfigId() {
        return this.vodConfigId;
    }
}
