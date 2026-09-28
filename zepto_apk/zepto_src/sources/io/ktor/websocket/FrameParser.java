package io.ktor.websocket;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FrameParser {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f51447a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ State[] f51448b;

        static {
            State state = new State("HEADER0", 0);
            f51447a = state;
            f51448b = new State[]{state, new State("LENGTH", 1), new State("MASK_KEY", 2), new State("BODY", 3)};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f51448b.clone();
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
            try {
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FrameParser() {
        new AtomicReference(State.f51447a);
    }
}
