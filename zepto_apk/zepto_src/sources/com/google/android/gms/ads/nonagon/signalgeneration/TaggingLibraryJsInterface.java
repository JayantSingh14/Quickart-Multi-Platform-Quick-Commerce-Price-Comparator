package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.fragment.app.e;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzayq;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbip;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzdxj;
import com.google.android.gms.internal.ads.zzfio;
import com.google.android.gms.internal.ads.zzfpi;
import com.google.android.gms.internal.ads.zzgxi;
import com.google.android.gms.internal.ads.zzgyw;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class TaggingLibraryJsInterface {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21743a;

    /* renamed from: b, reason: collision with root package name */
    public final WebView f21744b;

    /* renamed from: c, reason: collision with root package name */
    public final zzayq f21745c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfio f21746d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21747e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdxj f21748f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21749g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgyw f21750h = zzcdo.f25987f;

    /* renamed from: i, reason: collision with root package name */
    public final zzfpi f21751i;

    /* renamed from: j, reason: collision with root package name */
    public final zzo f21752j;

    /* renamed from: k, reason: collision with root package name */
    public final zzf f21753k;

    /* renamed from: l, reason: collision with root package name */
    public final zzj f21754l;

    public TaggingLibraryJsInterface(WebView webView, zzayq zzayqVar, zzdxj zzdxjVar, zzfpi zzfpiVar, zzfio zzfioVar, zzo zzoVar, zzf zzfVar, zzj zzjVar) {
        this.f21744b = webView;
        Context context = webView.getContext();
        this.f21743a = context;
        this.f21745c = zzayqVar;
        this.f21748f = zzdxjVar;
        zzbgk.a(context);
        zzbgb zzbgbVar = zzbgk.Ka;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.f21747e = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
        this.f21749g = ((Boolean) zzbdVar.f21153c.a(zzbgk.La)).booleanValue();
        this.f21751i = zzfpiVar;
        this.f21746d = zzfioVar;
        this.f21752j = zzoVar;
        this.f21753k = zzfVar;
        this.f21754l = zzjVar;
    }

    @NonNull
    @JavascriptInterface
    @KeepForSdk
    public String getClickSignals(@NonNull String str) {
        try {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
            String strE = this.f21745c.f24512b.e(this.f21743a, str, this.f21744b);
            if (!this.f21749g) {
                return strE;
            }
            zzaa.d(this.f21748f, "csg", new Pair("clat", String.valueOf(zztVar.f21687k.currentTimeMillis() - jCurrentTimeMillis)));
            return strE;
        } catch (RuntimeException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting click signals. ", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("TaggingLibraryJsInterface.getClickSignals", e2);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @JavascriptInterface
    @KeepForSdk
    public String getClickSignalsWithTimeout(@NonNull final String str, int i2) {
        if (i2 <= 0) {
            String strR = e.r(new StringBuilder(String.valueOf(i2).length() + 51), i2, "Invalid timeout for getting click signals. Timeout=");
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c(strR);
            return "";
        }
        try {
            return (String) ((zzgxi) zzcdo.f25982a).submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbr
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.f21875a.getClickSignals(str);
                }
            }).get(Math.min(i2, this.f21747e), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting click signals with timeout. ", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("TaggingLibraryJsInterface.getClickSignalsWithTimeout", e2);
            return e2 instanceof TimeoutException ? "17" : "";
        }
    }

    @NonNull
    @JavascriptInterface
    @KeepForSdk
    public String getQueryInfo() {
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        String string = UUID.randomUUID().toString();
        final Bundle bundleI = e.i("query_info_type", "requester_type_6");
        final zzbp zzbpVar = new zzbp(this, string);
        if (((Boolean) zzbip.f25199e.c()).booleanValue()) {
            this.f21752j.a(this.f21744b, zzbpVar);
            return string;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Na)).booleanValue()) {
            this.f21750h.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbt
                @Override // java.lang.Runnable
                public final void run() {
                    TaggingLibraryJsInterface taggingLibraryJsInterface = this.f21879a;
                    CookieManager cookieManagerH = com.google.android.gms.ads.internal.zzt.C.f21682f.h();
                    boolean zAcceptThirdPartyCookies = cookieManagerH != null ? cookieManagerH.acceptThirdPartyCookies(taggingLibraryJsInterface.f21744b) : false;
                    Bundle bundle = bundleI;
                    bundle.putBoolean("accept_3p_cookie", zAcceptThirdPartyCookies);
                    QueryInfo.a(taggingLibraryJsInterface.f21743a, new AdRequest((AdRequest.Builder) new AdRequest.Builder().c(bundle)), zzbpVar);
                }
            });
            return string;
        }
        QueryInfo.a(this.f21743a, new AdRequest((AdRequest.Builder) new AdRequest.Builder().c(bundleI)), zzbpVar);
        return string;
    }

    @NonNull
    @JavascriptInterface
    @KeepForSdk
    public String getViewSignals() {
        try {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
            String strJ = this.f21745c.f24512b.j(this.f21743a, this.f21744b, null);
            if (!this.f21749g) {
                return strJ;
            }
            zzaa.d(this.f21748f, "vsg", new Pair("vlat", String.valueOf(zztVar.f21687k.currentTimeMillis() - jCurrentTimeMillis)));
            return strJ;
        } catch (RuntimeException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting view signals. ", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("TaggingLibraryJsInterface.getViewSignals", e2);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @JavascriptInterface
    @KeepForSdk
    public String getViewSignalsWithTimeout(int i2) {
        if (i2 <= 0) {
            String strR = e.r(new StringBuilder(String.valueOf(i2).length() + 50), i2, "Invalid timeout for getting view signals. Timeout=");
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c(strR);
            return "";
        }
        try {
            return (String) ((zzgxi) zzcdo.f25982a).submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbq
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.f21874a.getViewSignals();
                }
            }).get(Math.min(i2, this.f21747e), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting view signals with timeout. ", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("TaggingLibraryJsInterface.getViewSignalsWithTimeout", e2);
            return e2 instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    @KeepForSdk
    public void recordClick(@NonNull final String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Pa)).booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        zzcdo.f25982a.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbs
            @Override // java.lang.Runnable
            public final void run() {
                zzfio zzfioVar;
                TaggingLibraryJsInterface taggingLibraryJsInterface = this.f21877a;
                Uri uriB = Uri.parse(str);
                try {
                    boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ed)).booleanValue();
                    WebView webView = taggingLibraryJsInterface.f21744b;
                    Context context = taggingLibraryJsInterface.f21743a;
                    uriB = (!zBooleanValue || (zzfioVar = taggingLibraryJsInterface.f21746d) == null) ? taggingLibraryJsInterface.f21745c.b(uriB, context, webView, null) : zzfioVar.a(uriB, context, webView, null);
                } catch (zzayr e2) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.b("Failed to append the click signal to URL: ", e2);
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("TaggingLibraryJsInterface.recordClick", e2);
                }
                taggingLibraryJsInterface.f21751i.b(uriB.toString(), null, null, null);
            }
        });
    }

    @JavascriptInterface
    @KeepForSdk
    public void reportTouchEvent(@NonNull String str) throws JSONException {
        int i2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("x");
            int i4 = jSONObject.getInt("y");
            int i5 = jSONObject.getInt("duration_ms");
            float f2 = (float) jSONObject.getDouble("force");
            int i6 = jSONObject.getInt("type");
            if (i6 != 0) {
                i2 = 1;
                if (i6 != 1) {
                    i2 = 2;
                    if (i6 != 2) {
                        i2 = 3;
                        if (i6 != 3) {
                            i2 = -1;
                        }
                    }
                }
            } else {
                i2 = 0;
            }
            try {
                this.f21745c.f24512b.f(MotionEvent.obtain(0L, i5, i2, i3, i4, f2, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException e2) {
                e = e2;
                int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("TaggingLibraryJsInterface.reportTouchEvent", e);
            } catch (JSONException e3) {
                e = e3;
                int i72 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("TaggingLibraryJsInterface.reportTouchEvent", e);
            }
        } catch (RuntimeException | JSONException e4) {
            e = e4;
        }
    }
}
