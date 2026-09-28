package com.google.android.gms.ads.initialization;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public interface AdapterStatus {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f21077a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f21078b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ State[] f21079c;

        static {
            State state = new State("NOT_READY", 0);
            f21077a = state;
            State state2 = new State("READY", 1);
            f21078b = state2;
            f21079c = new State[]{state, state2};
        }

        @NonNull
        public static State valueOf(@NonNull String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        @NonNull
        public static State[] values() {
            return (State[]) f21079c.clone();
        }
    }

    State a();

    String getDescription();
}
