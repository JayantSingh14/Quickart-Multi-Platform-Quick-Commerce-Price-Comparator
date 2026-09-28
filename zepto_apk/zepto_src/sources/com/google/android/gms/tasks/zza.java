package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class zza implements OnSuccessListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnTokenCanceledListener f39753a;

    public zza(OnTokenCanceledListener onTokenCanceledListener) {
        this.f39753a = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        this.f39753a.a();
    }
}
