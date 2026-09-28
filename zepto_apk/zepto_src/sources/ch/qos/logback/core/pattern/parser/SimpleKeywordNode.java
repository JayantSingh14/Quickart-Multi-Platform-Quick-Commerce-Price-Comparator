package ch.qos.logback.core.pattern.parser;

import java.util.List;

/* loaded from: classes3.dex */
public class SimpleKeywordNode extends FormattingNode {

    /* renamed from: e, reason: collision with root package name */
    public List f13683e;

    @Override // ch.qos.logback.core.pattern.parser.FormattingNode, ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof SimpleKeywordNode)) {
            return false;
        }
        List list = this.f13683e;
        List list2 = ((SimpleKeywordNode) obj).f13683e;
        return list != null ? list.equals(list2) : list2 == null;
    }

    @Override // ch.qos.logback.core.pattern.parser.Node
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List list = this.f13683e;
        Object obj = this.f13672b;
        if (list == null) {
            sb.append("KeyWord(" + obj + "," + this.f13670d + ")");
        } else {
            sb.append("KeyWord(" + obj + ", " + this.f13670d + "," + this.f13683e + ")");
        }
        sb.append(a());
        return sb.toString();
    }
}
