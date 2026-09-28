package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

/* loaded from: classes.dex */
public class HeartBeatConsumerComponent {

    /* renamed from: com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent$1, reason: invalid class name */
    class AnonymousClass1 implements HeartBeatConsumer {
    }

    public static Component a() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        Component.Builder builderB = Component.b(HeartBeatConsumer.class);
        builderB.f43567e = 1;
        builderB.f43568f = new androidx.work.impl.c(anonymousClass1, 1);
        return builderB.b();
    }
}
