package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* loaded from: classes4.dex */
public class TabItem extends View {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f41212a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f41213b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41214c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayE = TintTypedArray.e(context, attributeSet, R.styleable.TabItem);
        int i2 = R.styleable.TabItem_android_text;
        TypedArray typedArray = tintTypedArrayE.f1185b;
        this.f41212a = typedArray.getText(i2);
        this.f41213b = tintTypedArrayE.b(R.styleable.TabItem_android_icon);
        this.f41214c = typedArray.getResourceId(R.styleable.TabItem_android_layout, 0);
        tintTypedArrayE.g();
    }
}
