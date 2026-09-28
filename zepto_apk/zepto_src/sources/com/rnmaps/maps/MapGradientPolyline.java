package com.rnmaps.maps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.Log;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.io.ByteArrayOutputStream;
import java.util.List;

/* loaded from: classes.dex */
public class MapGradientPolyline extends MapFeature {

    /* renamed from: a, reason: collision with root package name */
    public List f46493a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f46494b;

    /* renamed from: c, reason: collision with root package name */
    public float f46495c;

    /* renamed from: d, reason: collision with root package name */
    public float f46496d;

    /* renamed from: e, reason: collision with root package name */
    public GoogleMap f46497e;

    /* renamed from: f, reason: collision with root package name */
    public TileOverlay f46498f;

    /* renamed from: g, reason: collision with root package name */
    public final ThemedReactContext f46499g;

    /* loaded from: classes4.dex */
    public class AirMapGradientPolylineProvider implements TileProvider {

        /* renamed from: b, reason: collision with root package name */
        public final List f46500b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f46501c;

        /* renamed from: d, reason: collision with root package name */
        public final float f46502d;

        /* renamed from: e, reason: collision with root package name */
        public final float f46503e;

        /* renamed from: f, reason: collision with root package name */
        public final int f46504f;

        /* renamed from: g, reason: collision with root package name */
        public final SphericalMercatorProjection f46505g;

        /* renamed from: h, reason: collision with root package name */
        public final LatLng[] f46506h;

        /* renamed from: i, reason: collision with root package name */
        public final Point[] f46507i;

        /* renamed from: j, reason: collision with root package name */
        public final Point[] f46508j;

        public AirMapGradientPolylineProvider(ThemedReactContext themedReactContext, List list, int[] iArr, float f2) {
            LatLng latLng;
            List list2 = list;
            this.f46500b = list2;
            this.f46501c = iArr;
            this.f46502d = f2;
            float f3 = themedReactContext.getResources().getDisplayMetrics().density;
            this.f46503e = f3;
            this.f46504f = (int) (f3 * 256.0f);
            this.f46505g = new SphericalMercatorProjection(256.0d);
            this.f46506h = new LatLng[list2.size()];
            this.f46507i = new Point[list2.size()];
            int i2 = 0;
            this.f46508j = new Point[Math.max(list2.size() - 1, 0)];
            while (i2 < list2.size()) {
                LatLng latLng2 = (LatLng) list2.get(i2);
                this.f46506h[i2] = latLng2;
                Point[] pointArr = this.f46507i;
                SphericalMercatorProjection sphericalMercatorProjection = this.f46505g;
                pointArr[i2] = sphericalMercatorProjection.a(latLng2);
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    LatLng latLng3 = (LatLng) list2.get(i3);
                    double radians = Math.toRadians(latLng3.f38475a);
                    double d2 = latLng3.f38476b;
                    double radians2 = Math.toRadians(d2);
                    double d3 = latLng2.f38475a;
                    double radians3 = Math.toRadians(d3);
                    double d4 = latLng2.f38476b;
                    double radians4 = Math.toRadians(d4);
                    double dCos = Math.cos(radians);
                    double dCos2 = Math.cos(radians3);
                    double d5 = latLng3.f38475a;
                    double radians5 = Math.toRadians(d5);
                    double radians6 = Math.toRadians(d2);
                    double radians7 = Math.toRadians(d3);
                    double radians8 = radians6 - Math.toRadians(d4);
                    double dSin = Math.sin((radians5 - radians7) * 0.5d);
                    double dSin2 = Math.sin(radians8 * 0.5d);
                    double dAsin = Math.asin(Math.sqrt((Math.cos(radians7) * Math.cos(radians5) * dSin2 * dSin2) + (dSin * dSin))) * 2.0d;
                    double dSin3 = Math.sin(dAsin);
                    if (dSin3 < 1.0E-6d) {
                        latLng = new LatLng(((d3 - d5) * 0.5d) + d5, ((d4 - d2) * 0.5d) + d2);
                    } else {
                        double d6 = 0.5d * dAsin;
                        double dSin4 = Math.sin(d6) / dSin3;
                        double dSin5 = Math.sin(d6) / dSin3;
                        double d7 = dCos * dSin4;
                        double d8 = dCos2 * dSin5;
                        double dCos3 = (Math.cos(radians4) * d8) + (Math.cos(radians2) * d7);
                        double dSin6 = (Math.sin(radians4) * d8) + (Math.sin(radians2) * d7);
                        latLng = new LatLng(Math.toDegrees(Math.atan2((Math.sin(radians3) * dSin5) + (Math.sin(radians) * dSin4), Math.sqrt((dSin6 * dSin6) + (dCos3 * dCos3)))), Math.toDegrees(Math.atan2(dSin6, dCos3)));
                    }
                    this.f46508j[i3] = sphericalMercatorProjection.a(latLng);
                }
                i2++;
                list2 = list;
            }
        }

