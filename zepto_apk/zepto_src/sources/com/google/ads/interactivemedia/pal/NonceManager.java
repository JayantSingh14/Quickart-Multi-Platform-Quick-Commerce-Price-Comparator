package com.google.ads.interactivemedia.pal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.pal.zzagc;
import com.google.android.gms.internal.pal.zzagg;
import com.google.android.gms.internal.pal.zzfm;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class NonceManager {

    @VisibleForTesting
    static final zzagc zza = new zzagc(zzagg.a(1000, 3));

    @VisibleForTesting
    static final zzagc zzb = new zzagc(zzagg.a(1000, 5));
    public static final /* synthetic */ int zzc = 0;
    private final Context zzd;
    private final ExecutorService zze;
    private final Task zzf;
    private final zzax zzg;
    private final zzav zzh;
    private final String zzi;
    private boolean zzj = false;

    @Nullable
    private String zzk;

    public NonceManager(@NonNull Context context, @NonNull Handler handler, @NonNull ExecutorService executorService, @NonNull Task task, @NonNull zzax zzaxVar, @NonNull String str) {
        this.zzd = context;
        this.zze = executorService;
        this.zzf = task;
        this.zzg = zzaxVar;
        this.zzh = new zzav(handler, zzb);
        this.zzi = str;
    }

    public static /* bridge */ /* synthetic */ Activity zza(NonceManager nonceManager) {
        Context context = nonceManager.zzd;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @NonNull
    public String getNonce() {
        return this.zzi;
    }

    public void sendAdClick() {
        Task taskH = this.zzf.h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzan
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzc(task);
            }
        });
        long j2 = zza.f37520a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Tasks.i(taskH, j2).h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzao
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzd(task);
                return null;
            }
        });
    }

    @Deprecated
    public void sendAdImpression() {
    }

    public void sendAdTouch(@NonNull final MotionEvent motionEvent) {
        Task taskH = this.zzf.h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzal
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                MotionEvent motionEvent2 = motionEvent;
                int i2 = NonceManager.zzc;
                ((zzfm) task.l()).f37740a.zzl(new ObjectWrapper(motionEvent2));
                return null;
            }
        });
        long j2 = zza.f37520a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Tasks.i(taskH, j2).h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzam
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zze(task);
                return null;
            }
        });
    }

    public void sendPlaybackEnd() {
        this.zzh.zzd();
        if (this.zzj) {
            this.zzj = false;
            this.zzg.zza(8, this.zzk);
        }
    }

    public void sendPlaybackStart() {
        if (this.zzj) {
            return;
        }
        this.zzj = true;
        Task taskH = this.zzf.h(this.zze, new zzas(this));
        long j2 = zza.f37520a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Task taskI = Tasks.i(taskH, j2);
        taskI.h(this.zze, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzap
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzf(task);
                return null;
            }
        });
        taskI.g(new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzaq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzg(task);
                return null;
            }
        });
    }

    public final String zzc(Task task) throws Exception {
        return ((zzfm) task.l()).f37740a.zze(new ObjectWrapper(this.zzd), "");
    }

    public final /* synthetic */ Void zzd(Task task) throws Exception {
        this.zzg.zza(4, task.p() ? (String) task.l() : null);
        return null;
    }

    public final /* synthetic */ Void zze(Task task) throws Exception {
        this.zzg.zza(5, null);
        return null;
    }

    public final /* synthetic */ Void zzf(Task task) throws Exception {
        String str = task.p() ? (String) task.l() : null;
        this.zzk = str;
        this.zzg.zza(6, str);
        return null;
    }

    public final /* synthetic */ Void zzg(Task task) throws Exception {
        if (!this.zzj) {
            return null;
        }
        this.zzh.zzc(new zzar(this));
        return null;
    }
}
