package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzelu implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29679a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdlv f29680b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f29681c;

    public zzelu(Context context, zzdlv zzdlvVar, Executor executor) {
        this.f29679a = context;
        this.f29680b = zzdlvVar;
        this.f29681c = executor;
    }

    public static final boolean c(zzfic zzficVar, int i2) {
        return zzficVar.f31193a.f31185a.f31220h.contains(Integer.toString(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x0528  */
    @Override // com.google.android.gms.internal.ads.zzejm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.google.android.gms.internal.ads.zzfic r48, com.google.android.gms.internal.ads.zzfhr r49, com.google.android.gms.internal.ads.zzejj r50) throws com.google.android.gms.internal.ads.zzemv {
        /*
            Method dump skipped, instructions count: 1458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelu.a(com.google.android.gms.internal.ads.zzfic, com.google.android.gms.internal.ads.zzfhr, com.google.android.gms.internal.ads.zzejj):java.lang.Object");
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws JSONException, zzfir, IOException {
        zzfji zzfjiVar = (zzfji) zzejjVar.f29463b;
        zzfik zzfikVar = zzficVar.f31193a.f31185a;
        String string = zzfhrVar.v.toString();
        String strI = com.google.android.gms.ads.internal.util.zzbp.i(zzfhrVar.s);
        Context context = this.f29679a;
        zzbtf zzbtfVar = (zzbtf) zzejjVar.f29464c;
        zzbjn zzbjnVar = zzfikVar.f31222j;
        ArrayList arrayList = zzfikVar.f31220h;
        try {
            zzfjiVar.f31270a.E8(new ObjectWrapper(context), zzfikVar.f31216d, string, strI, zzbtfVar, zzbjnVar, arrayList);
        } catch (Throwable th) {
            throw new zzfir(th);
        }
    }
}
