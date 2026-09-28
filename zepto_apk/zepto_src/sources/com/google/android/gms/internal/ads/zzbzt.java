package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzbzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbzt> CREATOR = new zzbzu();

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzm f25779a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25780b;

    public zzbzt(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) {
        this.f25779a = zzmVar;
        this.f25780b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f25779a, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.f25780b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
