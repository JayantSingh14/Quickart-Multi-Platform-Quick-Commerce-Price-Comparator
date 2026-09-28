package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
/* loaded from: classes.dex */
public final class zzpk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpk> CREATOR = new zzpl();

    /* renamed from: a, reason: collision with root package name */
    public final int f39626a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39627b;

    /* renamed from: c, reason: collision with root package name */
    public final long f39628c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f39629d;

    /* renamed from: e, reason: collision with root package name */
    public final String f39630e;

    /* renamed from: f, reason: collision with root package name */
    public final String f39631f;

    /* renamed from: g, reason: collision with root package name */
    public final Double f39632g;

    public zzpk(int i2, String str, long j2, Long l2, Float f2, String str2, String str3, Double d2) {
        this.f39626a = i2;
        this.f39627b = str;
        this.f39628c = j2;
        this.f39629d = l2;
        this.f39632g = i2 == 1 ? f2 != null ? Double.valueOf(f2.doubleValue()) : null : d2;
        this.f39630e = str2;
        this.f39631f = str3;
    }

    public final Object b() {
        Long l2 = this.f39629d;
        if (l2 != null) {
            return l2;
        }
        Double d2 = this.f39632g;
        if (d2 != null) {
            return d2;
        }
        String str = this.f39630e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        zzpl.a(this, parcel);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzpk(zzpm zzpmVar) {
        String str = zzpmVar.f39635c;
        this(zzpmVar.f39636d, zzpmVar.f39637e, str, zzpmVar.f39634b);
    }

    public zzpk(long j2, Object obj, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        this.f39626a = 2;
        this.f39627b = str;
        this.f39628c = j2;
        this.f39631f = str2;
        if (obj == null) {
            this.f39629d = null;
            this.f39632g = null;
            this.f39630e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f39629d = (Long) obj;
            this.f39632g = null;
            this.f39630e = null;
        } else if (obj instanceof String) {
            this.f39629d = null;
            this.f39632g = null;
            this.f39630e = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f39629d = null;
                this.f39632g = (Double) obj;
                this.f39630e = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
