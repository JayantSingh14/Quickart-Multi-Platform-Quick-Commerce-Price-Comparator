package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_CustomAttribute extends CrashlyticsReport.CustomAttribute {

    /* renamed from: a, reason: collision with root package name */
    public final String f44144a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44145b;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.CustomAttribute.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44146a;

        /* renamed from: b, reason: collision with root package name */
        public String f44147b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public final CrashlyticsReport.CustomAttribute a() {
            String str;
            String str2 = this.f44146a;
            if (str2 != null && (str = this.f44147b) != null) {
                return new AutoValue_CrashlyticsReport_CustomAttribute(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44146a == null) {
                sb.append(" key");
            }
            if (this.f44147b == null) {
                sb.append(" value");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public final CrashlyticsReport.CustomAttribute.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f44146a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public final CrashlyticsReport.CustomAttribute.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f44147b = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2) {
        this.f44144a = str;
        this.f44145b = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    public final String b() {
        return this.f44144a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    public final String c() {
        return this.f44145b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.CustomAttribute)) {
            return false;
        }
        CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
        return this.f44144a.equals(customAttribute.b()) && this.f44145b.equals(customAttribute.c());
    }

    public final int hashCode() {
        return ((this.f44144a.hashCode() ^ 1000003) * 1000003) ^ this.f44145b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CustomAttribute{key=");
        sb.append(this.f44144a);
        sb.append(", value=");
        return b.r(sb, this.f44145b, "}");
    }
}
