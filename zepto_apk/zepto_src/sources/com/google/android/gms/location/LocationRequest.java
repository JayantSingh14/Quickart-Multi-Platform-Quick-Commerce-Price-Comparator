package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzdj;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
/* loaded from: classes4.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzx();

    /* renamed from: a, reason: collision with root package name */
    public int f38311a;

    /* renamed from: b, reason: collision with root package name */
    public long f38312b;

    /* renamed from: c, reason: collision with root package name */
    public long f38313c;

    /* renamed from: d, reason: collision with root package name */
    public final long f38314d;

    /* renamed from: e, reason: collision with root package name */
    public final long f38315e;

    /* renamed from: f, reason: collision with root package name */
    public final int f38316f;

    /* renamed from: g, reason: collision with root package name */
    public float f38317g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f38318h;

    /* renamed from: i, reason: collision with root package name */
    public long f38319i;

    /* renamed from: j, reason: collision with root package name */
    public final int f38320j;

    /* renamed from: k, reason: collision with root package name */
    public final int f38321k;

    /* renamed from: l, reason: collision with root package name */
    public final String f38322l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f38323m;
    public final WorkSource n;
    public final com.google.android.gms.internal.location.zzd o;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final int f38324a;

        /* renamed from: b, reason: collision with root package name */
        public final long f38325b;

        /* renamed from: c, reason: collision with root package name */
        public final long f38326c;

        /* renamed from: d, reason: collision with root package name */
        public final long f38327d;

        /* renamed from: e, reason: collision with root package name */
        public final long f38328e;

        /* renamed from: f, reason: collision with root package name */
        public final int f38329f;

        /* renamed from: g, reason: collision with root package name */
        public final float f38330g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f38331h;

        /* renamed from: i, reason: collision with root package name */
        public long f38332i;

        /* renamed from: j, reason: collision with root package name */
        public int f38333j;

        /* renamed from: k, reason: collision with root package name */
        public int f38334k;

        /* renamed from: l, reason: collision with root package name */
        public String f38335l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f38336m;
        public WorkSource n;
        public final com.google.android.gms.internal.location.zzd o;

        public Builder(LocationRequest locationRequest) {
            this.f38324a = locationRequest.f38311a;
            this.f38325b = locationRequest.f38312b;
            this.f38326c = locationRequest.f38313c;
            this.f38327d = locationRequest.f38314d;
            this.f38328e = locationRequest.f38315e;
            this.f38329f = locationRequest.f38316f;
            this.f38330g = locationRequest.f38317g;
            this.f38331h = locationRequest.f38318h;
            this.f38332i = locationRequest.f38319i;
            this.f38333j = locationRequest.f38320j;
            this.f38334k = locationRequest.f38321k;
            this.f38335l = locationRequest.f38322l;
            this.f38336m = locationRequest.f38323m;
            this.n = locationRequest.n;
            this.o = locationRequest.o;
        }

        public final LocationRequest a() {
            long jMin = this.f38326c;
            int i2 = this.f38324a;
            long j2 = this.f38325b;
            if (jMin == -1) {
                jMin = j2;
            } else if (i2 != 105) {
                jMin = Math.min(jMin, j2);
            }
            long j3 = this.f38327d;
            long j4 = this.f38325b;
            long jMax = Math.max(j3, j4);
            long j5 = jMin;
            long j6 = this.f38328e;
            boolean z = this.f38331h;
            long j7 = this.f38332i;
            return new LocationRequest(i2, j2, j5, jMax, Long.MAX_VALUE, j6, this.f38329f, this.f38330g, z, j7 == -1 ? j4 : j7, this.f38333j, this.f38334k, this.f38335l, this.f38336m, new WorkSource(this.n), this.o);
        }
    }

    @Deprecated
    public LocationRequest() {
        this(102, DateUtils.MILLIS_PER_HOUR, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0.0f, true, DateUtils.MILLIS_PER_HOUR, 0, 0, null, false, new WorkSource(), null);
    }

    public static String A(long j2) {
        String string;
        if (j2 == Long.MAX_VALUE) {
            return "∞";
        }
        StringBuilder sb = zzdj.f36693a;
        synchronized (sb) {
            sb.setLength(0);
            zzdj.a(j2, sb);
            string = sb.toString();
        }
        return string;
    }

    public final boolean b() {
        long j2 = this.f38314d;
        return j2 > 0 && (j2 >> 1) >= this.f38312b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        int i2 = this.f38311a;
        if (i2 != locationRequest.f38311a) {
            return false;
        }
        if ((i2 == 105 || this.f38312b == locationRequest.f38312b) && this.f38313c == locationRequest.f38313c && b() == locationRequest.b()) {
            return (!b() || this.f38314d == locationRequest.f38314d) && this.f38315e == locationRequest.f38315e && this.f38316f == locationRequest.f38316f && this.f38317g == locationRequest.f38317g && this.f38318h == locationRequest.f38318h && this.f38320j == locationRequest.f38320j && this.f38321k == locationRequest.f38321k && this.f38323m == locationRequest.f38323m && this.n.equals(locationRequest.n) && Objects.equal(this.f38322l, locationRequest.f38322l) && Objects.equal(this.o, locationRequest.o);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38311a), Long.valueOf(this.f38312b), Long.valueOf(this.f38313c), this.n);
    }

    public final void r(long j2) {
        Preconditions.checkArgument(j2 >= 0, "illegal fastest interval: %d", Long.valueOf(j2));
        this.f38313c = j2;
    }

    public final void s(long j2) {
        Preconditions.checkArgument(j2 >= 0, "intervalMillis must be greater than or equal to 0");
        long j3 = this.f38313c;
        long j4 = this.f38312b;
        if (j3 == j4 / 6) {
            this.f38313c = j2 / 6;
        }
        if (this.f38319i == j4) {
            this.f38319i = j2;
        }
        this.f38312b = j2;
    }

    public final String toString() {
        String str;
        StringBuilder sbW = b.w("Request[");
        int i2 = this.f38311a;
        if (i2 == 105) {
            sbW.append(zzae.b(i2));
        } else {
            sbW.append("@");
            if (b()) {
                zzdj.a(this.f38312b, sbW);
                sbW.append("/");
                zzdj.a(this.f38314d, sbW);
            } else {
                zzdj.a(this.f38312b, sbW);
            }
            sbW.append(StringUtils.SPACE);
            sbW.append(zzae.b(this.f38311a));
        }
        if (this.f38311a == 105 || this.f38313c != this.f38312b) {
            sbW.append(", minUpdateInterval=");
            sbW.append(A(this.f38313c));
        }
        if (this.f38317g > 0.0d) {
            sbW.append(", minUpdateDistance=");
            sbW.append(this.f38317g);
        }
        if (!(this.f38311a == 105) ? this.f38319i != this.f38312b : this.f38319i != Long.MAX_VALUE) {
            sbW.append(", maxUpdateAge=");
            sbW.append(A(this.f38319i));
        }
        long j2 = this.f38315e;
        if (j2 != Long.MAX_VALUE) {
            sbW.append(", duration=");
            zzdj.a(j2, sbW);
        }
        int i3 = this.f38316f;
        if (i3 != Integer.MAX_VALUE) {
            sbW.append(", maxUpdates=");
            sbW.append(i3);
        }
        int i4 = this.f38321k;
        if (i4 != 0) {
            sbW.append(", ");
            if (i4 == 0) {
                str = "THROTTLE_BACKGROUND";
            } else if (i4 == 1) {
                str = "THROTTLE_ALWAYS";
            } else {
                if (i4 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "THROTTLE_NEVER";
            }
            sbW.append(str);
        }
        int i5 = this.f38320j;
        if (i5 != 0) {
            sbW.append(", ");
            sbW.append(zzo.a(i5));
        }
        if (this.f38318h) {
            sbW.append(", waitForAccurateLocation");
        }
        if (this.f38323m) {
            sbW.append(", bypass");
        }
        String str2 = this.f38322l;
        if (str2 != null) {
            sbW.append(", moduleId=");
            sbW.append(str2);
        }
        WorkSource workSource = this.n;
        if (!WorkSourceUtil.isEmpty(workSource)) {
            sbW.append(", ");
            sbW.append(workSource);
        }
        com.google.android.gms.internal.location.zzd zzdVar = this.o;
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
        SafeParcelWriter.writeInt(parcel, 1, this.f38311a);
        SafeParcelWriter.writeLong(parcel, 2, this.f38312b);
        SafeParcelWriter.writeLong(parcel, 3, this.f38313c);
        SafeParcelWriter.writeInt(parcel, 6, this.f38316f);
        SafeParcelWriter.writeFloat(parcel, 7, this.f38317g);
        SafeParcelWriter.writeLong(parcel, 8, this.f38314d);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f38318h);
        SafeParcelWriter.writeLong(parcel, 10, this.f38315e);
        SafeParcelWriter.writeLong(parcel, 11, this.f38319i);
        SafeParcelWriter.writeInt(parcel, 12, this.f38320j);
        SafeParcelWriter.writeInt(parcel, 13, this.f38321k);
        SafeParcelWriter.writeString(parcel, 14, this.f38322l, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.f38323m);
        SafeParcelWriter.writeParcelable(parcel, 16, this.n, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.o, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public LocationRequest(int i2, long j2, long j3, long j4, long j5, long j6, int i3, float f2, boolean z, long j7, int i4, int i5, String str, boolean z2, WorkSource workSource, com.google.android.gms.internal.location.zzd zzdVar) {
        this.f38311a = i2;
        this.f38312b = j2;
        this.f38313c = j3;
        this.f38314d = j4;
        this.f38315e = j5 == Long.MAX_VALUE ? j6 : Math.min(Math.max(1L, j5 - SystemClock.elapsedRealtime()), j6);
        this.f38316f = i3;
        this.f38317g = f2;
        this.f38318h = z;
        this.f38319i = j7 != -1 ? j7 : j2;
        this.f38320j = i4;
        this.f38321k = i5;
        this.f38322l = str;
        this.f38323m = z2;
        this.n = workSource;
        this.o = zzdVar;
    }
}
