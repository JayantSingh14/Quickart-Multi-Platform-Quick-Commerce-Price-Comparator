package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {

    /* renamed from: a, reason: collision with root package name */
    public final Double f44304a;

    /* renamed from: b, reason: collision with root package name */
    public final int f44305b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f44306c;

    /* renamed from: d, reason: collision with root package name */
    public final int f44307d;

    /* renamed from: e, reason: collision with root package name */
    public final long f44308e;

    /* renamed from: f, reason: collision with root package name */
    public final long f44309f;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Double f44310a;

        /* renamed from: b, reason: collision with root package name */
        public int f44311b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f44312c;

        /* renamed from: d, reason: collision with root package name */
        public int f44313d;

        /* renamed from: e, reason: collision with root package name */
        public long f44314e;

        /* renamed from: f, reason: collision with root package name */
        public long f44315f;

        /* renamed from: g, reason: collision with root package name */
        public byte f44316g;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public final CrashlyticsReport.Session.Event.Device a() {
            if (this.f44316g == 31) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.f44310a, this.f44311b, this.f44312c, this.f44313d, this.f44314e, this.f44315f);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f44316g & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.f44316g & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.f44316g & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.f44316g & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.f44316g & 16) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public final CrashlyticsReport.Session.Event.Device.Builder b(Double d2) {
            this.f44310a = d2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public final CrashlyticsReport.Session.Event.Device.Builder c(int i2) {
            this.f44311b = i2;
            this.f44316g = (byte) (this.f44316g | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public final CrashlyticsReport.Session.Event.Device.Builder d(long j2) {
            this.f44315f = j2;
            this.f44316g = (byte) (this.f44316g | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public final CrashlyticsReport.Session.Event.Device.Builder e(int i2) {
            this.f44313d = i2;
            this.f44316g = (byte) (this.f44316g | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public final CrashlyticsReport.Session.Event.Device.Builder f(boolean z) {
            this.f44312c = z;
            this.f44316g = (byte) (this.f44316g | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public final CrashlyticsReport.Session.Event.Device.Builder g(long j2) {
            this.f44314e = j2;
            this.f44316g = (byte) (this.f44316g | 8);
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Device(Double d2, int i2, boolean z, int i3, long j2, long j3) {
        this.f44304a = d2;
        this.f44305b = i2;
        this.f44306c = z;
        this.f44307d = i3;
        this.f44308e = j2;
        this.f44309f = j3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final Double b() {
        return this.f44304a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final int c() {
        return this.f44305b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final long d() {
        return this.f44309f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final int e() {
        return this.f44307d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d2 = this.f44304a;
        if (d2 == null) {
            if (device.b() != null) {
                return false;
            }
        } else if (!d2.equals(device.b())) {
            return false;
        }
        return this.f44305b == device.c() && this.f44306c == device.g() && this.f44307d == device.e() && this.f44308e == device.f() && this.f44309f == device.d();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final long f() {
        return this.f44308e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final boolean g() {
        return this.f44306c;
    }

    public final int hashCode() {
        Double d2 = this.f44304a;
        int iHashCode = ((((((((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003) ^ this.f44305b) * 1000003) ^ (this.f44306c ? 1231 : 1237)) * 1000003) ^ this.f44307d) * 1000003;
        long j2 = this.f44308e;
        long j3 = this.f44309f;
        return ((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{batteryLevel=");
        sb.append(this.f44304a);
        sb.append(", batteryVelocity=");
        sb.append(this.f44305b);
        sb.append(", proximityOn=");
        sb.append(this.f44306c);
        sb.append(", orientation=");
        sb.append(this.f44307d);
        sb.append(", ramUsed=");
        sb.append(this.f44308e);
        sb.append(", diskUsed=");
        return b.p(sb, this.f44309f, "}");
    }
}
