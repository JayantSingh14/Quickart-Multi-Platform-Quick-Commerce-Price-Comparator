package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.storage.EventStorage;
import com.zeptonow.horizon.utils.EventPropertiesFilter;
import com.zeptonow.horizon.utils.LogLevel;
import com.zeptonow.horizon.utils.SerializationUtilsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventManager$track$1", f = "EventManager.kt", l = {53}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventManager$track$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Event f47993a;

    /* renamed from: b, reason: collision with root package name */
    public String f47994b;

    /* renamed from: c, reason: collision with root package name */
    public int f47995c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Event f47996d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EventManager f47997e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventManager$track$1(Event event, EventManager eventManager, Continuation continuation) {
        super(2, continuation);
        this.f47996d = event;
        this.f47997e = eventManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventManager$track$1(this.f47996d, this.f47997e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventManager$track$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.zeptonow.horizon.entity.Event] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Event event;
        final String str;
        String name;
        List list;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        final Event event2 = this.f47995c;
        try {
            if (event2 == 0) {
                ResultKt.b(obj);
                LinkedHashMap linkedHashMap = EventPropertiesFilter.f48239a;
                Event event3 = this.f47996d;
                Map pathsByEventName = this.f47997e.f47983d.f48090j;
                Intrinsics.checkNotNullParameter(event3, "event");
                Intrinsics.checkNotNullParameter(pathsByEventName, "pathsByEventName");
                try {
                    name = event3.f48063a;
                    list = (List) pathsByEventName.get(name);
                    if (list == null) {
                        list = EmptyList.f53609a;
                    }
                } catch (Exception unused) {
                }
                if (list.isEmpty()) {
                    event = event3;
                } else {
                    Json json = SerializationUtilsKt.f48279b;
                    String string = event3.f48064b;
                    json.getClass();
                    Intrinsics.checkNotNullParameter(string, "string");
                    JsonObject jsonObjectE = JsonElementKt.e((JsonElement) json.b(string, JsonElementSerializer.f55978a));
                    for (List list2 : EventPropertiesFilter.a(name, list)) {
                        if (!list2.isEmpty()) {
                            jsonObjectE = EventPropertiesFilter.b(jsonObjectE, list2);
                        }
                    }
                    String properties = SerializationUtilsKt.f48279b.d(JsonObject.Companion.serializer(), jsonObjectE);
                    EventType type = event3.f48065c;
                    Intrinsics.checkNotNullParameter(name, "name");
                    Intrinsics.checkNotNullParameter(properties, "properties");
                    Intrinsics.checkNotNullParameter(type, "type");
                    event = new Event(name, properties, type);
                }
                if (this.f47997e.f47986g) {
                    this.f47997e.f47984e.a(LogLevel.f48266d, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventManager$track$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return "EventManager:: storage full, sending directly: " + event.f48063a;
                        }
                    });
                    this.f47997e.f47985f.c(event);
                    return Unit.f53572a;
                }
                String string2 = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                EventStorage eventStorage = this.f47997e.f47981b;
                this.f47993a = event;
                this.f47994b = string2;
                this.f47995c = 1;
                if (eventStorage.h(event, string2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                str = string2;
                event2 = event;
            } else {
                if (event2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = this.f47994b;
                Event event4 = this.f47993a;
                ResultKt.b(obj);
                event2 = event4;
            }
            this.f47997e.f47984e.a(LogLevel.f48266d, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventManager$track$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "EventManager:: stored event: " + event2.f48063a + ", id: " + str;
                }
            });
        } catch (Exception unused2) {
            this.f47997e.f47984e.a(LogLevel.f48266d, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventManager$track$1.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "EventManager:: storage failed, sending directly: " + event2.f48063a;
                }
            });
            EventManager eventManager = this.f47997e;
            if (!eventManager.f47986g) {
                eventManager.f47986g = true;
                eventManager.f47984e.a(LogLevel.f48264b, EventManager$markStorageFull$1.f47991c);
            }
            this.f47997e.f47985f.c(event2);
        }
        return Unit.f53572a;
    }
}
