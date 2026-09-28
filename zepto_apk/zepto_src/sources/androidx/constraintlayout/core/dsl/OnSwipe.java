package androidx.constraintlayout.core.dsl;

/* loaded from: classes3.dex */
public class OnSwipe {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Boundary {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Boundary[] f1773a = {new Boundary("OVERSHOOT", 0), new Boundary("BOUNCE_START", 1), new Boundary("BOUNCE_END", 2), new Boundary("BOUNCE_BOTH", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        Boundary EF5;

        public static Boundary valueOf(String str) {
            return (Boundary) Enum.valueOf(Boundary.class, str);
        }

        public static Boundary[] values() {
            return (Boundary[]) f1773a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Drag {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Drag[] f1774a = {new Drag("UP", 0), new Drag("DOWN", 1), new Drag("LEFT", 2), new Drag("RIGHT", 3), new Drag("START", 4), new Drag("END", 5), new Drag("CLOCKWISE", 6), new Drag("ANTICLOCKWISE", 7)};

        /* JADX INFO: Fake field, exist only in values array */
        Drag EF5;

        public static Drag valueOf(String str) {
            return (Drag) Enum.valueOf(Drag.class, str);
        }

        public static Drag[] values() {
            return (Drag[]) f1774a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Mode {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f1775a = {new Mode("VELOCITY", 0), new Mode("SPRING", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Mode EF5;

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) f1775a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Side {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Side[] f1776a = {new Side("TOP", 0), new Side("LEFT", 1), new Side("RIGHT", 2), new Side("BOTTOM", 3), new Side("MIDDLE", 4), new Side("START", 5), new Side("END", 6)};

        /* JADX INFO: Fake field, exist only in values array */
        Side EF5;

        public static Side valueOf(String str) {
            return (Side) Enum.valueOf(Side.class, str);
        }

        public static Side[] values() {
            return (Side[]) f1776a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TouchUp {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TouchUp[] f1777a = {new TouchUp("AUTOCOMPLETE", 0), new TouchUp("TO_START", 1), new TouchUp("NEVER_COMPLETE_END", 2), new TouchUp("TO_END", 3), new TouchUp("STOP", 4), new TouchUp("DECELERATE", 5), new TouchUp("DECELERATE_COMPLETE", 6), new TouchUp("NEVER_COMPLETE_START", 7)};

        /* JADX INFO: Fake field, exist only in values array */
        TouchUp EF5;

        public static TouchUp valueOf(String str) {
            return (TouchUp) Enum.valueOf(TouchUp.class, str);
        }

        public static TouchUp[] values() {
            return (TouchUp[]) f1777a.clone();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OnSwipe:{\n");
        if (!Float.isNaN(Float.NaN)) {
            sb.append("scale:'NaN',\n");
        }
        if (!Float.isNaN(Float.NaN)) {
            sb.append("threshold:'NaN',\n");
        }
        if (!Float.isNaN(Float.NaN)) {
            sb.append("maxVelocity:'NaN',\n");
        }
        if (!Float.isNaN(Float.NaN)) {
            sb.append("maxAccel:'NaN',\n");
        }
        if (!Float.isNaN(Float.NaN)) {
            sb.append("springMass:'NaN',\n");
        }
        if (!Float.isNaN(Float.NaN)) {
            sb.append("springStiffness:'NaN',\n");
        }
        if (!Float.isNaN(Float.NaN)) {
            sb.append("springDamping:'NaN',\n");
        }
        if (!Float.isNaN(Float.NaN)) {
            sb.append("stopThreshold:'NaN',\n");
        }
        sb.append("},\n");
        return sb.toString();
    }
}
