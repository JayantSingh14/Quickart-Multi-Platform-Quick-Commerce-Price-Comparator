package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
/* loaded from: classes4.dex */
public final class zzboz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzboz> CREATOR = new zzbpa();

    /* renamed from: a, reason: collision with root package name */
    public final String f25392a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f25393b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f25394c;

    public zzboz(String str, String[] strArr, String[] strArr2) {
        this.f25392a = str;
        this.f25393b = strArr;
        this.f25394c = strArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f25392a, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.f25393b, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.f25394c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
