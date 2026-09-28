package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
/* loaded from: classes4.dex */
public final class zzbpy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbpy> CREATOR = new zzbpz();

    /* renamed from: a, reason: collision with root package name */
    public final int f25420a;

    /* renamed from: b, reason: collision with root package name */
    public final int f25421b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25422c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25423d;

    public zzbpy(int i2, int i3, int i4, String str) {
        this.f25420a = i2;
        this.f25421b = i3;
        this.f25422c = str;
        this.f25423d = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f25421b);
        SafeParcelWriter.writeString(parcel, 2, this.f25422c, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f25423d);
        SafeParcelWriter.writeInt(parcel, 1000, this.f25420a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
