package io.sentry;

/* loaded from: classes3.dex */
public final class SamplingContext {

    /* renamed from: a, reason: collision with root package name */
    public final TransactionContext f51758a;

    public SamplingContext(TransactionContext transactionContext) {
        this.f51758a = transactionContext;
    }

    public final TransactionContext a() {
        return this.f51758a;
    }
}
