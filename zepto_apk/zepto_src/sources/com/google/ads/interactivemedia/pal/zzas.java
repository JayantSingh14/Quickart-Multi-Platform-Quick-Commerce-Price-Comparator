package com.google.ads.interactivemedia.pal;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.pal.zzfm;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
final class zzas implements Continuation {
    final /* synthetic */ NonceManager zza;

    public zzas(NonceManager nonceManager) {
        this.zza = nonceManager;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(@NonNull Task task) throws Exception {
        Activity activityZza = NonceManager.zza(this.zza);
        return ((zzfm) task.l()).f37740a.zzk(new ObjectWrapper(this.zza.zzd), new ObjectWrapper(null), new ObjectWrapper(activityZza));
    }
}
