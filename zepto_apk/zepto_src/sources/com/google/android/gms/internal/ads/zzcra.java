package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.api.Api;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzcra {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26928a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f26929b;

    /* renamed from: c, reason: collision with root package name */
    public final zzejc f26930c;

    /* renamed from: d, reason: collision with root package name */
    public final zzduf f26931d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgyw f26932e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgyw f26933f;

    /* renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f26934g;

    /* renamed from: h, reason: collision with root package name */
    public zzbxx f26935h;

    /* renamed from: i, reason: collision with root package name */
    public zzbxx f26936i;

    public zzcra(Context context, com.google.android.gms.ads.internal.util.zzj zzjVar, zzejc zzejcVar, zzduf zzdufVar, zzgyw zzgywVar, zzgyw zzgywVar2, ScheduledExecutorService scheduledExecutorService) {
        this.f26928a = context;
        this.f26929b = zzjVar;
        this.f26930c = zzejcVar;
        this.f26931d = zzdufVar;
        this.f26932e = zzgywVar;
        this.f26933f = zzgywVar2;
        this.f26934g = scheduledExecutorService;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ob));
    }

    public final ListenableFuture a(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzgym.a(str) : zzgym.f(c(str, this.f26931d.f28591a, random), Throwable.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcqz
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                final Throwable th = (Throwable) obj;
                final zzcra zzcraVar = this.f26926a;
                zzcraVar.getClass();
                ((zzgxi) zzcraVar.f26932e).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqy
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcra zzcraVar2 = zzcraVar;
                        zzcraVar2.getClass();
                        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.vb)).booleanValue();
                        Throwable th2 = th;
                        Context context = zzcraVar2.f26928a;
                        if (zBooleanValue) {
                            zzbxx zzbxxVarE = zzbxv.e(context);
                            zzcraVar2.f26936i = zzbxxVarE;
                            zzbxxVarE.a("AttributionReporting.getUpdatedUrlAndRegisterSource", th2);
                        } else {
                            zzbxx zzbxxVarC = zzbxv.c(context);
                            zzcraVar2.f26935h = zzbxxVarC;
                            zzbxxVarC.a("AttributionReportingSampled.getUpdatedUrlAndRegisterSource", th2);
                        }
                    }
                });
                return zzgym.a(str);
            }
        }, this.f26932e);
    }

    public final ListenableFuture c(final String str, final MotionEvent motionEvent, Random random) {
        ListenableFuture listenableFutureB;
        try {
            zzbgb zzbgbVar = zzbgk.ob;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            zzbgi zzbgiVar2 = zzbdVar.f21153c;
            if (!str.contains((CharSequence) zzbgiVar.a(zzbgbVar)) || this.f26929b.q()) {
                return zzgym.a(str);
            }
            final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter((String) zzbgiVar2.a(zzbgk.pb), String.valueOf(random.nextInt(Api.BaseClientBuilder.API_PRIORITY_OTHER)));
            if (motionEvent == null) {
                builderBuildUpon.appendQueryParameter((String) zzbgiVar2.a(zzbgk.qb), "11");
                return zzgym.a(builderBuildUpon.toString());
            }
            zzejc zzejcVar = this.f26930c;
            zzejcVar.getClass();
            try {
                MeasurementManagerFutures measurementManagerFuturesA = MeasurementManagerFutures.a(zzejcVar.f29456b);
                zzejcVar.f29455a = measurementManagerFuturesA;
                listenableFutureB = measurementManagerFuturesA == null ? zzgym.b(new IllegalStateException("MeasurementManagerFutures is null")) : measurementManagerFuturesA.b();
            } catch (Exception e2) {
                listenableFutureB = zzgym.b(e2);
            }
            return (zzgye) zzgym.f((zzgye) zzgym.h(zzgye.s(listenableFutureB), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcqu
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final ListenableFuture zza(Object obj) {
                    ListenableFuture listenableFutureB2;
                    MotionEvent motionEvent2 = motionEvent;
                    zzcra zzcraVar = this.f26915a;
                    zzcraVar.getClass();
                    int iIntValue = ((Integer) obj).intValue();
                    final Uri.Builder builder = builderBuildUpon;
                    if (iIntValue != 1) {
                        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.qb), "10");
                        return zzgym.a(builder.toString());
                    }
                    Uri.Builder builderBuildUpon2 = builder.build().buildUpon();
                    zzbgb zzbgbVar2 = zzbgk.rb;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                    builderBuildUpon2.appendQueryParameter((String) zzbdVar2.f21153c.a(zzbgbVar2), "1");
                    zzbgb zzbgbVar3 = zzbgk.qb;
                    zzbgi zzbgiVar3 = zzbdVar2.f21153c;
                    builderBuildUpon2.appendQueryParameter((String) zzbgiVar3.a(zzbgbVar3), "12");
                    if (str.contains((CharSequence) zzbgiVar3.a(zzbgk.sb))) {
                        builderBuildUpon2.authority((String) zzbgiVar3.a(zzbgk.tb));
                    }
                    Uri uriBuild = builderBuildUpon2.build();
                    zzejc zzejcVar2 = zzcraVar.f26930c;
                    zzejcVar2.getClass();
                    try {
                        MeasurementManagerFutures measurementManagerFutures = zzejcVar2.f29455a;
                        Objects.requireNonNull(measurementManagerFutures);
                        listenableFutureB2 = measurementManagerFutures.c(uriBuild, motionEvent2);
                    } catch (Exception e3) {
                        listenableFutureB2 = zzgym.b(e3);
                    }
                    return (zzgye) zzgym.h(zzgye.s(listenableFutureB2), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcqw
                        @Override // com.google.android.gms.internal.ads.zzgxu
                        public final ListenableFuture zza(Object obj2) {
                            String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.qb);
                            Uri.Builder builder2 = builder;
                            builder2.appendQueryParameter(str2, "12");
                            return zzgym.a(builder2.toString());
                        }
                    }, zzcraVar.f26933f);
                }
            }, this.f26933f), Throwable.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcqv
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final ListenableFuture zza(Object obj) {
                    final Throwable th = (Throwable) obj;
                    final zzcra zzcraVar = this.f26919a;
                    zzcraVar.getClass();
                    ((zzgxi) zzcraVar.f26932e).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqx
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcra zzcraVar2 = zzcraVar;
                            zzcraVar2.getClass();
                            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.vb)).booleanValue();
                            Throwable th2 = th;
                            Context context = zzcraVar2.f26928a;
                            if (zBooleanValue) {
                                zzbxx zzbxxVarE = zzbxv.e(context);
                                zzcraVar2.f26936i = zzbxxVarE;
                                zzbxxVarE.a("AttributionReporting", th2);
                            } else {
                                zzbxx zzbxxVarC = zzbxv.c(context);
                                zzcraVar2.f26935h = zzbxxVarC;
                                zzbxxVarC.a("AttributionReportingSampled", th2);
                            }
                        }
                    });
                    String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.qb);
                    Uri.Builder builder = builderBuildUpon;
                    builder.appendQueryParameter(str2, "9");
                    return zzgym.a(builder.toString());
                }
            }, this.f26932e);
        } catch (Exception e3) {
            return zzgym.b(e3);
        }
    }
}
