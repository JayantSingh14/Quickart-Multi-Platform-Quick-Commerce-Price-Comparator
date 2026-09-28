package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class zzmo {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzmo(@NonNull Context context, @NonNull Executor executor, @NonNull Task task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static zzmo zza(@NonNull final Context context, @NonNull Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.zzmm
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.b(zzoe.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.zzmn
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.b(zzoe.zzc());
                }
            });
        }
        return new zzmo(context, executor, taskCompletionSource.f39750a, z);
    }

    public static void zzg(int i2) {
        zzf = i2;
    }

    private final Task zzh(final int i2, long j2, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.h(this.zzc, new Continuation() { // from class: com.google.ads.interactivemedia.v3.internal.zzmk
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Boolean.valueOf(task.p());
                }
            });
        }
        Context context = this.zzb;
        final zzr zzrVarZza = zzv.zza();
        zzrVarZza.zza(context.getPackageName());
        zzrVarZza.zze(j2);
        zzrVarZza.zzg(zzf);
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzrVarZza.zzf(stringWriter.toString());
            zzrVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzrVarZza.zzb(str2);
        }
        if (str != null) {
            zzrVarZza.zzc(str);
        }
        return this.zzd.h(this.zzc, new Continuation() { // from class: com.google.ads.interactivemedia.v3.internal.zzml
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                if (!task.p()) {
                    return Boolean.FALSE;
                }
                int i3 = i2;
                zzod zzodVarZza = ((zzoe) task.l()).zza(((zzv) zzrVarZza.zzal()).zzav());
                zzodVarZza.zza(i3);
                zzodVarZza.zzc();
                return Boolean.TRUE;
            }
        });
    }

    public final Task zzb(int i2, String str) {
        return zzh(i2, 0L, null, null, null, str);
    }

    public final Task zzc(int i2, long j2, Exception exc) {
        return zzh(i2, j2, exc, null, null, null);
    }

    public final Task zzd(int i2, long j2) {
        return zzh(i2, j2, null, null, null, null);
    }

    public final Task zze(int i2, long j2, String str) {
        return zzh(i2, j2, null, null, null, str);
    }

    public final Task zzf(int i2, long j2, String str, Map map) {
        return zzh(i2, j2, null, str, null, null);
    }
}
