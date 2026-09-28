package com.facebook.react.jstasks;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class LinearCountingRetryPolicy implements HeadlessJsTaskRetryPolicy {
    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final boolean a() {
        return false;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final int b() {
        throw null;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final HeadlessJsTaskRetryPolicy c() {
        return NoRetryPolicy.f19016a;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public final HeadlessJsTaskRetryPolicy copy() {
        throw null;
    }
}
