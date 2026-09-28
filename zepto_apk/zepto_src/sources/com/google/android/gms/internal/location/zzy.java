package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzy implements RemoteCall {
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzf zzfVar = (zzf) obj;
        int i2 = zzag.f36626a;
        zzfVar.getClass();
        Preconditions.checkNotNull(null);
        ((zzo) zzfVar.getService()).zzm();
        ((TaskCompletionSource) obj2).b(null);
    }
}
