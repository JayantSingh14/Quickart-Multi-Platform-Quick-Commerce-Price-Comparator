package ch.qos.logback.classic.joran.action;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ContextNameAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void U1(InterpretationContext interpretationContext, String str) {
        String strX1 = interpretationContext.X1(str);
        s1("Setting logger context name as [" + strX1 + "]");
        try {
            this.f13733b.a(strX1);
        } catch (IllegalStateException e2) {
            o1("Failed to rename context [" + this.f13733b.getName() + "] as [" + strX1 + "]", e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
    }
}
