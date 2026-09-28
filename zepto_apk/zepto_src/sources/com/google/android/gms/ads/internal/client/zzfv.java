package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
/* loaded from: classes4.dex */
public final class zzfv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfw();

    /* renamed from: a, reason: collision with root package name */
    public final int f21243a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21244b;

    public zzfv(int i2, int i3) {
        this.f21243a = i2;
        this.f21244b = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21243a);
        SafeParcelWriter.writeInt(parcel, 2, this.f21244b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
