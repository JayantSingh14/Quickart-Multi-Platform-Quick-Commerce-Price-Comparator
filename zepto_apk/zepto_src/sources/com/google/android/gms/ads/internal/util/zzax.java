package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcdt;
import com.google.android.gms.internal.ads.zzeaj;
import com.google.android.gms.internal.ads.zzeak;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzax {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21505a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public String f21506b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f21507c = "";

    /* renamed from: d, reason: collision with root package name */
    public boolean f21508d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21509e = false;

    /* renamed from: f, reason: collision with root package name */
    public String f21510f = "";

    /* renamed from: g, reason: collision with root package name */
    public zzeak f21511g;

    public static final String j(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("User-Agent", com.google.android.gms.ads.internal.zzt.C.f21679c.E(context, str2));
        ListenableFuture listenableFutureA = new zzbl(context).a(0, str, map, null);
        try {
            return (String) ((zzcdt) listenableFutureA).f25992a.get(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.H5)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            String strValueOf = String.valueOf(str);
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Interrupted while retrieving a response from: ".concat(strValueOf), e2);
            ((zzcdt) listenableFutureA).cancel(true);
            return null;
        } catch (TimeoutException e3) {
            String strValueOf2 = String.valueOf(str);
            int i3 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Timeout while retrieving a response from: ".concat(strValueOf2), e3);
            ((zzcdt) listenableFutureA).cancel(true);
            return null;
        } catch (Exception e4) {
            String strValueOf3 = String.valueOf(str);
            int i4 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error retrieving a response from: ".concat(strValueOf3), e4);
            return null;
        }
    }

    public final void a(Context context) {
        zzeak zzeakVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.pa)).booleanValue() || (zzeakVar = this.f21511g) == null) {
            return;
        }
        zzeakVar.e(new zzau(this, context), zzeaj.f28932d);
    }

    public final boolean b(Context context, String str, String str2) {
        zzbgb zzbgbVar = zzbgk.F5;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        String strJ = j(context, k(context, (String) zzbdVar.f21153c.a(zzbgbVar), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strJ)) {
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Not linked for debug signals.");
            return false;
        }
        try {
            boolean zEquals = "1".equals(new JSONObject(strJ.trim()).optString("debug_mode"));
            f(zEquals);
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.pa)).booleanValue()) {
                zzj zzjVarG = com.google.android.gms.ads.internal.zzt.C.f21684h.g();
                if (true != zEquals) {
                    str = "";
                }
                zzjVarG.b(str);
            }
            return zEquals;
        } catch (JSONException e2) {
            int i3 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    public final void c(Context context, String str, String str2) {
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        zzs.u(context, k(context, (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.D5), str, str2));
    }

    public final boolean d(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !h()) {
            return false;
        }
        int i2 = zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Sending troubleshooting signals to the server.");
        e(context, str, str2, str3);
        return true;
    }

    public final void e(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = k(context, (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.G5), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        new zzbt(context, str, builderBuildUpon.build().toString(), null).b();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:4:0x0003, B:6:0x0017, B:8:0x0026, B:11:0x002c, B:13:0x0032, B:16:0x0037, B:17:0x003b, B:19:0x0041, B:22:0x0047), top: B:26:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:4:0x0003, B:6:0x0017, B:8:0x0026, B:11:0x002c, B:13:0x0032, B:16:0x0037, B:17:0x003b, B:19:0x0041, B:22:0x0047), top: B:26:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f21505a
            monitor-enter(r0)
            r3.f21509e = r4     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.pa     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.internal.ads.zzbgi r2 = r2.f21153c     // Catch: java.lang.Throwable -> L45
            java.lang.Object r1 = r2.a(r1)     // Catch: java.lang.Throwable -> L45
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L45
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L47
            com.google.android.gms.ads.internal.zzt r1 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.internal.ads.zzcda r1 = r1.f21684h     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.ads.internal.util.zzj r1 = r1.g()     // Catch: java.lang.Throwable -> L45
            r1.a(r4)     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.internal.ads.zzeak r1 = r3.f21511g     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L47
            boolean r2 = r1.u     // Catch: java.lang.Throwable -> L45
            if (r2 != 0) goto L30
            if (r4 == 0) goto L3b
            r1.j()     // Catch: java.lang.Throwable -> L45
            goto L32
        L30:
            if (r4 == 0) goto L3b
        L32:
            boolean r4 = r1.s     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L37
            goto L3b
        L37:
            r1.k()     // Catch: java.lang.Throwable -> L45
            goto L47
        L3b:
            boolean r4 = r1.f()     // Catch: java.lang.Throwable -> L45
            if (r4 != 0) goto L47
            r1.l()     // Catch: java.lang.Throwable -> L45
            goto L47
        L45:
            r4 = move-exception
            goto L49
        L47:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            return
        L49:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzax.f(boolean):void");
    }

    public final boolean g() {
        boolean z;
        synchronized (this.f21505a) {
            z = this.f21509e;
        }
        return z;
    }

    public final boolean h() {
        boolean z;
        synchronized (this.f21505a) {
            z = this.f21508d;
        }
        return z;
    }

    public final void i(String str, Context context, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzs.f21608l.post(new zzaw(this, context, str, z, z2));
        } else {
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Can not create dialog without Activity Context");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: all -> 0x002a, TryCatch #1 {, blocks: (B:4:0x000b, B:6:0x0013, B:7:0x0019, B:12:0x0035, B:14:0x003d, B:16:0x004e, B:19:0x0060, B:11:0x002c, B:20:0x0067, B:21:0x0069), top: B:28:0x000b, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.net.Uri k(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            android.net.Uri r6 = android.net.Uri.parse(r6)
            android.net.Uri$Builder r6 = r6.buildUpon()
            java.lang.Object r0 = r4.f21505a
            monitor-enter(r0)
            java.lang.String r1 = r4.f21506b     // Catch: java.lang.Throwable -> L2a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L67
            com.google.android.gms.ads.internal.zzt r1 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L2a
            com.google.android.gms.ads.internal.util.zzs r1 = r1.f21679c     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = "debug_signals_id.txt"
            java.io.FileInputStream r1 = r5.openFileInput(r1)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            r3 = 1
            byte[] r1 = com.google.android.gms.common.util.IOUtils.readInputStreamFully(r1, r3)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            goto L35
        L2a:
            r5 = move-exception
            goto L7e
        L2c:
            java.lang.String r1 = "Error reading from internal storage."
            int r2 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> L2a
            com.google.android.gms.ads.internal.util.client.zzo.a(r1)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = ""
        L35:
            r4.f21506b = r2     // Catch: java.lang.Throwable -> L2a
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L67
            com.google.android.gms.ads.internal.zzt r1 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L2a
            com.google.android.gms.ads.internal.util.zzs r1 = r1.f21679c     // Catch: java.lang.Throwable -> L2a
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2a
            r4.f21506b = r1     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = "debug_signals_id.txt"
            r3 = 0
            java.io.FileOutputStream r5 = r5.openFileOutput(r2, r3)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L5f
            java.lang.String r2 = "UTF-8"
            byte[] r1 = r1.getBytes(r2)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L5f
            r5.write(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L5f
            r5.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L5f
            goto L67
        L5f:
            r5 = move-exception
            java.lang.String r1 = "Error writing to file in internal storage."
            int r2 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> L2a
            com.google.android.gms.ads.internal.util.client.zzo.d(r1, r5)     // Catch: java.lang.Throwable -> L2a
        L67:
            java.lang.String r5 = r4.f21506b     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = "linkedDeviceId"
            r6.appendQueryParameter(r0, r5)
            java.lang.String r5 = "adSlotPath"
            r6.appendQueryParameter(r5, r7)
            java.lang.String r5 = "afmaVersion"
            r6.appendQueryParameter(r5, r8)
            android.net.Uri r5 = r6.build()
            return r5
        L7e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzax.k(android.content.Context, java.lang.String, java.lang.String, java.lang.String):android.net.Uri");
    }
}
