package com.google.firebase.messaging.reporting;

/* loaded from: classes4.dex */
public final class MessagingClientEventExtension {

    /* renamed from: a, reason: collision with root package name */
    public final MessagingClientEvent f44887a;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public MessagingClientEvent f44888a = null;

        public final MessagingClientEventExtension a() {
            return new MessagingClientEventExtension(this.f44888a);
        }

        public final void b(MessagingClientEvent messagingClientEvent) {
            this.f44888a = messagingClientEvent;
        }
    }

    static {
        new Builder().a();
    }

    public MessagingClientEventExtension(MessagingClientEvent messagingClientEvent) {
        this.f44887a = messagingClientEvent;
    }

    public static Builder a() {
        return new Builder();
    }
}
