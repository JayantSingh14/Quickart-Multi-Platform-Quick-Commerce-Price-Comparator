package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.LogLevel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EventTypesChannel {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultLogger f48049a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f48050b;

    public EventTypesChannel(DefaultLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f48049a = logger;
        this.f48050b = new LinkedHashMap();
        Iterator it = ((AbstractList) EventType.f48079d).iterator();
        while (it.hasNext()) {
            this.f48050b.put((EventType) it.next(), ChannelKt.a(-1, null, 6));
        }
    }

    public final Object a(final EventType eventType, Continuation continuation) {
        Channel channel = (Channel) this.f48050b.get(eventType);
        this.f48049a.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventTypesChannel$send$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "EventTypesChannel:: Send, type = " + eventType;
            }
        });
        if (channel == null) {
            return Unit.f53572a;
        }
        Object objO = channel.o(eventType, continuation);
        return objO == CoroutineSingletons.f53689a ? objO : Unit.f53572a;
    }
}
