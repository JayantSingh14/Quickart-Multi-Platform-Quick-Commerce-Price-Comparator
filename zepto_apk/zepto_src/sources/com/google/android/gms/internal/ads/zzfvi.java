package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
/* loaded from: classes4.dex */
public final class zzfvi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfvi> CREATOR = new zzfvj();

    /* renamed from: a, reason: collision with root package name */
    public final int f31921a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31922b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31923c;

    public zzfvi(int i2, String str, String str2) {
        this.f31921a = i2;
        this.f31922b = str;
        this.f31923c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f31921a);
        SafeParcelWriter.writeString(parcel, 2, this.f31922b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f31923c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
