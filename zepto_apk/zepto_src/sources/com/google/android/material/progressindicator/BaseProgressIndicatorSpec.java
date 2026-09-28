package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* loaded from: classes4.dex */
public abstract class BaseProgressIndicatorSpec {

    /* renamed from: a, reason: collision with root package name */
    public int f40777a;

    /* renamed from: b, reason: collision with root package name */
    public int f40778b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f40779c;

    /* renamed from: d, reason: collision with root package name */
    public int f40780d;

    /* renamed from: e, reason: collision with root package name */
    public int f40781e;

    /* renamed from: f, reason: collision with root package name */
    public int f40782f;

    /* renamed from: g, reason: collision with root package name */
    public int f40783g;

    public BaseProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i2, int i3) throws Resources.NotFoundException {
        this.f40779c = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        int[] iArr = R.styleable.BaseProgressIndicator;
        ThemeEnforcement.a(context, attributeSet, i2, i3);
        ThemeEnforcement.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f40777a = MaterialResources.c(context, typedArrayObtainStyledAttributes, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f40778b = Math.min(MaterialResources.c(context, typedArrayObtainStyledAttributes, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f40777a / 2);
        this.f40781e = typedArrayObtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f40782f = typedArrayObtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.f40783g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.BaseProgressIndicator_indicatorColor)) {
            this.f40779c = new int[]{MaterialColors.c(context, R.attr.colorPrimary, -1)};
        } else if (typedArrayObtainStyledAttributes.peekValue(R.styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.f40779c = new int[]{typedArrayObtainStyledAttributes.getColor(R.styleable.BaseProgressIndicator_indicatorColor, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(R.styleable.BaseProgressIndicator_indicatorColor, -1));
            this.f40779c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BaseProgressIndicator_trackColor)) {
            this.f40780d = typedArrayObtainStyledAttributes.getColor(R.styleable.BaseProgressIndicator_trackColor, -1);
        } else {
            this.f40780d = this.f40779c[0];
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
            float f2 = typedArrayObtainStyledAttributes2.getFloat(0, 0.2f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f40780d = MaterialColors.a(this.f40780d, (int) (f2 * 255.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void a() {
        if (this.f40783g < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
