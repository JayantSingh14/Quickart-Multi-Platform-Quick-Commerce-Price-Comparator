package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdValueParcelCreator")
/* loaded from: classes4.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    /* renamed from: a, reason: collision with root package name */
    public final int f21294a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21295b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21296c;

    /* renamed from: d, reason: collision with root package name */
    public final long f21297d;

    public zzt(long j2, String str, int i2, int i3) {
        this.f21294a = i2;
        this.f21295b = i3;
        this.f21296c = str;
        this.f21297d = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21294a);
        SafeParcelWriter.writeInt(parcel, 2, this.f21295b);
        SafeParcelWriter.writeString(parcel, 3, this.f21296c, false);
        SafeParcelWriter.writeLong(parcel, 4, this.f21297d);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
