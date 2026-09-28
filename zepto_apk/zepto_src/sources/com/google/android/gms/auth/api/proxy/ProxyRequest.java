package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyRequestCreator")
/* loaded from: classes4.dex */
public class ProxyRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    public final String f22139a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22140b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22141c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f22142d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22143e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f22144f;

    @ShowFirstParty
    @KeepForSdkWithMembers
    public static class Builder {
    }

    public ProxyRequest(int i2, String str, int i3, long j2, byte[] bArr, Bundle bundle) {
        this.f22143e = i2;
        this.f22139a = str;
        this.f22140b = i3;
        this.f22141c = j2;
        this.f22142d = bArr;
        this.f22144f = bundle;
    }

    public final String toString() {
        return "ProxyRequest[ url: " + this.f22139a + ", method: " + this.f22140b + " ]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22139a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f22140b);
        SafeParcelWriter.writeLong(parcel, 3, this.f22141c);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22142d, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.f22144f, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f22143e);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
