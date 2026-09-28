package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

@SafeParcelable.Class(creator = "SignInResponseCreator")
/* loaded from: classes4.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();

    /* renamed from: a, reason: collision with root package name */
    public final int f39729a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectionResult f39730b;

    /* renamed from: c, reason: collision with root package name */
    public final zav f39731c;

    public zak(int i2, ConnectionResult connectionResult, zav zavVar) {
        this.f39729a = i2;
        this.f39730b = connectionResult;
        this.f39731c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f39729a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f39730b, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f39731c, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
