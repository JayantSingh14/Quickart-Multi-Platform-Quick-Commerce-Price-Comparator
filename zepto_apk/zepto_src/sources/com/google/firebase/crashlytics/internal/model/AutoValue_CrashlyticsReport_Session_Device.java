package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {

    /* renamed from: a, reason: collision with root package name */
    public final int f44193a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44194b;

    /* renamed from: c, reason: collision with root package name */
    public final int f44195c;

    /* renamed from: d, reason: collision with root package name */
    public final long f44196d;

    /* renamed from: e, reason: collision with root package name */
    public final long f44197e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f44198f;

    /* renamed from: g, reason: collision with root package name */
    public final int f44199g;

    /* renamed from: h, reason: collision with root package name */
    public final String f44200h;

    /* renamed from: i, reason: collision with root package name */
    public final String f44201i;

    public static final class Builder extends CrashlyticsReport.Session.Device.Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f44202a;

        /* renamed from: b, reason: collision with root package name */
        public String f44203b;

        /* renamed from: c, reason: collision with root package name */
        public int f44204c;

        /* renamed from: d, reason: collision with root package name */
        public long f44205d;

        /* renamed from: e, reason: collision with root package name */
        public long f44206e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f44207f;

        /* renamed from: g, reason: collision with root package name */
        public int f44208g;

        /* renamed from: h, reason: collision with root package name */
        public String f44209h;

        /* renamed from: i, reason: collision with root package name */
        public String f44210i;

        /* renamed from: j, reason: collision with root package name */
        public byte f44211j;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device a() {
            String str;
            String str2;
            String str3;
            if (this.f44211j == 63 && (str = this.f44203b) != null && (str2 = this.f44209h) != null && (str3 = this.f44210i) != null) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.f44202a, str, this.f44204c, this.f44205d, this.f44206e, this.f44207f, this.f44208g, str2, str3);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f44211j & 1) == 0) {
                sb.append(" arch");
            }
            if (this.f44203b == null) {
                sb.append(" model");
            }
            if ((this.f44211j & 2) == 0) {
                sb.append(" cores");
            }
            if ((this.f44211j & 4) == 0) {
                sb.append(" ram");
            }
            if ((this.f44211j & 8) == 0) {
                sb.append(" diskSpace");
            }
            if ((this.f44211j & 16) == 0) {
                sb.append(" simulator");
            }
            if ((this.f44211j & 32) == 0) {
                sb.append(" state");
            }
            if (this.f44209h == null) {
                sb.append(" manufacturer");
            }
            if (this.f44210i == null) {
                sb.append(" modelClass");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder b(int i2) {
            this.f44202a = i2;
            this.f44211j = (byte) (this.f44211j | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder c(int i2) {
            this.f44204c = i2;
            this.f44211j = (byte) (this.f44211j | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder d(long j2) {
            this.f44206e = j2;
            this.f44211j = (byte) (this.f44211j | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f44209h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f44203b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f44210i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder h(long j2) {
            this.f44205d = j2;
            this.f44211j = (byte) (this.f44211j | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder i(boolean z) {
            this.f44207f = z;
            this.f44211j = (byte) (this.f44211j | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public final CrashlyticsReport.Session.Device.Builder j(int i2) {
            this.f44208g = i2;
            this.f44211j = (byte) (this.f44211j | 32);
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Device(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
        this.f44193a = i2;
        this.f44194b = str;
        this.f44195c = i3;
        this.f44196d = j2;
        this.f44197e = j3;
        this.f44198f = z;
        this.f44199g = i4;
        this.f44200h = str2;
        this.f44201i = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final int b() {
        return this.f44193a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final int c() {
        return this.f44195c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final long d() {
        return this.f44197e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final String e() {
        return this.f44200h;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        return this.f44193a == device.b() && this.f44194b.equals(device.f()) && this.f44195c == device.c() && this.f44196d == device.h() && this.f44197e == device.d() && this.f44198f == device.j() && this.f44199g == device.i() && this.f44200h.equals(device.e()) && this.f44201i.equals(device.g());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final String f() {
        return this.f44194b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final String g() {
        return this.f44201i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final long h() {
        return this.f44196d;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f44193a ^ 1000003) * 1000003) ^ this.f44194b.hashCode()) * 1000003) ^ this.f44195c) * 1000003;
        long j2 = this.f44196d;
        int i2 = (iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f44197e;
        return ((((((((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f44198f ? 1231 : 1237)) * 1000003) ^ this.f44199g) * 1000003) ^ this.f44200h.hashCode()) * 1000003) ^ this.f44201i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final int i() {
        return this.f44199g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final boolean j() {
        return this.f44198f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{arch=");
        sb.append(this.f44193a);
        sb.append(", model=");
        sb.append(this.f44194b);
        sb.append(", cores=");
        sb.append(this.f44195c);
        sb.append(", ram=");
        sb.append(this.f44196d);
        sb.append(", diskSpace=");
        sb.append(this.f44197e);
        sb.append(", simulator=");
        sb.append(this.f44198f);
        sb.append(", state=");
        sb.append(this.f44199g);
        sb.append(", manufacturer=");
        sb.append(this.f44200h);
        sb.append(", modelClass=");
        return b.r(sb, this.f44201i, "}");
    }
}
