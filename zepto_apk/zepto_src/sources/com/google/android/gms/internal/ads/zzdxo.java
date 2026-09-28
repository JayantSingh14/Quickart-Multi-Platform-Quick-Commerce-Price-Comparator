package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults_Factory;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder_Factory;
import com.google.android.gms.common.util.DeviceProperties;
import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzdxo implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijp f28758a;

    /* renamed from: b, reason: collision with root package name */
    public final CsiParamDefaults_Factory f28759b;

    /* renamed from: c, reason: collision with root package name */
    public final CsiUrlBuilder_Factory f28760c;

    /* renamed from: d, reason: collision with root package name */
    public final zzclp f28761d;

    public zzdxo(zzijp zzijpVar, CsiParamDefaults_Factory csiParamDefaults_Factory, CsiUrlBuilder_Factory csiUrlBuilder_Factory, zzclp zzclpVar) {
        this.f28758a = zzijpVar;
        this.f28759b = csiParamDefaults_Factory;
        this.f28760c = csiUrlBuilder_Factory;
        this.f28761d = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        boolean zIsBstar;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        com.google.android.gms.ads.internal.util.client.zzu zzuVar = (com.google.android.gms.ads.internal.util.client.zzu) this.f28758a.zzb();
        CsiParamDefaults_Factory csiParamDefaults_Factory = this.f28759b;
        Context context = (Context) csiParamDefaults_Factory.f21966a.zzb();
        CsiParamDefaults csiParamDefaults = new CsiParamDefaults(context, (VersionInfoParcel) csiParamDefaults_Factory.f21967b.zzb());
        this.f28760c.getClass();
        zzdxj zzdxjVar = new zzdxj(zzgywVar, zzuVar, new CsiUrlBuilder(), this.f28761d.a());
        HashMap map = zzdxjVar.f28748a;
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
        map.put(LogSubCategory.Context.DEVICE, com.google.android.gms.ads.internal.util.zzs.S());
        map.put(Constants.APP_DIR, csiParamDefaults.f21964a);
        map.put("is_lite_sdk", true != com.google.android.gms.ads.internal.util.zzs.f(context) ? "0" : "1");
        zzbgb zzbgbVar = zzbgk.f25011a;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        ArrayList arrayListB = zzbdVar.f21151a.b();
        zzbgb zzbgbVar2 = zzbgk.z7;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        boolean zBooleanValue = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
        zzcda zzcdaVar = zztVar.f21684h;
        if (zBooleanValue) {
            arrayListB.addAll(zzcdaVar.g().i().f25915i);
        }
        map.put("e", TextUtils.join(",", arrayListB));
        map.put(PaymentConstants.SDK_VERSION, csiParamDefaults.f21965b);
        if (((Boolean) zzbgiVar.a(zzbgk.wc)).booleanValue()) {
            try {
                zIsBstar = DeviceProperties.isBstar(context);
            } catch (NoSuchMethodError unused) {
                zIsBstar = false;
            }
            map.put("is_bstar", true != zIsBstar ? "0" : "1");
        }
        if (((Boolean) zzbgiVar.a(zzbgk.Ba)).booleanValue() && ((Boolean) zzbgiVar.a(zzbgk.M2)).booleanValue()) {
            String str = zzcdaVar.f25937g;
            if (str == null) {
                str = "";
            }
            map.put("plugin", str);
        }
        return zzdxjVar;
    }
}
