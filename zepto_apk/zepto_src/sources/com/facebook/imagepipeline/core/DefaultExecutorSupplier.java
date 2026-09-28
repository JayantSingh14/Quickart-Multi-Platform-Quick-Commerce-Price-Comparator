package com.facebook.imagepipeline.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class DefaultExecutorSupplier implements ExecutorSupplier {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f17795a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f17796b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f17797c;

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f17798d;

    /* renamed from: e, reason: collision with root package name */
    public final ScheduledExecutorService f17799e;

    @Metadata
    public static final class Companion {
    }

    public DefaultExecutorSupplier(int i2) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2, new PriorityThreadFactory("FrescoIoBoundExecutor"));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        this.f17795a = executorServiceNewFixedThreadPool;
        ExecutorService executorServiceNewFixedThreadPool2 = Executors.newFixedThreadPool(i2, new PriorityThreadFactory("FrescoDecodeExecutor"));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool2, "newFixedThreadPool(...)");
        this.f17796b = executorServiceNewFixedThreadPool2;
        ExecutorService executorServiceNewFixedThreadPool3 = Executors.newFixedThreadPool(i2, new PriorityThreadFactory("FrescoBackgroundExecutor"));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool3, "newFixedThreadPool(...)");
        this.f17797c = executorServiceNewFixedThreadPool3;
        ExecutorService executorServiceNewFixedThreadPool4 = Executors.newFixedThreadPool(1, new PriorityThreadFactory("FrescoLightWeightBackgroundExecutor"));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool4, "newFixedThreadPool(...)");
        this.f17798d = executorServiceNewFixedThreadPool4;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(i2, new PriorityThreadFactory("FrescoBackgroundExecutor"));
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
        this.f17799e = scheduledExecutorServiceNewScheduledThreadPool;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public final ExecutorService a() {
        return this.f17798d;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public final ExecutorService b() {
        return this.f17795a;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public final ExecutorService c() {
        return this.f17796b;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public final ExecutorService d() {
        return this.f17797c;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public final ExecutorService e() {
        return this.f17795a;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public final ExecutorService f() {
        return this.f17795a;
    }
}
