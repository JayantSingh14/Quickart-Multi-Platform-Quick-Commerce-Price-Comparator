package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    public static final int z = R.style.Widget_Design_AppBarLayout;

    /* renamed from: a, reason: collision with root package name */
    public int f39835a;

    /* renamed from: b, reason: collision with root package name */
    public int f39836b;

    /* renamed from: c, reason: collision with root package name */
    public int f39837c;

    /* renamed from: d, reason: collision with root package name */
    public int f39838d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39839e;

    /* renamed from: f, reason: collision with root package name */
    public int f39840f;

    /* renamed from: g, reason: collision with root package name */
    public WindowInsetsCompat f39841g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f39842h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39843i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f39844j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39845k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39846l;

    /* renamed from: m, reason: collision with root package name */
    public int f39847m;
    public WeakReference n;
    public final boolean o;
    public ValueAnimator p;
    public final ValueAnimator.AnimatorUpdateListener q;
    public final ArrayList r;
    public final long s;
    public final TimeInterpolator t;
    public int[] u;
    public Drawable v;
    public Integer w;
    public final float x;
    public Behavior y;

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: j, reason: collision with root package name */
        public int f39849j;

        /* renamed from: k, reason: collision with root package name */
        public int f39850k;

        /* renamed from: l, reason: collision with root package name */
        public ValueAnimator f39851l;

        /* renamed from: m, reason: collision with root package name */
        public SavedState f39852m;
        public WeakReference n;

        /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$2, reason: invalid class name */
        class AnonymousClass2 extends AccessibilityDelegateCompat {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f39856a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f39857b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ BaseBehavior f39858c;

            public AnonymousClass2(CoordinatorLayout coordinatorLayout, BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
                this.f39858c = baseBehavior;
                this.f39856a = appBarLayout;
                this.f39857b = coordinatorLayout;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                BaseBehavior baseBehavior;
                View viewI;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m(ScrollView.class.getName());
                AppBarLayout appBarLayout = this.f39856a;
                if (appBarLayout.getTotalScrollRange() == 0 || (viewI = BaseBehavior.I((baseBehavior = this.f39858c), this.f39857b)) == null) {
                    return;
                }
                int childCount = appBarLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (((LayoutParams) appBarLayout.getChildAt(i2).getLayoutParams()).f39866a != 0) {
                        if (baseBehavior.z() != (-appBarLayout.getTotalScrollRange())) {
                            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3191i);
                            accessibilityNodeInfoCompat.u(true);
                        }
                        if (baseBehavior.z() != 0) {
                            if (!viewI.canScrollVertically(-1)) {
                                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3192j);
                                accessibilityNodeInfoCompat.u(true);
                                return;
                            } else {
                                if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3192j);
                                    accessibilityNodeInfoCompat.u(true);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                AppBarLayout appBarLayout = this.f39856a;
                if (i2 == 4096) {
                    appBarLayout.setExpanded(false);
                    return true;
                }
                if (i2 != 8192) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                BaseBehavior baseBehavior = this.f39858c;
                if (baseBehavior.z() != 0) {
                    View viewI = BaseBehavior.I(baseBehavior, this.f39857b);
                    if (!viewI.canScrollVertically(-1)) {
                        appBarLayout.setExpanded(true);
                        return true;
                    }
                    int i3 = -appBarLayout.getDownNestedPreScrollRange();
                    if (i3 != 0) {
                        CoordinatorLayout coordinatorLayout = this.f39857b;
                        AppBarLayout appBarLayout2 = this.f39856a;
                        this.f39858c.L(coordinatorLayout, appBarLayout2, viewI, i3, new int[]{0, 0});
                        return true;
                    }
                }
                return false;
            }
        }

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

            /* renamed from: c, reason: collision with root package name */
            public boolean f39859c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f39860d;

            /* renamed from: e, reason: collision with root package name */
            public int f39861e;

            /* renamed from: f, reason: collision with root package name */
            public float f39862f;

            /* renamed from: g, reason: collision with root package name */
            public boolean f39863g;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$1, reason: invalid class name */
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
                this.f39859c = parcel.readByte() != 0;
                this.f39860d = parcel.readByte() != 0;
                this.f39861e = parcel.readInt();
                this.f39862f = parcel.readFloat();
                this.f39863g = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeByte(this.f39859c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f39860d ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f39861e);
                parcel.writeFloat(this.f39862f);
                parcel.writeByte(this.f39863g ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
        }

        public static View I(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            baseBehavior.getClass();
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f2560a instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View K(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void O(androidx.coordinatorlayout.widget.CoordinatorLayout r8, com.google.android.material.appbar.AppBarLayout r9, int r10, int r11, boolean r12) {
            /*
                r0 = 1
                int r1 = java.lang.Math.abs(r10)
                int r2 = r9.getChildCount()
                r3 = 0
                r4 = r3
            Lb:
                r5 = 0
                if (r4 >= r2) goto L21
                android.view.View r6 = r9.getChildAt(r4)
                int r7 = r6.getTop()
                if (r1 < r7) goto L1f
                int r7 = r6.getBottom()
                if (r1 > r7) goto L1f
                goto L22
            L1f:
                int r4 = r4 + r0
                goto Lb
            L21:
                r6 = r5
            L22:
                if (r6 == 0) goto L5d
                android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r1 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r1
                int r1 = r1.f39866a
                r2 = r1 & 1
                if (r2 == 0) goto L5d
                java.util.WeakHashMap r2 = androidx.core.view.ViewCompat.f3080a
                int r2 = r6.getMinimumHeight()
                if (r11 <= 0) goto L4b
                r11 = r1 & 12
                if (r11 == 0) goto L4b
                int r10 = -r10
                int r11 = r6.getBottom()
                int r11 = r11 - r2
                int r1 = r9.getTopInset()
                int r11 = r11 - r1
                if (r10 < r11) goto L5d
            L49:
                r10 = r0
                goto L5e
            L4b:
                r11 = r1 & 2
                if (r11 == 0) goto L5d
                int r10 = -r10
                int r11 = r6.getBottom()
                int r11 = r11 - r2
                int r1 = r9.getTopInset()
                int r11 = r11 - r1
                if (r10 < r11) goto L5d
                goto L49
            L5d:
                r10 = r3
            L5e:
                boolean r11 = r9.f39846l
                if (r11 == 0) goto L6a
                android.view.View r10 = K(r8)
                boolean r10 = r9.f(r10)
            L6a:
                boolean r10 = r9.e(r10)
                if (r12 != 0) goto La9
                if (r10 == 0) goto Ld0
                androidx.coordinatorlayout.widget.DirectedAcyclicGraph r8 = r8.f2546b
                androidx.collection.SimpleArrayMap r8 = r8.f2576b
                java.lang.Object r8 = r8.get(r9)
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                if (r8 != 0) goto L7f
                goto L84
            L7f:
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>(r8)
            L84:
                if (r5 != 0) goto L88
                java.util.List r5 = java.util.Collections.EMPTY_LIST
            L88:
                int r8 = r5.size()
            L8c:
                if (r3 >= r8) goto Ld0
                java.lang.Object r10 = r5.get(r3)
                android.view.View r10 = (android.view.View) r10
                android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r10 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r10
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r10 = r10.f2560a
                boolean r11 = r10 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r11 == 0) goto La7
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r10 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r10
                int r8 = r10.f39900f
                if (r8 == 0) goto Ld0
                goto La9
            La7:
                int r3 = r3 + r0
                goto L8c
            La9:
                android.graphics.drawable.Drawable r8 = r9.getBackground()
                if (r8 == 0) goto Lb6
                android.graphics.drawable.Drawable r8 = r9.getBackground()
                r8.jumpToCurrentState()
            Lb6:
                android.graphics.drawable.Drawable r8 = r9.getForeground()
                if (r8 == 0) goto Lc3
                android.graphics.drawable.Drawable r8 = r9.getForeground()
                r8.jumpToCurrentState()
            Lc3:
                android.animation.StateListAnimator r8 = r9.getStateListAnimator()
                if (r8 == 0) goto Ld0
                android.animation.StateListAnimator r8 = r9.getStateListAnimator()
                r8.jumpToCurrentState()
            Ld0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.O(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final boolean C(View view) {
            WeakReference weakReference = this.n;
            if (weakReference == null) {
                return true;
            }
            View view2 = (View) weakReference.get();
            return (view2 == null || !view2.isShown() || view2.canScrollVertically(-1)) ? false : true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int D(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            return appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange());
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int E(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final void F(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            N(coordinatorLayout, appBarLayout);
            if (appBarLayout.f39846l) {
                appBarLayout.e(appBarLayout.f(K(coordinatorLayout)));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0152  */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int G(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
            /*
                Method dump skipped, instructions count: 363
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.G(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void J(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i2) {
            int iAbs = Math.abs(z() - i2);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iZ = z();
            if (iZ == i2) {
                ValueAnimator valueAnimator = this.f39851l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f39851l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f39851l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f39851l = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.f39820e);
                this.f39851l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        int iIntValue = ((Integer) valueAnimator4.getAnimatedValue()).intValue();
                        this.H(coordinatorLayout, appBarLayout, iIntValue);
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.f39851l.setDuration(Math.min(iRound, 600));
            this.f39851l.setIntValues(iZ, i2);
            this.f39851l.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void L(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2b
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
            Le:
                r6 = r0
                r7 = r1
                goto L18
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                goto Le
            L18:
                if (r6 == r7) goto L2b
                int r0 = r8.z()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r9 = r2.G(r3, r4, r5, r6, r7)
                r10 = 1
                r13[r10] = r9
                goto L2c
            L2b:
                r4 = r10
            L2c:
                boolean r9 = r4.f39846l
                if (r9 == 0) goto L37
                boolean r9 = r4.f(r11)
                r4.e(r9)
            L37:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.L(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        public final SavedState M(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iY = y();
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int bottom = childAt.getBottom() + iY;
                if (childAt.getTop() + iY <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.f3320b;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z = iY == 0;
                    savedState.f39860d = z;
                    savedState.f39859c = !z && (-iY) >= appBarLayout.getTotalScrollRange();
                    savedState.f39861e = i2;
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    savedState.f39863g = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    savedState.f39862f = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public final void N(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int iZ = z() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i2 = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if ((layoutParams.f39866a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i3 = -iZ;
                if (top <= i3 && bottom >= i3) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i2);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                int i4 = layoutParams2.f39866a;
                if ((i4 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i2 == 0) {
                        WeakHashMap weakHashMap = ViewCompat.f3080a;
                        if (appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                            topInset -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i4 & 2) == 2) {
                        WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i4 & 5) == 5) {
                        WeakHashMap weakHashMap3 = ViewCompat.f3080a;
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iZ < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i4 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    }
                    if (iZ < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    J(coordinatorLayout, appBarLayout, MathUtils.b(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
            int iRound;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.n(coordinatorLayout, appBarLayout, i2);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.f39852m;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i3 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            J(coordinatorLayout, appBarLayout, i3);
                        } else {
                            H(coordinatorLayout, appBarLayout, i3);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            J(coordinatorLayout, appBarLayout, 0);
                        } else {
                            H(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.f39859c) {
                H(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.f39860d) {
                H(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.f39861e);
                int i4 = -childAt.getBottom();
                if (this.f39852m.f39863g) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    iRound = appBarLayout.getTopInset() + childAt.getMinimumHeight() + i4;
                } else {
                    iRound = Math.round(childAt.getHeight() * this.f39852m.f39862f) + i4;
                }
                H(coordinatorLayout, appBarLayout, iRound);
            }
            appBarLayout.f39840f = 0;
            this.f39852m = null;
            B(MathUtils.b(y(), -appBarLayout.getTotalScrollRange(), 0));
            O(coordinatorLayout, appBarLayout, y(), 0, true);
            appBarLayout.c(y());
            if (ViewCompat.e(coordinatorLayout) != null) {
                return true;
            }
            ViewCompat.z(coordinatorLayout, new AnonymousClass2(coordinatorLayout, this, appBarLayout));
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean o(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.w(i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
            L(coordinatorLayout, (AppBarLayout) view, view2, i3, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void r(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i4 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = G(coordinatorLayout2, appBarLayout, z() - i4, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i4 == 0 && ViewCompat.e(coordinatorLayout2) == null) {
                ViewCompat.z(coordinatorLayout2, new AnonymousClass2(coordinatorLayout2, this, appBarLayout));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void t(View view, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                this.f39852m = (SavedState) parcelable;
            } else {
                this.f39852m = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final Parcelable u(View view) {
            android.view.AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            SavedState savedStateM = M(absSavedState, (AppBarLayout) view);
            return savedStateM == null ? absSavedState : savedStateM;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i2 & 2) != 0 && (appBarLayout.f39846l || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z && (valueAnimator = this.f39851l) != null) {
                valueAnimator.cancel();
            }
            this.n = null;
            this.f39850k = i3;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f39850k == 0 || i2 == 1) {
                N(coordinatorLayout, appBarLayout);
                if (appBarLayout.f39846l) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.n = new WeakReference(view2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public final int z() {
            return y() + this.f39849j;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void a(int i2);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class ChildScrollEffect {
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f39864a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        public final Rect f39865b = new Rect();
    }

    public interface LiftOnScrollListener {
        void a();
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final AppBarLayout C(List list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final float D(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f2560a;
                int iZ = behavior instanceof BaseBehavior ? ((BaseBehavior) behavior).z() : 0;
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iZ > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iZ / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final int E(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : view.getMeasuredHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean h(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean j(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int iB;
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).f2560a;
            if (behavior instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f39849j + this.f39899e;
                if (this.f39900f == 0) {
                    iB = 0;
                } else {
                    float fD = D(view2);
                    int i2 = this.f39900f;
                    iB = MathUtils.b((int) (fD * i2), 0, i2);
                }
                int i3 = bottom - iB;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                view.offsetTopAndBottom(i3);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f39846l) {
                    appBarLayout.e(appBarLayout.f(view));
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void k(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                ViewCompat.z(coordinatorLayout, null);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean s(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayout;
            List listL = coordinatorLayout.l(view);
            int size = listL.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    appBarLayout = null;
                    break;
                }
                View view2 = (View) listL.get(i2);
                if (view2 instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) view2;
                    break;
                }
                i2++;
            }
            if (appBarLayout != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f39897c;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayout.d(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            this.f39900f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public static LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LayoutParams layoutParams2 = new LayoutParams((LinearLayout.LayoutParams) layoutParams);
            layoutParams2.f39866a = 1;
            return layoutParams2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams layoutParams3 = new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams3.f39866a = 1;
            return layoutParams3;
        }
        LayoutParams layoutParams4 = new LayoutParams(layoutParams);
        layoutParams4.f39866a = 1;
        return layoutParams4;
    }

    public final void b() {
        Behavior behavior = this.y;
        BaseBehavior.SavedState savedStateM = (behavior == null || this.f39836b == -1 || this.f39840f != 0) ? null : behavior.M(AbsSavedState.f3320b, this);
        this.f39836b = -1;
        this.f39837c = -1;
        this.f39838d = -1;
        if (savedStateM != null) {
            Behavior behavior2 = this.y;
            if (behavior2.f39852m != null) {
                return;
            }
            behavior2.f39852m = savedStateM;
        }
    }

    public final void c(int i2) {
        this.f39835a = i2;
        if (!willNotDraw()) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
        ArrayList arrayList = this.f39842h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = (BaseOnOffsetChangedListener) this.f39842h.get(i3);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.a(i2);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d(boolean z2, boolean z3, boolean z4) {
        this.f39840f = (z2 ? 1 : 2) | (z3 ? 4 : 0) | (z4 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.v == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f39835a);
        this.v.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.v;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z2) {
        if (this.f39843i || this.f39845k == z2) {
            return false;
        }
        this.f39845k = z2;
        refreshDrawableState();
        if (!(getBackground() instanceof MaterialShapeDrawable)) {
            return true;
        }
        if (this.o) {
            g(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f39846l) {
            return true;
        }
        float f2 = this.x;
        g(z2 ? 0.0f : f2, z2 ? f2 : 0.0f);
        return true;
    }

    public final boolean f(View view) {
        int i2;
        if (this.n == null && (i2 = this.f39847m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i2) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f39847m);
            }
            if (viewFindViewById != null) {
                this.n = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.n;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void g(float f2, float f3) {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, f3);
        this.p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.s);
        this.p.setInterpolator(this.t);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.q;
        if (animatorUpdateListener != null) {
            this.p.addUpdateListener(animatorUpdateListener);
        }
        this.p.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.y = behavior;
        return behavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getDownNestedPreScrollRange() {
        /*
            r11 = this;
            r0 = 5
            r1 = 8
            int r2 = r11.f39837c
            r3 = -1
            if (r2 == r3) goto L9
            return r2
        L9:
            int r2 = r11.getChildCount()
            int r2 = r2 + (-1)
            r4 = 0
            r5 = r4
        L11:
            if (r2 < 0) goto L68
            android.view.View r6 = r11.getChildAt(r2)
            int r7 = r6.getVisibility()
            if (r7 != r1) goto L1e
            goto L66
        L1e:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$LayoutParams r7 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r7
            int r8 = r6.getMeasuredHeight()
            int r9 = r7.f39866a
            r10 = r9 & 5
            if (r10 != r0) goto L63
            int r10 = r7.topMargin
            int r7 = r7.bottomMargin
            int r10 = r10 + r7
            r7 = r9 & 8
            if (r7 == 0) goto L3f
            java.util.WeakHashMap r7 = androidx.core.view.ViewCompat.f3080a
            int r7 = r6.getMinimumHeight()
        L3d:
            int r7 = r7 + r10
            goto L4e
        L3f:
            r7 = r9 & 2
            if (r7 == 0) goto L4c
            java.util.WeakHashMap r7 = androidx.core.view.ViewCompat.f3080a
            int r7 = r6.getMinimumHeight()
            int r7 = r8 - r7
            goto L3d
        L4c:
            int r7 = r10 + r8
        L4e:
            if (r2 != 0) goto L61
            java.util.WeakHashMap r9 = androidx.core.view.ViewCompat.f3080a
            boolean r6 = r6.getFitsSystemWindows()
            if (r6 == 0) goto L61
            int r6 = r11.getTopInset()
            int r8 = r8 - r6
            int r7 = java.lang.Math.min(r7, r8)
        L61:
            int r5 = r5 + r7
            goto L66
        L63:
            if (r5 <= 0) goto L66
            goto L68
        L66:
            int r2 = r2 + r3
            goto L11
        L68:
            int r0 = java.lang.Math.max(r4, r5)
            r11.f39837c = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f39838d;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                int i4 = layoutParams.f39866a;
                if ((i4 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i4 & 2) != 0) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f39838d = iMax;
        return iMax;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.f39847m;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            return (MaterialShapeDrawable) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f39840f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.v;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f39841g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.j();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f39836b;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = layoutParams.f39866a;
                if ((i4 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + minimumHeight;
                if (i3 == 0) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    if (childAt.getFitsSystemWindows()) {
                        topInset -= getTopInset();
                    }
                }
                minimumHeight = topInset;
                if ((i4 & 2) != 0) {
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f39836b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.d(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        if (this.u == null) {
            this.u = new int[4];
        }
        int[] iArr = this.u;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z2 = this.f39844j;
        int i3 = R.attr.state_liftable;
        if (!z2) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (z2 && this.f39845k) ? R.attr.state_lifted : -R.attr.state_lifted;
        int i4 = R.attr.state_collapsible;
        if (!z2) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (z2 && this.f39845k) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3 = true;
        super.onLayout(z2, i2, i3, i4, i5);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    getChildAt(childCount).offsetTopAndBottom(topInset);
                }
            }
        }
        b();
        this.f39839e = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i6).getLayoutParams()).f39868c != null) {
                this.f39839e = true;
                break;
            }
            i6++;
        }
        Drawable drawable = this.v;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f39843i) {
            return;
        }
        if (!this.f39846l) {
            int childCount3 = getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 >= childCount3) {
                    z3 = false;
                    break;
                }
                int i8 = ((LayoutParams) getChildAt(i7).getLayoutParams()).f39866a;
                if ((i8 & 1) == 1 && (i8 & 10) != 0) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        if (this.f39844j != z3) {
            this.f39844j = z3;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (getFitsSystemWindows() && getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                    int measuredHeight = getMeasuredHeight();
                    if (mode == Integer.MIN_VALUE) {
                        measuredHeight = MathUtils.b(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i3));
                    } else if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                }
            }
        }
        b();
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.b(this, f2);
    }

    public void setExpanded(boolean z2) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        d(z2, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z2) {
        this.f39846l = z2;
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.f39847m = -1;
        if (view != null) {
            this.n = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        this.f39847m = i2;
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    public void setLiftableOverrideEnabled(boolean z2) {
        this.f39843i = z2;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i2);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.v;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.v = drawableMutate;
            if (drawableMutate instanceof MaterialShapeDrawable) {
                numValueOf = Integer.valueOf(((MaterialShapeDrawable) drawableMutate).u);
            } else {
                ColorStateList colorStateListD = DrawableUtils.d(drawableMutate);
                if (colorStateListD != null) {
                    numValueOf = Integer.valueOf(colorStateListD.getDefaultColor());
                }
            }
            this.w = numValueOf;
            Drawable drawable3 = this.v;
            boolean z2 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                Drawable drawable4 = this.v;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                drawable4.setLayoutDirection(getLayoutDirection());
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            if (this.v != null && getTopInset() > 0) {
                z2 = true;
            }
            setWillNotDraw(!z2);
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        setStatusBarForeground(AppCompatResources.b(i2, getContext()));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        ViewUtilsLollipop.a(this, f2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.v;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Integer numValueOf;
        int i3 = z;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f39836b = -1;
        this.f39837c = -1;
        this.f39838d = -1;
        this.f39840f = 0;
        this.r = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i4 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayD = ThemeEnforcement.d(context3, attributeSet, ViewUtilsLollipop.f39907a, i2, i3, new int[0]);
        try {
            if (typedArrayD.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayD.getResourceId(0, 0)));
            }
            typedArrayD.recycle();
            TypedArray typedArrayD2 = ThemeEnforcement.d(context2, attributeSet, R.styleable.AppBarLayout, i2, i3, new int[0]);
            Drawable drawable = typedArrayD2.getDrawable(R.styleable.AppBarLayout_android_background);
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            setBackground(drawable);
            final ColorStateList colorStateListA = MaterialResources.a(context2, typedArrayD2, R.styleable.AppBarLayout_liftOnScrollColor);
            this.o = colorStateListA != null;
            final ColorStateList colorStateListD = DrawableUtils.d(getBackground());
            if (colorStateListD != null) {
                final MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
                materialShapeDrawable.m(colorStateListD);
                if (colorStateListA != null) {
                    Context context4 = getContext();
                    TypedValue typedValueA = MaterialAttributes.a(R.attr.colorSurface, context4);
                    if (typedValueA != null) {
                        int i5 = typedValueA.resourceId;
                        numValueOf = Integer.valueOf(i5 != 0 ? context4.getColor(i5) : typedValueA.data);
                    } else {
                        numValueOf = null;
                    }
                    final Integer num = numValueOf;
                    this.q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Integer num2;
                            int i6 = AppBarLayout.z;
                            AppBarLayout appBarLayout = this.f39908a;
                            int iG = MaterialColors.g(((Float) valueAnimator.getAnimatedValue()).floatValue(), colorStateListD.getDefaultColor(), colorStateListA.getDefaultColor());
                            ColorStateList colorStateListValueOf = ColorStateList.valueOf(iG);
                            MaterialShapeDrawable materialShapeDrawable2 = materialShapeDrawable;
                            materialShapeDrawable2.m(colorStateListValueOf);
                            if (appBarLayout.v != null && (num2 = appBarLayout.w) != null && num2.equals(num)) {
                                appBarLayout.v.setTint(iG);
                            }
                            ArrayList arrayList = appBarLayout.r;
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                AppBarLayout.LiftOnScrollListener liftOnScrollListener = (AppBarLayout.LiftOnScrollListener) it.next();
                                if (materialShapeDrawable2.f40974a.f40991c != null) {
                                    liftOnScrollListener.a();
                                }
                            }
                        }
                    };
                    setBackground(materialShapeDrawable);
                } else {
                    materialShapeDrawable.k(context2);
                    this.q = new h(1, this, materialShapeDrawable);
                    setBackground(materialShapeDrawable);
                }
            }
            this.s = MotionUtils.c(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.t = MotionUtils.d(context2, R.attr.motionEasingStandardInterpolator, AnimationUtils.f39816a);
            if (typedArrayD2.hasValue(R.styleable.AppBarLayout_expanded)) {
                d(typedArrayD2.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
            }
            if (typedArrayD2.hasValue(R.styleable.AppBarLayout_elevation)) {
                ViewUtilsLollipop.a(this, typedArrayD2.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
            }
            if (i4 >= 26) {
                if (typedArrayD2.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                    setKeyboardNavigationCluster(typedArrayD2.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
                }
                if (typedArrayD2.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                    setTouchscreenBlocksFocus(typedArrayD2.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
                }
            }
            this.x = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.f39846l = typedArrayD2.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
            this.f39847m = typedArrayD2.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
            setStatusBarForeground(typedArrayD2.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
            typedArrayD2.recycle();
            ViewCompat.H(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.appbar.AppBarLayout.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                    AppBarLayout appBarLayout = AppBarLayout.this;
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    WindowInsetsCompat windowInsetsCompat2 = appBarLayout.getFitsSystemWindows() ? windowInsetsCompat : null;
                    if (!Objects.equals(appBarLayout.f39841g, windowInsetsCompat2)) {
                        appBarLayout.f39841g = windowInsetsCompat2;
                        appBarLayout.setWillNotDraw(!(appBarLayout.v != null && appBarLayout.getTopInset() > 0));
                        appBarLayout.requestLayout();
                    }
                    return windowInsetsCompat;
                }
            });
        } catch (Throwable th) {
            typedArrayD.recycle();
            throw th;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f39866a;

        /* renamed from: b, reason: collision with root package name */
        public final CompressChildScrollEffect f39867b;

        /* renamed from: c, reason: collision with root package name */
        public final Interpolator f39868c;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f39866a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f39866a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            this.f39867b = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0) != 1 ? null : new CompressChildScrollEffect();
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f39868c = android.view.animation.AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -2);
            this.f39866a = 1;
        }
    }
}
