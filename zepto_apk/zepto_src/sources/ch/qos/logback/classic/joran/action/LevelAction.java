package ch.qos.logback.classic.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class LevelAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        Object objPeek = interpretationContext.f13562d.peek();
        if (!(objPeek instanceof Logger)) {
            l1("For element <level>, could not find a logger at the top of execution stack.");
            return;
        }
        Logger logger = (Logger) objPeek;
        String str2 = logger.f13242a;
        String strX1 = interpretationContext.X1(attributesImpl.getValue(CLConstants.FIELD_PAY_INFO_VALUE));
        if ("INHERITED".equalsIgnoreCase(strX1) || "NULL".equalsIgnoreCase(strX1)) {
            logger.E(null);
        } else {
            logger.E(Level.a(strX1));
        }
        StringBuilder sbX = b.x(str2, " level set to ");
        sbX.append(logger.f13243b);
        s1(sbX.toString());
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
