package com.google.firebase.messaging;

import android.os.Bundle;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzaa;
import com.google.android.gms.cloudmessaging.zzv;
import com.google.android.gms.cloudmessaging.zzw;
import com.google.android.gms.cloudmessaging.zzy;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
class GmsRpc {

    /* renamed from: a, reason: collision with root package name */
    public final FirebaseApp f44716a;

    /* renamed from: b, reason: collision with root package name */
    public final Metadata f44717b;

    /* renamed from: c, reason: collision with root package name */
    public final Rpc f44718c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider f44719d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider f44720e;

    /* renamed from: f, reason: collision with root package name */
    public final FirebaseInstallationsApi f44721f;

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        firebaseApp.a();
        Rpc rpc = new Rpc(firebaseApp.f43489a);
        this.f44716a = firebaseApp;
        this.f44717b = metadata;
        this.f44718c = rpc;
        this.f44719d = provider;
        this.f44720e = provider2;
        this.f44721f = firebaseInstallationsApi;
    }

    public final Task a(Task task) {
        return task.h(new androidx.arch.core.executor.a(1), new m(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r2, java.lang.String r3, android.os.Bundle r4) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.GmsRpc.b(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    public final Task c(String str, String str2, final Bundle bundle) {
        try {
            b(str, str2, bundle);
            final Rpc rpc = this.f44718c;
            zzw zzwVar = rpc.f22240c;
            int iA = zzwVar.a();
            zzy zzyVar = zzy.f22292a;
            return iA < 12000000 ? zzwVar.b() != 0 ? rpc.a(bundle).j(zzyVar, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzz
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Bundle bundle2;
                    Rpc rpc2 = rpc;
                    rpc2.getClass();
                    return (task.p() && (bundle2 = (Bundle) task.l()) != null && bundle2.containsKey("google.messenger")) ? rpc2.a(bundle).r(zzy.f22292a, zzx.f22291a) : task;
                }
            }) : Tasks.d(new IOException("MISSING_INSTANCEID_SERVICE")) : zzv.a(rpc.f22239b).c(1, bundle).h(zzyVar, zzaa.f22245a);
        } catch (InterruptedException | ExecutionException e2) {
            return Tasks.d(e2);
        }
    }
}
