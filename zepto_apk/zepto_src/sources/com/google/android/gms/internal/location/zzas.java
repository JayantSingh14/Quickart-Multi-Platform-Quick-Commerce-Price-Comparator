package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes4.dex */
final class zzas implements zzcs {

    /* renamed from: a, reason: collision with root package name */
    public ListenerHolder f36628a = null;

    @Override // com.google.android.gms.internal.location.zzcs
    public final synchronized void a(ListenerHolder listenerHolder) {
        ListenerHolder listenerHolder2 = this.f36628a;
        if (listenerHolder2 != listenerHolder) {
            listenerHolder2.clear();
            this.f36628a = listenerHolder;
        }
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final synchronized ListenerHolder zza() {
        return this.f36628a;
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final void zzb() {
    }
}
