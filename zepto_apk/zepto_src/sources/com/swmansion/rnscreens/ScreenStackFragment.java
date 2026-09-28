package com.swmansion.rnscreens;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.brentvatne.common.react.r;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import com.swmansion.rnscreens.bottomsheet.DimmingView;
import com.swmansion.rnscreens.bottomsheet.DimmingViewManager;
import com.swmansion.rnscreens.bottomsheet.SheetDelegate;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.ScreenAnimationDelegate;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenEventEmitter;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout;
import com.swmansion.rnscreens.transition.ExternalBoundaryValuesEvaluator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ScreenStackFragment extends ScreenFragment implements ScreenStackFragmentWrapper {
    public static final /* synthetic */ int N0 = 0;
    public AppBarLayout D0;
    public CustomToolbar E0;
    public boolean F0;
    public boolean G0;
    public View H0;
    public CustomSearchView I0;
    public com.brentvatne.react.c J0;
    public ScreensCoordinatorLayout K0;
    public DimmingViewManager L0;
    public SheetDelegate M0;

    @Metadata
    /* renamed from: com.swmansion.rnscreens.ScreenStackFragment$onCreateView$5, reason: invalid class name */
    public final class AnonymousClass5 extends WindowInsetsAnimationCompat.Callback {
        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public final WindowInsetsCompat onProgress(WindowInsetsCompat insets, List runningAnimations) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
            return insets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenStackFragment(Screen screenView) {
        super(screenView);
        Intrinsics.checkNotNullParameter(screenView, "screenView");
    }

    public final boolean C() {
        ScreenContainer container = k().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
        }
        if (!Intrinsics.b(((ScreenStack) container).getRootScreen(), k())) {
            return true;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof ScreenStackFragment) {
            return ((ScreenStackFragment) parentFragment).C();
        }
        return false;
    }

    public final void D() {
        ScreenContainer container = k().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
        }
        ScreenStack screenStack = (ScreenStack) container;
        screenStack.getClass();
        Intrinsics.checkNotNullParameter(this, "screenFragment");
        screenStack.f47016j.add(this);
        screenStack.f46993d = true;
        screenStack.g();
    }

    public final void E() {
        if (isRemoving() && isDetached()) {
            return;
        }
        ThemedReactContext reactContext = k().getReactContext();
        int iD = UIManagerHelper.d(reactContext);
        EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, k().getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new ScreenDismissedEvent(iD, k().getId()));
        }
    }

    public final CustomSearchView F() {
        return this.I0;
    }

    public final SheetDelegate G() {
        return this.M0;
    }

    public final void H() {
        CustomToolbar customToolbar;
        AppBarLayout appBarLayout = this.D0;
        if (appBarLayout != null && (customToolbar = this.E0) != null && customToolbar.getParent() == appBarLayout) {
            appBarLayout.removeView(customToolbar);
        }
        this.E0 = null;
    }

    public final DimmingViewManager I(boolean z) {
        DimmingViewManager dimmingViewManager = this.L0;
        if (dimmingViewManager == null || z) {
            if (dimmingViewManager != null) {
                BottomSheetBehavior<Screen> sheetBehavior = k().getSheetBehavior();
                BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = dimmingViewManager.f47091c;
                if (bottomSheetCallback != null && sheetBehavior != null) {
                    sheetBehavior.M(bottomSheetCallback);
                }
            }
            this.L0 = new DimmingViewManager(k().getReactContext(), k());
        }
        DimmingViewManager dimmingViewManager2 = this.L0;
        Intrinsics.c(dimmingViewManager2);
        return dimmingViewManager2;
    }

    public final void J(com.brentvatne.react.c cVar) {
        this.J0 = cVar;
    }

    public final void K(CustomToolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        AppBarLayout appBarLayout = this.D0;
        if (appBarLayout != null) {
            appBarLayout.addView(toolbar);
        }
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams();
        layoutParams.f39866a = 0;
        toolbar.setLayoutParams(layoutParams);
        this.E0 = toolbar;
    }

    public final void L(boolean z) {
        if (this.F0 != z) {
            AppBarLayout appBarLayout = this.D0;
            if (appBarLayout != null) {
                appBarLayout.setElevation(z ? 0.0f : PixelUtil.b(4.0f));
            }
            AppBarLayout appBarLayout2 = this.D0;
            if (appBarLayout2 != null) {
                appBarLayout2.setStateListAnimator(null);
            }
            this.F0 = z;
        }
    }

    public final void M(boolean z) {
        if (this.G0 != z) {
            ViewGroup.LayoutParams layoutParams = k().getLayoutParams();
            Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((CoordinatorLayout.LayoutParams) layoutParams).c(z ? null : new AppBarLayout.ScrollingViewBehavior());
            this.G0 = z;
        }
    }

    public final void N(Menu menu) {
        menu.clear();
        ScreenStackHeaderConfig headerConfig = k().getHeaderConfig();
        int configSubviewsCount = headerConfig != null ? headerConfig.getConfigSubviewsCount() : 0;
        if (headerConfig == null || configSubviewsCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < configSubviewsCount; i2++) {
            Object obj = headerConfig.f47026e.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            if (((ScreenStackHeaderSubview) obj).getType() == ScreenStackHeaderSubview.Type.f47042e) {
                Context context = getContext();
                if (this.I0 == null && context != null) {
                    CustomSearchView customSearchView = new CustomSearchView(context, this);
                    this.I0 = customSearchView;
                    com.brentvatne.react.c cVar = this.J0;
                    if (cVar != null) {
                        cVar.invoke(customSearchView);
                    }
                }
                MenuItem menuItemAdd = menu.add("");
                menuItemAdd.setShowAsAction(2);
                menuItemAdd.setActionView(this.I0);
                return;
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public final boolean l() {
        int iOrdinal = k().f46941f.ordinal();
        return iOrdinal == 2 || iOrdinal == 3;
    }

    @Override // androidx.fragment.app.Fragment
    public final Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final Animator onCreateAnimator(int i2, boolean z, int i3) {
        final int i4 = 1;
        final int i5 = 0;
        if (!SheetUtilsKt.c(k())) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        final DimmingViewManager dimmingViewManagerI = I(false);
        if (z) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, dimmingViewManagerI.f47090b);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator anim) {
                    switch (i5) {
                        case 0:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue = anim.getAnimatedValue();
                            Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
                            if (f2 != null) {
                                dimmingViewManagerI.f47089a.setAlpha(f2.floatValue());
                                break;
                            }
                            break;
                        default:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue2 = anim.getAnimatedValue();
                            Float f3 = animatedValue2 instanceof Float ? (Float) animatedValue2 : null;
                            if (f3 != null) {
                                dimmingViewManagerI.f47089a.setAlpha(f3.floatValue());
                                break;
                            }
                            break;
                    }
                }
            });
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ExternalBoundaryValuesEvaluator(new com.brentvatne.react.c(this, 4), new r(14)), Float.valueOf(k().getHeight()), Float.valueOf(0.0f));
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.swmansion.rnscreens.d

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ScreenStackFragment f47114b;

                {
                    this.f47114b = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator anim) {
                    switch (i5) {
                        case 0:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue = anim.getAnimatedValue();
                            Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
                            if (f2 != null) {
                                this.f47114b.k().setTranslationY(f2.floatValue());
                                break;
                            }
                            break;
                        default:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue2 = anim.getAnimatedValue();
                            Float f3 = animatedValue2 instanceof Float ? (Float) animatedValue2 : null;
                            if (f3 != null) {
                                this.f47114b.k().setTranslationY(f3.floatValue());
                                break;
                            }
                            break;
                    }
                }
            });
            AnimatorSet.Builder builderPlay = animatorSet.play(valueAnimatorOfObject);
            Screen screen = k();
            int sheetInitialDetentIndex = k().getSheetInitialDetentIndex();
            Intrinsics.checkNotNullParameter(screen, "screen");
            AnimatorSet.Builder builder = sheetInitialDetentIndex > screen.getSheetLargestUndimmedDetentIndex() ? builderPlay : null;
            if (builder != null) {
                builder.with(valueAnimatorOfFloat);
            }
        } else {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(dimmingViewManagerI.f47089a.getAlpha(), 0.0f);
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator anim) {
                    switch (i4) {
                        case 0:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue = anim.getAnimatedValue();
                            Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
                            if (f2 != null) {
                                dimmingViewManagerI.f47089a.setAlpha(f2.floatValue());
                                break;
                            }
                            break;
                        default:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue2 = anim.getAnimatedValue();
                            Float f3 = animatedValue2 instanceof Float ? (Float) animatedValue2 : null;
                            if (f3 != null) {
                                dimmingViewManagerI.f47089a.setAlpha(f3.floatValue());
                                break;
                            }
                            break;
                    }
                }
            });
            if (this.K0 == null) {
                Intrinsics.h("coordinatorLayout");
                throw null;
            }
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, r3.getBottom() - k().getTop());
            valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.swmansion.rnscreens.d

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ScreenStackFragment f47114b;

                {
                    this.f47114b = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator anim) {
                    switch (i4) {
                        case 0:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue = anim.getAnimatedValue();
                            Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
                            if (f2 != null) {
                                this.f47114b.k().setTranslationY(f2.floatValue());
                                break;
                            }
                            break;
                        default:
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            Object animatedValue2 = anim.getAnimatedValue();
                            Float f3 = animatedValue2 instanceof Float ? (Float) animatedValue2 : null;
                            if (f3 != null) {
                                this.f47114b.k().setTranslationY(f3.floatValue());
                                break;
                            }
                            break;
                    }
                }
            });
            animatorSet.play(valueAnimatorOfFloat2).with(valueAnimatorOfFloat3);
        }
        animatorSet.addListener(new ScreenAnimationDelegate(this, new ScreenEventEmitter(k()), z ? ScreenAnimationDelegate.AnimationType.f47120a : ScreenAnimationDelegate.AnimationType.f47121b));
        return animatorSet;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        N(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Integer numValueOf;
        ColorStateList colorStateList;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2;
        AppBarLayout appBarLayout3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.K0 = new ScreensCoordinatorLayout(contextRequireContext, this);
        Screen screenK = k();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.c(SheetUtilsKt.c(k()) ? new BottomSheetBehavior() : this.G0 ? null : new AppBarLayout.ScrollingViewBehavior());
        screenK.setLayoutParams(layoutParams);
        ScreensCoordinatorLayout screensCoordinatorLayout = this.K0;
        if (screensCoordinatorLayout == null) {
            Intrinsics.h("coordinatorLayout");
            throw null;
        }
        Screen screenK2 = k();
        ViewExtKt.a(screenK2);
        screensCoordinatorLayout.addView(screenK2);
        if (SheetUtilsKt.c(k())) {
            k().setClipToOutline(true);
            Screen screenK3 = k();
            float fB = PixelUtil.b(screenK3.getSheetCornerRadius());
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
            builder.f(fB);
            builder.i(fB);
            ShapeAppearanceModel shapeAppearanceModelA = builder.a();
            Intrinsics.checkNotNullExpressionValue(shapeAppearanceModelA, "build(...)");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModelA);
            Drawable background = screenK3.getBackground();
            ColorDrawable colorDrawable = background instanceof ColorDrawable ? (ColorDrawable) background : null;
            if (colorDrawable != null) {
                numValueOf = Integer.valueOf(colorDrawable.getColor());
            } else {
                Drawable background2 = screenK3.getBackground();
                MaterialShapeDrawable materialShapeDrawable2 = background2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background2 : null;
                numValueOf = (materialShapeDrawable2 == null || (colorStateList = materialShapeDrawable2.f40974a.f40993e) == null) ? null : Integer.valueOf(colorStateList.getDefaultColor());
            }
            if (numValueOf == null) {
                ScreenContentWrapper contentWrapper = screenK3.getContentWrapper();
                if (contentWrapper == null) {
                    numValueOf = null;
                } else {
                    Intrinsics.checkNotNullParameter(contentWrapper, "<this>");
                    numValueOf = BackgroundStyleApplicator.g(contentWrapper);
                }
            }
            materialShapeDrawable.setTint(numValueOf != null ? numValueOf.intValue() : 0);
            screenK3.setBackground(materialShapeDrawable);
            k().setElevation(k().getSheetElevation());
            if (this.M0 == null) {
                this.M0 = new SheetDelegate(k());
            }
            SheetDelegate sheetDelegate = this.M0;
            Intrinsics.c(sheetDelegate);
            BottomSheetBehavior<Screen> sheetBehavior = k().getSheetBehavior();
            Intrinsics.c(sheetBehavior);
            SheetDelegate.c(sheetDelegate, sheetBehavior, null, 6);
            DimmingViewManager dimmingViewManagerI = I(true);
            Screen screen = k();
            ScreensCoordinatorLayout root = this.K0;
            if (root == null) {
                Intrinsics.h("coordinatorLayout");
                throw null;
            }
            Intrinsics.checkNotNullParameter(screen, "screen");
            Intrinsics.checkNotNullParameter(root, "root");
            DimmingView dimmingView = dimmingViewManagerI.f47089a;
            root.addView(dimmingView, 0);
            int sheetInitialDetentIndex = screen.getSheetInitialDetentIndex();
            Intrinsics.checkNotNullParameter(screen, "screen");
            if (sheetInitialDetentIndex > screen.getSheetLargestUndimmedDetentIndex()) {
                dimmingView.setAlpha(dimmingViewManagerI.f47090b);
            } else {
                dimmingView.setAlpha(0.0f);
            }
            Screen screenK4 = k();
            BottomSheetBehavior<Screen> sheetBehavior2 = k().getSheetBehavior();
            Intrinsics.c(sheetBehavior2);
            dimmingViewManagerI.a(screenK4, sheetBehavior2);
            ScreenContainer container = k().getContainer();
            Intrinsics.c(container);
            ScreensCoordinatorLayout screensCoordinatorLayout2 = this.K0;
            if (screensCoordinatorLayout2 == null) {
                Intrinsics.h("coordinatorLayout");
                throw null;
            }
            screensCoordinatorLayout2.measure(View.MeasureSpec.makeMeasureSpec(container.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(container.getHeight(), 1073741824));
            ScreensCoordinatorLayout screensCoordinatorLayout3 = this.K0;
            if (screensCoordinatorLayout3 == null) {
                Intrinsics.h("coordinatorLayout");
                throw null;
            }
            screensCoordinatorLayout3.layout(0, 0, container.getWidth(), container.getHeight());
            ViewCompat.O(k(), new AnonymousClass5(0));
        } else {
            Context context = getContext();
            if (context != null) {
                appBarLayout = new AppBarLayout(context, null);
                appBarLayout.setBackgroundColor(0);
                appBarLayout.setLayoutParams(new AppBarLayout.LayoutParams());
            } else {
                appBarLayout = null;
            }
            this.D0 = appBarLayout;
            ScreensCoordinatorLayout screensCoordinatorLayout4 = this.K0;
            if (screensCoordinatorLayout4 == null) {
                Intrinsics.h("coordinatorLayout");
                throw null;
            }
            screensCoordinatorLayout4.addView(appBarLayout);
            if (this.F0 && (appBarLayout3 = this.D0) != null) {
                appBarLayout3.setTargetElevation(0.0f);
            }
            CustomToolbar customToolbar = this.E0;
            if (customToolbar != null && (appBarLayout2 = this.D0) != null) {
                ViewExtKt.a(customToolbar);
                appBarLayout2.addView(customToolbar);
            }
            setHasOptionsMenu(true);
        }
        ScreensCoordinatorLayout screensCoordinatorLayout5 = this.K0;
        if (screensCoordinatorLayout5 != null) {
            return screensCoordinatorLayout5;
        }
        Intrinsics.h("coordinatorLayout");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPrepareOptionsMenu(Menu menu) {
        ScreenStackHeaderConfig headerConfig;
        Intrinsics.checkNotNullParameter(menu, "menu");
        int iOrdinal = k().f46941f.ordinal();
        if ((iOrdinal != 2 && iOrdinal != 3) || ((headerConfig = k().getHeaderConfig()) != null && !headerConfig.f47028g)) {
            N(menu);
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        View view = this.H0;
        if (view != null) {
            view.requestFocus();
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        PackageManager packageManager;
        Context context = getContext();
        if (context != null && (packageManager = context.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) {
            View viewK = k();
            while (true) {
                if (viewK == null) {
                    viewK = null;
                    break;
                } else if (viewK.isFocused()) {
                    break;
                } else {
                    viewK = viewK instanceof ViewGroup ? ((ViewGroup) viewK).getFocusedChild() : null;
                }
            }
            this.H0 = viewK;
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public final void p() {
        super.p();
        ScreenStackHeaderConfig headerConfig = k().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.c();
        }
    }

    public ScreenStackFragment() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }
}
