package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

@VisibleForTesting
@SafeParcelable.Class(creator = "ParcelableGeofenceCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzdh extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator<zzdh> CREATOR = new zzdi();

    /* renamed from: a, reason: collision with root package name */
    public final String f36684a;

    /* renamed from: b, reason: collision with root package name */
    public final long f36685b;

    /* renamed from: c, reason: collision with root package name */
    public final short f36686c;

    /* renamed from: d, reason: collision with root package name */
    public final double f36687d;

    /* renamed from: e, reason: collision with root package name */
    public final double f36688e;

    /* renamed from: f, reason: collision with root package name */
    public final float f36689f;

    /* renamed from: g, reason: collision with root package name */
    public final int f36690g;

    /* renamed from: h, reason: collision with root package name */
    public final int f36691h;

    /* renamed from: i, reason: collision with root package name */
    public final int f36692i;

    public zzdh(String str, int i2, short s, double d2, double d3, float f2, long j2, int i3, int i4) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: ".concat(String.valueOf(str)));
        }
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f2);
        }
        if (d2 > 90.0d || d2 < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d2);
        }
        if (d3 > 180.0d || d3 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d3);
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            throw new IllegalArgumentException(b.f(i2, "No supported transition specified: "));
        }
        this.f36686c = s;
        this.f36684a = str;
        this.f36687d = d2;
        this.f36688e = d3;
        this.f36689f = f2;
        this.f36685b = j2;
        this.f36690g = i5;
        this.f36691h = i3;
        this.f36692i = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdh) {
            zzdh zzdhVar = (zzdh) obj;
            if (this.f36689f == zzdhVar.f36689f && this.f36687d == zzdhVar.f36687d && this.f36688e == zzdhVar.f36688e && this.f36686c == zzdhVar.f36686c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f36687d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f36688e);
        return ((((Float.floatToIntBits(this.f36689f) + ((((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31)) * 31) + this.f36686c) * 31) + this.f36690g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        short s = this.f36686c;
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", s != -1 ? s != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID", this.f36684a.replaceAll("\\p{C}", "?"), Integer.valueOf(this.f36690g), Double.valueOf(this.f36687d), Double.valueOf(this.f36688e), Float.valueOf(this.f36689f), Integer.valueOf(this.f36691h / 1000), Integer.valueOf(this.f36692i), Long.valueOf(this.f36685b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f36684a, false);
        SafeParcelWriter.writeLong(parcel, 2, this.f36685b);
        SafeParcelWriter.writeShort(parcel, 3, this.f36686c);
        SafeParcelWriter.writeDouble(parcel, 4, this.f36687d);
        SafeParcelWriter.writeDouble(parcel, 5, this.f36688e);
        SafeParcelWriter.writeFloat(parcel, 6, this.f36689f);
        SafeParcelWriter.writeInt(parcel, 7, this.f36690g);
        SafeParcelWriter.writeInt(parcel, 8, this.f36691h);
        SafeParcelWriter.writeInt(parcel, 9, this.f36692i);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
