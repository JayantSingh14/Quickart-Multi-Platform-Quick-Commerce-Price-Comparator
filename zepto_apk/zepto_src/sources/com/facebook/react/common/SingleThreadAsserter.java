package com.facebook.react.common;

import com.facebook.infer.annotation.Assertions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SingleThreadAsserter {

    /* renamed from: a, reason: collision with root package name */
    public Thread f18708a;

    public final void a() {
        Thread threadCurrentThread = Thread.currentThread();
        if (this.f18708a == null) {
            this.f18708a = threadCurrentThread;
        }
        Assertions.a(Intrinsics.b(this.f18708a, threadCurrentThread));
    }
}
