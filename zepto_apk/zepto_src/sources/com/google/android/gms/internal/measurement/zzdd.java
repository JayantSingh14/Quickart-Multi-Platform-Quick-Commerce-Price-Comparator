package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InitializationParamsCreator")
@SafeParcelable.Reserved({4, 5, 6})
/* loaded from: classes.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();

    /* renamed from: a, reason: collision with root package name */
    public final long f36831a;

    /* renamed from: b, reason: collision with root package name */
    public final long f36832b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f36833c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f36834d;

    /* renamed from: e, reason: collision with root package name */
    public final String f36835e;

    public zzdd(long j2, long j3, boolean z, Bundle bundle, String str) {
        this.f36831a = j2;
        this.f36832b = j3;
        this.f36833c = z;
        this.f36834d = bundle;
        this.f36835e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f36831a);
        SafeParcelWriter.writeLong(parcel, 2, this.f36832b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f36833c);
        SafeParcelWriter.writeBundle(parcel, 7, this.f36834d, false);
        SafeParcelWriter.writeString(parcel, 8, this.f36835e, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
