package androidx.constraintlayout.core.dsl;

import android.support.v4.media.b;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class Chain extends Helper {

    public class Anchor {
        public final String toString() {
            return b.D("[", ",0,0", "]");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Style {

        /* renamed from: a, reason: collision with root package name */
        public static final Style f1717a;

        /* renamed from: b, reason: collision with root package name */
        public static final Style f1718b;

        /* renamed from: c, reason: collision with root package name */
        public static final Style f1719c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Style[] f1720d;

        static {
            Style style = new Style("PACKED", 0);
            f1717a = style;
            Style style2 = new Style("SPREAD", 1);
            f1718b = style2;
            Style style3 = new Style("SPREAD_INSIDE", 2);
            f1719c = style3;
            f1720d = new Style[]{style, style2, style3};
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) f1720d.clone();
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(Style.f1718b, "'spread'");
        map.put(Style.f1719c, "'spread_inside'");
        map.put(Style.f1717a, "'packed'");
    }
}
