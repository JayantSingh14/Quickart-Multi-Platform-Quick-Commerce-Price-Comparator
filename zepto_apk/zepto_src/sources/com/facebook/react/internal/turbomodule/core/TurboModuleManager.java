package com.facebook.react.internal.turbomodule.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.internal.turbomodule.core.TurboModuleInteropUtils;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TurboModuleManager implements TurboModuleRegistry {
    private static final String TAG = "TurboModuleManager";
    private final TurboModuleManagerDelegate mDelegate;
    private final List<String> mEagerInitModuleNames;

    @DoNotStrip
    private final HybridData mHybridData;
    private final ModuleProvider mLegacyModuleProvider;
    private final Object mModuleCleanupLock = new Object();

    @GuardedBy
    private boolean mModuleCleanupStarted = false;

    @GuardedBy
    private final Map<String, ModuleHolder> mModuleHolders = new HashMap();
    private final ModuleProvider mTurboModuleProvider;

    /* loaded from: classes3.dex */
    public static class ModuleHolder {
        private static volatile int sHolderCount;
        private volatile NativeModule mModule = null;
        private volatile boolean mIsTryingToCreate = false;
        private volatile boolean mIsDoneCreatingModule = false;
        private volatile int mModuleId = sHolderCount;

        public ModuleHolder() {
            sHolderCount++;
        }

        public void endCreatingModule() {
            this.mIsTryingToCreate = false;
            this.mIsDoneCreatingModule = true;
        }

        @Nullable
        public NativeModule getModule() {
            return this.mModule;
        }

        public int getModuleId() {
            return this.mModuleId;
        }

        public boolean isCreatingModule() {
            return this.mIsTryingToCreate;
        }

        public boolean isDoneCreatingModule() {
            return this.mIsDoneCreatingModule;
        }

        public void setModule(@NonNull NativeModule nativeModule) {
            this.mModule = nativeModule;
        }

        public void startCreatingModule() {
            this.mIsTryingToCreate = true;
        }
    }

    /* loaded from: classes3.dex */
    public interface ModuleProvider {
        @Nullable
        NativeModule getModule(String str);
    }

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    public TurboModuleManager(RuntimeExecutor runtimeExecutor, @Nullable final TurboModuleManagerDelegate turboModuleManagerDelegate, CallInvokerHolder callInvokerHolder, NativeMethodCallInvokerHolder nativeMethodCallInvokerHolder) {
        ModuleProvider moduleProvider;
        this.mDelegate = turboModuleManagerDelegate;
        this.mHybridData = initHybrid(runtimeExecutor, (CallInvokerHolderImpl) callInvokerHolder, (NativeMethodCallInvokerHolderImpl) nativeMethodCallInvokerHolder, turboModuleManagerDelegate);
        installJSIBindings(shouldEnableLegacyModuleInterop());
        this.mEagerInitModuleNames = turboModuleManagerDelegate == null ? Collections.EMPTY_LIST : turboModuleManagerDelegate.getEagerInitModuleNames();
        ModuleProvider moduleProvider2 = new ModuleProvider() { // from class: com.facebook.react.internal.turbomodule.core.a
            @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleProvider
            public final NativeModule getModule(String str) {
                return TurboModuleManager.lambda$new$0(str);
            }
        };
        if (turboModuleManagerDelegate == null) {
            moduleProvider = moduleProvider2;
        } else {
            final int i2 = 0;
            moduleProvider = new ModuleProvider() { // from class: com.facebook.react.internal.turbomodule.core.b
                @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleProvider
                public final NativeModule getModule(String str) {
                    switch (i2) {
                        case 0:
                            return TurboModuleManager.lambda$new$1(turboModuleManagerDelegate, str);
                        default:
                            return TurboModuleManager.lambda$new$2(turboModuleManagerDelegate, str);
                    }
                }
            };
        }
        this.mTurboModuleProvider = moduleProvider;
        if (turboModuleManagerDelegate != null && shouldEnableLegacyModuleInterop()) {
            final int i3 = 1;
            moduleProvider2 = new ModuleProvider() { // from class: com.facebook.react.internal.turbomodule.core.b
                @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleProvider
                public final NativeModule getModule(String str) {
                    switch (i3) {
                        case 0:
                            return TurboModuleManager.lambda$new$1(turboModuleManagerDelegate, str);
                        default:
                            return TurboModuleManager.lambda$new$2(turboModuleManagerDelegate, str);
                    }
                }
            };
        }
        this.mLegacyModuleProvider = moduleProvider2;
    }

    @Nullable
    @DoNotStrip
    private CxxModuleWrapper getLegacyCxxModule(String str) {
        if (!isLegacyModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if (!(module instanceof CxxModuleWrapper) || (module instanceof TurboModule)) {
            return null;
        }
        return (CxxModuleWrapper) module;
    }

    @Nullable
    @DoNotStrip
    private NativeModule getLegacyJavaModule(String str) {
        if (!isLegacyModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) || (module instanceof TurboModule)) {
            return null;
        }
        return module;
    }

    @DoNotStrip
    private static List<TurboModuleInteropUtils.MethodDescriptor> getMethodDescriptorsFromModule(NativeModule nativeModule) {
        return TurboModuleInteropUtils.getMethodDescriptorsFromModule(nativeModule);
    }

    @Nullable
    private NativeModule getOrCreateModule(String str, @NonNull ModuleHolder moduleHolder, boolean z) {
        boolean z2;
        NativeModule module;
        synchronized (moduleHolder) {
            try {
                if (moduleHolder.isDoneCreatingModule()) {
                    if (z) {
                        TurboModulePerfLogger.moduleCreateCacheHit(str, moduleHolder.getModuleId());
                    }
                    return moduleHolder.getModule();
                }
                boolean z3 = false;
                if (moduleHolder.isCreatingModule()) {
                    z2 = false;
                } else {
                    moduleHolder.startCreatingModule();
                    z2 = true;
                }
                if (!z2) {
                    synchronized (moduleHolder) {
                        while (moduleHolder.isCreatingModule()) {
                            try {
                                moduleHolder.wait();
                            } catch (InterruptedException unused) {
                                z3 = true;
                            }
                        }
                        if (z3) {
                            Thread.currentThread().interrupt();
                        }
                        module = moduleHolder.getModule();
                    }
                    return module;
                }
                TurboModulePerfLogger.moduleCreateConstructStart(str, moduleHolder.getModuleId());
                NativeModule module2 = this.mTurboModuleProvider.getModule(str);
                if (module2 == null) {
                    module2 = this.mLegacyModuleProvider.getModule(str);
                }
                TurboModulePerfLogger.moduleCreateConstructEnd(str, moduleHolder.getModuleId());
                TurboModulePerfLogger.moduleCreateSetUpStart(str, moduleHolder.getModuleId());
                if (module2 != null) {
                    synchronized (moduleHolder) {
                        moduleHolder.setModule(module2);
                    }
                    module2.initialize();
                } else {
                    FLog.i(TAG, "getOrCreateModule(): Unable to create module \"%s\" (legacy: %b, turbo: %b)", str, Boolean.valueOf(isLegacyModule(str)), Boolean.valueOf(isTurboModule(str)));
                }
                TurboModulePerfLogger.moduleCreateSetUpEnd(str, moduleHolder.getModuleId());
                synchronized (moduleHolder) {
                    moduleHolder.endCreatingModule();
                    moduleHolder.notifyAll();
                }
                return module2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    @DoNotStrip
    private TurboModule getTurboJavaModule(String str) {
        if (!isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) || !(module instanceof TurboModule)) {
            return null;
        }
        return (TurboModule) module;
    }

    @Nullable
    @DoNotStrip
    private CxxModuleWrapper getTurboLegacyCxxModule(String str) {
        if (!isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) && (module instanceof TurboModule)) {
            return (CxxModuleWrapper) module;
        }
        return null;
    }

    private native HybridData initHybrid(RuntimeExecutor runtimeExecutor, CallInvokerHolderImpl callInvokerHolderImpl, NativeMethodCallInvokerHolderImpl nativeMethodCallInvokerHolderImpl, TurboModuleManagerDelegate turboModuleManagerDelegate);

    private native void installJSIBindings(boolean z);

    private boolean isLegacyModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_isLegacyModuleRegistered(str);
    }

    private boolean isTurboModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_isModuleRegistered(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NativeModule lambda$new$0(String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NativeModule lambda$new$1(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        return (NativeModule) turboModuleManagerDelegate.getModule(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NativeModule lambda$new$2(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        NativeModule legacyModule = turboModuleManagerDelegate.getLegacyModule(str);
        if (legacyModule == null) {
            return null;
        }
        Assertions.b(!(legacyModule instanceof TurboModule), "NativeModule \"" + str + "\" is a TurboModule");
        return legacyModule;
    }

    private boolean shouldEnableLegacyModuleInterop() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_shouldEnableLegacyModuleInterop();
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    @NonNull
    public List<String> getEagerInitModuleNames() {
        return this.mEagerInitModuleNames;
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    @Nullable
    public NativeModule getModule(String str) {
        synchronized (this.mModuleCleanupLock) {
            try {
                if (this.mModuleCleanupStarted) {
                    FLog.i(TAG, "getModule(): Tried to get module \"%s\", but TurboModuleManager was tearing down (legacy: %b, turbo: %b)", str, Boolean.valueOf(isLegacyModule(str)), Boolean.valueOf(isTurboModule(str)));
                    return null;
                }
                if (!this.mModuleHolders.containsKey(str)) {
                    this.mModuleHolders.put(str, new ModuleHolder());
                }
                ModuleHolder moduleHolder = this.mModuleHolders.get(str);
                TurboModulePerfLogger.moduleCreateStart(str, moduleHolder.getModuleId());
                NativeModule orCreateModule = getOrCreateModule(str, moduleHolder, true);
                if (orCreateModule != null) {
                    TurboModulePerfLogger.moduleCreateEnd(str, moduleHolder.getModuleId());
                    return orCreateModule;
                }
                TurboModulePerfLogger.moduleCreateFail(str, moduleHolder.getModuleId());
                return orCreateModule;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public Collection<NativeModule> getModules() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mModuleCleanupLock) {
            arrayList.addAll(this.mModuleHolders.values());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ModuleHolder moduleHolder = (ModuleHolder) it.next();
            synchronized (moduleHolder) {
                try {
                    if (moduleHolder.getModule() != null) {
                        arrayList2.add(moduleHolder.getModule());
                    }
                } finally {
                }
            }
        }
        return arrayList2;
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public boolean hasModule(String str) {
        ModuleHolder moduleHolder;
        synchronized (this.mModuleCleanupLock) {
            moduleHolder = this.mModuleHolders.get(str);
        }
        if (moduleHolder == null) {
            return false;
        }
        synchronized (moduleHolder) {
            try {
                return moduleHolder.getModule() != null;
            } finally {
            }
        }
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public void invalidate() {
        synchronized (this.mModuleCleanupLock) {
            this.mModuleCleanupStarted = true;
        }
        for (Map.Entry<String, ModuleHolder> entry : this.mModuleHolders.entrySet()) {
            NativeModule orCreateModule = getOrCreateModule(entry.getKey(), entry.getValue(), false);
            if (orCreateModule != null) {
                orCreateModule.invalidate();
            }
        }
        this.mModuleHolders.clear();
        this.mHybridData.resetNative();
    }
}
