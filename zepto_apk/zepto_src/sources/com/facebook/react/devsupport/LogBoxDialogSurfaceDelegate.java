package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.util.RNLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class LogBoxDialogSurfaceDelegate implements SurfaceDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final DevSupportManager f18857a;

    /* renamed from: b, reason: collision with root package name */
    public View f18858b;

    /* renamed from: c, reason: collision with root package name */
    public LogBoxDialog f18859c;

    public LogBoxDialogSurfaceDelegate(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.f18857a = devSupportManager;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void a() {
        if (b() || !d()) {
            return;
        }
        Activity activityV = this.f18857a.v();
        if (activityV == null || activityV.isFinishing()) {
            RNLog.a("Unable to launch logbox because react activity is not available, here is the error that logbox would've displayed: ");
            return;
        }
        LogBoxDialog logBoxDialog = new LogBoxDialog(activityV, this.f18858b);
        this.f18859c = logBoxDialog;
        logBoxDialog.setCancelable(false);
        logBoxDialog.show();
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final boolean b() {
        LogBoxDialog logBoxDialog = this.f18859c;
        if (logBoxDialog != null) {
            return logBoxDialog.isShowing();
        }
        return false;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void c() {
        LogBoxDialog logBoxDialog;
        if (b() && (logBoxDialog = this.f18859c) != null) {
            logBoxDialog.dismiss();
        }
        View view = this.f18858b;
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        if (viewGroup != null) {
            viewGroup.removeView(this.f18858b);
        }
        this.f18859c = null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final boolean d() {
        return this.f18858b != null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void e(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Assertions.b(appKey.equals("LogBox"), "This surface manager can only create LogBox React application");
        View viewP = this.f18857a.p();
        this.f18858b = viewP;
        if (viewP == null) {
            RNLog.a("Unable to launch logbox because react was unable to create the root view");
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void f() {
        View view = this.f18858b;
        if (view != null) {
            this.f18857a.o(view);
            this.f18858b = null;
        }
    }
}
