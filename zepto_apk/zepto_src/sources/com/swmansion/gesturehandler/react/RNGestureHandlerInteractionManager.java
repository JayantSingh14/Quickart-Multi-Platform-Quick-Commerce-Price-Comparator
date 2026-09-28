package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerInteractionController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RNGestureHandlerInteractionManager implements GestureHandlerInteractionController {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f46820a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f46821b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f46822c = new SparseArray();

    @Metadata
    public static final class Companion {
    }

    public static int[] b(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        Intrinsics.c(array);
        int size = array.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = array.getInt(i2);
        }
        return iArr;
    }

    public final void a(GestureHandler handler, ReadableMap config) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(config, "config");
        handler.C = this;
        if (config.hasKey("waitFor")) {
            this.f46820a.put(handler.f46717d, b(config, "waitFor"));
        }
        if (config.hasKey("simultaneousHandlers")) {
            this.f46821b.put(handler.f46717d, b(config, "simultaneousHandlers"));
        }
        if (config.hasKey("blocksHandlers")) {
            this.f46822c.put(handler.f46717d, b(config, "blocksHandlers"));
        }
    }
}
