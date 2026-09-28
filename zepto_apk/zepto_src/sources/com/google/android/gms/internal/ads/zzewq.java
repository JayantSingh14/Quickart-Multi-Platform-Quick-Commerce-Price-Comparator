package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzewq implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30493a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30494b;

    public zzewq(Context context, zzgyw zzgywVar) {
        this.f30493a = context;
        this.f30494b = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30494b).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzewp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzewq zzewqVar = this.f30492a;
                zzewqVar.getClass();
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                zzbgb zzbgbVar = zzbgk.K6;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
                Context context = zzewqVar.f30493a;
                String string = !zBooleanValue ? "" : context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
                zzbgb zzbgbVar2 = zzbgk.M6;
                zzbgi zzbgiVar = zzbdVar.f21153c;
                String string2 = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue() ? context.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
                Bundle bundle = null;
                if (((Boolean) zzbgiVar.a(zzbgk.L6)).booleanValue()) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    Bundle bundle2 = new Bundle();
                    if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                        bundle2.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
                    }
                    String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
                    for (int i2 = 0; i2 < 4; i2++) {
                        String str = strArr[i2];
                        if (defaultSharedPreferences.contains(str)) {
                            bundle2.putString(str, defaultSharedPreferences.getString(str, null));
                        }
                    }
                    bundle = bundle2;
                }
                return new zzewo(string, string2, bundle);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 18;
    }
}
