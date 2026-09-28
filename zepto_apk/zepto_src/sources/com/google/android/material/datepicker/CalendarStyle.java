package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

/* loaded from: classes4.dex */
final class CalendarStyle {

    /* renamed from: a, reason: collision with root package name */
    public final CalendarItemStyle f40291a;

    /* renamed from: b, reason: collision with root package name */
    public final CalendarItemStyle f40292b;

    /* renamed from: c, reason: collision with root package name */
    public final CalendarItemStyle f40293c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarItemStyle f40294d;

    /* renamed from: e, reason: collision with root package name */
    public final CalendarItemStyle f40295e;

    /* renamed from: f, reason: collision with root package name */
    public final CalendarItemStyle f40296f;

    /* renamed from: g, reason: collision with root package name */
    public final CalendarItemStyle f40297g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f40298h;

    public CalendarStyle(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.c(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()).data, R.styleable.MaterialCalendar);
        this.f40291a = CalendarItemStyle.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0), context);
        this.f40297g = CalendarItemStyle.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0), context);
        this.f40292b = CalendarItemStyle.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0), context);
        this.f40293c = CalendarItemStyle.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0), context);
        ColorStateList colorStateListA = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f40294d = CalendarItemStyle.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0), context);
        this.f40295e = CalendarItemStyle.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0), context);
        this.f40296f = CalendarItemStyle.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0), context);
        Paint paint = new Paint();
        this.f40298h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
