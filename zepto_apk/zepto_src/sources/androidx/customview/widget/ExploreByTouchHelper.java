package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayCompatKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {

    /* renamed from: k, reason: collision with root package name */
    public static final Rect f3322k = new Rect(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    public static final FocusStrategy.BoundsAdapter f3323l = new AnonymousClass1();

    /* renamed from: m, reason: collision with root package name */
    public static final FocusStrategy.CollectionAdapter f3324m = new AnonymousClass2();

    /* renamed from: e, reason: collision with root package name */
    public final AccessibilityManager f3329e;

    /* renamed from: f, reason: collision with root package name */
    public final View f3330f;

    /* renamed from: g, reason: collision with root package name */
    public MyNodeProvider f3331g;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f3325a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f3326b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final Rect f3327c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f3328d = new int[2];

    /* renamed from: h, reason: collision with root package name */
    public int f3332h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public int f3333i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f3334j = Integer.MIN_VALUE;

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
        public final void a(Object obj, Rect rect) {
            ((AccessibilityNodeInfoCompat) obj).g(rect);
        }
    }

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
        public final AccessibilityNodeInfoCompat a(SparseArrayCompat sparseArrayCompat, int i2) {
            return (AccessibilityNodeInfoCompat) sparseArrayCompat.f1607b[i2];
        }
    }

    /* loaded from: classes3.dex */
    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        public MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public final AccessibilityNodeInfoCompat a(int i2) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.i(i2).f3185a));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public final AccessibilityNodeInfoCompat b(int i2) {
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            int i3 = i2 == 2 ? exploreByTouchHelper.f3332h : exploreByTouchHelper.f3333i;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i3);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public final boolean d(int i2, int i3, Bundle bundle) {
            int i4;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            View view = exploreByTouchHelper.f3330f;
            if (i2 == -1) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                return view.performAccessibilityAction(i3, bundle);
            }
            if (i3 == 1) {
                return exploreByTouchHelper.n(i2);
            }
            if (i3 == 2) {
                return exploreByTouchHelper.a(i2);
            }
            if (i3 != 64) {
                if (i3 != 128) {
                    return exploreByTouchHelper.j(i2, i3, bundle);
                }
                if (exploreByTouchHelper.f3332h != i2) {
                    return false;
                }
                exploreByTouchHelper.f3332h = Integer.MIN_VALUE;
                view.invalidate();
                exploreByTouchHelper.o(i2, 65536);
                return true;
            }
            AccessibilityManager accessibilityManager = exploreByTouchHelper.f3329e;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i4 = exploreByTouchHelper.f3332h) == i2) {
                return false;
            }
            if (i4 != Integer.MIN_VALUE) {
                exploreByTouchHelper.f3332h = Integer.MIN_VALUE;
                view.invalidate();
                exploreByTouchHelper.o(i4, 65536);
            }
            exploreByTouchHelper.f3332h = i2;
            view.invalidate();
            exploreByTouchHelper.o(i2, 32768);
            return true;
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f3330f = view;
        this.f3329e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public final boolean a(int i2) {
        if (this.f3333i != i2) {
            return false;
        }
        this.f3333i = Integer.MIN_VALUE;
        m(i2, false);
        o(i2, 8);
        return true;
    }

    public final AccessibilityEvent b(int i2, int i3) {
        View view = this.f3330f;
        if (i2 == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i3);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatI = i(i2);
        accessibilityEventObtain2.getText().add(accessibilityNodeInfoCompatI.i());
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompatI.f3185a;
        accessibilityEventObtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityEventObtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityEventObtain2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityEventObtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityEventObtain2.setChecked(accessibilityNodeInfo.isChecked());
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(accessibilityNodeInfo.getClassName());
        AccessibilityRecordCompat.a(accessibilityEventObtain2, view, i2);
        accessibilityEventObtain2.setPackageName(view.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    public final AccessibilityNodeInfoCompat c(int i2) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        accessibilityNodeInfoCompat.m("android.view.View");
        Rect rect = f3322k;
        accessibilityNodeInfoCompat.l(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        View view = this.f3330f;
        accessibilityNodeInfoObtain.setParent(view);
        l(i2, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat.i() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f3326b;
        accessibilityNodeInfoCompat.g(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(view.getContext().getPackageName());
        accessibilityNodeInfoCompat.f3186b = i2;
        accessibilityNodeInfoObtain.setSource(view, i2);
        if (this.f3332h == i2) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.a(64);
        }
        boolean z = this.f3333i == i2;
        if (z) {
            accessibilityNodeInfoCompat.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            accessibilityNodeInfoCompat.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.f3328d;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f3325a;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            accessibilityNodeInfoCompat.g(rect3);
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f3327c;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfoCompat.f3185a.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return accessibilityNodeInfoCompat;
    }

    public final boolean d(MotionEvent motionEvent) {
        int i2;
        AccessibilityManager accessibilityManager = this.f3329e;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iE = e(motionEvent.getX(), motionEvent.getY());
            int i3 = this.f3334j;
            if (i3 != iE) {
                this.f3334j = iE;
                o(iE, 128);
                o(i3, 256);
            }
            if (iE == Integer.MIN_VALUE) {
                return false;
            }
        } else {
            if (action != 10 || (i2 = this.f3334j) == Integer.MIN_VALUE) {
                return false;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f3334j = Integer.MIN_VALUE;
                o(i2, 256);
                return true;
            }
        }
        return true;
    }

    public abstract int e(float f2, float f3);

    public abstract void f(ArrayList arrayList);

    public final void g(int i2) {
        View view;
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f3329e.isEnabled() || (parent = (view = this.f3330f).getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventB = b(i2, 2048);
        AccessibilityEventCompat.a(accessibilityEventB);
        parent.requestSendAccessibilityEvent(view, accessibilityEventB);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f3331g == null) {
            this.f3331g = new MyNodeProvider();
        }
        return this.f3331g;
    }

    public final boolean h(int i2, Rect rect) {
        SparseArrayCompat sparseArrayCompat;
        int i3;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        ArrayList arrayList = new ArrayList();
        f(arrayList);
        SparseArrayCompat sparseArrayCompat2 = new SparseArrayCompat();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            sparseArrayCompat2.c(((Integer) arrayList.get(i4)).intValue(), c(((Integer) arrayList.get(i4)).intValue()));
        }
        int i5 = this.f3333i;
        int i6 = Integer.MIN_VALUE;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i5 == Integer.MIN_VALUE ? null : (AccessibilityNodeInfoCompat) SparseArrayCompatKt.a(sparseArrayCompat2, i5);
        FocusStrategy.BoundsAdapter boundsAdapter = f3323l;
        FocusStrategy.CollectionAdapter collectionAdapter = f3324m;
        int i7 = -1;
        View view = this.f3330f;
        if (i2 == 1 || i2 == 2) {
            sparseArrayCompat = sparseArrayCompat2;
            i3 = 0;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.d(sparseArrayCompat, collectionAdapter, boundsAdapter, accessibilityNodeInfoCompat2, i2, view.getLayoutDirection() == 1);
        } else {
            if (i2 != 17 && i2 != 33 && i2 != 66 && i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i8 = this.f3333i;
            if (i8 != Integer.MIN_VALUE) {
                i(i8).g(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                int width = view.getWidth();
                int height = view.getHeight();
                if (i2 == 17) {
                    i3 = 0;
                    rect2.set(width, 0, width, height);
                } else if (i2 == 33) {
                    i3 = 0;
                    rect2.set(0, height, width, height);
                } else if (i2 == 66) {
                    i3 = 0;
                    rect2.set(-1, 0, -1, height);
                } else {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i3 = 0;
                    rect2.set(0, -1, width, -1);
                }
                sparseArrayCompat = sparseArrayCompat2;
                accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.c(sparseArrayCompat, collectionAdapter, boundsAdapter, accessibilityNodeInfoCompat2, rect2, i2);
            }
            sparseArrayCompat = sparseArrayCompat2;
            i3 = 0;
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.c(sparseArrayCompat, collectionAdapter, boundsAdapter, accessibilityNodeInfoCompat2, rect2, i2);
        }
        if (accessibilityNodeInfoCompat != null) {
            int i9 = sparseArrayCompat.f1608c;
            int i10 = i3;
            while (true) {
                if (i10 >= i9) {
                    break;
                }
                if (sparseArrayCompat.f1607b[i10] == accessibilityNodeInfoCompat) {
                    i7 = i10;
                    break;
                }
                i10++;
            }
            i6 = sparseArrayCompat.f1606a[i7];
        }
        return n(i6);
    }

    public final AccessibilityNodeInfoCompat i(int i2) {
        if (i2 != -1) {
            return c(i2);
        }
        View view = this.f3330f;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        f(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            accessibilityNodeInfoCompat.f3185a.addChild(view, ((Integer) arrayList.get(i3)).intValue());
        }
        return accessibilityNodeInfoCompat;
    }

    public abstract boolean j(int i2, int i3, Bundle bundle);

    public void k(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void l(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void m(int i2, boolean z) {
    }

    public final boolean n(int i2) {
        int i3;
        View view = this.f3330f;
        if ((!view.isFocused() && !view.requestFocus()) || (i3 = this.f3333i) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        if (i2 == Integer.MIN_VALUE) {
            return false;
        }
        this.f3333i = i2;
        m(i2, true);
        o(i2, 8);
        return true;
    }

    public final void o(int i2, int i3) {
        View view;
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f3329e.isEnabled() || (parent = (view = this.f3330f).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, b(i2, i3));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        k(accessibilityNodeInfoCompat);
    }
}
