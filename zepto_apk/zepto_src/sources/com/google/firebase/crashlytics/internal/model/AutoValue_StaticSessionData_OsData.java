package com.google.firebase.crashlytics.internal.model;

import android.os.Build;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes.dex */
final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {

    /* renamed from: a, reason: collision with root package name */
    public final String f44363a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44364b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f44365c;

    public AutoValue_StaticSessionData_OsData(boolean z) {
        String str = Build.VERSION.RELEASE;
        String str2 = Build.VERSION.CODENAME;
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f44363a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f44364b = str2;
        this.f44365c = z;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final boolean b() {
        return this.f44365c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final String c() {
        return this.f44364b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final String d() {
        return this.f44363a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.OsData)) {
            return false;
        }
        StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
        return this.f44363a.equals(osData.d()) && this.f44364b.equals(osData.c()) && this.f44365c == osData.b();
    }

    public final int hashCode() {
        return ((((this.f44363a.hashCode() ^ 1000003) * 1000003) ^ this.f44364b.hashCode()) * 1000003) ^ (this.f44365c ? 1231 : 1237);
    }

    public final String toString() {
        return "OsData{osRelease=" + this.f44363a + ", osCodeName=" + this.f44364b + ", isRooted=" + this.f44365c + "}";
    }
}
