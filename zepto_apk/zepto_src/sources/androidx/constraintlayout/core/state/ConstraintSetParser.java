package androidx.constraintlayout.core.state;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class ConstraintSetParser {

    public static class DesignElement {
    }

    public static class FiniteGenerator implements GeneratedValue {
    }

    public interface GeneratedValue {
    }

    public static class Generator implements GeneratedValue {
    }

    public static class LayoutVariables {
        public LayoutVariables() {
            new HashMap();
            new HashMap();
            new HashMap();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MotionLayoutDebugFlags {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MotionLayoutDebugFlags[] f1907a = {new MotionLayoutDebugFlags("NONE", 0), new MotionLayoutDebugFlags("SHOW_ALL", 1), new MotionLayoutDebugFlags("UNKNOWN", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        MotionLayoutDebugFlags EF5;

        public static MotionLayoutDebugFlags valueOf(String str) {
            return (MotionLayoutDebugFlags) Enum.valueOf(MotionLayoutDebugFlags.class, str);
        }

        public static MotionLayoutDebugFlags[] values() {
            return (MotionLayoutDebugFlags[]) f1907a.clone();
        }
    }

    public static class OverrideValue implements GeneratedValue {
    }
}
