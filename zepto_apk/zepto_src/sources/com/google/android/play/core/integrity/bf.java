package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class bf extends bm {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f41802c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f41803d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ bn f41804e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bn bnVar, TaskCompletionSource taskCompletionSource, long j2, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f41802c = j2;
        this.f41803d = taskCompletionSource2;
        this.f41804e = bnVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        TaskCompletionSource taskCompletionSource = this.f41803d;
        long j2 = this.f41802c;
        bn bnVar = this.f41804e;
        if (bn.d(bnVar)) {
            a(new StandardIntegrityException(-2, null));
            return;
        }
        if (bn.c(bnVar)) {
            a(new StandardIntegrityException(-14, null));
            return;
        }
        try {
            ((com.google.android.play.integrity.internal.i) bnVar.f41821e.n).w9(bn.b(bnVar, j2), new bl(bnVar, taskCompletionSource));
        } catch (RemoteException e2) {
            bnVar.f41817a.a(e2, "warmUpIntegrityToken(%s)", Long.valueOf(j2));
            taskCompletionSource.c(new StandardIntegrityException(-100, e2));
        }
    }
}
