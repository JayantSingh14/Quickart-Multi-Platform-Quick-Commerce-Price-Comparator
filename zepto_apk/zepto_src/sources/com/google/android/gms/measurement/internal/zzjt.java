package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzjt extends zzay {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzli f39220e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjt(zzli zzliVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zzliVar);
        this.f39220e = zzliVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        final zzli zzliVar = this.f39220e.f39180a.f39096m;
        zzib.k(zzliVar);
        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzliVar.J();
            }
        }).start();
    }
}
