package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;

/* loaded from: classes3.dex */
public final class PreferenceScreen extends PreferenceGroup {
    @RestrictTo
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.a(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle));
    }

    @Override // androidx.preference.Preference
    public final void h() {
        if (this.f11087h == null && this.A.size() != 0) {
            throw null;
        }
    }
}
