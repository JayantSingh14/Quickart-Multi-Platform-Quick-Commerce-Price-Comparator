package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes3.dex */
public final class WebSocketReader implements CoroutineScope {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f51518a = {new State("HEADER", 0), new State("BODY", 1), new State("CLOSED", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        State EF5;

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f51518a.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return null;
    }
}
