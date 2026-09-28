package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BatchUploadStatusParcelCreator")
/* loaded from: classes4.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();

    /* renamed from: a, reason: collision with root package name */
    public final long f38673a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38674b;

    /* renamed from: c, reason: collision with root package name */
    public final long f38675c;

    public zzaf(long j2, long j3, int i2) {
        this.f38673a = j2;
        this.f38674b = i2;
        this.f38675c = j3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f38673a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38674b);
        SafeParcelWriter.writeLong(parcel, 3, this.f38675c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
