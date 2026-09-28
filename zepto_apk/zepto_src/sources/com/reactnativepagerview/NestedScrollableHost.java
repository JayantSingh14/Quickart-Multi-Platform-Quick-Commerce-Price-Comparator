package com.reactnativepagerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class NestedScrollableHost extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Integer f46392a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f46393b;

    /* renamed from: c, reason: collision with root package name */
    public int f46394c;

    /* renamed from: d, reason: collision with root package name */
    public float f46395d;

    /* renamed from: e, reason: collision with root package name */
    public float f46396e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f46397f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f46394c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x000d, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto Lc
            android.view.View r0 = (android.view.View) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            if (r0 == 0) goto L1e
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 != 0) goto L1e
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto Lc
            android.view.View r0 = (android.view.View) r0
            goto Ld
        L1e:
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L25
            androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
            return r0
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.NestedScrollableHost.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    public final boolean getDidSetInitialIndex() {
        return this.f46393b;
    }

    @Nullable
    public final Integer getInitialIndex() {
        return this.f46392a;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c9  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            androidx.viewpager2.widget.ViewPager2 r0 = r10.getParentViewPager()
            if (r0 == 0) goto L14
            int r0 = r0.getOrientation()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L15
        L14:
            r0 = 0
        L15:
            int r1 = r11.getAction()
            r2 = 1
            if (r1 != 0) goto L33
            float r1 = r11.getX()
            r10.f46395d = r1
            float r1 = r11.getY()
            r10.f46396e = r1
            if (r0 == 0) goto Ld0
            android.view.ViewParent r0 = r10.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto Ld0
        L33:
            int r1 = r11.getAction()
            r3 = 2
            if (r1 != r3) goto Ld0
            float r1 = r11.getX()
            float r3 = r10.f46395d
            float r1 = r1 - r3
            float r3 = r11.getY()
            float r4 = r10.f46396e
            float r3 = r3 - r4
            r4 = 0
            if (r0 != 0) goto L4c
            goto L54
        L4c:
            int r5 = r0.intValue()
            if (r5 != 0) goto L54
            r5 = r2
            goto L55
        L54:
            r5 = r4
        L55:
            float r6 = java.lang.Math.abs(r1)
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 1056964608(0x3f000000, float:0.5)
            if (r5 == 0) goto L61
            r9 = r8
            goto L62
        L61:
            r9 = r7
        L62:
            float r6 = r6 * r9
            float r9 = java.lang.Math.abs(r3)
            if (r5 == 0) goto L6a
            goto L6b
        L6a:
            r7 = r8
        L6b:
            float r9 = r9 * r7
            int r7 = r10.f46394c
            float r7 = (float) r7
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 > 0) goto L77
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 <= 0) goto Ld0
        L77:
            com.facebook.react.uimanager.events.NativeGestureUtil.b(r10, r11)
            r10.f46397f = r2
            if (r0 != 0) goto L7f
            goto Ld0
        L7f:
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 <= 0) goto L85
            r6 = r2
            goto L86
        L85:
            r6 = r4
        L86:
            if (r5 != r6) goto L90
            android.view.ViewParent r0 = r10.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
            goto Ld0
        L90:
            int r0 = r0.intValue()
            if (r5 == 0) goto L97
            goto L98
        L97:
            r1 = r3
        L98:
            float r1 = java.lang.Math.signum(r1)
            int r1 = (int) r1
            int r1 = -r1
            if (r0 == 0) goto Lb5
            if (r0 != r2) goto Laf
            android.view.View r0 = r10.getChild()
            if (r0 == 0) goto Lad
            boolean r0 = r0.canScrollVertically(r1)
            goto Lbf
        Lad:
            r0 = r4
            goto Lbf
        Laf:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        Lb5:
            android.view.View r0 = r10.getChild()
            if (r0 == 0) goto Lad
            boolean r0 = r0.canScrollHorizontally(r1)
        Lbf:
            if (r0 == 0) goto Lc9
            android.view.ViewParent r0 = r10.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto Ld0
        Lc9:
            android.view.ViewParent r0 = r10.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
        Ld0:
            boolean r11 = super.onInterceptTouchEvent(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.NestedScrollableHost.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        if (e2.getActionMasked() == 1 && this.f46397f) {
            NativeGestureUtil.a(this, e2);
            this.f46397f = false;
        }
        return super.onTouchEvent(e2);
    }

    public final void setDidSetInitialIndex(boolean z) {
        this.f46393b = z;
    }

    public final void setInitialIndex(@Nullable Integer num) {
        this.f46392a = num;
    }
}
