package com.facebook.react.views.text.frescosupport;

import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = FrescoBasedReactTextInlineImageViewManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class FrescoBasedReactTextInlineImageViewManager extends BaseViewManager<View, FrescoBasedReactTextInlineImageShadowNode> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RCTTextInlineImage";

    @Nullable
    private final Object callerContext;

    @Nullable
    private final AbstractDraweeControllerBuilder<?, ?, ?, ?> draweeControllerBuilder;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public FrescoBasedReactTextInlineImageViewManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public View createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Class<FrescoBasedReactTextInlineImageShadowNode> getShadowNodeClass() {
        return FrescoBasedReactTextInlineImageShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(@NotNull View root, @NotNull Object extraData) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    public FrescoBasedReactTextInlineImageViewManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder) {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(abstractDraweeControllerBuilder, defaultConstructorMarker, 2, defaultConstructorMarker);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public FrescoBasedReactTextInlineImageShadowNode createShadowNodeInstance() {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.draweeControllerBuilder;
        if (abstractDraweeControllerBuilder == null) {
            abstractDraweeControllerBuilder = Fresco.f17198a.get();
        }
        return new FrescoBasedReactTextInlineImageShadowNode(abstractDraweeControllerBuilder, this.callerContext);
    }

    public /* synthetic */ FrescoBasedReactTextInlineImageViewManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : abstractDraweeControllerBuilder, (i2 & 2) != 0 ? null : obj);
    }

    @JvmOverloads
    public FrescoBasedReactTextInlineImageViewManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder, @Nullable Object obj) {
        this.draweeControllerBuilder = abstractDraweeControllerBuilder;
        this.callerContext = obj;
    }
}
