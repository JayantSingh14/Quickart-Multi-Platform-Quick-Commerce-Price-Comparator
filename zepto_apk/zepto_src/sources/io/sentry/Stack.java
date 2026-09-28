package io.sentry;

import io.sentry.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes.dex */
final class Stack {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingDeque f51937a;

    /* renamed from: b, reason: collision with root package name */
    public final ILogger f51938b;

    public Stack(ILogger iLogger, StackItem stackItem) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        this.f51937a = linkedBlockingDeque;
        Objects.b(iLogger, "logger is required");
        this.f51938b = iLogger;
        linkedBlockingDeque.push(stackItem);
    }

    public final StackItem a() {
        return (StackItem) this.f51937a.peek();
    }

    public static final class StackItem {

        /* renamed from: a, reason: collision with root package name */
        public final SentryOptions f51939a;

        /* renamed from: b, reason: collision with root package name */
        public volatile SentryClient f51940b;

        /* renamed from: c, reason: collision with root package name */
        public volatile IScope f51941c;

        public StackItem(SentryOptions sentryOptions, SentryClient sentryClient, Scope scope) {
            this.f51940b = sentryClient;
            this.f51941c = scope;
            this.f51939a = sentryOptions;
        }

        public StackItem(StackItem stackItem) {
            this.f51939a = stackItem.f51939a;
            this.f51940b = stackItem.f51940b;
            this.f51941c = stackItem.f51941c.clone();
        }
    }
}
