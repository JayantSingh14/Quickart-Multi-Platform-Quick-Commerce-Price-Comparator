package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* renamed from: m, reason: collision with root package name */
    public static final int f40802m = R.style.Widget_MaterialComponents_CircularProgressIndicator;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final BaseProgressIndicatorSpec a(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f40762a).f40805j;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f40762a).f40804i;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f40762a).f40803h;
    }

    public void setIndicatorDirection(int i2) {
        ((CircularProgressIndicatorSpec) this.f40762a).f40805j = i2;
        invalidate();
    }

    public void setIndicatorInset(@Px int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f40804i != i2) {
            ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f40804i = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i2) {
        int iMax = Math.max(i2, getTrackThickness() * 2);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f40803h != iMax) {
            ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f40803h = iMax;
            ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).a();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((CircularProgressIndicatorSpec) this.f40762a).a();
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, f40802m);
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f40762a;
        CircularDrawingDelegate circularDrawingDelegate = new CircularDrawingDelegate(circularProgressIndicatorSpec);
        Context context2 = getContext();
        IndeterminateDrawable indeterminateDrawable = new IndeterminateDrawable(context2, circularProgressIndicatorSpec, circularDrawingDelegate, new CircularIndeterminateAnimatorDelegate(circularProgressIndicatorSpec));
        indeterminateDrawable.n = VectorDrawableCompat.a(context2.getResources(), R.drawable.indeterminate_static, null);
        setIndeterminateDrawable(indeterminateDrawable);
        setProgressDrawable(new DeterminateDrawable(getContext(), circularProgressIndicatorSpec, circularDrawingDelegate));
    }
}
