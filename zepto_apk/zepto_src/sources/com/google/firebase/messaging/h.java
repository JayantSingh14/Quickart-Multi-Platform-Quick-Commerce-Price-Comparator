package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public final /* synthetic */ class h implements SuccessContinuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44827a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f44828b;

    public /* synthetic */ h(String str, int i2) {
        this.f44827a = i2;
        this.f44828b = str;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        String str = this.f44828b;
        TopicsSubscriber topicsSubscriber = (TopicsSubscriber) obj;
        switch (this.f44827a) {
            case 0:
                Store store = FirebaseMessaging.f44699m;
                topicsSubscriber.getClass();
                Task taskD = topicsSubscriber.d(new TopicOperation("U", str));
                topicsSubscriber.f();
                return taskD;
            default:
                Store store2 = FirebaseMessaging.f44699m;
                topicsSubscriber.getClass();
                Task taskD2 = topicsSubscriber.d(new TopicOperation("S", str));
                topicsSubscriber.f();
                return taskD2;
        }
    }
}
