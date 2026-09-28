package com.zeptonow.horizon.storage;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class EventDatabaseQueries$deleteEvent$2 extends Lambda implements Function1<Function1<? super String, ? extends Unit>, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final EventDatabaseQueries$deleteEvent$2 f48141c = new EventDatabaseQueries$deleteEvent$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Function1 emit = (Function1) obj;
        Intrinsics.checkNotNullParameter(emit, "emit");
        emit.invoke("EventEntity");
        return Unit.f53572a;
    }
}
