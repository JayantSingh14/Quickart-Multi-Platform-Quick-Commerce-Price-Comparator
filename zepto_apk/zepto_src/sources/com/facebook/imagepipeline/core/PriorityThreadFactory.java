package com.facebook.imagepipeline.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PriorityThreadFactory implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f17888a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f17889b;

    public PriorityThreadFactory(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.f17888a = prefix;
        this.f17889b = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return new Thread(new androidx.constraintlayout.motion.widget.a(18, this, runnable), this.f17888a + "-" + this.f17889b.getAndIncrement());
    }
}
