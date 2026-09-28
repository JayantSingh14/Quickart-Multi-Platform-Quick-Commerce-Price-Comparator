package com.horcrux.svg;

import android.graphics.Matrix;
import android.net.Uri;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSVGCircleManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGCircleManagerInterface;
import com.facebook.react.viewmanagers.RNSVGClipPathManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface;
import com.facebook.react.viewmanagers.RNSVGDefsManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGDefsManagerInterface;
import com.facebook.react.viewmanagers.RNSVGEllipseManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeBlendManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeCompositeManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeFloodManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeMergeManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeOffsetManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFilterManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGFilterManagerInterface;
import com.facebook.react.viewmanagers.RNSVGForeignObjectManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface;
import com.facebook.react.viewmanagers.RNSVGGroupManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGGroupManagerInterface;
import com.facebook.react.viewmanagers.RNSVGImageManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGImageManagerInterface;
import com.facebook.react.viewmanagers.RNSVGLineManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGLineManagerInterface;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface;
import com.facebook.react.viewmanagers.RNSVGMarkerManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface;
import com.facebook.react.viewmanagers.RNSVGMaskManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGMaskManagerInterface;
import com.facebook.react.viewmanagers.RNSVGPathManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGPathManagerInterface;
import com.facebook.react.viewmanagers.RNSVGPatternManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGPatternManagerInterface;
import com.facebook.react.viewmanagers.RNSVGRadialGradientManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface;
import com.facebook.react.viewmanagers.RNSVGRectManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGRectManagerInterface;
import com.facebook.react.viewmanagers.RNSVGSymbolManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTSpanManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTextManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGTextManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTextPathManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface;
import com.facebook.react.viewmanagers.RNSVGUseManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGUseManagerInterface;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.horcrux.svg.Brush;
import com.horcrux.svg.FilterProperties;
import com.horcrux.svg.MaskView;
import com.horcrux.svg.RenderableView;
import com.horcrux.svg.TextProperties;
import com.horcrux.svg.VirtualViewManager;
import com.horcrux.svg.events.SvgLoadEvent;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
class RenderableViewManager<T extends RenderableView> extends VirtualViewManager<T> {

