package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbyw extends zzbyt {

    /* renamed from: b, reason: collision with root package name */
    public final Context f25709b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f25710c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbsj f25711d;

    /* renamed from: e, reason: collision with root package name */
    public final VersionInfoParcel f25712e;

    /* renamed from: g, reason: collision with root package name */
    public final zzgyw f25714g;

    /* renamed from: a, reason: collision with root package name */
    public final Object f25708a = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f25713f = new AtomicBoolean(false);

    public zzbyw(Context context, zzbsj zzbsjVar, VersionInfoParcel versionInfoParcel, zzgyw zzgywVar) {
        this.f25709b = context.getApplicationContext();
        this.f25712e = versionInfoParcel;
        this.f25711d = zzbsjVar;
        this.f25714g = zzgywVar;
    }

    public static JSONObject b(Context context, VersionInfoParcel versionInfoParcel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbik.f25180f.c()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.f21400a);
            jSONObject.put("mf", zzbik.f25181g.c());
            jSONObject.put("cl", "829525209");
            jSONObject.put("rapid_rc", PaymentConstants.ENVIRONMENT.DEV);
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.d(context, ModuleDescriptor.MODULE_ID, false));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final ListenableFuture a() {
        synchronized (this.f25708a) {
            try {
                if (this.f25710c == null) {
                    this.f25710c = this.f25709b.getSharedPreferences("google_ads_flags_meta", 0);
                }
            } finally {
            }
        }
        SharedPreferences sharedPreferences = this.f25710c;
        if (com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - (sharedPreferences != null ? sharedPreferences.getLong("js_last_update", 0L) : 0L) < ((Long) zzbik.f25182h.c()).longValue()) {
            return zzgyq.f33377b;
        }
        return zzgym.i(this.f25711d.a(b(this.f25709b, this.f25712e)), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzbyu
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) throws JSONException {
                SharedPreferences sharedPreferences2;
                JSONObject jSONObject = (JSONObject) obj;
                zzbyw zzbywVar = this.f25706a;
                zzbywVar.getClass();
                zzbgb zzbgbVar = zzbgk.f25011a;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                zzbgd zzbgdVar = zzbdVar.f21152b;
                Context context = zzbywVar.f25709b;
                SharedPreferences sharedPreferencesA = zzbgd.a(context);
                if (sharedPreferencesA != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                    zzbgc zzbgcVar = zzbdVar.f21151a;
                    Objects.requireNonNull(zzbgcVar);
                    Iterator it = zzbgcVar.f24992a.iterator();
                    while (it.hasNext()) {
                        zzbgb zzbgbVar2 = (zzbgb) it.next();
                        if (zzbgbVar2.f24988a == 1) {
                            zzbgbVar2.b(editorEdit, zzbgbVar2.c(jSONObject));
                        }
                    }
                    if (jSONObject != null) {
                        editorEdit.putString("flag_configuration", jSONObject.toString());
                    } else {
                        com.google.android.gms.ads.internal.util.client.zzo.c("Flag Json is null.");
                    }
                    if ((((Boolean) zzbik.o.c()).booleanValue() || ((Boolean) zzbik.p.c()).booleanValue()) && !ClientLibraryUtils.isPackageSide()) {
                        zzbgd zzbgdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e.f21152b;
                        editorEdit.apply();
                    } else {
                        zzbgd zzbgdVar3 = com.google.android.gms.ads.internal.client.zzbd.f21150e.f21152b;
                        editorEdit.commit();
                    }
                    if (((Boolean) zzbik.f25179e.c()).booleanValue() && !TextUtils.equals(context.getPackageName(), "com.google.android.gms")) {
                        zzbgd zzbgdVar4 = com.google.android.gms.ads.internal.client.zzbd.f21150e.f21152b;
                        try {
                            sharedPreferences2 = context.getSharedPreferences("google_adapter_flags", 0);
                        } catch (IllegalStateException e2) {
                            com.google.android.gms.ads.internal.util.client.zzo.g("", e2);
                            sharedPreferences2 = null;
                        }
                        if (sharedPreferences2 != null) {
                            SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                            JSONObject jSONObject2 = new JSONObject();
                            Iterator<String> itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                if (next.startsWith("adapter:")) {
                                    try {
                                        jSONObject2.put(next, jSONObject.get(next));
                                    } catch (JSONException unused) {
                                    }
                                }
                            }
                            editorEdit2.putString("flag_configuration", jSONObject2.toString());
                            editorEdit2.apply();
                        }
                    }
                    SharedPreferences sharedPreferences3 = zzbywVar.f25710c;
                    if (sharedPreferences3 != null) {
                        sharedPreferences3.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis()).apply();
                    }
                }
                return null;
            }
        }, ((Boolean) zzbik.f25187m.c()).booleanValue() ? this.f25714g : zzcdo.f25988g);
    }
}
