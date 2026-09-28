package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.DoNotMock;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@DoNotMock
@J2ktIncompatible
/* loaded from: classes4.dex */
public interface Service {

    public static abstract class Listener {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f43470a = {new State("NEW", 0), new State("STARTING", 1), new State("RUNNING", 2), new State("STOPPING", 3), new State("TERMINATED", 4), new State("FAILED", 5)};

        /* JADX INFO: Fake field, exist only in values array */
        State EF5;

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f43470a.clone();
        }
    }
}
