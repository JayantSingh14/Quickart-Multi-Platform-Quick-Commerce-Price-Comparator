package com.facebook.react.bridge;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.systrace.SystraceMessage;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@DoNotStrip
/* loaded from: classes.dex */
public class ModuleHolder {
    private static final AtomicInteger sInstanceKeyCounter = new AtomicInteger(1);

    @GuardedBy
    private boolean mInitializable;
    private final int mInstanceKey = sInstanceKeyCounter.getAndIncrement();

    @GuardedBy
    private boolean mIsCreating;

    @GuardedBy
    private boolean mIsInitializing;

    @Nullable
    @GuardedBy
    private NativeModule mModule;
    private final String mName;

    @Nullable
    private Provider<? extends NativeModule> mProvider;
    private final ReactModuleInfo mReactModuleInfo;

    public ModuleHolder(ReactModuleInfo reactModuleInfo, Provider<? extends NativeModule> provider) {
        this.mName = reactModuleInfo.f19020a;
        this.mProvider = provider;
        this.mReactModuleInfo = reactModuleInfo;
        if (reactModuleInfo.f19023d) {
            this.mModule = create();
        }
    }

    private NativeModule create() {
        boolean z = false;
        SoftAssertions.assertCondition(this.mModule == null, "Creating an already created module.");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, this.mName, this.mInstanceKey);
        SystraceMessage.Builder builderA = SystraceMessage.a("ModuleHolder.createModule");
        builderA.b(this.mName, CLConstants.FIELD_PAY_INFO_NAME);
        builderA.c();
        DebugOverlayTag tag = ReactDebugOverlayTags.f17192c;
        Object[] args = {this.mName};
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter("NativeModule init: %s", APayConstants.Error.MESSAGE);
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            Provider<? extends NativeModule> provider = this.mProvider;
            Assertions.c(provider);
            NativeModule nativeModule = (NativeModule) provider.get();
            this.mProvider = null;
            synchronized (this) {
                try {
                    this.mModule = nativeModule;
                    if (this.mInitializable && !this.mIsInitializing) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                doInitialize(nativeModule);
            }
            return nativeModule;
        } finally {
        }
    }

    private void doInitialize(NativeModule nativeModule) {
        boolean z;
        SystraceMessage.Builder builderA = SystraceMessage.a("ModuleHolder.initialize");
        builderA.b(this.mName, CLConstants.FIELD_PAY_INFO_NAME);
        builderA.c();
        ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_START, this.mName, this.mInstanceKey);
        try {
            synchronized (this) {
                try {
                    if (!this.mInitializable || this.mIsInitializing) {
                        z = false;
                    } else {
                        z = true;
                        this.mIsInitializing = true;
                    }
                } finally {
                }
            }
            if (z) {
                nativeModule.initialize();
                synchronized (this) {
                    this.mIsInitializing = false;
                }
            }
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mName, this.mInstanceKey);
            SystraceMessage.b().c();
        }
    }

    public synchronized void destroy() {
        NativeModule nativeModule = this.mModule;
        if (nativeModule != null) {
            nativeModule.invalidate();
        }
    }

    public boolean getCanOverrideExistingModule() {
        return this.mReactModuleInfo.f19022c;
    }

    public String getClassName() {
        return this.mReactModuleInfo.f19021b;
    }

    @DoNotStrip
    public NativeModule getModule() {
        boolean z;
        NativeModule nativeModule;
        synchronized (this) {
            try {
                NativeModule nativeModule2 = this.mModule;
                if (nativeModule2 != null) {
                    return nativeModule2;
                }
                if (this.mIsCreating) {
                    z = false;
                } else {
                    z = true;
                    this.mIsCreating = true;
                }
                if (z) {
                    NativeModule nativeModuleCreate = create();
                    synchronized (this) {
                        this.mIsCreating = false;
                        notifyAll();
                    }
                    return nativeModuleCreate;
                }
                synchronized (this) {
                    while (true) {
                        nativeModule = this.mModule;
                        if (nativeModule != null || !this.mIsCreating) {
                            break;
                        }
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    Assertions.c(nativeModule);
                }
                return nativeModule;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @DoNotStrip
    public String getName() {
        return this.mName;
    }

    public synchronized boolean hasInstance() {
        return this.mModule != null;
    }

    public boolean isCxxModule() {
        return this.mReactModuleInfo.f19024e;
    }

    public boolean isTurboModule() {
        return this.mReactModuleInfo.f19025f;
    }

    public void markInitializable() {
        boolean z;
        NativeModule nativeModule;
        synchronized (this) {
            z = true;
            try {
                this.mInitializable = true;
                if (this.mModule != null) {
                    Assertions.a(!this.mIsInitializing);
                    nativeModule = this.mModule;
                } else {
                    nativeModule = null;
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            doInitialize(nativeModule);
        }
    }

    public ModuleHolder(NativeModule nativeModule) {
        String name = nativeModule.getName();
        this.mName = name;
        this.mReactModuleInfo = new ReactModuleInfo(nativeModule.getName(), nativeModule.getClass().getSimpleName(), nativeModule.canOverrideExistingModule(), true, CxxModuleWrapper.class.isAssignableFrom(nativeModule.getClass()), ReactModuleInfo.Companion.a(nativeModule.getClass()));
        this.mModule = nativeModule;
        DebugOverlayTag tag = ReactDebugOverlayTags.f17192c;
        Object[] args = {name};
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter("NativeModule init: %s", APayConstants.Error.MESSAGE);
        Intrinsics.checkNotNullParameter(args, "args");
    }
}
