package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.collections.MarkerManager;

/* loaded from: classes.dex */
public class MapMarker extends MapFeature {
    public boolean A;
    public boolean B;
    public final MapMarkerManager C;
    public String D;
    public final DraweeHolder E;
    public DataSource F;
    public final ControllerListener G;
    public Bitmap H;

    /* renamed from: a, reason: collision with root package name */
    public MarkerOptions f46529a;

    /* renamed from: b, reason: collision with root package name */
    public Marker f46530b;

    /* renamed from: c, reason: collision with root package name */
    public int f46531c;

    /* renamed from: d, reason: collision with root package name */
    public int f46532d;

    /* renamed from: e, reason: collision with root package name */
    public String f46533e;

    /* renamed from: f, reason: collision with root package name */
    public LatLng f46534f;

    /* renamed from: g, reason: collision with root package name */
    public String f46535g;

    /* renamed from: h, reason: collision with root package name */
    public String f46536h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46537i;

    /* renamed from: j, reason: collision with root package name */
    public float f46538j;

    /* renamed from: k, reason: collision with root package name */
    public float f46539k;

    /* renamed from: l, reason: collision with root package name */
    public MapCallout f46540l;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f46541m;
    public final Context n;
    public float o;
    public BitmapDescriptor p;
    public Bitmap q;
    public float r;
    public boolean s;
    public boolean t;
    public int u;
    public float v;
    public float w;
    public float x;
    public boolean y;
    public boolean z;

