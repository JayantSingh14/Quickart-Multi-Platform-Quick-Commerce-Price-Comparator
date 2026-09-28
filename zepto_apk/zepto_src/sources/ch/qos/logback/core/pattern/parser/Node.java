package ch.qos.logback.core.pattern.parser;

/* loaded from: classes3.dex */
public class Node {

    /* renamed from: a, reason: collision with root package name */
    public final int f13671a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13672b;

    /* renamed from: c, reason: collision with root package name */
    public Node f13673c;

    public Node(int i2, Object obj) {
        this.f13671a = i2;
        this.f13672b = obj;
    }

    public final String a() {
        if (this.f13673c == null) {
            return "";
        }
        return " -> " + this.f13673c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node node = (Node) obj;
        if (this.f13671a != node.f13671a) {
            return false;
        }
        Object obj2 = node.f13672b;
        Object obj3 = this.f13672b;
        if (obj3 != null) {
            if (!obj3.equals(obj2)) {
                return false;
            }
        } else if (obj2 != null) {
            return false;
        }
        Node node2 = this.f13673c;
        Node node3 = node.f13673c;
        return node2 != null ? node2.equals(node3) : node3 == null;
    }

    public int hashCode() {
        int i2 = this.f13671a * 31;
        Object obj = this.f13672b;
        return i2 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f13671a != 0) {
            sb.append(super.toString());
        } else {
            sb.append("LITERAL(" + this.f13672b + ")");
        }
        sb.append(a());
        return sb.toString();
    }
}
