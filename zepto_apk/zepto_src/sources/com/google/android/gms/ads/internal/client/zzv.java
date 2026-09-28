package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterResponseInfoParcelCreator")
/* loaded from: classes4.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();

    /* renamed from: a, reason: collision with root package name */
    public final String f21298a;

    /* renamed from: b, reason: collision with root package name */
    public long f21299b;

    /* renamed from: c, reason: collision with root package name */
    public zze f21300c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f21301d;

    /* renamed from: e, reason: collision with root package name */
    public final String f21302e;

    /* renamed from: f, reason: collision with root package name */
    public final String f21303f;

    /* renamed from: g, reason: collision with root package name */
    public final String f21304g;

    /* renamed from: h, reason: collision with root package name */
    public final String f21305h;

    public zzv(String str, long j2, zze zzeVar, Bundle bundle, String str2, String str3, String str4, String str5) {
        this.f21298a = str;
        this.f21299b = j2;
        this.f21300c = zzeVar;
        this.f21301d = bundle;
        this.f21302e = str2;
        this.f21303f = str3;
        this.f21304g = str4;
        this.f21305h = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21298a, false);
        SafeParcelWriter.writeLong(parcel, 2, this.f21299b);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f21300c, i2, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.f21301d, false);
        SafeParcelWriter.writeString(parcel, 5, this.f21302e, false);
        SafeParcelWriter.writeString(parcel, 6, this.f21303f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f21304g, false);
        SafeParcelWriter.writeString(parcel, 8, this.f21305h, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
