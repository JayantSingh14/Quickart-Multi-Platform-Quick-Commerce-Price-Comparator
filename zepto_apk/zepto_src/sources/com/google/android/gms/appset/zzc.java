package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AppSetInfoParcelCreator")
/* loaded from: classes4.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public final String f21998a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21999b;

    public zzc(String str, int i2) {
        this.f21998a = str;
        this.f21999b = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21998a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f21999b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
