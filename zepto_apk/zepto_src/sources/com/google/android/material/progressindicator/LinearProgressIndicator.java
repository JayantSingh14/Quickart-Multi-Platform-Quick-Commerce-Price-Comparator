package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* renamed from: m, reason: collision with root package name */
    public static final int f40856m = R.style.Widget_MaterialComponents_LinearProgressIndicator;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final BaseProgressIndicatorSpec a(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final void b(int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (baseProgressIndicatorSpec != null && ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40857h == 0 && isIndeterminate()) {
            return;
        }
        super.b(i2);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f40762a).f40857h;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f40762a).f40858i;
    }

    @Px
    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec) this.f40762a).f40860k;
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) baseProgressIndicatorSpec;
        boolean z2 = true;
        if (((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40858i != 1) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if ((getLayoutDirection() != 1 || ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40858i != 2) && (getLayoutDirection() != 0 || ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40858i != 3)) {
                z2 = false;
            }
        }
        linearProgressIndicatorSpec.f40859j = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingRight = i2 - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i3 - (getPaddingBottom() + getPaddingTop());
        IndeterminateDrawable<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        DeterminateDrawable<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40857h == i2) {
            return;
        }
        if (c() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40857h = i2;
        ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).a();
        if (i2 == 0) {
            IndeterminateDrawable<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
            LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) baseProgressIndicatorSpec);
            indeterminateDrawable.f40829m = linearIndeterminateContiguousAnimatorDelegate;
            linearIndeterminateContiguousAnimatorDelegate.f40826a = indeterminateDrawable;
        } else {
            IndeterminateDrawable<LinearProgressIndicatorSpec> indeterminateDrawable2 = getIndeterminateDrawable();
            LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) baseProgressIndicatorSpec);
            indeterminateDrawable2.f40829m = linearIndeterminateDisjointAnimatorDelegate;
            linearIndeterminateDisjointAnimatorDelegate.f40826a = indeterminateDrawable2;
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f40762a).a();
    }

    public void setIndicatorDirection(int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40858i = i2;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) baseProgressIndicatorSpec;
        boolean z = true;
        if (i2 != 1) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if ((getLayoutDirection() != 1 || ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40858i != 2) && (getLayoutDirection() != 0 || i2 != 3)) {
                z = false;
            }
        }
        linearProgressIndicatorSpec.f40859j = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i2) {
        super.setTrackCornerRadius(i2);
        ((LinearProgressIndicatorSpec) this.f40762a).a();
        invalidate();
    }

    public void setTrackStopIndicatorSize(@Px int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40860k != i2) {
            ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40860k = Math.min(i2, ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f40777a);
            ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).a();
            invalidate();
        }
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, f40856m);
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f40762a;
        LinearDrawingDelegate linearDrawingDelegate = new LinearDrawingDelegate(linearProgressIndicatorSpec);
        linearDrawingDelegate.f40830b = 300.0f;
        Context context2 = getContext();
        setIndeterminateDrawable(new IndeterminateDrawable(context2, linearProgressIndicatorSpec, linearDrawingDelegate, linearProgressIndicatorSpec.f40857h == 0 ? new LinearIndeterminateContiguousAnimatorDelegate(linearProgressIndicatorSpec) : new LinearIndeterminateDisjointAnimatorDelegate(context2, linearProgressIndicatorSpec)));
        setProgressDrawable(new DeterminateDrawable(getContext(), linearProgressIndicatorSpec, linearDrawingDelegate));
    }
}
