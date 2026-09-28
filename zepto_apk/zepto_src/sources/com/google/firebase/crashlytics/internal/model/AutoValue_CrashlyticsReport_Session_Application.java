package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {

    /* renamed from: a, reason: collision with root package name */
    public final String f44181a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44182b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44183c;

    /* renamed from: d, reason: collision with root package name */
    public final String f44184d;

    /* renamed from: e, reason: collision with root package name */
    public final String f44185e;

    /* renamed from: f, reason: collision with root package name */
    public final String f44186f;

    public static final class Builder extends CrashlyticsReport.Session.Application.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44187a;

        /* renamed from: b, reason: collision with root package name */
        public String f44188b;

        /* renamed from: c, reason: collision with root package name */
        public String f44189c;

        /* renamed from: d, reason: collision with root package name */
        public String f44190d;

        /* renamed from: e, reason: collision with root package name */
        public String f44191e;

        /* renamed from: f, reason: collision with root package name */
        public String f44192f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public final CrashlyticsReport.Session.Application a() {
            String str;
            String str2 = this.f44187a;
            if (str2 != null && (str = this.f44188b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Application(str2, str, this.f44189c, this.f44190d, this.f44191e, this.f44192f);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44187a == null) {
                sb.append(" identifier");
            }
            if (this.f44188b == null) {
                sb.append(" version");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public final CrashlyticsReport.Session.Application.Builder b(String str) {
            this.f44191e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public final CrashlyticsReport.Session.Application.Builder c(String str) {
            this.f44192f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public final CrashlyticsReport.Session.Application.Builder d(String str) {
            this.f44189c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public final CrashlyticsReport.Session.Application.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f44187a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public final CrashlyticsReport.Session.Application.Builder f(String str) {
            this.f44190d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public final CrashlyticsReport.Session.Application.Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f44188b = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f44181a = str;
        this.f44182b = str2;
        this.f44183c = str3;
        this.f44184d = str4;
        this.f44185e = str5;
        this.f44186f = str6;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String b() {
        return this.f44185e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String c() {
        return this.f44186f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String d() {
        return this.f44183c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String e() {
        return this.f44181a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (!this.f44181a.equals(application.e()) || !this.f44182b.equals(application.h())) {
            return false;
        }
        String str = this.f44183c;
        if (str == null) {
            if (application.d() != null) {
                return false;
            }
        } else if (!str.equals(application.d())) {
            return false;
        }
        if (application.g() != null) {
            return false;
        }
        String str2 = this.f44184d;
        if (str2 == null) {
            if (application.f() != null) {
                return false;
            }
        } else if (!str2.equals(application.f())) {
            return false;
        }
        String str3 = this.f44185e;
        if (str3 == null) {
            if (application.b() != null) {
                return false;
            }
        } else if (!str3.equals(application.b())) {
            return false;
        }
        String str4 = this.f44186f;
        return str4 == null ? application.c() == null : str4.equals(application.c());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String f() {
        return this.f44184d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final CrashlyticsReport.Session.Application.Organization g() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String h() {
        return this.f44182b;
    }

    public final int hashCode() {
        int iHashCode = (((this.f44181a.hashCode() ^ 1000003) * 1000003) ^ this.f44182b.hashCode()) * 1000003;
        String str = this.f44183c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f44184d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f44185e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f44186f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{identifier=");
        sb.append(this.f44181a);
        sb.append(", version=");
        sb.append(this.f44182b);
        sb.append(", displayVersion=");
        sb.append(this.f44183c);
        sb.append(", organization=null, installationUuid=");
        sb.append(this.f44184d);
        sb.append(", developmentPlatform=");
        sb.append(this.f44185e);
        sb.append(", developmentPlatformVersion=");
        return b.r(sb, this.f44186f, "}");
    }
}
