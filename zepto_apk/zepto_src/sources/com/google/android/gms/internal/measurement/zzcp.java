package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzcp extends zzbl implements zzcr {
    public zzcp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void beginAdUnitExposure(String str, long j2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeLong(j2);
        j1(23, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        zzbn.c(parcelZ0, bundle);
        j1(9, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void endAdUnitExposure(String str, long j2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeLong(j2);
        j1(24, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void generateEventId(zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcuVar);
        j1(22, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getAppInstanceId(zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcuVar);
        j1(20, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getCachedAppInstanceId(zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcuVar);
        j1(19, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getConditionalUserProperties(String str, String str2, zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        zzbn.d(parcelZ0, zzcuVar);
        j1(10, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getCurrentScreenClass(zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcuVar);
        j1(17, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getCurrentScreenName(zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcuVar);
        j1(16, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getGmpAppId(zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcuVar);
        j1(21, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getMaxUserProperties(String str, zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        zzbn.d(parcelZ0, zzcuVar);
        j1(6, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getSessionId(zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcuVar);
        j1(46, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getTestFlag(zzcu zzcuVar, int i2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getUserProperties(String str, String str2, boolean z, zzcu zzcuVar) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        ClassLoader classLoader = zzbn.f36803a;
        parcelZ0.writeInt(z ? 1 : 0);
        zzbn.d(parcelZ0, zzcuVar);
        j1(5, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void initialize(IObjectWrapper iObjectWrapper, zzdd zzddVar, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, iObjectWrapper);
        zzbn.c(parcelZ0, zzddVar);
        parcelZ0.writeLong(j2);
        j1(1, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        zzbn.c(parcelZ0, bundle);
        parcelZ0.writeInt(z ? 1 : 0);
        parcelZ0.writeInt(1);
        parcelZ0.writeLong(j2);
        j1(2, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logHealthData(int i2, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(5);
        parcelZ0.writeString(str);
        zzbn.d(parcelZ0, iObjectWrapper);
        zzbn.d(parcelZ0, iObjectWrapper2);
        zzbn.d(parcelZ0, iObjectWrapper3);
        j1(33, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        zzbn.c(parcelZ0, bundle);
        parcelZ0.writeLong(j2);
        j1(53, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        parcelZ0.writeLong(j2);
        j1(54, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        parcelZ0.writeLong(j2);
        j1(55, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        parcelZ0.writeLong(j2);
        j1(56, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        zzbn.d(parcelZ0, zzcuVar);
        parcelZ0.writeLong(j2);
        j1(57, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        parcelZ0.writeLong(j2);
        j1(51, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        parcelZ0.writeLong(j2);
        j1(52, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void performAction(Bundle bundle, zzcu zzcuVar, long j2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void registerOnMeasurementEventListener(zzda zzdaVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzdaVar);
        j1(35, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void resetAnalyticsData(long j2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeLong(j2);
        j1(12, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void retrieveAndUploadBatches(zzcx zzcxVar) {
        Parcel parcelZ0 = z0();
        zzbn.d(parcelZ0, zzcxVar);
        j1(58, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConditionalUserProperty(Bundle bundle, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, bundle);
        parcelZ0.writeLong(j2);
        j1(8, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConsentThirdParty(Bundle bundle, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, bundle);
        parcelZ0.writeLong(j2);
        j1(45, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j2) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, zzdfVar);
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        parcelZ0.writeLong(j2);
        j1(50, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setDataCollectionEnabled(boolean z) {
        Parcel parcelZ0 = z0();
        ClassLoader classLoader = zzbn.f36803a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(39, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setDefaultEventParameters(Bundle bundle) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, bundle);
        j1(42, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setEventInterceptor(zzda zzdaVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setMeasurementEnabled(boolean z, long j2) {
        Parcel parcelZ0 = z0();
        ClassLoader classLoader = zzbn.f36803a;
        parcelZ0.writeInt(z ? 1 : 0);
        parcelZ0.writeLong(j2);
        j1(11, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setSessionTimeoutDuration(long j2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeLong(j2);
        j1(14, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setSgtmDebugInfo(Intent intent) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, intent);
        j1(48, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setUserId(String str, long j2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeLong(j2);
        j1(7, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        zzbn.d(parcelZ0, iObjectWrapper);
        parcelZ0.writeInt(z ? 1 : 0);
        parcelZ0.writeLong(j2);
        j1(4, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void unregisterOnMeasurementEventListener(zzda zzdaVar) {
        throw null;
    }
}
