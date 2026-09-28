package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzan extends zzat {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zzda zzdaVar = (zzda) anyClient;
        ListenerHolder.ListenerKey listenerKeyCreateListenerKey = ListenerHolders.createListenerKey(null, "LocationListener");
        TaskCompletionSource taskCompletionSourceA = zzau.a(this);
        synchronized (zzdaVar.f36667a) {
            try {
                zzcz zzczVar = (zzcz) zzdaVar.f36667a.remove(listenerKeyCreateListenerKey);
                if (zzczVar == null) {
                    taskCompletionSourceA.b(Boolean.FALSE);
                    return;
                }
                ((zzas) zzczVar.f36658b).zza().clear();
                if (zzdaVar.f(com.google.android.gms.location.zzm.f38389e)) {
                    ((zzo) zzdaVar.getService()).H8(new zzdb(1, null, zzczVar, null, null, null), new zzcl(Boolean.TRUE, taskCompletionSourceA));
                } else {
                    ((zzo) zzdaVar.getService()).Q7(new zzdf(2, null, zzczVar, null, null, new zzcn(Boolean.TRUE, taskCompletionSourceA), null));
                }
            } finally {
            }
        }
    }
}
