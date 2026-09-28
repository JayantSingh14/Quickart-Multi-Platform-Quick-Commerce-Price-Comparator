package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant extends CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant {

    /* renamed from: a, reason: collision with root package name */
    public final String f44328a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44329b;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44330a;

        /* renamed from: b, reason: collision with root package name */
        public String f44331b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant a() {
            String str;
            String str2 = this.f44330a;
            if (str2 != null && (str = this.f44331b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44330a == null) {
                sb.append(" rolloutId");
            }
            if (this.f44331b == null) {
                sb.append(" variantId");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f44330a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder
        public final CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f44331b = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant(String str, String str2) {
        this.f44328a = str;
        this.f44329b = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant
    public final String b() {
        return this.f44328a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant
    public final String c() {
        return this.f44329b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant)) {
            return false;
        }
        CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant = (CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant) obj;
        return this.f44328a.equals(rolloutVariant.b()) && this.f44329b.equals(rolloutVariant.c());
    }

    public final int hashCode() {
        return ((this.f44328a.hashCode() ^ 1000003) * 1000003) ^ this.f44329b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutVariant{rolloutId=");
        sb.append(this.f44328a);
        sb.append(", variantId=");
        return b.r(sb, this.f44329b, "}");
    }
}
