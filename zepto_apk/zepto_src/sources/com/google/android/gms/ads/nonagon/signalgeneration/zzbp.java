package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbhu;
import com.google.android.gms.internal.ads.zzbip;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzbp extends QueryInfoGenerationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21872a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaggingLibraryJsInterface f21873b;

    public zzbp(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.f21872a = str;
        this.f21873b = taggingLibraryJsInterface;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void a(String str) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        boolean zBooleanValue = ((Boolean) zzbip.f25197c.c()).booleanValue();
        TaggingLibraryJsInterface taggingLibraryJsInterface = this.f21873b;
        String strConcat = zBooleanValue ? ",\"as\":".concat(taggingLibraryJsInterface.f21753k.b().toString()) : "";
        Locale locale = Locale.getDefault();
        zzbhu zzbhuVar = zzbip.f25199e;
        final String str2 = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"error\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", this.f21872a, str, Long.valueOf(((Boolean) zzbhuVar.c()).booleanValue() ? ((Long) zzbip.f25202h.c()).longValue() : 0L), strConcat);
        if (((Boolean) zzbhuVar.c()).booleanValue()) {
            try {
                taggingLibraryJsInterface.f21750h.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbn
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f21868a.f21873b.f21744b.evaluateJavascript(str2, null);
                    }
                });
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.e("TaggingLibraryJsInterface.getQueryInfo.onFailure", e2);
            }
        } else {
            taggingLibraryJsInterface.f21744b.evaluateJavascript(str2, null);
        }
        if (((Boolean) zzbip.f25197c.c()).booleanValue() && ((Boolean) zzbip.f25198d.c()).booleanValue()) {
            zzj zzjVar = taggingLibraryJsInterface.f21754l;
            zzjVar.getClass();
            zzjVar.f21904c.execute(new zzh(zzjVar));
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void b(QueryInfo queryInfo) throws JSONException {
        final String str;
        String str2 = this.f21872a;
        TaggingLibraryJsInterface taggingLibraryJsInterface = this.f21873b;
        String str3 = queryInfo.f21972a.f21226a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", str2);
            if (((Boolean) zzbip.f25197c.c()).booleanValue()) {
                jSONObject.put("as", taggingLibraryJsInterface.f21753k.b());
            }
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzbip.f25199e.c()).booleanValue() ? ((Long) zzbip.f25202h.c()).longValue() : 0L);
            jSONObject.put("signal", str3);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            String strConcat = ((Boolean) zzbip.f25197c.c()).booleanValue() ? ",\"as\":".concat(taggingLibraryJsInterface.f21753k.b().toString()) : "";
            str = String.format(Locale.getDefault(), "window.postMessage({\"paw_id\":\"%1$s\",\"signal\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", str2, queryInfo.f21972a.f21226a, Long.valueOf(((Boolean) zzbip.f25199e.c()).booleanValue() ? ((Long) zzbip.f25202h.c()).longValue() : 0L), strConcat);
        }
        if (((Boolean) zzbip.f25199e.c()).booleanValue()) {
            try {
                taggingLibraryJsInterface.f21750h.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbo
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f21870a.f21873b.f21744b.evaluateJavascript(str, null);
                    }
                });
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.e("TaggingLibraryJsInterface.getQueryInfo.onSuccess", e2);
            }
        } else {
            taggingLibraryJsInterface.f21744b.evaluateJavascript(str, null);
        }
        if (((Boolean) zzbip.f25197c.c()).booleanValue() && ((Boolean) zzbip.f25198d.c()).booleanValue()) {
            zzj zzjVar = taggingLibraryJsInterface.f21754l;
            zzjVar.getClass();
            zzjVar.f21904c.execute(new zzh(zzjVar));
        }
    }
}
