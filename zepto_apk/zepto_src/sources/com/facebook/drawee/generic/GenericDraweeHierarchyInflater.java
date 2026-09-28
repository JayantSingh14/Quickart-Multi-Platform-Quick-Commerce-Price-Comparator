package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils;

/* loaded from: classes3.dex */
public class GenericDraweeHierarchyInflater {
    public static Drawable a(Context context, TypedArray typedArray, int i2) {
        int resourceId = typedArray.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getDrawable(resourceId);
    }

    public static RoundingParams b(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.p == null) {
            genericDraweeHierarchyBuilder.p = new RoundingParams();
        }
        return genericDraweeHierarchyBuilder.p;
    }

    public static ScalingUtils.AbstractScaleType c(TypedArray typedArray, int i2) {
        switch (typedArray.getInt(i2, -2)) {
            case -1:
                return null;
            case 0:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17384a;
            case 1:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17387d;
            case 2:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17388e;
            case 3:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17389f;
            case 4:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17390g;
            case 5:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17391h;
            case 6:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17392i;
            case 7:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17393j;
            case 8:
                return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17394k;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x021e A[PHI: r0 r1 r2
      0x021e: PHI (r0v23 boolean) = (r0v18 boolean), (r0v25 boolean) binds: [B:151:0x023f, B:134:0x021c] A[DONT_GENERATE, DONT_INLINE]
      0x021e: PHI (r1v19 boolean) = (r1v14 boolean), (r1v21 boolean) binds: [B:151:0x023f, B:134:0x021c] A[DONT_GENERATE, DONT_INLINE]
      0x021e: PHI (r2v14 boolean) = (r2v10 boolean), (r2v16 boolean) binds: [B:151:0x023f, B:134:0x021c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0220 A[PHI: r0 r1 r2
      0x0220: PHI (r0v20 boolean) = (r0v18 boolean), (r0v18 boolean), (r0v25 boolean), (r0v25 boolean) binds: [B:150:0x023d, B:151:0x023f, B:133:0x021a, B:134:0x021c] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r1v16 boolean) = (r1v14 boolean), (r1v14 boolean), (r1v21 boolean), (r1v21 boolean) binds: [B:150:0x023d, B:151:0x023f, B:133:0x021a, B:134:0x021c] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r2v12 boolean) = (r2v10 boolean), (r2v10 boolean), (r2v16 boolean), (r2v16 boolean) binds: [B:150:0x023d, B:151:0x023f, B:133:0x021a, B:134:0x021c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.drawee.generic.GenericDraweeHierarchyBuilder d(android.content.Context r20, android.util.AttributeSet r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.GenericDraweeHierarchyInflater.d(android.content.Context, android.util.AttributeSet):com.facebook.drawee.generic.GenericDraweeHierarchyBuilder");
    }
}
