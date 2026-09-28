package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbip;
import com.google.android.gms.internal.ads.zzgtn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21892a;

    /* renamed from: b, reason: collision with root package name */
    public final ApplicationInfo f21893b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f21894c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f21895d;

    /* renamed from: e, reason: collision with root package name */
    public final JSONObject f21896e = new JSONObject();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f21897f = new AtomicBoolean(false);

    public zzf(Context context, ArrayList arrayList, VersionInfoParcel versionInfoParcel) {
        this.f21892a = context;
        this.f21893b = context.getApplicationInfo();
        this.f21894c = arrayList;
        this.f21895d = versionInfoParcel;
    }

    public final void a(WebView webView) throws JSONException {
        if (this.f21897f.getAndSet(true)) {
            return;
        }
        ApplicationInfo applicationInfo = this.f21893b;
        PackageInfo packageInfo = null;
        if (applicationInfo != null) {
            try {
                packageInfo = Wrappers.packageManager(this.f21892a).getPackageInfo(applicationInfo.packageName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        JSONObject jSONObject = this.f21896e;
        if (packageInfo != null) {
            try {
                jSONObject.put("vc", packageInfo.versionCode);
                jSONObject.put("vnm", packageInfo.versionName);
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("PawAppSignalGenerator.initialize", e2);
            }
        }
        if (applicationInfo != null) {
            jSONObject.put("pn", applicationInfo.packageName);
        }
        ArrayList arrayList = this.f21894c;
        ArrayList arrayList2 = new ArrayList();
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Va)).split(",", -1)) {
            if (arrayList.contains(str)) {
                arrayList2.add(str);
            }
        }
        jSONObject.put("eid", arrayList2);
        jSONObject.put("js", this.f21895d.f21400a);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj != null) {
                jSONObject.put(next, Base64.encodeToString(obj.toString().getBytes(), 2));
            }
        }
        if (((Boolean) zzbip.f25196b.c()).booleanValue() && WebViewFeature.a("DOCUMENT_START_SCRIPT") && webView != null) {
            String str2 = String.format(Locale.getDefault(), (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ua), b());
            zzgtn zzgtnVarM = zzgtn.m();
            int i2 = WebViewCompat.f12427a;
            if (!WebViewFeatureInternal.f12458l.d()) {
                throw WebViewFeatureInternal.a();
            }
        }
    }

    public final JSONObject b() throws JSONException {
        if (!this.f21897f.get()) {
            a(null);
        }
        return this.f21896e;
    }
}
