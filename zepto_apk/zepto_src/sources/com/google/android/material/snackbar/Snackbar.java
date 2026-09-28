package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;

/* loaded from: classes4.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] B = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    public boolean A;
    public final AccessibilityManager z;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
    }

    @RestrictTo
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    public Snackbar(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        super(context, viewGroup, snackbarContentLayout, snackbarContentLayout2);
        this.z = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public final void a() {
        b(3);
    }

    public final void g() {
        int recommendedTimeoutMillis;
        SnackbarManager snackbarManagerB = SnackbarManager.b();
        int i2 = Build.VERSION.SDK_INT;
        AccessibilityManager accessibilityManager = this.z;
        boolean z = false;
        if (i2 >= 29) {
            recommendedTimeoutMillis = accessibilityManager.getRecommendedTimeoutMillis(0, (this.A ? 4 : 0) | 3);
        } else {
            recommendedTimeoutMillis = (this.A && accessibilityManager.isTouchExplorationEnabled()) ? -2 : 0;
        }
        BaseTransientBottomBar.AnonymousClass5 anonymousClass5 = this.s;
        synchronized (snackbarManagerB.f41203a) {
            try {
                if (snackbarManagerB.c(anonymousClass5)) {
                    SnackbarManager.SnackbarRecord snackbarRecord = snackbarManagerB.f41205c;
                    snackbarRecord.f41209b = recommendedTimeoutMillis;
                    snackbarManagerB.f41204b.removeCallbacksAndMessages(snackbarRecord);
                    snackbarManagerB.f(snackbarManagerB.f41205c);
                    return;
                }
                SnackbarManager.SnackbarRecord snackbarRecord2 = snackbarManagerB.f41206d;
                if (snackbarRecord2 != null && snackbarRecord2.f41208a.get() == anonymousClass5) {
                    z = true;
                }
                if (z) {
                    snackbarManagerB.f41206d.f41209b = recommendedTimeoutMillis;
                } else {
                    snackbarManagerB.f41206d = new SnackbarManager.SnackbarRecord(recommendedTimeoutMillis, anonymousClass5);
                }
                SnackbarManager.SnackbarRecord snackbarRecord3 = snackbarManagerB.f41205c;
                if (snackbarRecord3 == null || !snackbarManagerB.a(snackbarRecord3, 4)) {
                    snackbarManagerB.f41205c = null;
                    SnackbarManager.SnackbarRecord snackbarRecord4 = snackbarManagerB.f41206d;
                    if (snackbarRecord4 != null) {
                        snackbarManagerB.f41205c = snackbarRecord4;
                        snackbarManagerB.f41206d = null;
                        SnackbarManager.Callback callback = (SnackbarManager.Callback) snackbarRecord4.f41208a.get();
                        if (callback != null) {
                            callback.a();
                        } else {
                            snackbarManagerB.f41205c = null;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
