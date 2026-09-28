package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public final class CustomSearchView extends SearchView {
    public SearchView.OnCloseListener V0;
    public View.OnClickListener W0;
    public final FragmentBackPressOverrider X0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.swmansion.rnscreens.CustomSearchView$onBackPressedCallback$1] */
    public CustomSearchView(Context context, ScreenStackFragment fragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.X0 = new FragmentBackPressOverrider(fragment, new OnBackPressedCallback() { // from class: com.swmansion.rnscreens.CustomSearchView$onBackPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public final void handleOnBackPressed() {
                this.f46918a.setIconified(true);
            }
        });
        super.setOnSearchClickListener(new com.google.android.material.datepicker.d(this, 1));
        super.setOnCloseListener(new l(this, 19));
        setMaxWidth(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final void A() {
        t("");
    }

    public final void B() {
        setIconified(false);
        requestFocusFromTouch();
    }

    public final boolean getOverrideBackAction() {
        return this.X0.f46926d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C0) {
            return;
        }
        this.X0.a();
    }

    @Override // androidx.appcompat.widget.SearchView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FragmentBackPressOverrider fragmentBackPressOverrider = this.X0;
        if (fragmentBackPressOverrider.f46925c) {
            fragmentBackPressOverrider.f46924b.remove();
            fragmentBackPressOverrider.f46925c = false;
        }
    }

    @Override // androidx.appcompat.widget.SearchView
    public void setOnCloseListener(@Nullable SearchView.OnCloseListener onCloseListener) {
        this.V0 = onCloseListener;
    }

    @Override // androidx.appcompat.widget.SearchView
    public void setOnSearchClickListener(@Nullable View.OnClickListener onClickListener) {
        this.W0 = onClickListener;
    }

    public final void setOverrideBackAction(boolean z) {
        this.X0.f46926d = z;
    }

    public final void setText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        t(text);
    }
}
