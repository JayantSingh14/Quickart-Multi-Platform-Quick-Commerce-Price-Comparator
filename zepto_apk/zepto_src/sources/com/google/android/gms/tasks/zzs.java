package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class zzs implements OnTokenCanceledListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f39802a;

    public zzs(TaskCompletionSource taskCompletionSource) {
        this.f39802a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void a() {
        this.f39802a.f39750a.u();
    }
}
