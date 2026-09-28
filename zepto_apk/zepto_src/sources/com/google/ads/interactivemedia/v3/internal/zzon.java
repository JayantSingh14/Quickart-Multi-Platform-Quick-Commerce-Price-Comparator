package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public final class zzon {
    public static zzta zza(Task task, CancellationTokenSource cancellationTokenSource) {
        final zzom zzomVar = new zzom(task, null);
        task.b(zztg.zzb(), new OnCompleteListener() { // from class: com.google.ads.interactivemedia.v3.internal.zzol
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                zzom zzomVar2 = zzomVar;
                if (task2.n()) {
                    zzomVar2.cancel(false);
                    return;
                }
                if (task2.p()) {
                    zzomVar2.zzc(task2.l());
                    return;
                }
                Exception excK = task2.k();
                if (excK == null) {
                    throw new IllegalStateException();
                }
                zzomVar2.zzd(excK);
            }
        });
        return zzomVar;
    }
}
