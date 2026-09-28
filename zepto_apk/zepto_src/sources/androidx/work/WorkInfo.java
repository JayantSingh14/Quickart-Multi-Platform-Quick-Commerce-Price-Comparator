package androidx.work;

import android.support.v4.media.a;
import java.util.HashSet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WorkInfo {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f12552a;

    /* renamed from: b, reason: collision with root package name */
    public final State f12553b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f12554c;

    /* renamed from: d, reason: collision with root package name */
    public final Data f12555d;

    /* renamed from: e, reason: collision with root package name */
    public final Data f12556e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12557f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12558g;

    /* renamed from: h, reason: collision with root package name */
    public final Constraints f12559h;

    /* renamed from: i, reason: collision with root package name */
    public final long f12560i;

    /* renamed from: j, reason: collision with root package name */
    public final PeriodicityInfo f12561j;

    /* renamed from: k, reason: collision with root package name */
    public final long f12562k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12563l;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class PeriodicityInfo {

        /* renamed from: a, reason: collision with root package name */
        public final long f12564a;

        /* renamed from: b, reason: collision with root package name */
        public final long f12565b;

        public PeriodicityInfo(long j2, long j3) {
            this.f12564a = j2;
            this.f12565b = j3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PeriodicityInfo.class.equals(obj.getClass())) {
                PeriodicityInfo periodicityInfo = (PeriodicityInfo) obj;
                if (periodicityInfo.f12564a == this.f12564a && periodicityInfo.f12565b == this.f12565b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Long.hashCode(this.f12565b) + (Long.hashCode(this.f12564a) * 31);
        }

        public final String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.f12564a + ", flexIntervalMillis=" + this.f12565b + '}';
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes.dex */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f12566a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f12567b;

        /* renamed from: c, reason: collision with root package name */
        public static final State f12568c;

        /* renamed from: d, reason: collision with root package name */
        public static final State f12569d;

        /* renamed from: e, reason: collision with root package name */
        public static final State f12570e;

        /* renamed from: f, reason: collision with root package name */
        public static final State f12571f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ State[] f12572g;

        static {
            State state = new State("ENQUEUED", 0);
            f12566a = state;
            State state2 = new State("RUNNING", 1);
            f12567b = state2;
            State state3 = new State("SUCCEEDED", 2);
            f12568c = state3;
            State state4 = new State("FAILED", 3);
            f12569d = state4;
            State state5 = new State("BLOCKED", 4);
            f12570e = state5;
            State state6 = new State("CANCELLED", 5);
            f12571f = state6;
            f12572g = new State[]{state, state2, state3, state4, state5, state6};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f12572g.clone();
        }

        public final boolean a() {
            return this == f12568c || this == f12569d || this == f12571f;
        }
    }

    public WorkInfo(UUID id, State state, HashSet tags, Data outputData, Data progress, int i2, int i3, Constraints constraints, long j2, PeriodicityInfo periodicityInfo, long j3, int i4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        this.f12552a = id;
        this.f12553b = state;
        this.f12554c = tags;
        this.f12555d = outputData;
        this.f12556e = progress;
        this.f12557f = i2;
        this.f12558g = i3;
        this.f12559h = constraints;
        this.f12560i = j2;
        this.f12561j = periodicityInfo;
        this.f12562k = j3;
        this.f12563l = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !WorkInfo.class.equals(obj.getClass())) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f12557f == workInfo.f12557f && this.f12558g == workInfo.f12558g && Intrinsics.b(this.f12552a, workInfo.f12552a) && this.f12553b == workInfo.f12553b && Intrinsics.b(this.f12555d, workInfo.f12555d) && this.f12559h.equals(workInfo.f12559h) && this.f12560i == workInfo.f12560i && Intrinsics.b(this.f12561j, workInfo.f12561j) && this.f12562k == workInfo.f12562k && this.f12563l == workInfo.f12563l && this.f12554c.equals(workInfo.f12554c)) {
            return Intrinsics.b(this.f12556e, workInfo.f12556e);
        }
        return false;
    }

    public final int hashCode() {
        int iD = a.d((this.f12559h.hashCode() + ((((((this.f12556e.hashCode() + ((this.f12554c.hashCode() + ((this.f12555d.hashCode() + ((this.f12553b.hashCode() + (this.f12552a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + this.f12557f) * 31) + this.f12558g) * 31)) * 31, 31, this.f12560i);
        PeriodicityInfo periodicityInfo = this.f12561j;
        return Integer.hashCode(this.f12563l) + a.d((iD + (periodicityInfo != null ? periodicityInfo.hashCode() : 0)) * 31, 31, this.f12562k);
    }

    public final String toString() {
        return "WorkInfo{id='" + this.f12552a + "', state=" + this.f12553b + ", outputData=" + this.f12555d + ", tags=" + this.f12554c + ", progress=" + this.f12556e + ", runAttemptCount=" + this.f12557f + ", generation=" + this.f12558g + ", constraints=" + this.f12559h + ", initialDelayMillis=" + this.f12560i + ", periodicityInfo=" + this.f12561j + ", nextScheduleTimeMillis=" + this.f12562k + "}, stopReason=" + this.f12563l;
    }
}
