package com.th3rdwave.safeareacontext;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SafeAreaUtilsKt {
    public static final Rect a(View view, ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getParent() == null) {
            return null;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getDrawingRect(rect);
        try {
            rootView.offsetDescendantRectToMyCoords(view, rect);
            return new Rect(rect.left, rect.top, view.getWidth(), view.getHeight());
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.th3rdwave.safeareacontext.EdgeInsets b(android.view.View r9) {
        /*
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r0 = r9.getHeight()
            r1 = 0
            if (r0 != 0) goto Le
            goto L81
        Le:
            android.view.View r0 = r9.getRootView()
            kotlin.jvm.internal.Intrinsics.c(r0)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r2 < r3) goto L57
            android.view.WindowInsets r2 = r0.getRootWindowInsets()
            if (r2 == 0) goto L55
            int r3 = androidx.activity.result.contract.a.v()
            int r4 = androidx.activity.result.contract.a.C()
            r3 = r3 | r4
            int r4 = androidx.activity.result.contract.a.x()
            r3 = r3 | r4
            int r4 = androidx.activity.result.contract.a.y()
            r3 = r3 | r4
            android.graphics.Insets r2 = androidx.activity.result.contract.a.f(r2, r3)
            if (r2 != 0) goto L3b
            goto L55
        L3b:
            com.th3rdwave.safeareacontext.EdgeInsets r3 = new com.th3rdwave.safeareacontext.EdgeInsets
            int r4 = androidx.appcompat.widget.a.s(r2)
            float r4 = (float) r4
            int r5 = androidx.appcompat.widget.a.x(r2)
            float r5 = (float) r5
            int r6 = androidx.appcompat.widget.a.z(r2)
            float r6 = (float) r6
            int r2 = androidx.appcompat.widget.a.a(r2)
            float r2 = (float) r2
            r3.<init>(r4, r5, r6, r2)
            goto L7f
        L55:
            r3 = r1
            goto L7f
        L57:
            android.view.WindowInsets r2 = r0.getRootWindowInsets()
            if (r2 != 0) goto L5e
            goto L55
        L5e:
            com.th3rdwave.safeareacontext.EdgeInsets r3 = new com.th3rdwave.safeareacontext.EdgeInsets
            int r4 = r2.getSystemWindowInsetTop()
            float r4 = (float) r4
            int r5 = r2.getSystemWindowInsetRight()
            float r5 = (float) r5
            int r6 = r2.getSystemWindowInsetBottom()
            int r7 = r2.getStableInsetBottom()
            int r6 = java.lang.Math.min(r6, r7)
            float r6 = (float) r6
            int r2 = r2.getSystemWindowInsetLeft()
            float r2 = (float) r2
            r3.<init>(r4, r5, r6, r2)
        L7f:
            if (r3 != 0) goto L82
        L81:
            return r1
        L82:
            int r1 = r0.getWidth()
            float r1 = (float) r1
            int r0 = r0.getHeight()
            float r0 = (float) r0
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r9.getGlobalVisibleRect(r2)
            com.th3rdwave.safeareacontext.EdgeInsets r4 = new com.th3rdwave.safeareacontext.EdgeInsets
            int r5 = r2.top
            float r5 = (float) r5
            float r6 = r3.f47154a
            float r6 = r6 - r5
            r5 = 0
            float r6 = java.lang.Math.max(r6, r5)
            int r7 = r2.left
            int r8 = r9.getWidth()
            int r8 = r8 + r7
            float r7 = (float) r8
            float r7 = r7 - r1
            float r1 = java.lang.Math.min(r7, r5)
            float r7 = r3.f47155b
            float r1 = r1 + r7
            float r1 = java.lang.Math.max(r1, r5)
            int r7 = r2.top
            int r9 = r9.getHeight()
            int r9 = r9 + r7
            float r9 = (float) r9
            float r9 = r9 - r0
            float r9 = java.lang.Math.min(r9, r5)
            float r0 = r3.f47156c
            float r9 = r9 + r0
            float r9 = java.lang.Math.max(r9, r5)
            int r0 = r2.left
            float r0 = (float) r0
            float r2 = r3.f47157d
            float r2 = r2 - r0
            float r0 = java.lang.Math.max(r2, r5)
            r4.<init>(r6, r1, r9, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.th3rdwave.safeareacontext.SafeAreaUtilsKt.b(android.view.View):com.th3rdwave.safeareacontext.EdgeInsets");
    }
}
