package com.swmansion.rnscreens;

import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class FragmentBackPressOverrider {

    /* renamed from: a, reason: collision with root package name */
    public final ScreenStackFragment f46923a;

    /* renamed from: b, reason: collision with root package name */
    public final CustomSearchView$onBackPressedCallback$1 f46924b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f46925c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f46926d;

    public FragmentBackPressOverrider(ScreenStackFragment fragment, CustomSearchView$onBackPressedCallback$1 onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.f46923a = fragment;
        this.f46924b = onBackPressedCallback;
        this.f46926d = true;
    }

    public final void a() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        if (this.f46925c || !this.f46926d) {
            return;
        }
        ScreenStackFragment screenStackFragment = this.f46923a;
        FragmentActivity activity = screenStackFragment.getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.a(screenStackFragment, this.f46924b);
        }
        this.f46925c = true;
    }
}
