package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "MediationConfigurationParcelCreator")
/* loaded from: classes4.dex */
public final class zzbpw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbpw> CREATOR = new zzbpx();

    /* renamed from: a, reason: collision with root package name */
    public final String f25418a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f25419b;

    public zzbpw(String str, Bundle bundle) {
        this.f25418a = str;
        this.f25419b = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f25418a, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.f25419b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
