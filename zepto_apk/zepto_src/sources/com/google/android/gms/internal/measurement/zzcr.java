package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public interface zzcr extends IInterface {
    void beginAdUnitExposure(String str, long j2);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j2);

    void endAdUnitExposure(String str, long j2);

    void generateEventId(zzcu zzcuVar);

    void getAppInstanceId(zzcu zzcuVar);

    void getCachedAppInstanceId(zzcu zzcuVar);

    void getConditionalUserProperties(String str, String str2, zzcu zzcuVar);

    void getCurrentScreenClass(zzcu zzcuVar);

    void getCurrentScreenName(zzcu zzcuVar);

    void getGmpAppId(zzcu zzcuVar);

    void getMaxUserProperties(String str, zzcu zzcuVar);

    void getSessionId(zzcu zzcuVar);

    void getTestFlag(zzcu zzcuVar, int i2);

    void getUserProperties(String str, String str2, boolean z, zzcu zzcuVar);

    void initForTests(Map map);

    void initialize(IObjectWrapper iObjectWrapper, zzdd zzddVar, long j2);

    void isDataCollectionEnabled(zzcu zzcuVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcuVar, long j2);

    void logHealthData(int i2, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j2);

    void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j2);

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j2);

    void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j2);

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j2);

    void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j2);

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j2);

    void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j2);

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcu zzcuVar, long j2);

    void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j2);

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j2);

    void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j2);

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j2);

    void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j2);

    void performAction(Bundle bundle, zzcu zzcuVar, long j2);

    void registerOnMeasurementEventListener(zzda zzdaVar);

    void resetAnalyticsData(long j2);

    void retrieveAndUploadBatches(zzcx zzcxVar);

    void setConditionalUserProperty(Bundle bundle, long j2);

    void setConsent(Bundle bundle, long j2);

    void setConsentThirdParty(Bundle bundle, long j2);

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j2);

    void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j2);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzda zzdaVar);

    void setInstanceIdProvider(zzdc zzdcVar);

    void setMeasurementEnabled(boolean z, long j2);

    void setMinimumSessionDuration(long j2);

    void setSessionTimeoutDuration(long j2);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j2);

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j2);

    void unregisterOnMeasurementEventListener(zzda zzdaVar);
}
