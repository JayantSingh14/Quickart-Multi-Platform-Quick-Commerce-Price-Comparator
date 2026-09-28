package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class af extends com.google.android.play.integrity.internal.t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte[] f41767b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f41768c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f41769d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ IntegrityTokenRequest f41770e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ aj f41771f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(aj ajVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l2, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f41767b = bArr;
        this.f41768c = l2;
        this.f41769d = taskCompletionSource2;
        this.f41770e = integrityTokenRequest;
        this.f41771f = ajVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void a(Exception exc) {
        if (exc instanceof com.google.android.play.integrity.internal.af) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        TaskCompletionSource taskCompletionSource = this.f41769d;
        aj ajVar = this.f41771f;
        try {
            ((com.google.android.play.integrity.internal.n) ajVar.f41779e.n).U1(aj.a(ajVar, this.f41767b, this.f41768c), new ai(ajVar, taskCompletionSource));
        } catch (RemoteException e2) {
            ajVar.f41775a.a(e2, "requestIntegrityToken(%s)", this.f41770e);
            taskCompletionSource.c(new IntegrityServiceException(-100, e2));
        }
    }
}
