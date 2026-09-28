package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.search.SearchView;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
class SearchViewAnimationHelper {

    /* renamed from: a, reason: collision with root package name */
    public final SearchView f40919a;

    /* renamed from: b, reason: collision with root package name */
    public final View f40920b;

    /* renamed from: c, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f40921c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f40922d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f40923e;

    /* renamed from: f, reason: collision with root package name */
    public final MaterialToolbar f40924f;

    /* renamed from: g, reason: collision with root package name */
    public final Toolbar f40925g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f40926h;

    /* renamed from: i, reason: collision with root package name */
    public final EditText f40927i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageButton f40928j;

    /* renamed from: k, reason: collision with root package name */
    public final View f40929k;

    /* renamed from: l, reason: collision with root package name */
    public final TouchObserverFrameLayout f40930l;

    /* renamed from: m, reason: collision with root package name */
    public final MaterialMainContainerBackHelper f40931m;
    public AnimatorSet n;
    public SearchBar o;

    public SearchViewAnimationHelper(SearchView searchView) {
        this.f40919a = searchView;
        this.f40920b = searchView.f40898a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.f40899b;
        this.f40921c = clippableRoundedCornerLayout;
        this.f40922d = searchView.f40902e;
        this.f40923e = searchView.f40903f;
        this.f40924f = searchView.f40904g;
        this.f40925g = searchView.f40905h;
        this.f40926h = searchView.f40906i;
        this.f40927i = searchView.f40907j;
        this.f40928j = searchView.f40908k;
        this.f40929k = searchView.f40909l;
        this.f40930l = searchView.f40910m;
        this.f40931m = new MaterialMainContainerBackHelper(clippableRoundedCornerLayout);
    }

    public static void a(SearchViewAnimationHelper searchViewAnimationHelper, float f2) {
        ActionMenuView actionMenuViewA;
        searchViewAnimationHelper.f40928j.setAlpha(f2);
        searchViewAnimationHelper.f40929k.setAlpha(f2);
        searchViewAnimationHelper.f40930l.setAlpha(f2);
        if (!searchViewAnimationHelper.f40919a.w || (actionMenuViewA = ToolbarUtils.a(searchViewAnimationHelper.f40924f)) == null) {
            return;
        }
        actionMenuViewA.setAlpha(f2);
    }

    public final void b(AnimatorSet animatorSet) {
        final int i2 = 1;
        final int i3 = 0;
        ImageButton imageButtonB = ToolbarUtils.b(this.f40924f);
        if (imageButtonB == null) {
            return;
        }
        Drawable drawableO = DrawableCompat.o(imageButtonB.getDrawable());
        if (!this.f40919a.v) {
            if (drawableO instanceof DrawerArrowDrawable) {
                DrawerArrowDrawable drawerArrowDrawable = (DrawerArrowDrawable) drawableO;
                if (drawerArrowDrawable.f462i != 1.0f) {
                    drawerArrowDrawable.f462i = 1.0f;
                    drawerArrowDrawable.invalidateSelf();
                }
            }
            if (drawableO instanceof FadeThroughDrawable) {
                ((FadeThroughDrawable) drawableO).a(1.0f);
                return;
            }
            return;
        }
        if (drawableO instanceof DrawerArrowDrawable) {
            final DrawerArrowDrawable drawerArrowDrawable2 = (DrawerArrowDrawable) drawableO;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    switch (i3) {
                        case 0:
                            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            DrawerArrowDrawable drawerArrowDrawable3 = (DrawerArrowDrawable) drawerArrowDrawable2;
                            if (drawerArrowDrawable3.f462i != fFloatValue) {
                                drawerArrowDrawable3.f462i = fFloatValue;
                                drawerArrowDrawable3.invalidateSelf();
                                break;
                            }
                            break;
                        default:
                            ((FadeThroughDrawable) drawerArrowDrawable2).a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            break;
                    }
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
        if (drawableO instanceof FadeThroughDrawable) {
            final FadeThroughDrawable fadeThroughDrawable = (FadeThroughDrawable) drawableO;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    switch (i2) {
                        case 0:
                            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            DrawerArrowDrawable drawerArrowDrawable3 = (DrawerArrowDrawable) fadeThroughDrawable;
                            if (drawerArrowDrawable3.f462i != fFloatValue) {
                                drawerArrowDrawable3.f462i = fFloatValue;
                                drawerArrowDrawable3.invalidateSelf();
                                break;
                            }
                            break;
                        default:
                            ((FadeThroughDrawable) fadeThroughDrawable).a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            break;
                    }
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat2);
        }
    }

