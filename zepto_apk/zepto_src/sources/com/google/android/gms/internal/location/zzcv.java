package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes4.dex */
final class zzcv implements ListenerHolder.Notifier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcw f36655a;

    public zzcv(zzcw zzcwVar) {
        this.f36655a = zzcwVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        this.f36655a.f36656b.zzb();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
