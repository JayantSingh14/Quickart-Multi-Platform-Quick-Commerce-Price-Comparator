package ch.qos.logback.core.layout;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;

/* loaded from: classes3.dex */
public class EchoLayout<E> extends LayoutBase<E> {
    @Override // ch.qos.logback.core.Layout
    public final String c1(Object obj) {
        return obj + CoreConstants.f13442a;
    }
}
