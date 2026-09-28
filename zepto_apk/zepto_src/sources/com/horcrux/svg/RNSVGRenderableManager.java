package com.horcrux.svg;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Region;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;

@ReactModule(name = "RNSVGRenderableModule")
/* loaded from: classes.dex */
class RNSVGRenderableManager extends NativeSvgRenderableModuleSpec {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    public static final String NAME = "RNSVGRenderableModule";

    public RNSVGRenderableManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getBBox(Double d2, ReadableMap readableMap) {
        RenderableView renderableViewByTag = VirtualViewManager.getRenderableViewByTag(d2.intValue());
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        boolean z = readableMap.getBoolean("fill");
        boolean z2 = readableMap.getBoolean("stroke");
        boolean z3 = readableMap.getBoolean("markers");
        boolean z4 = readableMap.getBoolean("clipped");
        try {
            renderableViewByTag.getPath(null, null);
            float f2 = renderableViewByTag.mScale;
            renderableViewByTag.initBounds();
            RectF rectF = new RectF();
            RectF rectF2 = renderableViewByTag.mFillBounds;
            RectF rectF3 = renderableViewByTag.mStrokeBounds;
            RectF rectF4 = renderableViewByTag.mMarkerBounds;
            RectF rectF5 = renderableViewByTag.mClipBounds;
            if (z && rectF2 != null) {
                rectF.union(rectF2);
            }
            if (z2 && rectF3 != null) {
                rectF.union(rectF3);
            }
            if (z3 && rectF4 != null) {
                rectF.union(rectF4);
            }
            if (z4 && rectF5 != null) {
                rectF.intersect(rectF5);
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("x", rectF.left / f2);
            writableMapCreateMap.putDouble("y", rectF.top / f2);
            writableMapCreateMap.putDouble(Snapshot.WIDTH, rectF.width() / f2);
            writableMapCreateMap.putDouble(Snapshot.HEIGHT, rectF.height() / f2);
            return writableMapCreateMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getCTM(Double d2) {
        RenderableView renderableViewByTag = VirtualViewManager.getRenderableViewByTag(d2.intValue());
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        float f2 = renderableViewByTag.mScale;
        Matrix matrix = new Matrix(renderableViewByTag.mCTM);
        SvgView svgView = renderableViewByTag.getSvgView();
        if (svgView == null) {
            throw new RuntimeException("Did not find parent SvgView for view with tag: " + d2);
        }
        matrix.preConcat(svgView.mInvViewBoxMatrix);
        matrix.getValues(new float[9]);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("a", r6[0]);
        writableMapCreateMap.putDouble("b", r6[3]);
        writableMapCreateMap.putDouble("c", r6[1]);
        writableMapCreateMap.putDouble("d", r6[4]);
        writableMapCreateMap.putDouble("e", r6[2] / f2);
        writableMapCreateMap.putDouble("f", r6[5] / f2);
        return writableMapCreateMap;
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNSVGRenderableModule";
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getPointAtLength(Double d2, ReadableMap readableMap) {
        RenderableView renderableViewByTag = VirtualViewManager.getRenderableViewByTag(d2.intValue());
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        try {
            PathMeasure pathMeasure = new PathMeasure(renderableViewByTag.getPath(null, null), false);
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            pathMeasure.getPosTan(Math.max(0.0f, Math.min(((float) readableMap.getDouble("length")) * renderableViewByTag.mScale, pathMeasure.getLength())), fArr, fArr2);
            double dAtan2 = Math.atan2(fArr2[1], fArr2[0]);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("x", fArr[0] / r8);
            writableMapCreateMap.putDouble("y", fArr[1] / r8);
            writableMapCreateMap.putDouble(LinearGradientManager.PROP_ANGLE, dAtan2);
            return writableMapCreateMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod
    public void getRawResource(String str, Promise promise) throws Resources.NotFoundException, IOException {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Resources resources = reactApplicationContext.getResources();
            InputStream inputStreamOpenRawResource = resources.openRawResource(resources.getIdentifier(str, "raw", reactApplicationContext.getPackageName()));
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource, StandardCharsets.UTF_8);
                char[] cArr = new char[4096];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i2 = inputStreamReader.read(cArr, 0, 4096);
                    if (i2 == -1) {
                        promise.resolve(sb.toString());
                        try {
                            inputStreamOpenRawResource.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    sb.append(cArr, 0, i2);
                }
            } catch (Throwable th) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject(e2);
        }
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getScreenCTM(Double d2) {
        RenderableView renderableViewByTag = VirtualViewManager.getRenderableViewByTag(d2.intValue());
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        renderableViewByTag.mCTM.getValues(new float[9]);
        float f2 = renderableViewByTag.mScale;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("a", r0[0]);
        writableMapCreateMap.putDouble("b", r0[3]);
        writableMapCreateMap.putDouble("c", r0[1]);
        writableMapCreateMap.putDouble("d", r0[4]);
        writableMapCreateMap.putDouble("e", r0[2] / f2);
        writableMapCreateMap.putDouble("f", r0[5] / f2);
        return writableMapCreateMap;
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getTotalLength(Double d2) {
        RenderableView renderableViewByTag = VirtualViewManager.getRenderableViewByTag(d2.intValue());
        if (renderableViewByTag == null) {
            return 0.0d;
        }
        try {
            return new PathMeasure(renderableViewByTag.getPath(null, null), false).getLength() / renderableViewByTag.mScale;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return -1.0d;
        }
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isPointInFill(Double d2, ReadableMap readableMap) {
        RenderableView renderableViewByTag = VirtualViewManager.getRenderableViewByTag(d2.intValue());
        if (renderableViewByTag == null) {
            return false;
        }
        float f2 = renderableViewByTag.mScale;
        return renderableViewByTag.hitTest(new float[]{((float) readableMap.getDouble("x")) * f2, ((float) readableMap.getDouble("y")) * f2}) != -1;
    }

    @Override // com.horcrux.svg.NativeSvgRenderableModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isPointInStroke(Double d2, ReadableMap readableMap) {
        RenderableView renderableViewByTag = VirtualViewManager.getRenderableViewByTag(d2.intValue());
        if (renderableViewByTag == null) {
            return false;
        }
        try {
            renderableViewByTag.getPath(null, null);
            renderableViewByTag.initBounds();
            double d3 = renderableViewByTag.mScale;
            int i2 = (int) (readableMap.getDouble("x") * d3);
            int i3 = (int) (readableMap.getDouble("y") * d3);
            Region region = renderableViewByTag.mStrokeRegion;
            return region != null && region.contains(i2, i3);
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return false;
        }
    }
}
