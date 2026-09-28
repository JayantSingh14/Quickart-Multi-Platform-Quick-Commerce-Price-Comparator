package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.StateWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class MountItemFactory {

    @NotNull
    public static final MountItemFactory INSTANCE = new MountItemFactory();

    private MountItemFactory() {
    }

    @JvmStatic
    @NotNull
    public static final MountItem createDestroyViewMountItem(int i2, int i3) {
        return new DestroyUnmountedViewMountItem(i2, i3);
    }

    @JvmStatic
    @NotNull
    public static final DispatchCommandMountItem createDispatchCommandMountItem(int i2, int i3, int i4, @Nullable ReadableArray readableArray) {
        return new DispatchIntCommandMountItem(i2, i3, i4, readableArray);
    }

    @JvmStatic
    @NotNull
    public static final MountItem createIntBufferBatchMountItem(int i2, @NotNull int[] intBuf, @NotNull Object[] objBuf, int i3) {
        Intrinsics.checkNotNullParameter(intBuf, "intBuf");
        Intrinsics.checkNotNullParameter(objBuf, "objBuf");
        return new IntBufferBatchMountItem(i2, intBuf, objBuf, i3);
    }

    @JvmStatic
    @NotNull
    public static final MountItem createPreAllocateViewMountItem(int i2, int i3, @NotNull String component, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(component, "component");
        return new PreAllocateViewMountItem(i2, i3, component, readableMap, stateWrapper, z);
    }

    @JvmStatic
    @NotNull
    public static final MountItem createSendAccessibilityEventMountItem(int i2, int i3, int i4) {
        return new SendAccessibilityEventMountItem(i2, i3, i4);
    }

    @JvmStatic
    @NotNull
    public static final DispatchCommandMountItem createDispatchCommandMountItem(int i2, int i3, @NotNull String commandId, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        return new DispatchStringCommandMountItem(i2, i3, commandId, readableArray);
    }
}
