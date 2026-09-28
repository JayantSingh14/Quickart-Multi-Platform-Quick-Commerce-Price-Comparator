package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class ArcMotion extends PathMotion {

    /* renamed from: d, reason: collision with root package name */
    public static final float f12006d = (float) Math.tan(Math.toRadians(35.0d));

    /* renamed from: a, reason: collision with root package name */
    public final float f12007a;

    /* renamed from: b, reason: collision with root package name */
    public final float f12008b;

    /* renamed from: c, reason: collision with root package name */
    public final float f12009c;

    public ArcMotion() {
        this.f12007a = 0.0f;
        this.f12008b = 0.0f;
        this.f12009c = f12006d;
    }

    public static float b(float f2) {
        if (f2 < 0.0f || f2 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f2 / 2.0f));
    }

    @Override // androidx.transition.PathMotion
    public final Path a(float f2, float f3, float f4, float f5) {
        float fA;
        float fA2;
        float f6;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f7 = f4 - f2;
        float f8 = f5 - f3;
        float f9 = (f8 * f8) + (f7 * f7);
        float f10 = (f2 + f4) / 2.0f;
        float f11 = (f3 + f5) / 2.0f;
        float f12 = 0.25f * f9;
        boolean z = f3 > f5;
        if (Math.abs(f7) < Math.abs(f8)) {
            float fAbs = Math.abs(f9 / (f8 * 2.0f));
            if (z) {
                fA2 = fAbs + f5;
                fA = f4;
            } else {
                fA2 = fAbs + f3;
                fA = f2;
            }
            f6 = this.f12008b;
        } else {
            float f13 = f9 / (f7 * 2.0f);
            if (z) {
                fA2 = f3;
                fA = f13 + f2;
            } else {
                fA = f4 - f13;
                fA2 = f5;
            }
            f6 = this.f12007a;
        }
        float f14 = f12 * f6 * f6;
        float f15 = f10 - fA;
        float f16 = f11 - fA2;
        float f17 = (f16 * f16) + (f15 * f15);
        float f18 = this.f12009c;
        float f19 = f12 * f18 * f18;
        if (f17 >= f14) {
            f14 = f17 > f19 ? f19 : 0.0f;
        }
        if (f14 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f14 / f17);
            fA = android.support.v4.media.a.a(fA, f10, fSqrt, f10);
            fA2 = android.support.v4.media.a.a(fA2, f11, fSqrt, f11);
        }
        path.cubicTo((f2 + fA) / 2.0f, (f3 + fA2) / 2.0f, (fA + f4) / 2.0f, (fA2 + f5) / 2.0f, f4, f5);
        return path;
    }

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12007a = 0.0f;
        this.f12008b = 0.0f;
        this.f12009c = f12006d;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12113h);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f12008b = b(TypedArrayUtils.e(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        this.f12007a = b(TypedArrayUtils.h(xmlPullParser, "minimumHorizontalAngle") ? typedArrayObtainStyledAttributes.getFloat(0, 0.0f) : 0.0f);
        this.f12009c = b(TypedArrayUtils.h(xmlPullParser, "maximumAngle") ? typedArrayObtainStyledAttributes.getFloat(2, 70.0f) : 70.0f);
        typedArrayObtainStyledAttributes.recycle();
    }
}
