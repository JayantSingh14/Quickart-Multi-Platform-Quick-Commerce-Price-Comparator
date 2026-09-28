package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.entity.HorizonConfig;
import com.zeptonow.horizon.storage.EventStorage;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.LogLevel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.internal.ContextScope;

@Metadata
/* loaded from: classes.dex */
public final class EventManager {

    /* renamed from: a, reason: collision with root package name */
    public final ContextScope f47980a;

    /* renamed from: b, reason: collision with root package name */
    public final EventStorage f47981b;

    /* renamed from: c, reason: collision with root package name */
    public final EventDispatcher f47982c;

    /* renamed from: d, reason: collision with root package name */
    public final HorizonConfig f47983d;

    /* renamed from: e, reason: collision with root package name */
    public final DefaultLogger f47984e;

    /* renamed from: f, reason: collision with root package name */
    public final DirectEventSender f47985f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f47986g;

    public EventManager(ContextScope scope, EventStorage eventStorage, EventDispatcher eventDispatcher, HorizonConfig config, DefaultLogger logger, DirectEventSender directEventSender) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(directEventSender, "directEventSender");
        this.f47980a = scope;
        this.f47981b = eventStorage;
        this.f47982c = eventDispatcher;
        this.f47983d = config;
        this.f47984e = logger;
        this.f47985f = directEventSender;
    }

    public final void a() {
        this.f47984e.a(LogLevel.f48264b, EventManager$flushEvents$1.f47987c);
        EventDispatcher eventDispatcher = this.f47982c;
        eventDispatcher.getClass();
        Iterator it = ((AbstractList) EventType.f48079d).iterator();
        while (it.hasNext()) {
            EventType eventType = (EventType) it.next();
            EventDispatcher$flushEvents$1$1 eventDispatcher$flushEvents$1$1 = new EventDispatcher$flushEvents$1$1(eventDispatcher, eventType, null);
            ContextScope contextScope = eventDispatcher.f47910d;
            BuildersKt.c(contextScope, null, eventDispatcher$flushEvents$1$1, 3);
            BuildersKt.c(contextScope, null, new EventDispatcher$flushEvents$1$2(eventDispatcher, eventType, null), 3);
        }
        DirectEventSender directEventSender = this.f47985f;
        directEventSender.getClass();
        BuildersKt.c(directEventSender.f47869c, null, new DirectEventSender$flush$1(directEventSender, null), 3);
    }

    public final void b() {
        this.f47984e.a(LogLevel.f48264b, EventManager$initialize$1.f47988c);
        EventDispatcher eventDispatcher = this.f47982c;
        eventDispatcher.getClass();
        EventDispatcher$observeBatchTrigger$1 eventDispatcher$observeBatchTrigger$1 = new EventDispatcher$observeBatchTrigger$1(eventDispatcher, null);
        ContextScope contextScope = eventDispatcher.f47910d;
        BuildersKt.c(contextScope, null, eventDispatcher$observeBatchTrigger$1, 3);
        BuildersKt.c(contextScope, null, new EventDispatcher$observeBatchTrigger$2(eventDispatcher, null), 3);
        Iterator it = ((AbstractList) EventType.f48079d).iterator();
        while (it.hasNext()) {
            BuildersKt.c(contextScope, null, new EventDispatcher$setupRetryProcessing$1$1(eventDispatcher, (EventType) it.next(), null), 3);
        }
        Iterator it2 = ((AbstractList) EventType.f48079d).iterator();
        while (it2.hasNext()) {
            BuildersKt.c(contextScope, null, new EventDispatcher$setupEventCountTrigger$1$1(eventDispatcher, (EventType) it2.next(), null), 3);
        }
        Iterator it3 = ((AbstractList) EventType.f48079d).iterator();
        while (it3.hasNext()) {
            BuildersKt.c(contextScope, null, new EventDispatcher$setupTimerTrigger$1$1(eventDispatcher, (EventType) it3.next(), null), 3);
        }
        BuildersKt.c(this.f47980a, null, new EventManager$initialize$2(this, null), 3);
    }

    public final void c() {
        this.f47984e.a(LogLevel.f48264b, EventManager$shutdown$1.f47992c);
        CoroutineScopeKt.b(this.f47980a, null);
    }

    public final void d(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.c(this.f47980a, null, new EventManager$track$1(event, this, null), 3);
    }
}
