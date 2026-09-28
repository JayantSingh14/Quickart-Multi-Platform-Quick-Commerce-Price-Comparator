package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfzr {
    public static ListenableFuture a(Task task) {
        final zzfzp zzfzpVar = new zzfzp();
        zzfzpVar.f32107h = task;
        task.b(zzgyb.f33369a, new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfzq
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task2) {
                boolean zN = task2.n();
                zzfzp zzfzpVar2 = zzfzpVar;
                if (zN) {
                    zzfzpVar2.cancel(false);
                    return;
                }
                if (task2.p()) {
                    zzfzpVar2.c(task2.l());
                    return;
                }
                Exception excK = task2.k();
                if (excK == null) {
                    throw new IllegalStateException();
                }
                zzfzpVar2.d(excK);
            }
        });
        return zzfzpVar;
    }
}
