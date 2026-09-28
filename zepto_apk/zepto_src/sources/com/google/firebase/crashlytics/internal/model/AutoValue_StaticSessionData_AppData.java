package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes.dex */
final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {

    /* renamed from: a, reason: collision with root package name */
    public final String f44348a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44349b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44350c;

    /* renamed from: d, reason: collision with root package name */
    public final String f44351d;

    /* renamed from: e, reason: collision with root package name */
    public final int f44352e;

    /* renamed from: f, reason: collision with root package name */
    public final DevelopmentPlatformProvider f44353f;

    public AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i2, DevelopmentPlatformProvider developmentPlatformProvider) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f44348a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f44349b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f44350c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f44351d = str4;
        this.f44352e = i2;
        this.f44353f = developmentPlatformProvider;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String a() {
        return this.f44348a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final int c() {
        return this.f44352e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final DevelopmentPlatformProvider d() {
        return this.f44353f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String e() {
        return this.f44351d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.AppData)) {
            return false;
        }
        StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
        return this.f44348a.equals(appData.a()) && this.f44349b.equals(appData.f()) && this.f44350c.equals(appData.g()) && this.f44351d.equals(appData.e()) && this.f44352e == appData.c() && this.f44353f.equals(appData.d());
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String f() {
        return this.f44349b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String g() {
        return this.f44350c;
    }

    public final int hashCode() {
        return ((((((((((this.f44348a.hashCode() ^ 1000003) * 1000003) ^ this.f44349b.hashCode()) * 1000003) ^ this.f44350c.hashCode()) * 1000003) ^ this.f44351d.hashCode()) * 1000003) ^ this.f44352e) * 1000003) ^ this.f44353f.hashCode();
    }

    public final String toString() {
        return "AppData{appIdentifier=" + this.f44348a + ", versionCode=" + this.f44349b + ", versionName=" + this.f44350c + ", installUuid=" + this.f44351d + ", deliveryMechanism=" + this.f44352e + ", developmentPlatformProvider=" + this.f44353f + "}";
    }
}
