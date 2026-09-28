package com.facebook.react.internal.turbomodule.core;

import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Collections;
import java.util.List;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class TurboModuleManagerDelegate {

    @DoNotStrip
    private final HybridData mHybridData;

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    public TurboModuleManagerDelegate() {
        maybeLoadOtherSoLibraries();
        this.mHybridData = initHybrid();
    }

    public List<String> getEagerInitModuleNames() {
        return Collections.EMPTY_LIST;
    }

    @Nullable
    public NativeModule getLegacyModule(String str) {
        return null;
    }

    @Nullable
    public abstract TurboModule getModule(String str);

    public abstract HybridData initHybrid();

    public synchronized void maybeLoadOtherSoLibraries() {
    }

    public boolean unstable_isLegacyModuleRegistered(String str) {
        return false;
    }

    public abstract boolean unstable_isModuleRegistered(String str);

    public boolean unstable_shouldEnableLegacyModuleInterop() {
        return false;
    }

    public TurboModuleManagerDelegate(HybridData hybridData) {
        maybeLoadOtherSoLibraries();
        this.mHybridData = hybridData;
    }
}
