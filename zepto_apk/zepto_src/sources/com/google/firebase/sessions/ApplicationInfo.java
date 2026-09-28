package com.google.firebase.sessions;

import android.os.Build;
import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ApplicationInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f44923a;

    /* renamed from: b, reason: collision with root package name */
    public final AndroidApplicationInfo f44924b;

    public ApplicationInfo(String appId, AndroidApplicationInfo androidAppInfo) {
        String deviceModel = Build.MODEL;
        String osVersion = Build.VERSION.RELEASE;
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter("2.1.2", "sessionSdkVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(logEnvironment, "logEnvironment");
        Intrinsics.checkNotNullParameter(androidAppInfo, "androidAppInfo");
        this.f44923a = appId;
        this.f44924b = androidAppInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        if (!Intrinsics.b(this.f44923a, applicationInfo.f44923a)) {
            return false;
        }
        String str = Build.MODEL;
        if (!Intrinsics.b(str, str)) {
            return false;
        }
        String str2 = Build.VERSION.RELEASE;
        return Intrinsics.b(str2, str2) && this.f44924b.equals(applicationInfo.f44924b);
    }

    public final int hashCode() {
        return this.f44924b.hashCode() + ((LogEnvironment.LOG_ENVIRONMENT_PROD.hashCode() + e.e((((Build.MODEL.hashCode() + (this.f44923a.hashCode() * 31)) * 31) + 47595001) * 31, 31, Build.VERSION.RELEASE)) * 31);
    }

    public final String toString() {
        return "ApplicationInfo(appId=" + this.f44923a + ", deviceModel=" + Build.MODEL + ", sessionSdkVersion=2.1.2, osVersion=" + Build.VERSION.RELEASE + ", logEnvironment=" + LogEnvironment.LOG_ENVIRONMENT_PROD + ", androidAppInfo=" + this.f44924b + ')';
    }
}
