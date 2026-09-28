package com.google.firebase.sessions;

import androidx.media3.exoplayer.analytics.l;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata
/* loaded from: classes4.dex */
public final class EventGDTLogger implements EventGDTLoggerInterface {

    /* renamed from: a, reason: collision with root package name */
    public final Provider f44987a;

    @Metadata
    public static final class Companion {
    }

    public EventGDTLogger(Provider transportFactoryProvider) {
        Intrinsics.checkNotNullParameter(transportFactoryProvider, "transportFactoryProvider");
        this.f44987a = transportFactoryProvider;
    }

    @Override // com.google.firebase.sessions.EventGDTLoggerInterface
    public final void a(SessionEvent sessionEvent) {
        Intrinsics.checkNotNullParameter(sessionEvent, "sessionEvent");
        ((TransportFactory) this.f44987a.get()).a("FIREBASE_APPQUALITY_SESSION", new Encoding("json"), new l(this, 17)).b(Event.g(sessionEvent));
    }
}
