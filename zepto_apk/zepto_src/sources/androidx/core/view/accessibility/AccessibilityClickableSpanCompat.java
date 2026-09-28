package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes3.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f3180a;

    /* renamed from: b, reason: collision with root package name */
    public final AccessibilityNodeInfoCompat f3181b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3182c;

    public AccessibilityClickableSpanCompat(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i3) {
        this.f3180a = i2;
        this.f3181b = accessibilityNodeInfoCompat;
        this.f3182c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f3180a);
        this.f3181b.f3185a.performAction(this.f3182c, bundle);
    }
}
