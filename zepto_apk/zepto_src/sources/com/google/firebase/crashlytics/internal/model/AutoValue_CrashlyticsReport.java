package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport extends CrashlyticsReport {

    /* renamed from: b, reason: collision with root package name */
    public final String f44094b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44095c;

    /* renamed from: d, reason: collision with root package name */
    public final int f44096d;

    /* renamed from: e, reason: collision with root package name */
    public final String f44097e;

    /* renamed from: f, reason: collision with root package name */
    public final String f44098f;

    /* renamed from: g, reason: collision with root package name */
    public final String f44099g;

    /* renamed from: h, reason: collision with root package name */
    public final String f44100h;

    /* renamed from: i, reason: collision with root package name */
    public final String f44101i;

    /* renamed from: j, reason: collision with root package name */
    public final String f44102j;

    /* renamed from: k, reason: collision with root package name */
    public final CrashlyticsReport.Session f44103k;

    /* renamed from: l, reason: collision with root package name */
    public final CrashlyticsReport.FilesPayload f44104l;

    /* renamed from: m, reason: collision with root package name */
    public final CrashlyticsReport.ApplicationExitInfo f44105m;

    public static final class Builder extends CrashlyticsReport.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44106a;

        /* renamed from: b, reason: collision with root package name */
        public String f44107b;

        /* renamed from: c, reason: collision with root package name */
        public int f44108c;

        /* renamed from: d, reason: collision with root package name */
        public String f44109d;

        /* renamed from: e, reason: collision with root package name */
        public String f44110e;

        /* renamed from: f, reason: collision with root package name */
        public String f44111f;

        /* renamed from: g, reason: collision with root package name */
        public String f44112g;

        /* renamed from: h, reason: collision with root package name */
        public String f44113h;

        /* renamed from: i, reason: collision with root package name */
        public String f44114i;

        /* renamed from: j, reason: collision with root package name */
        public CrashlyticsReport.Session f44115j;

        /* renamed from: k, reason: collision with root package name */
        public CrashlyticsReport.FilesPayload f44116k;

        /* renamed from: l, reason: collision with root package name */
        public CrashlyticsReport.ApplicationExitInfo f44117l;

        /* renamed from: m, reason: collision with root package name */
        public byte f44118m;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport a() {
            if (this.f44118m == 1 && this.f44106a != null && this.f44107b != null && this.f44109d != null && this.f44113h != null && this.f44114i != null) {
                return new AutoValue_CrashlyticsReport(this.f44106a, this.f44107b, this.f44108c, this.f44109d, this.f44110e, this.f44111f, this.f44112g, this.f44113h, this.f44114i, this.f44115j, this.f44116k, this.f44117l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44106a == null) {
                sb.append(" sdkVersion");
            }
            if (this.f44107b == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.f44118m) == 0) {
                sb.append(" platform");
            }
            if (this.f44109d == null) {
                sb.append(" installationUuid");
            }
            if (this.f44113h == null) {
                sb.append(" buildVersion");
            }
            if (this.f44114i == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f44117l = applicationExitInfo;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder c(String str) {
            this.f44112g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f44113h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f44114i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder f(String str) {
            this.f44111f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder g(String str) {
            this.f44110e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder h(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f44107b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder i(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f44109d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder j(CrashlyticsReport.FilesPayload filesPayload) {
            this.f44116k = filesPayload;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder k(int i2) {
            this.f44108c = i2;
            this.f44118m = (byte) (this.f44118m | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder l(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f44106a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public final CrashlyticsReport.Builder m(CrashlyticsReport.Session session) {
            this.f44115j = session;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport(String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7, String str8, CrashlyticsReport.Session session, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        this.f44094b = str;
        this.f44095c = str2;
        this.f44096d = i2;
        this.f44097e = str3;
        this.f44098f = str4;
        this.f44099g = str5;
        this.f44100h = str6;
        this.f44101i = str7;
        this.f44102j = str8;
        this.f44103k = session;
        this.f44104l = filesPayload;
        this.f44105m = applicationExitInfo;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.ApplicationExitInfo b() {
        return this.f44105m;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String c() {
        return this.f44100h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String d() {
        return this.f44101i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String e() {
        return this.f44102j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (!this.f44094b.equals(crashlyticsReport.l()) || !this.f44095c.equals(crashlyticsReport.h()) || this.f44096d != crashlyticsReport.k() || !this.f44097e.equals(crashlyticsReport.i())) {
            return false;
        }
        String str = this.f44098f;
        if (str == null) {
            if (crashlyticsReport.g() != null) {
                return false;
            }
        } else if (!str.equals(crashlyticsReport.g())) {
            return false;
        }
        String str2 = this.f44099g;
        if (str2 == null) {
            if (crashlyticsReport.f() != null) {
                return false;
            }
        } else if (!str2.equals(crashlyticsReport.f())) {
            return false;
        }
        String str3 = this.f44100h;
        if (str3 == null) {
            if (crashlyticsReport.c() != null) {
                return false;
            }
        } else if (!str3.equals(crashlyticsReport.c())) {
            return false;
        }
        if (!this.f44101i.equals(crashlyticsReport.d()) || !this.f44102j.equals(crashlyticsReport.e())) {
            return false;
        }
        CrashlyticsReport.Session session = this.f44103k;
        if (session == null) {
            if (crashlyticsReport.m() != null) {
                return false;
            }
        } else if (!session.equals(crashlyticsReport.m())) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = this.f44104l;
        if (filesPayload == null) {
            if (crashlyticsReport.j() != null) {
                return false;
            }
        } else if (!filesPayload.equals(crashlyticsReport.j())) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f44105m;
        return applicationExitInfo == null ? crashlyticsReport.b() == null : applicationExitInfo.equals(crashlyticsReport.b());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String f() {
        return this.f44099g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String g() {
        return this.f44098f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String h() {
        return this.f44095c;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f44094b.hashCode() ^ 1000003) * 1000003) ^ this.f44095c.hashCode()) * 1000003) ^ this.f44096d) * 1000003) ^ this.f44097e.hashCode()) * 1000003;
        String str = this.f44098f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f44099g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f44100h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f44101i.hashCode()) * 1000003) ^ this.f44102j.hashCode()) * 1000003;
        CrashlyticsReport.Session session = this.f44103k;
        int iHashCode5 = (iHashCode4 ^ (session == null ? 0 : session.hashCode())) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.f44104l;
        int iHashCode6 = (iHashCode5 ^ (filesPayload == null ? 0 : filesPayload.hashCode())) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f44105m;
        return iHashCode6 ^ (applicationExitInfo != null ? applicationExitInfo.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String i() {
        return this.f44097e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.FilesPayload j() {
        return this.f44104l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final int k() {
        return this.f44096d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String l() {
        return this.f44094b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.Session m() {
        return this.f44103k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.Builder n() {
        Builder builder = new Builder();
        builder.f44106a = l();
        builder.f44107b = h();
        builder.f44108c = k();
        builder.f44109d = i();
        builder.f44110e = g();
        builder.f44111f = f();
        builder.f44112g = c();
        builder.f44113h = d();
        builder.f44114i = e();
        builder.f44115j = m();
        builder.f44116k = j();
        builder.f44117l = b();
        builder.f44118m = (byte) 1;
        return builder;
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f44094b + ", gmpAppId=" + this.f44095c + ", platform=" + this.f44096d + ", installationUuid=" + this.f44097e + ", firebaseInstallationId=" + this.f44098f + ", firebaseAuthenticationToken=" + this.f44099g + ", appQualitySessionId=" + this.f44100h + ", buildVersion=" + this.f44101i + ", displayVersion=" + this.f44102j + ", session=" + this.f44103k + ", ndkPayload=" + this.f44104l + ", appExitInfo=" + this.f44105m + "}";
    }
}
