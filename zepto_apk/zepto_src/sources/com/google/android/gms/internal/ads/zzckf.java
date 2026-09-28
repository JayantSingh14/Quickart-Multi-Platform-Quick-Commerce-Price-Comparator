package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import coil3.network.internal.UtilsKt;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class zzckf extends zzcke {
    public zzckf(zzcjn zzcjnVar, zzbfj zzbfjVar, boolean z, zzeif zzeifVar) {
        super(zzcjnVar, zzbfjVar, z, new zzbwc(zzcjnVar, ((zzcju) zzcjnVar.f26410a).O(), new zzbfr(zzcjnVar.getContext())), zzeifVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String str;
        if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
            String string = webResourceRequest.getUrl().toString();
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (!(webView instanceof zzcir)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return null;
            }
            zzcir zzcirVar = (zzcir) webView;
            zzcbk zzcbkVar = this.y;
            if (zzcbkVar != null) {
                zzcbkVar.a(string, requestHeaders, 1);
            }
            int i3 = zzfwo.f31979a;
            if (!"mraid.js".equalsIgnoreCase(new File(string).getName())) {
                if (requestHeaders == null) {
                    requestHeaders = Collections.EMPTY_MAP;
                }
                return g(string, requestHeaders);
            }
            if (zzcirVar.e0() != null) {
                final zzcjc zzcjcVarE0 = zzcirVar.e0();
                synchronized (zzcjcVarE0.f26372d) {
                    zzcjcVarE0.f26380l = false;
                    zzcjcVarE0.q = true;
                    ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzciy
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            zzcjn zzcjnVar = zzcjcVarE0.f26369a;
                            zzcjnVar.o();
                            com.google.android.gms.ads.internal.overlay.zzm zzmVarZ = ((zzcju) zzcjnVar.f26410a).z();
                            if (zzmVarZ != null) {
                                zzmVarZ.f21370l.removeView(zzmVarZ.f21364f);
                                zzmVarZ.h1(true);
                            }
                        }
                    });
                }
            }
            if (zzcirVar.zzN().b()) {
                str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.m0);
            } else if (zzcirVar.r()) {
                str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l0);
            } else {
                str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k0);
            }
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
            Context context = zzcirVar.getContext();
            String str2 = zzcirVar.zzs().f21400a;
            try {
                HashMap map = new HashMap();
                map.put("User-Agent", zztVar.f21679c.E(context, str2));
                map.put(UtilsKt.CACHE_CONTROL, "max-stale=3600");
                ListenableFuture listenableFutureA = new com.google.android.gms.ads.internal.util.zzbl(context).a(0, str, map, null);
                String str3 = (String) ((zzcdt) listenableFutureA).f25992a.get(60L, TimeUnit.SECONDS);
                if (str3 != null) {
                    return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
                }
            } catch (IOException | InterruptedException | ExecutionException | TimeoutException e2) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not fetch MRAID JS.", e2);
            }
        }
        return null;
    }
}
