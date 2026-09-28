package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* loaded from: classes4.dex */
final class bg extends bm {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StandardIntegrityManager.StandardIntegrityTokenRequest f41805c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f41806d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f41807e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f41808f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ bn f41809g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bn bnVar, TaskCompletionSource taskCompletionSource, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest, long j2, long j3, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f41805c = standardIntegrityTokenRequest;
        this.f41806d = j2;
        this.f41807e = j3;
        this.f41808f = taskCompletionSource2;
        this.f41809g = bnVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        TaskCompletionSource taskCompletionSource = this.f41808f;
        bn bnVar = this.f41809g;
        if (bn.d(bnVar)) {
            a(new StandardIntegrityException(-2, null));
            return;
        }
        if (bn.c(bnVar)) {
            a(new StandardIntegrityException(-14, null));
            return;
        }
        try {
            ((com.google.android.play.integrity.internal.i) bnVar.f41821e.n).ka(bn.a(bnVar, this.f41805c, this.f41806d, this.f41807e), new bk(bnVar, taskCompletionSource));
        } catch (RemoteException e2) {
            StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest = this.f41805c;
            bnVar.f41817a.a(e2, "requestExpressIntegrityToken(%s, %s, %s)", standardIntegrityTokenRequest.b(), standardIntegrityTokenRequest.c(), Long.valueOf(this.f41806d));
            taskCompletionSource.c(new StandardIntegrityException(-100, e2));
        }
    }
}
