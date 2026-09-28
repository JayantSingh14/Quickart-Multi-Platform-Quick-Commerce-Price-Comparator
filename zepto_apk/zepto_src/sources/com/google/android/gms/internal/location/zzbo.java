package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzbo implements RemoteCall, zzcs {

    /* renamed from: a, reason: collision with root package name */
    public ListenerHolder f36634a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36635b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbp f36636c;

    public zzbo(zzbp zzbpVar, ListenerHolder listenerHolder) {
        this.f36636c = zzbpVar;
        this.f36634a = listenerHolder;
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final synchronized void a(ListenerHolder listenerHolder) {
        ListenerHolder listenerHolder2 = this.f36634a;
        if (listenerHolder2 != listenerHolder) {
            listenerHolder2.clear();
            this.f36634a = listenerHolder;
        }
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        ListenerHolder.ListenerKey listenerKey;
        boolean z;
        zzda zzdaVar = (zzda) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        synchronized (this) {
            listenerKey = this.f36634a.getListenerKey();
            z = this.f36635b;
            this.f36634a.clear();
        }
        if (listenerKey == null) {
            taskCompletionSource.b(Boolean.FALSE);
        } else {
            zzdaVar.d(listenerKey, z, taskCompletionSource);
        }
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final synchronized ListenerHolder zza() {
        return this.f36634a;
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final void zzb() {
        ListenerHolder.ListenerKey<?> listenerKey;
        synchronized (this) {
            this.f36635b = false;
            listenerKey = this.f36634a.getListenerKey();
        }
        if (listenerKey != null) {
            this.f36636c.doUnregisterEventListener(listenerKey, 2441);
        }
    }
}
