package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {

    /* renamed from: a, reason: collision with root package name */
    public final long f44212a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44213b;

    /* renamed from: c, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Application f44214c;

    /* renamed from: d, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Device f44215d;

    /* renamed from: e, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Log f44216e;

    /* renamed from: f, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.RolloutsState f44217f;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f44218a;

        /* renamed from: b, reason: collision with root package name */
        public String f44219b;

        /* renamed from: c, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Application f44220c;

        /* renamed from: d, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Device f44221d;

        /* renamed from: e, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Log f44222e;

        /* renamed from: f, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.RolloutsState f44223f;

        /* renamed from: g, reason: collision with root package name */
        public byte f44224g;

        public Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public final CrashlyticsReport.Session.Event a() {
            String str;
            CrashlyticsReport.Session.Event.Application application;
            CrashlyticsReport.Session.Event.Device device;
            if (this.f44224g == 1 && (str = this.f44219b) != null && (application = this.f44220c) != null && (device = this.f44221d) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.f44218a, str, application, device, this.f44222e, this.f44223f);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.f44224g) == 0) {
                sb.append(" timestamp");
            }
            if (this.f44219b == null) {
                sb.append(" type");
            }
            if (this.f44220c == null) {
                sb.append(" app");
            }
            if (this.f44221d == null) {
                sb.append(" device");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public final CrashlyticsReport.Session.Event.Builder b(CrashlyticsReport.Session.Event.Application application) {
            if (application == null) {
                throw new NullPointerException("Null app");
            }
            this.f44220c = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public final CrashlyticsReport.Session.Event.Builder c(CrashlyticsReport.Session.Event.Device device) {
            if (device == null) {
                throw new NullPointerException("Null device");
            }
            this.f44221d = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public final CrashlyticsReport.Session.Event.Builder d(CrashlyticsReport.Session.Event.Log log) {
            this.f44222e = log;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public final CrashlyticsReport.Session.Event.Builder e(CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
            this.f44223f = rolloutsState;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public final CrashlyticsReport.Session.Event.Builder f(long j2) {
            this.f44218a = j2;
            this.f44224g = (byte) (this.f44224g | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public final CrashlyticsReport.Session.Event.Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f44219b = str;
            return this;
        }

        public Builder(CrashlyticsReport.Session.Event event) {
            AutoValue_CrashlyticsReport_Session_Event autoValue_CrashlyticsReport_Session_Event = (AutoValue_CrashlyticsReport_Session_Event) event;
            this.f44218a = autoValue_CrashlyticsReport_Session_Event.f44212a;
            this.f44219b = autoValue_CrashlyticsReport_Session_Event.f44213b;
            this.f44220c = autoValue_CrashlyticsReport_Session_Event.f44214c;
            this.f44221d = autoValue_CrashlyticsReport_Session_Event.f44215d;
            this.f44222e = autoValue_CrashlyticsReport_Session_Event.f44216e;
            this.f44223f = autoValue_CrashlyticsReport_Session_Event.f44217f;
            this.f44224g = (byte) 1;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event(long j2, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, CrashlyticsReport.Session.Event.Log log, CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
        this.f44212a = j2;
        this.f44213b = str;
        this.f44214c = application;
        this.f44215d = device;
        this.f44216e = log;
        this.f44217f = rolloutsState;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.Application b() {
        return this.f44214c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.Device c() {
        return this.f44215d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.Log d() {
        return this.f44216e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.RolloutsState e() {
        return this.f44217f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.f44212a != event.f() || !this.f44213b.equals(event.g()) || !this.f44214c.equals(event.b()) || !this.f44215d.equals(event.c())) {
            return false;
        }
        CrashlyticsReport.Session.Event.Log log = this.f44216e;
        if (log == null) {
            if (event.d() != null) {
                return false;
            }
        } else if (!log.equals(event.d())) {
            return false;
        }
        CrashlyticsReport.Session.Event.RolloutsState rolloutsState = this.f44217f;
        return rolloutsState == null ? event.e() == null : rolloutsState.equals(event.e());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final long f() {
        return this.f44212a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final String g() {
        return this.f44213b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.Builder h() {
        return new Builder(this);
    }

    public final int hashCode() {
        long j2 = this.f44212a;
        int iHashCode = (((((((((int) ((j2 >>> 32) ^ j2)) ^ 1000003) * 1000003) ^ this.f44213b.hashCode()) * 1000003) ^ this.f44214c.hashCode()) * 1000003) ^ this.f44215d.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.f44216e;
        int iHashCode2 = (iHashCode ^ (log == null ? 0 : log.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.RolloutsState rolloutsState = this.f44217f;
        return iHashCode2 ^ (rolloutsState != null ? rolloutsState.hashCode() : 0);
    }

    public final String toString() {
        return "Event{timestamp=" + this.f44212a + ", type=" + this.f44213b + ", app=" + this.f44214c + ", device=" + this.f44215d + ", log=" + this.f44216e + ", rollouts=" + this.f44217f + "}";
    }
}
