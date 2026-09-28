package com.google.android.play.core.appupdate;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
final class zzx extends AppUpdateOptions {

    /* renamed from: a, reason: collision with root package name */
    public final int f41748a;

    public /* synthetic */ zzx(int i2) {
        this.f41748a = i2;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final boolean a() {
        return false;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final int b() {
        return this.f41748a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppUpdateOptions)) {
            return false;
        }
        AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
        return this.f41748a == appUpdateOptions.b() && !appUpdateOptions.a();
    }

    public final int hashCode() {
        return ((this.f41748a ^ 1000003) * 1000003) ^ 1237;
    }

    public final String toString() {
        return b.o(new StringBuilder("AppUpdateOptions{appUpdateType="), this.f41748a, ", allowAssetPackDeletion=false}");
    }
}
