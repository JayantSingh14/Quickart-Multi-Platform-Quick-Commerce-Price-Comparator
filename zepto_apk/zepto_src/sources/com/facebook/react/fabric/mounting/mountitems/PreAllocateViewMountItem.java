package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.uimanager.StateWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class PreAllocateViewMountItem implements MountItem {

    @NotNull
    private final String fabricComponentName;
    private final boolean isLayoutable;

    @Nullable
    private final ReadableMap props;
    private final int reactTag;

    @Nullable
    private final StateWrapper stateWrapper;
    private final int surfaceId;

    public PreAllocateViewMountItem(int i2, int i3, @NotNull String component, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.surfaceId = i2;
        this.reactTag = i3;
        this.props = readableMap;
        this.stateWrapper = stateWrapper;
        this.isLayoutable = z;
        this.fabricComponentName = FabricNameComponentMapping.getFabricComponentName(component);
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(@NotNull MountingManager mountingManager) {
        Intrinsics.checkNotNullParameter(mountingManager, "mountingManager");
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.surfaceId);
        if (surfaceManager != null) {
            surfaceManager.preallocateView(this.fabricComponentName, this.reactTag, this.props, this.stateWrapper, this.isLayoutable);
            return;
        }
        FLog.g(FabricUIManager.TAG, "Skipping View PreAllocation; no SurfaceMountingManager found for [" + this.surfaceId + "]");
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this.surfaceId;
    }

    @NotNull
    public String toString() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder("PreAllocateViewMountItem [");
        sb.append(this.reactTag);
        sb.append("] - component: ");
        sb.append(this.fabricComponentName);
        sb.append(" surfaceId: ");
        sb.append(this.surfaceId);
        sb.append(" isLayoutable: ");
        sb.append(this.isLayoutable);
        if (FabricUIManager.IS_DEVELOPMENT_ENVIRONMENT) {
            sb.append(" props: ");
            ReadableMap readableMap = this.props;
            String str = "<null>";
            if (readableMap == null || (string = readableMap.toString()) == null) {
                string = "<null>";
            }
            sb.append(string);
            sb.append(" state: ");
            StateWrapper stateWrapper = this.stateWrapper;
            if (stateWrapper != null && (string2 = stateWrapper.toString()) != null) {
                str = string2;
            }
            sb.append(str);
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        return string3;
    }
}
