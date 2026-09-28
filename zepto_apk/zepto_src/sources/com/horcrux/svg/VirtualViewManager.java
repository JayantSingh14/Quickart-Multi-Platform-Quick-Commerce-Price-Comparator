package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.TransformHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.horcrux.svg.VirtualView;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
class VirtualViewManager<V extends VirtualView> extends ViewGroupManager<VirtualView> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    protected final String mClassName;
    protected ViewManagerDelegate<V> mDelegate;
    protected final SVGClass svgClass;
    private static final MatrixMathHelper.MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper.MatrixDecompositionContext();
    private static final double[] sTransformDecompositionArray = new double[16];
    private static final SparseArray<RenderableView> mTagToRenderableView = new SparseArray<>();
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();

    public static class RenderableShadowNode extends LayoutShadowNode {
        @ReactPropGroup(names = {"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", Snapshot.WIDTH, Snapshot.HEIGHT, "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
        public void ignoreLayoutProps(int i2, Dynamic dynamic) {
        }
    }

    public enum SVGClass {
        RNSVGGroup,
        RNSVGPath,
        RNSVGText,
        RNSVGTSpan,
        RNSVGTextPath,
        RNSVGImage,
        RNSVGCircle,
        RNSVGEllipse,
        RNSVGLine,
        RNSVGRect,
        RNSVGClipPath,
        RNSVGDefs,
        RNSVGUse,
        RNSVGSymbol,
        RNSVGLinearGradient,
        RNSVGRadialGradient,
        RNSVGPattern,
        RNSVGMask,
        RNSVGFilter,
        RNSVGFeBlend,
        RNSVGFeColorMatrix,
        RNSVGFeComposite,
        RNSVGFeFlood,
        RNSVGFeGaussianBlur,
        RNSVGFeMerge,
        RNSVGFeOffset,
        RNSVGMarker,
        RNSVGForeignObject
    }

    public VirtualViewManager(SVGClass sVGClass) {
        this.svgClass = sVGClass;
        this.mClassName = sVGClass.toString();
    }

    @Nullable
    public static RenderableView getRenderableViewByTag(int i2) {
        return mTagToRenderableView.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateSvgView(V v) {
        SvgView svgView = v.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            ViewParent parent = textView.getParent();
            while (parent instanceof TextView) {
                textView = (TextView) parent;
                parent = textView.getParent();
            }
            textView.clearChildCache();
        }
    }

    public static void runWhenViewIsAvailable(int i2, Runnable runnable) {
        mTagToRunnable.put(i2, runnable);
    }

    private static float sanitizeFloatPropertyValue(float f2) {
        if (f2 >= -3.4028235E38f && f2 <= Float.MAX_VALUE) {
            return f2;
        }
        if (f2 < -3.4028235E38f || f2 == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f2 > Float.MAX_VALUE || f2 == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f2)) {
            return 0.0f;
        }
        throw new IllegalStateException("Invalid float property value: " + f2);
    }

    public static void setRenderableView(int i2, RenderableView renderableView) {
        mTagToRenderableView.put(i2, renderableView);
        SparseArray<Runnable> sparseArray = mTagToRunnable;
        Runnable runnable = sparseArray.get(i2);
        if (runnable != null) {
            runnable.run();
            sparseArray.delete(i2);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return this.mClassName;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return RenderableShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(V v, String str) {
        v.setClipPath(str);
    }

    @ReactProp(name = "clipRule")
    public void setClipRule(V v, int i2) {
        v.setClipRule(i2);
    }

    @ReactProp(name = "display")
    public void setDisplay(V v, String str) {
        v.setDisplay(str);
    }

    @ReactProp(name = "markerEnd")
    public void setMarkerEnd(V v, String str) {
        v.setMarkerEnd(str);
    }

    @ReactProp(name = "markerMid")
    public void setMarkerMid(V v, String str) {
        v.setMarkerMid(str);
    }

    @ReactProp(name = "markerStart")
    public void setMarkerStart(V v, String str) {
        v.setMarkerStart(str);
    }

    @ReactProp(name = "mask")
    public void setMask(V v, String str) {
        v.setMask(str);
    }

    @ReactProp(name = "matrix")
    public void setMatrix(V v, Dynamic dynamic) {
        v.setMatrix(dynamic);
    }

    @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
    public void setName(V v, String str) {
        v.setName(str);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(@Nonnull V v, float f2) {
        v.setOpacity(f2);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(V v, @Nullable String str) {
        if (str == null) {
            v.setPointerEvents(PointerEvents.f19428e);
        } else {
            v.setPointerEvents(PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", Attributes.PREDEFINED_ATTRIBUTE_PREFIX)));
        }
    }

    @ReactProp(name = "responsible")
    public void setResponsible(V v, boolean z) {
        v.setResponsible(z);
    }

    public void setTransformProperty(VirtualView virtualView, ReadableArray readableArray) {
        if (readableArray == null) {
            virtualView.setTranslationX(PixelUtil.b(0.0f));
            virtualView.setTranslationY(PixelUtil.b(0.0f));
            virtualView.setRotation(0.0f);
            virtualView.setRotationX(0.0f);
            virtualView.setRotationY(0.0f);
            virtualView.setScaleX(1.0f);
            virtualView.setScaleY(1.0f);
            virtualView.setCameraDistance(0.0f);
            return;
        }
        MatrixMathHelper.MatrixDecompositionContext matrixDecompositionContext = sMatrixDecompositionContext;
        matrixDecompositionContext.a();
        double[] dArr = sTransformDecompositionArray;
        TransformHelper.c(readableArray, dArr, virtualView.getWidth(), virtualView.getHeight(), null, false);
        MatrixMathHelper.b(dArr, matrixDecompositionContext);
        virtualView.setTranslationX(PixelUtil.b(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19401d[0])));
        virtualView.setTranslationY(PixelUtil.b(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19401d[1])));
        virtualView.setRotation(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19402e[2]));
        virtualView.setRotationX(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19402e[0]));
        virtualView.setRotationY(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19402e[1]));
        virtualView.setScaleX(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19399b[0]));
        virtualView.setScaleY(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19399b[1]));
        double[] dArr2 = matrixDecompositionContext.f19398a;
        if (dArr2.length > 2) {
            float f2 = (float) dArr2[2];
            if (f2 == 0.0f) {
                f2 = 7.8125E-4f;
            }
            float f3 = (-1.0f) / f2;
            float f4 = DisplayMetricsHolder.c().density;
            virtualView.setCameraDistance(f4 * f4 * f3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull VirtualView virtualView) {
        super.addEventEmitters(themedReactContext, (ThemedReactContext) virtualView);
        virtualView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.horcrux.svg.VirtualViewManager.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public final void onChildViewAdded(View view, View view2) {
                if (view instanceof VirtualView) {
                    VirtualViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public final void onChildViewRemoved(View view, View view2) {
                if (view instanceof VirtualView) {
                    VirtualViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }
        });
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new RenderableShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nonnull
    public VirtualView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        switch (this.svgClass) {
            case RNSVGGroup:
                return new GroupView(themedReactContext);
            case RNSVGPath:
                PathView pathView = new PathView(themedReactContext);
                PathParser.f45795a = pathView.mScale;
                pathView.f45808a = new Path();
                return pathView;
            case RNSVGText:
                return new TextView(themedReactContext);
            case RNSVGTSpan:
                return new TSpanView(themedReactContext);
            case RNSVGTextPath:
                return new TextPathView(themedReactContext);
            case RNSVGImage:
                return new ImageView(themedReactContext);
            case RNSVGCircle:
                return new CircleView(themedReactContext);
            case RNSVGEllipse:
                return new EllipseView(themedReactContext);
            case RNSVGLine:
                return new LineView(themedReactContext);
            case RNSVGRect:
                return new RectView(themedReactContext);
            case RNSVGClipPath:
                return new ClipPathView(themedReactContext);
            case RNSVGDefs:
                return new DefsView(themedReactContext);
            case RNSVGUse:
                return new UseView(themedReactContext);
            case RNSVGSymbol:
                return new SymbolView(themedReactContext);
            case RNSVGLinearGradient:
                LinearGradientView linearGradientView = new LinearGradientView(themedReactContext);
                linearGradientView.f45775g = null;
                return linearGradientView;
            case RNSVGRadialGradient:
                RadialGradientView radialGradientView = new RadialGradientView(themedReactContext);
                radialGradientView.f45844i = null;
                return radialGradientView;
            case RNSVGPattern:
                PatternView patternView = new PatternView(themedReactContext);
                patternView.r = null;
                return patternView;
            case RNSVGMask:
                return new MaskView(themedReactContext);
            case RNSVGFilter:
                return new FilterView(themedReactContext);
            case RNSVGFeBlend:
                FeBlendView feBlendView = new FeBlendView(themedReactContext);
                SVGLength sVGLength = new SVGLength(0.0d);
                FilterRegion filterRegion = feBlendView.f45688b;
                filterRegion.mX = sVGLength;
                filterRegion.mY = new SVGLength(0.0d);
                filterRegion.mW = new SVGLength("100%");
                filterRegion.mH = new SVGLength("100%");
                return feBlendView;
            case RNSVGFeColorMatrix:
                return new FeColorMatrixView(themedReactContext);
            case RNSVGFeComposite:
                return new FeCompositeView(themedReactContext);
            case RNSVGFeFlood:
                FeFloodView feFloodView = new FeFloodView(themedReactContext);
                feFloodView.f45679d = 1.0f;
                return feFloodView;
            case RNSVGFeGaussianBlur:
                return new FeGaussianBlurView(themedReactContext);
            case RNSVGFeMerge:
                return new FeMergeView(themedReactContext);
            case RNSVGFeOffset:
                return new FeOffsetView(themedReactContext);
            case RNSVGMarker:
                MarkerView markerView = new MarkerView(themedReactContext);
                markerView.r = new Matrix();
                return markerView;
            case RNSVGForeignObject:
                ForeignObjectView foreignObjectView = new ForeignObjectView(themedReactContext);
                foreignObjectView.f45731j = new Canvas(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
                return foreignObjectView;
            default:
                throw new IllegalStateException("Unexpected type " + this.svgClass.toString());
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@Nonnull VirtualView virtualView) {
        super.onAfterUpdateTransaction((VirtualViewManager<V>) virtualView);
        invalidateSvgView(virtualView);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@Nonnull VirtualView virtualView) {
        super.onDropViewInstance((VirtualViewManager<V>) virtualView);
        mTagToRenderableView.remove(virtualView.getId());
    }

    public void setMatrix(V v, @Nullable ReadableArray readableArray) {
        v.setMatrix(readableArray);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setTransform(VirtualView virtualView, @Nullable ReadableArray readableArray) {
        setTransformProperty(virtualView, readableArray);
        Matrix matrix = virtualView.getMatrix();
        virtualView.mMatrix = matrix;
        virtualView.mInvertible = matrix.invert(virtualView.mInvMatrix);
    }

    @ReactProp(name = "transform")
    public void setTransform(V v, Dynamic dynamic) {
        if (dynamic.getType() != ReadableType.Array) {
            return;
        }
        setTransform((VirtualView) v, dynamic.asArray());
    }
}
