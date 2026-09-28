package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
final class zziq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbg f39137a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzr f39138b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzjc f39139c;

    public zziq(zzjc zzjcVar, zzbg zzbgVar, zzr zzrVar) {
        this.f39137a = zzbgVar;
        this.f39138b = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39139c = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        zzbe zzbeVar;
        zzjc zzjcVar = this.f39139c;
        zzjcVar.getClass();
        zzbg zzbgVar = this.f39137a;
        boolean zEquals = "_cmp".equals(zzbgVar.f38769a);
        zzpf zzpfVar = zzjcVar.f39177a;
        if (zEquals && (zzbeVar = zzbgVar.f38770b) != null) {
            Bundle bundle = zzbeVar.f38768a;
            if (bundle.size() != 0) {
                String string = bundle.getString("_cis");
                if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                    zzpfVar.b().f38964l.b(zzbgVar.toString(), "Event has been filtered ");
                    zzbgVar = new zzbg("_cmpx", zzbeVar, zzbgVar.f38771c, zzbgVar.f38772d);
                }
            }
        }
        String str = zzbgVar.f38769a;
        zzhs zzhsVar = zzpfVar.f39594a;
        zzpj zzpjVar = zzpfVar.f39600g;
        zzpf.S(zzhsVar);
        zzr zzrVar = this.f39138b;
        String str2 = zzrVar.f39648a;
        com.google.android.gms.internal.measurement.zzc zzcVar = TextUtils.isEmpty(str2) ? null : (com.google.android.gms.internal.measurement.zzc) zzhsVar.f39056j.c(str2);
        if (zzcVar == null) {
            zzpfVar.b().n.b(zzrVar.f39648a, "EES not loaded for");
            zzpfVar.A();
            zzpfVar.j(zzbgVar, zzrVar);
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzab zzabVar = zzcVar.f36815c;
            zzpf.S(zzpjVar);
            HashMap mapR = zzpj.R(zzbgVar.f38770b.A(), true);
            String strB = zzls.b(str, zzjl.f39203c, zzjl.f39201a);
            if (strB == null) {
                strB = str;
            }
            if (zzcVar.a(new com.google.android.gms.internal.measurement.zzaa(strB, zzbgVar.f38772d, mapR))) {
                if (zzabVar.c().equals(zzabVar.a())) {
                    zzpfVar.A();
                    zzpfVar.j(zzbgVar, zzrVar);
                } else {
                    zzpfVar.b().n.b(str, "EES edited event");
                    zzpf.S(zzpjVar);
                    zzbg zzbgVarK = zzpj.k(zzabVar.c());
                    zzpfVar.A();
                    zzpfVar.j(zzbgVarK, zzrVar);
                }
                if (((ArrayList) zzabVar.d()).isEmpty()) {
                    return;
                }
                Iterator it = ((ArrayList) zzabVar.d()).iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzaa zzaaVar = (com.google.android.gms.internal.measurement.zzaa) it.next();
                    zzpfVar.b().n.b(zzaaVar.b(), "EES logging created event");
                    zzpf.S(zzpjVar);
                    zzbg zzbgVarK2 = zzpj.k(zzaaVar);
                    zzpfVar.A();
                    zzpfVar.j(zzbgVarK2, zzrVar);
                }
                return;
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            zzpfVar.b().f38958f.c("EES error. appId, eventName", zzrVar.f39649b, str);
        }
        zzpfVar.b().n.b(str, "EES was not applied to event");
        zzpfVar.A();
        zzpfVar.j(zzbgVar, zzrVar);
    }
}
