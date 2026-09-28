package com.google.firebase.events;

import com.google.firebase.messaging.n;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface Subscriber {
    void a(n nVar);

    void b(n nVar);

    void d(Executor executor, EventHandler eventHandler);
}
