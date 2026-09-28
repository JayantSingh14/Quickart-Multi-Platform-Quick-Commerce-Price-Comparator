package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes4.dex */
class ClickActionDelegate extends AccessibilityDelegateCompat {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfoCompat.AccessibilityActionCompat f41395a;

    public ClickActionDelegate(Context context, int i2) {
        this.f41395a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i2));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.b(this.f41395a);
    }
}
