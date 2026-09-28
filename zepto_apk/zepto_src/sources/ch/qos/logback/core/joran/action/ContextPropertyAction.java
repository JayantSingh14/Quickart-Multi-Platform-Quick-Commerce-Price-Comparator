package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ContextPropertyAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        l1("The [contextProperty] element has been removed. Please use [substitutionProperty] element instead");
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
