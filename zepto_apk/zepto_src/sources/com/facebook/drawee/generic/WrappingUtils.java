package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class WrappingUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ColorDrawable f17438a = new ColorDrawable(0);

    public static Drawable a(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            Paint paint = bitmapDrawable.getPaint();
            roundingParams.getClass();
            RoundedBitmapDrawable roundedBitmapDrawable = new RoundedBitmapDrawable(resources, bitmap, paint);
            b(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        }
        if (drawable instanceof NinePatchDrawable) {
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable;
            Intrinsics.checkNotNullParameter(ninePatchDrawable, "ninePatchDrawable");
            RoundedNinePatchDrawable roundedNinePatchDrawable = new RoundedNinePatchDrawable(ninePatchDrawable);
            b(roundedNinePatchDrawable, roundingParams);
            return roundedNinePatchDrawable;
        }
        if (!(drawable instanceof ColorDrawable)) {
            FLog.s("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
        RoundedColorDrawable roundedColorDrawable = new RoundedColorDrawable(((ColorDrawable) drawable).getColor());
        b(roundedColorDrawable, roundingParams);
        return roundedColorDrawable;
    }

    public static void b(Rounded rounded, RoundingParams roundingParams) {
        rounded.b(roundingParams.f17428b);
        rounded.s(roundingParams.f17429c);
        rounded.c(roundingParams.f17431e, roundingParams.f17432f);
        rounded.h(roundingParams.f17433g);
        rounded.r();
        rounded.m(roundingParams.f17434h);
        rounded.o();
    }

    public static Drawable c(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        try {
            FrescoSystrace.a();
            if (drawable != null && roundingParams != null && roundingParams.f17427a == RoundingParams.RoundingMethod.f17436b) {
                if (!(drawable instanceof ForwardingDrawable)) {
                    return a(drawable, roundingParams, resources);
                }
                DrawableParent drawableParent = (ForwardingDrawable) drawable;
                while (true) {
                    Object drawable2 = drawableParent.getDrawable();
                    if (drawable2 == drawableParent || !(drawable2 instanceof DrawableParent)) {
                        break;
                    }
                    drawableParent = (DrawableParent) drawable2;
                }
                drawableParent.g(a(drawableParent.g(f17438a), roundingParams, resources));
                return drawable;
            }
            return drawable;
        } finally {
            FrescoSystrace.a();
        }
    }

    public static Drawable d(Drawable drawable, RoundingParams roundingParams) {
        try {
            FrescoSystrace.a();
            if (drawable != null && roundingParams != null && roundingParams.f17427a == RoundingParams.RoundingMethod.f17435a) {
                RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                b(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.f17359l = roundingParams.f17430d;
                roundedCornersDrawable.invalidateSelf();
                return roundedCornersDrawable;
            }
            return drawable;
        } finally {
            FrescoSystrace.a();
        }
    }

    public static Drawable e(Drawable drawable, ScalingUtils.AbstractScaleType abstractScaleType) {
        FrescoSystrace.a();
        if (drawable == null || abstractScaleType == null) {
            FrescoSystrace.a();
            return drawable;
        }
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, abstractScaleType);
        FrescoSystrace.a();
        return scaleTypeDrawable;
    }
}
