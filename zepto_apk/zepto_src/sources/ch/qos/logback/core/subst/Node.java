package ch.qos.logback.core.subst;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
public class Node {

    /* renamed from: a, reason: collision with root package name */
    public final Type f13755a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13756b;

    /* renamed from: c, reason: collision with root package name */
    public Node f13757c;

    /* renamed from: d, reason: collision with root package name */
    public Node f13758d;

    /* renamed from: ch.qos.logback.core.subst.Node$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13759a;

        static {
            int[] iArr = new int[Type.values().length];
            f13759a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13759a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f13760a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f13761b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Type[] f13762c;

        static {
            Type type = new Type("LITERAL", 0);
            f13760a = type;
            Type type2 = new Type("VARIABLE", 1);
            f13761b = type2;
            f13762c = new Type[]{type, type2};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f13762c.clone();
        }
    }

    public Node(Type type, Object obj) {
        this.f13755a = type;
        this.f13756b = obj;
    }

    public static void a(Node node, StringBuilder sb) {
        while (node != null) {
            sb.append(node.toString());
            sb.append(" --> ");
            node = node.f13758d;
        }
        sb.append("null ");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        if (this.f13755a != node.f13755a) {
            return false;
        }
        Object obj2 = node.f13756b;
        Object obj3 = this.f13756b;
        if (obj3 != null) {
            if (!obj3.equals(obj2)) {
                return false;
            }
        } else if (obj2 != null) {
            return false;
        }
        Node node2 = this.f13757c;
        if (node2 != null) {
            if (!node2.equals(node.f13757c)) {
                return false;
            }
        } else if (node.f13757c != null) {
            return false;
        }
        Node node3 = this.f13758d;
        Node node4 = node.f13758d;
        return node3 != null ? node3.equals(node4) : node4 == null;
    }

    public final int hashCode() {
        int iHashCode = this.f13755a.hashCode() * 31;
        Object obj = this.f13756b;
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Node node = this.f13757c;
        int iHashCode3 = (iHashCode2 + (node != null ? node.hashCode() : 0)) * 31;
        Node node2 = this.f13758d;
        return iHashCode3 + (node2 != null ? node2.hashCode() : 0);
    }

    public final String toString() {
        Type type = this.f13755a;
        int iOrdinal = type.ordinal();
        Object obj = this.f13756b;
        if (iOrdinal == 0) {
            return "Node{type=" + type + ", payload='" + obj + "'}";
        }
        if (iOrdinal != 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Node node = this.f13757c;
        if (node != null) {
            a(node, sb2);
        }
        a((Node) obj, sb);
        String string = "Node{type=" + type + ", payload='" + sb.toString() + "'";
        if (this.f13757c != null) {
            StringBuilder sbX = b.x(string, ", defaultPart=");
            sbX.append(sb2.toString());
            string = sbX.toString();
        }
        return string + '}';
    }
}
