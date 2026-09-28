package com.zeptonow.horizon.storage;

import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.entity.EventStatus;
import com.zeptonow.horizon.entity.EventType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes.dex */
public interface EventStorage {
    PersistentStorage$hasFailedEvents$$inlined$map$1 a(EventType eventType);

    List b(EventType eventType, int i2);

    Object c(List list, String str, ContinuationImpl continuationImpl);

    Object d(List list, ContinuationImpl continuationImpl);

    List e(EventType eventType, int i2);

    PersistentStorage$getPendingCount$$inlined$map$1 f(EventType eventType);

    Object g(ContinuationImpl continuationImpl);

    Object h(Event event, String str, ContinuationImpl continuationImpl);

    PersistentStorage$getFailedEventCount$$inlined$map$1 i(EventType eventType);

    Object j(ArrayList arrayList, EventStatus eventStatus, ContinuationImpl continuationImpl);
}
