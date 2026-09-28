package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class LoggerAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13282d = false;

    /* renamed from: e, reason: collision with root package name */
    public Logger f13283e;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        this.f13282d = false;
        this.f13283e = null;
        LoggerContext loggerContext = (LoggerContext) this.f13733b;
        String strX1 = interpretationContext.X1(attributesImpl.getValue(CLConstants.FIELD_PAY_INFO_NAME));
        if (OptionHelper.b(strX1)) {
            this.f13282d = true;
            l1("No 'name' attribute in element " + str + ", around " + Action.W1(interpretationContext));
            return;
        }
        this.f13283e = loggerContext.c(strX1);
        String strX12 = interpretationContext.X1(attributesImpl.getValue("level"));
        if (!OptionHelper.b(strX12)) {
            if ("INHERITED".equalsIgnoreCase(strX12) || "NULL".equalsIgnoreCase(strX12)) {
                s1("Setting level of logger [" + strX1 + "] to null, i.e. INHERITED");
                this.f13283e.E(null);
            } else {
                Level levelA = Level.a(strX12);
                s1("Setting level of logger [" + strX1 + "] to " + levelA);
                this.f13283e.E(levelA);
            }
        }
        String strX13 = interpretationContext.X1(attributesImpl.getValue("additivity"));
        if (!OptionHelper.b(strX13)) {
            boolean zD = OptionHelper.d(strX13, true);
            s1("Setting additivity of logger [" + strX1 + "] to " + zD);
            this.f13283e.f13248g = zD;
        }
        interpretationContext.W1(this.f13283e);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13282d) {
            return;
        }
        Object objPeek = interpretationContext.f13562d.peek();
        if (objPeek == this.f13283e) {
            interpretationContext.V1();
            return;
        }
        J1("The object on the top the of the stack is not " + this.f13283e + " pushed earlier");
        StringBuilder sb = new StringBuilder("It is: ");
        sb.append(objPeek);
        J1(sb.toString());
    }
}
