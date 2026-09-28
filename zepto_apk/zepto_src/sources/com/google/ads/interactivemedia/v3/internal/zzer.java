package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Build;
import com.google.ads.interactivemedia.pal.PlatformSignalCollector;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.tv.ads.SignalCollector;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class zzer {
    private final Context zza;
    private final ExecutorService zzb;
    private final PlatformSignalCollector zzc;
    private final zzel zzd;
    private final TaskCompletionSource zze;

    public zzer(Context context, ExecutorService executorService, zzel zzelVar, TestingConfiguration testingConfiguration) {
        SignalCollector signalCollector = null;
        if (Build.VERSION.SDK_INT >= 26 && zzdt.zzb(context, testingConfiguration)) {
            signalCollector = new SignalCollector();
        }
        this.zze = new TaskCompletionSource();
        this.zza = context;
        this.zzb = executorService;
        this.zzd = zzelVar;
        this.zzc = signalCollector;
    }

    public final Task zza() {
        return this.zze.f39750a;
    }

    public final void zzb(Integer num) {
        PlatformSignalCollector platformSignalCollector = this.zzc;
        if (platformSignalCollector == null || num == null) {
            this.zze.b(null);
            return;
        }
        Task<Map<String, String>> taskCollectSignals = platformSignalCollector.collectSignals(this.zza, this.zzb);
        long jIntValue = num.intValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Task taskI = Tasks.i(taskCollectSignals, jIntValue);
        final TaskCompletionSource taskCompletionSource = this.zze;
        Objects.requireNonNull(taskCompletionSource);
        taskI.e(new OnSuccessListener() { // from class: com.google.ads.interactivemedia.v3.internal.zzep
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                taskCompletionSource.b((Map) obj);
            }
        });
        taskI.c(new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.zzeq
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zza.zzc(exc);
            }
        });
    }

    public final /* synthetic */ void zzc(Exception exc) {
        this.zzd.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.PLATFORM_SIGNAL_COLLECTOR, com.google.ads.interactivemedia.v3.impl.data.zzbz.PLATFORM_COLLECT_SIGNALS, exc);
        this.zze.a(exc);
    }
}
