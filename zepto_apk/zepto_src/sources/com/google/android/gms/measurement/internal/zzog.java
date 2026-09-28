package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "TriggerUriParcelCreator")
/* loaded from: classes4.dex */
public final class zzog extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzog> CREATOR = new zzoh();

    /* renamed from: a, reason: collision with root package name */
    public final String f39544a;

    /* renamed from: b, reason: collision with root package name */
    public final long f39545b;

    /* renamed from: c, reason: collision with root package name */
    public final int f39546c;

    public zzog(int i2, long j2, String str) {
        this.f39544a = str;
        this.f39545b = j2;
        this.f39546c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f39544a, false);
        SafeParcelWriter.writeLong(parcel, 2, this.f39545b);
        SafeParcelWriter.writeInt(parcel, 3, this.f39546c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
