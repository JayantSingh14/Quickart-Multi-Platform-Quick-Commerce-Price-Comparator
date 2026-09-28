package com.facebook.react.fabric;

import com.facebook.react.fabric.DevToolsReactPerfLogger;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements DevToolsReactPerfLogger.DevToolsReactPerfLoggerListener {
    @Override // com.facebook.react.fabric.DevToolsReactPerfLogger.DevToolsReactPerfLoggerListener
    public final void onFabricCommitEnd(DevToolsReactPerfLogger.FabricCommitPoint fabricCommitPoint) {
        FabricUIManager.lambda$static$0(fabricCommitPoint);
    }
}
