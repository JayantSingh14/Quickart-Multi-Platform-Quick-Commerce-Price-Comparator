package com.google.android.gms.location;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzq extends com.google.android.gms.internal.location.zzb implements zzr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38391a = 0;

    public zzq() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 == 1) {
            LocationResult locationResult = (LocationResult) com.google.android.gms.internal.location.zzc.a(parcel, LocationResult.CREATOR);
            com.google.android.gms.internal.location.zzc.b(parcel);
            v9(locationResult);
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return false;
            }
            zzf();
            return true;
        }
        LocationAvailability locationAvailability = (LocationAvailability) com.google.android.gms.internal.location.zzc.a(parcel, LocationAvailability.CREATOR);
        com.google.android.gms.internal.location.zzc.b(parcel);
        Z4(locationAvailability);
        return true;
    }
}
