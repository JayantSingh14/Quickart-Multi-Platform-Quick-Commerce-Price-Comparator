package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.FormatInfo;

/* loaded from: classes3.dex */
public class FormattingNode extends Node {

    /* renamed from: d, reason: collision with root package name */
    public FormatInfo f13670d;

    @Override // ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof FormattingNode)) {
            return false;
        }
        FormatInfo formatInfo = this.f13670d;
        FormatInfo formatInfo2 = ((FormattingNode) obj).f13670d;
        return formatInfo != null ? formatInfo.equals(formatInfo2) : formatInfo2 == null;
    }

    @Override // ch.qos.logback.core.pattern.parser.Node
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        FormatInfo formatInfo = this.f13670d;
        return iHashCode + (formatInfo != null ? formatInfo.hashCode() : 0);
    }
}
