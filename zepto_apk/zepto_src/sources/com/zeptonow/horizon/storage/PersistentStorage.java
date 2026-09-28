package com.zeptonow.horizon.storage;

import app.cash.sqldelight.coroutines.FlowQuery;
import app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import com.zeptonow.horizon.entity.EventStatus;
import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.storage.EventDatabaseQueries;
import com.zeptonow.horizon.storage.EventEntity;
import com.zeptonow.horizon.storage.shared.EventDatabaseImplKt;
import com.zeptonow.horizon.utils.AndroidDispatchersProvider;
import com.zeptonow.horizon.utils.OS;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class PersistentStorage implements EventStorage {

    /* renamed from: a, reason: collision with root package name */
    public final AndroidDispatchersProvider f48174a;

    /* renamed from: b, reason: collision with root package name */
    public final EventDatabase f48175b;

    /* renamed from: c, reason: collision with root package name */
    public final EventDatabaseQueries f48176c;

    /* renamed from: d, reason: collision with root package name */
    public final MutexImpl f48177d;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[OS.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OS[] osArr = OS.f48272a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PersistentStorage(SqlDriver driver, AndroidDispatchersProvider dispatchers) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.f48174a = dispatchers;
        EventTypeAdapterKt$eventStatusAdapter$1 statusAdapter = EventTypeAdapterKt.f48173b;
        EventTypeAdapterKt$eventTypeAdapter$1 eventTypeAdapter = EventTypeAdapterKt.f48172a;
        Intrinsics.checkNotNullParameter(statusAdapter, "statusAdapter");
        Intrinsics.checkNotNullParameter(eventTypeAdapter, "eventTypeAdapter");
        EventEntity.Adapter EventEntityAdapter = new EventEntity.Adapter();
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(EventEntityAdapter, "EventEntityAdapter");
        EventDatabase eventDatabaseA = EventDatabaseImplKt.a(Reflection.a(EventDatabase.class), driver, EventEntityAdapter);
        this.f48175b = eventDatabaseA;
        this.f48176c = eventDatabaseA.a();
        this.f48177d = MutexKt.a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1] */
    @Override // com.zeptonow.horizon.storage.EventStorage
    public final PersistentStorage$hasFailedEvents$$inlined$map$1 a(EventType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        final PersistentStorage$getFailedEventCount$$inlined$map$1 persistentStorage$getFailedEventCount$$inlined$map$1I = i(type);
        return new Flow<Boolean>() { // from class: com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1

            @Metadata
            @SourceDebugExtension
            /* renamed from: com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1$2, reason: invalid class name */
            public final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f48189a;

                @Metadata
                @DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1$2", f = "PersistentStorage.kt", l = {219}, m = "emit")
                @SourceDebugExtension
                /* renamed from: com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1$2$1, reason: invalid class name */
                public final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f48190a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f48191b;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f48190a = obj;
                        this.f48191b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.a(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f48189a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1$2$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f48191b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f48191b = r1
                        goto L18
                    L13:
                        com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1$2$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f48190a
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                        int r2 = r0.f48191b
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.b(r6)
                        goto L4c
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.b(r6)
                        java.lang.Number r5 = (java.lang.Number) r5
                        int r5 = r5.intValue()
                        if (r5 <= 0) goto L3c
                        r5 = r3
                        goto L3d
                    L3c:
                        r5 = 0
                    L3d:
                        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                        r0.f48191b = r3
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f48189a
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4c
                        return r1
                    L4c:
                        kotlin.Unit r5 = kotlin.Unit.f53572a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object c(FlowCollector flowCollector, Continuation continuation) {
                Object objC = persistentStorage$getFailedEventCount$$inlined$map$1I.c(new AnonymousClass2(flowCollector), continuation);
                return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
            }
        };
    }

    @Override // com.zeptonow.horizon.storage.EventStorage
    public final List b(EventType eventType, int i2) {
        OS[] osArr = OS.f48272a;
        final EventDatabaseQueries eventDatabaseQueries = this.f48176c;
        eventDatabaseQueries.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        EventDatabaseQueries$getEventsByStatus$2 mapper = EventDatabaseQueries$getEventsByStatus$2.f48145c;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new EventDatabaseQueries.GetEventsByStatusQuery(eventDatabaseQueries, eventType, i2, new Function1<SqlCursor, Object>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$getEventsByStatus$1

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function8 f48143c = EventDatabaseQueries$getEventsByStatus$2.f48145c;

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlCursor cursor = (SqlCursor) obj;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                String eventId = cursor.getString(0);
                Intrinsics.c(eventId);
                String name = cursor.getString(1);
                Intrinsics.c(name);
                String properties = cursor.getString(2);
                Intrinsics.c(properties);
                Long l2 = cursor.getLong(3);
                Intrinsics.c(l2);
                Long l3 = cursor.getLong(4);
                Intrinsics.c(l3);
                EventDatabaseQueries eventDatabaseQueries2 = eventDatabaseQueries;
                eventDatabaseQueries2.f48124b.getClass();
                EventTypeAdapterKt$eventStatusAdapter$1 eventTypeAdapterKt$eventStatusAdapter$1 = EventTypeAdapterKt.f48173b;
                String string = cursor.getString(5);
                Intrinsics.c(string);
                Object objA = eventTypeAdapterKt$eventStatusAdapter$1.a(string);
                String string2 = cursor.getString(6);
                eventDatabaseQueries2.f48124b.getClass();
                EventTypeAdapterKt$eventTypeAdapter$1 eventTypeAdapterKt$eventTypeAdapter$1 = EventTypeAdapterKt.f48172a;
                String string3 = cursor.getString(7);
                Intrinsics.c(string3);
                Object objA2 = eventTypeAdapterKt$eventTypeAdapter$1.a(string3);
                EventDatabaseQueries$getEventsByStatus$2.f48145c.getClass();
                long jLongValue = l2.longValue();
                long jLongValue2 = l3.longValue();
                EventStatus status = (EventStatus) objA;
                EventType eventType_ = (EventType) objA2;
                Intrinsics.checkNotNullParameter(eventId, "eventId");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(properties, "properties");
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(eventType_, "eventType_");
                return new EventEntity(eventId, name, properties, jLongValue, jLongValue2, status, string2, eventType_);
            }
        }).b();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.zeptonow.horizon.storage.EventStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.util.List r5, java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.zeptonow.horizon.storage.PersistentStorage$markEventsFailed$1
            if (r0 == 0) goto L13
            r0 = r7
            com.zeptonow.horizon.storage.PersistentStorage$markEventsFailed$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$markEventsFailed$1) r0
            int r1 = r0.f48199g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48199g = r1
            goto L18
        L13:
            com.zeptonow.horizon.storage.PersistentStorage$markEventsFailed$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$markEventsFailed$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f48197e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48199g
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 == r3) goto L32
            r5 = 2
            if (r2 != r5) goto L2a
            kotlin.ResultKt.b(r7)
            goto L8e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlinx.coroutines.sync.MutexImpl r5 = r0.f48196d
            java.lang.String r6 = r0.f48195c
            java.util.List r1 = r0.f48194b
            java.util.List r1 = (java.util.List) r1
            com.zeptonow.horizon.storage.PersistentStorage r0 = r0.f48193a
            kotlin.ResultKt.b(r7)
            r7 = r5
            r5 = r1
            goto L5e
        L42:
            kotlin.ResultKt.b(r7)
            com.zeptonow.horizon.utils.OS[] r7 = com.zeptonow.horizon.utils.OS.f48272a
            kotlinx.coroutines.sync.MutexImpl r7 = r4.f48177d
            r0.f48193a = r4
            r2 = r5
            java.util.List r2 = (java.util.List) r2
            r0.f48194b = r2
            r0.f48195c = r6
            r0.f48196d = r7
            r0.f48199g = r3
            java.lang.Object r0 = r7.c(r0)
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r0 = r4
        L5e:
            r1 = 0
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L82
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L82
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.r(r5, r3)     // Catch: java.lang.Throwable -> L82
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L82
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L82
        L70:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L82
            if (r3 == 0) goto L84
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L82
            com.zeptonow.horizon.storage.EventEntity r3 = (com.zeptonow.horizon.storage.EventEntity) r3     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = r3.f48164a     // Catch: java.lang.Throwable -> L82
            r2.add(r3)     // Catch: java.lang.Throwable -> L82
            goto L70
        L82:
            r5 = move-exception
            goto L91
        L84:
            com.zeptonow.horizon.storage.EventDatabaseQueries r5 = r0.f48176c     // Catch: java.lang.Throwable -> L82
            r5.e(r6, r2)     // Catch: java.lang.Throwable -> L82
            kotlin.Unit r5 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L82
            r7.b(r1)
        L8e:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L91:
            r7.b(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage.c(java.util.List, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.zeptonow.horizon.storage.EventStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.util.List r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.zeptonow.horizon.storage.PersistentStorage$removeEvents$1
            if (r0 == 0) goto L13
            r0 = r6
            com.zeptonow.horizon.storage.PersistentStorage$removeEvents$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$removeEvents$1) r0
            int r1 = r0.f48205f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48205f = r1
            goto L18
        L13:
            com.zeptonow.horizon.storage.PersistentStorage$removeEvents$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$removeEvents$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f48203d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48205f
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 == r3) goto L32
            r5 = 2
            if (r2 != r5) goto L2a
            kotlin.ResultKt.b(r6)
            goto L8a
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlinx.coroutines.sync.MutexImpl r5 = r0.f48202c
            java.util.List r1 = r0.f48201b
            java.util.List r1 = (java.util.List) r1
            com.zeptonow.horizon.storage.PersistentStorage r0 = r0.f48200a
            kotlin.ResultKt.b(r6)
            r6 = r5
            r5 = r1
            goto L5a
        L40:
            kotlin.ResultKt.b(r6)
            com.zeptonow.horizon.utils.OS[] r6 = com.zeptonow.horizon.utils.OS.f48272a
            kotlinx.coroutines.sync.MutexImpl r6 = r4.f48177d
            r0.f48200a = r4
            r2 = r5
            java.util.List r2 = (java.util.List) r2
            r0.f48201b = r2
            r0.f48202c = r6
            r0.f48205f = r3
            java.lang.Object r0 = r6.c(r0)
            if (r0 != r1) goto L59
            return r1
        L59:
            r0 = r4
        L5a:
            r1 = 0
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L7e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7e
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.r(r5, r3)     // Catch: java.lang.Throwable -> L7e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7e
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L7e
        L6c:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L7e
            if (r3 == 0) goto L80
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L7e
            com.zeptonow.horizon.storage.EventEntity r3 = (com.zeptonow.horizon.storage.EventEntity) r3     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = r3.f48164a     // Catch: java.lang.Throwable -> L7e
            r2.add(r3)     // Catch: java.lang.Throwable -> L7e
            goto L6c
        L7e:
            r5 = move-exception
            goto L8d
        L80:
            com.zeptonow.horizon.storage.EventDatabaseQueries r5 = r0.f48176c     // Catch: java.lang.Throwable -> L7e
            r5.d(r2)     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r5 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L7e
            r6.b(r1)
        L8a:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L8d:
            r6.b(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage.d(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.zeptonow.horizon.storage.EventStorage
    public final List e(EventType eventType, int i2) {
        OS[] osArr = OS.f48272a;
        final EventDatabaseQueries eventDatabaseQueries = this.f48176c;
        eventDatabaseQueries.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        EventDatabaseQueries$getFailedEvents$2 mapper = EventDatabaseQueries$getFailedEvents$2.f48148c;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new EventDatabaseQueries.GetFailedEventsQuery(eventDatabaseQueries, eventType, i2, new Function1<SqlCursor, Object>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$getFailedEvents$1

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function8 f48146c = EventDatabaseQueries$getFailedEvents$2.f48148c;

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlCursor cursor = (SqlCursor) obj;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                String eventId = cursor.getString(0);
                Intrinsics.c(eventId);
                String name = cursor.getString(1);
                Intrinsics.c(name);
                String properties = cursor.getString(2);
                Intrinsics.c(properties);
                Long l2 = cursor.getLong(3);
                Intrinsics.c(l2);
                Long l3 = cursor.getLong(4);
                Intrinsics.c(l3);
                EventDatabaseQueries eventDatabaseQueries2 = eventDatabaseQueries;
                eventDatabaseQueries2.f48124b.getClass();
                EventTypeAdapterKt$eventStatusAdapter$1 eventTypeAdapterKt$eventStatusAdapter$1 = EventTypeAdapterKt.f48173b;
                String string = cursor.getString(5);
                Intrinsics.c(string);
                Object objA = eventTypeAdapterKt$eventStatusAdapter$1.a(string);
                String string2 = cursor.getString(6);
                eventDatabaseQueries2.f48124b.getClass();
                EventTypeAdapterKt$eventTypeAdapter$1 eventTypeAdapterKt$eventTypeAdapter$1 = EventTypeAdapterKt.f48172a;
                String string3 = cursor.getString(7);
                Intrinsics.c(string3);
                Object objA2 = eventTypeAdapterKt$eventTypeAdapter$1.a(string3);
                EventDatabaseQueries$getFailedEvents$2.f48148c.getClass();
                long jLongValue = l2.longValue();
                long jLongValue2 = l3.longValue();
                EventStatus status = (EventStatus) objA;
                EventType eventType_ = (EventType) objA2;
                Intrinsics.checkNotNullParameter(eventId, "eventId");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(properties, "properties");
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(eventType_, "eventType_");
                return new EventEntity(eventId, name, properties, jLongValue, jLongValue2, status, string2, eventType_);
            }
        }).b();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1] */
    @Override // com.zeptonow.horizon.storage.EventStorage
    public final PersistentStorage$getPendingCount$$inlined$map$1 f(EventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "type");
        EventStatus status = EventStatus.f48071a;
        EventDatabaseQueries eventDatabaseQueries = this.f48176c;
        eventDatabaseQueries.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(status, "status");
        Flow flowA = FlowQuery.a(new EventDatabaseQueries.GetCountByStatusQuery(eventDatabaseQueries, eventType, status));
        DefaultIoScheduler context = this.f48174a.f48228b;
        Intrinsics.checkNotNullParameter(flowA, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        final FlowQuery$mapToOne$$inlined$map$1 flowQuery$mapToOne$$inlined$map$1 = new FlowQuery$mapToOne$$inlined$map$1(flowA, context);
        return new Flow<Integer>() { // from class: com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1

            @Metadata
            @SourceDebugExtension
            /* renamed from: com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1$2, reason: invalid class name */
            public final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f48184a;

                @Metadata
                @DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1$2", f = "PersistentStorage.kt", l = {219}, m = "emit")
                @SourceDebugExtension
                /* renamed from: com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1$2$1, reason: invalid class name */
                public final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f48185a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f48186b;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f48185a = obj;
                        this.f48186b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.a(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f48184a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1$2$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f48186b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f48186b = r1
                        goto L18
                    L13:
                        com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1$2$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f48185a
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                        int r2 = r0.f48186b
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.b(r6)
                        goto L49
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.b(r6)
                        java.lang.Number r5 = (java.lang.Number) r5
                        long r5 = r5.longValue()
                        int r5 = (int) r5
                        java.lang.Integer r6 = new java.lang.Integer
                        r6.<init>(r5)
                        r0.f48186b = r3
                        kotlinx.coroutines.flow.FlowCollector r5 = r4.f48184a
                        java.lang.Object r5 = r5.a(r6, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.f53572a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object c(FlowCollector flowCollector, Continuation continuation) throws Throwable {
                Object objC = flowQuery$mapToOne$$inlined$map$1.c(new AnonymousClass2(flowCollector), continuation);
                return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.zeptonow.horizon.storage.EventStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.zeptonow.horizon.storage.PersistentStorage$resetInProgressEvents$1
            if (r0 == 0) goto L13
            r0 = r7
            com.zeptonow.horizon.storage.PersistentStorage$resetInProgressEvents$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$resetInProgressEvents$1) r0
            int r1 = r0.f48210e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48210e = r1
            goto L18
        L13:
            com.zeptonow.horizon.storage.PersistentStorage$resetInProgressEvents$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$resetInProgressEvents$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f48208c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48210e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 == r3) goto L32
            r0 = 2
            if (r2 != r0) goto L2a
            kotlin.ResultKt.b(r7)
            goto L6b
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L32:
            kotlinx.coroutines.sync.MutexImpl r1 = r0.f48207b
            com.zeptonow.horizon.storage.PersistentStorage r0 = r0.f48206a
            kotlin.ResultKt.b(r7)
            goto L50
        L3a:
            kotlin.ResultKt.b(r7)
            com.zeptonow.horizon.utils.OS[] r7 = com.zeptonow.horizon.utils.OS.f48272a
            kotlinx.coroutines.sync.MutexImpl r7 = r6.f48177d
            r0.f48206a = r6
            r0.f48207b = r7
            r0.f48210e = r3
            java.lang.Object r0 = r7.c(r0)
            if (r0 != r1) goto L4e
            return r1
        L4e:
            r0 = r6
            r1 = r7
        L50:
            r7 = 0
            com.zeptonow.horizon.storage.EventDatabaseQueries r0 = r0.f48176c     // Catch: java.lang.Throwable -> L6e
            r2 = 486211412(0x1cfaff54, float:1.6609613E-21)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L6e
            app.cash.sqldelight.db.SqlDriver r4 = r0.f13074a     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = "UPDATE EventEntity\nSET\n  status = 'FAILED',\n  lastFailureReason = 'App stopped'\nWHERE\n  status = 'IN_PROGRESS'"
            r4.b0(r3, r5, r7)     // Catch: java.lang.Throwable -> L6e
            com.zeptonow.horizon.storage.EventDatabaseQueries$resetInProgressEvents$1 r3 = com.zeptonow.horizon.storage.EventDatabaseQueries$resetInProgressEvents$1.f48159c     // Catch: java.lang.Throwable -> L6e
            r0.c(r2, r3)     // Catch: java.lang.Throwable -> L6e
            kotlin.Unit r0 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L6e
            r1.b(r7)
        L6b:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L6e:
            r0 = move-exception
            r1.b(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage.g(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.zeptonow.horizon.storage.EventStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(com.zeptonow.horizon.entity.Event r8, java.lang.String r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.zeptonow.horizon.storage.PersistentStorage$storeEvent$1
            if (r0 == 0) goto L13
            r0 = r10
            com.zeptonow.horizon.storage.PersistentStorage$storeEvent$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$storeEvent$1) r0
            int r1 = r0.f48217g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48217g = r1
            goto L18
        L13:
            com.zeptonow.horizon.storage.PersistentStorage$storeEvent$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$storeEvent$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f48215e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48217g
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 == r3) goto L32
            r8 = 2
            if (r2 != r8) goto L2a
            kotlin.ResultKt.b(r10)
            goto L76
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f48214d
            java.lang.String r9 = r0.f48213c
            com.zeptonow.horizon.entity.Event r1 = r0.f48212b
            com.zeptonow.horizon.storage.PersistentStorage r0 = r0.f48211a
            kotlin.ResultKt.b(r10)
            r10 = r8
            r8 = r1
        L3f:
            r1 = r9
            goto L5b
        L41:
            kotlin.ResultKt.b(r10)
            com.zeptonow.horizon.utils.OS[] r10 = com.zeptonow.horizon.utils.OS.f48272a
            kotlinx.coroutines.sync.MutexImpl r10 = r7.f48177d
            r0.f48211a = r7
            r0.f48212b = r8
            r0.f48213c = r9
            r0.f48214d = r10
            r0.f48217g = r3
            java.lang.Object r0 = r10.c(r0)
            if (r0 != r1) goto L59
            return r1
        L59:
            r0 = r7
            goto L3f
        L5b:
            r9 = 0
            com.zeptonow.horizon.storage.EventDatabaseQueries r0 = r0.f48176c     // Catch: java.lang.Throwable -> L79
            java.lang.String r2 = r8.f48063a     // Catch: java.lang.Throwable -> L79
            java.lang.String r3 = r8.f48064b     // Catch: java.lang.Throwable -> L79
            kotlinx.datetime.Instant r4 = kotlinx.datetime.Clock.System.a()     // Catch: java.lang.Throwable -> L79
            long r4 = r4.a()     // Catch: java.lang.Throwable -> L79
            com.zeptonow.horizon.entity.EventStatus r6 = com.zeptonow.horizon.entity.EventStatus.f48071a     // Catch: java.lang.Throwable -> L79
            com.zeptonow.horizon.entity.EventType r6 = r8.f48065c     // Catch: java.lang.Throwable -> L79
            r0.f(r1, r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L79
            kotlin.Unit r8 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L79
            r10.b(r9)
        L76:
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        L79:
            r0 = move-exception
            r8 = r0
            r10.b(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage.h(com.zeptonow.horizon.entity.Event, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.zeptonow.horizon.storage.EventStorage
    public final PersistentStorage$getFailedEventCount$$inlined$map$1 i(EventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "type");
        EventStatus status = EventStatus.f48072b;
        EventDatabaseQueries eventDatabaseQueries = this.f48176c;
        eventDatabaseQueries.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(status, "status");
        Flow flowA = FlowQuery.a(new EventDatabaseQueries.GetCountByStatusQuery(eventDatabaseQueries, eventType, status));
        DefaultIoScheduler context = this.f48174a.f48228b;
        Intrinsics.checkNotNullParameter(flowA, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new PersistentStorage$getFailedEventCount$$inlined$map$1(new FlowQuery$mapToOne$$inlined$map$1(flowA, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    @Override // com.zeptonow.horizon.storage.EventStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.util.ArrayList r5, com.zeptonow.horizon.entity.EventStatus r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.zeptonow.horizon.storage.PersistentStorage$updateStatusForEvents$1
            if (r0 == 0) goto L13
            r0 = r7
            com.zeptonow.horizon.storage.PersistentStorage$updateStatusForEvents$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$updateStatusForEvents$1) r0
            int r1 = r0.f48224g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48224g = r1
            goto L18
        L13:
            com.zeptonow.horizon.storage.PersistentStorage$updateStatusForEvents$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$updateStatusForEvents$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f48222e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48224g
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 == r3) goto L32
            r5 = 2
            if (r2 != r5) goto L2a
            kotlin.ResultKt.b(r7)
            goto L68
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlinx.coroutines.sync.MutexImpl r5 = r0.f48221d
            com.zeptonow.horizon.entity.EventStatus r6 = r0.f48220c
            java.util.List r1 = r0.f48219b
            java.util.List r1 = (java.util.List) r1
            com.zeptonow.horizon.storage.PersistentStorage r0 = r0.f48218a
            kotlin.ResultKt.b(r7)
            r7 = r5
            r5 = r1
            goto L5b
        L42:
            kotlin.ResultKt.b(r7)
            com.zeptonow.horizon.utils.OS[] r7 = com.zeptonow.horizon.utils.OS.f48272a
            kotlinx.coroutines.sync.MutexImpl r7 = r4.f48177d
            r0.f48218a = r4
            r0.f48219b = r5
            r0.f48220c = r6
            r0.f48221d = r7
            r0.f48224g = r3
            java.lang.Object r0 = r7.c(r0)
            if (r0 != r1) goto L5a
            return r1
        L5a:
            r0 = r4
        L5b:
            r1 = 0
            com.zeptonow.horizon.storage.EventDatabaseQueries r0 = r0.f48176c     // Catch: java.lang.Throwable -> L6b
            java.util.Collection r5 = (java.util.Collection) r5     // Catch: java.lang.Throwable -> L6b
            r0.g(r6, r5)     // Catch: java.lang.Throwable -> L6b
            kotlin.Unit r5 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L6b
            r7.b(r1)
        L68:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L6b:
            r5 = move-exception
            r7.b(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage.j(java.util.ArrayList, com.zeptonow.horizon.entity.EventStatus, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
