package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzftb {

    /* renamed from: a, reason: collision with root package name */
    public static WindowManager f31821a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f31822b = {"x", "y", Snapshot.WIDTH, Snapshot.HEIGHT};

    /* renamed from: c, reason: collision with root package name */
    public static float f31823c = Resources.getSystem().getDisplayMetrics().density;

    public static JSONObject a(int i2, int i3, int i4, int i5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", i2 / f31823c);
            jSONObject.put("y", i3 / f31823c);
            jSONObject.put(Snapshot.WIDTH, i4 / f31823c);
            jSONObject.put(Snapshot.HEIGHT, i5 / f31823c);
            return jSONObject;
        } catch (JSONException e2) {
            zzftc.a("Error with creating viewStateObject", e2);
            return jSONObject;
        }
    }

    public static void b(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e2) {
            StringBuilder sb = new StringBuilder(str.length() + 47);
            sb.append("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
            zzftc.a(sb.toString(), e2);
        }
    }

    public static void c(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArrayOptJSONArray);
            }
            jSONArrayOptJSONArray.put(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        float f2;
        float f3;
        if (f31821a != null) {
            Point point = new Point(0, 0);
            f31821a.getDefaultDisplay().getRealSize(point);
            float f4 = point.x;
            float f5 = f31823c;
            f2 = f4 / f5;
            f3 = point.y / f5;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        try {
            jSONObject.put(Snapshot.WIDTH, f2);
            jSONObject.put(Snapshot.HEIGHT, f3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(org.json.JSONObject r8, org.json.JSONObject r9) {
        /*
            if (r8 != 0) goto L4
            if (r9 == 0) goto Ld9
        L4:
            r0 = 0
            if (r8 == 0) goto Ldb
            if (r9 != 0) goto Lb
            goto Ldb
        Lb:
            java.lang.String[] r1 = com.google.android.gms.internal.ads.zzftb.f31822b
            r2 = r0
        Le:
            r3 = 4
            if (r2 >= r3) goto L24
            r3 = r1[r2]
            double r4 = r8.optDouble(r3)
            double r6 = r9.optDouble(r3)
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 == 0) goto L21
            goto Ldb
        L21:
            int r2 = r2 + 1
            goto Le
        L24:
            java.lang.String r1 = "adSessionId"
            java.lang.String r2 = ""
            java.lang.String r3 = r8.optString(r1, r2)
            java.lang.String r1 = r9.optString(r1, r2)
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto Ldb
            java.lang.String r1 = "noOutputDevice"
            boolean r3 = r8.optBoolean(r1)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r1 = r9.optBoolean(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto Ldb
            java.lang.String r1 = "hasWindowFocus"
            boolean r3 = r8.optBoolean(r1)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r1 = r9.optBoolean(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto Ldb
            java.lang.String r1 = "isFriendlyObstructionFor"
            org.json.JSONArray r3 = r8.optJSONArray(r1)
            org.json.JSONArray r1 = r9.optJSONArray(r1)
            if (r3 != 0) goto L75
            if (r1 != 0) goto L75
            goto La0
        L75:
            if (r3 != 0) goto L79
            if (r1 == 0) goto L88
        L79:
            if (r3 == 0) goto Ldb
            if (r1 != 0) goto L7e
            goto Ldb
        L7e:
            int r4 = r3.length()
            int r5 = r1.length()
            if (r4 != r5) goto Ldb
        L88:
            r4 = r0
        L89:
            int r5 = r3.length()
            if (r4 >= r5) goto La0
            java.lang.String r5 = r3.optString(r4, r2)
            java.lang.String r6 = r1.optString(r4, r2)
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto Ldb
            int r4 = r4 + 1
            goto L89
        La0:
            java.lang.String r1 = "childViews"
            org.json.JSONArray r8 = r8.optJSONArray(r1)
            org.json.JSONArray r9 = r9.optJSONArray(r1)
            if (r8 != 0) goto Lae
            if (r9 == 0) goto Ld9
        Lae:
            if (r8 != 0) goto Lb2
            if (r9 == 0) goto Lc1
        Lb2:
            if (r8 == 0) goto Ldb
            if (r9 != 0) goto Lb7
            goto Ldb
        Lb7:
            int r1 = r8.length()
            int r2 = r9.length()
            if (r1 != r2) goto Ldb
        Lc1:
            r1 = r0
        Lc2:
            int r2 = r8.length()
            if (r1 >= r2) goto Ld9
            org.json.JSONObject r2 = r8.optJSONObject(r1)
            org.json.JSONObject r3 = r9.optJSONObject(r1)
            boolean r2 = e(r2, r3)
            if (r2 == 0) goto Ldb
            int r1 = r1 + 1
            goto Lc2
        Ld9:
            r8 = 1
            return r8
        Ldb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzftb.e(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
