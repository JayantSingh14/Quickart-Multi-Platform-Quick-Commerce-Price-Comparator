package com.google.android.play.core.integrity;

import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes4.dex */
final class aa implements IntegrityManager {

    /* renamed from: a, reason: collision with root package name */
    public final aj f41764a;

    public aa(aj ajVar) {
        this.f41764a = ajVar;
    }

    @Override // com.google.android.play.core.integrity.IntegrityManager
    public final Task requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        aj ajVar = this.f41764a;
        com.google.android.play.integrity.internal.ae aeVar = ajVar.f41779e;
        if (aeVar == null) {
            return Tasks.d(new IntegrityServiceException(-2, null));
        }
        if (com.google.android.play.integrity.internal.ai.a(ajVar.f41777c) < 82380000) {
            return Tasks.d(new IntegrityServiceException(-14, null));
        }
        try {
            byte[] bArrDecode = Base64.decode(integrityTokenRequest.b(), 10);
            Long lA = integrityTokenRequest.a();
            if (integrityTokenRequest instanceof ao) {
            }
            ajVar.f41775a.b("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            aeVar.c(new af(ajVar, taskCompletionSource, bArrDecode, lA, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.f39750a;
        } catch (IllegalArgumentException e2) {
            return Tasks.d(new IntegrityServiceException(-13, e2));
        }
    }
}
