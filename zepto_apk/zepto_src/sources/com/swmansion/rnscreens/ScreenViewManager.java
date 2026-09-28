package com.swmansion.rnscreens;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.swmansion.rnscreens.Screen;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@ReactModule(name = ScreenViewManager.REACT_CLASS)
@SourceDebugExtension
/* loaded from: classes.dex */
public class ScreenViewManager extends ViewGroupManager<Screen> implements RNSScreenManagerInterface<Screen> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNSScreen";

    @NotNull
    private final ViewManagerDelegate<Screen> delegate = new RNSScreenManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<Screen> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.i(new Pair("topDismissed", MapBuilder.c("registrationName", "onDismissed")), new Pair("topWillAppear", MapBuilder.c("registrationName", "onWillAppear")), new Pair("topAppear", MapBuilder.c("registrationName", "onAppear")), new Pair("topWillDisappear", MapBuilder.c("registrationName", "onWillDisappear")), new Pair("topDisappear", MapBuilder.c("registrationName", "onDisappear")), new Pair("topHeaderHeightChange", MapBuilder.c("registrationName", "onHeaderHeightChange")), new Pair("topHeaderBackButtonClicked", MapBuilder.c("registrationName", "onHeaderBackButtonClicked")), new Pair("topTransitionProgress", MapBuilder.c("registrationName", "onTransitionProgress")), new Pair("topSheetDetentChanged", MapBuilder.c("registrationName", "onSheetDetentChanged")));
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

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setCustomAnimationOnSwipe(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeEnabled(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeShadowEnabled(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setGestureResponseDistance(@Nullable Screen screen, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHideKeyboardOnSwipe(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHomeIndicatorHidden(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setPreventNativeDismiss(@Nullable Screen screen, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSwipeDirection(@Nullable Screen screen, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setTransitionDuration(@Nullable Screen screen, int i2) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Screen createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new Screen(reactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull Screen view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((ScreenViewManager) view);
        if (view.f46947l) {
            view.f46947l = false;
            if (view.f46941f != Screen.StackPresentation.f46972d || view.getBackground() == null) {
                return;
            }
            Drawable background = view.getBackground();
            MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
            if (materialShapeDrawable != null) {
                float fA = PixelUtil.a(view.f46948m);
                ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
                builder.f(fA);
                builder.i(fA);
                materialShapeDrawable.setShapeAppearanceModel(builder.a());
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(@NotNull Screen parent, @NotNull View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        super.removeView((ScreenViewManager) parent, view);
        if (view instanceof ScreenFooter) {
            parent.setFooter(null);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setActivityState(@NotNull Screen view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        setActivityState(view, (int) f2);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "gestureEnabled")
    public void setGestureEnabled(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setGestureEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "nativeBackButtonDismissalEnabled")
    public void setNativeBackButtonDismissalEnabled(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNativeBackButtonDismissalEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated
    @ReactProp(customType = "Color", name = "navigationBarColor")
    public void setNavigationBarColor(@NotNull Screen view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "navigationBarHidden")
    public void setNavigationBarHidden(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarHidden(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated
    @ReactProp(name = "navigationBarTranslucent")
    public void setNavigationBarTranslucent(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarTranslucent(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "replaceAnimation")
    public void setReplaceAnimation(@NotNull Screen view, @Nullable String str) {
        Screen.ReplaceAnimation replaceAnimation;
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null || str.equals("pop")) {
            replaceAnimation = Screen.ReplaceAnimation.f46955b;
        } else {
            if (!str.equals("push")) {
                throw new JSApplicationIllegalArgumentException("Unknown replace animation type ".concat(str));
            }
            replaceAnimation = Screen.ReplaceAnimation.f46954a;
        }
        view.setReplaceAnimation(replaceAnimation);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "screenOrientation")
    public void setScreenOrientation(@NotNull Screen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScreenOrientation(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetAllowedDetents")
    public void setSheetAllowedDetents(@NotNull Screen view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getSheetDetents().clear();
        if (readableArray == null || readableArray.size() == 0) {
            view.getSheetDetents().add(Double.valueOf(1.0d));
            return;
        }
        IntProgression.Companion companion = IntProgression.f53837d;
        int size = readableArray.size() - 1;
        companion.getClass();
        SequencesKt.p(SequencesKt.m(CollectionsKt.n(new IntProgression(0, size, 1)), new coil3.disk.a(readableArray, 2)), view.getSheetDetents());
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetCornerRadius")
    public void setSheetCornerRadius(@NotNull Screen view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetCornerRadius(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetElevation")
    public void setSheetElevation(@Nullable Screen screen, int i2) {
        if (screen != null) {
            screen.setSheetElevation(i2);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetExpandsWhenScrolledToEdge")
    public void setSheetExpandsWhenScrolledToEdge(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetExpandsWhenScrolledToEdge(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetGrabberVisible")
    public void setSheetGrabberVisible(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetGrabberVisible(z);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetInitialDetent")
    public void setSheetInitialDetent(@NotNull Screen view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetInitialDetentIndex(i2);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetLargestUndimmedDetent")
    public void setSheetLargestUndimmedDetent(@NotNull Screen view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (-1 > i2 || i2 >= 3) {
            throw new IllegalStateException("[RNScreens] sheetLargestUndimmedDetent on Android supports values between -1 and 2");
        }
        view.setSheetLargestUndimmedDetentIndex(i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r3.equals(in.juspay.hypersdk.analytics.LogConstants.DEFAULT_CHANNEL) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r3.equals("flip") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
    
        if (r3.equals("simple_push") != false) goto L42;
     */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackAnimation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setStackAnimation(@org.jetbrains.annotations.NotNull com.swmansion.rnscreens.Screen r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L91
            int r0 = r3.hashCode()
            switch(r0) {
                case -1418955385: goto L7c;
                case -1198710326: goto L71;
                case -427095442: goto L66;
                case -349395819: goto L5b;
                case 3135100: goto L50;
                case 3145837: goto L47;
                case 3387192: goto L3c;
                case 182437661: goto L31;
                case 1500346553: goto L26;
                case 1544803905: goto L1c;
                case 1601504978: goto L10;
                default: goto Le;
            }
        Le:
            goto L85
        L10:
            java.lang.String r0 = "slide_from_bottom"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46961d
            goto L93
        L1c:
            java.lang.String r0 = "default"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            goto L91
        L26:
            java.lang.String r0 = "ios_from_right"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46965h
            goto L93
        L31:
            java.lang.String r0 = "fade_from_bottom"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46964g
            goto L93
        L3c:
            java.lang.String r0 = "none"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46959b
            goto L93
        L47:
            java.lang.String r0 = "flip"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            goto L91
        L50:
            java.lang.String r0 = "fade"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46960c
            goto L93
        L5b:
            java.lang.String r0 = "slide_from_right"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46962e
            goto L93
        L66:
            java.lang.String r0 = "slide_from_left"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46963f
            goto L93
        L71:
            java.lang.String r0 = "ios_from_left"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46966i
            goto L93
        L7c:
            java.lang.String r0 = "simple_push"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L85
            goto L91
        L85:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r0 = "Unknown animation type "
            java.lang.String r3 = r0.concat(r3)
            r2.<init>(r3)
            throw r2
        L91:
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.f46958a
        L93:
            r2.setStackAnimation(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3.equals("fullScreenModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r3.equals("containedTransparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r3.equals("pageSheet") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r3.equals("containedModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (r3.equals("modal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r3 = com.swmansion.rnscreens.Screen.StackPresentation.f46970b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        if (r3.equals("transparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        r3 = com.swmansion.rnscreens.Screen.StackPresentation.f46971c;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackPresentation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setStackPresentation(@org.jetbrains.annotations.NotNull com.swmansion.rnscreens.Screen r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L62
            int r0 = r3.hashCode()
            switch(r0) {
                case -76271493: goto L54;
                case 3452698: goto L49;
                case 104069805: goto L3e;
                case 438078970: goto L35;
                case 872434704: goto L2c;
                case 955284238: goto L23;
                case 1171936146: goto L1a;
                case 1798290171: goto Lf;
                default: goto Le;
            }
        Le:
            goto L62
        Lf:
            java.lang.String r0 = "formSheet"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.f46972d
            goto L5e
        L1a:
            java.lang.String r0 = "fullScreenModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L46
        L23:
            java.lang.String r0 = "containedTransparentModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L5c
        L2c:
            java.lang.String r0 = "pageSheet"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L46
        L35:
            java.lang.String r0 = "containedModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            goto L46
        L3e:
            java.lang.String r0 = "modal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
        L46:
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.f46970b
            goto L5e
        L49:
            java.lang.String r0 = "push"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.f46969a
            goto L5e
        L54:
            java.lang.String r0 = "transparentModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L62
        L5c:
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.f46971c
        L5e:
            r2.setStackPresentation(r3)
            return
        L62:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r0 = "Unknown presentation type "
            java.lang.String r3 = android.support.v4.media.b.C(r0, r3)
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarAnimation")
    public void setStatusBarAnimation(@NotNull Screen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarAnimated(Boolean.valueOf((str == null || "none".equals(str)) ? false : true));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated
    @ReactProp(customType = "Color", name = "statusBarColor")
    public void setStatusBarColor(@NotNull Screen view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarHidden")
    public void setStatusBarHidden(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarHidden(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarStyle")
    public void setStatusBarStyle(@NotNull Screen view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarStyle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated
    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(@NotNull Screen view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Object updateState(@NotNull Screen view, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        return super.updateState((ScreenViewManager) view, reactStylesDiffMap, stateWrapper);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull Screen parent, @NotNull View child, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof ScreenContentWrapper) {
            ScreenContentWrapper wrapper = (ScreenContentWrapper) child;
            parent.getClass();
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            wrapper.setDelegate$react_native_screens_release(parent);
        } else if (child instanceof ScreenFooter) {
            parent.setFooter((ScreenFooter) child);
        }
        super.addView((ScreenViewManager) parent, child, i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull Screen parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getChildAt(i2) instanceof ScreenFooter) {
            parent.setFooter(null);
        }
        super.removeViewAt((ScreenViewManager) parent, i2);
    }

    @ReactProp(name = "activityState")
    public final void setActivityState(@NotNull Screen view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (i2 == -1) {
            return;
        }
        if (i2 == 0) {
            view.setActivityState(Screen.ActivityState.f46949a);
        } else if (i2 == 1) {
            view.setActivityState(Screen.ActivityState.f46950b);
        } else {
            if (i2 != 2) {
                return;
            }
            view.setActivityState(Screen.ActivityState.f46951c);
        }
    }
}
