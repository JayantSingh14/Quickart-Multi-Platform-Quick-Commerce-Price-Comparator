package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.uimanager.PointerEvents;
import com.horcrux.svg.Brush;
import com.horcrux.svg.FilterProperties;
import com.horcrux.svg.MaskView;
import in.juspay.hypersdk.core.PaymentConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class RenderableView extends VirtualView implements ReactHitSlopView {
    private static final int CAP_BUTT = 0;
    static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;
    private static final int FILL_RULE_EVENODD = 0;
    static final int FILL_RULE_NONZERO = 1;
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    static final int JOIN_ROUND = 1;
    private static final int VECTOR_EFFECT_DEFAULT = 0;
    private static final int VECTOR_EFFECT_NON_SCALING_STROKE = 1;
    static RenderableView contextElement;
    private static final Pattern regex = Pattern.compile("[0-9.-]+");

    @Nullable
    public ReadableArray fill;
    public float fillOpacity;
    public Path.FillType fillRule;

    @Nullable
    private ArrayList<String> mAttributeList;

    @Nullable
    private RenderableView mCaller;
    private int mCurrentColor;

    @Nullable
    String mFilter;

    @Nullable
    private ArrayList<String> mLastMergedList;

    @Nullable
    private ArrayList<Object> mOriginProperties;

    @Nullable
    private ArrayList<String> mPropList;

    @Nullable
    public ReadableArray stroke;

    @Nullable
    public SVGLength[] strokeDasharray;
    public float strokeDashoffset;
    public Paint.Cap strokeLinecap;
    public Paint.Join strokeLinejoin;
    public float strokeMiterlimit;
    public float strokeOpacity;
    public SVGLength strokeWidth;
    public int vectorEffect;

    /* renamed from: com.horcrux.svg.RenderableView$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45851a;

        static {
            int[] iArr = new int[RNSVGMarkerType.values().length];
            f45851a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45851a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45851a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public RenderableView(ReactContext reactContext) {
        super(reactContext);
        this.vectorEffect = 0;
        this.strokeWidth = new SVGLength(1.0d);
        this.strokeOpacity = 1.0f;
        this.strokeMiterlimit = 4.0f;
        this.strokeDashoffset = 0.0f;
        this.strokeLinecap = Paint.Cap.BUTT;
        this.strokeLinejoin = Paint.Join.MITER;
        this.mCurrentColor = 0;
        this.fillOpacity = 1.0f;
        this.fillRule = Path.FillType.WINDING;
        setPivotX(0.0f);
        setPivotY(0.0f);
    }

    private ArrayList<String> getAttributeList() {
        return this.mAttributeList;
    }

    private boolean hasOwnProperty(String str) {
        ArrayList<String> arrayList = this.mAttributeList;
        return arrayList != null && arrayList.contains(str);
    }

    private void setupPaint(Paint paint, float f2, ReadableArray readableArray) {
        ReadableArray readableArray2;
        RenderableView renderableView;
        ReadableArray readableArray3;
        int i2 = readableArray.getInt(0);
        if (i2 == 0) {
            if (readableArray.size() != 2) {
                paint.setARGB((int) (readableArray.size() > 4 ? readableArray.getDouble(4) * f2 * 255.0d : f2 * 255.0f), (int) (readableArray.getDouble(1) * 255.0d), (int) (readableArray.getDouble(2) * 255.0d), (int) (readableArray.getDouble(3) * 255.0d));
                return;
            } else {
                paint.setColor((Math.round((r13 >>> 24) * f2) << 24) | ((readableArray.getType(1) == ReadableType.Map ? ColorPropConverter.getColor(readableArray.getMap(1), getContext()).intValue() : readableArray.getInt(1)) & 16777215));
                return;
            }
        }
        if (i2 == 1) {
            Brush definedBrush = getSvgView().getDefinedBrush(readableArray.getString(1));
            if (definedBrush != null) {
                definedBrush.g(paint, this.mBox, this.mScale, f2);
                return;
            }
            return;
        }
        if (i2 == 2) {
            paint.setColor((Math.round((r13 >>> 24) * f2) << 24) | (getCurrentColor() & 16777215));
            return;
        }
        if (i2 != 3) {
            if (i2 != 4 || (renderableView = contextElement) == null || (readableArray3 = renderableView.stroke) == null) {
                return;
            }
            setupPaint(paint, f2, readableArray3);
            return;
        }
        RenderableView renderableView2 = contextElement;
        if (renderableView2 == null || (readableArray2 = renderableView2.fill) == null) {
            return;
        }
        setupPaint(paint, f2, readableArray2);
    }

    @Override // com.horcrux.svg.VirtualView
    public void draw(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.mOpacity;
        boolean z = this.mPath == null;
        if (z) {
            Path path = getPath(canvas, paint);
            this.mPath = path;
            path.setFillType(this.fillRule);
        }
        boolean z2 = this.vectorEffect == 1;
        Path path2 = this.mPath;
        if (z2) {
            path2 = new Path();
            this.mPath.transform(this.mCTM, path2);
            canvas.setMatrix(null);
        }
        if (z || path2 != this.mPath) {
            RectF rectF = new RectF();
            this.mBox = rectF;
            path2.computeBounds(rectF, true);
        }
        RectF rectF2 = new RectF(this.mBox);
        this.mCTM.mapRect(rectF2);
        setClientRect(rectF2);
        clip(canvas, paint);
        if (setupFillPaint(paint, this.fillOpacity * f3)) {
            if (z) {
                Path path3 = new Path();
                this.mFillPath = path3;
                paint.getFillPath(path2, path3);
            }
            canvas.drawPath(path2, paint);
        }
        if (setupStrokePaint(paint, this.strokeOpacity * f3)) {
            if (z) {
                Path path4 = new Path();
                this.mStrokePath = path4;
                paint.getFillPath(path2, path4);
            }
            canvas.drawPath(path2, paint);
        }
        renderMarkers(canvas, paint, f3);
    }

    public int getCurrentColor() {
        int i2 = this.mCurrentColor;
        if (i2 != 0) {
            return i2;
        }
        RenderableView renderableView = this.mCaller;
        if (renderableView != null) {
            return renderableView.getCurrentColor();
        }
        ViewParent parent = getParent();
        if (parent instanceof VirtualView) {
            return ((RenderableView) parent).getCurrentColor();
        }
        if (parent instanceof SvgView) {
            return ((SvgView) parent).mCurrentColor;
        }
        return 0;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, com.facebook.react.touch.ReactHitSlopView
    @Nullable
    public Rect getHitSlopRect() {
        if (((VirtualView) this).mPointerEvents == PointerEvents.f19426c) {
            return new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        return null;
    }

    @Override // com.horcrux.svg.VirtualView
    public abstract Path getPath(Canvas canvas, Paint paint);

    public Region getRegion(Path path, RectF rectF) {
        Region region = new Region();
        region.setPath(path, new Region((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom)));
        return region;
    }

    @Override // com.horcrux.svg.VirtualView
    public int hitTest(float[] fArr) {
        Region region;
        Region region2;
        if (this.mPath == null || !this.mInvertible || ((VirtualView) this).mPointerEvents == PointerEvents.f19425b) {
            return -1;
        }
        float[] fArr2 = new float[2];
        this.mInvMatrix.mapPoints(fArr2, fArr);
        this.mInvTransform.mapPoints(fArr2);
        int iRound = Math.round(fArr2[0]);
        int iRound2 = Math.round(fArr2[1]);
        initBounds();
        Region region3 = this.mRegion;
        if ((region3 != null && region3.contains(iRound, iRound2)) || ((region = this.mStrokeRegion) != null && (region.contains(iRound, iRound2) || ((region2 = this.mMarkerRegion) != null && region2.contains(iRound, iRound2))))) {
            if (getClipPath() == null || this.mClipRegion.contains(iRound, iRound2)) {
                return getId();
            }
            return -1;
        }
        return -1;
    }

    public void initBounds() {
        if (this.mRegion == null && this.mFillPath != null) {
            RectF rectF = new RectF();
            this.mFillBounds = rectF;
            this.mFillPath.computeBounds(rectF, true);
            this.mRegion = getRegion(this.mFillPath, this.mFillBounds);
        }
        if (this.mRegion == null && this.mPath != null) {
            RectF rectF2 = new RectF();
            this.mFillBounds = rectF2;
            this.mPath.computeBounds(rectF2, true);
            this.mRegion = getRegion(this.mPath, this.mFillBounds);
        }
        if (this.mStrokeRegion == null && this.mStrokePath != null) {
            RectF rectF3 = new RectF();
            this.mStrokeBounds = rectF3;
            this.mStrokePath.computeBounds(rectF3, true);
            this.mStrokeRegion = getRegion(this.mStrokePath, this.mStrokeBounds);
        }
        if (this.mMarkerRegion == null && this.mMarkerPath != null) {
            RectF rectF4 = new RectF();
            this.mMarkerBounds = rectF4;
            this.mMarkerPath.computeBounds(rectF4, true);
            this.mMarkerRegion = getRegion(this.mMarkerPath, this.mMarkerBounds);
        }
        Path clipPath = getClipPath();
        if (clipPath == null || this.mClipRegionPath == clipPath) {
            return;
        }
        this.mClipRegionPath = clipPath;
        RectF rectF5 = new RectF();
        this.mClipBounds = rectF5;
        clipPath.computeBounds(rectF5, true);
        this.mClipRegion = getRegion(clipPath, this.mClipBounds);
    }

    public void mergeProperties(RenderableView renderableView) {
        this.mCaller = renderableView;
        ArrayList<String> attributeList = renderableView.getAttributeList();
        if (attributeList == null || attributeList.size() == 0) {
            return;
        }
        this.mOriginProperties = new ArrayList<>();
        this.mAttributeList = this.mPropList == null ? new ArrayList<>() : new ArrayList<>(this.mPropList);
        int size = attributeList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                String str = attributeList.get(i2);
                Field field = getClass().getField(str);
                Object obj = field.get(renderableView);
                this.mOriginProperties.add(field.get(this));
                if (!hasOwnProperty(str)) {
                    this.mAttributeList.add(str);
                    field.set(this, obj);
                }
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        this.mLastMergedList = attributeList;
    }

    @Override // com.horcrux.svg.VirtualView
    public void render(Canvas canvas, Paint paint, float f2) {
        RectF rectF;
        RectF rectF2;
        int i2;
        MaskView maskView = this.mMask != null ? (MaskView) getSvgView().getDefinedMask(this.mMask) : null;
        FilterView filterView = this.mFilter != null ? (FilterView) getSvgView().getDefinedFilter(this.mFilter) : null;
        if (maskView == null && filterView == null) {
            draw(canvas, paint, f2);
            return;
        }
        if (filterView != null) {
            Paint paint2 = new Paint(2);
            canvas.saveLayer(null, paint2);
            Bitmap currentBitmap = getSvgView().getCurrentBitmap();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            canvas2.setMatrix(canvas.getMatrix());
            draw(canvas2, paint, f2);
            initBounds();
            RectF clientRect = getClientRect();
            if ((this instanceof ImageView) && clientRect == null) {
                return;
            }
            HashMap map = filterView.f45708a;
            map.clear();
            map.put("SourceGraphic", bitmapCreateBitmap);
            map.put("SourceAlpha", FilterUtils.applySourceAlphaFilter(bitmapCreateBitmap));
            map.put("BackgroundImage", currentBitmap);
            map.put("BackgroundAlpha", FilterUtils.applySourceAlphaFilter(currentBitmap));
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), bitmapCreateBitmap.getConfig());
            Canvas canvas3 = new Canvas(bitmapCreateBitmap2);
            Rect cropRect = filterView.f45711d.getCropRect(filterView, filterView.f45709b, clientRect);
            int i3 = 0;
            int i4 = 0;
            while (i4 < filterView.getChildCount()) {
                View childAt = filterView.getChildAt(i4);
                if (childAt instanceof FilterPrimitiveView) {
                    FilterPrimitiveView filterPrimitiveView = (FilterPrimitiveView) childAt;
                    bitmapCreateBitmap2.eraseColor(i3);
                    FilterRegion filterRegion = filterPrimitiveView.f45688b;
                    FilterProperties.Units units = filterView.f45710c;
                    i2 = i4;
                    Rect cropRect2 = filterRegion.getCropRect(filterPrimitiveView, units, units == FilterProperties.Units.USER_SPACE_ON_USE ? new RectF(cropRect) : clientRect);
                    canvas3.drawBitmap(filterPrimitiveView.j(map, bitmapCreateBitmap), cropRect2, cropRect2, (Paint) null);
                    Bitmap bitmapCopy = bitmapCreateBitmap2.copy(Bitmap.Config.ARGB_8888, true);
                    String str = filterPrimitiveView.f45687a;
                    if (str != null) {
                        map.put(str, bitmapCopy);
                    }
                    bitmapCreateBitmap = bitmapCopy;
                } else {
                    i2 = i4;
                    Log.e("RNSVG", "Invalid `Filter` child: Filter children can only be `Fe...` components");
                }
                i4 = i2 + 1;
                i3 = 0;
            }
            bitmapCreateBitmap2.eraseColor(i3);
            rectF = null;
            canvas3.drawBitmap(bitmapCreateBitmap, cropRect, cropRect, (Paint) null);
            int iSave = canvas.save();
            canvas.setMatrix(null);
            canvas.drawBitmap(bitmapCreateBitmap2, 0.0f, 0.0f, paint2);
            canvas.restoreToCount(iSave);
        } else {
            rectF = null;
            canvas.saveLayer(null, new Paint());
            draw(canvas, paint, f2);
        }
        if (maskView != null) {
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.saveLayer(rectF, paint3);
            if (maskView.f45789k == MaskView.MaskType.f45790a) {
                Paint paint4 = new Paint();
                paint4.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2125f, 0.7154f, 0.0721f, 0.0f, 0.0f})));
                canvas.saveLayer(null, paint4);
            } else {
                canvas.saveLayer(null, paint);
            }
            if (maskView.f45788j == Brush.BrushUnits.f45646b) {
                float fRelativeOnWidth = (float) relativeOnWidth(maskView.f45784f);
                float fRelativeOnHeight = (float) relativeOnHeight(maskView.f45785g);
                rectF2 = new RectF(fRelativeOnWidth, fRelativeOnHeight, ((float) relativeOnWidth(maskView.f45786h)) + fRelativeOnWidth, ((float) relativeOnHeight(maskView.f45787i)) + fRelativeOnHeight);
            } else {
                RectF clientRect2 = getClientRect();
                if ((this instanceof ImageView) && clientRect2 == null) {
                    return;
                }
                this.mInvCTM.mapRect(clientRect2);
                float fRelativeOnFraction = (float) relativeOnFraction(maskView.f45784f, clientRect2.width());
                float fRelativeOnFraction2 = (float) relativeOnFraction(maskView.f45785g, clientRect2.height());
                float fRelativeOnFraction3 = (float) relativeOnFraction(maskView.f45786h, clientRect2.width());
                float fRelativeOnFraction4 = (float) relativeOnFraction(maskView.f45787i, clientRect2.height());
                float f3 = clientRect2.left + fRelativeOnFraction;
                float f4 = clientRect2.top + fRelativeOnFraction2;
                rectF2 = new RectF(f3, f4, fRelativeOnFraction3 + f3, fRelativeOnFraction4 + f4);
            }
            canvas.clipRect(rectF2);
            maskView.draw(canvas, paint, 1.0f);
            canvas.restore();
            canvas.saveLayer(null, paint3);
            canvas.clipRect(rectF2);
            maskView.draw(canvas, paint, 1.0f);
            canvas.restore();
            canvas.restore();
        }
        canvas.restore();
    }

    public void renderMarkers(Canvas canvas, Paint paint, float f2) {
        MarkerView markerView;
        MarkerView markerView2 = (MarkerView) getSvgView().getDefinedMarker(this.mMarkerStart);
        MarkerView markerView3 = (MarkerView) getSvgView().getDefinedMarker(this.mMarkerMid);
        MarkerView markerView4 = (MarkerView) getSvgView().getDefinedMarker(this.mMarkerEnd);
        ArrayList<PathElement> arrayList = this.elements;
        if (arrayList == null) {
            return;
        }
        if (markerView2 == null && markerView3 == null && markerView4 == null) {
            return;
        }
        contextElement = this;
        ArrayList arrayListC = RNSVGMarkerPosition.c(arrayList);
        SVGLength sVGLength = this.strokeWidth;
        float fRelativeOnOther = (float) (sVGLength != null ? relativeOnOther(sVGLength) : 1.0d);
        this.mMarkerPath = new Path();
        Iterator it = arrayListC.iterator();
        while (true) {
            MarkerView markerView5 = null;
            if (!it.hasNext()) {
                contextElement = null;
                return;
            }
            RNSVGMarkerPosition rNSVGMarkerPosition = (RNSVGMarkerPosition) it.next();
            int iOrdinal = rNSVGMarkerPosition.f45826a.ordinal();
            if (iOrdinal == 0) {
                markerView5 = markerView2;
            } else if (iOrdinal == 1) {
                markerView5 = markerView3;
            } else if (iOrdinal == 2) {
                markerView5 = markerView4;
            }
            if (markerView5 != null) {
                int iSaveAndSetupCanvas = markerView5.saveAndSetupCanvas(canvas, markerView5.mCTM);
                Matrix matrix = markerView5.r;
                matrix.reset();
                Point point = rNSVGMarkerPosition.f45827b;
                matrix.setTranslate((float) point.f45817a, (float) point.f45818b);
                double d2 = "auto".equals(markerView5.f45781k) ? -1.0d : Double.parseDouble(markerView5.f45781k);
                matrix.preRotate(((float) (d2 == -1.0d ? rNSVGMarkerPosition.f45828c : d2)) + 180.0f);
                if ("strokeWidth".equals(markerView5.f45780j)) {
                    float f3 = fRelativeOnOther / markerView5.mScale;
                    matrix.preScale(f3, f3);
                }
                MarkerView markerView6 = markerView2;
                MarkerView markerView7 = markerView3;
                RectF rectF = new RectF(0.0f, 0.0f, (float) (markerView5.relativeOnWidth(markerView5.f45778h) / markerView5.mScale), (float) (markerView5.relativeOnHeight(markerView5.f45779i) / markerView5.mScale));
                if (markerView5.p != null) {
                    float f4 = markerView5.f45782l;
                    float f5 = markerView5.mScale;
                    float f6 = markerView5.f45783m;
                    markerView = markerView4;
                    float[] fArr = new float[9];
                    ViewBox.a(new RectF(f4 * f5, f6 * f5, (f4 + markerView5.n) * f5, (f6 + markerView5.o) * f5), rectF, markerView5.p, markerView5.q).getValues(fArr);
                    matrix.preScale(fArr[0], fArr[4]);
                } else {
                    markerView = markerView4;
                }
                matrix.preTranslate((float) (-markerView5.relativeOnWidth(markerView5.f45776f)), (float) (-markerView5.relativeOnHeight(markerView5.f45777g)));
                canvas.concat(matrix);
                markerView5.j(canvas, paint, f2);
                markerView5.restoreCanvas(canvas, iSaveAndSetupCanvas);
                this.mMarkerPath.addPath(markerView5.getPath(canvas, paint), matrix);
                markerView2 = markerView6;
                markerView3 = markerView7;
                markerView4 = markerView;
            }
        }
    }

    public void resetProperties() {
        ArrayList<String> arrayList = this.mLastMergedList;
        if (arrayList == null || this.mOriginProperties == null) {
            return;
        }
        try {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                getClass().getField(this.mLastMergedList.get(size)).set(this, this.mOriginProperties.get(size));
            }
            this.mLastMergedList = null;
            this.mOriginProperties = null;
            this.mAttributeList = this.mPropList;
            this.mCaller = null;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void setCurrentColor(Integer num) {
        this.mCurrentColor = num != null ? num.intValue() : 0;
        invalidate();
        clearChildCache();
    }

    public void setFill(@Nullable Dynamic dynamic) throws NumberFormatException {
        if (dynamic == null || dynamic.isNull()) {
            this.fill = null;
            invalidate();
            return;
        }
        ReadableType type = dynamic.getType();
        if (type.equals(ReadableType.Map)) {
            setFill(dynamic.asMap());
            return;
        }
        int i2 = 0;
        if (type.equals(ReadableType.Number)) {
            this.fill = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
        } else if (type.equals(ReadableType.Array)) {
            this.fill = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                double d2 = Double.parseDouble(matcher.group());
                int i3 = i2 + 1;
                if (i2 < 3) {
                    d2 /= 255.0d;
                }
                javaOnlyArray.pushDouble(d2);
                i2 = i3;
            }
            this.fill = javaOnlyArray;
        }
        invalidate();
    }

    public void setFillOpacity(float f2) {
        this.fillOpacity = f2;
        invalidate();
    }

    public void setFillRule(int i2) {
        if (i2 == 0) {
            this.fillRule = Path.FillType.EVEN_ODD;
        } else if (i2 != 1) {
            throw new JSApplicationIllegalArgumentException(android.support.v4.media.b.g(i2, "fillRule ", " unrecognized"));
        }
        invalidate();
    }

    public void setFilter(String str) {
        this.mFilter = str;
        invalidate();
    }

    @Override // android.view.View
    public void setId(int i2) {
        super.setId(i2);
        VirtualViewManager.setRenderableView(i2, this);
    }

    public void setPropList(@Nullable ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mAttributeList = arrayList;
            this.mPropList = arrayList;
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                this.mPropList.add(readableArray.getString(i2));
            }
        }
        invalidate();
    }

    public void setStroke(@Nullable Dynamic dynamic) throws NumberFormatException {
        if (dynamic == null || dynamic.isNull()) {
            this.stroke = null;
            invalidate();
            return;
        }
        if (dynamic.getType().equals(ReadableType.Map)) {
            setStroke(dynamic.asMap());
            return;
        }
        ReadableType type = dynamic.getType();
        int i2 = 0;
        if (type.equals(ReadableType.Number)) {
            this.stroke = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
        } else if (type.equals(ReadableType.Array)) {
            this.stroke = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                double d2 = Double.parseDouble(matcher.group());
                int i3 = i2 + 1;
                if (i2 < 3) {
                    d2 /= 255.0d;
                }
                javaOnlyArray.pushDouble(d2);
                i2 = i3;
            }
            this.stroke = javaOnlyArray;
        }
        invalidate();
    }

    public void setStrokeDasharray(Dynamic dynamic) {
        ArrayList arrayListA = SVGLength.a(dynamic);
        if (arrayListA != null) {
            if (arrayListA.size() % 2 == 1) {
                arrayListA.addAll(arrayListA);
            }
            this.strokeDasharray = (SVGLength[]) arrayListA.toArray(new SVGLength[0]);
        } else {
            this.strokeDasharray = null;
        }
        invalidate();
    }

    public void setStrokeDashoffset(float f2) {
        this.strokeDashoffset = f2 * this.mScale;
        invalidate();
    }

    public void setStrokeLinecap(int i2) {
        if (i2 == 0) {
            this.strokeLinecap = Paint.Cap.BUTT;
        } else if (i2 == 1) {
            this.strokeLinecap = Paint.Cap.ROUND;
        } else {
            if (i2 != 2) {
                throw new JSApplicationIllegalArgumentException(android.support.v4.media.b.g(i2, "strokeLinecap ", " unrecognized"));
            }
            this.strokeLinecap = Paint.Cap.SQUARE;
        }
        invalidate();
    }

    public void setStrokeLinejoin(int i2) {
        if (i2 == 0) {
            this.strokeLinejoin = Paint.Join.MITER;
        } else if (i2 == 1) {
            this.strokeLinejoin = Paint.Join.ROUND;
        } else {
            if (i2 != 2) {
                throw new JSApplicationIllegalArgumentException(android.support.v4.media.b.g(i2, "strokeLinejoin ", " unrecognized"));
            }
            this.strokeLinejoin = Paint.Join.BEVEL;
        }
        invalidate();
    }

    public void setStrokeMiterlimit(float f2) {
        this.strokeMiterlimit = f2;
        invalidate();
    }

    public void setStrokeOpacity(float f2) {
        this.strokeOpacity = f2;
        invalidate();
    }

    public void setStrokeWidth(Dynamic dynamic) {
        this.strokeWidth = dynamic.isNull() ? new SVGLength(1.0d) : SVGLength.b(dynamic);
        invalidate();
    }

    public void setVectorEffect(int i2) {
        this.vectorEffect = i2;
        invalidate();
    }

    public boolean setupFillPaint(Paint paint, float f2) {
        ReadableArray readableArray = this.fill;
        if (readableArray == null || readableArray.size() <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(385);
        paint.setStyle(Paint.Style.FILL);
        setupPaint(paint, f2, this.fill);
        return true;
    }

    public boolean setupStrokePaint(Paint paint, float f2) {
        ReadableArray readableArray;
        paint.reset();
        double dRelativeOnOther = relativeOnOther(this.strokeWidth);
        if (dRelativeOnOther == 0.0d || (readableArray = this.stroke) == null || readableArray.size() == 0) {
            return false;
        }
        paint.setFlags(385);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.strokeLinecap);
        paint.setStrokeJoin(this.strokeLinejoin);
        paint.setStrokeMiter(this.strokeMiterlimit * this.mScale);
        paint.setStrokeWidth((float) dRelativeOnOther);
        setupPaint(paint, f2, this.stroke);
        SVGLength[] sVGLengthArr = this.strokeDasharray;
        if (sVGLengthArr == null) {
            return true;
        }
        int length = sVGLengthArr.length;
        float[] fArr = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2] = (float) relativeOnOther(this.strokeDasharray[i2]);
        }
        paint.setPathEffect(new DashPathEffect(fArr, this.strokeDashoffset));
        return true;
    }

    public void setFill(ReadableMap readableMap) {
        if (readableMap == null) {
            this.fill = null;
            invalidate();
            return;
        }
        int i2 = readableMap.getInt("type");
        if (i2 == 0) {
            ReadableType type = readableMap.getType(PaymentConstants.PAYLOAD);
            if (type.equals(ReadableType.Number)) {
                this.fill = JavaOnlyArray.of(0, Integer.valueOf(readableMap.getInt(PaymentConstants.PAYLOAD)));
            } else if (type.equals(ReadableType.Map)) {
                this.fill = JavaOnlyArray.of(0, readableMap.getMap(PaymentConstants.PAYLOAD));
            }
        } else if (i2 == 1) {
            this.fill = JavaOnlyArray.of(1, readableMap.getString("brushRef"));
        } else {
            this.fill = JavaOnlyArray.of(Integer.valueOf(i2));
        }
        invalidate();
    }

    public void setStroke(@Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            this.stroke = null;
            invalidate();
            return;
        }
        int i2 = readableMap.getInt("type");
        if (i2 == 0) {
            ReadableType type = readableMap.getType(PaymentConstants.PAYLOAD);
            if (type.equals(ReadableType.Number)) {
                this.stroke = JavaOnlyArray.of(0, Integer.valueOf(readableMap.getInt(PaymentConstants.PAYLOAD)));
            } else if (type.equals(ReadableType.Map)) {
                this.stroke = JavaOnlyArray.of(0, readableMap.getMap(PaymentConstants.PAYLOAD));
            }
        } else if (i2 == 1) {
            this.stroke = JavaOnlyArray.of(1, readableMap.getString("brushRef"));
        } else {
            this.stroke = JavaOnlyArray.of(Integer.valueOf(i2));
        }
        invalidate();
    }
}
