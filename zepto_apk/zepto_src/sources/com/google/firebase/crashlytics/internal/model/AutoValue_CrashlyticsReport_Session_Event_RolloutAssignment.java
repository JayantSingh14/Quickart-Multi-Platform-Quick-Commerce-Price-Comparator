package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment extends CrashlyticsReport.Session.Event.RolloutAssignment {

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant f44319a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44320b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44321c;

    /* renamed from: d, reason: collision with root package name */
    public final long f44322d;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.RolloutAssignment.Builder {

        /* renamed from: a, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant f44323a;

        /* renamed from: b, reason: collision with root package name */
        public String f44324b;

        /* renamed from: c, reason: collision with root package name */
        public String f44325c;

        /* renamed from: d, reason: collision with root package name */
        public long f44326d;

        /* renamed from: e, reason: collision with root package name */
        public byte f44327e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment a() {
            CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant;
            String str;
            String str2;
            if (this.f44327e == 1 && (rolloutVariant = this.f44323a) != null && (str = this.f44324b) != null && (str2 = this.f44325c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment(rolloutVariant, str, str2, this.f44326d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44323a == null) {
                sb.append(" rolloutVariant");
            }
            if (this.f44324b == null) {
                sb.append(" parameterKey");
            }
            if (this.f44325c == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f44327e) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f44324b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f44325c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment.Builder d(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant) {
            if (rolloutVariant == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.f44323a = rolloutVariant;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment.Builder e(long j2) {
            this.f44326d = j2;
            this.f44327e = (byte) (this.f44327e | 1);
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant, String str, String str2, long j2) {
        this.f44319a = rolloutVariant;
        this.f44320b = str;
        this.f44321c = str2;
        this.f44322d = j2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public final String b() {
        return this.f44320b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public final String c() {
        return this.f44321c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public final CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant d() {
        return this.f44319a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public final long e() {
        return this.f44322d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.RolloutAssignment)) {
            return false;
        }
        CrashlyticsReport.Session.Event.RolloutAssignment rolloutAssignment = (CrashlyticsReport.Session.Event.RolloutAssignment) obj;
        return this.f44319a.equals(rolloutAssignment.d()) && this.f44320b.equals(rolloutAssignment.b()) && this.f44321c.equals(rolloutAssignment.c()) && this.f44322d == rolloutAssignment.e();
    }

    public final int hashCode() {
        int iHashCode = (((((this.f44319a.hashCode() ^ 1000003) * 1000003) ^ this.f44320b.hashCode()) * 1000003) ^ this.f44321c.hashCode()) * 1000003;
        long j2 = this.f44322d;
        return iHashCode ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutVariant=");
        sb.append(this.f44319a);
        sb.append(", parameterKey=");
        sb.append(this.f44320b);
        sb.append(", parameterValue=");
        sb.append(this.f44321c);
        sb.append(", templateVersion=");
        return b.p(sb, this.f44322d, "}");
    }
}
