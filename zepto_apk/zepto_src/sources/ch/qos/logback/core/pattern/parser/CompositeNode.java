package ch.qos.logback.core.pattern.parser;

/* loaded from: classes3.dex */
public class CompositeNode extends SimpleKeywordNode {

    /* renamed from: f, reason: collision with root package name */
    public Node f13669f;

    @Override // ch.qos.logback.core.pattern.parser.SimpleKeywordNode, ch.qos.logback.core.pattern.parser.FormattingNode, ch.qos.logback.core.pattern.parser.Node
    public final boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof CompositeNode)) {
            return false;
        }
        Node node = this.f13669f;
        Node node2 = ((CompositeNode) obj).f13669f;
        return node != null ? node.equals(node2) : node2 == null;
    }

    @Override // ch.qos.logback.core.pattern.parser.SimpleKeywordNode, ch.qos.logback.core.pattern.parser.Node
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f13669f != null) {
            sb.append("CompositeNode(" + this.f13669f + ")");
        } else {
            sb.append("CompositeNode(no child)");
        }
        sb.append(a());
        return sb.toString();
    }
}
