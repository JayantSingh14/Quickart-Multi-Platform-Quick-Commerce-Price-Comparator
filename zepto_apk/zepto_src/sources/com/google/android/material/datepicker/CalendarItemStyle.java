package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
final class CalendarItemStyle {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f40285a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f40286b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f40287c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f40288d;

    /* renamed from: e, reason: collision with root package name */
    public final int f40289e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeAppearanceModel f40290f;

    public CalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, ShapeAppearanceModel shapeAppearanceModel, Rect rect) {
        Preconditions.b(rect.left);
        Preconditions.b(rect.top);
        Preconditions.b(rect.right);
        Preconditions.b(rect.bottom);
        this.f40285a = rect;
        this.f40286b = colorStateList2;
        this.f40287c = colorStateList;
        this.f40288d = colorStateList3;
        this.f40289e = i2;
        this.f40290f = shapeAppearanceModel;
    }

    public static CalendarItemStyle a(int i2, Context context) throws Resources.NotFoundException {
        Preconditions.a(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel shapeAppearanceModelA = ShapeAppearanceModel.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new CalendarItemStyle(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, shapeAppearanceModelA, rect);
    }

    public final void b(TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        ShapeAppearanceModel shapeAppearanceModel = this.f40290f;
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        materialShapeDrawable.m(this.f40287c);
        materialShapeDrawable.u(this.f40289e);
        materialShapeDrawable.t(this.f40288d);
        ColorStateList colorStateList = this.f40286b;
        textView.setTextColor(colorStateList);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.f40285a;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        textView.setBackground(insetDrawable);
    }
}
