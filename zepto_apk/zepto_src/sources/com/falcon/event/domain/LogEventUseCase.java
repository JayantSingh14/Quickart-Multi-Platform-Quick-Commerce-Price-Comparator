package com.falcon.event.domain;

import com.falcon.event.model.repository.EventRepository;
import com.falcon.event.model.repository.MixpanelRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class LogEventUseCase {

    /* renamed from: a, reason: collision with root package name */
    public static Object f20438a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
        public static Map a() {
            if (LogEventUseCase.f20438a == null) {
                EventRepository.Companion companion = EventRepository.f20439b;
                EventRepository eventRepository = EventRepository.f20440c;
                if (eventRepository == null) {
                    synchronized (companion) {
                        eventRepository = EventRepository.f20440c;
                        if (eventRepository == null) {
                            eventRepository = new EventRepository();
                            EventRepository.f20440c = eventRepository;
                        }
                    }
                }
                Pair pair = new Pair(EventRepository.class, eventRepository);
                MixpanelRepository.Companion companion2 = MixpanelRepository.f20442b;
                MixpanelRepository mixpanelRepository = MixpanelRepository.f20443c;
                if (mixpanelRepository == null) {
                    synchronized (companion2) {
                        mixpanelRepository = MixpanelRepository.f20443c;
                        if (mixpanelRepository == null) {
                            mixpanelRepository = new MixpanelRepository();
                            MixpanelRepository.f20443c = mixpanelRepository;
                        }
                    }
                }
                LogEventUseCase.f20438a = MapsKt.h(pair, new Pair(MixpanelRepository.class, mixpanelRepository));
            }
            ?? r0 = LogEventUseCase.f20438a;
            Intrinsics.c(r0);
            return r0;
        }
    }
}
