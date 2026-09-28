package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.Session.Event.Log {

    /* renamed from: a, reason: collision with root package name */
    public final String f44317a;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Log.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44318a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public final CrashlyticsReport.Session.Event.Log a() {
            String str = this.f44318a;
            if (str != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Log(str);
            }
            throw new IllegalStateException("Missing required properties: content");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public final CrashlyticsReport.Session.Event.Log.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f44318a = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Log(String str) {
        this.f44317a = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log
    public final String b() {
        return this.f44317a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.f44317a.equals(((CrashlyticsReport.Session.Event.Log) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return this.f44317a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return b.r(new StringBuilder("Log{content="), this.f44317a, "}");
    }
}
