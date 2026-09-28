package com.google.android.tv.ads;

import android.content.Context;
import com.google.ads.interactivemedia.pal.PlatformSignalCollector;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.gms.internal.atv_ads_framework.zzaa;
import com.google.android.gms.internal.atv_ads_framework.zzab;
import com.google.android.gms.internal.atv_ads_framework.zzac;
import com.google.android.gms.internal.atv_ads_framework.zzad;
import com.google.android.gms.internal.atv_ads_framework.zzz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class SignalCollector implements PlatformSignalCollector {
    @Override // com.google.ads.interactivemedia.pal.PlatformSignalCollector
    public final Task collectSignals(final Context context, ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        context.getClass();
        executorService.getClass();
        executorService.execute(new Runnable() { // from class: com.google.android.tv.ads.zzg
            @Override // java.lang.Runnable
            public final void run() {
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                Context context2 = context;
                try {
                    taskCompletionSource2.b(zzad.c(context2));
                } catch (RuntimeException e2) {
                    com.google.android.gms.internal.atv_ads_framework.zzf zzfVarA = com.google.android.gms.internal.atv_ads_framework.zzf.a(context2);
                    zzz zzzVarK = zzaa.k();
                    zzzVarK.d();
                    zzaa.l((zzaa) zzzVarK.f36121b);
                    zzaa zzaaVar = (zzaa) zzzVarK.b();
                    zzab zzabVarB = zzad.b(zzfVarA.f36180b);
                    zzabVarB.d();
                    zzac.m((zzac) zzabVarB.f36121b, zzaaVar);
                    zzac zzacVar = (zzac) zzabVarB.b();
                    zzfVarA.f36179a.a("TV_ADS_LIB", new Encoding("proto"), com.google.android.gms.internal.atv_ads_framework.zze.f36143a).b(Event.g(zzacVar));
                    taskCompletionSource2.a(e2);
                }
            }
        });
        return taskCompletionSource.f39750a;
    }
}
