package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes4.dex */
final class zzcy implements ListenerHolder.Notifier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcz f36657a;

    public zzcy(zzcz zzczVar) {
        this.f36657a = zzczVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        this.f36657a.f36658b.zzb();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
