package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "ServerSideVerificationOptionsParcelCreator")
/* loaded from: classes4.dex */
public final class zzcat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcat> CREATOR = new zzcau();

    /* renamed from: a, reason: collision with root package name */
    public final String f25795a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25796b;

    public zzcat(String str, String str2) {
        this.f25795a = str;
        this.f25796b = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f25795a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f25796b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
