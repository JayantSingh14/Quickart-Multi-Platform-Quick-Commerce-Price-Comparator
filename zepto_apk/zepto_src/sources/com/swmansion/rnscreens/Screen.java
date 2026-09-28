package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewGroupKt$iterator$1;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.swmansion.rnscreens.ScreenContentWrapper;
import com.swmansion.rnscreens.bottomsheet.BottomSheetBehaviorExtKt;
import com.swmansion.rnscreens.bottomsheet.SheetDelegate;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import com.swmansion.rnscreens.ext.FragmentExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Screen extends FabricEnabledViewGroup implements ScreenContentWrapper.OnLayoutCallback {
    public Boolean A;
    public Boolean B;
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public final ThemedReactContext f46936a;

    /* renamed from: b, reason: collision with root package name */
    public ScreenFragmentWrapper f46937b;

    /* renamed from: c, reason: collision with root package name */
    public ScreenContainer f46938c;

    /* renamed from: d, reason: collision with root package name */
    public ActivityState f46939d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46940e;

    /* renamed from: f, reason: collision with root package name */
    public StackPresentation f46941f;

    /* renamed from: g, reason: collision with root package name */
    public ReplaceAnimation f46942g;

    /* renamed from: h, reason: collision with root package name */
    public StackAnimation f46943h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f46944i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f46945j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46946k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f46947l;

    /* renamed from: m, reason: collision with root package name */
    public float f46948m;
    public boolean n;
    public List o;
    public int p;
    public int q;
    public boolean r;
    public float s;
    public boolean t;
    public ScreenFooter u;
    public String v;
    public Boolean w;
    public Boolean x;
    public Integer y;
    public Integer z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class ActivityState {

        /* renamed from: a, reason: collision with root package name */
        public static final ActivityState f46949a;

        /* renamed from: b, reason: collision with root package name */
        public static final ActivityState f46950b;

        /* renamed from: c, reason: collision with root package name */
        public static final ActivityState f46951c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ ActivityState[] f46952d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f46953e;

        static {
            ActivityState activityState = new ActivityState("INACTIVE", 0);
            f46949a = activityState;
            ActivityState activityState2 = new ActivityState("TRANSITIONING_OR_BELOW_TOP", 1);
            f46950b = activityState2;
            ActivityState activityState3 = new ActivityState("ON_TOP", 2);
            f46951c = activityState3;
            ActivityState[] activityStateArr = {activityState, activityState2, activityState3};
            f46952d = activityStateArr;
            f46953e = EnumEntriesKt.a(activityStateArr);
        }

        public static ActivityState valueOf(String str) {
            return (ActivityState) Enum.valueOf(ActivityState.class, str);
        }

        public static ActivityState[] values() {
            return (ActivityState[]) f46952d.clone();
        }
    }

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class ReplaceAnimation {

        /* renamed from: a, reason: collision with root package name */
        public static final ReplaceAnimation f46954a;

        /* renamed from: b, reason: collision with root package name */
        public static final ReplaceAnimation f46955b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ ReplaceAnimation[] f46956c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f46957d;

        static {
            ReplaceAnimation replaceAnimation = new ReplaceAnimation("PUSH", 0);
            f46954a = replaceAnimation;
            ReplaceAnimation replaceAnimation2 = new ReplaceAnimation("POP", 1);
            f46955b = replaceAnimation2;
            ReplaceAnimation[] replaceAnimationArr = {replaceAnimation, replaceAnimation2};
            f46956c = replaceAnimationArr;
            f46957d = EnumEntriesKt.a(replaceAnimationArr);
        }

        public static ReplaceAnimation valueOf(String str) {
            return (ReplaceAnimation) Enum.valueOf(ReplaceAnimation.class, str);
        }

        public static ReplaceAnimation[] values() {
            return (ReplaceAnimation[]) f46956c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class StackAnimation {

        /* renamed from: a, reason: collision with root package name */
        public static final StackAnimation f46958a;

        /* renamed from: b, reason: collision with root package name */
        public static final StackAnimation f46959b;

        /* renamed from: c, reason: collision with root package name */
        public static final StackAnimation f46960c;

        /* renamed from: d, reason: collision with root package name */
        public static final StackAnimation f46961d;

        /* renamed from: e, reason: collision with root package name */
        public static final StackAnimation f46962e;

        /* renamed from: f, reason: collision with root package name */
        public static final StackAnimation f46963f;

        /* renamed from: g, reason: collision with root package name */
        public static final StackAnimation f46964g;

        /* renamed from: h, reason: collision with root package name */
        public static final StackAnimation f46965h;

        /* renamed from: i, reason: collision with root package name */
        public static final StackAnimation f46966i;

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ StackAnimation[] f46967j;

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f46968k;

        static {
            StackAnimation stackAnimation = new StackAnimation("DEFAULT", 0);
            f46958a = stackAnimation;
            StackAnimation stackAnimation2 = new StackAnimation("NONE", 1);
            f46959b = stackAnimation2;
            StackAnimation stackAnimation3 = new StackAnimation("FADE", 2);
            f46960c = stackAnimation3;
            StackAnimation stackAnimation4 = new StackAnimation("SLIDE_FROM_BOTTOM", 3);
            f46961d = stackAnimation4;
            StackAnimation stackAnimation5 = new StackAnimation("SLIDE_FROM_RIGHT", 4);
            f46962e = stackAnimation5;
            StackAnimation stackAnimation6 = new StackAnimation("SLIDE_FROM_LEFT", 5);
            f46963f = stackAnimation6;
            StackAnimation stackAnimation7 = new StackAnimation("FADE_FROM_BOTTOM", 6);
            f46964g = stackAnimation7;
            StackAnimation stackAnimation8 = new StackAnimation("IOS_FROM_RIGHT", 7);
            f46965h = stackAnimation8;
            StackAnimation stackAnimation9 = new StackAnimation("IOS_FROM_LEFT", 8);
            f46966i = stackAnimation9;
            StackAnimation[] stackAnimationArr = {stackAnimation, stackAnimation2, stackAnimation3, stackAnimation4, stackAnimation5, stackAnimation6, stackAnimation7, stackAnimation8, stackAnimation9};
            f46967j = stackAnimationArr;
            f46968k = EnumEntriesKt.a(stackAnimationArr);
        }

        public static StackAnimation valueOf(String str) {
            return (StackAnimation) Enum.valueOf(StackAnimation.class, str);
        }

        public static StackAnimation[] values() {
            return (StackAnimation[]) f46967j.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class StackPresentation {

        /* renamed from: a, reason: collision with root package name */
        public static final StackPresentation f46969a;

        /* renamed from: b, reason: collision with root package name */
        public static final StackPresentation f46970b;

        /* renamed from: c, reason: collision with root package name */
        public static final StackPresentation f46971c;

        /* renamed from: d, reason: collision with root package name */
        public static final StackPresentation f46972d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ StackPresentation[] f46973e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f46974f;

        static {
            StackPresentation stackPresentation = new StackPresentation("PUSH", 0);
            f46969a = stackPresentation;
            StackPresentation stackPresentation2 = new StackPresentation("MODAL", 1);
            f46970b = stackPresentation2;
            StackPresentation stackPresentation3 = new StackPresentation("TRANSPARENT_MODAL", 2);
            f46971c = stackPresentation3;
            StackPresentation stackPresentation4 = new StackPresentation("FORM_SHEET", 3);
            f46972d = stackPresentation4;
            StackPresentation[] stackPresentationArr = {stackPresentation, stackPresentation2, stackPresentation3, stackPresentation4};
            f46973e = stackPresentationArr;
            f46974f = EnumEntriesKt.a(stackPresentationArr);
        }

        public static StackPresentation valueOf(String str) {
            return (StackPresentation) Enum.valueOf(StackPresentation.class, str);
        }

        public static StackPresentation[] values() {
            return (StackPresentation[]) f46973e.clone();
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[StackPresentation.values().length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                StackPresentation stackPresentation = StackPresentation.f46969a;
                iArr[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes4.dex */
    public static final class WindowTraits {

        /* renamed from: a, reason: collision with root package name */
        public static final WindowTraits f46975a;

        /* renamed from: b, reason: collision with root package name */
        public static final WindowTraits f46976b;

        /* renamed from: c, reason: collision with root package name */
        public static final WindowTraits f46977c;

        /* renamed from: d, reason: collision with root package name */
        public static final WindowTraits f46978d;

        /* renamed from: e, reason: collision with root package name */
        public static final WindowTraits f46979e;

        /* renamed from: f, reason: collision with root package name */
        public static final WindowTraits f46980f;

        /* renamed from: g, reason: collision with root package name */
        public static final WindowTraits f46981g;

        /* renamed from: h, reason: collision with root package name */
        public static final WindowTraits f46982h;

        /* renamed from: i, reason: collision with root package name */
        public static final WindowTraits f46983i;

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ WindowTraits[] f46984j;

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f46985k;

        static {
            WindowTraits windowTraits = new WindowTraits("ORIENTATION", 0);
            f46975a = windowTraits;
            WindowTraits windowTraits2 = new WindowTraits("COLOR", 1);
            f46976b = windowTraits2;
            WindowTraits windowTraits3 = new WindowTraits("STYLE", 2);
            f46977c = windowTraits3;
            WindowTraits windowTraits4 = new WindowTraits("TRANSLUCENT", 3);
            f46978d = windowTraits4;
            WindowTraits windowTraits5 = new WindowTraits("HIDDEN", 4);
            f46979e = windowTraits5;
            WindowTraits windowTraits6 = new WindowTraits("ANIMATED", 5);
            f46980f = windowTraits6;
            WindowTraits windowTraits7 = new WindowTraits("NAVIGATION_BAR_COLOR", 6);
            f46981g = windowTraits7;
            WindowTraits windowTraits8 = new WindowTraits("NAVIGATION_BAR_TRANSLUCENT", 7);
            f46982h = windowTraits8;
            WindowTraits windowTraits9 = new WindowTraits("NAVIGATION_BAR_HIDDEN", 8);
            f46983i = windowTraits9;
            WindowTraits[] windowTraitsArr = {windowTraits, windowTraits2, windowTraits3, windowTraits4, windowTraits5, windowTraits6, windowTraits7, windowTraits8, windowTraits9};
            f46984j = windowTraitsArr;
            f46985k = EnumEntriesKt.a(windowTraitsArr);
        }

        public static WindowTraits valueOf(String str) {
            return (WindowTraits) Enum.valueOf(WindowTraits.class, str);
        }

        public static WindowTraits[] values() {
            return (WindowTraits[]) f46984j.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Screen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.f46936a = reactContext;
        this.f46941f = StackPresentation.f46969a;
        this.f46942g = ReplaceAnimation.f46955b;
        this.f46943h = StackAnimation.f46958a;
        this.n = true;
        this.o = CollectionsKt.J(Double.valueOf(1.0d));
        this.p = -1;
        this.r = true;
        this.s = 24.0f;
        setLayoutParams(new WindowManager.LayoutParams(2));
        this.C = true;
    }

    public static void b(ViewGroup viewGroup) {
        Iterator it = ViewGroupKt.a(viewGroup).iterator();
        while (true) {
            ViewGroupKt$iterator$1 viewGroupKt$iterator$1 = (ViewGroupKt$iterator$1) it;
            if (!viewGroupKt$iterator$1.hasNext()) {
                return;
            }
            View view = (View) viewGroupKt$iterator$1.next();
            viewGroup.endViewTransition(view);
            if (view instanceof ScreenStackHeaderConfig) {
                b(((ScreenStackHeaderConfig) view).getToolbar());
            }
            if (view instanceof ViewGroup) {
                b((ViewGroup) view);
            }
        }
    }

    public static boolean c(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && c((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static /* synthetic */ void getNavigationBarColor$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getStatusBarColor$annotations() {
    }

    @Override // com.swmansion.rnscreens.ScreenContentWrapper.OnLayoutCallback
    public final void a(int i2, int i3) {
        BottomSheetBehavior<Screen> sheetBehavior;
        int i4 = i3 - i2;
        if (SheetUtilsKt.c(this)) {
            if (SheetUtilsKt.b(this) && (sheetBehavior = getSheetBehavior()) != null) {
                BottomSheetBehaviorExtKt.a(sheetBehavior, Integer.valueOf(i4));
            }
            this.t = true;
            Intrinsics.checkNotNullParameter(this, "<this>");
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup == null || viewGroup.isInLayout()) {
                return;
            }
            viewGroup.requestLayout();
        }
    }

    public final void d(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if ((viewGroup instanceof SwipeRefreshLayout) && (childAt instanceof ImageView)) {
                    viewGroup.addView(new View(getContext()), i2);
                } else if (childAt != null) {
                    viewGroup.startViewTransition(childAt);
                }
                if (childAt instanceof ScreenStackHeaderConfig) {
                    d(((ScreenStackHeaderConfig) childAt).getToolbar());
                }
                if (childAt instanceof ViewGroup) {
                    d((ViewGroup) childAt);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Nullable
    public final ActivityState getActivityState() {
        return this.f46939d;
    }

    @Nullable
    public final ScreenContainer getContainer() {
        return this.f46938c;
    }

    @Nullable
    public final ScreenContentWrapper getContentWrapper() {
        Object next;
        Iterator it = ViewGroupKt.a(this).iterator();
        while (true) {
            ViewGroupKt$iterator$1 viewGroupKt$iterator$1 = (ViewGroupKt$iterator$1) it;
            if (!viewGroupKt$iterator$1.hasNext()) {
                next = null;
                break;
            }
            next = viewGroupKt$iterator$1.next();
            if (((View) next) instanceof ScreenContentWrapper) {
                break;
            }
        }
        if (next instanceof ScreenContentWrapper) {
            return (ScreenContentWrapper) next;
        }
        return null;
    }

    @Nullable
    public final ScreenFooter getFooter() {
        return this.u;
    }

    @Nullable
    public final Fragment getFragment() {
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.j();
        }
        return null;
    }

    @Nullable
    public final ScreenFragmentWrapper getFragmentWrapper() {
        return this.f46937b;
    }

    @Nullable
    public final ScreenStackHeaderConfig getHeaderConfig() {
        Object next;
        Iterator it = ViewGroupKt.a(this).iterator();
        while (true) {
            ViewGroupKt$iterator$1 viewGroupKt$iterator$1 = (ViewGroupKt$iterator$1) it;
            if (!viewGroupKt$iterator$1.hasNext()) {
                next = null;
                break;
            }
            next = viewGroupKt$iterator$1.next();
            if (((View) next) instanceof ScreenStackHeaderConfig) {
                break;
            }
        }
        if (next instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) next;
        }
        return null;
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.C;
    }

    @Nullable
    public final Integer getNavigationBarColor() {
        return this.z;
    }

    @NotNull
    public final ThemedReactContext getReactContext() {
        return this.f46936a;
    }

    @Nullable
    public final EventDispatcher getReactEventDispatcher() {
        return UIManagerHelper.b(this.f46936a, getId());
    }

    @NotNull
    public final ReplaceAnimation getReplaceAnimation() {
        return this.f46942g;
    }

    @Nullable
    public final Integer getScreenOrientation() {
        return this.f46944i;
    }

    @Nullable
    public final BottomSheetBehavior<Screen> getSheetBehavior() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        CoordinatorLayout.Behavior behaviorA = layoutParams2 != null ? layoutParams2.a() : null;
        if (behaviorA instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behaviorA;
        }
        return null;
    }

    public final boolean getSheetClosesOnTouchOutside() {
        return this.r;
    }

    public final float getSheetCornerRadius() {
        return this.f46948m;
    }

    @NotNull
    public final List<Double> getSheetDetents() {
        return this.o;
    }

    public final float getSheetElevation() {
        return this.s;
    }

    public final boolean getSheetExpandsWhenScrolledToEdge() {
        return this.n;
    }

    public final int getSheetInitialDetentIndex() {
        return this.q;
    }

    public final int getSheetLargestUndimmedDetentIndex() {
        return this.p;
    }

    public final boolean getShouldTriggerPostponedTransitionAfterLayout() {
        return this.t;
    }

    @NotNull
    public final StackAnimation getStackAnimation() {
        return this.f46943h;
    }

    @NotNull
    public final StackPresentation getStackPresentation() {
        return this.f46941f;
    }

    @Nullable
    public final Integer getStatusBarColor() {
        return this.y;
    }

    @Nullable
    public final String getStatusBarStyle() {
        return this.v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Fragment fragment;
        SheetDelegate listener;
        super.onAttachedToWindow();
        if (!SheetUtilsKt.c(this) || (fragment = getFragment()) == null || (listener = FragmentExtKt.a(fragment).G()) == null) {
            return;
        }
        InsetsObserverProxy insetsObserverProxy = InsetsObserverProxy.f46927a;
        Intrinsics.checkNotNullParameter(listener, "listener");
        InsetsObserverProxy.f46928b.add(listener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z && (this.f46938c instanceof ScreenStack) && !SheetUtilsKt.c(this)) {
            ThemedReactContext themedReactContext = this.f46936a;
            themedReactContext.runOnNativeModulesQueueThread(new Screen$updateScreenSizePaper$1(this, i4 - i2, i5 - i3, themedReactContext.getExceptionHandler()));
            Context context = getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            ReactContext reactContext = (ReactContext) context;
            int iD = UIManagerHelper.d(reactContext);
            EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, getId());
            if (eventDispatcherB != null) {
                eventDispatcherB.g(new HeaderHeightChangeEvent(iD, getId(), i3));
            }
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (SheetUtilsKt.c(this)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setActivityState(@NotNull ActivityState activityState) {
        Intrinsics.checkNotNullParameter(activityState, "activityState");
        ActivityState activityState2 = this.f46939d;
        if (activityState == activityState2) {
            return;
        }
        if ((this.f46938c instanceof ScreenStack) && activityState2 != null && activityState.compareTo(activityState2) < 0) {
            throw new IllegalStateException("[RNScreens] activityState can only progress in NativeStack");
        }
        this.f46939d = activityState;
        ScreenContainer screenContainer = this.f46938c;
        if (screenContainer != null) {
            screenContainer.f46993d = true;
            screenContainer.g();
        }
    }

    public final void setBeingRemoved(boolean z) {
        this.f46946k = z;
    }

    public final void setContainer(@Nullable ScreenContainer screenContainer) {
        this.f46938c = screenContainer;
    }

    public final void setFooter(@Nullable ScreenFooter screenFooter) {
        BottomSheetBehavior<Screen> sheetBehavior;
        if (screenFooter == null && this.u != null) {
            BottomSheetBehavior<Screen> behavior = getSheetBehavior();
            if (behavior != null) {
                ScreenFooter screenFooter2 = this.u;
                Intrinsics.c(screenFooter2);
                Intrinsics.checkNotNullParameter(behavior, "behavior");
                if (screenFooter2.f47005f) {
                    behavior.M(screenFooter2.f47006g);
                    screenFooter2.f47005f = false;
                }
            }
        } else if (screenFooter != null && (sheetBehavior = getSheetBehavior()) != null) {
            screenFooter.n(sheetBehavior);
        }
        this.u = screenFooter;
    }

    public final void setFragmentWrapper(@Nullable ScreenFragmentWrapper screenFragmentWrapper) {
        this.f46937b = screenFragmentWrapper;
    }

    public final void setGestureEnabled(boolean z) {
    }

    @Override // android.view.View
    public final void setLayerType(int i2, Paint paint) {
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z) {
        this.C = z;
    }

    public final void setNavigationBarColor(@Nullable Integer num) {
        if (num != null) {
            ScreenWindowTraits.f47047c = true;
        }
        this.z = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.f(this, screenFragmentWrapper.m());
        }
    }

    public final void setNavigationBarHidden(@Nullable Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.f47047c = true;
        }
        this.B = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.g(this, screenFragmentWrapper.m());
        }
    }

    public final void setNavigationBarTranslucent(@Nullable Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.f47047c = true;
        }
        this.A = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.h(this, screenFragmentWrapper.m());
        }
    }

    public final void setReplaceAnimation(@NotNull ReplaceAnimation replaceAnimation) {
        Intrinsics.checkNotNullParameter(replaceAnimation, "<set-?>");
        this.f46942g = replaceAnimation;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setScreenOrientation(@org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L6
            r4 = 0
            r3.f46944i = r4
            return
        L6:
            r0 = 1
            com.swmansion.rnscreens.ScreenWindowTraits.f47045a = r0
            int r1 = r4.hashCode()
            r2 = -1
            switch(r1) {
                case -1894896954: goto L54;
                case 96673: goto L48;
                case 729267099: goto L3d;
                case 1430647483: goto L32;
                case 1651658175: goto L29;
                case 1730732811: goto L1d;
                case 2118770584: goto L12;
                default: goto L11;
            }
        L11:
            goto L5c
        L12:
            java.lang.String r0 = "landscape_right"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L1b
            goto L5c
        L1b:
            r0 = 0
            goto L60
        L1d:
            java.lang.String r0 = "landscape_left"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L26
            goto L5c
        L26:
            r0 = 8
            goto L60
        L29:
            java.lang.String r1 = "portrait_up"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L60
            goto L5c
        L32:
            java.lang.String r0 = "landscape"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L3b
            goto L5c
        L3b:
            r0 = 6
            goto L60
        L3d:
            java.lang.String r0 = "portrait"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L46
            goto L5c
        L46:
            r0 = 7
            goto L60
        L48:
            java.lang.String r0 = "all"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L51
            goto L5c
        L51:
            r0 = 10
            goto L60
        L54:
            java.lang.String r0 = "portrait_down"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L5e
        L5c:
            r0 = r2
            goto L60
        L5e:
            r0 = 9
        L60:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r3.f46944i = r4
            com.swmansion.rnscreens.ScreenFragmentWrapper r4 = r3.f46937b
            if (r4 == 0) goto L8b
            android.app.Activity r4 = r4.m()
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 != 0) goto L76
            goto L8b
        L76:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.f46975a
            com.swmansion.rnscreens.Screen r0 = com.swmansion.rnscreens.ScreenWindowTraits.c(r3, r0)
            if (r0 == 0) goto L88
            java.lang.Integer r0 = r0.getScreenOrientation()
            if (r0 == 0) goto L88
            int r2 = r0.intValue()
        L88:
            r4.setRequestedOrientation(r2)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.Screen.setScreenOrientation(java.lang.String):void");
    }

    public final void setSheetClosesOnTouchOutside(boolean z) {
        this.r = z;
    }

    public final void setSheetCornerRadius(float f2) {
        if (this.f46948m == f2) {
            return;
        }
        this.f46948m = f2;
        this.f46947l = true;
    }

    public final void setSheetDetents(@NotNull List<Double> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.o = list;
    }

    public final void setSheetElevation(float f2) {
        this.s = f2;
    }

    public final void setSheetExpandsWhenScrolledToEdge(boolean z) {
        this.n = z;
    }

    public final void setSheetGrabberVisible(boolean z) {
    }

    public final void setSheetInitialDetentIndex(int i2) {
        this.q = i2;
    }

    public final void setSheetLargestUndimmedDetentIndex(int i2) {
        this.p = i2;
    }

    public final void setShouldTriggerPostponedTransitionAfterLayout(boolean z) {
        this.t = z;
    }

    public final void setStackAnimation(@NotNull StackAnimation stackAnimation) {
        Intrinsics.checkNotNullParameter(stackAnimation, "<set-?>");
        this.f46943h = stackAnimation;
    }

    public final void setStackPresentation(@NotNull StackPresentation stackPresentation) {
        Intrinsics.checkNotNullParameter(stackPresentation, "<set-?>");
        this.f46941f = stackPresentation;
    }

    public final void setStatusBarAnimated(@Nullable Boolean bool) {
        this.f46945j = bool;
    }

    public final void setStatusBarColor(@Nullable Integer num) {
        if (num != null) {
            ScreenWindowTraits.f47046b = true;
        }
        this.y = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.d(this, screenFragmentWrapper.m(), screenFragmentWrapper.r());
        }
    }

    public final void setStatusBarHidden(@Nullable Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.f47046b = true;
        }
        this.w = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.e(this, screenFragmentWrapper.m());
        }
    }

    public final void setStatusBarStyle(@Nullable String str) {
        if (str != null) {
            ScreenWindowTraits.f47046b = true;
        }
        this.v = str;
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.i(this, screenFragmentWrapper.m(), screenFragmentWrapper.r());
        }
    }

    public final void setStatusBarTranslucent(@Nullable Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.f47046b = true;
        }
        this.x = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.f46937b;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.j(this, screenFragmentWrapper.m(), screenFragmentWrapper.r());
        }
    }

    public final void setTransitioning(boolean z) {
        if (this.f46940e == z) {
            return;
        }
        this.f46940e = z;
        boolean zC = c(this);
        if (!zC || getLayerType() == 2) {
            super.setLayerType((!z || zC) ? 0 : 2, null);
        }
    }
}
