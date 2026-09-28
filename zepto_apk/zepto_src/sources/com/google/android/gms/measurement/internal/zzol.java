package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UploadBatchParcelCreator")
/* loaded from: classes4.dex */
public final class zzol extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzol> CREATOR = new zzom();

    /* renamed from: a, reason: collision with root package name */
    public final long f39552a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f39553b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39554c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f39555d;

    /* renamed from: e, reason: collision with root package name */
    public final int f39556e;

    /* renamed from: f, reason: collision with root package name */
    public final long f39557f;

    /* renamed from: g, reason: collision with root package name */
    public String f39558g;

    public zzol(long j2, byte[] bArr, String str, Bundle bundle, int i2, long j3, String str2) {
        this.f39552a = j2;
        this.f39553b = bArr;
        this.f39554c = str;
        this.f39555d = bundle;
        this.f39556e = i2;
        this.f39557f = j3;
        this.f39558g = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f39552a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f39553b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f39554c, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.f39555d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f39556e);
        SafeParcelWriter.writeLong(parcel, 6, this.f39557f);
        SafeParcelWriter.writeString(parcel, 7, this.f39558g, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
