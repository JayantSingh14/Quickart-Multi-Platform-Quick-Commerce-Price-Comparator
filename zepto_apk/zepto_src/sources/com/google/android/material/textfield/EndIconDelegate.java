package com.google.android.material.textfield;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes4.dex */
abstract class EndIconDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f41304a;

    /* renamed from: b, reason: collision with root package name */
    public final EndCompoundLayout f41305b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f41306c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f41307d;

    public EndIconDelegate(EndCompoundLayout endCompoundLayout) {
        this.f41304a = endCompoundLayout.f41284a;
        this.f41305b = endCompoundLayout;
        this.f41306c = endCompoundLayout.getContext();
        this.f41307d = endCompoundLayout.f41290g;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    public boolean i(int i2) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof DropdownMenuEndIconDelegate;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText) {
    }

    public void p(boolean z) {
    }

    public final void q() {
        this.f41305b.f(false);
    }

    public void r() {
    }

    public void s() {
    }

    public void a() {
    }

    public void b() {
    }

    public void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }
}
