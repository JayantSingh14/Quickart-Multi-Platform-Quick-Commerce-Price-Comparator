package androidx.constraintlayout.core.state;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class State {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Chain {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Chain[] f1910a;

        /* JADX INFO: Fake field, exist only in values array */
        Chain EF0;

        static {
            Chain chain = new Chain("SPREAD", 0);
            Chain chain2 = new Chain("SPREAD_INSIDE", 1);
            Chain chain3 = new Chain("PACKED", 2);
            f1910a = new Chain[]{chain, chain2, chain3};
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            map.put("packed", chain3);
            map.put("spread_inside", chain2);
            map.put("spread", chain);
            b.z(2, map2, "packed", 1, "spread_inside");
            map2.put("spread", 0);
        }

        public static Chain valueOf(String str) {
            return (Chain) Enum.valueOf(Chain.class, str);
        }

        public static Chain[] values() {
            return (Chain[]) f1910a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Constraint {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Constraint[] f1911a = {new Constraint("LEFT_TO_LEFT", 0), new Constraint("LEFT_TO_RIGHT", 1), new Constraint("RIGHT_TO_LEFT", 2), new Constraint("RIGHT_TO_RIGHT", 3), new Constraint("START_TO_START", 4), new Constraint("START_TO_END", 5), new Constraint("END_TO_START", 6), new Constraint("END_TO_END", 7), new Constraint("TOP_TO_TOP", 8), new Constraint("TOP_TO_BOTTOM", 9), new Constraint("TOP_TO_BASELINE", 10), new Constraint("BOTTOM_TO_TOP", 11), new Constraint("BOTTOM_TO_BOTTOM", 12), new Constraint("BOTTOM_TO_BASELINE", 13), new Constraint("BASELINE_TO_BASELINE", 14), new Constraint("BASELINE_TO_TOP", 15), new Constraint("BASELINE_TO_BOTTOM", 16), new Constraint("CENTER_HORIZONTALLY", 17), new Constraint("CENTER_VERTICALLY", 18), new Constraint("CIRCULAR_CONSTRAINT", 19)};

        /* JADX INFO: Fake field, exist only in values array */
        Constraint EF5;

        public static Constraint valueOf(String str) {
            return (Constraint) Enum.valueOf(Constraint.class, str);
        }

        public static Constraint[] values() {
            return (Constraint[]) f1911a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Direction {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f1912a = {new Direction("LEFT", 0), new Direction("RIGHT", 1), new Direction("START", 2), new Direction("END", 3), new Direction("TOP", 4), new Direction("BOTTOM", 5)};

        /* JADX INFO: Fake field, exist only in values array */
        Direction EF5;

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) f1912a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Helper {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Helper[] f1913a = {new Helper("HORIZONTAL_CHAIN", 0), new Helper("VERTICAL_CHAIN", 1), new Helper("ALIGN_HORIZONTALLY", 2), new Helper("ALIGN_VERTICALLY", 3), new Helper("BARRIER", 4), new Helper("LAYER", 5), new Helper("HORIZONTAL_FLOW", 6), new Helper("VERTICAL_FLOW", 7), new Helper("GRID", 8), new Helper("ROW", 9), new Helper("COLUMN", 10), new Helper("FLOW", 11)};

        /* JADX INFO: Fake field, exist only in values array */
        Helper EF5;

        public static Helper valueOf(String str) {
            return (Helper) Enum.valueOf(Helper.class, str);
        }

        public static Helper[] values() {
            return (Helper[]) f1913a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Wrap {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Wrap[] f1914a;

        /* JADX INFO: Fake field, exist only in values array */
        Wrap EF0;

        static {
            Wrap wrap = new Wrap("NONE", 0);
            Wrap wrap2 = new Wrap("CHAIN", 1);
            Wrap wrap3 = new Wrap("ALIGNED", 2);
            f1914a = new Wrap[]{wrap, wrap2, wrap3};
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            map.put("none", wrap);
            map.put("chain", wrap2);
            map.put("aligned", wrap3);
            b.z(0, map2, "none", 3, "chain");
            map2.put("aligned", 2);
        }

        public static Wrap valueOf(String str) {
            return (Wrap) Enum.valueOf(Wrap.class, str);
        }

        public static Wrap[] values() {
            return (Wrap[]) f1914a.clone();
        }
    }

    public State() {
        HashMap map = new HashMap();
        new HashMap();
        new HashMap();
        ConstraintReference constraintReference = new ConstraintReference();
        new HashMap();
        new HashMap();
        new ArrayList();
        new ArrayList();
        map.put(0, constraintReference);
    }
}
