package com.facebook.react.jstasks;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class NoRetryPolicy implements HeadlessJsTaskRetryPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final NoRetryPolicy f19016a = new NoRetryPolicy();

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final boolean a() {
        return false;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final int b() {
        throw new IllegalStateException("Should not retrieve delay as canRetry is: false");
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final HeadlessJsTaskRetryPolicy c() {
        throw new IllegalStateException("Should not update as canRetry is: false");
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final HeadlessJsTaskRetryPolicy copy() {
        return this;
    }
}
