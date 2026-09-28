package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

/* loaded from: classes4.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44834a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f44835b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f44836c;

    public /* synthetic */ k(Object obj, TaskCompletionSource taskCompletionSource, int i2) {
        this.f44834a = i2;
        this.f44835b = obj;
        this.f44836c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f44834a) {
            case 0:
                TaskCompletionSource taskCompletionSource = this.f44836c;
                Store store = FirebaseMessaging.f44699m;
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f44835b;
                firebaseMessaging.getClass();
                try {
                    FirebaseInstanceIdInternal firebaseInstanceIdInternal = firebaseMessaging.f44701b;
                    Metadata.b(firebaseMessaging.f44700a);
                    firebaseInstanceIdInternal.b();
                    taskCompletionSource.b(null);
                    return;
                } catch (Exception e2) {
                    taskCompletionSource.a(e2);
                    return;
                }
            case 1:
                FirebaseMessaging firebaseMessaging2 = (FirebaseMessaging) this.f44835b;
                TaskCompletionSource taskCompletionSource2 = this.f44836c;
                Store store2 = FirebaseMessaging.f44699m;
                firebaseMessaging2.getClass();
                try {
                    GmsRpc gmsRpc = firebaseMessaging2.f44703d;
                    gmsRpc.getClass();
                    Bundle bundle = new Bundle();
                    bundle.putString("delete", "1");
                    Tasks.a(gmsRpc.a(gmsRpc.c(Metadata.b(gmsRpc.f44716a), "*", bundle)));
                    Store storeD = FirebaseMessaging.d(firebaseMessaging2.f44702c);
                    String strE = firebaseMessaging2.e();
                    String strB = Metadata.b(firebaseMessaging2.f44700a);
                    synchronized (storeD) {
                        String strA = Store.a(strE, strB);
                        SharedPreferences.Editor editorEdit = storeD.f44762a.edit();
                        editorEdit.remove(strA);
                        editorEdit.commit();
                    }
                    taskCompletionSource2.b(null);
                    return;
                } catch (Exception e3) {
                    taskCompletionSource2.a(e3);
                    return;
                }
            default:
                TaskCompletionSource taskCompletionSource3 = this.f44836c;
                try {
                    taskCompletionSource3.b(((ImageDownload) this.f44835b).a());
                    return;
                } catch (Exception e4) {
                    taskCompletionSource3.a(e4);
                    return;
                }
        }
    }
}