    public final AnimatorSet c(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        MaterialToolbar materialToolbar = this.f40924f;
        ImageButton imageButtonB = ToolbarUtils.b(materialToolbar);
        if (imageButtonB != null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f(imageButtonB), 0.0f);
            valueAnimatorOfFloat.addUpdateListener(new MultiViewUpdateListener(new com.google.android.material.internal.a(0), imageButtonB));
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(g(), 0.0f);
            valueAnimatorOfFloat2.addUpdateListener(MultiViewUpdateListener.a(imageButtonB));
            animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        }
        ActionMenuView actionMenuViewA = ToolbarUtils.a(materialToolbar);
        if (actionMenuViewA != null) {
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(e(actionMenuViewA), 0.0f);
            valueAnimatorOfFloat3.addUpdateListener(new MultiViewUpdateListener(new com.google.android.material.internal.a(0), actionMenuViewA));
            ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(g(), 0.0f);
            valueAnimatorOfFloat4.addUpdateListener(MultiViewUpdateListener.a(actionMenuViewA));
            animatorSet.playTogether(valueAnimatorOfFloat3, valueAnimatorOfFloat4);
        }
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z, AnimationUtils.f39817b));
        return animatorSet;
    }

    public final AnimatorSet d(final boolean z) {
        float f2;
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.n == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            b(animatorSet2);
            animatorSet2.setDuration(z ? 300L : 250L);
            animatorSet2.setInterpolator(ReversableAnimatedValueInterpolator.a(z, AnimationUtils.f39817b));
            animatorSet.playTogether(animatorSet2, c(z));
        }
        Interpolator interpolator = z ? AnimationUtils.f39816a : AnimationUtils.f39817b;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z, interpolator));
        valueAnimatorOfFloat.addUpdateListener(new MultiViewUpdateListener(new com.google.android.material.internal.a(3), this.f40920b));
        MaterialMainContainerBackHelper materialMainContainerBackHelper = this.f40931m;
        Rect rect = materialMainContainerBackHelper.f40684j;
        Rect rectA = materialMainContainerBackHelper.f40685k;
        SearchView searchView = this.f40919a;
        if (rect != null) {
            f2 = 0.0f;
        } else {
            f2 = 0.0f;
            rect = new Rect(searchView.getLeft(), searchView.getTop(), searchView.getRight(), searchView.getBottom());
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f40921c;
        if (rectA == null) {
            rectA = ViewUtils.a(clippableRoundedCornerLayout, this.o);
        }
        final Rect rect2 = new Rect(rectA);
        final float cornerSize = this.o.getCornerSize();
        final float fMax = Math.max(clippableRoundedCornerLayout.getCornerRadius(), materialMainContainerBackHelper.c());
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new RectEvaluator(rect2), rectA, rect);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchViewAnimationHelper searchViewAnimationHelper = this.f40948a;
                searchViewAnimationHelper.getClass();
                float fA = AnimationUtils.a(cornerSize, fMax, valueAnimator.getAnimatedFraction());
                ClippableRoundedCornerLayout clippableRoundedCornerLayout2 = searchViewAnimationHelper.f40921c;
                clippableRoundedCornerLayout2.getClass();
                Rect rect3 = rect2;
                clippableRoundedCornerLayout2.a(rect3.left, rect3.top, rect3.right, rect3.bottom, fA);
            }
        });
        valueAnimatorOfObject.setDuration(z ? 300L : 250L);
        FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.f39817b;
        valueAnimatorOfObject.setInterpolator(ReversableAnimatedValueInterpolator.a(z, fastOutSlowInInterpolator));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(z ? 50L : 42L);
        valueAnimatorOfFloat2.setStartDelay(z ? 250L : 0L);
        LinearInterpolator linearInterpolator = AnimationUtils.f39816a;
        valueAnimatorOfFloat2.setInterpolator(ReversableAnimatedValueInterpolator.a(z, linearInterpolator));
        valueAnimatorOfFloat2.addUpdateListener(new MultiViewUpdateListener(new com.google.android.material.internal.a(3), this.f40928j));
        AnimatorSet animatorSet3 = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat3.setDuration(z ? 150L : 83L);
        valueAnimatorOfFloat3.setStartDelay(z ? 75L : 0L);
        valueAnimatorOfFloat3.setInterpolator(ReversableAnimatedValueInterpolator.a(z, linearInterpolator));
        View view = this.f40929k;
        TouchObserverFrameLayout touchObserverFrameLayout = this.f40930l;
        valueAnimatorOfFloat3.addUpdateListener(new MultiViewUpdateListener(new com.google.android.material.internal.a(3), view, touchObserverFrameLayout));
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat((touchObserverFrameLayout.getHeight() * 0.050000012f) / 2.0f, f2);
        valueAnimatorOfFloat4.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat4.setInterpolator(ReversableAnimatedValueInterpolator.a(z, fastOutSlowInInterpolator));
        valueAnimatorOfFloat4.addUpdateListener(MultiViewUpdateListener.a(view));
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(0.95f, 1.0f);
        valueAnimatorOfFloat5.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat5.setInterpolator(ReversableAnimatedValueInterpolator.a(z, fastOutSlowInInterpolator));
        valueAnimatorOfFloat5.addUpdateListener(new MultiViewUpdateListener(new com.google.android.material.internal.a(2), touchObserverFrameLayout));
        animatorSet3.playTogether(valueAnimatorOfFloat3, valueAnimatorOfFloat4, valueAnimatorOfFloat5);
        Animator animatorI = i(this.f40922d, z, false);
        Toolbar toolbar = this.f40925g;
        Animator animatorI2 = i(toolbar, z, false);
        ValueAnimator valueAnimatorOfFloat6 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat6.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat6.setInterpolator(ReversableAnimatedValueInterpolator.a(z, fastOutSlowInInterpolator));
        if (searchView.w) {
            valueAnimatorOfFloat6.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.a(toolbar), ToolbarUtils.a(this.f40924f)));
        }
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfObject, valueAnimatorOfFloat2, animatorSet3, animatorI, animatorI2, valueAnimatorOfFloat6, i(this.f40927i, z, true), i(this.f40926h, z, true));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                float f3 = z ? 1.0f : 0.0f;
                SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
                SearchViewAnimationHelper.a(searchViewAnimationHelper, f3);
                ClippableRoundedCornerLayout clippableRoundedCornerLayout2 = searchViewAnimationHelper.f40921c;
                clippableRoundedCornerLayout2.f40551a = null;
                clippableRoundedCornerLayout2.f40552b = 0.0f;
                clippableRoundedCornerLayout2.invalidate();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.a(SearchViewAnimationHelper.this, z ? 0.0f : 1.0f);
            }
        });
        return animatorSet;
    }

    public final int e(View view) {
        int marginEnd = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginEnd();
        return ViewUtils.h(this.o) ? this.o.getLeft() - marginEnd : (this.o.getRight() - this.f40919a.getWidth()) + marginEnd;
    }

    public final int f(View view) {
        int marginStart = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginStart();
        SearchBar searchBar = this.o;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int paddingStart = searchBar.getPaddingStart();
        return ViewUtils.h(this.o) ? ((this.o.getWidth() - this.o.getRight()) + marginStart) - paddingStart : (this.o.getLeft() - marginStart) + paddingStart;
    }

    public final int g() {
        FrameLayout frameLayout = this.f40923e;
        return ((this.o.getBottom() + this.o.getTop()) / 2) - ((frameLayout.getBottom() + frameLayout.getTop()) / 2);
    }

    public final AnimatorSet h(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f40921c;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getHeight(), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.a(clippableRoundedCornerLayout));
        animatorSet.playTogether(valueAnimatorOfFloat);
        b(animatorSet);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z, AnimationUtils.f39817b));
        animatorSet.setDuration(z ? 350L : 300L);
        return animatorSet;
    }

    public final AnimatorSet i(View view, boolean z, boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(z2 ? f(view) : e(view), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new MultiViewUpdateListener(new com.google.android.material.internal.a(0), view));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(g(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(MultiViewUpdateListener.a(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z, AnimationUtils.f39817b));
        return animatorSet;
    }

    public final AnimatorSet j() {
        SearchBar searchBar = this.o;
        SearchView searchView = this.f40919a;
        if (searchBar != null) {
            if (searchView.i()) {
                searchView.h();
            }
            AnimatorSet animatorSetD = d(false);
            animatorSetD.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
                    searchViewAnimationHelper.f40921c.setVisibility(8);
                    if (!searchViewAnimationHelper.f40919a.i()) {
                        searchViewAnimationHelper.f40919a.h();
                    }
                    searchViewAnimationHelper.f40919a.setTransitionState(SearchView.TransitionState.f40915b);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    SearchViewAnimationHelper.this.f40919a.setTransitionState(SearchView.TransitionState.f40914a);
                }
            });
            animatorSetD.start();
            return animatorSetD;
        }
        if (searchView.i()) {
            searchView.h();
        }
        AnimatorSet animatorSetH = h(false);
        animatorSetH.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
                searchViewAnimationHelper.f40921c.setVisibility(8);
                if (!searchViewAnimationHelper.f40919a.i()) {
                    searchViewAnimationHelper.f40919a.h();
                }
                searchViewAnimationHelper.f40919a.setTransitionState(SearchView.TransitionState.f40915b);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f40919a.setTransitionState(SearchView.TransitionState.f40914a);
            }
        });
        animatorSetH.start();
        return animatorSetH;
    }
}
