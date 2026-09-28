package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f4803a = new AtomicReference(null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Event {
        private static final /* synthetic */ Event[] $VALUES;

        @NotNull
        public static final Companion Companion;
        public static final Event ON_ANY;
        public static final Event ON_CREATE;
        public static final Event ON_DESTROY;
        public static final Event ON_PAUSE;
        public static final Event ON_RESUME;
        public static final Event ON_START;
        public static final Event ON_STOP;

        @Metadata
        public static final class Companion {

            @Metadata
            public /* synthetic */ class WhenMappings {
                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[2] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[3] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[4] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[0] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[1] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                }
            }

            public static Event a(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int iOrdinal = state.ordinal();
                if (iOrdinal == 2) {
                    return Event.ON_DESTROY;
                }
                if (iOrdinal == 3) {
                    return Event.ON_STOP;
                }
                if (iOrdinal != 4) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            public static Event b(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int iOrdinal = state.ordinal();
                if (iOrdinal == 2) {
                    return Event.ON_CREATE;
                }
                if (iOrdinal == 3) {
                    return Event.ON_START;
                }
                if (iOrdinal != 4) {
                    return null;
                }
                return Event.ON_RESUME;
            }
        }

        @Metadata
        public /* synthetic */ class WhenMappings {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f4804a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f4804a = iArr;
            }
        }

        static {
            Event event = new Event("ON_CREATE", 0);
            ON_CREATE = event;
            Event event2 = new Event("ON_START", 1);
            ON_START = event2;
            Event event3 = new Event("ON_RESUME", 2);
            ON_RESUME = event3;
            Event event4 = new Event("ON_PAUSE", 3);
            ON_PAUSE = event4;
            Event event5 = new Event("ON_STOP", 4);
            ON_STOP = event5;
            Event event6 = new Event("ON_DESTROY", 5);
            ON_DESTROY = event6;
            Event event7 = new Event("ON_ANY", 6);
            ON_ANY = event7;
            $VALUES = new Event[]{event, event2, event3, event4, event5, event6, event7};
            Companion = new Companion();
        }

        public static Event valueOf(String str) {
            return (Event) Enum.valueOf(Event.class, str);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public final State a() {
            switch (WhenMappings.f4804a[ordinal()]) {
                case 1:
                case 2:
                    return State.f4807c;
                case 3:
                case 4:
                    return State.f4808d;
                case 5:
                    return State.f4809e;
                case 6:
                    return State.f4805a;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f4805a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f4806b;

        /* renamed from: c, reason: collision with root package name */
        public static final State f4807c;

        /* renamed from: d, reason: collision with root package name */
        public static final State f4808d;

        /* renamed from: e, reason: collision with root package name */
        public static final State f4809e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ State[] f4810f;

        static {
            State state = new State("DESTROYED", 0);
            f4805a = state;
            State state2 = new State("INITIALIZED", 1);
            f4806b = state2;
            State state3 = new State("CREATED", 2);
            f4807c = state3;
            State state4 = new State("STARTED", 3);
            f4808d = state4;
            State state5 = new State("RESUMED", 4);
            f4809e = state5;
            f4810f = new State[]{state, state2, state3, state4, state5};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f4810f.clone();
        }

        public final boolean a(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return compareTo(state) >= 0;
        }
    }

    public abstract void a(LifecycleObserver lifecycleObserver);

    public abstract State b();

    public abstract void c(LifecycleObserver lifecycleObserver);
}
