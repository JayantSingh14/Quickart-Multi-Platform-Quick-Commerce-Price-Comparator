package com.facebook.react.fabric.internal.interop;

import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.fabric.interop.UIBlock;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InteropUIBlockListener implements UIManagerListener {

    @NotNull
    private final List<UIBlock> beforeUIBlocks = new ArrayList();

    @NotNull
    private final List<UIBlock> afterUIBlocks = new ArrayList();

    public final synchronized void addUIBlock(@NotNull UIBlock block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.afterUIBlocks.add(block);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        didMountItems(uiManager);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        if (this.afterUIBlocks.isEmpty()) {
            return;
        }
        for (UIBlock uIBlock : this.afterUIBlocks) {
            if (uiManager instanceof UIBlockViewResolver) {
                uIBlock.execute((UIBlockViewResolver) uiManager);
            }
        }
        this.afterUIBlocks.clear();
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @NotNull
    public final List<UIBlock> getAfterUIBlocks$ReactAndroid_release() {
        return this.afterUIBlocks;
    }

    @NotNull
    public final List<UIBlock> getBeforeUIBlocks$ReactAndroid_release() {
        return this.beforeUIBlocks;
    }

    public final synchronized void prependUIBlock(@NotNull UIBlock block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.beforeUIBlocks.add(block);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        willMountItems(uiManager);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        if (this.beforeUIBlocks.isEmpty()) {
            return;
        }
        for (UIBlock uIBlock : this.beforeUIBlocks) {
            if (uiManager instanceof UIBlockViewResolver) {
                uIBlock.execute((UIBlockViewResolver) uiManager);
            }
        }
        this.beforeUIBlocks.clear();
    }
}
