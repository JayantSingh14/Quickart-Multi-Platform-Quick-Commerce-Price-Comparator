package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {

    /* renamed from: a, reason: collision with root package name */
    public final int f44334a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44335b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44336c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f44337d;

    public static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f44338a;

        /* renamed from: b, reason: collision with root package name */
        public String f44339b;

        /* renamed from: c, reason: collision with root package name */
        public String f44340c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f44341d;

        /* renamed from: e, reason: collision with root package name */
        public byte f44342e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public final CrashlyticsReport.Session.OperatingSystem a() {
            String str;
            String str2;
            if (this.f44342e == 3 && (str = this.f44339b) != null && (str2 = this.f44340c) != null) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(str, this.f44338a, str2, this.f44341d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f44342e & 1) == 0) {
                sb.append(" platform");
            }
            if (this.f44339b == null) {
                sb.append(" version");
            }
            if (this.f44340c == null) {
                sb.append(" buildVersion");
            }
            if ((this.f44342e & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public final CrashlyticsReport.Session.OperatingSystem.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f44340c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public final CrashlyticsReport.Session.OperatingSystem.Builder c(boolean z) {
            this.f44341d = z;
            this.f44342e = (byte) (this.f44342e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public final CrashlyticsReport.Session.OperatingSystem.Builder d(int i2) {
            this.f44338a = i2;
            this.f44342e = (byte) (this.f44342e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public final CrashlyticsReport.Session.OperatingSystem.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f44339b = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_OperatingSystem(String str, int i2, String str2, boolean z) {
        this.f44334a = i2;
        this.f44335b = str;
        this.f44336c = str2;
        this.f44337d = z;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final String b() {
        return this.f44336c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final int c() {
        return this.f44334a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final String d() {
        return this.f44335b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final boolean e() {
        return this.f44337d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        return this.f44334a == operatingSystem.c() && this.f44335b.equals(operatingSystem.d()) && this.f44336c.equals(operatingSystem.b()) && this.f44337d == operatingSystem.e();
    }

    public final int hashCode() {
        return ((((((this.f44334a ^ 1000003) * 1000003) ^ this.f44335b.hashCode()) * 1000003) ^ this.f44336c.hashCode()) * 1000003) ^ (this.f44337d ? 1231 : 1237);
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.f44334a + ", version=" + this.f44335b + ", buildVersion=" + this.f44336c + ", jailbroken=" + this.f44337d + "}";
    }
}
