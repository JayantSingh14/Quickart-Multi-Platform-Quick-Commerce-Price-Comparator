package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.ReactHostImplDevHelper;
import com.facebook.react.runtime.internal.bolts.Task;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
class BridgelessDevSupportManager extends DevSupportManagerBase {

    /* renamed from: com.facebook.react.devsupport.BridgelessDevSupportManager$1, reason: invalid class name */
    class AnonymousClass1 implements DevSupportManagerBase.CallbackWithBundleLoader {
    }

    public BridgelessDevSupportManager(Context context, ReactHostImplDevHelper reactHostImplDevHelper, String str) {
        super(context, reactHostImplDevHelper, str);
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerBase
    public final String G() {
        return "Bridgeless";
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void w() {
        UiThreadUtil.assertOnUiThread();
        j();
        ReactHostImplDevHelper reactHostImplDevHelper = this.f18823f;
        reactHostImplDevHelper.getClass();
        Intrinsics.checkNotNullParameter("BridgelessDevSupportManager.handleReloadJS()", "s");
        ReactHostImpl reactHostImpl = reactHostImplDevHelper.f19260a;
        reactHostImpl.getClass();
        Task.a(new com.facebook.react.runtime.a(reactHostImpl, 0), reactHostImpl.f19243e).c(new com.facebook.react.runtime.j(1), Task.f19311g);
    }
}
