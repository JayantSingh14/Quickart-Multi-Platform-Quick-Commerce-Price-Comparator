package androidx.constraintlayout.core.dsl;

import android.support.v4.media.b;
import androidx.constraintlayout.core.dsl.Constraint;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Helper {

    public static final class HelperType {
        public final String toString() {
            return null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f1756a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f1757b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f1758c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f1759d;

        /* renamed from: e, reason: collision with root package name */
        public static final Type f1760e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1761f;

        static {
            Type type = new Type("VERTICAL_GUIDELINE", 0);
            f1756a = type;
            Type type2 = new Type("HORIZONTAL_GUIDELINE", 1);
            f1757b = type2;
            Type type3 = new Type("VERTICAL_CHAIN", 2);
            f1758c = type3;
            Type type4 = new Type("HORIZONTAL_CHAIN", 3);
            f1759d = type4;
            Type type5 = new Type("BARRIER", 4);
            f1760e = type5;
            f1761f = new Type[]{type, type2, type3, type4, type5};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1761f.clone();
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(Constraint.Side.f1744a, "'left'");
        map.put(Constraint.Side.f1745b, "'right'");
        map.put(Constraint.Side.f1746c, "'top'");
        map.put(Constraint.Side.f1747d, "'bottom'");
        map.put(Constraint.Side.f1748e, "'start'");
        map.put(Constraint.Side.f1749f, "'end'");
        map.put(Constraint.Side.f1750g, "'baseline'");
        HashMap map2 = new HashMap();
        map2.put(Type.f1756a, "vGuideline");
        map2.put(Type.f1757b, "hGuideline");
        map2.put(Type.f1758c, "vChain");
        map2.put(Type.f1759d, "hChain");
        map2.put(Type.f1760e, "barrier");
    }

    public final String toString() {
        return b.C("null:{\n", "},\n");
    }
}
