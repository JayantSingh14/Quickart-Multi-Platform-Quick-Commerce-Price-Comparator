package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class zzbgn {

    /* renamed from: a, reason: collision with root package name */
    public final String f25024a = (String) zzbie.f25136a.c();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f25025b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f25026c;

    /* renamed from: d, reason: collision with root package name */
    public final String f25027d;

    /* JADX WARN: Multi-variable type inference failed */
    public zzbgn(Context context, String str) {
        boolean zIsBstar;
        this.f25026c = context;
        this.f25027d = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f25025b = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
        linkedHashMap.put(LogSubCategory.Context.DEVICE, com.google.android.gms.ads.internal.util.zzs.S());
        linkedHashMap.put(Constants.APP_DIR, context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        linkedHashMap.put("is_lite_sdk", true != com.google.android.gms.ads.internal.util.zzs.f(context) ? "0" : "1");
        zzbzh zzbzhVar = zztVar.p;
        zzbzhVar.getClass();
        ListenableFuture listenableFutureSubmit = ((zzgxi) zzcdo.f25982a).submit(new zzbzf(zzbzhVar, context));
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbze) listenableFutureSubmit.get()).f25768j));
            linkedHashMap.put("network_fine", Integer.toString(((zzbze) listenableFutureSubmit.get()).f25769k));
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("CsiConfiguration.CsiConfiguration", e2);
        }
        zzbgb zzbgbVar = zzbgk.wc;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            LinkedHashMap linkedHashMap2 = this.f25025b;
            com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzt.C.f21679c;
            try {
                zIsBstar = DeviceProperties.isBstar(context);
            } catch (NoSuchMethodError unused) {
                zIsBstar = false;
            }
            linkedHashMap2.put("is_bstar", true != zIsBstar ? "0" : "1");
        }
        zzbgb zzbgbVar2 = zzbgk.Ba;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue() && ((Boolean) zzbgiVar.a(zzbgk.M2)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt zztVar2 = com.google.android.gms.ads.internal.zzt.C;
            if (zzgpz.a(zztVar2.f21684h.f25937g)) {
                return;
            }
            this.f25025b.put("plugin", zztVar2.f21684h.f25937g);
        }
    }
}
