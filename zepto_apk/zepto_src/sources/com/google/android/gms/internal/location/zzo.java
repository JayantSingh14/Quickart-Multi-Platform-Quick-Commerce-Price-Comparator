package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;

/* loaded from: classes4.dex */
public interface zzo extends IInterface {
    void A7(IStatusCallback iStatusCallback);

    void H6(IStatusCallback iStatusCallback);

    void H8(zzdb zzdbVar, IStatusCallback iStatusCallback);

    void I7(LastLocationRequest lastLocationRequest, zzq zzqVar);

    void I8(StatusCallback statusCallback);

    void Ma(StatusCallback statusCallback);

    void P5(zzm zzmVar, String str);

    void Q7(zzdf zzdfVar);

    void a6(LocationSettingsRequest locationSettingsRequest, zzr zzrVar);

    void c();

    LocationAvailability c0(String str);

    ICancelToken c5(zzq zzqVar);

    void j();

    void p2(StatusCallback statusCallback);

    void rb(StatusCallback statusCallback);

    void s6(zzdb zzdbVar, LocationRequest locationRequest, IStatusCallback iStatusCallback);

    void w5(IStatusCallback iStatusCallback);

    void w6(zzk zzkVar);

    void x6(zzm zzmVar);

    Location zzd();

    void zzm();

    void zzr();
}
