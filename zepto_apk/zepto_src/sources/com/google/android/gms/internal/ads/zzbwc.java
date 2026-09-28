package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbwc extends zzbwd implements zzbnn {

    /* renamed from: c, reason: collision with root package name */
    public final zzcjn f25638c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f25639d;

    /* renamed from: e, reason: collision with root package name */
    public final WindowManager f25640e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbfr f25641f;

    /* renamed from: g, reason: collision with root package name */
    public DisplayMetrics f25642g;

    /* renamed from: h, reason: collision with root package name */
    public float f25643h;

    /* renamed from: i, reason: collision with root package name */
    public int f25644i;

    /* renamed from: j, reason: collision with root package name */
    public int f25645j;

    /* renamed from: k, reason: collision with root package name */
    public int f25646k;

    /* renamed from: l, reason: collision with root package name */
    public int f25647l;

    /* renamed from: m, reason: collision with root package name */
    public int f25648m;
    public int n;
    public int o;

    public zzbwc(zzcjn zzcjnVar, Context context, zzbfr zzbfrVar) {
        super(zzcjnVar, "");
        this.f25644i = -1;
        this.f25645j = -1;
        this.f25647l = -1;
        this.f25648m = -1;
        this.n = -1;
        this.o = -1;
        this.f25638c = zzcjnVar;
        this.f25639d = context;
        this.f25641f = zzbfrVar;
        this.f25640e = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws JSONException {
        JSONObject jSONObjectPut;
        this.f25642g = new DisplayMetrics();
        Display defaultDisplay = this.f25640e.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f25642g);
        this.f25643h = this.f25642g.density;
        this.f25646k = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        this.f25644i = Math.round(r11.widthPixels / this.f25642g.density);
        this.f25645j = Math.round(r11.heightPixels / this.f25642g.density);
        zzcjn zzcjnVar = this.f25638c;
        zzcir zzcirVar = zzcjnVar.f26410a;
        Activity activityZzj = ((zzcju) zzcirVar).zzj();
        if (activityZzj == null || activityZzj.getWindow() == null) {
            this.f25647l = this.f25644i;
            this.f25648m = this.f25645j;
        } else {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            int[] iArrP = com.google.android.gms.ads.internal.util.zzs.p(activityZzj);
            this.f25647l = Math.round(iArrP[0] / this.f25642g.density);
            this.f25648m = Math.round(iArrP[1] / this.f25642g.density);
        }
        if (((zzcju) zzcirVar).zzN().b()) {
            this.n = this.f25644i;
            this.o = this.f25645j;
        } else {
            zzcjnVar.measure(0, 0);
        }
        e(this.f25644i, this.f25645j, this.f25647l, this.f25648m, this.f25643h, this.f25646k);
        zzbwb zzbwbVar = new zzbwb();
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbfr zzbfrVar = this.f25641f;
        zzbwbVar.f25636b = zzbfrVar.b(intent);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbwbVar.f25635a = zzbfrVar.b(intent2);
        zzbwbVar.f25637c = zzbfrVar.b(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
        boolean zA = zzbfrVar.a();
        boolean z = zzbwbVar.f25635a;
        try {
            jSONObjectPut = new JSONObject().put("sms", z).put("tel", zzbwbVar.f25636b).put("calendar", zzbwbVar.f25637c).put("storePicture", zA).put("inlineVideo", true);
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while obtaining the MRAID capabilities.", e2);
            jSONObjectPut = null;
        }
        zzcjnVar.m("onDeviceFeaturesReceived", jSONObjectPut);
        int[] iArr = new int[2];
        zzcjnVar.getLocationOnScreen(iArr);
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
        com.google.android.gms.ads.internal.util.client.zzf zzfVar2 = zzbbVar.f21142a;
        int i3 = iArr[0];
        Context context = this.f25639d;
        f(zzfVar2.i(i3, context), zzbbVar.f21142a.i(iArr[1], context));
        if (com.google.android.gms.ads.internal.util.client.zzo.j(2)) {
            com.google.android.gms.ads.internal.util.client.zzo.e("Dispatching Ready Event.");
        }
        try {
            this.f25649a.m("onReadyEventReceived", new JSONObject().put("js", ((zzcju) zzcirVar).zzs().f21400a));
        } catch (JSONException e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching ready Event.", e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[PHI: r5
      0x0074: PHI (r5v4 int) = (r5v3 int), (r5v7 int) binds: [B:11:0x0048, B:17:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r10, int r11) {
        /*
            r9 = this;
            android.content.Context r0 = r9.f25639d
            boolean r1 = r0 instanceof android.app.Activity
            r2 = 0
            if (r1 == 0) goto L15
            com.google.android.gms.ads.internal.zzt r1 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzs r1 = r1.f21679c
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            int[] r1 = com.google.android.gms.ads.internal.util.zzs.q(r1)
            r1 = r1[r2]
            goto L16
        L15:
            r1 = r2
        L16:
            com.google.android.gms.internal.ads.zzcjn r3 = r9.f25638c
            com.google.android.gms.internal.ads.zzcir r4 = r3.f26410a
            r5 = r4
            com.google.android.gms.internal.ads.zzcju r5 = (com.google.android.gms.internal.ads.zzcju) r5
            com.google.android.gms.internal.ads.zzclb r5 = r5.zzN()
            if (r5 == 0) goto L30
            r5 = r4
            com.google.android.gms.internal.ads.zzcju r5 = (com.google.android.gms.internal.ads.zzcju) r5
            com.google.android.gms.internal.ads.zzclb r5 = r5.zzN()
            boolean r5 = r5.b()
            if (r5 != 0) goto L87
        L30:
            int r5 = r3.getWidth()
            int r6 = r3.getHeight()
            com.google.android.gms.internal.ads.zzbgb r7 = com.google.android.gms.internal.ads.zzbgk.p0
            com.google.android.gms.ads.internal.client.zzbd r8 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r8 = r8.f21153c
            java.lang.Object r7 = r8.a(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L74
            if (r5 != 0) goto L60
            r5 = r4
            com.google.android.gms.internal.ads.zzcju r5 = (com.google.android.gms.internal.ads.zzcju) r5
            com.google.android.gms.internal.ads.zzclb r5 = r5.zzN()
            if (r5 == 0) goto L5f
            r5 = r4
            com.google.android.gms.internal.ads.zzcju r5 = (com.google.android.gms.internal.ads.zzcju) r5
            com.google.android.gms.internal.ads.zzclb r5 = r5.zzN()
            int r5 = r5.f26493c
            goto L60
        L5f:
            r5 = r2
        L60:
            if (r6 != 0) goto L74
            r6 = r4
            com.google.android.gms.internal.ads.zzcju r6 = (com.google.android.gms.internal.ads.zzcju) r6
            com.google.android.gms.internal.ads.zzclb r6 = r6.zzN()
            if (r6 == 0) goto L75
            com.google.android.gms.internal.ads.zzcju r4 = (com.google.android.gms.internal.ads.zzcju) r4
            com.google.android.gms.internal.ads.zzclb r2 = r4.zzN()
            int r2 = r2.f26492b
            goto L75
        L74:
            r2 = r6
        L75:
            com.google.android.gms.ads.internal.client.zzbb r4 = com.google.android.gms.ads.internal.client.zzbb.f21141g
            com.google.android.gms.ads.internal.util.client.zzf r6 = r4.f21142a
            int r5 = r6.i(r5, r0)
            r9.n = r5
            com.google.android.gms.ads.internal.util.client.zzf r4 = r4.f21142a
            int r0 = r4.i(r2, r0)
            r9.o = r0
        L87:
            int r0 = r11 - r1
            int r1 = r9.n
            int r2 = r9.o
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lb2
            r4.<init>()     // Catch: org.json.JSONException -> Lb2
            java.lang.String r5 = "x"
            org.json.JSONObject r4 = r4.put(r5, r10)     // Catch: org.json.JSONException -> Lb2
            java.lang.String r5 = "y"
            org.json.JSONObject r0 = r4.put(r5, r0)     // Catch: org.json.JSONException -> Lb2
            java.lang.String r4 = "width"
            org.json.JSONObject r0 = r0.put(r4, r1)     // Catch: org.json.JSONException -> Lb2
            java.lang.String r1 = "height"
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> Lb2
            com.google.android.gms.internal.ads.zzcir r1 = r9.f25649a     // Catch: org.json.JSONException -> Lb2
            java.lang.String r2 = "onDefaultPositionReceived"
            r1.m(r2, r0)     // Catch: org.json.JSONException -> Lb2
            goto Lba
        Lb2:
            r0 = move-exception
            int r1 = com.google.android.gms.ads.internal.util.zze.f21576b
            java.lang.String r1 = "Error occurred while dispatching default position."
            com.google.android.gms.ads.internal.util.client.zzo.d(r1, r0)
        Lba:
            com.google.android.gms.internal.ads.zzcjc r0 = r3.e0()
            com.google.android.gms.internal.ads.zzbvx r0 = r0.x
            if (r0 == 0) goto Lc6
            r0.f25620e = r10
            r0.f25621f = r11
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwc.f(int, int):void");
    }
}
