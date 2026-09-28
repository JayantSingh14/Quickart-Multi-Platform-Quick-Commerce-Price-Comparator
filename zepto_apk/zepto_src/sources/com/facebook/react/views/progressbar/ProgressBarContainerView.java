package com.facebook.react.views.progressbar;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.R;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ProgressBarContainerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Integer f19993a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19994b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19995c;

    /* renamed from: d, reason: collision with root package name */
    public double f19996d;

    /* renamed from: e, reason: collision with root package name */
    public ProgressBar f19997e;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    private final void setColor(ProgressBar progressBar) {
        Drawable indeterminateDrawable = progressBar.isIndeterminate() ? progressBar.getIndeterminateDrawable() : progressBar.getProgressDrawable();
        if (indeterminateDrawable == null) {
            return;
        }
        Integer num = this.f19993a;
        if (num != null) {
            indeterminateDrawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        } else {
            indeterminateDrawable.clearColorFilter();
        }
    }

    public final void a() {
        ProgressBar progressBar = this.f19997e;
        if (progressBar == null) {
            throw new JSApplicationIllegalArgumentException("setStyle() not called");
        }
        progressBar.setIndeterminate(this.f19994b);
        setColor(progressBar);
        progressBar.setProgress((int) (this.f19996d * 1000));
        progressBar.setVisibility(this.f19995c ? 0 : 4);
    }

    public final boolean getAnimating$ReactAndroid_release() {
        return this.f19995c;
    }

    @Nullable
    public final Integer getColor$ReactAndroid_release() {
        return this.f19993a;
    }

    public final boolean getIndeterminate$ReactAndroid_release() {
        return this.f19994b;
    }

    public final double getProgress$ReactAndroid_release() {
        return this.f19996d;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        String str = (String) getTag(R.id.react_test_id);
        if (str != null) {
            info.setViewIdResourceName(str);
        }
    }

    public final void setAnimating$ReactAndroid_release(boolean z) {
        this.f19995c = z;
    }

    public final void setColor$ReactAndroid_release(@Nullable Integer num) {
        this.f19993a = num;
    }

    public final void setIndeterminate$ReactAndroid_release(boolean z) {
        this.f19994b = z;
    }

    public final void setProgress$ReactAndroid_release(double d2) {
        this.f19996d = d2;
    }

    public final void setStyle$ReactAndroid_release(@Nullable String str) {
        ReactProgressBarViewManager.Companion.getClass();
        ProgressBar progressBarA = ReactProgressBarViewManager.Companion.a(ReactProgressBarViewManager.Companion.b(str), getContext());
        progressBarA.setMax(1000);
        this.f19997e = progressBarA;
        removeAllViews();
        addView(this.f19997e, new ViewGroup.LayoutParams(-1, -1));
    }
}