    /* renamed from: com.horcrux.svg.RenderableViewManager$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45852a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            f45852a = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45852a[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class CircleViewManager extends RenderableViewManager<CircleView> implements RNSVGCircleManagerInterface<CircleView> {
        public static final String REACT_CLASS = "RNSVGCircle";

        public CircleViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGCircle);
            this.mDelegate = new RNSVGCircleManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((CircleViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((CircleViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((CircleViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((CircleViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((CircleViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((CircleViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((CircleViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((CircleViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((CircleViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((CircleViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((CircleViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((CircleViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((CircleViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((CircleViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((CircleViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((CircleViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((CircleViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((CircleViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((CircleViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((CircleViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((CircleViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((CircleViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((CircleViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((CircleViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((CircleViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((CircleViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((CircleViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "cx")
        public void setCx(CircleView circleView, Dynamic dynamic) {
            circleView.getClass();
            circleView.f45648a = SVGLength.b(dynamic);
            circleView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "cy")
        public void setCy(CircleView circleView, Dynamic dynamic) {
            circleView.getClass();
            circleView.f45649b = SVGLength.b(dynamic);
            circleView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGCircleManagerInterface
        @ReactProp(name = "r")
        public void setR(CircleView circleView, Dynamic dynamic) {
            circleView.getClass();
            circleView.f45650c = SVGLength.b(dynamic);
            circleView.invalidate();
        }
    }

    public static class ClipPathViewManager extends GroupViewManagerAbstract<ClipPathView> implements RNSVGClipPathManagerInterface<ClipPathView> {
        public static final String REACT_CLASS = "RNSVGClipPath";

        public ClipPathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGClipPath);
            this.mDelegate = new RNSVGClipPathManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((ClipPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((ClipPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((ClipPathViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((ClipPathViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((ClipPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((ClipPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((ClipPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((ClipPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((ClipPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((ClipPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((ClipPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((ClipPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((ClipPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((ClipPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((ClipPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((ClipPathViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((ClipPathViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((ClipPathViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((ClipPathViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((ClipPathViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((ClipPathViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((ClipPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((ClipPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((ClipPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((ClipPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((ClipPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((ClipPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((ClipPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((ClipPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((ClipPathViewManager) view, i2);
        }
    }

    public static class DefsViewManager extends VirtualViewManager<DefsView> implements RNSVGDefsManagerInterface<DefsView> {
        public static final String REACT_CLASS = "RNSVGDefs";

        public DefsViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGDefs);
            this.mDelegate = new RNSVGDefsManagerDelegate(this);
        }

        @Override // com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((DefsViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((DefsViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((DefsViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((DefsViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGDefsManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((DefsViewManager) view, z);
        }
    }

    public static class EllipseViewManager extends RenderableViewManager<EllipseView> implements RNSVGEllipseManagerInterface<EllipseView> {
        public static final String REACT_CLASS = "RNSVGEllipse";

        public EllipseViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGEllipse);
            this.mDelegate = new RNSVGEllipseManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((EllipseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((EllipseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((EllipseViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((EllipseViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((EllipseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((EllipseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((EllipseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((EllipseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((EllipseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((EllipseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((EllipseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((EllipseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((EllipseViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((EllipseViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((EllipseViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((EllipseViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((EllipseViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((EllipseViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((EllipseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((EllipseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((EllipseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((EllipseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((EllipseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((EllipseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((EllipseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((EllipseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((EllipseViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "cx")
        public void setCx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.getClass();
            ellipseView.f45656a = SVGLength.b(dynamic);
            ellipseView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "cy")
        public void setCy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.getClass();
            ellipseView.f45657b = SVGLength.b(dynamic);
            ellipseView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "rx")
        public void setRx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.getClass();
            ellipseView.f45658c = SVGLength.b(dynamic);
            ellipseView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface
        @ReactProp(name = "ry")
        public void setRy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.getClass();
            ellipseView.f45659d = SVGLength.b(dynamic);
            ellipseView.invalidate();
        }
    }

    public static class FeBlendManager extends FilterPrimitiveManager<FeBlendView> implements RNSVGFeBlendManagerInterface<FeBlendView> {
        public static final String REACT_CLASS = "RNSVGFeBlend";

        public FeBlendManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeBlend);
            this.mDelegate = new RNSVGFeBlendManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.FilterPrimitiveManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FeBlendManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = "in1")
        public void setIn1(FeBlendView feBlendView, String str) {
            feBlendView.f45661c = str;
            feBlendView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = "in2")
        public void setIn2(FeBlendView feBlendView, String str) {
            feBlendView.f45662d = str;
            feBlendView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FeBlendManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FeBlendManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FeBlendManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FeBlendManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface
        @ReactProp(name = "mode")
        public void setMode(FeBlendView feBlendView, String str) {
            feBlendView.getClass();
            feBlendView.f45663e = FilterProperties.FeBlendMode.a(str);
            feBlendView.invalidate();
        }
    }

    public static class FeColorMatrixManager extends FilterPrimitiveManager<FeColorMatrixView> implements RNSVGFeColorMatrixManagerInterface<FeColorMatrixView> {
        public static final String REACT_CLASS = "RNSVGFeColorMatrix";

        public FeColorMatrixManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeColorMatrix);
            this.mDelegate = new RNSVGFeColorMatrixManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.FilterPrimitiveManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FeColorMatrixManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = "in1")
        public void setIn1(FeColorMatrixView feColorMatrixView, String str) {
            feColorMatrixView.f45665c = str;
            feColorMatrixView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FeColorMatrixManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = "values")
        public void setValues(FeColorMatrixView feColorMatrixView, @Nullable ReadableArray readableArray) {
            feColorMatrixView.f45667e = readableArray;
            feColorMatrixView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FeColorMatrixManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FeColorMatrixManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FeColorMatrixManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface
        @ReactProp(name = "type")
        public void setType(FeColorMatrixView feColorMatrixView, String str) {
            feColorMatrixView.getClass();
            feColorMatrixView.f45666d = FilterProperties.FeColorMatrixType.a(str);
            feColorMatrixView.invalidate();
        }
    }

    public static class FeCompositeManager extends FilterPrimitiveManager<FeCompositeView> implements RNSVGFeCompositeManagerInterface<FeCompositeView> {
        public static final String REACT_CLASS = "RNSVGFeComposite";

        public FeCompositeManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeComposite);
            this.mDelegate = new RNSVGFeCompositeManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.FilterPrimitiveManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FeCompositeManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "in1")
        public void setIn1(FeCompositeView feCompositeView, String str) {
            feCompositeView.f45669c = str;
            feCompositeView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "in2")
        public void setIn2(FeCompositeView feCompositeView, String str) {
            feCompositeView.f45670d = str;
            feCompositeView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FeCompositeManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FeCompositeManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FeCompositeManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FeCompositeManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "k1")
        public void setK1(FeCompositeView feCompositeView, float f2) {
            feCompositeView.getClass();
            feCompositeView.f45671e = f2;
            feCompositeView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "k2")
        public void setK2(FeCompositeView feCompositeView, float f2) {
            feCompositeView.getClass();
            feCompositeView.f45672f = f2;
            feCompositeView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "k3")
        public void setK3(FeCompositeView feCompositeView, float f2) {
            feCompositeView.getClass();
            feCompositeView.f45673g = f2;
            feCompositeView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "k4")
        public void setK4(FeCompositeView feCompositeView, float f2) {
            feCompositeView.getClass();
            feCompositeView.f45674h = f2;
            feCompositeView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeCompositeManagerInterface
        @ReactProp(name = "operator1")
        public void setOperator1(FeCompositeView feCompositeView, String str) {
            feCompositeView.getClass();
            feCompositeView.f45675i = FilterProperties.FeCompositeOperator.a(str);
            feCompositeView.invalidate();
        }
    }

    public static class FeFloodManager extends FilterPrimitiveManager<FeFloodView> implements RNSVGFeFloodManagerInterface<FeFloodView> {
        public static final String REACT_CLASS = "RNSVGFeFlood";

        public FeFloodManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeFlood);
            this.mDelegate = new RNSVGFeFloodManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.FilterPrimitiveManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "floodOpacity")
        public void setFloodOpacity(FeFloodView feFloodView, float f2) {
            feFloodView.f45679d = f2;
            feFloodView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FeFloodManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface
        @ReactProp(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FeFloodManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FeFloodManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FeFloodManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FeFloodManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface
        @ReactProp(name = "floodColor")
        public void setFloodColor(FeFloodView feFloodView, @Nullable Dynamic dynamic) throws NumberFormatException {
            if (dynamic != null) {
                feFloodView.getClass();
                if (!dynamic.isNull()) {
                    if (dynamic.getType().equals(ReadableType.Map)) {
                        feFloodView.l(dynamic.asMap());
                        return;
                    }
                    ReadableType type = dynamic.getType();
                    int i2 = 0;
                    if (type.equals(ReadableType.Number)) {
                        feFloodView.f45678c = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
                    } else if (type.equals(ReadableType.Array)) {
                        feFloodView.f45678c = dynamic.asArray();
                    } else {
                        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                        javaOnlyArray.pushInt(0);
                        Matcher matcher = FeFloodView.f45677e.matcher(dynamic.asString());
                        while (matcher.find()) {
                            double d2 = Double.parseDouble(matcher.group());
                            int i3 = i2 + 1;
                            if (i2 < 3) {
                                d2 /= 255.0d;
                            }
                            javaOnlyArray.pushDouble(d2);
                            i2 = i3;
                        }
                        feFloodView.f45678c = javaOnlyArray;
                    }
                    feFloodView.invalidate();
                    return;
                }
            }
            feFloodView.f45678c = null;
            feFloodView.invalidate();
        }

        public void setFloodColor(FeFloodView feFloodView, @Nullable ReadableMap readableMap) {
            feFloodView.l(readableMap);
        }
    }

    public static class FeGaussianBlurManager extends FilterPrimitiveManager<FeGaussianBlurView> implements RNSVGFeGaussianBlurManagerInterface<FeGaussianBlurView> {
        public static final String REACT_CLASS = "RNSVGFeGaussianBlur";

        public FeGaussianBlurManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeGaussianBlur);
            this.mDelegate = new RNSVGFeGaussianBlurManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.FilterPrimitiveManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FeGaussianBlurManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = "in1")
        public void setIn1(FeGaussianBlurView feGaussianBlurView, String str) {
            feGaussianBlurView.f45680c = str;
            feGaussianBlurView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FeGaussianBlurManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = "stdDeviationX")
        public void setStdDeviationX(FeGaussianBlurView feGaussianBlurView, float f2) {
            feGaussianBlurView.f45681d = f2;
            feGaussianBlurView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = "stdDeviationY")
        public void setStdDeviationY(FeGaussianBlurView feGaussianBlurView, float f2) {
            feGaussianBlurView.f45682e = f2;
            feGaussianBlurView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FeGaussianBlurManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FeGaussianBlurManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FeGaussianBlurManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface
        @ReactProp(name = "values")
        public void setEdgeMode(FeGaussianBlurView feGaussianBlurView, String str) {
            feGaussianBlurView.getClass();
            FilterProperties.EdgeMode.a(str);
            feGaussianBlurView.invalidate();
        }
    }

    public static class FeMergeManager extends FilterPrimitiveManager<FeMergeView> implements RNSVGFeMergeManagerInterface<FeMergeView> {
        public static final String REACT_CLASS = "RNSVGFeMerge";

        public FeMergeManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeMerge);
            this.mDelegate = new RNSVGFeMergeManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.FilterPrimitiveManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FeMergeManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface
        @ReactProp(name = "nodes")
        public void setNodes(FeMergeView feMergeView, ReadableArray readableArray) {
            feMergeView.f45683c = readableArray;
            feMergeView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface
        @ReactProp(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FeMergeManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FeMergeManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FeMergeManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FeMergeManager) view, dynamic);
        }
    }

    public static class FeOffsetManager extends FilterPrimitiveManager<FeOffsetView> implements RNSVGFeOffsetManagerInterface<FeOffsetView> {
        public static final String REACT_CLASS = "RNSVGFeOffset";

        public FeOffsetManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeOffset);
            this.mDelegate = new RNSVGFeOffsetManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.FilterPrimitiveManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FeOffsetManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = "in1")
        public void setIn1(FeOffsetView feOffsetView, String str) {
            feOffsetView.f45684c = str;
            feOffsetView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FeOffsetManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FeOffsetManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FeOffsetManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FeOffsetManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = "dx")
        public void setDx(FeOffsetView feOffsetView, Dynamic dynamic) {
            feOffsetView.getClass();
            feOffsetView.f45685d = SVGLength.b(dynamic);
            feOffsetView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFeOffsetManagerInterface
        @ReactProp(name = "dy")
        public void setDy(FeOffsetView feOffsetView, Dynamic dynamic) {
            feOffsetView.getClass();
            feOffsetView.f45686e = SVGLength.b(dynamic);
            feOffsetView.invalidate();
        }
    }

    public static class FilterManager extends VirtualViewManager<FilterView> implements RNSVGFilterManagerInterface<FilterView> {
        public static final String REACT_CLASS = "RNSVGFilter";

        public FilterManager() {
            super(VirtualViewManager.SVGClass.RNSVGFilter);
            this.mDelegate = new RNSVGFilterManagerDelegate(this);
        }

        @Override // com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFilterManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(FilterView filterView, Dynamic dynamic) {
            filterView.f45711d.setHeight(dynamic);
            filterView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFilterManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((FilterManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFilterManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(FilterView filterView, Dynamic dynamic) {
            filterView.f45711d.setWidth(dynamic);
            filterView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFilterManagerInterface
        @ReactProp(name = "x")
        public void setX(FilterView filterView, Dynamic dynamic) {
            filterView.f45711d.setX(dynamic);
            filterView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFilterManagerInterface
        @ReactProp(name = "y")
        public void setY(FilterView filterView, Dynamic dynamic) {
            filterView.f45711d.setY(dynamic);
            filterView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFilterManagerInterface
        @ReactProp(name = "filterUnits")
        public void setFilterUnits(FilterView filterView, String str) {
            filterView.getClass();
            filterView.f45709b = FilterProperties.Units.a(str);
            filterView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGFilterManagerInterface
        @ReactProp(name = "primitiveUnits")
        public void setPrimitiveUnits(FilterView filterView, String str) {
            filterView.getClass();
            filterView.f45710c = FilterProperties.Units.a(str);
            filterView.invalidate();
        }
    }

    public static class FilterPrimitiveManager<T extends FilterPrimitiveView> extends VirtualViewManager<T> {
        public FilterPrimitiveManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        @Override // com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(T t, Dynamic dynamic) {
            t.f45688b.setHeight(dynamic);
            t.invalidate();
        }

        @ReactProp(name = "result")
        public void setResult(T t, String str) {
            t.f45687a = str;
            t.invalidate();
        }

        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(T t, Dynamic dynamic) {
            t.f45688b.setWidth(dynamic);
            t.invalidate();
        }

        @ReactProp(name = "x")
        public void setX(T t, Dynamic dynamic) {
            t.f45688b.setX(dynamic);
            t.invalidate();
        }

        @ReactProp(name = "y")
        public void setY(T t, Dynamic dynamic) {
            t.f45688b.setY(dynamic);
            t.invalidate();
        }
    }

    public static class ForeignObjectManager extends GroupViewManagerAbstract<ForeignObjectView> implements RNSVGForeignObjectManagerInterface<ForeignObjectView> {
        public static final String REACT_CLASS = "RNSVGForeignObject";

        public ForeignObjectManager() {
            super(VirtualViewManager.SVGClass.RNSVGForeignObject);
            this.mDelegate = new RNSVGForeignObjectManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((ForeignObjectManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((ForeignObjectManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((ForeignObjectManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((ForeignObjectManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((ForeignObjectManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((ForeignObjectManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((ForeignObjectManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((ForeignObjectManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((ForeignObjectManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((ForeignObjectManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((ForeignObjectManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((ForeignObjectManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((ForeignObjectManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((ForeignObjectManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((ForeignObjectManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((ForeignObjectManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((ForeignObjectManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((ForeignObjectManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((ForeignObjectManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((ForeignObjectManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((ForeignObjectManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((ForeignObjectManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((ForeignObjectManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((ForeignObjectManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((ForeignObjectManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((ForeignObjectManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((ForeignObjectManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((ForeignObjectManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((ForeignObjectManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((ForeignObjectManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.getClass();
            foreignObjectView.f45730i = SVGLength.b(dynamic);
            foreignObjectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.getClass();
            foreignObjectView.f45729h = SVGLength.b(dynamic);
            foreignObjectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "x")
        public void setX(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.getClass();
            foreignObjectView.f45727f = SVGLength.b(dynamic);
            foreignObjectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface
        @ReactProp(name = "y")
        public void setY(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.getClass();
            foreignObjectView.f45728g = SVGLength.b(dynamic);
            foreignObjectView.invalidate();
        }
    }

    public static class GroupViewManager extends GroupViewManagerAbstract<GroupView> implements RNSVGGroupManagerInterface<GroupView> {
        public static final String REACT_CLASS = "RNSVGGroup";

        public GroupViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGGroup);
            this.mDelegate = new RNSVGGroupManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((GroupViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((GroupViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((GroupViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((GroupViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((GroupViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((GroupViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((GroupViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((GroupViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((GroupViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((GroupViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((GroupViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((GroupViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((GroupViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((GroupViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((GroupViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((GroupViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((GroupViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((GroupViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((GroupViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((GroupViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((GroupViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((GroupViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((GroupViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((GroupViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((GroupViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((GroupViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGGroupManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((GroupViewManager) view, i2);
        }
    }

    public static class GroupViewManagerAbstract<U extends GroupView> extends RenderableViewManager<U> {
        public GroupViewManagerAbstract(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @ReactProp(name = "font")
        public void setFont(U u, Dynamic dynamic) {
            u.getClass();
            if (dynamic.getType() == ReadableType.Map) {
                u.f45748a = dynamic.asMap();
            } else {
                u.f45748a = null;
            }
            u.invalidate();
        }

        @ReactProp(name = "fontSize")
        public void setFontSize(U u, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i2 = AnonymousClass1.f45852a[dynamic.getType().ordinal()];
            if (i2 == 1) {
                javaOnlyMap.putDouble("fontSize", dynamic.asDouble());
            } else if (i2 != 2) {
                return;
            } else {
                javaOnlyMap.putString("fontSize", dynamic.asString());
            }
            u.f45748a = javaOnlyMap;
            u.invalidate();
        }

        @ReactProp(name = "fontWeight")
        public void setFontWeight(U u, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i2 = AnonymousClass1.f45852a[dynamic.getType().ordinal()];
            if (i2 == 1) {
                javaOnlyMap.putDouble("fontWeight", dynamic.asDouble());
            } else if (i2 != 2) {
                return;
            } else {
                javaOnlyMap.putString("fontWeight", dynamic.asString());
            }
            u.f45748a = javaOnlyMap;
            u.invalidate();
        }
    }

    public static class ImageViewManager extends RenderableViewManager<ImageView> implements RNSVGImageManagerInterface<ImageView> {
        public static final String REACT_CLASS = "RNSVGImage";

        public ImageViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGImage);
            this.mDelegate = new RNSVGImageManagerDelegate(this);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
        public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
            HashMap map = new HashMap();
            map.put(SvgLoadEvent.EVENT_NAME, MapBuilder.c("registrationName", "onLoad"));
            return map;
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "align")
        public void setAlign(ImageView imageView, String str) {
            imageView.f45760h = str;
            imageView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((ImageViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((ImageViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((ImageViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((ImageViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((ImageViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((ImageViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((ImageViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((ImageViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((ImageViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((ImageViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((ImageViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((ImageViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((ImageViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(ImageView imageView, int i2) {
            imageView.f45761i = i2;
            imageView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((ImageViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((ImageViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((ImageViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((ImageViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((ImageViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((ImageViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((ImageViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((ImageViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((ImageViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((ImageViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((ImageViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((ImageViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((ImageViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((ImageViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(ImageView imageView, Dynamic dynamic) {
            imageView.getClass();
            imageView.f45756d = SVGLength.b(dynamic);
            imageView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(customType = "ImageSource", name = "src")
        public void setSrc(ImageView imageView, @Nullable ReadableMap readableMap) {
            imageView.getClass();
            if (readableMap != null) {
                String string = readableMap.getString("uri");
                imageView.f45757e = string;
                if (string == null || string.isEmpty()) {
                    return;
                }
                if (readableMap.hasKey(Snapshot.WIDTH) && readableMap.hasKey(Snapshot.HEIGHT)) {
                    imageView.f45758f = readableMap.getInt(Snapshot.WIDTH);
                    imageView.f45759g = readableMap.getInt(Snapshot.HEIGHT);
                } else {
                    imageView.f45758f = 0;
                    imageView.f45759g = 0;
                }
                if (Uri.parse(imageView.f45757e).getScheme() == null) {
                    ResourceDrawableIdHelper.a().d(imageView.mContext, imageView.f45757e);
                }
            }
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(ImageView imageView, Dynamic dynamic) {
            imageView.getClass();
            imageView.f45755c = SVGLength.b(dynamic);
            imageView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "x")
        public void setX(ImageView imageView, Dynamic dynamic) {
            imageView.getClass();
            imageView.f45753a = SVGLength.b(dynamic);
            imageView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGImageManagerInterface
        @ReactProp(name = "y")
        public void setY(ImageView imageView, Dynamic dynamic) {
            imageView.getClass();
            imageView.f45754b = SVGLength.b(dynamic);
            imageView.invalidate();
        }
    }

    public static class LineViewManager extends RenderableViewManager<LineView> implements RNSVGLineManagerInterface<LineView> {
        public static final String REACT_CLASS = "RNSVGLine";

        public LineViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGLine);
            this.mDelegate = new RNSVGLineManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((LineViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((LineViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((LineViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((LineViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((LineViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((LineViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((LineViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((LineViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((LineViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((LineViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((LineViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((LineViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((LineViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((LineViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((LineViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((LineViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((LineViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((LineViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((LineViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((LineViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((LineViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((LineViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((LineViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((LineViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((LineViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((LineViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((LineViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "x1")
        public void setX1(LineView lineView, Dynamic dynamic) {
            lineView.getClass();
            lineView.f45764a = SVGLength.b(dynamic);
            lineView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "x2")
        public void setX2(LineView lineView, Dynamic dynamic) {
            lineView.getClass();
            lineView.f45766c = SVGLength.b(dynamic);
            lineView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "y1")
        public void setY1(LineView lineView, Dynamic dynamic) {
            lineView.getClass();
            lineView.f45765b = SVGLength.b(dynamic);
            lineView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLineManagerInterface
        @ReactProp(name = "y2")
        public void setY2(LineView lineView, Dynamic dynamic) {
            lineView.getClass();
            lineView.f45767d = SVGLength.b(dynamic);
            lineView.invalidate();
        }
    }

    public static class LinearGradientManager extends VirtualViewManager<LinearGradientView> implements RNSVGLinearGradientManagerInterface<LinearGradientView> {
        public static final String REACT_CLASS = "RNSVGLinearGradient";

        public LinearGradientManager() {
            super(VirtualViewManager.SVGClass.RNSVGLinearGradient);
            this.mDelegate = new RNSVGLinearGradientManagerDelegate(this);
        }

        @Override // com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((LinearGradientManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "gradient")
        public void setGradient(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.f45773e = readableArray;
            linearGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(LinearGradientView linearGradientView, @Nullable ReadableArray readableArray) {
            if (readableArray != null) {
                float[] fArr = LinearGradientView.f45768h;
                int iC = PropHelper.c(readableArray, fArr, linearGradientView.mScale);
                if (iC == 6) {
                    if (linearGradientView.f45775g == null) {
                        linearGradientView.f45775g = new Matrix();
                    }
                    linearGradientView.f45775g.setValues(fArr);
                } else if (iC != -1) {
                    FLog.q("ReactNative", "RNSVG: Transform matrices must be of size 6");
                }
            } else {
                linearGradientView.f45775g = null;
            }
            linearGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(LinearGradientView linearGradientView, int i2) {
            if (i2 == 0) {
                linearGradientView.f45774f = Brush.BrushUnits.f45645a;
            } else if (i2 == 1) {
                linearGradientView.f45774f = Brush.BrushUnits.f45646b;
            }
            linearGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((LinearGradientManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((LinearGradientManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((LinearGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((LinearGradientManager) view, z);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "x1")
        public void setX1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.getClass();
            linearGradientView.f45769a = SVGLength.b(dynamic);
            linearGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "x2")
        public void setX2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.getClass();
            linearGradientView.f45771c = SVGLength.b(dynamic);
            linearGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "y1")
        public void setY1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.getClass();
            linearGradientView.f45770b = SVGLength.b(dynamic);
            linearGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface
        @ReactProp(name = "y2")
        public void setY2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.getClass();
            linearGradientView.f45772d = SVGLength.b(dynamic);
            linearGradientView.invalidate();
        }
    }

    public static class MarkerManager extends GroupViewManagerAbstract<MarkerView> implements RNSVGMarkerManagerInterface<MarkerView> {
        public static final String REACT_CLASS = "RNSVGMarker";

        public MarkerManager() {
            super(VirtualViewManager.SVGClass.RNSVGMarker);
            this.mDelegate = new RNSVGMarkerManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "align")
        public void setAlign(MarkerView markerView, String str) {
            markerView.p = str;
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((MarkerManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((MarkerManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((MarkerManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((MarkerManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((MarkerManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((MarkerManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((MarkerManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((MarkerManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((MarkerManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((MarkerManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((MarkerManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((MarkerManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((MarkerManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((MarkerManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "markerUnits")
        public void setMarkerUnits(MarkerView markerView, String str) {
            markerView.f45780j = str;
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((MarkerManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((MarkerManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(MarkerView markerView, int i2) {
            markerView.q = i2;
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "minX")
        public void setMinX(MarkerView markerView, float f2) {
            markerView.f45782l = f2;
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "minY")
        public void setMinY(MarkerView markerView, float f2) {
            markerView.f45783m = f2;
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((MarkerManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((MarkerManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "orient")
        public void setOrient(MarkerView markerView, String str) {
            markerView.f45781k = str;
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((MarkerManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((MarkerManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((MarkerManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((MarkerManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((MarkerManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((MarkerManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((MarkerManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((MarkerManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((MarkerManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((MarkerManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((MarkerManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "vbHeight")
        public void setVbHeight(MarkerView markerView, float f2) {
            markerView.o = f2;
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "vbWidth")
        public void setVbWidth(MarkerView markerView, float f2) {
            markerView.n = f2;
            markerView.invalidate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((MarkerManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "markerHeight")
        public void setMarkerHeight(MarkerView markerView, Dynamic dynamic) {
            markerView.getClass();
            markerView.f45779i = SVGLength.b(dynamic);
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "markerWidth")
        public void setMarkerWidth(MarkerView markerView, Dynamic dynamic) {
            markerView.getClass();
            markerView.f45778h = SVGLength.b(dynamic);
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "refX")
        public void setRefX(MarkerView markerView, Dynamic dynamic) {
            markerView.getClass();
            markerView.f45776f = SVGLength.b(dynamic);
            markerView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface
        @ReactProp(name = "refY")
        public void setRefY(MarkerView markerView, Dynamic dynamic) {
            markerView.getClass();
            markerView.f45777g = SVGLength.b(dynamic);
            markerView.invalidate();
        }
    }

    public static class MaskManager extends GroupViewManagerAbstract<MaskView> implements RNSVGMaskManagerInterface<MaskView> {
        public static final String REACT_CLASS = "RNSVGMask";

        public MaskManager() {
            super(VirtualViewManager.SVGClass.RNSVGMask);
            this.mDelegate = new RNSVGMaskManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((MaskManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((MaskManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((MaskManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((MaskManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((MaskManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((MaskManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((MaskManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((MaskManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((MaskManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((MaskManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((MaskManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((MaskManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((MaskManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((MaskManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((MaskManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "maskContentUnits")
        public void setMaskContentUnits(MaskView maskView, int i2) {
            maskView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "maskType")
        public void setMaskType(MaskView maskView, int i2) {
            if (i2 == 0) {
                maskView.f45789k = MaskView.MaskType.f45790a;
            } else if (i2 == 1) {
                maskView.f45789k = MaskView.MaskType.f45791b;
            }
            maskView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "maskUnits")
        public void setMaskUnits(MaskView maskView, int i2) {
            if (i2 == 0) {
                maskView.f45788j = Brush.BrushUnits.f45645a;
            } else if (i2 == 1) {
                maskView.f45788j = Brush.BrushUnits.f45646b;
            }
            maskView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((MaskManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((MaskManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((MaskManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((MaskManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((MaskManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((MaskManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((MaskManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((MaskManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((MaskManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((MaskManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((MaskManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((MaskManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((MaskManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((MaskManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((MaskManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(MaskView maskView, Dynamic dynamic) {
            maskView.getClass();
            maskView.f45787i = SVGLength.b(dynamic);
            maskView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(MaskView maskView, Dynamic dynamic) {
            maskView.getClass();
            maskView.f45786h = SVGLength.b(dynamic);
            maskView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "x")
        public void setX(MaskView maskView, Dynamic dynamic) {
            maskView.getClass();
            maskView.f45784f = SVGLength.b(dynamic);
            maskView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGMaskManagerInterface
        @ReactProp(name = "y")
        public void setY(MaskView maskView, Dynamic dynamic) {
            maskView.getClass();
            maskView.f45785g = SVGLength.b(dynamic);
            maskView.invalidate();
        }
    }

    public static class PathViewManager extends RenderableViewManager<PathView> implements RNSVGPathManagerInterface<PathView> {
        public static final String REACT_CLASS = "RNSVGPath";

        public PathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGPath);
            this.mDelegate = new RNSVGPathManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((PathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((PathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((PathViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((PathViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((PathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((PathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((PathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((PathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((PathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((PathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((PathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((PathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((PathViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((PathViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((PathViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((PathViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((PathViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((PathViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((PathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((PathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((PathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((PathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((PathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((PathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((PathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((PathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((PathViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPathManagerInterface
        @ReactProp(name = "d")
        public void setD(PathView pathView, String str) {
            pathView.getClass();
            pathView.f45808a = PathParser.e(str);
            ArrayList<PathElement> arrayList = PathParser.f45800f;
            pathView.elements = arrayList;
            Iterator<PathElement> it = arrayList.iterator();
            while (it.hasNext()) {
                for (Point point : it.next().f45794b) {
                    double d2 = point.f45817a;
                    double d3 = pathView.mScale;
                    point.f45817a = d2 * d3;
                    point.f45818b *= d3;
                }
            }
            pathView.invalidate();
        }
    }

    public static class PatternManager extends GroupViewManagerAbstract<PatternView> implements RNSVGPatternManagerInterface<PatternView> {
        public static final String REACT_CLASS = "RNSVGPattern";

        public PatternManager() {
            super(VirtualViewManager.SVGClass.RNSVGPattern);
            this.mDelegate = new RNSVGPatternManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "align")
        public void setAlign(PatternView patternView, String str) {
            patternView.p = str;
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((PatternManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((PatternManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((PatternManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((PatternManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((PatternManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((PatternManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((PatternManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((PatternManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((PatternManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((PatternManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((PatternManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((PatternManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((PatternManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((PatternManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((PatternManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((PatternManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(PatternView patternView, int i2) {
            patternView.q = i2;
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "minX")
        public void setMinX(PatternView patternView, float f2) {
            patternView.f45815l = f2;
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "minY")
        public void setMinY(PatternView patternView, float f2) {
            patternView.f45816m = f2;
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((PatternManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((PatternManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "patternContentUnits")
        public void setPatternContentUnits(PatternView patternView, int i2) {
            if (i2 == 0) {
                patternView.f45814k = Brush.BrushUnits.f45645a;
            } else if (i2 == 1) {
                patternView.f45814k = Brush.BrushUnits.f45646b;
            }
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "patternTransform")
        public void setPatternTransform(PatternView patternView, @Nullable ReadableArray readableArray) {
            if (readableArray != null) {
                float[] fArr = PatternView.s;
                int iC = PropHelper.c(readableArray, fArr, patternView.mScale);
                if (iC == 6) {
                    if (patternView.r == null) {
                        patternView.r = new Matrix();
                    }
                    patternView.r.setValues(fArr);
                } else if (iC != -1) {
                    FLog.q("ReactNative", "RNSVG: Transform matrices must be of size 6");
                }
            } else {
                patternView.r = null;
            }
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "patternUnits")
        public void setPatternUnits(PatternView patternView, int i2) {
            if (i2 == 0) {
                patternView.f45813j = Brush.BrushUnits.f45645a;
            } else if (i2 == 1) {
                patternView.f45813j = Brush.BrushUnits.f45646b;
            }
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((PatternManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((PatternManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((PatternManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((PatternManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((PatternManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((PatternManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((PatternManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((PatternManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((PatternManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((PatternManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((PatternManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "vbHeight")
        public void setVbHeight(PatternView patternView, float f2) {
            patternView.o = f2;
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "vbWidth")
        public void setVbWidth(PatternView patternView, float f2) {
            patternView.n = f2;
            patternView.invalidate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((PatternManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(PatternView patternView, Dynamic dynamic) {
            patternView.getClass();
            patternView.f45812i = SVGLength.b(dynamic);
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(PatternView patternView, Dynamic dynamic) {
            patternView.getClass();
            patternView.f45811h = SVGLength.b(dynamic);
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "x")
        public void setX(PatternView patternView, Dynamic dynamic) {
            patternView.getClass();
            patternView.f45809f = SVGLength.b(dynamic);
            patternView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGPatternManagerInterface
        @ReactProp(name = "y")
        public void setY(PatternView patternView, Dynamic dynamic) {
            patternView.getClass();
            patternView.f45810g = SVGLength.b(dynamic);
            patternView.invalidate();
        }
    }

    public static class RadialGradientManager extends VirtualViewManager<RadialGradientView> implements RNSVGRadialGradientManagerInterface<RadialGradientView> {
        public static final String REACT_CLASS = "RNSVGRadialGradient";

        public RadialGradientManager() {
            super(VirtualViewManager.SVGClass.RNSVGRadialGradient);
            this.mDelegate = new RNSVGRadialGradientManagerDelegate(this);
        }

        @Override // com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((RadialGradientManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "gradient")
        public void setGradient(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.f45842g = readableArray;
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(RadialGradientView radialGradientView, @Nullable ReadableArray readableArray) {
            if (readableArray != null) {
                float[] fArr = RadialGradientView.f45835j;
                int iC = PropHelper.c(readableArray, fArr, radialGradientView.mScale);
                if (iC == 6) {
                    if (radialGradientView.f45844i == null) {
                        radialGradientView.f45844i = new Matrix();
                    }
                    radialGradientView.f45844i.setValues(fArr);
                } else if (iC != -1) {
                    FLog.q("ReactNative", "RNSVG: Transform matrices must be of size 6");
                }
            } else {
                radialGradientView.f45844i = null;
            }
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(RadialGradientView radialGradientView, int i2) {
            if (i2 == 0) {
                radialGradientView.f45843h = Brush.BrushUnits.f45645a;
            } else if (i2 == 1) {
                radialGradientView.f45843h = Brush.BrushUnits.f45646b;
            }
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((RadialGradientManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((RadialGradientManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((RadialGradientManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((RadialGradientManager) view, z);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "cx")
        public void setCx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.getClass();
            radialGradientView.f45840e = SVGLength.b(dynamic);
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "cy")
        public void setCy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.getClass();
            radialGradientView.f45841f = SVGLength.b(dynamic);
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "fx")
        public void setFx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.getClass();
            radialGradientView.f45836a = SVGLength.b(dynamic);
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "fy")
        public void setFy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.getClass();
            radialGradientView.f45837b = SVGLength.b(dynamic);
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "rx")
        public void setRx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.getClass();
            radialGradientView.f45838c = SVGLength.b(dynamic);
            radialGradientView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface
        @ReactProp(name = "ry")
        public void setRy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.getClass();
            radialGradientView.f45839d = SVGLength.b(dynamic);
            radialGradientView.invalidate();
        }
    }

    public static class RectViewManager extends RenderableViewManager<RectView> implements RNSVGRectManagerInterface<RectView> {
        public static final String REACT_CLASS = "RNSVGRect";

        public RectViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGRect);
            this.mDelegate = new RNSVGRectManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((RectViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((RectViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((RectViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((RectViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((RectViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((RectViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((RectViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((RectViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((RectViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((RectViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((RectViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((RectViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((RectViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((RectViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((RectViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((RectViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RectViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((RectViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((RectViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((RectViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((RectViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((RectViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((RectViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((RectViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((RectViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((RectViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((RectViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(RectView rectView, Dynamic dynamic) {
            rectView.getClass();
            rectView.f45848d = SVGLength.b(dynamic);
            rectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "rx")
        public void setRx(RectView rectView, Dynamic dynamic) {
            rectView.getClass();
            rectView.f45849e = SVGLength.b(dynamic);
            rectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "ry")
        public void setRy(RectView rectView, Dynamic dynamic) {
            rectView.getClass();
            rectView.f45850f = SVGLength.b(dynamic);
            rectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(RectView rectView, Dynamic dynamic) {
            rectView.getClass();
            rectView.f45847c = SVGLength.b(dynamic);
            rectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "x")
        public void setX(RectView rectView, Dynamic dynamic) {
            rectView.getClass();
            rectView.f45845a = SVGLength.b(dynamic);
            rectView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGRectManagerInterface
        @ReactProp(name = "y")
        public void setY(RectView rectView, Dynamic dynamic) {
            rectView.getClass();
            rectView.f45846b = SVGLength.b(dynamic);
            rectView.invalidate();
        }
    }

    public static class SymbolManager extends GroupViewManagerAbstract<SymbolView> implements RNSVGSymbolManagerInterface<SymbolView> {
        public static final String REACT_CLASS = "RNSVGSymbol";

        public SymbolManager() {
            super(VirtualViewManager.SVGClass.RNSVGSymbol);
            this.mDelegate = new RNSVGSymbolManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "align")
        public void setAlign(SymbolView symbolView, String str) {
            symbolView.f45871j = str;
            symbolView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((SymbolManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((SymbolManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((SymbolManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((SymbolManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((SymbolManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((SymbolManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((SymbolManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((SymbolManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((SymbolManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((SymbolManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((SymbolManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((SymbolManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((SymbolManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((SymbolManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((SymbolManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((SymbolManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(SymbolView symbolView, int i2) {
            symbolView.f45872k = i2;
            symbolView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "minX")
        public void setMinX(SymbolView symbolView, float f2) {
            symbolView.f45867f = f2;
            symbolView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "minY")
        public void setMinY(SymbolView symbolView, float f2) {
            symbolView.f45868g = f2;
            symbolView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((SymbolManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((SymbolManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((SymbolManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((SymbolManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((SymbolManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((SymbolManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((SymbolManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((SymbolManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((SymbolManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((SymbolManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((SymbolManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((SymbolManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((SymbolManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "vbHeight")
        public void setVbHeight(SymbolView symbolView, float f2) {
            symbolView.f45870i = f2;
            symbolView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "vbWidth")
        public void setVbWidth(SymbolView symbolView, float f2) {
            symbolView.f45869h = f2;
            symbolView.invalidate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((SymbolManager) view, i2);
        }
    }

    public static class TextPathViewManager extends TextViewManagerAbstract<TextPathView> implements RNSVGTextPathManagerInterface<TextPathView> {
        public static final String REACT_CLASS = "RNSVGTextPath";

        public TextPathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGTextPath);
            this.mDelegate = new RNSVGTextPathManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.TextViewManagerAbstract, com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, @Nullable String str) {
            super.setAlignmentBaseline((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "baselineShift")
        public /* bridge */ /* synthetic */ void setBaselineShift(View view, Dynamic dynamic) {
            super.setBaselineShift((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((TextPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((TextPathViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "dx")
        public /* bridge */ /* synthetic */ void setDx(View view, Dynamic dynamic) {
            super.setDx((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "dy")
        public /* bridge */ /* synthetic */ void setDy(View view, Dynamic dynamic) {
            super.setDy((TextPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((TextPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((TextPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((TextPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "href")
        public void setHref(TextPathView textPathView, String str) {
            textPathView.q = str;
            textPathView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "inlineSize")
        public /* bridge */ /* synthetic */ void setInlineSize(View view, Dynamic dynamic) {
            super.setInlineSize((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, @Nullable String str) {
            super.setLengthAdjust((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((TextPathViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((TextPathViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((TextPathViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((TextPathViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((TextPathViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((TextPathViewManager) view, z);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = CLConstants.MODE_ROTATE)
        public /* bridge */ /* synthetic */ void setRotate(View view, Dynamic dynamic) {
            super.setRotate((TextPathViewManager) view, dynamic);
        }

        @ReactProp(name = "midLine")
        public void setSharp(TextPathView textPathView, @Nullable String str) {
            textPathView.getClass();
            textPathView.s = TextProperties.TextPathMidLine.valueOf(str);
            textPathView.invalidate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((TextPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((TextPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((TextPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((TextPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((TextPathViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((TextPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((TextPathViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "textLength")
        public /* bridge */ /* synthetic */ void setTextLength(View view, Dynamic dynamic) {
            super.setTextLength((TextPathViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((TextPathViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, @Nullable Dynamic dynamic) {
            super.setVerticalAlign((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((TextPathViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        public void setMidLine(TextPathView textPathView, @Nullable String str) {
            textPathView.getClass();
            textPathView.s = TextProperties.TextPathMidLine.valueOf(str);
            textPathView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "side")
        public void setSide(TextPathView textPathView, @Nullable String str) {
            textPathView.getClass();
            textPathView.r = TextProperties.TextPathSide.valueOf(str);
            textPathView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "spacing")
        public void setSpacing(TextPathView textPathView, @Nullable String str) {
            textPathView.getClass();
            TextProperties.TextPathSpacing.valueOf(str);
            textPathView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface
        @ReactProp(name = "startOffset")
        public void setStartOffset(TextPathView textPathView, Dynamic dynamic) {
            textPathView.getClass();
            textPathView.t = SVGLength.b(dynamic);
            textPathView.invalidate();
        }

        @Override // com.horcrux.svg.RenderableViewManager.TextViewManagerAbstract
        @ReactProp(name = "method")
        public void setMethod(TextPathView textPathView, @Nullable String str) {
            textPathView.s(str);
        }

        public TextPathViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new RNSVGTextPathManagerDelegate(this);
        }
    }

    public static class TextViewManagerAbstract<K extends TextView> extends GroupViewManagerAbstract<K> {
        public TextViewManagerAbstract(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        public void setAlignmentBaseline(K k2, @Nullable String str) {
            k2.s(str);
        }

        @ReactProp(name = "baselineShift")
        public void setBaselineShift(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.f45917h = SVGLength.c(dynamic);
            k2.invalidate();
        }

        @ReactProp(name = "dx")
        public void setDx(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.n = SVGLength.a(dynamic);
            k2.invalidate();
        }

        @ReactProp(name = "dy")
        public void setDy(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.o = SVGLength.a(dynamic);
            k2.invalidate();
        }

        @ReactProp(name = "inlineSize")
        public void setInlineSize(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.f45915f = SVGLength.b(dynamic);
            k2.invalidate();
        }

        @ReactProp(name = "lengthAdjust")
        public void setLengthAdjust(K k2, @Nullable String str) {
            k2.getClass();
            k2.f45918i = TextProperties.TextLengthAdjust.valueOf(str);
            k2.invalidate();
        }

        @ReactProp(name = "alignmentBaseline")
        public void setMethod(K k2, @Nullable String str) {
            k2.s(str);
        }

        @ReactProp(name = CLConstants.MODE_ROTATE)
        public void setRotate(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.f45922m = SVGLength.a(dynamic);
            k2.invalidate();
        }

        @ReactProp(name = "textLength")
        public void setTextLength(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.f45916g = SVGLength.b(dynamic);
            k2.invalidate();
        }

        @ReactProp(name = "verticalAlign")
        public void setVerticalAlign(K k2, @Nullable Dynamic dynamic) {
            k2.getClass();
            String strC = SVGLength.c(dynamic);
            if (strC != null) {
                String strTrim = strC.trim();
                int iLastIndexOf = strTrim.lastIndexOf(32);
                try {
                    k2.f45919j = TextProperties.AlignmentBaseline.a(strTrim.substring(iLastIndexOf));
                } catch (IllegalArgumentException unused) {
                    k2.f45919j = TextProperties.AlignmentBaseline.baseline;
                }
                try {
                    k2.f45917h = strTrim.substring(0, iLastIndexOf);
                } catch (IndexOutOfBoundsException unused2) {
                    k2.f45917h = null;
                }
            } else {
                k2.f45919j = TextProperties.AlignmentBaseline.baseline;
                k2.f45917h = null;
            }
            k2.invalidate();
        }

        @ReactProp(name = "x")
        public void setX(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.f45920k = SVGLength.a(dynamic);
            k2.invalidate();
        }

        @ReactProp(name = "y")
        public void setY(K k2, Dynamic dynamic) {
            k2.getClass();
            k2.f45921l = SVGLength.a(dynamic);
            k2.invalidate();
        }

        @Override // com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract
        @ReactProp(name = "font")
        public void setFont(K k2, Dynamic dynamic) {
            k2.getClass();
            if (dynamic.getType() == ReadableType.Map) {
                k2.f45748a = dynamic.asMap();
            } else {
                k2.f45748a = null;
            }
            k2.invalidate();
        }
    }

    public static class UseViewManager extends RenderableViewManager<UseView> implements RNSVGUseManagerInterface<UseView> {
        public static final String REACT_CLASS = "RNSVGUse";

        public UseViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGUse);
            this.mDelegate = new RNSVGUseManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((UseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((UseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((UseViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((UseViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((UseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((UseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((UseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((UseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "href")
        public void setHref(UseView useView, String str) {
            useView.f45923a = str;
            useView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((UseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((UseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((UseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((UseViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((UseViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((UseViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((UseViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((UseViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((UseViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((UseViewManager) view, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((UseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((UseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((UseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((UseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((UseViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((UseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((UseViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((UseViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((UseViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = Snapshot.HEIGHT)
        public void setHeight(UseView useView, Dynamic dynamic) {
            useView.getClass();
            useView.f45927e = SVGLength.b(dynamic);
            useView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = Snapshot.WIDTH)
        public void setWidth(UseView useView, Dynamic dynamic) {
            useView.getClass();
            useView.f45926d = SVGLength.b(dynamic);
            useView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "x")
        public void setX(UseView useView, Dynamic dynamic) {
            useView.getClass();
            useView.f45924b = SVGLength.b(dynamic);
            useView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGUseManagerInterface
        @ReactProp(name = "y")
        public void setY(UseView useView, Dynamic dynamic) {
            useView.getClass();
            useView.f45925c = SVGLength.b(dynamic);
            useView.invalidate();
        }
    }

    public RenderableViewManager(VirtualViewManager.SVGClass sVGClass) {
        super(sVGClass);
    }

    @Override // com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(T t, Integer num) {
        t.setCurrentColor(num);
    }

    @ReactProp(name = "fill")
    public void setFill(T t, @Nullable Dynamic dynamic) throws NumberFormatException {
        t.setFill(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(T t, float f2) {
        t.setFillOpacity(f2);
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(T t, int i2) {
        t.setFillRule(i2);
    }

    @ReactProp(name = "filter")
    public void setFilter(T t, String str) {
        t.setFilter(str);
    }

    @ReactProp(name = "propList")
    public void setPropList(T t, @Nullable ReadableArray readableArray) {
        t.setPropList(readableArray);
    }

    @ReactProp(name = "stroke")
    public void setStroke(T t, @Nullable Dynamic dynamic) throws NumberFormatException {
        t.setStroke(dynamic);
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(T t, Dynamic dynamic) {
        t.setStrokeDasharray(dynamic);
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(T t, float f2) {
        t.setStrokeDashoffset(f2);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(T t, int i2) {
        t.setStrokeLinecap(i2);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(T t, int i2) {
        t.setStrokeLinejoin(i2);
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(T t, float f2) {
        t.setStrokeMiterlimit(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(T t, float f2) {
        t.setStrokeOpacity(f2);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(T t, Dynamic dynamic) {
        t.setStrokeWidth(dynamic);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(T t, int i2) {
        t.setVectorEffect(i2);
    }

    public void setFill(T t, @Nullable ReadableMap readableMap) {
        t.setFill(readableMap);
    }

    public void setStroke(T t, @Nullable ReadableMap readableMap) {
        t.setStroke(readableMap);
    }

    public static class TSpanViewManager extends TextViewManagerAbstract<TSpanView> implements RNSVGTSpanManagerInterface<TSpanView> {
        public static final String REACT_CLASS = "RNSVGTSpan";

        public TSpanViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGTSpan);
            this.mDelegate = new RNSVGTSpanManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.TextViewManagerAbstract, com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, @Nullable String str) {
            super.setAlignmentBaseline((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "baselineShift")
        public /* bridge */ /* synthetic */ void setBaselineShift(View view, Dynamic dynamic) {
            super.setBaselineShift((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((TSpanViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((TSpanViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "content")
        public void setContent(TSpanView tSpanView, @Nullable String str) {
            tSpanView.r = str;
            tSpanView.invalidate();
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "dx")
        public /* bridge */ /* synthetic */ void setDx(View view, Dynamic dynamic) {
            super.setDx((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "dy")
        public /* bridge */ /* synthetic */ void setDy(View view, Dynamic dynamic) {
            super.setDy((TSpanViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((TSpanViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((TSpanViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((TSpanViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "inlineSize")
        public /* bridge */ /* synthetic */ void setInlineSize(View view, Dynamic dynamic) {
            super.setInlineSize((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, @Nullable String str) {
            super.setLengthAdjust((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((TSpanViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((TSpanViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((TSpanViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((TSpanViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((TSpanViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((TSpanViewManager) view, z);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = CLConstants.MODE_ROTATE)
        public /* bridge */ /* synthetic */ void setRotate(View view, Dynamic dynamic) {
            super.setRotate((TSpanViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((TSpanViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((TSpanViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((TSpanViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((TSpanViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((TSpanViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((TSpanViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((TSpanViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "textLength")
        public /* bridge */ /* synthetic */ void setTextLength(View view, Dynamic dynamic) {
            super.setTextLength((TSpanViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((TSpanViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, @Nullable Dynamic dynamic) {
            super.setVerticalAlign((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((TSpanViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((TSpanViewManager) view, dynamic);
        }

        public TSpanViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new RNSVGTSpanManagerDelegate(this);
        }
    }

    public static class TextViewManager extends TextViewManagerAbstract<TextView> implements RNSVGTextManagerInterface<TextView> {
        public static final String REACT_CLASS = "RNSVGText";

        public TextViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGText);
            this.mDelegate = new RNSVGTextManagerDelegate(this);
        }

        @Override // com.horcrux.svg.RenderableViewManager.TextViewManagerAbstract, com.horcrux.svg.RenderableViewManager.GroupViewManagerAbstract, com.horcrux.svg.RenderableViewManager, com.horcrux.svg.VirtualViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
        public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
            super.removeAllViews(view);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, @Nullable String str) {
            super.setAlignmentBaseline((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "baselineShift")
        public /* bridge */ /* synthetic */ void setBaselineShift(View view, Dynamic dynamic) {
            super.setBaselineShift((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i2) {
            super.setClipRule((TextViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            super.setColor((TextViewManager) view, num);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "dx")
        public /* bridge */ /* synthetic */ void setDx(View view, Dynamic dynamic) {
            super.setDx((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "dy")
        public /* bridge */ /* synthetic */ void setDy(View view, Dynamic dynamic) {
            super.setDy((TextViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setFill((TextViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f2) {
            super.setFillOpacity((TextViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i2) {
            super.setFillRule((TextViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            super.setFilter((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "inlineSize")
        public /* bridge */ /* synthetic */ void setInlineSize(View view, Dynamic dynamic) {
            super.setInlineSize((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, @Nullable String str) {
            super.setLengthAdjust((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((TextViewManager) view, str);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((TextViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((TextViewManager) view, str);
        }

        @Override // com.facebook.react.uimanager.BaseViewManager
        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f2) {
            super.setOpacity((TextViewManager) view, f2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((TextViewManager) view, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((TextViewManager) view, readableArray);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((TextViewManager) view, z);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = CLConstants.MODE_ROTATE)
        public /* bridge */ /* synthetic */ void setRotate(View view, Dynamic dynamic) {
            super.setRotate((TextViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable Dynamic dynamic) throws NumberFormatException {
            super.setStroke((TextViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            super.setStrokeDasharray((TextViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f2) {
            super.setStrokeDashoffset((TextViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i2) {
            super.setStrokeLinecap((TextViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i2) {
            super.setStrokeLinejoin((TextViewManager) view, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f2) {
            super.setStrokeMiterlimit((TextViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f2) {
            super.setStrokeOpacity((TextViewManager) view, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            super.setStrokeWidth((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "textLength")
        public /* bridge */ /* synthetic */ void setTextLength(View view, Dynamic dynamic) {
            super.setTextLength((TextViewManager) view, dynamic);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i2) {
            super.setVectorEffect((TextViewManager) view, i2);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, @Nullable Dynamic dynamic) {
            super.setVerticalAlign((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((TextViewManager) view, dynamic);
        }

        @Override // com.facebook.react.viewmanagers.RNSVGTextManagerInterface
        @ReactProp(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((TextViewManager) view, dynamic);
        }

        public TextViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new RNSVGTextManagerDelegate(this);
        }
    }
}
