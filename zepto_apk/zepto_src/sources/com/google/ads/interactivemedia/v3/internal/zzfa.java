package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public final /* synthetic */ class zzfa implements Continuation {
    public final /* synthetic */ zzff zza;

    public /* synthetic */ zzfa(zzff zzffVar) {
        this.zza = zzffVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return zzff.zza(this.zza, task);
    }
}
