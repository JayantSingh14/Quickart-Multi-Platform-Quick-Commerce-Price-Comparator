package com.zeptonow.horizon.storage;

import app.cash.sqldelight.BaseTransacterImpl;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.coroutines.a;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.zeptonow.horizon.entity.EventStatus;
import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.storage.EventDatabaseQueries;
import com.zeptonow.horizon.storage.EventEntity;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class EventDatabaseQueries extends TransacterImpl {

    /* renamed from: b, reason: collision with root package name */
    public final EventEntity.Adapter f48124b;

    @Metadata
    public final class GetCountByStatusQuery<T> extends Query<T> {

        /* renamed from: b, reason: collision with root package name */
        public final EventType f48125b;

        /* renamed from: c, reason: collision with root package name */
        public final EventStatus f48126c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EventDatabaseQueries f48127d;

        /* JADX WARN: Illegal instructions before constructor call */
        public GetCountByStatusQuery(EventDatabaseQueries eventDatabaseQueries, EventType eventType, EventStatus status) {
            EventDatabaseQueries$getCountByStatus$1 mapper = EventDatabaseQueries$getCountByStatus$1.f48142c;
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.f48127d = eventDatabaseQueries;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            super(mapper);
            this.f48125b = eventType;
            this.f48126c = status;
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public final QueryResult a(Function1 mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            final EventDatabaseQueries eventDatabaseQueries = this.f48127d;
            return eventDatabaseQueries.f13074a.r1(1044612008, "SELECT COUNT(*) FROM EventEntity\nWHERE eventType = ? AND status = ?", mapper, new Function1<SqlPreparedStatement, Unit>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$GetCountByStatusQuery$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    SqlPreparedStatement executeQuery = (SqlPreparedStatement) obj;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    EventDatabaseQueries eventDatabaseQueries2 = eventDatabaseQueries;
                    eventDatabaseQueries2.f48124b.getClass();
                    EventTypeAdapterKt$eventTypeAdapter$1 eventTypeAdapterKt$eventTypeAdapter$1 = EventTypeAdapterKt.f48172a;
                    EventDatabaseQueries.GetCountByStatusQuery getCountByStatusQuery = this;
                    executeQuery.m(0, eventTypeAdapterKt$eventTypeAdapter$1.b(getCountByStatusQuery.f48125b));
                    eventDatabaseQueries2.f48124b.getClass();
                    executeQuery.m(1, EventTypeAdapterKt.f48173b.b(getCountByStatusQuery.f48126c));
                    return Unit.f53572a;
                }
            });
        }

        @Override // app.cash.sqldelight.Query
        public final void c(a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f48127d.f13074a.O0(new String[]{"EventEntity"}, listener);
        }

        @Override // app.cash.sqldelight.Query
        public final void d(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f48127d.f13074a.I0(new String[]{"EventEntity"}, listener);
        }

        public final String toString() {
            return "EventDatabase.sq:getCountByStatus";
        }
    }

    @Metadata
    public final class GetEventsByStatusQuery<T> extends Query<T> {

        /* renamed from: b, reason: collision with root package name */
        public final EventType f48130b;

        /* renamed from: c, reason: collision with root package name */
        public final long f48131c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EventDatabaseQueries f48132d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetEventsByStatusQuery(EventDatabaseQueries eventDatabaseQueries, EventType eventType, long j2, Function1 mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.f48132d = eventDatabaseQueries;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.f48130b = eventType;
            this.f48131c = j2;
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public final QueryResult a(Function1 mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            final EventDatabaseQueries eventDatabaseQueries = this.f48132d;
            return eventDatabaseQueries.f13074a.r1(184282898, "SELECT EventEntity.eventId, EventEntity.name, EventEntity.properties, EventEntity.timestamp, EventEntity.failureCount, EventEntity.status, EventEntity.lastFailureReason, EventEntity.eventType FROM EventEntity\nWHERE eventType = ? AND status = 'PENDING'\nLIMIT ?", mapper, new Function1<SqlPreparedStatement, Unit>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$GetEventsByStatusQuery$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    SqlPreparedStatement executeQuery = (SqlPreparedStatement) obj;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    eventDatabaseQueries.f48124b.getClass();
                    EventTypeAdapterKt$eventTypeAdapter$1 eventTypeAdapterKt$eventTypeAdapter$1 = EventTypeAdapterKt.f48172a;
                    EventDatabaseQueries.GetEventsByStatusQuery getEventsByStatusQuery = this;
                    executeQuery.m(0, eventTypeAdapterKt$eventTypeAdapter$1.b(getEventsByStatusQuery.f48130b));
                    executeQuery.a(1, Long.valueOf(getEventsByStatusQuery.f48131c));
                    return Unit.f53572a;
                }
            });
        }

        @Override // app.cash.sqldelight.Query
        public final void c(a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f48132d.f13074a.O0(new String[]{"EventEntity"}, listener);
        }

        @Override // app.cash.sqldelight.Query
        public final void d(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f48132d.f13074a.I0(new String[]{"EventEntity"}, listener);
        }

        public final String toString() {
            return "EventDatabase.sq:getEventsByStatus";
        }
    }

    @Metadata
    public final class GetFailedEventsQuery<T> extends Query<T> {

        /* renamed from: b, reason: collision with root package name */
        public final EventType f48135b;

        /* renamed from: c, reason: collision with root package name */
        public final long f48136c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EventDatabaseQueries f48137d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetFailedEventsQuery(EventDatabaseQueries eventDatabaseQueries, EventType eventType, long j2, Function1 mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.f48137d = eventDatabaseQueries;
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.f48135b = eventType;
            this.f48136c = j2;
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public final QueryResult a(Function1 mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            final EventDatabaseQueries eventDatabaseQueries = this.f48137d;
            return eventDatabaseQueries.f13074a.r1(1014666086, "SELECT EventEntity.eventId, EventEntity.name, EventEntity.properties, EventEntity.timestamp, EventEntity.failureCount, EventEntity.status, EventEntity.lastFailureReason, EventEntity.eventType FROM EventEntity\nWHERE eventType = ? AND status = 'FAILED'\nORDER BY failureCount, timestamp ASC\nLIMIT ?", mapper, new Function1<SqlPreparedStatement, Unit>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$GetFailedEventsQuery$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    SqlPreparedStatement executeQuery = (SqlPreparedStatement) obj;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    eventDatabaseQueries.f48124b.getClass();
                    EventTypeAdapterKt$eventTypeAdapter$1 eventTypeAdapterKt$eventTypeAdapter$1 = EventTypeAdapterKt.f48172a;
                    EventDatabaseQueries.GetFailedEventsQuery getFailedEventsQuery = this;
                    executeQuery.m(0, eventTypeAdapterKt$eventTypeAdapter$1.b(getFailedEventsQuery.f48135b));
                    executeQuery.a(1, Long.valueOf(getFailedEventsQuery.f48136c));
                    return Unit.f53572a;
                }
            });
        }

        @Override // app.cash.sqldelight.Query
        public final void c(a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f48137d.f13074a.O0(new String[]{"EventEntity"}, listener);
        }

        @Override // app.cash.sqldelight.Query
        public final void d(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f48137d.f13074a.I0(new String[]{"EventEntity"}, listener);
        }

        public final String toString() {
            return "EventDatabase.sq:getFailedEvents";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDatabaseQueries(SqlDriver driver, EventEntity.Adapter EventEntityAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(EventEntityAdapter, "EventEntityAdapter");
        this.f48124b = EventEntityAdapter;
    }

    public final void d(final ArrayList eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        String strF0 = StringsKt.f0("\n        |DELETE FROM EventEntity\n        |WHERE eventId IN " + BaseTransacterImpl.b(eventId.size()) + "\n        ");
        eventId.size();
        this.f13074a.b0(null, strF0, new Function1<SqlPreparedStatement, Unit>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$deleteEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlPreparedStatement execute = (SqlPreparedStatement) obj;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                int i2 = 0;
                for (Object obj2 : eventId) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.b0();
                        throw null;
                    }
                    execute.m(i2, (String) obj2);
                    i2 = i3;
                }
                return Unit.f53572a;
            }
        });
        c(-172884503, EventDatabaseQueries$deleteEvent$2.f48141c);
    }

    public final void e(final String str, final ArrayList eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        String strF0 = StringsKt.f0("\n        |UPDATE EventEntity\n        |SET\n        |  failureCount = failureCount + 1,\n        |  status = 'FAILED',\n        |  lastFailureReason = ?\n        |WHERE eventId IN " + BaseTransacterImpl.b(eventId.size()) + "\n        ");
        eventId.size();
        this.f13074a.b0(null, strF0, new Function1<SqlPreparedStatement, Unit>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$incrementFailureCount$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlPreparedStatement execute = (SqlPreparedStatement) obj;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                int i2 = 0;
                execute.m(0, str);
                for (Object obj2 : eventId) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.b0();
                        throw null;
                    }
                    execute.m(i3, (String) obj2);
                    i2 = i3;
                }
                return Unit.f53572a;
            }
        });
        c(-1458506642, EventDatabaseQueries$incrementFailureCount$2.f48151c);
    }

    public final void f(final String eventId, final String name, final String properties, final long j2, final EventType eventType) {
        EventStatus status = EventStatus.f48071a;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.f13074a.b0(845789595, "INSERT INTO EventEntity(eventId, name, properties, timestamp, failureCount, status, lastFailureReason, eventType)\nVALUES (?, ?, ?, ?, ?, ?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$insertEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                EventStatus eventStatus = EventStatus.f48071a;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlPreparedStatement execute = (SqlPreparedStatement) obj;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.m(0, eventId);
                execute.m(1, name);
                execute.m(2, properties);
                execute.a(3, Long.valueOf(j2));
                execute.a(4, 0L);
                EventDatabaseQueries eventDatabaseQueries = this;
                eventDatabaseQueries.f48124b.getClass();
                execute.m(5, EventTypeAdapterKt.f48173b.b(EventStatus.f48071a));
                execute.m(6, null);
                eventDatabaseQueries.f48124b.getClass();
                execute.m(7, EventTypeAdapterKt.f48172a.b(eventType));
                return Unit.f53572a;
            }
        });
        c(845789595, EventDatabaseQueries$insertEvent$2.f48158c);
    }

    public final void g(final EventStatus newStatus, final Collection eventId) {
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        String strF0 = StringsKt.f0("\n        |UPDATE EventEntity\n        |SET status = ?\n        |WHERE eventId IN " + BaseTransacterImpl.b(eventId.size()) + "\n        ");
        eventId.size();
        this.f13074a.b0(null, strF0, new Function1<SqlPreparedStatement, Unit>() { // from class: com.zeptonow.horizon.storage.EventDatabaseQueries$updateEventStatusByIds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlPreparedStatement execute = (SqlPreparedStatement) obj;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                this.f48160c.f48124b.getClass();
                int i2 = 0;
                execute.m(0, EventTypeAdapterKt.f48173b.b(newStatus));
                for (Object obj2 : eventId) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.b0();
                        throw null;
                    }
                    execute.m(i3, (String) obj2);
                    i2 = i3;
                }
                return Unit.f53572a;
            }
        });
        c(87903108, EventDatabaseQueries$updateEventStatusByIds$2.f48163c);
    }
}
