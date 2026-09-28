package com.google.maps.android.data.kml;

import android.graphics.Color;
import android.support.v4.media.b;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/* loaded from: classes4.dex */
public class KmlStyle extends Style {

    /* renamed from: h, reason: collision with root package name */
    public String f45584h;

    /* renamed from: f, reason: collision with root package name */
    public boolean f45582f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f45583g = true;

    /* renamed from: j, reason: collision with root package name */
    public String f45586j = null;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f45580d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f45581e = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    public double f45585i = 1.0d;
    public float n = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    public boolean f45587k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f45588l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f45589m = false;

    public static int b(int i2) {
        Random random = new Random();
        int iRed = Color.red(i2);
        int iGreen = Color.green(i2);
        int iBlue = Color.blue(i2);
        if (iRed != 0) {
            iRed = random.nextInt(iRed);
        }
        if (iBlue != 0) {
            iBlue = random.nextInt(iBlue);
        }
        if (iGreen != 0) {
            iGreen = random.nextInt(iGreen);
        }
        return Color.rgb(iRed, iGreen, iBlue);
    }

    public static String c(String str) {
        String strTrim = str.trim();
        if (strTrim.length() <= 6) {
            return strTrim.substring(4, 6) + strTrim.substring(2, 4) + strTrim.substring(0, 2);
        }
        return strTrim.substring(0, 2) + strTrim.substring(6, 8) + strTrim.substring(4, 6) + strTrim.substring(2, 4);
    }

    public final String d() {
        return this.f45584h;
    }

    public final MarkerOptions e() {
        MarkerOptions markerOptions = this.f45548a;
        boolean z = this.f45587k;
        float f2 = this.n;
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.f38495j = markerOptions.f38495j;
        float f3 = markerOptions.f38490e;
        float f4 = markerOptions.f38491f;
        markerOptions2.f38490e = f3;
        markerOptions2.f38491f = f4;
        if (z) {
            int iB = b((int) f2);
            float[] fArr = new float[3];
            Color.colorToHSV(iB, fArr);
            markerOptions.f38489d = BitmapDescriptorFactory.b(fArr[0]);
        }
        markerOptions2.f38489d = markerOptions.f38489d;
        return markerOptions2;
    }

    public final PolygonOptions f() {
        float f2;
        PolygonOptions polygonOptions = this.f45550c;
        boolean z = this.f45582f;
        boolean z2 = this.f45583g;
        PolygonOptions polygonOptions2 = new PolygonOptions();
        if (z) {
            polygonOptions2.f38516e = polygonOptions.f38516e;
        }
        if (z2) {
            polygonOptions2.f38515d = polygonOptions.f38515d;
            f2 = polygonOptions.f38514c;
        } else {
            f2 = 0.0f;
        }
        polygonOptions2.f38514c = f2;
        polygonOptions2.f38520i = polygonOptions.f38520i;
        return polygonOptions2;
    }

    public final PolylineOptions g() {
        PolylineOptions polylineOptions = this.f45549b;
        PolylineOptions polylineOptions2 = new PolylineOptions();
        polylineOptions2.f38526c = polylineOptions.f38526c;
        polylineOptions2.f38525b = polylineOptions.f38525b;
        polylineOptions2.f38530g = polylineOptions.f38530g;
        return polylineOptions2;
    }

    public final void h(float f2, float f3, String str, String str2) {
        if (!str.equals("fraction")) {
            Log.w("Style", "Hotspot xUnits other than \"fraction\" are not supported.");
            f2 = 0.5f;
        }
        if (!str2.equals("fraction")) {
            Log.w("Style", "Hotspot yUnits other than \"fraction\" are not supported.");
            f3 = 1.0f;
        }
        MarkerOptions markerOptions = this.f45548a;
        markerOptions.f38490e = f2;
        markerOptions.f38491f = f3;
        this.f45581e.add("hotSpot");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Style{\n balloon options=");
        sb.append(this.f45580d);
        sb.append(",\n fill=");
        sb.append(this.f45582f);
        sb.append(",\n outline=");
        sb.append(this.f45583g);
        sb.append(",\n icon url=");
        sb.append(this.f45584h);
        sb.append(",\n scale=");
        sb.append(this.f45585i);
        sb.append(",\n style id=");
        return b.r(sb, this.f45586j, "\n}\n");
    }
}
