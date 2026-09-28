package com.google.android.play.core.splitinstall.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzy extends zzv {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f42003b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzv f42004c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzaf f42005d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(zzaf zzafVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzv zzvVar) {
        super(taskCompletionSource);
        this.f42005d = zzafVar;
        this.f42003b = taskCompletionSource2;
        this.f42004c = zzvVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzv
    public final void a() {
        synchronized (this.f42005d.f41945f) {
            try {
                final zzaf zzafVar = this.f42005d;
                final TaskCompletionSource taskCompletionSource = this.f42003b;
                zzafVar.f41944e.add(taskCompletionSource);
                taskCompletionSource.f39750a.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.splitinstall.internal.zzw
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        zzaf zzafVar2 = zzafVar;
                        TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                        synchronized (zzafVar2.f41945f) {
                            zzafVar2.f41944e.remove(taskCompletionSource2);
                        }
                    }
                });
                if (this.f42005d.f41950k.getAndIncrement() > 0) {
                    this.f42005d.f41941b.d("Already connected to the service.", new Object[0]);
                }
                zzaf.b(this.f42005d, this.f42004c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
