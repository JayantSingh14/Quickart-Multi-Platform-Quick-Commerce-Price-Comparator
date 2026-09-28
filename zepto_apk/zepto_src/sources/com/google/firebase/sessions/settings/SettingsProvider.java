package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.time.Duration;

@Metadata
/* loaded from: classes.dex */
public interface SettingsProvider {

    @Metadata
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static Unit a() {
            return Unit.f53572a;
        }
    }

    Boolean a();

    Duration b();

    Double c();

    Object d(Continuation continuation);
}
