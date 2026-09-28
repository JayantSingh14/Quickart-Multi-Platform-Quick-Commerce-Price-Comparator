package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class zzct {
    private static WindowManager zzb;
    private static final String[] zzc = {"x", "y", Snapshot.WIDTH, Snapshot.HEIGHT};
    static float zza = Resources.getSystem().getDisplayMetrics().density;

    public static JSONObject zza(int i2, int i3, int i4, int i5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", i2 / zza);
            jSONObject.put("y", i3 / zza);
            jSONObject.put(Snapshot.WIDTH, i4 / zza);
            jSONObject.put(Snapshot.HEIGHT, i5 / zza);
            return jSONObject;
        } catch (JSONException e2) {
            zzcu.zza("Error with creating viewStateObject", e2);
            return jSONObject;
        }
    }

    public static void zzb(JSONObject jSONObject, String str) throws JSONException {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            zzcu.zza("Error with setting ad session id", e2);
        }
    }

    public static void zzc(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
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

    public static void zzd(Context context) {
        if (context != null) {
            zza = context.getResources().getDisplayMetrics().density;
            zzb = (WindowManager) context.getSystemService("window");
        }
    }

    public static void zze(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e2) {
            zzcu.zza("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void zzf(JSONObject jSONObject) throws JSONException {
        float f2;
        float f3;
        if (zzb != null) {
            Point point = new Point(0, 0);
            zzb.getDefaultDisplay().getRealSize(point);
            float f4 = point.x;
            float f5 = zza;
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

    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzg(@androidx.annotation.NonNull org.json.JSONObject r9, @androidx.annotation.Nullable org.json.JSONObject r10) {
        /*
            r0 = 1
            if (r9 != 0) goto L7
            if (r10 == 0) goto L6
            goto L7
        L6:
            return r0
        L7:
            r1 = 0
            if (r9 == 0) goto Lc3
            if (r10 != 0) goto Le
            goto Lc3
        Le:
            java.lang.String[] r2 = com.google.ads.interactivemedia.v3.internal.zzct.zzc
            r3 = r1
        L11:
            r4 = 4
            if (r3 >= r4) goto L27
            r4 = r2[r3]
            double r5 = r9.optDouble(r4)
            double r7 = r10.optDouble(r4)
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 == 0) goto L24
            goto Lc3
        L24:
            int r3 = r3 + 1
            goto L11
        L27:
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r9.optString(r2, r3)
            java.lang.String r2 = r10.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto Lc3
            java.lang.String r2 = "noOutputDevice"
            boolean r4 = r9.optBoolean(r2)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r2 = r10.optBoolean(r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto Lc3
            java.lang.String r2 = "hasWindowFocus"
            boolean r4 = r9.optBoolean(r2)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r2 = r10.optBoolean(r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto Lc3
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r9.optJSONArray(r2)
            org.json.JSONArray r2 = r10.optJSONArray(r2)
            if (r4 != 0) goto L78
            if (r2 != 0) goto L78
            goto L96
        L78:
            boolean r5 = zzh(r4, r2)
            if (r5 == 0) goto Lc3
            r5 = r1
        L7f:
            int r6 = r4.length()
            if (r5 >= r6) goto L96
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto Lc3
            int r5 = r5 + 1
            goto L7f
        L96:
            java.lang.String r2 = "childViews"
            org.json.JSONArray r9 = r9.optJSONArray(r2)
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            if (r9 != 0) goto La4
            if (r10 == 0) goto Lc2
        La4:
            boolean r2 = zzh(r9, r10)
            if (r2 == 0) goto Lc3
            r2 = r1
        Lab:
            int r3 = r9.length()
            if (r2 >= r3) goto Lc2
            org.json.JSONObject r3 = r9.optJSONObject(r2)
            org.json.JSONObject r4 = r10.optJSONObject(r2)
            boolean r3 = zzg(r3, r4)
            if (r3 == 0) goto Lc3
            int r2 = r2 + 1
            goto Lab
        Lc2:
            return r0
        Lc3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzct.zzg(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    private static boolean zzh(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
