package com.google.android.play.core.appupdate;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.sudoplz.rninappupdates.SpReactNativeInAppUpdatesModule;

/* loaded from: classes.dex */
public interface AppUpdateManager {
    void a(SpReactNativeInAppUpdatesModule spReactNativeInAppUpdatesModule);

    Task b();

    Task c();

    boolean d(AppUpdateInfo appUpdateInfo, int i2, Activity activity, int i3);
}
