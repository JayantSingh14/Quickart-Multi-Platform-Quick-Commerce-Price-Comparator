package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {

    /* renamed from: a, reason: collision with root package name */
    public final String f44343a;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.User.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44344a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public final CrashlyticsReport.Session.User a() {
            String str = this.f44344a;
            if (str != null) {
                return new AutoValue_CrashlyticsReport_Session_User(str);
            }
            throw new IllegalStateException("Missing required properties: identifier");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public final CrashlyticsReport.Session.User.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f44344a = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_User(String str) {
        this.f44343a = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User
    public final String b() {
        return this.f44343a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.f44343a.equals(((CrashlyticsReport.Session.User) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return this.f44343a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return b.r(new StringBuilder("User{identifier="), this.f44343a, "}");
    }
}
