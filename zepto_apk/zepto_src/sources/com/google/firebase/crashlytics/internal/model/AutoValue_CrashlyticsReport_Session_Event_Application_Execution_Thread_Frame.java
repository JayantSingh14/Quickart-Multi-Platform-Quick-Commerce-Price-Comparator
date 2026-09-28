package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {

    /* renamed from: a, reason: collision with root package name */
    public final long f44284a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44285b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44286c;

    /* renamed from: d, reason: collision with root package name */
    public final long f44287d;

    /* renamed from: e, reason: collision with root package name */
    public final int f44288e;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f44289a;

        /* renamed from: b, reason: collision with root package name */
        public String f44290b;

        /* renamed from: c, reason: collision with root package name */
        public String f44291c;

        /* renamed from: d, reason: collision with root package name */
        public long f44292d;

        /* renamed from: e, reason: collision with root package name */
        public int f44293e;

        /* renamed from: f, reason: collision with root package name */
        public byte f44294f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame a() {
            String str;
            if (this.f44294f == 7 && (str = this.f44290b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f44289a, str, this.f44291c, this.f44292d, this.f44293e);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f44294f & 1) == 0) {
                sb.append(" pc");
            }
            if (this.f44290b == null) {
                sb.append(" symbol");
            }
            if ((this.f44294f & 2) == 0) {
                sb.append(" offset");
            }
            if ((this.f44294f & 4) == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder b(String str) {
            this.f44291c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder c(int i2) {
            this.f44293e = i2;
            this.f44294f = (byte) (this.f44294f | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder d(long j2) {
            this.f44292d = j2;
            this.f44294f = (byte) (this.f44294f | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder e(long j2) {
            this.f44289a = j2;
            this.f44294f = (byte) (this.f44294f | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f44290b = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j2, String str, String str2, long j3, int i2) {
        this.f44284a = j2;
        this.f44285b = str;
        this.f44286c = str2;
        this.f44287d = j3;
        this.f44288e = i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final String b() {
        return this.f44286c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final int c() {
        return this.f44288e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final long d() {
        return this.f44287d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final long e() {
        return this.f44284a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f44284a != frame.e() || !this.f44285b.equals(frame.f())) {
            return false;
        }
        String str = this.f44286c;
        if (str == null) {
            if (frame.b() != null) {
                return false;
            }
        } else if (!str.equals(frame.b())) {
            return false;
        }
        return this.f44287d == frame.d() && this.f44288e == frame.c();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final String f() {
        return this.f44285b;
    }

    public final int hashCode() {
        long j2 = this.f44284a;
        int iHashCode = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f44285b.hashCode()) * 1000003;
        String str = this.f44286c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j3 = this.f44287d;
        return ((iHashCode2 ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f44288e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Frame{pc=");
        sb.append(this.f44284a);
        sb.append(", symbol=");
        sb.append(this.f44285b);
        sb.append(", file=");
        sb.append(this.f44286c);
        sb.append(", offset=");
        sb.append(this.f44287d);
        sb.append(", importance=");
        return b.o(sb, this.f44288e, "}");
    }
}
