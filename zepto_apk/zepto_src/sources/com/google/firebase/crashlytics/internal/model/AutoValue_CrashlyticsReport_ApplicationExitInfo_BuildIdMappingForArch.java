package com.google.firebase.crashlytics.internal.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch {

    /* renamed from: a, reason: collision with root package name */
    public final String f44138a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44139b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44140c;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44141a;

        /* renamed from: b, reason: collision with root package name */
        public String f44142b;

        /* renamed from: c, reason: collision with root package name */
        public String f44143c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public final CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch a() {
            String str;
            String str2;
            String str3 = this.f44141a;
            if (str3 != null && (str = this.f44142b) != null && (str2 = this.f44143c) != null) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(str3, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f44141a == null) {
                sb.append(" arch");
            }
            if (this.f44142b == null) {
                sb.append(" libraryName");
            }
            if (this.f44143c == null) {
                sb.append(" buildId");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public final CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f44141a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public final CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f44143c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public final CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f44142b = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(String str, String str2, String str3) {
        this.f44138a = str;
        this.f44139b = str2;
        this.f44140c = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch
    public final String b() {
        return this.f44138a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch
    public final String c() {
        return this.f44140c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch
    public final String d() {
        return this.f44139b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch = (CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch) obj;
        return this.f44138a.equals(buildIdMappingForArch.b()) && this.f44139b.equals(buildIdMappingForArch.d()) && this.f44140c.equals(buildIdMappingForArch.c());
    }

    public final int hashCode() {
        return ((((this.f44138a.hashCode() ^ 1000003) * 1000003) ^ this.f44139b.hashCode()) * 1000003) ^ this.f44140c.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BuildIdMappingForArch{arch=");
        sb.append(this.f44138a);
        sb.append(", libraryName=");
        sb.append(this.f44139b);
        sb.append(", buildId=");
        return b.r(sb, this.f44140c, "}");
    }
}
