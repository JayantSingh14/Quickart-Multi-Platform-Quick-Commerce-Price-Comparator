package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.AdsRequestImpl;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface zzbq {
    zzbq adTagParameters(Map<String, String> map);

    zzbq adTagUrl(String str);

    zzbq adsResponse(String str);

    zzbq apiKey(String str);

    zzbq assetKey(String str);

    zzbq authToken(String str);

    zzbr build();

    zzbq companionSlots(Map<String, String> map);

    zzbq consentSettings(Map<String, String> map);

    zzbq contentDuration(Float f2);

    zzbq contentKeywords(List<String> list);

    zzbq contentSourceId(String str);

    zzbq contentSourceUrl(String str);

    zzbq contentTitle(String str);

    zzbq contentUrl(String str);

    zzbq customAssetKey(String str);

    zzbq enableNonce(Boolean bool);

    zzbq env(String str);

    zzbq format(String str);

    zzbq identifierInfo(zzbv zzbvVar);

    zzbq isAndroidTvAdsFramework(Boolean bool);

    zzbq isTv(Boolean bool);

    zzbq linearAdSlotHeight(Integer num);

    zzbq linearAdSlotWidth(Integer num);

    zzbq liveStreamEventId(String str);

    zzbq liveStreamPrefetchSeconds(Float f2);

    zzbq marketAppInfo(com.google.ads.interactivemedia.v3.impl.zzs zzsVar);

    zzbq msParameter(String str);

    zzbq network(String str);

    zzbq networkCode(String str);

    zzbq oAuthToken(String str);

    zzbq omidAdSessionsOnStartedOnly(Boolean bool);

    zzbq platformSignals(@Nullable Map<String, String> map);

    zzbq projectNumber(String str);

    zzbq region(String str);

    zzbq secureSignals(List<zzcq> list);

    zzbq settings(ImaSdkSettings imaSdkSettings);

    zzbq streamActivityMonitorId(String str);

    zzbq supportsExternalNavigation(Boolean bool);

    zzbq supportsIconClickFallback(Boolean bool);

    zzbq supportsNativeNetworking(Boolean bool);

    zzbq supportsResizing(Boolean bool);

    zzbq useQAStreamBaseUrl(Boolean bool);

    zzbq usesCustomVideoPlayback(Boolean bool);

    zzbq vastLoadTimeout(Float f2);

    zzbq videoContinuousPlay(AdsRequestImpl.ContinuousPlayState continuousPlayState);

    zzbq videoEnvironment(zzcy zzcyVar);

    zzbq videoId(String str);

    zzbq videoPlayActivation(AdsRequestImpl.AutoPlayState autoPlayState);

    zzbq videoPlayMuted(AdsRequestImpl.MutePlayState mutePlayState);

    zzbq vodConfigId(String str);
}
