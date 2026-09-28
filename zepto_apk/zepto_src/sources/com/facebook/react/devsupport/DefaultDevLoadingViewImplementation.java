package com.facebook.react.devsupport;

import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.runtime.ReactHostImplDevHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DefaultDevLoadingViewImplementation implements DevLoadingViewManager {

    /* renamed from: a, reason: collision with root package name */
    public final ReactHostImplDevHelper f18791a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f18792b;

    /* renamed from: c, reason: collision with root package name */
    public PopupWindow f18793c;

    @Metadata
    public static final class Companion {
    }

    public DefaultDevLoadingViewImplementation(ReactHostImplDevHelper reactInstanceDevHelper) {
        Intrinsics.checkNotNullParameter(reactInstanceDevHelper, "reactInstanceDevHelper");
        this.f18791a = reactInstanceDevHelper;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        UiThreadUtil.runOnUiThread(new androidx.constraintlayout.motion.widget.a(20, this, message));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public final void b(String str, Integer num, Integer num2) {
        UiThreadUtil.runOnUiThread(new d(num, num2, this, str));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public final void c() {
        UiThreadUtil.runOnUiThread(new m(this, 3));
    }
}
