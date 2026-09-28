package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes4.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    public static class OverlayViewGroup extends ViewGroup {
        static {
            try {
                Class cls = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas canvas) {
            throw null;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        public final boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable);
        }
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public final void a(Drawable drawable) {
        throw null;
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public final void b(Drawable drawable) {
        throw null;
    }
}
