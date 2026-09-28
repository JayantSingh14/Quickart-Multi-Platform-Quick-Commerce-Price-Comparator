package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* loaded from: classes4.dex */
public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {

    /* renamed from: h, reason: collision with root package name */
    public int f40857h;

    /* renamed from: i, reason: collision with root package name */
    public int f40858i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40859j;

    /* renamed from: k, reason: collision with root package name */
    public int f40860k;

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public final void a() {
        super.a();
        if (this.f40860k < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        }
        if (this.f40857h == 0) {
            if (this.f40778b > 0 && this.f40783g == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            if (this.f40779c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        int i3 = LinearProgressIndicator.f40856m;
        super(context, attributeSet, i2, i3);
        int[] iArr = R.styleable.LinearProgressIndicator;
        int i4 = R.attr.linearProgressIndicatorStyle;
        ThemeEnforcement.a(context, attributeSet, i4, i3);
        ThemeEnforcement.b(context, attributeSet, iArr, i4, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, i3);
        this.f40857h = typedArrayObtainStyledAttributes.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f40858i = typedArrayObtainStyledAttributes.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        this.f40860k = Math.min(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearProgressIndicator_trackStopIndicatorSize, 0), this.f40777a);
        typedArrayObtainStyledAttributes.recycle();
        a();
        this.f40859j = this.f40858i == 1;
    }
}
