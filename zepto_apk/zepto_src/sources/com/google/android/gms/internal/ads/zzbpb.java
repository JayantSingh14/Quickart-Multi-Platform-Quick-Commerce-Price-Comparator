package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
/* loaded from: classes4.dex */
public final class zzbpb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbpb> CREATOR = new zzbpc();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f25395a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25396b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25397c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f25398d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f25399e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f25400f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f25401g;

    /* renamed from: h, reason: collision with root package name */
    public final long f25402h;

    public zzbpb(boolean z, String str, int i2, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j2) {
        this.f25395a = z;
        this.f25396b = str;
        this.f25397c = i2;
        this.f25398d = bArr;
        this.f25399e = strArr;
        this.f25400f = strArr2;
        this.f25401g = z2;
        this.f25402h = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f25395a);
        SafeParcelWriter.writeString(parcel, 2, this.f25396b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f25397c);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f25398d, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.f25399e, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.f25400f, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f25401g);
        SafeParcelWriter.writeLong(parcel, 8, this.f25402h);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
