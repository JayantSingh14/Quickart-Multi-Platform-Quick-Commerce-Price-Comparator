package com.google.firebase.sessions;

import android.os.Build;
import androidx.fragment.app.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class AndroidApplicationInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f44918a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44919b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44920c;

    /* renamed from: d, reason: collision with root package name */
    public final ProcessDetails f44921d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f44922e;

    public AndroidApplicationInfo(String packageName, String versionName, String appBuildVersion, ProcessDetails currentProcessDetails, ArrayList appProcessDetails) {
        String deviceManufacturer = Build.MANUFACTURER;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(appBuildVersion, "appBuildVersion");
        Intrinsics.checkNotNullParameter(deviceManufacturer, "deviceManufacturer");
        Intrinsics.checkNotNullParameter(currentProcessDetails, "currentProcessDetails");
        Intrinsics.checkNotNullParameter(appProcessDetails, "appProcessDetails");
        this.f44918a = packageName;
        this.f44919b = versionName;
        this.f44920c = appBuildVersion;
        this.f44921d = currentProcessDetails;
        this.f44922e = appProcessDetails;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidApplicationInfo)) {
            return false;
        }
        AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
        if (!Intrinsics.b(this.f44918a, androidApplicationInfo.f44918a) || !Intrinsics.b(this.f44919b, androidApplicationInfo.f44919b) || !Intrinsics.b(this.f44920c, androidApplicationInfo.f44920c)) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return Intrinsics.b(str, str) && this.f44921d.equals(androidApplicationInfo.f44921d) && this.f44922e.equals(androidApplicationInfo.f44922e);
    }

    public final int hashCode() {
        return this.f44922e.hashCode() + ((this.f44921d.hashCode() + e.e(e.e(e.e(this.f44918a.hashCode() * 31, 31, this.f44919b), 31, this.f44920c), 31, Build.MANUFACTURER)) * 31);
    }

    public final String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f44918a + ", versionName=" + this.f44919b + ", appBuildVersion=" + this.f44920c + ", deviceManufacturer=" + Build.MANUFACTURER + ", currentProcessDetails=" + this.f44921d + ", appProcessDetails=" + this.f44922e + ')';
    }
}
