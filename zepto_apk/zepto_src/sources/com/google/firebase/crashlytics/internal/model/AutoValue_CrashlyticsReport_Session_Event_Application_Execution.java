package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {

    /* renamed from: a, reason: collision with root package name */
    public final List f44240a;

    /* renamed from: b, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception f44241b;

    /* renamed from: c, reason: collision with root package name */
    public final CrashlyticsReport.ApplicationExitInfo f44242c;

    /* renamed from: d, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Application.Execution.Signal f44243d;

    /* renamed from: e, reason: collision with root package name */
    public final List f44244e;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Builder {

        /* renamed from: a, reason: collision with root package name */
        public List f44245a;

        /* renamed from: b, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Application.Execution.Exception f44246b;

        /* renamed from: c, reason: collision with root package name */
        public CrashlyticsReport.ApplicationExitInfo f44247c;

        /* renamed from: d, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Application.Execution.Signal f44248d;

        /* renamed from: e, reason: collision with root package name */
        public List f44249e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution a() {
            List list;
            CrashlyticsReport.Session.Event.Application.Execution.Signal signal = this.f44248d;
            if (signal != null && (list = this.f44249e) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.f44245a, this.f44246b, this.f44247c, signal, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44248d == null) {
                sb.append(" signal");
            }
            if (this.f44249e == null) {
                sb.append(" binaries");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Builder b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f44247c = applicationExitInfo;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Builder c(List list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f44249e = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Builder d(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f44246b = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Builder e(CrashlyticsReport.Session.Event.Application.Execution.Signal signal) {
            if (signal == null) {
                throw new NullPointerException("Null signal");
            }
            this.f44248d = signal;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Builder f(List list) {
            this.f44245a = list;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution(List list, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, CrashlyticsReport.ApplicationExitInfo applicationExitInfo, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, List list2) {
        this.f44240a = list;
        this.f44241b = exception;
        this.f44242c = applicationExitInfo;
        this.f44243d = signal;
        this.f44244e = list2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final CrashlyticsReport.ApplicationExitInfo b() {
        return this.f44242c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final List c() {
        return this.f44244e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception d() {
        return this.f44241b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final CrashlyticsReport.Session.Event.Application.Execution.Signal e() {
        return this.f44243d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        List list = this.f44240a;
        if (list == null) {
            if (execution.f() != null) {
                return false;
            }
        } else if (!list.equals(execution.f())) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f44241b;
        if (exception == null) {
            if (execution.d() != null) {
                return false;
            }
        } else if (!exception.equals(execution.d())) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f44242c;
        if (applicationExitInfo == null) {
            if (execution.b() != null) {
                return false;
            }
        } else if (!applicationExitInfo.equals(execution.b())) {
            return false;
        }
        return this.f44243d.equals(execution.e()) && this.f44244e.equals(execution.c());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final List f() {
        return this.f44240a;
    }

    public final int hashCode() {
        List list = this.f44240a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f44241b;
        int iHashCode2 = (iHashCode ^ (exception == null ? 0 : exception.hashCode())) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f44242c;
        return (((((applicationExitInfo != null ? applicationExitInfo.hashCode() : 0) ^ iHashCode2) * 1000003) ^ this.f44243d.hashCode()) * 1000003) ^ this.f44244e.hashCode();
    }

    public final String toString() {
        return "Execution{threads=" + this.f44240a + ", exception=" + this.f44241b + ", appExitInfo=" + this.f44242c + ", signal=" + this.f44243d + ", binaries=" + this.f44244e + "}";
    }
}
