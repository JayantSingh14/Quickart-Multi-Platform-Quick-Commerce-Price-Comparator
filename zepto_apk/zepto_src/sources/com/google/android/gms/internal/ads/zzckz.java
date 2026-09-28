package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.webkit.ProfileStore;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzckz {

    /* renamed from: a, reason: collision with root package name */
    public final zzckq f26482a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxe f26483b;

    public zzckz(zzckq zzckqVar, zzdxe zzdxeVar) {
        this.f26482a = zzckqVar;
        this.f26483b = zzdxeVar;
    }

    public final void a(final Context context, final VersionInfoParcel versionInfoParcel) {
        zzbgb zzbgbVar = zzbgk.af;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            Executor threadPoolExecutor = zzcdo.f25982a;
            zzbgb zzbgbVar2 = zzbgk.cf;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue()) {
                zzcky zzckyVar = new zzcky(((Integer) zzbgiVar.a(zzbgk.ef)).intValue());
                int iIntValue = ((Integer) zzbgiVar.a(zzbgk.df)).intValue();
                threadPoolExecutor = new ThreadPoolExecutor(iIntValue, iIntValue, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzckyVar);
            }
            threadPoolExecutor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckw
                @Override // java.lang.Runnable
                public final void run() {
                    final zzckz zzckzVar = this.f26475a;
                    zzckzVar.getClass();
                    com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                    long jElapsedRealtime = zztVar.f21687k.elapsedRealtime();
                    zztVar.f21679c.E(context, versionInfoParcel.f21400a);
                    zzbgb zzbgbVar3 = zzbgk.bf;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                    if (((Boolean) zzbdVar2.f21153c.a(zzbgbVar3)).booleanValue()) {
                        long jElapsedRealtime2 = zztVar.f21687k.elapsedRealtime() - jElapsedRealtime;
                        zzdxd zzdxdVarA = zzckzVar.f26483b.a();
                        zzdxdVarA.b("action", "webview_startup_l");
                        StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length());
                        sb.append(jElapsedRealtime2);
                        zzdxdVarA.b("webview_startup_l", sb.toString());
                        zzdxdVarA.c();
                    }
                    if (((Boolean) zzbdVar2.f21153c.a(zzbgk.hf)).booleanValue()) {
                        ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckv
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzckz zzckzVar2 = zzckzVar;
                                zzckzVar2.getClass();
                                zzcku zzckuVar = new zzcku(zzckzVar2, com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime());
                                zzckq zzckqVar = zzckzVar2.f26482a;
                                zzckqVar.getClass();
                                if (!WebViewFeature.a("MULTI_PROFILE")) {
                                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.a("WebViewFeature.MULTI_PROFILE is not supported");
                                    return;
                                }
                                ProfileStore profileStore = null;
                                try {
                                    profileStore = (ProfileStore) ProfileStore.class.getDeclaredMethod("getInstance", null).invoke(null, null);
                                } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e2) {
                                    String strValueOf = String.valueOf(e2.getMessage());
                                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.a("Unable to get ProfileStore instance: ".concat(strValueOf));
                                    try {
                                        profileStore = (ProfileStore) Class.forName("androidx.webkit.ProfileStore$-CC").getDeclaredMethod("getInstance", null).invoke(null, null);
                                    } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e3) {
                                        com.google.android.gms.ads.internal.util.client.zzo.a("Unable to get ProfileStore instance: ".concat(String.valueOf(e3.getMessage())));
                                    }
                                }
                                zzckz zzckzVar3 = zzckuVar.f26473b;
                                if (profileStore != null) {
                                    zzckqVar.f26467a = profileStore.getOrCreateProfile("GMA_WEBVIEW_PROFILE");
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ff)).booleanValue()) {
                                        long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - zzckuVar.f26472a;
                                        zzdxd zzdxdVarA2 = zzckzVar3.f26483b.a();
                                        zzdxdVarA2.b("action", "webview_p_l");
                                        zzdxdVarA2.b("webview_p_l", Long.toString(jElapsedRealtime3));
                                        zzdxdVarA2.c();
                                        return;
                                    }
                                    return;
                                }
                                int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.f("WebViewCompat failure: No instance");
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ff)).booleanValue()) {
                                    zzdxd zzdxdVarA3 = zzckzVar3.f26483b.a();
                                    zzdxdVarA3.b("action", "webview_p_f");
                                    zzdxdVarA3.b("webview_p_f", "No instance");
                                    zzdxdVarA3.c();
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
