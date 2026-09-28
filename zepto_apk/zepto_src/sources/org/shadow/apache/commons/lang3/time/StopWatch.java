package org.shadow.apache.commons.lang3.time;

/* loaded from: classes5.dex */
public class StopWatch {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class SplitState {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SplitState[] f57866a = {new SplitState("SPLIT", 0), new SplitState("UNSPLIT", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        SplitState EF5;

        public static SplitState valueOf(String str) {
            return (SplitState) Enum.valueOf(SplitState.class, str);
        }

        public static SplitState[] values() {
            return (SplitState[]) f57866a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class State {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f57867a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ State[] f57868b;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [org.shadow.apache.commons.lang3.time.StopWatch$State$1] */
        static {
            ?? r0 = new State() { // from class: org.shadow.apache.commons.lang3.time.StopWatch.State.1
            };
            f57867a = r0;
            f57868b = new State[]{r0, new State() { // from class: org.shadow.apache.commons.lang3.time.StopWatch.State.2
            }, new State() { // from class: org.shadow.apache.commons.lang3.time.StopWatch.State.3
            }, new State() { // from class: org.shadow.apache.commons.lang3.time.StopWatch.State.4
            }};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f57868b.clone();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.shadow.apache.commons.lang3.time.StopWatch.toString():java.lang.String");
    }
}
