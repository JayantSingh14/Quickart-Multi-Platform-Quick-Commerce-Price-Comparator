package com.facebook.react.uimanager;

import android.annotation.TargetApi;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@TargetApi(31)
/* loaded from: classes3.dex */
public final class FilterHelper {
    public static RenderEffect a(ColorMatrix colorMatrix, RenderEffect renderEffect) {
        if (renderEffect == null) {
            RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix));
            Intrinsics.c(renderEffectCreateColorFilterEffect);
            return renderEffectCreateColorFilterEffect;
        }
        RenderEffect renderEffectCreateColorFilterEffect2 = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix), renderEffect);
        Intrinsics.c(renderEffectCreateColorFilterEffect2);
        return renderEffectCreateColorFilterEffect2;
    }

    public static ColorMatrix b(float f2) {
        float f3 = ((-(f2 / 2.0f)) + 0.5f) * 255;
        return new ColorMatrix(new float[]{f2, 0.0f, 0.0f, 0.0f, f3, 0.0f, f2, 0.0f, 0.0f, f3, 0.0f, 0.0f, f2, 0.0f, f3, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static ColorMatrix c(float f2) {
        float f3 = 1 - f2;
        float f4 = 0.7152f - (f3 * 0.7152f);
        float f5 = 0.0722f - (f3 * 0.0722f);
        float f6 = 0.2126f - (f3 * 0.2126f);
        return new ColorMatrix(new float[]{(0.7874f * f3) + 0.2126f, f4, f5, 0.0f, 0.0f, f6, (0.2848f * f3) + 0.7152f, f5, 0.0f, 0.0f, f6, f4, (f3 * 0.9278f) + 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static ColorMatrix d(float f2) {
        double radians = Math.toRadians(f2);
        float fCos = (float) Math.cos(radians);
        float fSin = (float) Math.sin(radians);
        float f3 = 0.715f - (fCos * 0.715f);
        float f4 = fSin * 0.715f;
        float f5 = 0.072f - (fCos * 0.072f);
        float f6 = 0.213f - (fCos * 0.213f);
        return new ColorMatrix(new float[]{((fCos * 0.787f) + 0.213f) - (fSin * 0.213f), f3 - f4, (fSin * 0.928f) + f5, 0.0f, 0.0f, (0.143f * fSin) + f6, (0.14f * fSin) + (0.285f * fCos) + 0.715f, f5 - (0.283f * fSin), 0.0f, 0.0f, f6 - (0.787f * fSin), f3 + f4, (fSin * 0.072f) + (fCos * 0.928f) + 0.072f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static ColorMatrix e(float f2) {
        float f3 = 1 - (2 * f2);
        float f4 = f2 * 255;
        return new ColorMatrix(new float[]{f3, 0.0f, 0.0f, 0.0f, f4, 0.0f, f3, 0.0f, 0.0f, f4, 0.0f, 0.0f, f3, 0.0f, f4, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static ColorMatrix f(float f2) {
        float f3 = 1 - f2;
        return new ColorMatrix(new float[]{(0.607f * f3) + 0.393f, 0.769f - (f3 * 0.769f), 0.189f - (f3 * 0.189f), 0.0f, 0.0f, 0.349f - (f3 * 0.349f), (0.314f * f3) + 0.686f, 0.168f - (f3 * 0.168f), 0.0f, 0.0f, 0.272f - (f3 * 0.272f), 0.534f - (f3 * 0.534f), (f3 * 0.869f) + 0.131f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static final boolean g(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return false;
        }
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Intrinsics.c(map);
            String key = map.getEntryIterator().next().getKey();
            if (Intrinsics.b(key, "blur") || Intrinsics.b(key, "dropShadow")) {
                return false;
            }
        }
        return true;
    }

    public static final ColorMatrixColorFilter h(ReadableArray readableArray) {
        ColorMatrix colorMatrix;
        ColorMatrix colorMatrixE;
        if (readableArray == null) {
            return null;
        }
        ColorMatrix colorMatrix2 = new ColorMatrix();
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            if (map == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Map.Entry<String, Object> next = map.getEntryIterator().next();
            String key = next.getKey();
            Object value = next.getValue();
            Intrinsics.d(value, "null cannot be cast to non-null type kotlin.Double");
            float fDoubleValue = (float) ((Double) value).doubleValue();
            switch (key.hashCode()) {
                case -2114203985:
                    if (!key.equals("saturate")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrix = new ColorMatrix();
                    colorMatrix.setSaturation(fDoubleValue);
                    colorMatrixE = colorMatrix;
                    colorMatrix2.preConcat(colorMatrixE);
                case -1267206133:
                    if (!key.equals("opacity")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrix = new ColorMatrix();
                    colorMatrix.setScale(1.0f, 1.0f, 1.0f, fDoubleValue);
                    colorMatrixE = colorMatrix;
                    colorMatrix2.preConcat(colorMatrixE);
                case -1183703082:
                    if (!key.equals("invert")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrixE = e(fDoubleValue);
                    colorMatrix2.preConcat(colorMatrixE);
                case -905411385:
                    if (!key.equals("grayscale")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrixE = c(fDoubleValue);
                    colorMatrix2.preConcat(colorMatrixE);
                case -566947070:
                    if (!key.equals("contrast")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrixE = b(fDoubleValue);
                    colorMatrix2.preConcat(colorMatrixE);
                case 109324790:
                    if (!key.equals("sepia")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrixE = f(fDoubleValue);
                    colorMatrix2.preConcat(colorMatrixE);
                case 648162385:
                    if (!key.equals("brightness")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrix = new ColorMatrix();
                    colorMatrix.setScale(fDoubleValue, fDoubleValue, fDoubleValue, 1.0f);
                    colorMatrixE = colorMatrix;
                    colorMatrix2.preConcat(colorMatrixE);
                case 650888307:
                    if (!key.equals("hueRotate")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
                    }
                    colorMatrixE = d(fDoubleValue);
                    colorMatrix2.preConcat(colorMatrixE);
                default:
                    throw new IllegalArgumentException("Invalid color matrix filter: ".concat(key));
            }
        }
        return new ColorMatrixColorFilter(colorMatrix2);
    }

    public static final RenderEffect i(ReadableArray readableArray) {
        RenderEffect renderEffectCreateOffsetEffect;
        RenderEffect renderEffectCreateOffsetEffect2;
        if (readableArray == null) {
            return null;
        }
        int size = readableArray.size();
        RenderEffect renderEffectA = null;
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            if (map == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Map.Entry<String, Object> next = map.getEntryIterator().next();
            String key = next.getKey();
            switch (key.hashCode()) {
                case -2114203985:
                    if (!key.equals("saturate")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value = next.getValue();
                    Intrinsics.d(value, "null cannot be cast to non-null type kotlin.Double");
                    float fDoubleValue = (float) ((Double) value).doubleValue();
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.setSaturation(fDoubleValue);
                    renderEffectA = a(colorMatrix, renderEffectA);
                case -1267206133:
                    if (!key.equals("opacity")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value2 = next.getValue();
                    Intrinsics.d(value2, "null cannot be cast to non-null type kotlin.Double");
                    float fDoubleValue2 = (float) ((Double) value2).doubleValue();
                    ColorMatrix colorMatrix2 = new ColorMatrix();
                    colorMatrix2.setScale(1.0f, 1.0f, 1.0f, fDoubleValue2);
                    renderEffectA = a(colorMatrix2, renderEffectA);
                case -1183703082:
                    if (!key.equals("invert")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value3 = next.getValue();
                    Intrinsics.d(value3, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectA = a(e((float) ((Double) value3).doubleValue()), renderEffectA);
                case -905411385:
                    if (!key.equals("grayscale")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value4 = next.getValue();
                    Intrinsics.d(value4, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectA = a(c((float) ((Double) value4).doubleValue()), renderEffectA);
                case -566947070:
                    if (!key.equals("contrast")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value5 = next.getValue();
                    Intrinsics.d(value5, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectA = a(b((float) ((Double) value5).doubleValue()), renderEffectA);
                case 3027047:
                    if (!key.equals("blur")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value6 = next.getValue();
                    Intrinsics.d(value6, "null cannot be cast to non-null type kotlin.Double");
                    float fDoubleValue3 = (float) ((Double) value6).doubleValue();
                    if (fDoubleValue3 <= 0.5d) {
                        renderEffectA = null;
                    } else {
                        float fJ = j(fDoubleValue3);
                        if (renderEffectA == null) {
                            Shader.TileMode unused = Shader.TileMode.DECAL;
                            renderEffectA = RenderEffect.createBlurEffect(fJ, fJ, Shader.TileMode.DECAL);
                        } else {
                            Shader.TileMode unused2 = Shader.TileMode.DECAL;
                            renderEffectA = RenderEffect.createBlurEffect(fJ, fJ, renderEffectA, Shader.TileMode.DECAL);
                        }
                    }
                case 109324790:
                    if (!key.equals("sepia")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value7 = next.getValue();
                    Intrinsics.d(value7, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectA = a(f((float) ((Double) value7).doubleValue()), renderEffectA);
                case 648162385:
                    if (!key.equals("brightness")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value8 = next.getValue();
                    Intrinsics.d(value8, "null cannot be cast to non-null type kotlin.Double");
                    float fDoubleValue4 = (float) ((Double) value8).doubleValue();
                    ColorMatrix colorMatrix3 = new ColorMatrix();
                    colorMatrix3.setScale(fDoubleValue4, fDoubleValue4, fDoubleValue4, 1.0f);
                    renderEffectA = a(colorMatrix3, renderEffectA);
                case 650888307:
                    if (!key.equals("hueRotate")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value9 = next.getValue();
                    Intrinsics.d(value9, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectA = a(d((float) ((Double) value9).doubleValue()), renderEffectA);
                case 906978543:
                    if (!key.equals("dropShadow")) {
                        throw new IllegalArgumentException("Invalid filter name: ".concat(key));
                    }
                    Object value10 = next.getValue();
                    Intrinsics.d(value10, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
                    ReadableMap filterValues = (ReadableMap) value10;
                    Intrinsics.checkNotNullParameter(filterValues, "filterValues");
                    float fB = PixelUtil.b((float) filterValues.getDouble("offsetX"));
                    float fB2 = PixelUtil.b((float) filterValues.getDouble("offsetY"));
                    int i3 = filterValues.hasKey("color") ? filterValues.getInt("color") : -16777216;
                    float fJ2 = filterValues.hasKey("standardDeviation") ? j((float) filterValues.getDouble("standardDeviation")) : 0.0f;
                    if (renderEffectA == null) {
                        renderEffectCreateOffsetEffect2 = RenderEffect.createOffsetEffect(0.0f, 0.0f);
                        renderEffectCreateOffsetEffect = RenderEffect.createOffsetEffect(fB, fB2);
                    } else {
                        RenderEffect renderEffectCreateOffsetEffect3 = RenderEffect.createOffsetEffect(0.0f, 0.0f, renderEffectA);
                        renderEffectCreateOffsetEffect = RenderEffect.createOffsetEffect(fB, fB2, renderEffectA);
                        renderEffectCreateOffsetEffect2 = renderEffectCreateOffsetEffect3;
                    }
                    RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(i3, BlendMode.SRC_IN), renderEffectCreateOffsetEffect);
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect, "createColorFilterEffect(...)");
                    Shader.TileMode unused3 = Shader.TileMode.DECAL;
                    RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(fJ2, fJ2, renderEffectCreateColorFilterEffect, Shader.TileMode.DECAL);
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect, "createBlurEffect(...)");
                    BlendMode blendMode = BlendMode.SRC_OVER;
                    renderEffectA = RenderEffect.createBlendModeEffect(renderEffectCreateBlurEffect, renderEffectCreateOffsetEffect2, BlendMode.SRC_OVER);
                    Intrinsics.checkNotNullExpressionValue(renderEffectA, "createBlendModeEffect(...)");
                default:
                    throw new IllegalArgumentException("Invalid filter name: ".concat(key));
            }
        }
        return renderEffectA;
    }

    public static float j(float f2) {
        return (PixelUtil.b(f2) - 0.5f) / 0.57735f;
    }
}
