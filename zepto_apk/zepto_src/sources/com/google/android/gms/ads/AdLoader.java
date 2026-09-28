package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzek;
import com.google.android.gms.ads.internal.client.zzfi;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbsv;

/* loaded from: classes4.dex */
public class AdLoader {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20993a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbq f20994b;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f20995a;

        /* renamed from: b, reason: collision with root package name */
        public final zzbt f20996b;

        public Builder(Context context, String str) {
            Context context2 = (Context) Preconditions.checkNotNull(context, "context cannot be null");
            zzbt zzbtVarC = zzbb.f21141g.f21143b.c(context, str, new zzbsv());
            this.f20995a = context2;
            this.f20996b = zzbtVarC;
        }

        public final AdLoader a() {
            Context context = this.f20995a;
            try {
                return new AdLoader(context, this.f20996b.zze());
            } catch (RemoteException e2) {
                zzo.d("Failed to build AdLoader.", e2);
                return new AdLoader(context, new zzfi().Xb());
            }
        }

        public final void b(NativeAdOptions nativeAdOptions) {
            try {
                zzbt zzbtVar = this.f20996b;
                boolean z = nativeAdOptions.f21721a;
                boolean z2 = nativeAdOptions.f21723c;
                int i2 = nativeAdOptions.f21724d;
                VideoOptions videoOptions = nativeAdOptions.f21725e;
                zzbtVar.P8(new zzbjn(4, z, -1, z2, i2, videoOptions != null ? new zzga(videoOptions) : null, nativeAdOptions.f21726f, nativeAdOptions.f21722b, nativeAdOptions.f21728h, nativeAdOptions.f21727g, nativeAdOptions.f21729i - 1));
            } catch (RemoteException e2) {
                zzo.g("Failed to specify native ad options", e2);
            }
        }
    }

    public AdLoader(Context context, zzbq zzbqVar) {
        this.f20993a = context;
        this.f20994b = zzbqVar;
    }

    public final void a(AdRequest adRequest) {
        final zzek zzekVar = adRequest.f20997a;
        Context context = this.f20993a;
        zzbgk.a(context);
        if (((Boolean) zzbii.f25157c.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.zza
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzek zzekVar2 = zzekVar;
                        AdLoader adLoader = this.f21984a;
                        adLoader.getClass();
                        try {
                            adLoader.f20994b.U0(zzq.a(adLoader.f20993a, zzekVar2));
                        } catch (RemoteException e2) {
                            zzo.d("Failed to load ad.", e2);
                        }
                    }
                });
                return;
            }
        }
        try {
            this.f20994b.U0(zzq.a(context, zzekVar));
        } catch (RemoteException e2) {
            zzo.d("Failed to load ad.", e2);
        }
    }
}
