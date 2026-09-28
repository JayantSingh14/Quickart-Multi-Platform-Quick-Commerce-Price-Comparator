package com.falcon.event.model.repository;

import coil3.decode.b;
import com.falcon.event.model.api.EventApi;
import com.falcon.event.model.api.EventRequestType;
import com.falcon.event.model.entity.Event;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class EventRepository implements BaseRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f20439b = new Companion();

    /* renamed from: c, reason: collision with root package name */
    public static volatile EventRepository f20440c;

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f20441a = LazyKt.b(new b(10));

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    @Override // com.falcon.event.model.repository.BaseRepository
    public final void a(String eventName, Map properties) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        EventRequestType eventRequestType = new EventRequestType(CollectionsKt.H(new Event(eventName, properties)));
        Object value = this.f20441a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        ((EventApi) value).a(eventRequestType).N(new EventRepository$publishEvent$1());
    }
}
