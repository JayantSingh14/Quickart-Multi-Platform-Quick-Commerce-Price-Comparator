package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.search.SearchView;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior, MaterialBackHandler {
    public static final int D = R.style.Widget_Material3_SearchView;
    public boolean A;
    public TransitionState B;
    public HashMap C;

    /* renamed from: a, reason: collision with root package name */
    public final View f40898a;

    /* renamed from: b, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f40899b;

    /* renamed from: c, reason: collision with root package name */
    public final View f40900c;

    /* renamed from: d, reason: collision with root package name */
    public final View f40901d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f40902e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f40903f;

    /* renamed from: g, reason: collision with root package name */
    public final MaterialToolbar f40904g;

    /* renamed from: h, reason: collision with root package name */
    public final Toolbar f40905h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f40906i;

    /* renamed from: j, reason: collision with root package name */
    public final EditText f40907j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageButton f40908k;

    /* renamed from: l, reason: collision with root package name */
    public final View f40909l;

    /* renamed from: m, reason: collision with root package name */
    public final TouchObserverFrameLayout f40910m;
    public final boolean n;
    public final SearchViewAnimationHelper o;
    public final MaterialBackOrchestrator p;
    public final boolean q;
    public final ElevationOverlayProvider r;
    public final LinkedHashSet s;
    public SearchBar t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final int y;
    public boolean z;

    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean j(CoordinatorLayout coordinatorLayout, View view, View view2) {
            SearchView searchView = (SearchView) view;
            if (searchView.t != null || !(view2 instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view2);
            return false;
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public String f40912c;

        /* renamed from: d, reason: collision with root package name */
        public int f40913d;

        /* renamed from: com.google.android.material.search.SearchView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f40912c = parcel.readString();
            this.f40913d = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f40912c);
            parcel.writeInt(this.f40913d);
        }
    }

    public interface TransitionListener {
        void a();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TransitionState {

        /* renamed from: a, reason: collision with root package name */
        public static final TransitionState f40914a;

        /* renamed from: b, reason: collision with root package name */
        public static final TransitionState f40915b;

        /* renamed from: c, reason: collision with root package name */
        public static final TransitionState f40916c;

        /* renamed from: d, reason: collision with root package name */
        public static final TransitionState f40917d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f40918e;

        static {
            TransitionState transitionState = new TransitionState("HIDING", 0);
            f40914a = transitionState;
            TransitionState transitionState2 = new TransitionState("HIDDEN", 1);
            f40915b = transitionState2;
            TransitionState transitionState3 = new TransitionState("SHOWING", 2);
            f40916c = transitionState3;
            TransitionState transitionState4 = new TransitionState("SHOWN", 3);
            f40917d = transitionState4;
            f40918e = new TransitionState[]{transitionState, transitionState2, transitionState3, transitionState4};
        }

        public static TransitionState valueOf(String str) {
            return (TransitionState) Enum.valueOf(TransitionState.class, str);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f40918e.clone();
        }
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchViewStyle);
    }

    public static /* synthetic */ void g(SearchView searchView, WindowInsetsCompat windowInsetsCompat) {
        int iJ = windowInsetsCompat.j();
        searchView.setUpStatusBarSpacer(iJ);
        if (searchView.A) {
            return;
        }
        searchView.setStatusBarSpacerEnabledInternal(iJ > 0);
    }

    @Nullable
    private Window getActivityWindow() {
        Activity activityA = ContextUtils.a(getContext());
        if (activityA == null) {
            return null;
        }
        return activityA.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.t;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    @Px
    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", LogSubCategory.LifeCycle.ANDROID);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z) {
        this.f40901d.setVisibility(z ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f2) {
        View view;
        ElevationOverlayProvider elevationOverlayProvider = this.r;
        if (elevationOverlayProvider == null || (view = this.f40900c) == null) {
            return;
        }
        view.setBackgroundColor(elevationOverlayProvider.a(f2, this.y));
    }

    private void setUpHeaderLayout(int i2) {
        if (i2 != -1) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            FrameLayout frameLayout = this.f40902e;
            frameLayout.addView(layoutInflaterFrom.inflate(i2, (ViewGroup) frameLayout, false));
            frameLayout.setVisibility(0);
        }
    }

    private void setUpStatusBarSpacer(@Px int i2) {
        View view = this.f40901d;
        if (view.getLayoutParams().height != i2) {
            view.getLayoutParams().height = i2;
            view.requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.n) {
            this.f40910m.addView(view, i2, layoutParams);
        } else {
            super.addView(view, i2, layoutParams);
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void b() {
        int i2 = 0;
        if (j() || this.t == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        SearchViewAnimationHelper searchViewAnimationHelper = this.o;
        SearchBar searchBar = searchViewAnimationHelper.o;
        MaterialMainContainerBackHelper materialMainContainerBackHelper = searchViewAnimationHelper.f40931m;
        if (materialMainContainerBackHelper.a() != null) {
            AnimatorSet animatorSetB = materialMainContainerBackHelper.b(searchBar);
            View view = materialMainContainerBackHelper.f40667b;
            if (view instanceof ClippableRoundedCornerLayout) {
                ClippableRoundedCornerLayout clippableRoundedCornerLayout = (ClippableRoundedCornerLayout) view;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), materialMainContainerBackHelper.c());
                valueAnimatorOfFloat.addUpdateListener(new com.google.android.material.motion.b(clippableRoundedCornerLayout, i2));
                animatorSetB.playTogether(valueAnimatorOfFloat);
            }
            animatorSetB.setDuration(materialMainContainerBackHelper.f40670e);
            animatorSetB.start();
            materialMainContainerBackHelper.f40683i = 0.0f;
            materialMainContainerBackHelper.f40684j = null;
            materialMainContainerBackHelper.f40685k = null;
        }
        AnimatorSet animatorSet = searchViewAnimationHelper.n;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        searchViewAnimationHelper.n = null;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void c(BackEventCompat backEventCompat) {
        if (j() || this.t == null) {
            return;
        }
        SearchViewAnimationHelper searchViewAnimationHelper = this.o;
        SearchBar searchBar = searchViewAnimationHelper.o;
        MaterialMainContainerBackHelper materialMainContainerBackHelper = searchViewAnimationHelper.f40931m;
        materialMainContainerBackHelper.f40671f = backEventCompat;
        View view = materialMainContainerBackHelper.f40667b;
        materialMainContainerBackHelper.f40684j = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (searchBar != null) {
            materialMainContainerBackHelper.f40685k = ViewUtils.a(view, searchBar);
        }
        materialMainContainerBackHelper.f40683i = backEventCompat.f119b;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void d(BackEventCompat backEventCompat) {
        if (j() || this.t == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        SearchViewAnimationHelper searchViewAnimationHelper = this.o;
        searchViewAnimationHelper.getClass();
        float f2 = backEventCompat.f120c;
        if (f2 <= 0.0f) {
            return;
        }
        SearchBar searchBar = searchViewAnimationHelper.o;
        float cornerSize = searchBar.getCornerSize();
        MaterialMainContainerBackHelper materialMainContainerBackHelper = searchViewAnimationHelper.f40931m;
        if (materialMainContainerBackHelper.f40671f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = materialMainContainerBackHelper.f40671f;
        materialMainContainerBackHelper.f40671f = backEventCompat;
        if (backEventCompat2 != null) {
            if (searchBar.getVisibility() != 4) {
                searchBar.setVisibility(4);
            }
            boolean z = backEventCompat.f121d == 0;
            float interpolation = materialMainContainerBackHelper.f40666a.getInterpolation(f2);
            View view = materialMainContainerBackHelper.f40667b;
            float width = view.getWidth();
            float height = view.getHeight();
            if (width > 0.0f && height > 0.0f) {
                float fA = AnimationUtils.a(1.0f, 0.9f, interpolation);
                float f3 = materialMainContainerBackHelper.f40681g;
                float fA2 = AnimationUtils.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - f3), interpolation) * (z ? 1 : -1);
                float fMin = Math.min(Math.max(0.0f, ((height - (fA * height)) / 2.0f) - f3), materialMainContainerBackHelper.f40682h);
                float f4 = backEventCompat.f119b - materialMainContainerBackHelper.f40683i;
                float fA3 = AnimationUtils.a(0.0f, fMin, Math.abs(f4) / height) * Math.signum(f4);
                view.setScaleX(fA);
                view.setScaleY(fA);
                view.setTranslationX(fA2);
                view.setTranslationY(fA3);
                if (view instanceof ClippableRoundedCornerLayout) {
                    ((ClippableRoundedCornerLayout) view).a(r12.getLeft(), r12.getTop(), r12.getRight(), r12.getBottom(), AnimationUtils.a(materialMainContainerBackHelper.c(), cornerSize, interpolation));
                }
            }
        }
        AnimatorSet animatorSet = searchViewAnimationHelper.n;
        if (animatorSet != null) {
            animatorSet.setCurrentPlayTime((long) (f2 * animatorSet.getDuration()));
            return;
        }
        SearchView searchView = searchViewAnimationHelper.f40919a;
        if (searchView.i()) {
            searchView.h();
        }
        if (searchView.v) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            searchViewAnimationHelper.b(animatorSet2);
            animatorSet2.setDuration(250L);
            animatorSet2.setInterpolator(ReversableAnimatedValueInterpolator.a(false, AnimationUtils.f39817b));
            searchViewAnimationHelper.n = animatorSet2;
            animatorSet2.start();
            searchViewAnimationHelper.n.pause();
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void e() {
        if (j()) {
            return;
        }
        SearchViewAnimationHelper searchViewAnimationHelper = this.o;
        MaterialMainContainerBackHelper materialMainContainerBackHelper = searchViewAnimationHelper.f40931m;
        BackEventCompat backEventCompat = materialMainContainerBackHelper.f40671f;
        materialMainContainerBackHelper.f40671f = null;
        if (Build.VERSION.SDK_INT < 34 || this.t == null || backEventCompat == null) {
            if (this.B.equals(TransitionState.f40915b) || this.B.equals(TransitionState.f40914a)) {
                return;
            }
            searchViewAnimationHelper.j();
            return;
        }
        long totalDuration = searchViewAnimationHelper.j().getTotalDuration();
        SearchBar searchBar = searchViewAnimationHelper.o;
        MaterialMainContainerBackHelper materialMainContainerBackHelper2 = searchViewAnimationHelper.f40931m;
        AnimatorSet animatorSetB = materialMainContainerBackHelper2.b(searchBar);
        animatorSetB.setDuration(totalDuration);
        animatorSetB.start();
        materialMainContainerBackHelper2.f40683i = 0.0f;
        materialMainContainerBackHelper2.f40684j = null;
        materialMainContainerBackHelper2.f40685k = null;
        if (searchViewAnimationHelper.n != null) {
            searchViewAnimationHelper.c(false).start();
            searchViewAnimationHelper.n.resume();
        }
        searchViewAnimationHelper.n = null;
    }

    @VisibleForTesting
    public MaterialMainContainerBackHelper getBackHelper() {
        return this.o.f40931m;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.B;
    }

    @DrawableRes
    @RestrictTo
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    @NonNull
    public EditText getEditText() {
        return this.f40907j;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f40907j.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.f40906i;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.f40906i.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.u;
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f40907j.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.f40904g;
    }

    public final void h() {
        this.f40907j.post(new c(this, 0));
    }

    public final boolean i() {
        return this.u == 48;
    }

    public final boolean j() {
        return this.B.equals(TransitionState.f40915b) || this.B.equals(TransitionState.f40914a);
    }

    public final void k() {
        if (this.x) {
            this.f40907j.postDelayed(new c(this, 1), 100L);
        }
    }

    public final void l(TransitionState transitionState, boolean z) {
        if (this.B.equals(transitionState)) {
            return;
        }
        if (z) {
            if (transitionState == TransitionState.f40917d) {
                setModalForAccessibility(true);
            } else if (transitionState == TransitionState.f40915b) {
                setModalForAccessibility(false);
            }
        }
        this.B = transitionState;
        Iterator it = new LinkedHashSet(this.s).iterator();
        while (it.hasNext()) {
            ((TransitionListener) it.next()).a();
        }
        o(transitionState);
    }

    public final void m() {
        if (this.B.equals(TransitionState.f40917d)) {
            return;
        }
        TransitionState transitionState = this.B;
        TransitionState transitionState2 = TransitionState.f40916c;
        if (transitionState.equals(transitionState2)) {
            return;
        }
        final SearchViewAnimationHelper searchViewAnimationHelper = this.o;
        SearchBar searchBar = searchViewAnimationHelper.o;
        SearchView searchView = searchViewAnimationHelper.f40919a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchViewAnimationHelper.f40921c;
        if (searchBar == null) {
            if (searchView.i()) {
                searchView.postDelayed(new c(searchView, 3), 150L);
            }
            clippableRoundedCornerLayout.setVisibility(4);
            final int i2 = 1;
            clippableRoundedCornerLayout.post(new Runnable() { // from class: com.google.android.material.search.j
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            SearchViewAnimationHelper searchViewAnimationHelper2 = searchViewAnimationHelper;
                            AnimatorSet animatorSetD = searchViewAnimationHelper2.d(true);
                            animatorSetD.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.1
                                public AnonymousClass1() {
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    SearchViewAnimationHelper searchViewAnimationHelper3 = SearchViewAnimationHelper.this;
                                    if (!searchViewAnimationHelper3.f40919a.i()) {
                                        searchViewAnimationHelper3.f40919a.k();
                                    }
                                    searchViewAnimationHelper3.f40919a.setTransitionState(SearchView.TransitionState.f40917d);
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationStart(Animator animator) {
                                    SearchViewAnimationHelper searchViewAnimationHelper3 = SearchViewAnimationHelper.this;
                                    searchViewAnimationHelper3.f40921c.setVisibility(0);
                                    SearchBar searchBar2 = searchViewAnimationHelper3.o;
                                    searchBar2.J0.getClass();
                                    View centerView = searchBar2.getCenterView();
                                    if (centerView instanceof AnimatableView) {
                                        ((AnimatableView) centerView).a();
                                    }
                                    if (centerView != 0) {
                                        centerView.setAlpha(0.0f);
                                    }
                                }
                            });
                            animatorSetD.start();
                            break;
                        default:
                            SearchViewAnimationHelper searchViewAnimationHelper3 = searchViewAnimationHelper;
                            searchViewAnimationHelper3.f40921c.setTranslationY(r1.getHeight());
                            AnimatorSet animatorSetH = searchViewAnimationHelper3.h(true);
                            animatorSetH.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.3
                                public AnonymousClass3() {
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    SearchViewAnimationHelper searchViewAnimationHelper4 = SearchViewAnimationHelper.this;
                                    if (!searchViewAnimationHelper4.f40919a.i()) {
                                        searchViewAnimationHelper4.f40919a.k();
                                    }
                                    searchViewAnimationHelper4.f40919a.setTransitionState(SearchView.TransitionState.f40917d);
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationStart(Animator animator) {
                                    SearchViewAnimationHelper searchViewAnimationHelper4 = SearchViewAnimationHelper.this;
                                    searchViewAnimationHelper4.f40921c.setVisibility(0);
                                    searchViewAnimationHelper4.f40919a.setTransitionState(SearchView.TransitionState.f40916c);
                                }
                            });
                            animatorSetH.start();
                            break;
                    }
                }
            });
            return;
        }
        if (searchView.i()) {
            searchView.k();
        }
        searchView.setTransitionState(transitionState2);
        Toolbar toolbar = searchViewAnimationHelper.f40925g;
        Menu menu = toolbar.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (searchViewAnimationHelper.o.getMenuResId() == -1 || !searchView.w) {
            toolbar.setVisibility(8);
        } else {
            toolbar.n(searchViewAnimationHelper.o.getMenuResId());
            ActionMenuView actionMenuViewA = ToolbarUtils.a(toolbar);
            if (actionMenuViewA != null) {
                for (int i3 = 0; i3 < actionMenuViewA.getChildCount(); i3++) {
                    View childAt = actionMenuViewA.getChildAt(i3);
                    childAt.setClickable(false);
                    childAt.setFocusable(false);
                    childAt.setFocusableInTouchMode(false);
                }
            }
            toolbar.setVisibility(0);
        }
        CharSequence text = searchViewAnimationHelper.o.getText();
        EditText editText = searchViewAnimationHelper.f40927i;
        editText.setText(text);
        editText.setSelection(editText.getText().length());
        clippableRoundedCornerLayout.setVisibility(4);
        final int i4 = 0;
        clippableRoundedCornerLayout.post(new Runnable() { // from class: com.google.android.material.search.j
            @Override // java.lang.Runnable
            public final void run() {
                switch (i4) {
                    case 0:
                        SearchViewAnimationHelper searchViewAnimationHelper2 = searchViewAnimationHelper;
                        AnimatorSet animatorSetD = searchViewAnimationHelper2.d(true);
                        animatorSetD.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.1
                            public AnonymousClass1() {
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                SearchViewAnimationHelper searchViewAnimationHelper3 = SearchViewAnimationHelper.this;
                                if (!searchViewAnimationHelper3.f40919a.i()) {
                                    searchViewAnimationHelper3.f40919a.k();
                                }
                                searchViewAnimationHelper3.f40919a.setTransitionState(SearchView.TransitionState.f40917d);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationStart(Animator animator) {
                                SearchViewAnimationHelper searchViewAnimationHelper3 = SearchViewAnimationHelper.this;
                                searchViewAnimationHelper3.f40921c.setVisibility(0);
                                SearchBar searchBar2 = searchViewAnimationHelper3.o;
                                searchBar2.J0.getClass();
                                View centerView = searchBar2.getCenterView();
                                if (centerView instanceof AnimatableView) {
                                    ((AnimatableView) centerView).a();
                                }
                                if (centerView != 0) {
                                    centerView.setAlpha(0.0f);
                                }
                            }
                        });
                        animatorSetD.start();
                        break;
                    default:
                        SearchViewAnimationHelper searchViewAnimationHelper3 = searchViewAnimationHelper;
                        searchViewAnimationHelper3.f40921c.setTranslationY(r1.getHeight());
                        AnimatorSet animatorSetH = searchViewAnimationHelper3.h(true);
                        animatorSetH.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.3
                            public AnonymousClass3() {
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                SearchViewAnimationHelper searchViewAnimationHelper4 = SearchViewAnimationHelper.this;
                                if (!searchViewAnimationHelper4.f40919a.i()) {
                                    searchViewAnimationHelper4.f40919a.k();
                                }
                                searchViewAnimationHelper4.f40919a.setTransitionState(SearchView.TransitionState.f40917d);
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationStart(Animator animator) {
                                SearchViewAnimationHelper searchViewAnimationHelper4 = SearchViewAnimationHelper.this;
                                searchViewAnimationHelper4.f40921c.setVisibility(0);
                                searchViewAnimationHelper4.f40919a.setTransitionState(SearchView.TransitionState.f40916c);
                            }
                        });
                        animatorSetH.start();
                        break;
                }
            }
        });
    }

    public final void n(ViewGroup viewGroup, boolean z) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != this) {
                if (childAt.findViewById(this.f40899b.getId()) != null) {
                    n((ViewGroup) childAt, z);
                } else if (z) {
                    this.C.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    childAt.setImportantForAccessibility(4);
                } else {
                    HashMap map = this.C;
                    if (map != null && map.containsKey(childAt)) {
                        int iIntValue = ((Integer) this.C.get(childAt)).intValue();
                        WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                        childAt.setImportantForAccessibility(iIntValue);
                    }
                }
            }
        }
    }

    public final void o(TransitionState transitionState) {
        if (this.t == null || !this.q) {
            return;
        }
        boolean zEquals = transitionState.equals(TransitionState.f40917d);
        MaterialBackOrchestrator materialBackOrchestrator = this.p;
        if (zEquals) {
            materialBackOrchestrator.a(false);
        } else if (transitionState.equals(TransitionState.f40915b)) {
            materialBackOrchestrator.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.d(this);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.u = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        setText(savedState.f40912c);
        setVisible(savedState.f40913d == 0);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.f40912c = text == null ? null : text.toString();
        savedState.f40913d = this.f40899b.getVisibility();
        return savedState;
    }

    public final void p() {
        ImageButton imageButtonB = ToolbarUtils.b(this.f40904g);
        if (imageButtonB == null) {
            return;
        }
        int i2 = this.f40899b.getVisibility() == 0 ? 1 : 0;
        Drawable drawableO = DrawableCompat.o(imageButtonB.getDrawable());
        if (drawableO instanceof DrawerArrowDrawable) {
            DrawerArrowDrawable drawerArrowDrawable = (DrawerArrowDrawable) drawableO;
            float f2 = i2;
            if (drawerArrowDrawable.f462i != f2) {
                drawerArrowDrawable.f462i = f2;
                drawerArrowDrawable.invalidateSelf();
            }
        }
        if (drawableO instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawableO).a(i2);
        }
    }

    public void setAnimatedNavigationIcon(boolean z) {
        this.v = z;
    }

    public void setAutoShowKeyboard(boolean z) {
        this.x = z;
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        setUpBackgroundViewElevationOverlay(f2);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f40907j.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z) {
        this.w = z;
    }

    public void setModalForAccessibility(boolean z) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z) {
            this.C = new HashMap(viewGroup.getChildCount());
        }
        n(viewGroup, z);
        if (z) {
            return;
        }
        this.C = null;
    }

    public void setOnMenuItemClickListener(@Nullable Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.f40904g.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setSearchPrefixText(@Nullable CharSequence charSequence) {
        TextView textView = this.f40906i;
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @RestrictTo
    public void setStatusBarSpacerEnabled(boolean z) {
        this.A = true;
        setStatusBarSpacerEnabledInternal(z);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence charSequence) {
        this.f40907j.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z) {
        this.f40904g.setTouchscreenBlocksFocus(z);
    }

    public void setTransitionState(@NonNull TransitionState transitionState) {
        l(transitionState, true);
    }

    @RestrictTo
    public void setUseWindowInsetsController(boolean z) {
        this.z = z;
    }

    public void setVisible(boolean z) {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f40899b;
        boolean z2 = clippableRoundedCornerLayout.getVisibility() == 0;
        clippableRoundedCornerLayout.setVisibility(z ? 0 : 8);
        p();
        l(z ? TransitionState.f40917d : TransitionState.f40915b, z2 != z);
    }

    public void setupWithSearchBar(@Nullable SearchBar searchBar) {
        this.t = searchBar;
        this.o.o = searchBar;
        if (searchBar != null) {
            searchBar.setOnClickListener(new b(this, 2));
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new c(this, 2));
                    this.f40907j.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        MaterialToolbar materialToolbar = this.f40904g;
        if (materialToolbar != null && !(DrawableCompat.o(materialToolbar.getNavigationIcon()) instanceof DrawerArrowDrawable)) {
            int defaultNavigationIconResource = getDefaultNavigationIconResource();
            if (this.t == null) {
                materialToolbar.setNavigationIcon(defaultNavigationIconResource);
            } else {
                Drawable drawableMutate = AppCompatResources.b(defaultNavigationIconResource, getContext()).mutate();
                if (materialToolbar.getNavigationIconTint() != null) {
                    drawableMutate.setTint(materialToolbar.getNavigationIconTint().intValue());
                }
                materialToolbar.setNavigationIcon(new FadeThroughDrawable(this.t.getNavigationIcon(), drawableMutate));
                p();
            }
        }
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
        o(getCurrentTransitionState());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = D;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.p = new MaterialBackOrchestrator(this, this);
        this.s = new LinkedHashSet();
        this.u = 16;
        this.B = TransitionState.f40915b;
        Context context2 = getContext();
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.SearchView, i2, i3, new int[0]);
        this.y = typedArrayD.getColor(R.styleable.SearchView_backgroundTint, 0);
        int resourceId = typedArrayD.getResourceId(R.styleable.SearchView_headerLayout, -1);
        int resourceId2 = typedArrayD.getResourceId(R.styleable.SearchView_android_textAppearance, -1);
        String string = typedArrayD.getString(R.styleable.SearchView_android_text);
        String string2 = typedArrayD.getString(R.styleable.SearchView_android_hint);
        String string3 = typedArrayD.getString(R.styleable.SearchView_searchPrefixText);
        boolean z = typedArrayD.getBoolean(R.styleable.SearchView_useDrawerArrowDrawable, false);
        this.v = typedArrayD.getBoolean(R.styleable.SearchView_animateNavigationIcon, true);
        this.w = typedArrayD.getBoolean(R.styleable.SearchView_animateMenuItems, true);
        boolean z2 = typedArrayD.getBoolean(R.styleable.SearchView_hideNavigationIcon, false);
        this.x = typedArrayD.getBoolean(R.styleable.SearchView_autoShowKeyboard, true);
        this.q = typedArrayD.getBoolean(R.styleable.SearchView_backHandlingEnabled, true);
        typedArrayD.recycle();
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_view, this);
        this.n = true;
        this.f40898a = findViewById(R.id.open_search_view_scrim);
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = (ClippableRoundedCornerLayout) findViewById(R.id.open_search_view_root);
        this.f40899b = clippableRoundedCornerLayout;
        this.f40900c = findViewById(R.id.open_search_view_background);
        View viewFindViewById = findViewById(R.id.open_search_view_status_bar_spacer);
        this.f40901d = viewFindViewById;
        this.f40902e = (FrameLayout) findViewById(R.id.open_search_view_header_container);
        this.f40903f = (FrameLayout) findViewById(R.id.open_search_view_toolbar_container);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R.id.open_search_view_toolbar);
        this.f40904g = materialToolbar;
        this.f40905h = (Toolbar) findViewById(R.id.open_search_view_dummy_toolbar);
        this.f40906i = (TextView) findViewById(R.id.open_search_view_search_prefix);
        EditText editText = (EditText) findViewById(R.id.open_search_view_edit_text);
        this.f40907j = editText;
        ImageButton imageButton = (ImageButton) findViewById(R.id.open_search_view_clear_button);
        this.f40908k = imageButton;
        View viewFindViewById2 = findViewById(R.id.open_search_view_divider);
        this.f40909l = viewFindViewById2;
        TouchObserverFrameLayout touchObserverFrameLayout = (TouchObserverFrameLayout) findViewById(R.id.open_search_view_content_container);
        this.f40910m = touchObserverFrameLayout;
        this.o = new SearchViewAnimationHelper(this);
        this.r = new ElevationOverlayProvider(context2);
        clippableRoundedCornerLayout.setOnTouchListener(new f());
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
        setUpHeaderLayout(resourceId);
        setSearchPrefixText(string3);
        if (resourceId2 != -1) {
            editText.setTextAppearance(resourceId2);
        }
        editText.setText(string);
        editText.setHint(string2);
        if (z2) {
            materialToolbar.setNavigationIcon((Drawable) null);
        } else {
            materialToolbar.setNavigationOnClickListener(new b(this, 0));
            if (z) {
                DrawerArrowDrawable drawerArrowDrawable = new DrawerArrowDrawable(getContext());
                int iB = MaterialColors.b(R.attr.colorOnSurface, this);
                Paint paint = drawerArrowDrawable.f454a;
                if (iB != paint.getColor()) {
                    paint.setColor(iB);
                    drawerArrowDrawable.invalidateSelf();
                }
                materialToolbar.setNavigationIcon(drawerArrowDrawable);
            }
        }
        imageButton.setOnClickListener(new b(this, 1));
        editText.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.search.SearchView.1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                SearchView.this.f40908k.setVisibility(charSequence.length() > 0 ? 0 : 8);
            }
        });
        touchObserverFrameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int i4 = SearchView.D;
                SearchView searchView = this.f40947a;
                if (!searchView.i()) {
                    return false;
                }
                searchView.h();
                return false;
            }
        });
        ViewUtils.b(materialToolbar, new a(this));
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById2.getLayoutParams();
        final int i4 = marginLayoutParams.leftMargin;
        final int i5 = marginLayoutParams.rightMargin;
        ViewCompat.H(viewFindViewById2, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.search.d
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                int i6 = SearchView.D;
                int iH = windowInsetsCompat.h() + i4;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                marginLayoutParams2.leftMargin = iH;
                marginLayoutParams2.rightMargin = windowInsetsCompat.i() + i5;
                return windowInsetsCompat;
            }
        });
        setUpStatusBarSpacer(getStatusBarHeight());
        ViewCompat.H(viewFindViewById, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.search.e
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                SearchView.g(this.f40946a, windowInsetsCompat);
                return windowInsetsCompat;
            }
        });
    }

    public void setHint(@StringRes int i2) {
        this.f40907j.setHint(i2);
    }

    public void setText(@StringRes int i2) {
        this.f40907j.setText(i2);
    }
}
