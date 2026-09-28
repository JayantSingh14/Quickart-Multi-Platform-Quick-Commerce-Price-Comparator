package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzdj;

@SafeParcelable.Class(creator = "CurrentLocationRequestCreator")
/* loaded from: classes4.dex */
public final class CurrentLocationRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    public final long f38286a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38287b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38288c;

    /* renamed from: d, reason: collision with root package name */
    public final long f38289d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f38290e;

    /* renamed from: f, reason: collision with root package name */
    public final int f38291f;

    /* renamed from: g, reason: collision with root package name */
    public final String f38292g;

    /* renamed from: h, reason: collision with root package name */
    public final WorkSource f38293h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.gms.internal.location.zzd f38294i;

    public static final class Builder {
    }

    public CurrentLocationRequest(long j2, int i2, int i3, long j3, boolean z, int i4, String str, WorkSource workSource, com.google.android.gms.internal.location.zzd zzdVar) {
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f38286a = j2;
        this.f38287b = i2;
        this.f38288c = i3;
        this.f38289d = j3;
        this.f38290e = z;
        this.f38291f = i4;
        this.f38292g = str;
        this.f38293h = workSource;
        this.f38294i = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        return this.f38286a == currentLocationRequest.f38286a && this.f38287b == currentLocationRequest.f38287b && this.f38288c == currentLocationRequest.f38288c && this.f38289d == currentLocationRequest.f38289d && this.f38290e == currentLocationRequest.f38290e && this.f38291f == currentLocationRequest.f38291f && Objects.equal(this.f38292g, currentLocationRequest.f38292g) && Objects.equal(this.f38293h, currentLocationRequest.f38293h) && Objects.equal(this.f38294i, currentLocationRequest.f38294i);
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f38286a), Integer.valueOf(this.f38287b), Integer.valueOf(this.f38288c), Long.valueOf(this.f38289d));
    }

    public final String toString() {
        String str;
        StringBuilder sbW = b.w("CurrentLocationRequest[");
        sbW.append(zzae.b(this.f38288c));
        long j2 = this.f38286a;
        if (j2 != Long.MAX_VALUE) {
            sbW.append(", maxAge=");
            zzdj.a(j2, sbW);
        }
        long j3 = this.f38289d;
        if (j3 != Long.MAX_VALUE) {
            e.A(sbW, ", duration=", j3, "ms");
        }
        int i2 = this.f38287b;
        if (i2 != 0) {
            sbW.append(", ");
            sbW.append(zzo.a(i2));
        }
        if (this.f38290e) {
            sbW.append(", bypass");
        }
        int i3 = this.f38291f;
        if (i3 != 0) {
            sbW.append(", ");
            if (i3 == 0) {
                str = "THROTTLE_BACKGROUND";
            } else if (i3 == 1) {
                str = "THROTTLE_ALWAYS";
            } else {
                if (i3 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "THROTTLE_NEVER";
            }
            sbW.append(str);
        }
        String str2 = this.f38292g;
        if (str2 != null) {
            sbW.append(", moduleId=");
            sbW.append(str2);
        }
        WorkSource workSource = this.f38293h;
        if (!WorkSourceUtil.isEmpty(workSource)) {
            sbW.append(", workSource=");
            sbW.append(workSource);
        }
        com.google.android.gms.internal.location.zzd zzdVar = this.f38294i;
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
        SafeParcelWriter.writeLong(parcel, 1, this.f38286a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38287b);
        SafeParcelWriter.writeInt(parcel, 3, this.f38288c);
        SafeParcelWriter.writeLong(parcel, 4, this.f38289d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f38290e);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f38293h, i2, false);
        SafeParcelWriter.writeInt(parcel, 7, this.f38291f);
        SafeParcelWriter.writeString(parcel, 8, this.f38292g, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f38294i, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
