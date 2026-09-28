package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* loaded from: classes4.dex */
final class az implements StandardIntegrityManager {

    /* renamed from: a, reason: collision with root package name */
    public final bn f41795a;

    /* renamed from: b, reason: collision with root package name */
    public final bt f41796b;

    public az(bn bnVar, bt btVar) {
        this.f41795a = bnVar;
        this.f41796b = btVar;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager
    public final Task a(final StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        long jA = prepareIntegrityTokenRequest.a();
        Object[] objArr = {Long.valueOf(jA)};
        bn bnVar = this.f41795a;
        bnVar.f41817a.b("warmUpIntegrityToken(%s)", objArr);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        bnVar.f41821e.c(new bf(bnVar, taskCompletionSource, jA, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.f39750a.q(new SuccessContinuation() { // from class: com.google.android.play.core.integrity.ay
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                az azVar = this.f41793a;
                azVar.getClass();
                final long jA2 = prepareIntegrityTokenRequest.a();
                final long jLongValue = ((Long) obj).longValue();
                final bt btVar = azVar.f41796b;
                return Tasks.e(new StandardIntegrityManager.StandardIntegrityTokenProvider() { // from class: com.google.android.play.core.integrity.bs
                    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider
                    public final Task a(StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
                        long j2 = jLongValue;
                        Object[] objArr2 = {Long.valueOf(j2)};
                        bn bnVar2 = btVar.f41830a;
                        bnVar2.f41817a.b("requestExpressIntegrityToken(%s)", objArr2);
                        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                        bnVar2.f41821e.c(new bg(bnVar2, taskCompletionSource2, standardIntegrityTokenRequest, jA2, j2, taskCompletionSource2), taskCompletionSource2);
                        return taskCompletionSource2.f39750a;
                    }
                });
            }
        });
    }
}
