package com.facebook.react.devsupport;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class ReleaseDevSupportManager implements DevSupportManager {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultJSExceptionHandler f18895a = new DefaultJSExceptionHandler();

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void A() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void B(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void C(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void D() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void E(PackagerStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.a(false);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void a(String message, DevSupportManager.PausedInDebuggerOverlayCommandListener listener) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void b() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void c(boolean z) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final String d() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final String e() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void f() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final boolean g() {
        return false;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void h(boolean z) {
    }

    @Override // com.facebook.react.bridge.JSExceptionHandler
    public final void handleException(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.f18895a.handleException(e2);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final SurfaceDelegate i(String str) {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void j() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final Pair k(Pair pair) {
        return pair;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void l(boolean z) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final String m() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void n(String str, DevOptionHandler devOptionHandler) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void o(View view) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final View p() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void q() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final RedBoxHandler r() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void s() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final StackFrame[] t() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final ReactContext u() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final Activity v() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void w() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void x(boolean z) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public DeveloperSettings y() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final boolean z() {
        return false;
    }
}
