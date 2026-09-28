package com.facebook.react.runtime;

import com.facebook.react.runtime.internal.bolts.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19282a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f19283b;

    public /* synthetic */ a(ReactHostImpl reactHostImpl, int i2) {
        this.f19282a = i2;
        this.f19283b = reactHostImpl;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Task taskK;
        ReactHostImpl reactHostImpl = this.f19283b;
        switch (this.f19282a) {
            case 0:
                Task task = reactHostImpl.z;
                ExecutorService executorService = reactHostImpl.f19243e;
                if (task != null) {
                    reactHostImpl.r("reload()", "Waiting for destroy to finish, before reloading React Native.");
                    taskK = reactHostImpl.z.c(new i(reactHostImpl, 3), executorService).k();
                } else {
                    taskK = reactHostImpl.o().k();
                }
                return taskK.c(new i(reactHostImpl, 4), executorService);
            case 1:
                AtomicInteger atomicInteger = ReactHostImpl.A;
                return reactHostImpl.w(0);
            case 2:
                return reactHostImpl.f19240b.f18751b;
            default:
                if (reactHostImpl.x == null) {
                    reactHostImpl.r("getOrCreateStartTask()", "Schedule");
                    reactHostImpl.x = reactHostImpl.w(0).c(new i(reactHostImpl, 5), reactHostImpl.f19243e);
                }
                return reactHostImpl.x;
        }
    }
}
