package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzekt implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29573a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdkz f29574b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f29575c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfhq f29576d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdxe f29577e;

    public zzekt(Context context, Executor executor, zzdkz zzdkzVar, zzfhq zzfhqVar, zzdxe zzdxeVar) {
        this.f29573a = context;
        this.f29574b = zzdkzVar;
        this.f29575c = executor;
        this.f29576d = zzfhqVar;
        this.f29577e = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(final zzfic zzficVar, final zzfhr zzfhrVar) throws JSONException {
        String string;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ke)).booleanValue()) {
            zzdxd zzdxdVarA = this.f29577e.a();
            zzdxdVarA.b("action", "cstm_tbs_rndr");
            zzdxdVarA.c();
        }
        try {
            string = zzfhrVar.v.getString("tab_url");
        } catch (Exception unused) {
            string = null;
        }
        final Uri uri = string != null ? Uri.parse(string) : null;
        zzfib zzfibVar = zzficVar.f31194b;
        ListenableFuture listenableFuture = zzgyq.f33377b;
        final zzfhu zzfhuVar = zzfibVar.f31190b;
        return zzgym.h(listenableFuture, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzeks
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                Uri uri2 = uri;
                zzfic zzficVar2 = zzficVar;
                zzfhr zzfhrVar2 = zzfhrVar;
                zzfhu zzfhuVar2 = zzfhuVar;
                zzekt zzektVar = this.f29568a;
                zzektVar.getClass();
                try {
                    Intent intent = new CustomTabsIntent.Builder().a().f1341a;
                    intent.setData(uri2);
                    com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(intent, null);
                    zzcdt zzcdtVar = new zzcdt();
                    zzdjt zzdjtVarD = zzektVar.f29574b.d(new zzcwa(zzficVar2, zzfhrVar2, null), new zzdjw(new zzekr(zzektVar, zzcdtVar, zzfhrVar2), null));
                    zzcdtVar.b(new AdOverlayInfoParcel(zzcVar, null, (zzdcv) ((zzcnm) zzdjtVarD).I.zzb(), null, new VersionInfoParcel(0, 0, false, false), null, null, zzfhuVar2.f31167b));
                    zzektVar.f29576d.c(2, 3);
                    return zzgym.a(zzdjtVarD.g());
                } catch (Throwable th) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Error in CustomTabsAdRenderer", th);
                    throw th;
                }
            }
        }, this.f29575c);
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) throws JSONException {
        String string;
        Context context = this.f29573a;
        if (!(context instanceof Activity) || !zzbhl.a(context)) {
            return false;
        }
        try {
            string = zzfhrVar.v.getString("tab_url");
        } catch (Exception unused) {
            string = null;
        }
        return !TextUtils.isEmpty(string);
    }
}