    public MapMarker(Context context, MarkerOptions markerOptions, MapMarkerManager mapMarkerManager) {
        super(context);
        this.o = 0.0f;
        this.r = 0.0f;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = 1.0f;
        this.z = true;
        this.A = false;
        this.B = false;
        this.G = new BaseControllerListener<ImageInfo>() { // from class: com.rnmaps.maps.MapMarker.1
            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public final void l(String str, Object obj, Animatable animatable) throws Throwable {
                CloseableReference closeableReference;
                Throwable th;
                Bitmap bitmapV1;
                String str2;
                MapMarker mapMarker = MapMarker.this;
                try {
                    closeableReference = (CloseableReference) mapMarker.F.a();
                    if (closeableReference != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) closeableReference.l();
                            if ((closeableImage instanceof CloseableStaticBitmap) && (bitmapV1 = ((CloseableStaticBitmap) closeableImage).v1()) != null) {
                                Bitmap bitmapCopy = bitmapV1.copy(Bitmap.Config.ARGB_8888, true);
                                mapMarker.q = bitmapCopy;
                                mapMarker.p = BitmapDescriptorFactory.c(bitmapCopy);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mapMarker.F.close();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                            throw th;
                        }
                    }
                    mapMarker.F.close();
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    MapMarkerManager mapMarkerManager2 = mapMarker.C;
                    if (mapMarkerManager2 != null && (str2 = mapMarker.D) != null) {
                        mapMarkerManager2.getSharedIcon(str2).a(mapMarker.p, mapMarker.q);
                    }
                    mapMarker.l(true);
                } catch (Throwable th3) {
                    closeableReference = null;
                    th = th3;
                }
            }
        };
        this.H = null;
        this.n = context;
        this.C = mapMarkerManager;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.c(ScalingUtils.ScaleType.f17388e);
        genericDraweeHierarchyBuilder.d();
        DraweeHolder draweeHolderC = DraweeHolder.c(genericDraweeHierarchyBuilder.a());
        this.E = draweeHolderC;
        draweeHolderC.h();
        this.f46534f = markerOptions.D0();
        double dZ = markerOptions.Z();
        double dL0 = markerOptions.l0();
        this.f46537i = true;
        float f2 = (float) dZ;
        this.f46538j = f2;
        float f3 = (float) dL0;
        this.f46539k = f3;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.e(f2, f3);
        }
        l(false);
        double dS0 = markerOptions.s0();
        double dY0 = markerOptions.y0();
        this.y = true;
        float f4 = (float) dS0;
        this.w = f4;
        float f5 = (float) dY0;
        this.x = f5;
        Marker marker2 = this.f46530b;
        if (marker2 != null) {
            marker2.i(f4, f5);
        }
        l(false);
        setTitle(markerOptions.U1());
        setSnippet(markerOptions.T1());
        setRotation(markerOptions.S1());
        setFlat(markerOptions.Z1());
        setDraggable(markerOptions.Y1());
        setZIndex(Math.round(markerOptions.V1()));
        setAlpha(markerOptions.N());
        this.p = markerOptions.n0();
    }

    private BitmapDescriptor getIcon() {
        if (!this.B) {
            BitmapDescriptor bitmapDescriptor = this.p;
            return bitmapDescriptor != null ? bitmapDescriptor : BitmapDescriptorFactory.b(this.o);
        }
        if (this.p == null) {
            return BitmapDescriptorFactory.c(k());
        }
        Bitmap bitmapK = k();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(this.q.getWidth(), bitmapK.getWidth()), Math.max(this.q.getHeight(), bitmapK.getHeight()), this.q.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(this.q, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmapK, 0.0f, 0.0f, (Paint) null);
        return BitmapDescriptorFactory.c(bitmapCreateBitmap);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        super.addView(view, i2);
        if (!(view instanceof MapCallout)) {
            this.B = true;
            n();
        }
        l(true);
    }

    public View getCallout() {
        if (this.f46540l == null) {
            return null;
        }
        if (this.f46541m == null) {
            o();
        }
        if (this.f46540l.getTooltip()) {
            return this.f46541m;
        }
        return null;
    }

    public MapCallout getCalloutView() {
        return this.f46540l;
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46530b;
    }

    public String getIdentifier() {
        return this.f46533e;
    }

    public View getInfoContents() {
        if (this.f46540l == null) {
            return null;
        }
        if (this.f46541m == null) {
            o();
        }
        if (this.f46540l.getTooltip()) {
            return null;
        }
        return this.f46541m;
    }

    public MarkerOptions getMarkerOptions() {
        if (this.f46529a == null) {
            this.f46529a = new MarkerOptions();
        }
        MarkerOptions markerOptions = this.f46529a;
        markerOptions.a2(this.f46534f);
        if (this.f46537i) {
            markerOptions.r(this.f46538j, this.f46539k);
        }
        if (this.y) {
            markerOptions.X1(this.w, this.x);
        }
        markerOptions.d2(this.f46535g);
        markerOptions.c2(this.f46536h);
        markerOptions.b2(this.r);
        markerOptions.A(this.s);
        markerOptions.s(this.t);
        markerOptions.e2(this.u);
        markerOptions.b(this.v);
        markerOptions.W1(getIcon());
        return this.f46529a;
    }

    public LatLng getPosition() {
        return this.f46534f;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        Marker marker = this.f46530b;
        if (marker == null) {
            return;
        }
        ((MarkerManager.Collection) obj).d(marker);
        this.f46530b = null;
        n();
    }

    public final Bitmap k() {
        int i2 = this.f46531c;
        if (i2 <= 0) {
            i2 = 100;
        }
        int i3 = this.f46532d;
        int i4 = i3 > 0 ? i3 : 100;
        buildDrawingCache();
        Bitmap bitmapCreateBitmap = this.H;
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.isRecycled() || bitmapCreateBitmap.getWidth() != i2 || bitmapCreateBitmap.getHeight() != i4) {
            bitmapCreateBitmap = Bitmap.createBitmap(i2, i4, Bitmap.Config.ARGB_8888);
            this.H = bitmapCreateBitmap;
        } else {
            bitmapCreateBitmap.eraseColor(0);
        }
        draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public final void l(boolean z) {
        if (this.f46530b == null) {
            return;
        }
        if (z) {
            m();
        }
        if (this.f46537i) {
            this.f46530b.e(this.f46538j, this.f46539k);
        } else {
            this.f46530b.e(0.5f, 1.0f);
        }
        if (this.y) {
            this.f46530b.i(this.w, this.x);
        } else {
            this.f46530b.i(0.5f, 0.0f);
        }
    }

    public final void m() {
        Marker marker = this.f46530b;
        if (marker == null) {
            return;
        }
        marker.h(getIcon());
    }

    public final void n() {
        boolean z = this.z && this.B && this.f46530b != null;
        if (z == this.A) {
            return;
        }
        this.A = z;
        if (z) {
            ViewChangesTracker.b().a(this);
        } else {
            ViewChangesTracker.b().c(this);
            m();
        }
    }

    public final void o() {
        MapCallout mapCallout = this.f46540l;
        if (mapCallout == null || mapCallout.getChildCount() == 0) {
            return;
        }
        Context context = this.n;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        MapCallout mapCallout2 = this.f46540l;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(mapCallout2.f46483b, mapCallout2.f46484c, 0.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        MapCallout mapCallout3 = this.f46540l;
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(mapCallout3.f46483b, mapCallout3.f46484c, 0.0f));
        linearLayout.addView(linearLayout2);
        linearLayout2.addView(this.f46540l);
        this.f46541m = linearLayout;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (getChildCount() == 0 && this.B) {
            this.B = false;
            this.H = null;
            n();
            l(true);
        }
    }

    public void setCalloutView(MapCallout mapCallout) {
        this.f46540l = mapCallout;
    }

    public void setCoordinate(ReadableMap readableMap) {
        LatLng latLng = new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude"));
        this.f46534f = latLng;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.j(latLng);
        }
        l(false);
    }

    public void setDraggable(boolean z) {
        this.t = z;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.f(z);
        }
        l(false);
    }

    public void setFlat(boolean z) {
        this.s = z;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.g(z);
        }
        l(false);
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.q = bitmap;
    }

    public void setIdentifier(String str) {
        this.f46533e = str;
        l(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setImage(java.lang.String r7) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapMarker.setImage(java.lang.String):void");
    }

    public void setMarkerHue(float f2) {
        this.o = f2;
        l(false);
    }

    public void setOpacity(float f2) {
        this.v = f2;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.d(f2);
        }
        l(false);
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        this.r = f2;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.k(f2);
        }
        l(false);
    }

    public void setSnippet(String str) {
        this.f46536h = str;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.l(str);
        }
        l(false);
    }

    public void setTitle(String str) {
        this.f46535g = str;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.m(str);
        }
        l(false);
    }

    public void setTracksViewChanges(boolean z) {
        this.z = z;
        n();
    }

    public void setZIndex(int i2) {
        this.u = i2;
        Marker marker = this.f46530b;
        if (marker != null) {
            marker.n(i2);
        }
        l(false);
    }

    public MapMarker(ThemedReactContext themedReactContext, MapMarkerManager mapMarkerManager) {
        super(themedReactContext);
        this.o = 0.0f;
        this.r = 0.0f;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = 1.0f;
        this.z = true;
        this.A = false;
        this.B = false;
        this.G = new BaseControllerListener<ImageInfo>() { // from class: com.rnmaps.maps.MapMarker.1
            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public final void l(String str, Object obj, Animatable animatable) throws Throwable {
                CloseableReference closeableReference;
                Throwable th;
                Bitmap bitmapV1;
                String str2;
                MapMarker mapMarker = MapMarker.this;
                try {
                    closeableReference = (CloseableReference) mapMarker.F.a();
                    if (closeableReference != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) closeableReference.l();
                            if ((closeableImage instanceof CloseableStaticBitmap) && (bitmapV1 = ((CloseableStaticBitmap) closeableImage).v1()) != null) {
                                Bitmap bitmapCopy = bitmapV1.copy(Bitmap.Config.ARGB_8888, true);
                                mapMarker.q = bitmapCopy;
                                mapMarker.p = BitmapDescriptorFactory.c(bitmapCopy);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mapMarker.F.close();
                            if (closeableReference != null) {
                                closeableReference.close();
                            }
                            throw th;
                        }
                    }
                    mapMarker.F.close();
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    MapMarkerManager mapMarkerManager2 = mapMarker.C;
                    if (mapMarkerManager2 != null && (str2 = mapMarker.D) != null) {
                        mapMarkerManager2.getSharedIcon(str2).a(mapMarker.p, mapMarker.q);
                    }
                    mapMarker.l(true);
                } catch (Throwable th3) {
                    closeableReference = null;
                    th = th3;
                }
            }
        };
        this.H = null;
        this.n = themedReactContext;
        this.C = mapMarkerManager;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.c(ScalingUtils.ScaleType.f17388e);
        genericDraweeHierarchyBuilder.d();
        DraweeHolder draweeHolderC = DraweeHolder.c(genericDraweeHierarchyBuilder.a());
        this.E = draweeHolderC;
        draweeHolderC.h();
    }
}
