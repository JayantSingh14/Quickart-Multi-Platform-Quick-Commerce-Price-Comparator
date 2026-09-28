package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "NetworkRequestOptionsCreator")
/* loaded from: classes3.dex */
public final class zzlw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlw> CREATOR = new zzlx();

    @SafeParcelable.Field(getter = "getUrl", id = 1)
    private final String zza;

    @SafeParcelable.Field(defaultValue = "0", getter = "getMethod", id = 2)
    private final int zzb;

    @SafeParcelable.Field(defaultValue = "", getter = "getBody", id = 3)
    private final String zzc;

    @SafeParcelable.Constructor
    public zzlw(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str2) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
