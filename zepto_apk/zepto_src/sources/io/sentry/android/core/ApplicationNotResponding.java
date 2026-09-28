package io.sentry.android.core;

import io.sentry.util.Objects;

/* loaded from: classes3.dex */
final class ApplicationNotResponding extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final Thread f52101a;

    public ApplicationNotResponding(String str, Thread thread) {
        super(str);
        Objects.b(thread, "Thread must be provided.");
        this.f52101a = thread;
        setStackTrace(thread.getStackTrace());
    }
}
