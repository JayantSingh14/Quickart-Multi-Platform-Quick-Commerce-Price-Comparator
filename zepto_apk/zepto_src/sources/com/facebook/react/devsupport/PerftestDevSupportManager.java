package com.facebook.react.devsupport;

import android.app.Application;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.devsupport.DevServerHelper.AnonymousClass3;
import com.facebook.react.devsupport.DevServerHelper.AnonymousClass4;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class PerftestDevSupportManager extends ReleaseDevSupportManager {

    /* renamed from: b, reason: collision with root package name */
    public final DevInternalSettings f18866b;

    /* renamed from: c, reason: collision with root package name */
    public final DevServerHelper f18867c;

    public PerftestDevSupportManager(Application applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        DevInternalSettings devInternalSettings = new DevInternalSettings(applicationContext, new PerftestDevSupportManager$devSettings$1());
        this.f18866b = devInternalSettings;
        this.f18867c = new DevServerHelper(devInternalSettings, applicationContext, devInternalSettings.f18796c);
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void f() {
        DevServerHelper devServerHelper = this.f18867c;
        devServerHelper.getClass();
        devServerHelper.new AnonymousClass4().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void s() {
        DevServerHelper devServerHelper = this.f18867c;
        if (devServerHelper.f18805i != null) {
            FLog.q("ReactNative", "Inspector connection already open, nooping.");
        } else {
            devServerHelper.new AnonymousClass3().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public final DeveloperSettings y() {
        return this.f18866b;
    }
}
