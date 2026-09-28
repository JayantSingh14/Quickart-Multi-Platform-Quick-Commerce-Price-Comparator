package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcrt implements zzbry {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26999a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbch f27000b;

    /* renamed from: c, reason: collision with root package name */
    public final PowerManager f27001c;

    public zzcrt(Context context, zzbch zzbchVar) {
        this.f26999a = context;
        this.f27000b = zzbchVar;
        this.f27001c = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final JSONObject zzb(zzcrw zzcrwVar) throws JSONException {
        boolean z;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzbcj zzbcjVar = zzcrwVar.f27010e;
        if (zzbcjVar == null) {
            jSONObject = new JSONObject();
        } else {
            zzbch zzbchVar = this.f27000b;
            if (zzbchVar.f24693b == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObjectPut = jSONObject3.put("afmaVersion", zzbchVar.f24695d).put("activeViewJSON", zzbchVar.f24693b).put("timestamp", zzcrwVar.f27008c).put("adFormat", zzbchVar.f24692a).put("hashCode", zzbchVar.f24694c).put("isMraid", false).put("isStopped", false).put("isPaused", zzcrwVar.f27007b).put("isNative", zzbchVar.f24696e).put("isScreenOn", this.f27001c.isInteractive());
            com.google.android.gms.ads.internal.util.zzaa zzaaVar = com.google.android.gms.ads.internal.zzt.C.f21685i;
            synchronized (zzaaVar) {
                z = zzaaVar.f21456a;
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("appMuted", z).put("appVolume", r5.f21685i.a());
            Context context = this.f26999a;
            jSONObjectPut2.put("deviceVolume", com.google.android.gms.ads.internal.util.zzaa.b(context.getApplicationContext()));
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            JSONObject jSONObjectPut3 = jSONObject3.put("windowVisibility", zzbcjVar.f24699b).put("isAttachedToWindow", zzbcjVar.f24698a);
            JSONObject jSONObject4 = new JSONObject();
            Rect rect = zzbcjVar.f24700c;
            JSONObject jSONObjectPut4 = jSONObjectPut3.put("viewBox", jSONObject4.put("top", rect.top).put("bottom", rect.bottom).put("left", rect.left).put("right", rect.right));
            JSONObject jSONObject5 = new JSONObject();
            Rect rect2 = zzbcjVar.f24701d;
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("adBox", jSONObject5.put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
            JSONObject jSONObject6 = new JSONObject();
            Rect rect3 = zzbcjVar.f24702e;
            JSONObject jSONObjectPut6 = jSONObjectPut5.put("globalVisibleBox", jSONObject6.put("top", rect3.top).put("bottom", rect3.bottom).put("left", rect3.left).put("right", rect3.right)).put("globalVisibleBoxVisible", zzbcjVar.f24703f);
            JSONObject jSONObject7 = new JSONObject();
            Rect rect4 = zzbcjVar.f24704g;
            JSONObject jSONObjectPut7 = jSONObjectPut6.put("localVisibleBox", jSONObject7.put("top", rect4.top).put("bottom", rect4.bottom).put("left", rect4.left).put("right", rect4.right)).put("localVisibleBoxVisible", zzbcjVar.f24705h);
            JSONObject jSONObject8 = new JSONObject();
            Rect rect5 = zzbcjVar.f24706i;
            jSONObjectPut7.put("hitBox", jSONObject8.put("top", rect5.top).put("bottom", rect5.bottom).put("left", rect5.left).put("right", rect5.right)).put("screenDensity", displayMetrics.density);
            jSONObject3.put("isVisible", zzcrwVar.f27006a);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.L1)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzbcjVar.f24708k;
                if (list != null) {
                    for (Rect rect6 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect6.top).put("bottom", rect6.bottom).put("left", rect6.left).put("right", rect6.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcrwVar.f27009d)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
