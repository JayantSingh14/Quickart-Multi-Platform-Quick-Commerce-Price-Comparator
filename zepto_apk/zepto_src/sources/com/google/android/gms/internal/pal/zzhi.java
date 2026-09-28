package com.google.android.gms.internal.pal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
/* loaded from: classes4.dex */
public final class zzhi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhi> CREATOR = new zzhj();

    /* renamed from: a, reason: collision with root package name */
    public final int f37793a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37794b;

    /* renamed from: c, reason: collision with root package name */
    public final String f37795c;

    public zzhi(int i2, String str, String str2) {
        this.f37793a = i2;
        this.f37794b = str;
        this.f37795c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f37793a);
        SafeParcelWriter.writeString(parcel, 2, this.f37794b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f37795c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
