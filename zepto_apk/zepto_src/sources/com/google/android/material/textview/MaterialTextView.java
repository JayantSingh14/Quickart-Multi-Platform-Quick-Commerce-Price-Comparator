package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes4.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i2) throws Resources.NotFoundException {
        super.setTextAppearance(context, i2);
        if (MaterialAttributes.b(context, com.google.android.material.R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i2, com.google.android.material.R.styleable.MaterialTextAppearance);
            Context context2 = getContext();
            int[] iArr = {com.google.android.material.R.styleable.MaterialTextAppearance_android_lineHeight, com.google.android.material.R.styleable.MaterialTextAppearance_lineHeight};
            int iC = -1;
            for (int i3 = 0; i3 < 2 && iC < 0; i3++) {
                iC = MaterialResources.c(context2, typedArrayObtainStyledAttributes, iArr[i3], -1);
            }
            typedArrayObtainStyledAttributes.recycle();
            if (iC >= 0) {
                setLineHeight(iC);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        super(MaterialThemeOverlay.a(context, attributeSet, i2, 0), attributeSet, i2);
        Context context2 = getContext();
        if (MaterialAttributes.b(context2, com.google.android.material.R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.MaterialTextView, i2, 0);
            int[] iArr = {com.google.android.material.R.styleable.MaterialTextView_android_lineHeight, com.google.android.material.R.styleable.MaterialTextView_lineHeight};
            int iC = -1;
            for (int i3 = 0; i3 < 2 && iC < 0; i3++) {
                iC = MaterialResources.c(context2, typedArrayObtainStyledAttributes, iArr[i3], -1);
            }
            typedArrayObtainStyledAttributes.recycle();
            if (iC != -1) {
                return;
            }
            TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.MaterialTextView, i2, 0);
            int resourceId = typedArrayObtainStyledAttributes2.getResourceId(com.google.android.material.R.styleable.MaterialTextView_android_textAppearance, -1);
            typedArrayObtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, com.google.android.material.R.styleable.MaterialTextAppearance);
                Context context3 = getContext();
                int[] iArr2 = {com.google.android.material.R.styleable.MaterialTextAppearance_android_lineHeight, com.google.android.material.R.styleable.MaterialTextAppearance_lineHeight};
                int iC2 = -1;
                for (int i4 = 0; i4 < 2 && iC2 < 0; i4++) {
                    iC2 = MaterialResources.c(context3, typedArrayObtainStyledAttributes3, iArr2[i4], -1);
                }
                typedArrayObtainStyledAttributes3.recycle();
                if (iC2 >= 0) {
                    setLineHeight(iC2);
                }
            }
        }
    }
}
