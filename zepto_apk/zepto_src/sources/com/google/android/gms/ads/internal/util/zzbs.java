package com.google.android.gms.ads.internal.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzfhr;
import com.google.android.gms.internal.ads.zzgpo;
import com.google.android.gms.internal.ads.zzgqp;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbs {
    public static boolean a(int i2) {
        zzbgb zzbgbVar = zzbgk.e4;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            return ((Boolean) zzbdVar.f21153c.a(zzbgk.f4)).booleanValue() || i2 <= 15299999;
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(2:83|24)|33|79|34|35|(9:37|(1:42)(1:46)|47|(2:49|(1:51)(1:54))(1:55)|78|58|(2:72|60)|63|(2:81|65))(9:43|(1:45)(0)|47|(0)(0)|78|58|(0)|63|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0149, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0156, code lost:
    
        r3 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.d("Could not log native template signal to JSON", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0150 A[Catch: JSONException -> 0x0149, TRY_LEAVE, TryCatch #3 {JSONException -> 0x0149, blocks: (B:34:0x0118, B:51:0x0145, B:54:0x014b, B:55:0x0150), top: B:79:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject b(android.content.Context r17, android.view.View r18) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbs.b(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static JSONObject c(View view) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                zzbgb zzbgbVar = zzbgk.R8;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.S8)).booleanValue()) {
                        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                        jSONObject.put("contained_in_scroll_view", zzs.b(view) != 0);
                    }
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.T8)).booleanValue()) {
                        zzs zzsVar2 = com.google.android.gms.ads.internal.zzt.C.f21679c;
                        jSONObject.put("scroll_view_type", zzs.b(view));
                        return jSONObject;
                    }
                } else {
                    zzs zzsVar3 = com.google.android.gms.ads.internal.zzt.C.f21679c;
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof AdapterView)) {
                        parent = parent.getParent();
                    }
                    jSONObject.put("contained_in_scroll_view", (parent == null ? -1 : ((AdapterView) parent).getPositionForView(view)) != -1);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject d(Context context, View view) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                jSONObject.put("can_show_on_lock_screen", zzs.N(view));
                boolean z = false;
                if (context != null) {
                    Object systemService = context.getSystemService("keyguard");
                    KeyguardManager keyguardManager = (systemService == null || !(systemService instanceof KeyguardManager)) ? null : (KeyguardManager) systemService;
                    if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                        z = true;
                    }
                }
                jSONObject.put("is_keyguard_locked", z);
                return jSONObject;
            } catch (JSONException unused) {
                int i2 = zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) throws JSONException {
        String str;
        int[] iArr;
        JSONObject jSONObject;
        String str2 = "ad_view";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int i2 = 2;
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] iArr3 = new int[i2];
                    view2.getLocationOnScreen(iArr3);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator it2 = it;
                    try {
                        int measuredWidth = view2.getMeasuredWidth();
                        iArr = iArr2;
                        try {
                            com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
                            com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbbVar.f21142a;
                            com.google.android.gms.ads.internal.util.client.zzf zzfVar2 = zzbbVar.f21142a;
                            jSONObject4.put(Snapshot.WIDTH, zzfVar.i(measuredWidth, context));
                            jSONObject4.put(Snapshot.HEIGHT, zzfVar2.i(view2.getMeasuredHeight(), context));
                            jSONObject4.put("x", zzfVar2.i(iArr3[0] - iArr[0], context));
                            jSONObject4.put("y", zzfVar2.i(iArr3[1] - iArr[1], context));
                            jSONObject4.put("relative_to", str2);
                            jSONObject3.put("frame", jSONObject4);
                            Rect rect = new Rect();
                            if (view2.getLocalVisibleRect(rect)) {
                                jSONObject = j(context, rect);
                            } else {
                                jSONObject = new JSONObject();
                                jSONObject.put(Snapshot.WIDTH, 0);
                                jSONObject.put(Snapshot.HEIGHT, 0);
                                jSONObject.put("x", zzfVar2.i(iArr3[0] - iArr[0], context));
                                jSONObject.put("y", zzfVar2.i(iArr3[1] - iArr[1], context));
                                jSONObject.put("relative_to", str2);
                            }
                            jSONObject3.put("visible_bounds", jSONObject);
                            if (((String) entry.getKey()).equals("3010")) {
                                zzbgb zzbgbVar = zzbgk.U8;
                                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                                zzbgi zzbgiVar = zzbdVar.f21153c;
                                zzbgi zzbgiVar2 = zzbdVar.f21153c;
                                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                                    jSONObject3.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                                }
                                if (((Boolean) zzbgiVar2.a(zzbgk.V8)).booleanValue()) {
                                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                    jSONObject3.put("view_width_layout_type", k(layoutParams.width) - 1);
                                    jSONObject3.put("view_height_layout_type", k(layoutParams.height) - 1);
                                }
                                if (((Boolean) zzbgiVar2.a(zzbgk.W8)).booleanValue()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(Integer.valueOf(view2.getId()));
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        arrayList.add(Integer.valueOf(((View) parent).getId()));
                                    }
                                    jSONObject3.put("view_path", TextUtils.join("/", arrayList));
                                }
                                if (scaleType != null) {
                                    jSONObject3.put("mediaview_scale_type", scaleType.ordinal());
                                }
                            }
                            if (view2 instanceof TextView) {
                                TextView textView = (TextView) view2;
                                jSONObject3.put("text_color", textView.getCurrentTextColor());
                                str = str2;
                                try {
                                    jSONObject3.put("font_size", textView.getTextSize());
                                    jSONObject3.put("text", textView.getText());
                                } catch (JSONException unused) {
                                    int i3 = zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.f("Unable to get asset views information");
                                    it = it2;
                                    str2 = str;
                                    iArr2 = iArr;
                                    i2 = 2;
                                }
                            } else {
                                str = str2;
                            }
                            jSONObject3.put("is_clickable", map2 != null && map2.containsKey(entry.getKey()) && view2.isClickable());
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.X8)).booleanValue()) {
                                jSONObject3.put("alpha", view2.getAlpha());
                            }
                            jSONObject2.put((String) entry.getKey(), jSONObject3);
                        } catch (JSONException unused2) {
                            str = str2;
                        }
                    } catch (JSONException unused3) {
                        str = str2;
                        iArr = iArr2;
                    }
                    it = it2;
                    str2 = str;
                    iArr2 = iArr;
                    i2 = 2;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject f(String str, Context context, Point point, Point point2) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                int i2 = point2.x;
                com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
                com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbbVar.f21142a;
                com.google.android.gms.ads.internal.util.client.zzf zzfVar2 = zzbbVar.f21142a;
                jSONObject3.put("x", zzfVar.i(i2, context));
                jSONObject3.put("y", zzfVar2.i(point2.y, context));
                jSONObject3.put("start_x", zzfVar2.i(point.x, context));
                jSONObject3.put("start_y", zzfVar2.i(point.y, context));
                jSONObject2 = jSONObject3;
            } catch (JSONException e3) {
                int i3 = zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while putting signals into JSON object.", e3);
            }
            jSONObject.put("click_point", jSONObject2);
            jSONObject.put("asset_id", str);
            return jSONObject;
        } catch (Exception e4) {
            e = e4;
            jSONObject2 = jSONObject;
            int i4 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while grabbing click signals.", e);
            return jSONObject2;
        }
    }

    public static boolean g(Context context, zzfhr zzfhrVar) {
        if (!zzfhrVar.N) {
            return false;
        }
        zzbgb zzbgbVar = zzbgk.Y8;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (zBooleanValue) {
            return ((Boolean) zzbgiVar.a(zzbgk.b9)).booleanValue();
        }
        String str = (String) zzbgiVar.a(zzbgk.Z8);
        if (str.isEmpty() || context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        Iterator it = zzgqp.a(zzgpo.b(';')).c(str).iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static JSONObject h(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        try {
            int i2 = displayMetrics.widthPixels;
            com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
            jSONObject.put(Snapshot.WIDTH, zzbbVar.f21142a.i(i2, context));
            jSONObject.put(Snapshot.HEIGHT, zzbbVar.f21142a.i(displayMetrics.heightPixels, context));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static WindowManager.LayoutParams i() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.a9)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject j(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i2 = rect.right - rect.left;
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
        jSONObject.put(Snapshot.WIDTH, zzbbVar.f21142a.i(i2, context));
        int i3 = rect.bottom - rect.top;
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbbVar.f21142a;
        jSONObject.put(Snapshot.HEIGHT, zzfVar.i(i3, context));
        jSONObject.put("x", zzfVar.i(rect.left, context));
        jSONObject.put("y", zzfVar.i(rect.top, context));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    public static int k(int i2) {
        if (i2 != -2) {
            return i2 != -1 ? 2 : 3;
        }
        return 4;
    }
}
