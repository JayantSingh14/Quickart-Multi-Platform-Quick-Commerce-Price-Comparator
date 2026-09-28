package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Application.Execution f44225a;

    /* renamed from: b, reason: collision with root package name */
    public final List f44226b;

    /* renamed from: c, reason: collision with root package name */
    public final List f44227c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f44228d;

    /* renamed from: e, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Application.ProcessDetails f44229e;

    /* renamed from: f, reason: collision with root package name */
    public final List f44230f;

    /* renamed from: g, reason: collision with root package name */
    public final int f44231g;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {

        /* renamed from: a, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Application.Execution f44232a;

        /* renamed from: b, reason: collision with root package name */
        public List f44233b;

        /* renamed from: c, reason: collision with root package name */
        public List f44234c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f44235d;

        /* renamed from: e, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Application.ProcessDetails f44236e;

        /* renamed from: f, reason: collision with root package name */
        public List f44237f;

        /* renamed from: g, reason: collision with root package name */
        public int f44238g;

        /* renamed from: h, reason: collision with root package name */
        public byte f44239h;

        public Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application a() {
            CrashlyticsReport.Session.Event.Application.Execution execution;
            if (this.f44239h == 1 && (execution = this.f44232a) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(execution, this.f44233b, this.f44234c, this.f44235d, this.f44236e, this.f44237f, this.f44238g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44232a == null) {
                sb.append(" execution");
            }
            if ((1 & this.f44239h) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application.Builder b(List list) {
            this.f44237f = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application.Builder c(Boolean bool) {
            this.f44235d = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application.Builder d(CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails) {
            this.f44236e = processDetails;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application.Builder e(List list) {
            this.f44233b = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application.Builder f(CrashlyticsReport.Session.Event.Application.Execution execution) {
            if (execution == null) {
                throw new NullPointerException("Null execution");
            }
            this.f44232a = execution;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application.Builder g(List list) {
            this.f44234c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public final CrashlyticsReport.Session.Event.Application.Builder h(int i2) {
            this.f44238g = i2;
            this.f44239h = (byte) (this.f44239h | 1);
            return this;
        }

        public Builder(CrashlyticsReport.Session.Event.Application application) {
            AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = (AutoValue_CrashlyticsReport_Session_Event_Application) application;
            this.f44232a = autoValue_CrashlyticsReport_Session_Event_Application.f44225a;
            this.f44233b = autoValue_CrashlyticsReport_Session_Event_Application.f44226b;
            this.f44234c = autoValue_CrashlyticsReport_Session_Event_Application.f44227c;
            this.f44235d = autoValue_CrashlyticsReport_Session_Event_Application.f44228d;
            this.f44236e = autoValue_CrashlyticsReport_Session_Event_Application.f44229e;
            this.f44237f = autoValue_CrashlyticsReport_Session_Event_Application.f44230f;
            this.f44238g = autoValue_CrashlyticsReport_Session_Event_Application.f44231g;
            this.f44239h = (byte) 1;
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution, List list, List list2, Boolean bool, CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails, List list3, int i2) {
        this.f44225a = execution;
        this.f44226b = list;
        this.f44227c = list2;
        this.f44228d = bool;
        this.f44229e = processDetails;
        this.f44230f = list3;
        this.f44231g = i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final List b() {
        return this.f44230f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final Boolean c() {
        return this.f44228d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final CrashlyticsReport.Session.Event.Application.ProcessDetails d() {
        return this.f44229e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final List e() {
        return this.f44226b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
        if (!this.f44225a.equals(application.f())) {
            return false;
        }
        List list = this.f44226b;
        if (list == null) {
            if (application.e() != null) {
                return false;
            }
        } else if (!list.equals(application.e())) {
            return false;
        }
        List list2 = this.f44227c;
        if (list2 == null) {
            if (application.g() != null) {
                return false;
            }
        } else if (!list2.equals(application.g())) {
            return false;
        }
        Boolean bool = this.f44228d;
        if (bool == null) {
            if (application.c() != null) {
                return false;
            }
        } else if (!bool.equals(application.c())) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = this.f44229e;
        if (processDetails == null) {
            if (application.d() != null) {
                return false;
            }
        } else if (!processDetails.equals(application.d())) {
            return false;
        }
        List list3 = this.f44230f;
        if (list3 == null) {
            if (application.b() != null) {
                return false;
            }
        } else if (!list3.equals(application.b())) {
            return false;
        }
        return this.f44231g == application.h();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final CrashlyticsReport.Session.Event.Application.Execution f() {
        return this.f44225a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final List g() {
        return this.f44227c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final int h() {
        return this.f44231g;
    }

    public final int hashCode() {
        int iHashCode = (this.f44225a.hashCode() ^ 1000003) * 1000003;
        List list = this.f44226b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f44227c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f44228d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = this.f44229e;
        int iHashCode5 = (iHashCode4 ^ (processDetails == null ? 0 : processDetails.hashCode())) * 1000003;
        List list3 = this.f44230f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f44231g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final CrashlyticsReport.Session.Event.Application.Builder i() {
        return new Builder(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{execution=");
        sb.append(this.f44225a);
        sb.append(", customAttributes=");
        sb.append(this.f44226b);
        sb.append(", internalKeys=");
        sb.append(this.f44227c);
        sb.append(", background=");
        sb.append(this.f44228d);
        sb.append(", currentProcessDetails=");
        sb.append(this.f44229e);
        sb.append(", appProcessDetails=");
        sb.append(this.f44230f);
        sb.append(", uiOrientation=");
        return b.o(sb, this.f44231g, "}");
    }
}
