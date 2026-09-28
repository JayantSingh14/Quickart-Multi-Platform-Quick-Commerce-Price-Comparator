package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbh();

    /* renamed from: a, reason: collision with root package name */
    public final String f38769a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbe f38770b;

    /* renamed from: c, reason: collision with root package name */
    public final String f38771c;

    /* renamed from: d, reason: collision with root package name */
    public final long f38772d;

    public zzbg(zzbg zzbgVar, long j2) {
        Preconditions.checkNotNull(zzbgVar);
        this.f38769a = zzbgVar.f38769a;
        this.f38770b = zzbgVar.f38770b;
        this.f38771c = zzbgVar.f38771c;
        this.f38772d = j2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f38770b);
        String str = this.f38771c;
        int length = String.valueOf(str).length();
        String str2 = this.f38769a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        b.B(sb, "origin=", str, ",name=", str2);
        return b.r(sb, ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        zzbh.a(this, parcel, i2);
    }

    public zzbg(String str, zzbe zzbeVar, String str2, long j2) {
        this.f38769a = str;
        this.f38770b = zzbeVar;
        this.f38771c = str2;
        this.f38772d = j2;
    }
}
