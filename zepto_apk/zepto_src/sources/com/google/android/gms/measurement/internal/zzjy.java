package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import in.juspay.airborne.ota.Constants;
import java.util.Objects;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
final class zzjy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzli f39227a;

    public zzjy(zzli zzliVar) {
        Objects.requireNonNull(zzliVar);
        this.f39227a = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzx zzxVar = this.f39227a.r;
        zzib zzibVar = zzxVar.f39665a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        if (zzxVar.c()) {
            boolean zB = zzxVar.b();
            zzli zzliVar = zzibVar.f39096m;
            zzhg zzhgVar = zzibVar.f39088e;
            if (zB) {
                zzib.j(zzhgVar);
                zzhgVar.w.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                zzib.k(zzliVar);
                zzliVar.o("auto", "_cmpx", bundle);
            } else {
                zzib.j(zzhgVar);
                zzhf zzhfVar = zzhgVar.w;
                String strA = zzhfVar.a();
                if (TextUtils.isEmpty(strA)) {
                    zzgt zzgtVar = zzibVar.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38959g.a("Cache still valid but referrer not found");
                } else {
                    long jA = zzhgVar.x.a() / DateUtils.MILLIS_PER_HOUR;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", (jA - 1) * DateUtils.MILLIS_PER_HOUR);
                    Object obj = pair.first;
                    String str2 = obj == null ? Constants.APP_DIR : (String) obj;
                    zzib.k(zzliVar);
                    zzliVar.o(str2, "_cmp", (Bundle) pair.second);
                }
                zzhfVar.b(null);
            }
            zzib.j(zzhgVar);
            zzhgVar.x.b(0L);
        }
    }
}
