package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "ActivityRecognitionRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public final long f38376a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f38377b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkSource f38378c;

    /* renamed from: d, reason: collision with root package name */
    public final String f38379d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f38380e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f38381f;

    /* renamed from: g, reason: collision with root package name */
    public final String f38382g;

    /* renamed from: h, reason: collision with root package name */
    public final long f38383h;

    /* renamed from: i, reason: collision with root package name */
    public final String f38384i;

    public zzb(long j2, boolean z, WorkSource workSource, String str, int[] iArr, boolean z2, String str2, long j3, String str3) {
        this.f38376a = j2;
        this.f38377b = z;
        this.f38378c = workSource;
        this.f38379d = str;
        this.f38380e = iArr;
        this.f38381f = z2;
        this.f38382g = str2;
        this.f38383h = j3;
        this.f38384i = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f38376a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f38377b);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f38378c, i2, false);
        SafeParcelWriter.writeString(parcel, 4, this.f38379d, false);
        SafeParcelWriter.writeIntArray(parcel, 5, this.f38380e, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f38381f);
        SafeParcelWriter.writeString(parcel, 7, this.f38382g, false);
        SafeParcelWriter.writeLong(parcel, 8, this.f38383h);
        SafeParcelWriter.writeString(parcel, 9, this.f38384i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
