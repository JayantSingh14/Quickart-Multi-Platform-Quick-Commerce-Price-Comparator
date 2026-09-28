package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes.dex */
final class AutoValue_StaticSessionData extends StaticSessionData {

    /* renamed from: a, reason: collision with root package name */
    public final StaticSessionData.AppData f44345a;

    /* renamed from: b, reason: collision with root package name */
    public final StaticSessionData.OsData f44346b;

    /* renamed from: c, reason: collision with root package name */
    public final StaticSessionData.DeviceData f44347c;

    public AutoValue_StaticSessionData(StaticSessionData.AppData appData, StaticSessionData.OsData osData, StaticSessionData.DeviceData deviceData) {
        this.f44345a = appData;
        this.f44346b = osData;
        this.f44347c = deviceData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.AppData a() {
        return this.f44345a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.DeviceData c() {
        return this.f44347c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.OsData d() {
        return this.f44346b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData)) {
            return false;
        }
        StaticSessionData staticSessionData = (StaticSessionData) obj;
        return this.f44345a.equals(staticSessionData.a()) && this.f44346b.equals(staticSessionData.d()) && this.f44347c.equals(staticSessionData.c());
    }

    public final int hashCode() {
        return ((((this.f44345a.hashCode() ^ 1000003) * 1000003) ^ this.f44346b.hashCode()) * 1000003) ^ this.f44347c.hashCode();
    }

    public final String toString() {
        return "StaticSessionData{appData=" + this.f44345a + ", osData=" + this.f44346b + ", deviceData=" + this.f44347c + "}";
    }
}
