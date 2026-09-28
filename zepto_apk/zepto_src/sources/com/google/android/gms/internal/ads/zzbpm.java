package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterStatusParcelCreator")
/* loaded from: classes4.dex */
public final class zzbpm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbpm> CREATOR = new zzbpn();

    /* renamed from: a, reason: collision with root package name */
    public final String f25411a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f25412b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25413c;

    /* renamed from: d, reason: collision with root package name */
    public final String f25414d;

    public zzbpm(String str, int i2, String str2, boolean z) {
        this.f25411a = str;
        this.f25412b = z;
        this.f25413c = i2;
        this.f25414d = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f25411a, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f25412b);
        SafeParcelWriter.writeInt(parcel, 3, this.f25413c);
        SafeParcelWriter.writeString(parcel, 4, this.f25414d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
