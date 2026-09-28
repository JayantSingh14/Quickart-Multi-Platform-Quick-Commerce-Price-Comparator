package com.facebook.react.runtime;

import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19341a;

    public /* synthetic */ j(int i2) {
        this.f19341a = i2;
    }

    @Override // com.facebook.react.runtime.internal.bolts.Continuation
    public final Object a(Task task) {
        switch (this.f19341a) {
            case 0:
                AtomicInteger atomicInteger = ReactHostImpl.A;
                return ((ReactHostImpl.CreationResult) task.g()).f19257a;
            default:
                return (Task) task.g();
        }
    }
}
