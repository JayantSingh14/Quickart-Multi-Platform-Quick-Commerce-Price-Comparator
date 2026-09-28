package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.os.Build;
import android.webkit.WebView;
import in.juspay.airborne.ota.Constants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class zzfsv {

    /* renamed from: a, reason: collision with root package name */
    public final String f31810a;

    /* renamed from: c, reason: collision with root package name */
    public long f31812c = System.nanoTime();

    /* renamed from: d, reason: collision with root package name */
    public int f31813d = 1;

    /* renamed from: b, reason: collision with root package name */
    public zzftx f31811b = new zzftx(null);

    public zzfsv(String str) {
        this.f31810a = str;
    }

    public void a() {
    }

    public void b() {
        this.f31811b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView c() {
        return (WebView) this.f31811b.get();
    }

    public void d(zzfrl zzfrlVar, zzfrj zzfrjVar) {
        e(zzfrlVar, zzfrjVar, null);
    }

    public final void e(zzfrl zzfrlVar, zzfrj zzfrjVar, JSONObject jSONObject) throws JSONException {
        String str = zzfrlVar.f31724g;
        JSONObject jSONObject2 = new JSONObject();
        zzftb.b(jSONObject2, PaymentConstants.ENV, Constants.APP_DIR);
        zzftb.b(jSONObject2, "adSessionType", zzfrjVar.f31713g);
        JSONObject jSONObject3 = new JSONObject();
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        zzftb.b(jSONObject3, "deviceType", android.support.v4.media.b.s(new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str3).length()), str2, "; ", str3));
        zzftb.b(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzftb.b(jSONObject3, "os", "Android");
        zzftb.b(jSONObject2, "deviceInfo", jSONObject3);
        UiModeManager uiModeManager = zzfta.f31820a;
        zzfrn zzfrnVar = zzfrn.OTHER;
        if (uiModeManager != null) {
            int currentModeType = uiModeManager.getCurrentModeType();
            if (currentModeType == 1) {
                zzfrnVar = zzfrn.MOBILE;
            } else if (currentModeType == 4) {
                zzfrnVar = zzfrn.CTV;
            }
        }
        zzftb.b(jSONObject2, "deviceCategory", zzfrnVar.f31735a);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzftb.b(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfrv zzfrvVar = zzfrjVar.f31707a;
        zzftb.b(jSONObject4, "partnerName", zzfrvVar.f31758a);
        zzftb.b(jSONObject4, "partnerVersion", zzfrvVar.f31759b);
        zzftb.b(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzftb.b(jSONObject5, "libraryVersion", "1.5.2-google_20241009");
        zzftb.b(jSONObject5, CLConstants.SALT_FIELD_APP_ID, zzfsk.f31792b.f31793a.getApplicationContext().getPackageName());
        zzftb.b(jSONObject2, Constants.APP_DIR, jSONObject5);
        String str4 = zzfrjVar.f31712f;
        if (str4 != null) {
            zzftb.b(jSONObject2, "contentUrl", str4);
        }
        String str5 = zzfrjVar.f31711e;
        if (str5 != null) {
            zzftb.b(jSONObject2, "customReferenceData", str5);
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = Collections.unmodifiableList(zzfrjVar.f31709c).iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzfsm.f31796a.a(c(), "startSession", str, jSONObject2, jSONObject6, jSONObject);
    }

    public final void f(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzftb.b(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfsm.f31796a.a(c(), "setLastActivity", jSONObject);
    }
}
