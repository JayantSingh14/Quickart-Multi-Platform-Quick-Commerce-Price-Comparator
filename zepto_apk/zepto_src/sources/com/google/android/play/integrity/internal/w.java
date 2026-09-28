package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class w extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f42199b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f42200c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ae f42201d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(ae aeVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, t tVar) {
        super(taskCompletionSource);
        this.f42199b = taskCompletionSource2;
        this.f42200c = tVar;
        this.f42201d = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        synchronized (this.f42201d.f42161f) {
            try {
                final ae aeVar = this.f42201d;
                final TaskCompletionSource taskCompletionSource = this.f42199b;
                aeVar.f42160e.add(taskCompletionSource);
                taskCompletionSource.f39750a.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.integrity.internal.v
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        ae aeVar2 = aeVar;
                        TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                        synchronized (aeVar2.f42161f) {
                            aeVar2.f42160e.remove(taskCompletionSource2);
                        }
                    }
                });
                if (this.f42201d.f42167l.getAndIncrement() > 0) {
                    this.f42201d.f42157b.b("Already connected to the service.", new Object[0]);
                }
                ae.b(this.f42201d, this.f42200c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
