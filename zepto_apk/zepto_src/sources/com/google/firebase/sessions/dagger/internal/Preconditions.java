package com.google.firebase.sessions.dagger.internal;

/* loaded from: classes.dex */
public final class Preconditions {
    public static void a(Class cls, Object obj) {
        if (obj != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }
}
