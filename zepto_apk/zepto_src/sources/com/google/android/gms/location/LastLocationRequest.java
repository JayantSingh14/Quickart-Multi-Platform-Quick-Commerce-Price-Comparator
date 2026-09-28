package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzdj;

@SafeParcelable.Class(creator = "LastLocationRequestCreator")
/* loaded from: classes4.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzv();

    /* renamed from: a, reason: collision with root package name */
    public final long f38301a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38302b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f38303c;

    /* renamed from: d, reason: collision with root package name */
    public final String f38304d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.internal.location.zzd f38305e;

    public static final class Builder {
    }

    public LastLocationRequest(long j2, int i2, boolean z, String str, com.google.android.gms.internal.location.zzd zzdVar) {
        this.f38301a = j2;
        this.f38302b = i2;
        this.f38303c = z;
        this.f38304d = str;
        this.f38305e = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        return this.f38301a == lastLocationRequest.f38301a && this.f38302b == lastLocationRequest.f38302b && this.f38303c == lastLocationRequest.f38303c && Objects.equal(this.f38304d, lastLocationRequest.f38304d) && Objects.equal(this.f38305e, lastLocationRequest.f38305e);
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f38301a), Integer.valueOf(this.f38302b), Boolean.valueOf(this.f38303c));
    }

    public final String toString() {
        StringBuilder sbW = b.w("LastLocationRequest[");
        long j2 = this.f38301a;
        if (j2 != Long.MAX_VALUE) {
            sbW.append("maxAge=");
            zzdj.a(j2, sbW);
        }
        int i2 = this.f38302b;
        if (i2 != 0) {
            sbW.append(", ");
            sbW.append(zzo.a(i2));
        }
        if (this.f38303c) {
            sbW.append(", bypass");
        }
        String str = this.f38304d;
        if (str != null) {
            sbW.append(", moduleId=");
            sbW.append(str);
        }
        com.google.android.gms.internal.location.zzd zzdVar = this.f38305e;
        if (zzdVar != null) {
            sbW.append(", impersonation=");
            sbW.append(zzdVar);
        }
        sbW.append(']');
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f38301a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38302b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f38303c);
        SafeParcelWriter.writeString(parcel, 4, this.f38304d, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f38305e, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
