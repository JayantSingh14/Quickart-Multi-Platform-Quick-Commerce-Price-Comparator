package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PlusSessionCreator")
/* loaded from: classes4.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    public final int f39700a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39701b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f39702c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f39703d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f39704e;

    /* renamed from: f, reason: collision with root package name */
    public final String f39705f;

    /* renamed from: g, reason: collision with root package name */
    public final String f39706g;

    /* renamed from: h, reason: collision with root package name */
    public final String f39707h;

    /* renamed from: i, reason: collision with root package name */
    public final String f39708i;

    /* renamed from: j, reason: collision with root package name */
    public final PlusCommonExtras f39709j;

    public zzn(int i2, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.f39700a = i2;
        this.f39701b = str;
        this.f39702c = strArr;
        this.f39703d = strArr2;
        this.f39704e = strArr3;
        this.f39705f = str2;
        this.f39706g = str3;
        this.f39707h = str4;
        this.f39708i = str5;
        this.f39709j = plusCommonExtras;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        return this.f39700a == zznVar.f39700a && Objects.equal(this.f39701b, zznVar.f39701b) && Arrays.equals(this.f39702c, zznVar.f39702c) && Arrays.equals(this.f39703d, zznVar.f39703d) && Arrays.equals(this.f39704e, zznVar.f39704e) && Objects.equal(this.f39705f, zznVar.f39705f) && Objects.equal(this.f39706g, zznVar.f39706g) && Objects.equal(this.f39707h, zznVar.f39707h) && Objects.equal(this.f39708i, zznVar.f39708i) && Objects.equal(this.f39709j, zznVar.f39709j);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f39700a), this.f39701b, this.f39702c, this.f39703d, this.f39704e, this.f39705f, this.f39706g, this.f39707h, this.f39708i, this.f39709j);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.f39700a)).add("accountName", this.f39701b).add("requestedScopes", this.f39702c).add("visibleActivities", this.f39703d).add("requiredFeatures", this.f39704e).add("packageNameForAuth", this.f39705f).add("callingPackageName", this.f39706g).add("applicationName", this.f39707h).add("extra", this.f39709j.toString()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f39701b, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.f39702c, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.f39703d, false);
        SafeParcelWriter.writeStringArray(parcel, 4, this.f39704e, false);
        SafeParcelWriter.writeString(parcel, 5, this.f39705f, false);
        SafeParcelWriter.writeString(parcel, 6, this.f39706g, false);
        SafeParcelWriter.writeString(parcel, 7, this.f39707h, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f39700a);
        SafeParcelWriter.writeString(parcel, 8, this.f39708i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f39709j, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzn(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, PlusCommonExtras plusCommonExtras) {
        this.f39700a = 1;
        this.f39701b = str;
        this.f39702c = strArr;
        this.f39703d = strArr2;
        this.f39704e = strArr3;
        this.f39705f = str2;
        this.f39706g = str3;
        this.f39707h = null;
        this.f39708i = null;
        this.f39709j = plusCommonExtras;
    }
}
