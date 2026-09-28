package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.util.JNDIUtil;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.action.ActionUtil;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import javax.naming.NamingException;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class InsertFromJNDIAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        int i2;
        String strX1 = interpretationContext.X1(attributesImpl.getValue("env-entry-name"));
        String strX12 = interpretationContext.X1(attributesImpl.getValue("as"));
        ActionUtil.Scope scopeB = ActionUtil.b(attributesImpl.getValue(AuthorizationResponseParser.SCOPE));
        if (OptionHelper.b(strX1)) {
            l1("[env-entry-name] missing, around " + Action.W1(interpretationContext));
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (OptionHelper.b(strX12)) {
            l1("[as] missing, around " + Action.W1(interpretationContext));
            i2++;
        }
        if (i2 != 0) {
            return;
        }
        try {
            String strB = JNDIUtil.b(JNDIUtil.a(), strX1);
            if (OptionHelper.b(strB)) {
                l1("[" + strX1 + "] has null or empty value");
                return;
            }
            s1("Setting variable [" + strX12 + "] to [" + strB + "] in [" + scopeB + "] scope");
            ActionUtil.a(interpretationContext, strX12, strB, scopeB);
        } catch (NamingException unused) {
            l1("Failed to lookup JNDI env-entry [" + strX1 + "]");
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
