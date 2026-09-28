package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* JADX WARN: Method from annotation default annotation not found: byteBuffer */
/* JADX WARN: Method from annotation default annotation not found: enums */
/* JADX WARN: Method from annotation default annotation not found: uuid */
@Target({})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
/* loaded from: classes3.dex */
public @interface BuiltInTypeConverters {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f11733a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ State[] f11734b;

        /* JADX INFO: Fake field, exist only in values array */
        State EF0;

        static {
            State state = new State("ENABLED", 0);
            State state2 = new State("DISABLED", 1);
            State state3 = new State("INHERITED", 2);
            f11733a = state3;
            f11734b = new State[]{state, state2, state3};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f11734b.clone();
        }
    }
}
