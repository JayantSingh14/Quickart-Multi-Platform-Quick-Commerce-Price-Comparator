package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsAdapter;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class zzff {
    private final List zza = new ArrayList(0);
    private final TaskCompletionSource zzb = new TaskCompletionSource();
    private final TaskCompletionSource zzc = new TaskCompletionSource();
    private final Context zzd;
    private final ExecutorService zze;
    private final zzel zzf;

    @Nullable
    private Integer zzg;

    public zzff(Context context, ExecutorService executorService, zzel zzelVar) {
        this.zzd = context;
        this.zze = executorService;
        this.zzf = zzelVar;
    }

    public static /* synthetic */ Task zza(zzff zzffVar, Task task) {
        final List list = (List) task.l();
        return Tasks.g(list).h(zzffVar.zze, new Continuation() { // from class: com.google.ads.interactivemedia.v3.internal.zzey
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return list;
            }
        });
    }

    public static /* synthetic */ Void zzd(zzff zzffVar, Task task) {
        zzffVar.zzc.d(zzffVar.zza);
        return null;
    }

    private final void zzi(com.google.ads.interactivemedia.v3.impl.data.zzbz zzbzVar, Exception exc) {
        this.zzf.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.NATIVE_ESP, zzbzVar, exc);
    }

    private final void zzj(zzev zzevVar) {
        this.zza.remove(zzevVar);
    }

    private static final Exception zzk(zzev zzevVar, Exception exc) {
        return new Exception(e.p("Exception with SecureSignalsAdapter ", zzevVar.zze(), ":", zzevVar.zzf()), exc);
    }

    public final Task zzb() {
        this.zzb.f39750a.h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.v3.internal.zzfd
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                List<zzev> list = (List) task.l();
                ArrayList arrayList = new ArrayList(list.size());
                for (final zzev zzevVar : list) {
                    final zzff zzffVar = this.zza;
                    Task taskZzc = zzevVar.zzc();
                    taskZzc.c(new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.zzex
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            zzffVar.zzh(zzevVar, exc);
                        }
                    });
                    arrayList.add(taskZzc);
                }
                return arrayList;
            }
        }).j(this.zze, new zzfa(this)).h(this.zze, new zzfb(this)).h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.v3.internal.zzfe
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzff.zzd(this.zza, task);
                return null;
            }
        });
        return this.zzc.f39750a;
    }

    @WorkerThread
    public final Task zzc(@Nullable List list, @Nullable Integer num) {
        if (num.intValue() == 0) {
            this.zzb.c(new Exception("No adapters to load"));
            return this.zzb.f39750a;
        }
        this.zzg = num;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzev zzevVar = null;
            try {
                int i2 = 0;
                Class<?> cls = Class.forName(str, false, zzff.class.getClassLoader());
                Class<?>[] interfaces = cls.getInterfaces();
                String name = SecureSignalsAdapter.class.getName();
                int length = interfaces.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (interfaces[i2].getName().equals(name)) {
                        zzevVar = new zzev((SecureSignalsAdapter) cls.getDeclaredConstructor(null).newInstance(null), str, this.zzd);
                        break;
                    }
                    i2++;
                }
            } catch (Throwable unused) {
            }
            if (zzevVar != null) {
                try {
                    this.zza.add(zzevVar);
                } catch (Exception e2) {
                    zzi(com.google.ads.interactivemedia.v3.impl.data.zzbz.LOAD_ADAPTER, new Exception("Exception with SecureSignalsAdapter ".concat(String.valueOf(str)), e2));
                }
            }
        }
        this.zzb.d(this.zza);
        return this.zzb.f39750a;
    }

    @WorkerThread
    public final List zze() {
        Task taskI;
        try {
            Task taskH = this.zzc.f39750a.h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.v3.internal.zzez
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    List<zzev> list = (List) task.l();
                    ArrayList arrayList = new ArrayList(list.size());
                    for (final zzev zzevVar : list) {
                        final zzff zzffVar = this.zza;
                        arrayList.add(zzevVar.zzb().c(new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.zzew
                            @Override // com.google.android.gms.tasks.OnFailureListener
                            public final void onFailure(Exception exc) {
                                zzffVar.zzg(zzevVar, exc);
                            }
                        }));
                    }
                    return arrayList;
                }
            }).j(this.zze, new zzfa(this)).h(this.zze, new zzfb(this));
            Integer num = this.zzg;
            if (num == null) {
                taskI = Tasks.e(new ArrayList());
            } else {
                long jIntValue = num.intValue();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                taskI = Tasks.i(taskH, jIntValue);
                taskI.c(new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.zzfc
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        this.zza.zzf(exc);
                    }
                });
            }
            return (List) Tasks.a(taskI);
        } catch (InterruptedException | ExecutionException unused) {
            return new ArrayList();
        }
    }

    public final /* synthetic */ void zzf(Exception exc) {
        zzi(com.google.ads.interactivemedia.v3.impl.data.zzbz.COLLECT_SIGNALS, exc);
    }

    public final /* synthetic */ void zzg(zzev zzevVar, Exception exc) {
        zzj(zzevVar);
        zzi(com.google.ads.interactivemedia.v3.impl.data.zzbz.COLLECT_SIGNALS, zzk(zzevVar, exc));
    }

    public final /* synthetic */ void zzh(zzev zzevVar, Exception exc) {
        zzj(zzevVar);
        zzi(com.google.ads.interactivemedia.v3.impl.data.zzbz.INIT, zzk(zzevVar, exc));
    }
}
