package com.zeptoconsumerapp.modules.event.domain;

import com.google.gson.reflect.TypeToken;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.event.model.repository.BaseRepository;
import com.zeptoconsumerapp.modules.event.model.repository.EventRepository;
import com.zeptoconsumerapp.modules.event.model.repository.MixpanelRepository;
import com.zeptoconsumerapp.modules.helper.StorageHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class LogEventUseCase {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f47644a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.Map] */
        public static void a(String eventName, Map properties) {
            Map mapC;
            Object objC;
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(properties, "properties");
            try {
                StorageHelper.f47656a.a();
                try {
                    objC = Utils.c().e(StorageHelper.a("experimentData"), new TypeToken<Map<String, ? extends Object>>() { // from class: com.zeptoconsumerapp.modules.event.domain.LogEventUseCase$Companion$getCommonProperties$$inlined$get$1
                    }.f45460b);
                } catch (Exception unused) {
                    objC = MapsKt.c();
                }
                Map map = (Map) objC;
                mapC = map != null ? MapsKt.g(new Pair("experimentData", map)) : MapsKt.c();
            } catch (Exception unused2) {
                mapC = MapsKt.c();
            }
            LinkedHashMap linkedHashMapJ = MapsKt.j(mapC, properties);
            BaseRepository baseRepository = (BaseRepository) LogEventUseCase.f47644a.get(EventRepository.class);
            if (baseRepository != null) {
                baseRepository.a(eventName, linkedHashMapJ);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
        public static void b(String eventName, Map properties) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(properties, "properties");
            BaseRepository baseRepository = (BaseRepository) LogEventUseCase.f47644a.get(MixpanelRepository.class);
            if (baseRepository != null) {
                baseRepository.a(eventName, properties);
            }
        }
    }

    static {
        EventRepository.Companion companion = EventRepository.f47645b;
        EventRepository eventRepository = EventRepository.f47646c;
        if (eventRepository == null) {
            synchronized (companion) {
                eventRepository = EventRepository.f47646c;
                if (eventRepository == null) {
                    eventRepository = new EventRepository();
                    EventRepository.f47646c = eventRepository;
                }
            }
        }
        Pair pair = new Pair(EventRepository.class, eventRepository);
        MixpanelRepository.Companion companion2 = MixpanelRepository.f47648b;
        MixpanelRepository mixpanelRepository = MixpanelRepository.f47649c;
        if (mixpanelRepository == null) {
            synchronized (companion2) {
                mixpanelRepository = MixpanelRepository.f47649c;
                if (mixpanelRepository == null) {
                    mixpanelRepository = new MixpanelRepository();
                    MixpanelRepository.f47649c = mixpanelRepository;
                }
            }
        }
        f47644a = MapsKt.h(pair, new Pair(MixpanelRepository.class, mixpanelRepository));
    }
}
