package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Iterator;
import java.util.List;

@Nullsafe
/* loaded from: classes3.dex */
public class GenericDraweeHierarchyBuilder {
    public static final ScalingUtils.ScaleType q = ScalingUtils.ScaleType.f17391h;
    public static final ScalingUtils.ScaleType r = ScalingUtils.ScaleType.f17392i;

    /* renamed from: a, reason: collision with root package name */
    public final Resources f17412a;

    /* renamed from: b, reason: collision with root package name */
    public int f17413b = 300;

    /* renamed from: c, reason: collision with root package name */
    public float f17414c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f17415d = null;

    /* renamed from: e, reason: collision with root package name */
    public ScalingUtils.AbstractScaleType f17416e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f17417f;

    /* renamed from: g, reason: collision with root package name */
    public ScalingUtils.AbstractScaleType f17418g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f17419h;

    /* renamed from: i, reason: collision with root package name */
    public ScalingUtils.AbstractScaleType f17420i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f17421j;

    /* renamed from: k, reason: collision with root package name */
    public ScalingUtils.AbstractScaleType f17422k;

    /* renamed from: l, reason: collision with root package name */
    public ScalingUtils.AbstractScaleType f17423l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f17424m;
    public List n;
    public StateListDrawable o;
    public RoundingParams p;

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.f17412a = resources;
        ScalingUtils.AbstractScaleType abstractScaleType = (ScalingUtils.AbstractScaleType) q;
        this.f17416e = abstractScaleType;
        this.f17417f = null;
        this.f17418g = abstractScaleType;
        this.f17419h = null;
        this.f17420i = abstractScaleType;
        this.f17421j = null;
        this.f17422k = abstractScaleType;
        this.f17423l = (ScalingUtils.AbstractScaleType) r;
        this.f17424m = null;
        this.n = null;
        this.o = null;
        this.p = null;
    }

    public final GenericDraweeHierarchy a() {
        List list = this.n;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Drawable) it.next()).getClass();
            }
        }
        return new GenericDraweeHierarchy(this);
    }

    public final float b() {
        return this.f17414c;
    }

    public final void c(ScalingUtils.ScaleType scaleType) {
        this.f17423l = (ScalingUtils.AbstractScaleType) scaleType;
    }

    public final void d() {
        this.f17413b = 0;
    }
}
