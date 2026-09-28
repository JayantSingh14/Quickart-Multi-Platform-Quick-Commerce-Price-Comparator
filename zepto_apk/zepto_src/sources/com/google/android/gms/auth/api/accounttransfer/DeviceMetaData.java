package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceMetaDataCreator")
/* loaded from: classes4.dex */
public class DeviceMetaData extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzy();

    /* renamed from: a, reason: collision with root package name */
    public final int f22026a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f22027b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22028c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22029d;

    public DeviceMetaData(int i2, boolean z, long j2, boolean z2) {
        this.f22026a = i2;
        this.f22027b = z;
        this.f22028c = j2;
        this.f22029d = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22026a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f22027b);
        SafeParcelWriter.writeLong(parcel, 3, this.f22028c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22029d);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
