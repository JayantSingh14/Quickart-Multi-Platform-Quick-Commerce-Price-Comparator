package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44824a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f44825b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f44826c;

    public /* synthetic */ f(int i2, Object obj, Object obj2) {
        this.f44824a = i2;
        this.f44825b = obj;
        this.f44826c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f44825b;
        Object obj2 = this.f44826c;
        switch (this.f44824a) {
            case 0:
                ((FcmLifecycleCallbacks) obj).a((Intent) obj2);
                break;
            default:
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                Store store = FirebaseMessaging.f44699m;
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) obj;
                firebaseMessaging.getClass();
                try {
                    taskCompletionSource.b(firebaseMessaging.a());
                    break;
                } catch (Exception e2) {
                    taskCompletionSource.a(e2);
                }
        }
    }
}
