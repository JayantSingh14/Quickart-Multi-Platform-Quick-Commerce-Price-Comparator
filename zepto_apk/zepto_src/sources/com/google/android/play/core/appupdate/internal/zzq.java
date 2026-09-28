package com.google.android.play.core.appupdate.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzq extends zzn {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f41692b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzn f41693c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzx f41694d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(zzx zzxVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzn zznVar) {
        super(taskCompletionSource);
        this.f41694d = zzxVar;
        this.f41692b = taskCompletionSource2;
        this.f41693c = zznVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        synchronized (this.f41694d.f41705f) {
            try {
                final zzx zzxVar = this.f41694d;
                final TaskCompletionSource taskCompletionSource = this.f41692b;
                zzxVar.f41704e.add(taskCompletionSource);
                taskCompletionSource.f39750a.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.appupdate.internal.zzo
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        zzx zzxVar2 = zzxVar;
                        TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                        synchronized (zzxVar2.f41705f) {
                            zzxVar2.f41704e.remove(taskCompletionSource2);
                        }
                    }
                });
                if (this.f41694d.f41710k.getAndIncrement() > 0) {
                    this.f41694d.f41701b.c("Already connected to the service.", new Object[0]);
                }
                zzx.b(this.f41694d, this.f41693c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
