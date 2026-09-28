package com.facebook.react.fabric;

import androidx.tracing.Trace;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class FabricUIManagerProviderImpl implements UIManagerProvider {
    private final ComponentFactory mComponentFactory;
    private final ViewManagerRegistry mViewManagerRegistry;

    public FabricUIManagerProviderImpl(ComponentFactory componentFactory, ViewManagerRegistry viewManagerRegistry) {
        this.mComponentFactory = componentFactory;
        this.mViewManagerRegistry = viewManagerRegistry;
    }

    @Override // com.facebook.react.bridge.UIManagerProvider
    public UIManager createUIManager(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter("FabricUIManagerProviderImpl.create", "sectionName");
        Trace.b("FabricUIManagerProviderImpl.create");
        EventBeatManager eventBeatManager = new EventBeatManager();
        Intrinsics.checkNotNullParameter("FabricUIManagerProviderImpl.createUIManager", "sectionName");
        Trace.b("FabricUIManagerProviderImpl.createUIManager");
        FabricUIManager fabricUIManager = new FabricUIManager(reactApplicationContext, this.mViewManagerRegistry, eventBeatManager);
        android.os.Trace.endSection();
        Intrinsics.checkNotNullParameter("FabricUIManagerProviderImpl.registerBinding", "sectionName");
        Trace.b("FabricUIManagerProviderImpl.registerBinding");
        FabricUIManagerBinding fabricUIManagerBinding = new FabricUIManagerBinding();
        CatalystInstance catalystInstance = reactApplicationContext.getCatalystInstance();
        RuntimeExecutor runtimeExecutor = catalystInstance.getRuntimeExecutor();
        RuntimeScheduler runtimeScheduler = catalystInstance.getRuntimeScheduler();
        if (runtimeExecutor == null || runtimeScheduler == null) {
            throw new IllegalStateException("Unable to register FabricUIManager with CatalystInstance, runtimeExecutor and runtimeScheduler must not be null");
        }
        fabricUIManagerBinding.register(runtimeExecutor, runtimeScheduler, fabricUIManager, eventBeatManager, this.mComponentFactory);
        android.os.Trace.endSection();
        android.os.Trace.endSection();
        return fabricUIManager;
    }
}
