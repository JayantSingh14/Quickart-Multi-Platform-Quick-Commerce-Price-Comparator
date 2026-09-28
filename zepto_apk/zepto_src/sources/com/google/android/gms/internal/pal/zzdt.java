package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes4.dex */
final class zzdt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdu f37633a;

    public zzdt(zzdu zzduVar) {
        this.f37633a = zzduVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdu zzduVar = this.f37633a;
        zzgc zzgcVar = zzgk.f37764a;
        final Context context = zzduVar.f37634a;
        zzgl.a(new zzis() { // from class: com.google.android.gms.internal.pal.zzgj
            @Override // com.google.android.gms.internal.pal.zzis
            public final Object zza() {
                Context context2 = context;
                zzgc zzgcVar2 = zzgk.f37764a;
                zzgi zzgiVar = zzfv.f37741d.f37744c;
                if (zzgiVar.f37757c) {
                    return null;
                }
                synchronized (zzgiVar.f37755a) {
                    try {
                        if (zzgiVar.f37757c) {
                            return null;
                        }
                        if (!zzgiVar.f37758d) {
                            zzgiVar.f37758d = true;
                        }
                        Context applicationContext = context2.getApplicationContext() == null ? context2 : context2.getApplicationContext();
                        zzgiVar.f37761g = applicationContext;
                        try {
                            zzgiVar.f37760f = Wrappers.packageManager(applicationContext).getApplicationInfo(zzgiVar.f37761g.getPackageName(), 128).metaData;
                        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                        }
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context2);
                        if (remoteContext != null || (remoteContext = context2.getApplicationContext()) != null) {
                            context2 = remoteContext;
                        }
                        zzge zzgeVar = zzfv.f37741d.f37743b;
                        SharedPreferences sharedPreferences = context2.getSharedPreferences("google_ads_flags", 0);
                        zzgiVar.f37759e = sharedPreferences;
                        if (sharedPreferences != null) {
                            sharedPreferences.registerOnSharedPreferenceChangeListener(zzgiVar);
                        }
                        zzgr.f37780a.set(new zzgh(zzgiVar));
                        zzgiVar.b();
                        zzgiVar.f37757c = true;
                        zzgiVar.f37758d = false;
                        zzgiVar.f37756b.open();
                        return null;
                    } catch (Throwable th) {
                        zzgiVar.f37758d = false;
                        zzgiVar.f37756b.open();
                        throw th;
                    } finally {
                    }
                }
            }
        });
    }
}
