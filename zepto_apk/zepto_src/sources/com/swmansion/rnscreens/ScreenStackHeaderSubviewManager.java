package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerInterface;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = ScreenStackHeaderSubviewManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ScreenStackHeaderSubviewManager extends ViewGroupManager<ScreenStackHeaderSubview> implements RNSScreenStackHeaderSubviewManagerInterface<ScreenStackHeaderSubview> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNSScreenStackHeaderSubview";

    @NotNull
    private final ViewManagerDelegate<ScreenStackHeaderSubview> delegate = new RNSScreenStackHeaderSubviewManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ScreenStackHeaderSubview> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ScreenStackHeaderSubview createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ScreenStackHeaderSubview screenStackHeaderSubview = new ScreenStackHeaderSubview(context);
        screenStackHeaderSubview.f47037c = ScreenStackHeaderSubview.Type.f47040c;
        return screenStackHeaderSubview;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderSubviewManagerInterface
    @ReactProp(name = "type")
    public void setType(@NotNull ScreenStackHeaderSubview view, @Nullable String str) {
        ScreenStackHeaderSubview.Type type;
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        type = ScreenStackHeaderSubview.Type.f47039b;
                        view.setType(type);
                        return;
                    }
                    break;
                case 3015911:
                    if (str.equals("back")) {
                        type = ScreenStackHeaderSubview.Type.f47041d;
                        view.setType(type);
                        return;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        type = ScreenStackHeaderSubview.Type.f47038a;
                        view.setType(type);
                        return;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        type = ScreenStackHeaderSubview.Type.f47040c;
                        view.setType(type);
                        return;
                    }
                    break;
                case 1778179403:
                    if (str.equals("searchBar")) {
                        type = ScreenStackHeaderSubview.Type.f47042e;
                        view.setType(type);
                        return;
                    }
                    break;
            }
        }
        throw new JSApplicationIllegalArgumentException(android.support.v4.media.b.C("Unknown type ", str));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Object updateState(@NotNull ScreenStackHeaderSubview view, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        return super.updateState((ScreenStackHeaderSubviewManager) view, reactStylesDiffMap, stateWrapper);
    }
}
