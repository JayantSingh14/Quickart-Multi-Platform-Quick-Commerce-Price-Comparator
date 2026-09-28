package com.facebook.react;

import com.facebook.react.bridge.BridgeReactContext;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class NativeModuleRegistryBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final BridgeReactContext f18432a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f18433b;

    public NativeModuleRegistryBuilder(BridgeReactContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.f18432a = reactApplicationContext;
        this.f18433b = new HashMap();
    }
}
