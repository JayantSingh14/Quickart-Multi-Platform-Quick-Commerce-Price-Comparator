package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {

    /* renamed from: a, reason: collision with root package name */
    public final String f44156a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44157b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44158c;

    /* renamed from: d, reason: collision with root package name */
    public final long f44159d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f44160e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f44161f;

    /* renamed from: g, reason: collision with root package name */
    public final CrashlyticsReport.Session.Application f44162g;

    /* renamed from: h, reason: collision with root package name */
    public final CrashlyticsReport.Session.User f44163h;

    /* renamed from: i, reason: collision with root package name */
    public final CrashlyticsReport.Session.OperatingSystem f44164i;

    /* renamed from: j, reason: collision with root package name */
    public final CrashlyticsReport.Session.Device f44165j;

    /* renamed from: k, reason: collision with root package name */
    public final List f44166k;

    /* renamed from: l, reason: collision with root package name */
    public final int f44167l;

    public static final class Builder extends CrashlyticsReport.Session.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44168a;

        /* renamed from: b, reason: collision with root package name */
        public String f44169b;

        /* renamed from: c, reason: collision with root package name */
        public String f44170c;

        /* renamed from: d, reason: collision with root package name */
        public long f44171d;

        /* renamed from: e, reason: collision with root package name */
        public Long f44172e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f44173f;

        /* renamed from: g, reason: collision with root package name */
        public CrashlyticsReport.Session.Application f44174g;

        /* renamed from: h, reason: collision with root package name */
        public CrashlyticsReport.Session.User f44175h;

        /* renamed from: i, reason: collision with root package name */
        public CrashlyticsReport.Session.OperatingSystem f44176i;

        /* renamed from: j, reason: collision with root package name */
        public CrashlyticsReport.Session.Device f44177j;

        /* renamed from: k, reason: collision with root package name */
        public List f44178k;

        /* renamed from: l, reason: collision with root package name */
        public int f44179l;

        /* renamed from: m, reason: collision with root package name */
        public byte f44180m;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session a() {
            String str;
            String str2;
            CrashlyticsReport.Session.Application application;
            if (this.f44180m == 7 && (str = this.f44168a) != null && (str2 = this.f44169b) != null && (application = this.f44174g) != null) {
                return new AutoValue_CrashlyticsReport_Session(str, str2, this.f44170c, this.f44171d, this.f44172e, this.f44173f, application, this.f44175h, this.f44176i, this.f44177j, this.f44178k, this.f44179l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44168a == null) {
                sb.append(" generator");
            }
            if (this.f44169b == null) {
                sb.append(" identifier");
            }
            if ((this.f44180m & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.f44180m & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.f44174g == null) {
                sb.append(" app");
            }
            if ((this.f44180m & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder b(CrashlyticsReport.Session.Application application) {
            if (application == null) {
                throw new NullPointerException("Null app");
            }
            this.f44174g = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder c(String str) {
            this.f44170c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder d(boolean z) {
            this.f44173f = z;
            this.f44180m = (byte) (this.f44180m | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder e(CrashlyticsReport.Session.Device device) {
            this.f44177j = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder f(Long l2) {
            this.f44172e = l2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder g(List list) {
            this.f44178k = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f44168a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder i(int i2) {
            this.f44179l = i2;
            this.f44180m = (byte) (this.f44180m | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f44169b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder k(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f44176i = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder l(long j2) {
            this.f44171d = j2;
            this.f44180m = (byte) (this.f44180m | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public final CrashlyticsReport.Session.Builder m(CrashlyticsReport.Session.User user) {
            this.f44175h = user;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session(String str, String str2, String str3, long j2, Long l2, boolean z, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device, List list, int i2) {
        this.f44156a = str;
        this.f44157b = str2;
        this.f44158c = str3;
        this.f44159d = j2;
        this.f44160e = l2;
        this.f44161f = z;
        this.f44162g = application;
        this.f44163h = user;
        this.f44164i = operatingSystem;
        this.f44165j = device;
        this.f44166k = list;
        this.f44167l = i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.Application b() {
        return this.f44162g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final String c() {
        return this.f44158c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.Device d() {
        return this.f44165j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final Long e() {
        return this.f44160e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (!this.f44156a.equals(session.g()) || !this.f44157b.equals(session.i())) {
            return false;
        }
        String str = this.f44158c;
        if (str == null) {
            if (session.c() != null) {
                return false;
            }
        } else if (!str.equals(session.c())) {
            return false;
        }
        if (this.f44159d != session.k()) {
            return false;
        }
        Long l2 = this.f44160e;
        if (l2 == null) {
            if (session.e() != null) {
                return false;
            }
        } else if (!l2.equals(session.e())) {
            return false;
        }
        if (this.f44161f != session.m() || !this.f44162g.equals(session.b())) {
            return false;
        }
        CrashlyticsReport.Session.User user = this.f44163h;
        if (user == null) {
            if (session.l() != null) {
                return false;
            }
        } else if (!user.equals(session.l())) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f44164i;
        if (operatingSystem == null) {
            if (session.j() != null) {
                return false;
            }
        } else if (!operatingSystem.equals(session.j())) {
            return false;
        }
        CrashlyticsReport.Session.Device device = this.f44165j;
        if (device == null) {
            if (session.d() != null) {
                return false;
            }
        } else if (!device.equals(session.d())) {
            return false;
        }
        List list = this.f44166k;
        if (list == null) {
            if (session.f() != null) {
                return false;
            }
        } else if (!list.equals(session.f())) {
            return false;
        }
        return this.f44167l == session.h();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final List f() {
        return this.f44166k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final String g() {
        return this.f44156a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final int h() {
        return this.f44167l;
    }

    public final int hashCode() {
        int iHashCode = (((this.f44156a.hashCode() ^ 1000003) * 1000003) ^ this.f44157b.hashCode()) * 1000003;
        String str = this.f44158c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j2 = this.f44159d;
        int i2 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        Long l2 = this.f44160e;
        int iHashCode3 = (((((i2 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ (this.f44161f ? 1231 : 1237)) * 1000003) ^ this.f44162g.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.f44163h;
        int iHashCode4 = (iHashCode3 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f44164i;
        int iHashCode5 = (iHashCode4 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device = this.f44165j;
        int iHashCode6 = (iHashCode5 ^ (device == null ? 0 : device.hashCode())) * 1000003;
        List list = this.f44166k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f44167l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final String i() {
        return this.f44157b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.OperatingSystem j() {
        return this.f44164i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final long k() {
        return this.f44159d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.User l() {
        return this.f44163h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final boolean m() {
        return this.f44161f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.Builder n() {
        Builder builder = new Builder();
        builder.f44168a = g();
        builder.f44169b = i();
        builder.f44170c = c();
        builder.f44171d = k();
        builder.f44172e = e();
        builder.f44173f = m();
        builder.f44174g = b();
        builder.f44175h = l();
        builder.f44176i = j();
        builder.f44177j = d();
        builder.f44178k = f();
        builder.f44179l = h();
        builder.f44180m = (byte) 7;
        return builder;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Session{generator=");
        sb.append(this.f44156a);
        sb.append(", identifier=");
        sb.append(this.f44157b);
        sb.append(", appQualitySessionId=");
        sb.append(this.f44158c);
        sb.append(", startedAt=");
        sb.append(this.f44159d);
        sb.append(", endedAt=");
        sb.append(this.f44160e);
        sb.append(", crashed=");
        sb.append(this.f44161f);
        sb.append(", app=");
        sb.append(this.f44162g);
        sb.append(", user=");
        sb.append(this.f44163h);
        sb.append(", os=");
        sb.append(this.f44164i);
        sb.append(", device=");
        sb.append(this.f44165j);
        sb.append(", events=");
        sb.append(this.f44166k);
        sb.append(", generatorType=");
        return b.o(sb, this.f44167l, "}");
    }
}
