package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    public static final int[] D = {R.attr.colorPrimaryDark};
    public static final int[] E = {R.attr.layout_gravity};
    public static final boolean F;
    public static final boolean G;
    public static final boolean H;
    public Rect A;
    public Matrix B;
    public final AccessibilityViewCommand C;

    /* renamed from: a, reason: collision with root package name */
    public final ChildAccessibilityDelegate f4222a;

    /* renamed from: b, reason: collision with root package name */
    public float f4223b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4224c;

    /* renamed from: d, reason: collision with root package name */
    public int f4225d;

    /* renamed from: e, reason: collision with root package name */
    public float f4226e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f4227f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewDragHelper f4228g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewDragHelper f4229h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewDragCallback f4230i;

    /* renamed from: j, reason: collision with root package name */
    public final ViewDragCallback f4231j;

    /* renamed from: k, reason: collision with root package name */
    public int f4232k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4233l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4234m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public DrawerListener s;
    public ArrayList t;
    public float u;
    public float v;
    public Drawable w;
    public WindowInsets x;
    public boolean y;
    public final ArrayList z;

    /* loaded from: classes3.dex */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f4236a = new Rect();

        public AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            accessibilityEvent.getText();
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewG = drawerLayout.g();
            if (viewG == null) {
                return true;
            }
            int i2 = drawerLayout.i(viewG);
            drawerLayout.getClass();
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            GravityCompat.a(i2, drawerLayout.getLayoutDirection());
            return true;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z = DrawerLayout.F;
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
            if (z) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                super.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain));
                accessibilityNodeInfoCompat.f3186b = -1;
                accessibilityNodeInfo.setSource(view);
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                Object parentForAccessibility = view.getParentForAccessibility();
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfo.setParent((View) parentForAccessibility);
                }
                Rect rect = this.f4236a;
                accessibilityNodeInfoObtain.getBoundsInScreen(rect);
                accessibilityNodeInfo.setBoundsInScreen(rect);
                accessibilityNodeInfo.setVisibleToUser(accessibilityNodeInfoObtain.isVisibleToUser());
                accessibilityNodeInfo.setPackageName(accessibilityNodeInfoObtain.getPackageName());
                accessibilityNodeInfoCompat.m(accessibilityNodeInfoObtain.getClassName());
                accessibilityNodeInfoCompat.q(accessibilityNodeInfoObtain.getContentDescription());
                accessibilityNodeInfo.setEnabled(accessibilityNodeInfoObtain.isEnabled());
                accessibilityNodeInfo.setFocused(accessibilityNodeInfoObtain.isFocused());
                accessibilityNodeInfo.setAccessibilityFocused(accessibilityNodeInfoObtain.isAccessibilityFocused());
                accessibilityNodeInfo.setSelected(accessibilityNodeInfoObtain.isSelected());
                accessibilityNodeInfoCompat.a(accessibilityNodeInfoObtain.getActions());
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (DrawerLayout.k(childAt)) {
                        accessibilityNodeInfo.addChild(childAt);
                    }
                }
            }
            accessibilityNodeInfoCompat.m("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfo.setFocusable(false);
            accessibilityNodeInfo.setFocused(false);
            accessibilityNodeInfoCompat.j(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3187e);
            accessibilityNodeInfoCompat.j(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3188f);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.F || DrawerLayout.k(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (DrawerLayout.k(view)) {
                return;
            }
            accessibilityNodeInfoCompat.f3185a.setParent(null);
        }
    }

    /* loaded from: classes3.dex */
    public interface DrawerListener {
        void a(View view);

        void b(View view);

        void c(int i2);

        void d(View view, float f2);
    }

    /* loaded from: classes3.dex */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void a(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void b(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public final void c(int i2) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public final void d(View view, float f2) {
        }
    }

    /* loaded from: classes3.dex */
    public class ViewDragCallback extends ViewDragHelper.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final int f4247a;

        /* renamed from: b, reason: collision with root package name */
        public ViewDragHelper f4248b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f4249c = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public final void run() {
                View viewE;
                int width;
                ViewDragCallback viewDragCallback = ViewDragCallback.this;
                int i2 = viewDragCallback.f4248b.o;
                int i3 = viewDragCallback.f4247a;
                boolean z = i3 == 3;
                DrawerLayout drawerLayout = DrawerLayout.this;
                if (z) {
                    viewE = drawerLayout.e(3);
                    width = (viewE != null ? -viewE.getWidth() : 0) + i2;
                } else {
                    viewE = drawerLayout.e(5);
                    width = drawerLayout.getWidth() - i2;
                }
                if (viewE != null) {
                    if (((!z || viewE.getLeft() >= width) && (z || viewE.getLeft() <= width)) || drawerLayout.h(viewE) != 0) {
                        return;
                    }
                    LayoutParams layoutParams = (LayoutParams) viewE.getLayoutParams();
                    viewDragCallback.f4248b.A(viewE, width, viewE.getTop());
                    layoutParams.f4240c = true;
                    drawerLayout.invalidate();
                    View viewE2 = drawerLayout.e(i3 == 3 ? 5 : 3);
                    if (viewE2 != null) {
                        drawerLayout.c(viewE2, true);
                    }
                    if (drawerLayout.r) {
                        return;
                    }
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        drawerLayout.getChildAt(i4).dispatchTouchEvent(motionEventObtain);
                    }
                    motionEventObtain.recycle();
                    drawerLayout.r = true;
                }
            }
        };

        public ViewDragCallback(int i2) {
            this.f4247a = i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int a(int i2, View view) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            if (drawerLayout.b(3, view)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = drawerLayout.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int b(int i2, View view) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int c(View view) {
            if (DrawerLayout.n(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void e(int i2, int i3) {
            int i4 = i2 & 1;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewE = i4 == 1 ? drawerLayout.e(3) : drawerLayout.e(5);
            if (viewE == null || drawerLayout.h(viewE) != 0) {
                return;
            }
            this.f4248b.b(i3, viewE);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void f() {
            DrawerLayout.this.postDelayed(this.f4249c, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void g(int i2, View view) {
            ((LayoutParams) view.getLayoutParams()).f4240c = false;
            int i3 = this.f4247a == 3 ? 5 : 3;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewE = drawerLayout.e(i3);
            if (viewE != null) {
                drawerLayout.c(viewE, true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void h(int i2) {
            DrawerLayout.this.t(i2, this.f4248b.t);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void i(View view, int i2, int i3) {
            int width = view.getWidth();
            DrawerLayout drawerLayout = DrawerLayout.this;
            float width2 = (drawerLayout.b(3, view) ? i2 + width : drawerLayout.getWidth() - i2) / width;
            drawerLayout.q(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            drawerLayout.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void j(View view, float f2, float f3) {
            int i2;
            DrawerLayout drawerLayout = DrawerLayout.this;
            int[] iArr = DrawerLayout.D;
            float f4 = ((LayoutParams) view.getLayoutParams()).f4239b;
            int width = view.getWidth();
            if (drawerLayout.b(3, view)) {
                i2 = (f2 > 0.0f || (f2 == 0.0f && f4 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = drawerLayout.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && f4 > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f4248b.y(i2, view.getTop());
            drawerLayout.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean k(int i2, View view) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            return DrawerLayout.n(view) && drawerLayout.b(this.f4247a, view) && drawerLayout.h(view) == 0;
        }

        public final void l() {
            DrawerLayout.this.removeCallbacks(this.f4249c);
        }

        public final void m(ViewDragHelper viewDragHelper) {
            this.f4248b = viewDragHelper;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        F = true;
        G = true;
        H = i2 >= 29;
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public static String j(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    public static boolean k(View view) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) ? false : true;
    }

    public static boolean l(View view) {
        return ((LayoutParams) view.getLayoutParams()).f4238a == 0;
    }

    public static boolean m(View view) {
        if (n(view)) {
            return (((LayoutParams) view.getLayoutParams()).f4241d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean n(View view) {
        int i2 = ((LayoutParams) view.getLayoutParams()).f4238a;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int iA = GravityCompat.a(i2, view.getLayoutDirection());
        return ((iA & 3) == 0 && (iA & 5) == 0) ? false : true;
    }

    public final void a(DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i4 = 0;
        boolean z = false;
        while (true) {
            arrayList2 = this.z;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (!n(childAt)) {
                arrayList2.add(childAt);
            } else if (m(childAt)) {
                childAt.addFocusables(arrayList, i2, i3);
                z = true;
            }
            i4++;
        }
        if (!z) {
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = (View) arrayList2.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i2, i3);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (f() != null || n(view)) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            view.setImportantForAccessibility(4);
        } else {
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            view.setImportantForAccessibility(1);
        }
        if (F) {
            return;
        }
        ViewCompat.z(view, this.f4222a);
    }

    public final boolean b(int i2, View view) {
        return (i(view) & i2) == i2;
    }

    public final void c(View view, boolean z) {
        if (!n(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f4234m) {
            layoutParams.f4239b = 0.0f;
            layoutParams.f4241d = 0;
        } else if (z) {
            layoutParams.f4241d |= 4;
            if (b(3, view)) {
                this.f4228g.A(view, -view.getWidth(), view.getTop());
            } else {
                this.f4229h.A(view, getWidth(), view.getTop());
            }
        } else {
            float f2 = ((LayoutParams) view.getLayoutParams()).f4239b;
            float width = view.getWidth();
            int i2 = ((int) (width * 0.0f)) - ((int) (f2 * width));
            if (!b(3, view)) {
                i2 = -i2;
            }
            view.offsetLeftAndRight(i2);
            q(view, 0.0f);
            t(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i2).getLayoutParams()).f4239b);
        }
        this.f4226e = fMax;
        boolean zH = this.f4228g.h();
        boolean zH2 = this.f4229h.h();
        if (zH || zH2) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    public final void d(boolean z) {
        int childCount = getChildCount();
        boolean zA = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (n(childAt) && (!z || layoutParams.f4240c)) {
                zA |= b(3, childAt) ? this.f4228g.A(childAt, -childAt.getWidth(), childAt.getTop()) : this.f4229h.A(childAt, getWidth(), childAt.getTop());
                layoutParams.f4240c = false;
            }
        }
        this.f4230i.l();
        this.f4231j.l();
        if (zA) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f4226e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (this.A == null) {
                this.A = new Rect();
            }
            childAt.getHitRect(this.A);
            if (this.A.contains((int) x, (int) y) && !l(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.B == null) {
                            this.B = new Matrix();
                        }
                        matrix.invert(this.B);
                        motionEventObtain.transform(this.B);
                    }
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zDispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        Drawable background;
        int height = getHeight();
        boolean zL = l(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i2 = 0;
        if (zL) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && n(childAt) && childAt.getHeight() >= height) {
                    if (b(3, childAt)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(iSave);
        float f2 = this.f4226e;
        if (f2 > 0.0f && zL) {
            int i5 = this.f4225d;
            Paint paint = this.f4227f;
            paint.setColor((((int) ((((-16777216) & i5) >>> 24) * f2)) << 24) | (i5 & 16777215));
            canvas.drawRect(i2, 0.0f, width, getHeight(), paint);
        }
        return zDrawChild;
    }

    public final View e(int i2) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int iA = GravityCompat.a(i2, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((i(childAt) & 7) == iA) {
                return childAt;
            }
        }
        return null;
    }

    public final View f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).f4241d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View g() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (n(childAt)) {
                if (!n(childAt)) {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                if (((LayoutParams) childAt.getLayoutParams()).f4239b > 0.0f) {
                    return childAt;
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (G) {
            return this.f4223b;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.w;
    }

    public final int h(View view) {
        if (!n(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        int i2 = ((LayoutParams) view.getLayoutParams()).f4238a;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int layoutDirection = getLayoutDirection();
        if (i2 == 3) {
            int i3 = this.n;
            if (i3 != 3) {
                return i3;
            }
            int i4 = layoutDirection == 0 ? this.p : this.q;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        }
        if (i2 == 5) {
            int i5 = this.o;
            if (i5 != 3) {
                return i5;
            }
            int i6 = layoutDirection == 0 ? this.q : this.p;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (i2 == 8388611) {
            int i7 = this.p;
            if (i7 != 3) {
                return i7;
            }
            int i8 = layoutDirection == 0 ? this.n : this.o;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (i2 != 8388613) {
            return 0;
        }
        int i9 = this.q;
        if (i9 != 3) {
            return i9;
        }
        int i10 = layoutDirection == 0 ? this.o : this.n;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    public final int i(View view) {
        int i2 = ((LayoutParams) view.getLayoutParams()).f4238a;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return GravityCompat.a(i2, getLayoutDirection());
    }

    public final void o(View view) {
        if (!n(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f4234m) {
            layoutParams.f4239b = 1.0f;
            layoutParams.f4241d = 1;
            s(view, true);
            r(view);
        } else {
            layoutParams.f4241d |= 2;
            if (b(3, view)) {
                this.f4228g.A(view, 0, view.getTop());
            } else {
                this.f4229h.A(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4234m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4234m = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.y || this.w == null) {
            return;
        }
        WindowInsets windowInsets = this.x;
        int systemWindowInsetTop = windowInsets != null ? windowInsets.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.w.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r7.f4228g
            boolean r2 = r1.z(r8)
            androidx.customview.widget.ViewDragHelper r3 = r7.f4229h
            boolean r3 = r3.z(r8)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L36
            if (r0 == r3) goto L2f
            r8 = 2
            if (r0 == r8) goto L1e
            r8 = 3
            if (r0 == r8) goto L2f
            goto L34
        L1e:
            boolean r8 = r1.d()
            if (r8 == 0) goto L34
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r8 = r7.f4230i
            r8.l()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r8 = r7.f4231j
            r8.l()
            goto L34
        L2f:
            r7.d(r3)
            r7.r = r4
        L34:
            r8 = r4
            goto L5c
        L36:
            float r0 = r8.getX()
            float r8 = r8.getY()
            r7.u = r0
            r7.v = r8
            float r5 = r7.f4226e
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L59
            int r0 = (int) r0
            int r8 = (int) r8
            android.view.View r8 = r1.j(r0, r8)
            if (r8 == 0) goto L59
            boolean r8 = l(r8)
            if (r8 == 0) goto L59
            r8 = r3
            goto L5a
        L59:
            r8 = r4
        L5a:
            r7.r = r4
        L5c:
            if (r2 != 0) goto L7f
            if (r8 != 0) goto L7f
            int r8 = r7.getChildCount()
            r0 = r4
        L65:
            if (r0 >= r8) goto L79
            android.view.View r1 = r7.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r1 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r1
            boolean r1 = r1.f4240c
            if (r1 == 0) goto L76
            goto L7f
        L76:
            int r0 = r0 + 1
            goto L65
        L79:
            boolean r8 = r7.r
            if (r8 == 0) goto L7e
            goto L7f
        L7e:
            return r4
        L7f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || g() == null) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View viewG = g();
        if (viewG != null && h(viewG) == 0) {
            d(false);
        }
        return viewG != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        WindowInsets rootWindowInsets;
        float f2;
        int i6;
        boolean z2 = true;
        this.f4233l = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (l(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(3, childAt)) {
                        float f3 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.f4239b * f3));
                        f2 = (measuredWidth + i6) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i7 - r11) / f4;
                        i6 = i7 - ((int) (layoutParams.f4239b * f4));
                    }
                    boolean z3 = f2 != layoutParams.f4239b ? z2 : false;
                    int i10 = layoutParams.f4238a & 112;
                    if (i10 == 16) {
                        int i11 = i5 - i3;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = i11 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i14 > i15) {
                                i12 = i15 - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i6, i16, measuredWidth + i6, measuredHeight + i16);
                    } else {
                        int i17 = i5 - i3;
                        childAt.layout(i6, (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z3) {
                        q(childAt, f2);
                    }
                    int i18 = layoutParams.f4239b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
            i8++;
            z2 = true;
        }
        if (H && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets insetsF = WindowInsetsCompat.r(null, rootWindowInsets).f();
            ViewDragHelper viewDragHelper = this.f4228g;
            viewDragHelper.v(Math.max(viewDragHelper.l(), insetsF.f2808a));
            ViewDragHelper viewDragHelper2 = this.f4229h;
            viewDragHelper2.v(Math.max(viewDragHelper2.l(), insetsF.f2810c));
        }
        this.f4233l = false;
        this.f4234m = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r19, int r20) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View viewE;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i2 = savedState.f4242c;
        if (i2 != 0 && (viewE = e(i2)) != null) {
            o(viewE);
        }
        int i3 = savedState.f4243d;
        if (i3 != 3) {
            p(i3, 3);
        }
        int i4 = savedState.f4244e;
        if (i4 != 3) {
            p(i4, 5);
        }
        int i5 = savedState.f4245f;
        if (i5 != 3) {
            p(i5, 8388611);
        }
        int i6 = savedState.f4246g;
        if (i6 != 3) {
            p(i6, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        if (G) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        getLayoutDirection();
        getLayoutDirection();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int i3 = layoutParams.f4241d;
            boolean z = i3 == 1;
            boolean z2 = i3 == 2;
            if (z || z2) {
                savedState.f4242c = layoutParams.f4238a;
                break;
            }
        }
        savedState.f4243d = this.n;
        savedState.f4244e = this.o;
        savedState.f4245f = this.p;
        savedState.f4246g = this.q;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.f4228g
            r0.p(r7)
            androidx.customview.widget.ViewDragHelper r1 = r6.f4229h
            r1.p(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L5b
            if (r1 == r3) goto L20
            r7 = 3
            if (r1 == r7) goto L1a
            return r3
        L1a:
            r6.d(r3)
            r6.r = r2
            return r3
        L20:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.j(r4, r5)
            if (r4 == 0) goto L56
            boolean r4 = l(r4)
            if (r4 == 0) goto L56
            float r4 = r6.u
            float r1 = r1 - r4
            float r4 = r6.v
            float r7 = r7 - r4
            int r0 = r0.m()
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L56
            android.view.View r7 = r6.f()
            if (r7 == 0) goto L56
            int r7 = r6.h(r7)
            r0 = 2
            if (r7 != r0) goto L57
        L56:
            r2 = r3
        L57:
            r6.d(r2)
            return r3
        L5b:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.u = r0
            r6.v = r7
            r6.r = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i2, int i3) {
        View viewE;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int iA = GravityCompat.a(i3, getLayoutDirection());
        if (i3 == 3) {
            this.n = i2;
        } else if (i3 == 5) {
            this.o = i2;
        } else if (i3 == 8388611) {
            this.p = i2;
        } else if (i3 == 8388613) {
            this.q = i2;
        }
        if (i2 != 0) {
            (iA == 3 ? this.f4228g : this.f4229h).a();
        }
        if (i2 != 1) {
            if (i2 == 2 && (viewE = e(iA)) != null) {
                o(viewE);
                return;
            }
            return;
        }
        View viewE2 = e(iA);
        if (viewE2 != null) {
            c(viewE2, true);
        }
    }

    public final void q(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 == layoutParams.f4239b) {
            return;
        }
        layoutParams.f4239b = f2;
        ArrayList arrayList = this.t;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((DrawerListener) this.t.get(size)).d(view, f2);
            }
        }
    }

    public final void r(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3195m;
        ViewCompat.v(accessibilityActionCompat.a(), view);
        ViewCompat.s(0, view);
        if (!m(view) || h(view) == 2) {
            return;
        }
        ViewCompat.w(view, accessibilityActionCompat, null, this.C);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            d(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f4233l) {
            return;
        }
        super.requestLayout();
    }

    public final void s(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z || n(childAt)) && !(z && childAt == view)) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                childAt.setImportantForAccessibility(4);
            } else {
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    public void setDrawerElevation(float f2) {
        this.f4223b = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (n(childAt)) {
                ViewCompat.E(childAt, this.f4223b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        ArrayList arrayList;
        DrawerListener drawerListener2 = this.s;
        if (drawerListener2 != null && (arrayList = this.t) != null) {
            arrayList.remove(drawerListener2);
        }
        if (drawerListener != null) {
            a(drawerListener);
        }
        this.s = drawerListener;
    }

    public void setDrawerLockMode(int i2) {
        p(i2, 3);
        p(i2, 5);
    }

    public void setScrimColor(@ColorInt int i2) {
        this.f4225d = i2;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        this.w = new ColorDrawable(i2);
        invalidate();
    }

    public final void t(int i2, View view) {
        int i3;
        View rootView;
        int iN = this.f4228g.n();
        int iN2 = this.f4229h.n();
        if (iN == 1 || iN2 == 1) {
            i3 = 1;
        } else {
            i3 = 2;
            if (iN != 2 && iN2 != 2) {
                i3 = 0;
            }
        }
        if (view != null && i2 == 0) {
            float f2 = ((LayoutParams) view.getLayoutParams()).f4239b;
            if (f2 == 0.0f) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.f4241d & 1) == 1) {
                    layoutParams.f4241d = 0;
                    ArrayList arrayList = this.t;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((DrawerListener) this.t.get(size)).b(view);
                        }
                    }
                    s(view, false);
                    r(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f2 == 1.0f) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                if ((layoutParams2.f4241d & 1) == 0) {
                    layoutParams2.f4241d = 1;
                    ArrayList arrayList2 = this.t;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ((DrawerListener) this.t.get(size2)).a(view);
                        }
                    }
                    s(view, true);
                    r(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i3 != this.f4232k) {
            this.f4232k = i3;
            ArrayList arrayList3 = this.t;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((DrawerListener) this.t.get(size3)).c(i3);
                }
            }
        }
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4222a = new ChildAccessibilityDelegate();
        this.f4225d = -1728053248;
        this.f4227f = new Paint();
        this.f4234m = true;
        this.n = 3;
        this.o = 3;
        this.p = 3;
        this.q = 3;
        this.C = new AccessibilityViewCommand() { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean c(View view) {
                DrawerLayout drawerLayout = DrawerLayout.this;
                if (!DrawerLayout.m(view) || drawerLayout.h(view) == 2) {
                    return false;
                }
                drawerLayout.c(view, true);
                return true;
            }
        };
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f4224c = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.f4230i = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.f4231j = viewDragCallback2;
        ViewDragHelper viewDragHelperI = ViewDragHelper.i(this, viewDragCallback);
        this.f4228g = viewDragHelperI;
        viewDragHelperI.w(1);
        viewDragHelperI.x(f3);
        viewDragCallback.m(viewDragHelperI);
        ViewDragHelper viewDragHelperI2 = ViewDragHelper.i(this, viewDragCallback2);
        this.f4229h = viewDragHelperI2;
        viewDragHelperI2.w(2);
        viewDragHelperI2.x(f3);
        viewDragCallback2.m(viewDragHelperI2);
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setImportantForAccessibility(1);
        ViewCompat.z(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    DrawerLayout drawerLayout = (DrawerLayout) view;
                    boolean z = false;
                    boolean z2 = windowInsets.getSystemWindowInsetTop() > 0;
                    drawerLayout.x = windowInsets;
                    drawerLayout.y = z2;
                    if (!z2 && drawerLayout.getBackground() == null) {
                        z = true;
                    }
                    drawerLayout.setWillNotDraw(z);
                    drawerLayout.requestLayout();
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
            setSystemUiVisibility(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(D);
            try {
                this.w = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i2, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(androidx.drawerlayout.R.styleable.DrawerLayout_elevation)) {
                this.f4223b = typedArrayObtainStyledAttributes2.getDimension(androidx.drawerlayout.R.styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.f4223b = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.z = new ArrayList();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setStatusBarBackground(int i2) {
        this.w = i2 != 0 ? getContext().getDrawable(i2) : null;
        invalidate();
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f4238a;

        /* renamed from: b, reason: collision with root package name */
        public float f4239b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4240c;

        /* renamed from: d, reason: collision with root package name */
        public int f4241d;

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4238a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.E);
            this.f4238a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
            this.f4238a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f4238a = 0;
            this.f4238a = layoutParams.f4238a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4238a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4238a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public int f4242c;

        /* renamed from: d, reason: collision with root package name */
        public int f4243d;

        /* renamed from: e, reason: collision with root package name */
        public int f4244e;

        /* renamed from: f, reason: collision with root package name */
        public int f4245f;

        /* renamed from: g, reason: collision with root package name */
        public int f4246g;

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$SavedState$1, reason: invalid class name */
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
            this.f4242c = 0;
            this.f4242c = parcel.readInt();
            this.f4243d = parcel.readInt();
            this.f4244e = parcel.readInt();
            this.f4245f = parcel.readInt();
            this.f4246g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4242c);
            parcel.writeInt(this.f4243d);
            parcel.writeInt(this.f4244e);
            parcel.writeInt(this.f4245f);
            parcel.writeInt(this.f4246g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f4242c = 0;
        }
    }
}
