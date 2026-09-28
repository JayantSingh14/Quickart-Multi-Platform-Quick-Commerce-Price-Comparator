package com.facebook.react.defaults;

import com.facebook.react.JSEngineResolutionAlgorithm;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.UIManagerProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class DefaultReactNativeHost extends ReactNativeHost {
    @Override // com.facebook.react.ReactNativeHost
    public final JSEngineResolutionAlgorithm c() {
        Boolean boolI = i();
        if (Intrinsics.b(boolI, Boolean.TRUE)) {
            return JSEngineResolutionAlgorithm.f18425b;
        }
        if (Intrinsics.b(boolI, Boolean.FALSE)) {
            return JSEngineResolutionAlgorithm.f18424a;
        }
        if (boolI == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.facebook.react.ReactNativeHost
    public final UIManagerProvider g() {
        return null;
    }

    public Boolean i() {
        return null;
    }
}
