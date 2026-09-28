package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class RootLoggerAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public Logger f13288d;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        this.f13288d = ((LoggerContext) this.f13733b).c("ROOT");
        String strX1 = interpretationContext.X1(attributesImpl.getValue("level"));
        if (!OptionHelper.b(strX1)) {
            Level levelA = Level.a(strX1);
            s1("Setting level of ROOT logger to " + levelA);
            this.f13288d.E(levelA);
        }
        interpretationContext.W1(this.f13288d);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        Object objPeek = interpretationContext.f13562d.peek();
        if (objPeek == this.f13288d) {
            interpretationContext.V1();
            return;
        }
        J1("The object on the top the of the stack is not the root logger");
        J1("It is: " + objPeek);
    }
}
