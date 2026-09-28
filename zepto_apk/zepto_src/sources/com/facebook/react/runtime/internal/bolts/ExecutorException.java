package com.facebook.react.runtime.internal.bolts;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ExecutorException extends RuntimeException {
    public ExecutorException(Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
