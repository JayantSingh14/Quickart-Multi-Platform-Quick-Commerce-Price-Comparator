package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.install.InstallException;
import com.sudoplz.rninappupdates.SpReactNativeInAppUpdatesModule;

/* loaded from: classes4.dex */
public class FakeAppUpdateManager implements AppUpdateManager {
    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final void a(SpReactNativeInAppUpdatesModule spReactNativeInAppUpdatesModule) {
        throw null;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task b() {
        return Tasks.d(new InstallException(-8));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task c() {
        throw null;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean d(AppUpdateInfo appUpdateInfo, int i2, Activity activity, int i3) {
        AppUpdateOptions appUpdateOptionsA = AppUpdateOptions.d(i2).a();
        if (!(appUpdateInfo.a(appUpdateOptionsA) != null) && (!AppUpdateOptions.c(appUpdateOptionsA.b()).equals(appUpdateOptionsA) || appUpdateInfo.a(AppUpdateOptions.c(appUpdateOptionsA.b())) == null)) {
            return false;
        }
        appUpdateOptionsA.b();
        return true;
    }
}
