package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {

    /* renamed from: a, reason: collision with root package name */
    public final long f44250a;

    /* renamed from: b, reason: collision with root package name */
    public final long f44251b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44252c;

    /* renamed from: d, reason: collision with root package name */
    public final String f44253d;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f44254a;

        /* renamed from: b, reason: collision with root package name */
        public long f44255b;

        /* renamed from: c, reason: collision with root package name */
        public String f44256c;

        /* renamed from: d, reason: collision with root package name */
        public String f44257d;

        /* renamed from: e, reason: collision with root package name */
        public byte f44258e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage a() {
            String str;
            if (this.f44258e == 3 && (str = this.f44256c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.f44254a, this.f44255b, str, this.f44257d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f44258e & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.f44258e & 2) == 0) {
                sb.append(" size");
            }
            if (this.f44256c == null) {
                sb.append(" name");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder b(long j2) {
            this.f44254a = j2;
            this.f44258e = (byte) (this.f44258e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f44256c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder d(long j2) {
            this.f44255b = j2;
            this.f44258e = (byte) (this.f44258e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder e(String str) {
            this.f44257d = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j2, long j3, String str, String str2) {
        this.f44250a = j2;
        this.f44251b = j3;
        this.f44252c = str;
        this.f44253d = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public final long b() {
        return this.f44250a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public final String c() {
        return this.f44252c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public final long d() {
        return this.f44251b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public final String e() {
        return this.f44253d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.f44250a != binaryImage.b() || this.f44251b != binaryImage.d() || !this.f44252c.equals(binaryImage.c())) {
            return false;
        }
        String str = this.f44253d;
        return str == null ? binaryImage.e() == null : str.equals(binaryImage.e());
    }

    public final int hashCode() {
        long j2 = this.f44250a;
        long j3 = this.f44251b;
        int iHashCode = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f44252c.hashCode()) * 1000003;
        String str = this.f44253d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BinaryImage{baseAddress=");
        sb.append(this.f44250a);
        sb.append(", size=");
        sb.append(this.f44251b);
        sb.append(", name=");
        sb.append(this.f44252c);
        sb.append(", uuid=");
        return b.r(sb, this.f44253d, "}");
    }
}
