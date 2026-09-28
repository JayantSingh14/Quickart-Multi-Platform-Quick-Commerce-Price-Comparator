package com.google.android.material.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements AccessibilityManagerCompat.TouchExplorationStateChangeListener, ViewUtils.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f40938a;

    public /* synthetic */ a(ViewGroup viewGroup) {
        this.f40938a = viewGroup;
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        MaterialToolbar materialToolbar = ((SearchView) this.f40938a).f40904g;
        boolean zH = ViewUtils.h(materialToolbar);
        materialToolbar.setPadding(windowInsetsCompat.h() + (zH ? relativePadding.f40662c : relativePadding.f40660a), relativePadding.f40661b, windowInsetsCompat.i() + (zH ? relativePadding.f40660a : relativePadding.f40662c), relativePadding.f40663d);
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean z) {
        int i2 = SearchBar.V0;
        ((SearchBar) this.f40938a).setFocusableInTouchMode(z);
    }
}
