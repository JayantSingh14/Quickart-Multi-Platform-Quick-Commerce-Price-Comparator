package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzesw implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30255a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30256b;

    public zzesw(Context context, zzgyw zzgywVar) {
        this.f30256b = zzgywVar;
        this.f30255a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ae)).booleanValue()) {
            return zzgym.a(new zzesx(null, false));
        }
        final ContentResolver contentResolver = this.f30255a.getContentResolver();
        if (contentResolver == null) {
            return zzgym.a(new zzesx(null, false));
        }
        return ((zzgxi) this.f30256b).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzesv
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                ContentResolver contentResolver2 = contentResolver;
                return new zzesx(Settings.Secure.getString(contentResolver2, "advertising_id"), Settings.Secure.getInt(contentResolver2, "limit_ad_tracking", 0) == 1);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 61;
    }
}
