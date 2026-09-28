package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

@RestrictTo
@Deprecated
/* loaded from: classes3.dex */
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f11130c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerViewAccessibilityDelegate.ItemDelegate f11131d;

    /* renamed from: e, reason: collision with root package name */
    public final AccessibilityDelegateCompat f11132e;

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f11131d = this.f11667b;
        this.f11132e = new AccessibilityDelegateCompat() { // from class: androidx.preference.PreferenceRecyclerViewAccessibilityDelegate.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Preference preferenceZ;
                RecyclerView recyclerView2;
                PreferenceRecyclerViewAccessibilityDelegate preferenceRecyclerViewAccessibilityDelegate = PreferenceRecyclerViewAccessibilityDelegate.this;
                preferenceRecyclerViewAccessibilityDelegate.f11131d.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                RecyclerView recyclerView3 = preferenceRecyclerViewAccessibilityDelegate.f11130c;
                recyclerView3.getClass();
                RecyclerView.ViewHolder viewHolderN = RecyclerView.N(view);
                int iK = -1;
                if (viewHolderN != null && (recyclerView2 = viewHolderN.r) != null) {
                    iK = recyclerView2.K(viewHolderN);
                }
                RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                if ((adapter instanceof PreferenceGroupAdapter) && (preferenceZ = ((PreferenceGroupAdapter) adapter).z(iK)) != null) {
                    preferenceZ.l(accessibilityNodeInfoCompat);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                return PreferenceRecyclerViewAccessibilityDelegate.this.f11131d.performAccessibilityAction(view, i2, bundle);
            }
        };
        this.f11130c = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public final AccessibilityDelegateCompat a() {
        return this.f11132e;
    }
}
