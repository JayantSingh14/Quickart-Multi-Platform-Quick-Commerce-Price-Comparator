package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread extends CrashlyticsReport.Session.Event.Application.Execution.Thread {

    /* renamed from: a, reason: collision with root package name */
    public final String f44277a;

    /* renamed from: b, reason: collision with root package name */
    public final int f44278b;

    /* renamed from: c, reason: collision with root package name */
    public final List f44279c;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44280a;

        /* renamed from: b, reason: collision with root package name */
        public int f44281b;

        /* renamed from: c, reason: collision with root package name */
        public List f44282c;

        /* renamed from: d, reason: collision with root package name */
        public byte f44283d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread a() {
            String str;
            List list;
            if (this.f44283d == 1 && (str = this.f44280a) != null && (list = this.f44282c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(str, list, this.f44281b);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44280a == null) {
                sb.append(" name");
            }
            if ((1 & this.f44283d) == 0) {
                sb.append(" importance");
            }
            if (this.f44282c == null) {
                sb.append(" frames");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder b(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f44282c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder c(int i2) {
            this.f44281b = i2;
            this.f44283d = (byte) (this.f44283d | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f44280a = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String str, List list, int i2) {
        this.f44277a = str;
        this.f44278b = i2;
        this.f44279c = list;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public final List b() {
        return this.f44279c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public final int c() {
        return this.f44278b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public final String d() {
        return this.f44277a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
        return this.f44277a.equals(thread.d()) && this.f44278b == thread.c() && this.f44279c.equals(thread.b());
    }

    public final int hashCode() {
        return ((((this.f44277a.hashCode() ^ 1000003) * 1000003) ^ this.f44278b) * 1000003) ^ this.f44279c.hashCode();
    }

    public final String toString() {
        return "Thread{name=" + this.f44277a + ", importance=" + this.f44278b + ", frames=" + this.f44279c + "}";
    }
}
