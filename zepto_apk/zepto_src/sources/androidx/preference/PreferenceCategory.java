package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes3.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
    }

    @Override // androidx.preference.Preference
    public final boolean c() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void g(PreferenceViewHolder preferenceViewHolder) {
        super.g(preferenceViewHolder);
        if (Build.VERSION.SDK_INT >= 28) {
            preferenceViewHolder.f11653a.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public final void l(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (Build.VERSION.SDK_INT < 28) {
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = accessibilityNodeInfoCompat.f3185a.getCollectionItemInfo();
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompat = collectionItemInfo != null ? new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(collectionItemInfo) : null;
            if (collectionItemInfoCompat == null) {
                return;
            }
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo2 = collectionItemInfoCompat.f3201a;
            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(collectionItemInfo2.getRowIndex(), collectionItemInfo2.getRowSpan(), collectionItemInfo2.getColumnIndex(), collectionItemInfo2.getColumnSpan(), true, collectionItemInfo2.isSelected()));
        }
    }

    @Override // androidx.preference.Preference
    public final boolean q() {
        return !super.c();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle));
    }
}
