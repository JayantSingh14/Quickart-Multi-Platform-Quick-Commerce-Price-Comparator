package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzgyj;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzag implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzau f21770a;

    public zzag(zzau zzauVar) {
        Objects.requireNonNull(zzauVar);
        this.f21770a = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.C.f21684h.d("SignalGeneratorImpl.initializeWebViewForSignalCollection", th);
        Pair pair = new Pair("sgf_reason", th.getMessage());
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair("ad_format", "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        zzau zzauVar = this.f21770a;
        zzaa.d(zzauVar.f21805l, "sgf", pair, pair2, pair3, pair4, pair5, new Pair("sgi_rn", Integer.toString(zzauVar.D.get())));
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.d("Failed to initialize webview for loading SDKCore. ", th);
        zzbgb zzbgbVar = zzbgk.Qa;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() || zzauVar.C.get()) {
            return;
        }
        if (zzauVar.D.getAndIncrement() < ((Integer) zzbdVar.f21153c.a(zzbgk.Ra)).intValue()) {
            zzauVar.ac();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Initialized webview successfully for SDKCore.");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Qa)).booleanValue()) {
            Pair pair = new Pair("se", "query_g");
            Pair pair2 = new Pair("ad_format", "BANNER");
            Pair pair3 = new Pair("rtype", Integer.toString(6));
            Pair pair4 = new Pair("scar", "true");
            zzau zzauVar = this.f21770a;
            zzaa.d(zzauVar.f21805l, "sgs", pair, pair2, pair3, pair4, new Pair("sgi_rn", Integer.toString(zzauVar.D.get())));
            zzauVar.C.set(true);
        }
    }
}
