package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails extends CrashlyticsReport.Session.Event.Application.ProcessDetails {

    /* renamed from: a, reason: collision with root package name */
    public final String f44295a;

    /* renamed from: b, reason: collision with root package name */
    public final int f44296b;

    /* renamed from: c, reason: collision with root package name */
    public final int f44297c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f44298d;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44299a;

        /* renamed from: b, reason: collision with root package name */
        public int f44300b;

        /* renamed from: c, reason: collision with root package name */
        public int f44301c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f44302d;

        /* renamed from: e, reason: collision with root package name */
        public byte f44303e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public final CrashlyticsReport.Session.Event.Application.ProcessDetails a() {
            String str;
            if (this.f44303e == 7 && (str = this.f44299a) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails(this.f44300b, this.f44301c, str, this.f44302d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44299a == null) {
                sb.append(" processName");
            }
            if ((this.f44303e & 1) == 0) {
                sb.append(" pid");
            }
            if ((this.f44303e & 2) == 0) {
                sb.append(" importance");
            }
            if ((this.f44303e & 4) == 0) {
                sb.append(" defaultProcess");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public final CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder b(boolean z) {
            this.f44302d = z;
            this.f44303e = (byte) (this.f44303e | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public final CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder c(int i2) {
            this.f44301c = i2;
            this.f44303e = (byte) (this.f44303e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public final CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder d(int i2) {
            this.f44300b = i2;
            this.f44303e = (byte) (this.f44303e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public final CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f44299a = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails(int i2, int i3, String str, boolean z) {
        this.f44295a = str;
        this.f44296b = i2;
        this.f44297c = i3;
        this.f44298d = z;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public final int b() {
        return this.f44297c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public final int c() {
        return this.f44296b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public final String d() {
        return this.f44295a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public final boolean e() {
        return this.f44298d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.ProcessDetails)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) obj;
        return this.f44295a.equals(processDetails.d()) && this.f44296b == processDetails.c() && this.f44297c == processDetails.b() && this.f44298d == processDetails.e();
    }

    public final int hashCode() {
        return ((((((this.f44295a.hashCode() ^ 1000003) * 1000003) ^ this.f44296b) * 1000003) ^ this.f44297c) * 1000003) ^ (this.f44298d ? 1231 : 1237);
    }

    public final String toString() {
        return "ProcessDetails{processName=" + this.f44295a + ", pid=" + this.f44296b + ", importance=" + this.f44297c + ", defaultProcess=" + this.f44298d + "}";
    }
}
