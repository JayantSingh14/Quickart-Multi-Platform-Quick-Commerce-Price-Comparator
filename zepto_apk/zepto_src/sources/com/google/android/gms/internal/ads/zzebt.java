package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;

/* loaded from: classes4.dex */
public final class zzebt implements zzddq, zzdjd, zzdby {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29029a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxe f29030b;

    public zzebt(Context context, zzdxe zzdxeVar) {
        this.f29029a = context;
        this.f29030b = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q5)).booleanValue()) {
            b(this.f29029a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void a(com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r5)).booleanValue()) {
            b(this.f29029a);
        }
    }

    public final void b(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.o5)).booleanValue()) {
            ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebs
                @Override // java.lang.Runnable
                public final void run() {
                    String strA;
                    zzebt zzebtVar = this.f29027a;
                    zzebtVar.getClass();
                    zzbhj zzbhjVar = com.google.android.gms.ads.internal.zzt.C.n;
                    Context context2 = context;
                    if (zzbhjVar.f25058b.getAndSet(true)) {
                        return;
                    }
                    zzbhjVar.f25059c = context2;
                    zzbhjVar.f25060d = zzebtVar.f29030b;
                    if (zzbhjVar.f25062f != null || (strA = CustomTabsClient.a(context2, null)) == null || strA.equals(context2.getPackageName())) {
                        return;
                    }
                    zzbhjVar.f1351a = context2.getApplicationContext();
                    Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                    if (!TextUtils.isEmpty(strA)) {
                        intent.setPackage(strA);
                    }
                    context2.bindService(intent, zzbhjVar, 33);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void q(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s5)).booleanValue()) {
            b(this.f29029a);
        }
    }
}
