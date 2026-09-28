package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProgramRequestCreator")
/* loaded from: classes4.dex */
public final class zzfvr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfvr> CREATOR = new zzfvs();

    /* renamed from: a, reason: collision with root package name */
    public final int f31941a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31942b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31943c;

    /* renamed from: d, reason: collision with root package name */
    public final String f31944d;

    /* renamed from: e, reason: collision with root package name */
    public final int f31945e;

    public zzfvr(int i2, int i3, int i4, String str, String str2) {
        this.f31941a = i2;
        this.f31942b = i3;
        this.f31943c = str;
        this.f31944d = str2;
        this.f31945e = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f31941a);
        SafeParcelWriter.writeInt(parcel, 2, this.f31942b);
        SafeParcelWriter.writeString(parcel, 3, this.f31943c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f31944d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f31945e);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
