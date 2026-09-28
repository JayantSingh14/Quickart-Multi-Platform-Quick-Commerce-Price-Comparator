package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
/* loaded from: classes4.dex */
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();

    /* renamed from: a, reason: collision with root package name */
    public final String f21515a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21516b;

    public zzba(String str, int i2) {
        this.f21515a = str == null ? "" : str;
        this.f21516b = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21515a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f21516b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
