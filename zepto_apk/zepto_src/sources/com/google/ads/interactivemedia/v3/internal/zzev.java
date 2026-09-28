package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsAdapter;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes3.dex */
final class zzev {
    private final SecureSignalsAdapter zza;
    private final Context zzb;
    private final String zzc;
    private final TaskCompletionSource zzd = new TaskCompletionSource();

    public zzev(SecureSignalsAdapter secureSignalsAdapter, String str, Context context) {
        this.zza = secureSignalsAdapter;
        this.zzc = str;
        this.zzb = context;
    }

    @WorkerThread
    public final Task zzb() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.collectSignals(this.zzb, new zzeu(this, taskCompletionSource));
        return taskCompletionSource.f39750a;
    }

    @WorkerThread
    public final Task zzc() {
        this.zza.initialize(this.zzb, new zzet(this));
        return this.zzd.f39750a;
    }

    public final String zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zza.getVersion().toString();
    }
}
