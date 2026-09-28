package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes4.dex */
final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsReport f43724a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43725b;

    /* renamed from: c, reason: collision with root package name */
    public final File f43726c;

    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport == null) {
            throw new NullPointerException("Null report");
        }
        this.f43724a = crashlyticsReport;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f43725b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f43726c = file;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public final CrashlyticsReport b() {
        return this.f43724a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public final File c() {
        return this.f43726c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public final String d() {
        return this.f43725b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        return this.f43724a.equals(crashlyticsReportWithSessionId.b()) && this.f43725b.equals(crashlyticsReportWithSessionId.d()) && this.f43726c.equals(crashlyticsReportWithSessionId.c());
    }

    public final int hashCode() {
        return ((((this.f43724a.hashCode() ^ 1000003) * 1000003) ^ this.f43725b.hashCode()) * 1000003) ^ this.f43726c.hashCode();
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f43724a + ", sessionId=" + this.f43725b + ", reportFile=" + this.f43726c + "}";
    }
}