        @Override // com.google.android.gms.maps.model.TileProvider
        public final Tile a(int i2, int i3, int i4) {
            AirMapGradientPolylineProvider airMapGradientPolylineProvider = this;
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            int i5 = airMapGradientPolylineProvider.f46504f;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i5, config);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Matrix matrix = new Matrix();
            Paint paint = new Paint();
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            float f2 = airMapGradientPolylineProvider.f46502d;
            paint.setStrokeWidth(f2);
            Paint.Cap cap = Paint.Cap.BUTT;
            paint.setStrokeCap(cap);
            Paint.Join join = Paint.Join.ROUND;
            paint.setStrokeJoin(join);
            paint.setFlags(1);
            paint.setShader(new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, airMapGradientPolylineProvider.f46501c, (float[]) null, Shader.TileMode.CLAMP));
            paint.getShader().setLocalMatrix(matrix);
            Paint paint2 = new Paint();
            paint2.setStyle(style);
            paint2.setStrokeWidth(f2);
            paint2.setStrokeCap(cap);
            paint2.setStrokeJoin(join);
            paint2.setFlags(1);
            float fPow = (float) (Math.pow(2.0d, i4) * airMapGradientPolylineProvider.f46503e);
            MutPoint mutPoint = new MutPoint();
            MutPoint mutPoint2 = new MutPoint();
            MutPoint mutPoint3 = new MutPoint();
            MutPoint mutPoint4 = new MutPoint();
            MutPoint mutPoint5 = new MutPoint();
            List list = airMapGradientPolylineProvider.f46500b;
            int size = list.size();
            int[] iArr = airMapGradientPolylineProvider.f46501c;
            if (size == 1) {
                mutPoint.a(airMapGradientPolylineProvider.f46507i[0], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(MapGradientPolyline.l(iArr, 1.0f));
                canvas.drawCircle((float) mutPoint.f46509a, (float) mutPoint.f46510b, paint2.getStrokeWidth() / 2.0f, paint2);
                paint2.setStyle(style);
            } else {
                int i6 = 2;
                if (list.size() == 2) {
                    mutPoint.a(airMapGradientPolylineProvider.f46507i[0], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                    mutPoint2.a(airMapGradientPolylineProvider.f46507i[1], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                    paint2.setColor(MapGradientPolyline.l(iArr, 0.0f));
                    canvas.drawLine((float) mutPoint.f46509a, (float) mutPoint.f46510b, (float) mutPoint2.f46509a, (float) mutPoint2.f46510b, paint2);
                } else {
                    while (i6 < list.size()) {
                        int i7 = i6 - 2;
                        List list2 = list;
                        mutPoint.a(airMapGradientPolylineProvider.f46507i[i7], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                        MutPoint mutPoint6 = mutPoint;
                        int i8 = i6 - 1;
                        mutPoint2.a(airMapGradientPolylineProvider.f46507i[i8], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                        MutPoint mutPoint7 = mutPoint3;
                        mutPoint7.a(airMapGradientPolylineProvider.f46507i[i6], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                        MutPoint mutPoint8 = mutPoint4;
                        mutPoint8.a(airMapGradientPolylineProvider.f46508j[i7], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                        MutPoint mutPoint9 = mutPoint5;
                        mutPoint9.a(airMapGradientPolylineProvider.f46508j[i8], fPow, i2, i3, airMapGradientPolylineProvider.f46504f);
                        float f3 = i6;
                        float size2 = (f3 - 2.0f) / list2.size();
                        float size3 = (f3 - 1.0f) / list2.size();
                        float f4 = (size2 + size3) / 2.0f;
                        Log.d("AirMapGradientPolyline", String.valueOf(f4));
                        paint2.setStyle(Paint.Style.FILL);
                        paint2.setColor(MapGradientPolyline.l(iArr, f4));
                        Matrix matrix2 = matrix;
                        Paint paint3 = paint;
                        canvas.drawCircle((float) mutPoint2.f46509a, (float) mutPoint2.f46510b, paint2.getStrokeWidth() / 2.0f, paint2);
                        paint2.setStyle(Paint.Style.STROKE);
                        MutPoint mutPoint10 = mutPoint2;
                        paint = paint3;
                        matrix = matrix2;
                        airMapGradientPolylineProvider.b(canvas, matrix, paint, paint2, i7 == 0 ? mutPoint6 : mutPoint8, mutPoint10, size2, f4);
                        mutPoint2 = mutPoint10;
                        b(canvas, matrix, paint, paint2, mutPoint2, i6 == list2.size() + (-1) ? mutPoint7 : mutPoint9, f4, size3);
                        i6++;
                        airMapGradientPolylineProvider = this;
                        mutPoint5 = mutPoint9;
                        list = list2;
                        mutPoint = mutPoint6;
                        mutPoint3 = mutPoint7;
                        mutPoint4 = mutPoint8;
                    }
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return new Tile(i5, byteArrayOutputStream.toByteArray(), i5);
        }

        public final void b(Canvas canvas, Matrix matrix, Paint paint, Paint paint2, MutPoint mutPoint, MutPoint mutPoint2, float f2, float f3) {
            if (f2 == f3) {
                paint2.setColor(MapGradientPolyline.l(this.f46501c, f2));
                canvas.drawLine((float) mutPoint.f46509a, (float) mutPoint.f46510b, (float) mutPoint2.f46509a, (float) mutPoint2.f46510b, paint2);
                return;
            }
            matrix.reset();
            matrix.preRotate((float) Math.toDegrees(Math.atan2(mutPoint2.f46510b - mutPoint.f46510b, mutPoint2.f46509a - mutPoint.f46509a)), (float) mutPoint.f46509a, (float) mutPoint.f46510b);
            matrix.preTranslate((float) mutPoint.f46509a, (float) mutPoint.f46510b);
            float fSqrt = (float) Math.sqrt(Math.pow(mutPoint2.f46510b - mutPoint.f46510b, 2.0d) + Math.pow(mutPoint2.f46509a - mutPoint.f46509a, 2.0d));
            matrix.preScale(fSqrt, fSqrt);
            float f4 = 1.0f / (f3 - f2);
            matrix.preScale(f4, f4);
            matrix.preTranslate(-f2, 0.0f);
            paint.getShader().setLocalMatrix(matrix);
            canvas.drawLine((float) mutPoint.f46509a, (float) mutPoint.f46510b, (float) mutPoint2.f46509a, (float) mutPoint2.f46510b, paint);
        }
    }

    /* loaded from: classes4.dex */
    public static class MutPoint {

        /* renamed from: a, reason: collision with root package name */
        public double f46509a;

        /* renamed from: b, reason: collision with root package name */
        public double f46510b;

        public final void a(Point point, float f2, int i2, int i3, int i4) {
            double d2 = f2;
            this.f46509a = (point.f45596a * d2) - (i2 * i4);
            this.f46510b = (point.f45597b * d2) - (i3 * i4);
        }
    }

    public MapGradientPolyline(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f46499g = themedReactContext;
    }

    public static int l(int[] iArr, float f2) {
        float length = f2 * (iArr.length - 1);
        int iRed = 0;
        int iGreen = 0;
        int iBlue = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float fMax = Math.max(1.0f - Math.abs(length - i2), 0.0f);
            iRed += (int) (Color.red(iArr[i2]) * fMax);
            iGreen += (int) (Color.green(iArr[i2]) * fMax);
            iBlue += (int) (Color.blue(iArr[i2]) * fMax);
        }
        return Color.rgb(iRed, iGreen, iBlue);
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46498f;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        this.f46498f.b();
    }

    public final TileOverlayOptions k() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.s(this.f46495c);
        tileOverlayOptions.b(new AirMapGradientPolylineProvider(this.f46499g, this.f46493a, this.f46494b, this.f46496d));
        return tileOverlayOptions;
    }

    public void setCoordinates(List<LatLng> list) {
        this.f46493a = list;
        TileOverlay tileOverlay = this.f46498f;
        if (tileOverlay != null) {
            tileOverlay.b();
        }
        GoogleMap googleMap = this.f46497e;
        if (googleMap != null) {
            this.f46498f = googleMap.a(k());
        }
    }

    public void setStrokeColors(int[] iArr) {
        this.f46494b = iArr;
        TileOverlay tileOverlay = this.f46498f;
        if (tileOverlay != null) {
            tileOverlay.b();
        }
        GoogleMap googleMap = this.f46497e;
        if (googleMap != null) {
            this.f46498f = googleMap.a(k());
        }
    }

    public void setWidth(float f2) {
        this.f46496d = f2;
        TileOverlay tileOverlay = this.f46498f;
        if (tileOverlay != null) {
            tileOverlay.b();
        }
        GoogleMap googleMap = this.f46497e;
        if (googleMap != null) {
            this.f46498f = googleMap.a(k());
        }
    }

    public void setZIndex(float f2) {
        this.f46495c = f2;
        TileOverlay tileOverlay = this.f46498f;
        if (tileOverlay != null) {
            tileOverlay.d(f2);
        }
    }
}
