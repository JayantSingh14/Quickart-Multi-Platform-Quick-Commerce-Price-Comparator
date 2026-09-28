package com.google.android.gms.ads.internal.offline.buffering;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OfflineNotificationParcelCreator")
/* loaded from: classes4.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final String f21311a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21312b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21313c;

    public zza(String str, String str2, String str3) {
        this.f21311a = str;
        this.f21312b = str2;
        this.f21313c = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21311a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f21312b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f21313c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
