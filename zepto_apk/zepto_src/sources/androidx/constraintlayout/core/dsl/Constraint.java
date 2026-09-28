package androidx.constraintlayout.core.dsl;

import android.support.v4.media.b;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Constraint {
    public static final int q;

    /* renamed from: a, reason: collision with root package name */
    public final String f1721a;

    /* renamed from: b, reason: collision with root package name */
    public final HAnchor f1722b = new HAnchor(this, HSide.f1739a);

    /* renamed from: c, reason: collision with root package name */
    public final HAnchor f1723c = new HAnchor(this, HSide.f1740b);

    /* renamed from: d, reason: collision with root package name */
    public final VAnchor f1724d = new VAnchor(this, VSide.f1752a);

    /* renamed from: e, reason: collision with root package name */
    public final VAnchor f1725e = new VAnchor(this, VSide.f1753b);

    /* renamed from: f, reason: collision with root package name */
    public final HAnchor f1726f = new HAnchor(this, HSide.f1741c);

    /* renamed from: g, reason: collision with root package name */
    public final HAnchor f1727g = new HAnchor(this, HSide.f1742d);

    /* renamed from: h, reason: collision with root package name */
    public final VAnchor f1728h = new VAnchor(this, VSide.f1754c);

    /* renamed from: i, reason: collision with root package name */
    public final int f1729i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1730j;

    /* renamed from: k, reason: collision with root package name */
    public final float f1731k;

    /* renamed from: l, reason: collision with root package name */
    public final float f1732l;

    /* renamed from: m, reason: collision with root package name */
    public final float f1733m;
    public final float n;
    public final float o;
    public final float p;

    public class Anchor {
        public final String toString() {
            return b.C("[", "]");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Behaviour {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Behaviour[] f1734a = {new Behaviour("SPREAD", 0), new Behaviour("WRAP", 1), new Behaviour("PERCENT", 2), new Behaviour("RATIO", 3), new Behaviour("RESOLVED", 4)};

        /* JADX INFO: Fake field, exist only in values array */
        Behaviour EF5;

        public static Behaviour valueOf(String str) {
            return (Behaviour) Enum.valueOf(Behaviour.class, str);
        }

        public static Behaviour[] values() {
            return (Behaviour[]) f1734a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ChainMode {

        /* renamed from: a, reason: collision with root package name */
        public static final ChainMode f1735a;

        /* renamed from: b, reason: collision with root package name */
        public static final ChainMode f1736b;

        /* renamed from: c, reason: collision with root package name */
        public static final ChainMode f1737c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ ChainMode[] f1738d;

        static {
            ChainMode chainMode = new ChainMode("SPREAD", 0);
            f1735a = chainMode;
            ChainMode chainMode2 = new ChainMode("SPREAD_INSIDE", 1);
            f1736b = chainMode2;
            ChainMode chainMode3 = new ChainMode("PACKED", 2);
            f1737c = chainMode3;
            f1738d = new ChainMode[]{chainMode, chainMode2, chainMode3};
        }

        public static ChainMode valueOf(String str) {
            return (ChainMode) Enum.valueOf(ChainMode.class, str);
        }

        public static ChainMode[] values() {
            return (ChainMode[]) f1738d.clone();
        }
    }

    public class HAnchor extends Anchor {
        public HAnchor(Constraint constraint, HSide hSide) {
            Side.valueOf(hSide.name());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class HSide {

        /* renamed from: a, reason: collision with root package name */
        public static final HSide f1739a;

        /* renamed from: b, reason: collision with root package name */
        public static final HSide f1740b;

        /* renamed from: c, reason: collision with root package name */
        public static final HSide f1741c;

        /* renamed from: d, reason: collision with root package name */
        public static final HSide f1742d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ HSide[] f1743e;

        static {
            HSide hSide = new HSide("LEFT", 0);
            f1739a = hSide;
            HSide hSide2 = new HSide("RIGHT", 1);
            f1740b = hSide2;
            HSide hSide3 = new HSide("START", 2);
            f1741c = hSide3;
            HSide hSide4 = new HSide("END", 3);
            f1742d = hSide4;
            f1743e = new HSide[]{hSide, hSide2, hSide3, hSide4};
        }

        public static HSide valueOf(String str) {
            return (HSide) Enum.valueOf(HSide.class, str);
        }

        public static HSide[] values() {
            return (HSide[]) f1743e.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Side {

        /* renamed from: a, reason: collision with root package name */
        public static final Side f1744a;

        /* renamed from: b, reason: collision with root package name */
        public static final Side f1745b;

        /* renamed from: c, reason: collision with root package name */
        public static final Side f1746c;

        /* renamed from: d, reason: collision with root package name */
        public static final Side f1747d;

        /* renamed from: e, reason: collision with root package name */
        public static final Side f1748e;

        /* renamed from: f, reason: collision with root package name */
        public static final Side f1749f;

        /* renamed from: g, reason: collision with root package name */
        public static final Side f1750g;

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ Side[] f1751h;

        static {
            Side side = new Side("LEFT", 0);
            f1744a = side;
            Side side2 = new Side("RIGHT", 1);
            f1745b = side2;
            Side side3 = new Side("TOP", 2);
            f1746c = side3;
            Side side4 = new Side("BOTTOM", 3);
            f1747d = side4;
            Side side5 = new Side("START", 4);
            f1748e = side5;
            Side side6 = new Side("END", 5);
            f1749f = side6;
            Side side7 = new Side("BASELINE", 6);
            f1750g = side7;
            f1751h = new Side[]{side, side2, side3, side4, side5, side6, side7};
        }

        public static Side valueOf(String str) {
            return (Side) Enum.valueOf(Side.class, str);
        }

        public static Side[] values() {
            return (Side[]) f1751h.clone();
        }
    }

    public class VAnchor extends Anchor {
        public VAnchor(Constraint constraint, VSide vSide) {
            Side.valueOf(vSide.name());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class VSide {

        /* renamed from: a, reason: collision with root package name */
        public static final VSide f1752a;

        /* renamed from: b, reason: collision with root package name */
        public static final VSide f1753b;

        /* renamed from: c, reason: collision with root package name */
        public static final VSide f1754c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ VSide[] f1755d;

        static {
            VSide vSide = new VSide("TOP", 0);
            f1752a = vSide;
            VSide vSide2 = new VSide("BOTTOM", 1);
            f1753b = vSide2;
            VSide vSide3 = new VSide("BASELINE", 2);
            f1754c = vSide3;
            f1755d = new VSide[]{vSide, vSide2, vSide3};
        }

        public static VSide valueOf(String str) {
            return (VSide) Enum.valueOf(VSide.class, str);
        }

        public static VSide[] values() {
            return (VSide[]) f1755d.clone();
        }
    }

    static {
        new Constraint();
        q = Integer.MIN_VALUE;
        HashMap map = new HashMap();
        map.put(ChainMode.f1735a, "spread");
        map.put(ChainMode.f1736b, "spread_inside");
        map.put(ChainMode.f1737c, "packed");
    }

    public Constraint() {
        int i2 = q;
        this.f1729i = i2;
        this.f1730j = i2;
        this.f1731k = Float.NaN;
        this.f1732l = Float.NaN;
        this.f1733m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.f1721a = "parent";
    }

    public static void a(StringBuilder sb, String str, float f2) {
        if (Float.isNaN(f2)) {
            return;
        }
        sb.append(str);
        sb.append(":");
        sb.append(f2);
        sb.append(",\n");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(b.r(new StringBuilder(), this.f1721a, ":{\n"));
        this.f1722b.getClass();
        this.f1723c.getClass();
        this.f1724d.getClass();
        this.f1725e.getClass();
        this.f1726f.getClass();
        this.f1727g.getClass();
        this.f1728h.getClass();
        int i2 = this.f1729i;
        int i3 = q;
        if (i2 != i3) {
            sb.append("width:");
            sb.append(i2);
            sb.append(",\n");
        }
        int i4 = this.f1730j;
        if (i4 != i3) {
            sb.append("height:");
            sb.append(i4);
            sb.append(",\n");
        }
        a(sb, "horizontalBias", this.f1731k);
        a(sb, "verticalBias", this.f1732l);
        a(sb, "verticalWeight", this.f1733m);
        a(sb, "horizontalWeight", this.n);
        float f2 = this.o;
        if (!Double.isNaN(f2)) {
            sb.append("width:'");
            sb.append((int) f2);
            sb.append("%',\n");
        }
        float f3 = this.p;
        if (!Double.isNaN(f3)) {
            sb.append("height:'");
            sb.append((int) f3);
            sb.append("%',\n");
        }
        sb.append("},\n");
        return sb.toString();
    }
}
