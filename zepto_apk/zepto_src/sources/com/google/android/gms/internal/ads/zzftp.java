package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzftp implements zzfsq {

    /* renamed from: g, reason: collision with root package name */
    public static final zzftp f31840g = new zzftp();

    /* renamed from: h, reason: collision with root package name */
    public static final Handler f31841h = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    public static Handler f31842i = null;

    /* renamed from: j, reason: collision with root package name */
    public static final Runnable f31843j = new zzftl();

    /* renamed from: k, reason: collision with root package name */
    public static final Runnable f31844k = new zzftm();

    /* renamed from: f, reason: collision with root package name */
    public long f31850f;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f31845a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f31846b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final zzfti f31848d = new zzfti();

    /* renamed from: c, reason: collision with root package name */
    public final zzfss f31847c = new zzfss();

    /* renamed from: e, reason: collision with root package name */
    public final zzftj f31849e = new zzftj(new zzfts());

    public static void b() {
        if (f31842i == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f31842i = handler;
            handler.post(f31843j);
            f31842i.postDelayed(f31844k, 200L);
        }
    }

    public final void a(View view, zzfsu zzfsuVar, JSONObject jSONObject, boolean z) throws JSONException {
        Object obj;
        boolean z2;
        int i2;
        if (zzftg.a(view) == null) {
            zzfti zzftiVar = this.f31848d;
            char c2 = zzftiVar.f31830d.contains(view) ? (char) 1 : zzftiVar.f31836j ? (char) 2 : (char) 3;
            if (c2 == 3) {
                return;
            }
            JSONObject jSONObjectA = zzfsuVar.a(view);
            zzftb.c(jSONObject, jSONObjectA);
            HashMap map = zzftiVar.f31827a;
            if (map.size() == 0) {
                obj = null;
            } else {
                Object obj2 = (String) map.get(view);
                if (obj2 != null) {
                    map.remove(view);
                }
                obj = obj2;
            }
            boolean z3 = false;
            if (obj != null) {
                try {
                    jSONObjectA.put("adSessionId", obj);
                } catch (JSONException e2) {
                    zzftc.a("Error with setting ad session id", e2);
                }
                WeakHashMap weakHashMap = zzftiVar.f31835i;
                if (weakHashMap.containsKey(view)) {
                    weakHashMap.put(view, Boolean.TRUE);
                } else {
                    z3 = true;
                }
                try {
                    jSONObjectA.put("hasWindowFocus", Boolean.valueOf(z3));
                } catch (JSONException e3) {
                    zzftc.a("Error with setting has window focus", e3);
                }
                boolean zContains = zzftiVar.f31834h.contains(obj);
                Object objValueOf = Boolean.valueOf(zContains);
                if (zContains) {
                    try {
                        jSONObjectA.put("isPipActive", objValueOf);
                    } catch (JSONException e4) {
                        zzftc.a("Error with setting is picture-in-picture active", e4);
                    }
                }
                zzftiVar.f31836j = true;
                return;
            }
            HashMap map2 = zzftiVar.f31828b;
            zzfth zzfthVar = (zzfth) map2.get(view);
            if (zzfthVar != null) {
                map2.remove(view);
            }
            if (zzfthVar != null) {
                zzfsi zzfsiVar = zzfthVar.f31825a;
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayList = zzfthVar.f31826b;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    jSONArray.put((String) arrayList.get(i3));
                }
                try {
                    jSONObjectA.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectA.put("friendlyObstructionClass", zzfsiVar.f31787b);
                    jSONObjectA.put("friendlyObstructionPurpose", zzfsiVar.f31788c);
                    jSONObjectA.put("friendlyObstructionReason", zzfsiVar.f31789d);
                } catch (JSONException e5) {
                    zzftc.a("Error with setting friendly obstruction", e5);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = z || z2;
            boolean z5 = c2 == 1;
            zzfsuVar.getClass();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!z5) {
                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                        a(viewGroup.getChildAt(i4), zzfsuVar, jSONObjectA, z4);
                    }
                    return;
                }
                HashMap map3 = new HashMap();
                for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                    View childAt = viewGroup.getChildAt(i5);
                    ArrayList arrayList2 = (ArrayList) map3.get(Float.valueOf(childAt.getZ()));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        map3.put(Float.valueOf(childAt.getZ()), arrayList2);
                    }
                    arrayList2.add(childAt);
                }
                ArrayList arrayList3 = new ArrayList(map3.keySet());
                Collections.sort(arrayList3);
                int size2 = arrayList3.size();
                int i6 = 0;
                while (i6 < size2) {
                    ArrayList arrayList4 = (ArrayList) map3.get((Float) arrayList3.get(i6));
                    int size3 = arrayList4.size();
                    int i7 = 0;
                    while (true) {
                        i2 = i6 + 1;
                        if (i7 < size3) {
                            a((View) arrayList4.get(i7), zzfsuVar, jSONObjectA, z4);
                            i7++;
                        }
                    }
                    i6 = i2;
                }
            }
        }
    }
}
