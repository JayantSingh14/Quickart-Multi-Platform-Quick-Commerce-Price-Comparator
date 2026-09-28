package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzt extends com.google.android.gms.internal.location.zzb implements zzu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38392a = 0;

    public zzt() {
        super("com.google.android.gms.location.ILocationListener");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            zze();
            return true;
        }
        Location location = (Location) com.google.android.gms.internal.location.zzc.a(parcel, Location.CREATOR);
        com.google.android.gms.internal.location.zzc.b(parcel);
        h0(location);
        return true;
    }
}
