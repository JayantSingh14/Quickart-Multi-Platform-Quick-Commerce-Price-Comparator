package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.Session.Event.Application.Execution.Exception {

    /* renamed from: a, reason: collision with root package name */
    public final String f44259a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44260b;

    /* renamed from: c, reason: collision with root package name */
    public final List f44261c;

    /* renamed from: d, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception f44262d;

    /* renamed from: e, reason: collision with root package name */
    public final int f44263e;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44264a;

        /* renamed from: b, reason: collision with root package name */
        public String f44265b;

        /* renamed from: c, reason: collision with root package name */
        public List f44266c;

        /* renamed from: d, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Application.Execution.Exception f44267d;

        /* renamed from: e, reason: collision with root package name */
        public int f44268e;

        /* renamed from: f, reason: collision with root package name */
        public byte f44269f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Exception a() {
            String str;
            List list;
            if (this.f44269f == 1 && (str = this.f44264a) != null && (list = this.f44266c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(str, this.f44265b, list, this.f44267d, this.f44268e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44264a == null) {
                sb.append(" type");
            }
            if (this.f44266c == null) {
                sb.append(" frames");
            }
            if ((1 & this.f44269f) == 0) {
                sb.append(" overflowCount");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder b(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f44267d = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder c(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f44266c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder d(int i2) {
            this.f44268e = i2;
            this.f44269f = (byte) (this.f44269f | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder e(String str) {
            this.f44265b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f44264a = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, List list, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int i2) {
        this.f44259a = str;
        this.f44260b = str2;
        this.f44261c = list;
        this.f44262d = exception;
        this.f44263e = i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception b() {
        return this.f44262d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final List c() {
        return this.f44261c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final int d() {
        return this.f44263e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final String e() {
        return this.f44260b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
        if (!this.f44259a.equals(exception.f())) {
            return false;
        }
        String str = this.f44260b;
        if (str == null) {
            if (exception.e() != null) {
                return false;
            }
        } else if (!str.equals(exception.e())) {
            return false;
        }
        if (!this.f44261c.equals(exception.c())) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception2 = this.f44262d;
        if (exception2 == null) {
            if (exception.b() != null) {
                return false;
            }
        } else if (!exception2.equals(exception.b())) {
            return false;
        }
        return this.f44263e == exception.d();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final String f() {
        return this.f44259a;
    }

    public final int hashCode() {
        int iHashCode = (this.f44259a.hashCode() ^ 1000003) * 1000003;
        String str = this.f44260b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f44261c.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f44262d;
        return ((iHashCode2 ^ (exception != null ? exception.hashCode() : 0)) * 1000003) ^ this.f44263e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Exception{type=");
        sb.append(this.f44259a);
        sb.append(", reason=");
        sb.append(this.f44260b);
        sb.append(", frames=");
        sb.append(this.f44261c);
        sb.append(", causedBy=");
        sb.append(this.f44262d);
        sb.append(", overflowCount=");
        return b.o(sb, this.f44263e, "}");
    }
}
