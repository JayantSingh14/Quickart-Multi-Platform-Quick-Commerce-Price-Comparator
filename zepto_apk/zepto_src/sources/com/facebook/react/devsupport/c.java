package com.facebook.react.devsupport;

import androidx.core.util.Supplier;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.devsupport.interfaces.BundleLoadCallback;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements DevInternalSettings.Listener, ShakeDetector.ShakeListener, Supplier, BundleLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DevSupportManagerBase f18924a;

    public /* synthetic */ c(DevSupportManagerBase devSupportManagerBase) {
        this.f18924a = devSupportManagerBase;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings.Listener
    public void a() {
        this.f18924a.J();
    }

    @Override // com.facebook.react.devsupport.interfaces.BundleLoadCallback
    public void onSuccess() {
        BridgeDevSupportManager bridgeDevSupportManager = (BridgeDevSupportManager) this.f18924a;
        bridgeDevSupportManager.getClass();
        UiThreadUtil.runOnUiThread(new m(bridgeDevSupportManager, 2));
    }
}
