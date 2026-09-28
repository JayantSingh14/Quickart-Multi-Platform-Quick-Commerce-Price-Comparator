package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends CrashlyticsReport.Session.Event.Application.Execution.Signal {

    /* renamed from: a, reason: collision with root package name */
    public final String f44270a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44271b;

    /* renamed from: c, reason: collision with root package name */
    public final long f44272c;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44273a;

        /* renamed from: b, reason: collision with root package name */
        public String f44274b;

        /* renamed from: c, reason: collision with root package name */
        public long f44275c;

        /* renamed from: d, reason: collision with root package name */
        public byte f44276d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Signal a() {
            String str;
            String str2;
            if (this.f44276d == 1 && (str = this.f44273a) != null && (str2 = this.f44274b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(this.f44275c, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44273a == null) {
                sb.append(" name");
            }
            if (this.f44274b == null) {
                sb.append(" code");
            }
            if ((1 & this.f44276d) == 0) {
                sb.append(" address");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder b(long j2) {
            this.f44275c = j2;
            this.f44276d = (byte) (this.f44276d | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f44274b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f44273a = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(long j2, String str, String str2) {
        this.f44270a = str;
        this.f44271b = str2;
        this.f44272c = j2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public final long b() {
        return this.f44272c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public final String c() {
        return this.f44271b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public final String d() {
        return this.f44270a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
        return this.f44270a.equals(signal.d()) && this.f44271b.equals(signal.c()) && this.f44272c == signal.b();
    }

    public final int hashCode() {
        int iHashCode = (((this.f44270a.hashCode() ^ 1000003) * 1000003) ^ this.f44271b.hashCode()) * 1000003;
        long j2 = this.f44272c;
        return iHashCode ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Signal{name=");
        sb.append(this.f44270a);
        sb.append(", code=");
        sb.append(this.f44271b);
        sb.append(", address=");
        return b.p(sb, this.f44272c, "}");
    }
}
