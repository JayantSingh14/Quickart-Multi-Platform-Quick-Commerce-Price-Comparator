package ch.qos.logback.core.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.AppenderAttachable;
import ch.qos.logback.core.util.OptionHelper;
import java.util.HashMap;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class AppenderRefAction<E> extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        Object objPeek = interpretationContext.f13562d.peek();
        if (!(objPeek instanceof AppenderAttachable)) {
            StringBuilder sbY = b.y("Could not find an AppenderAttachable at the top of execution stack. Near [", str, "] line ");
            sbY.append(Action.X1(interpretationContext));
            l1(sbY.toString());
            return;
        }
        AppenderAttachable appenderAttachable = (AppenderAttachable) objPeek;
        String strX1 = interpretationContext.X1(attributesImpl.getValue("ref"));
        if (OptionHelper.b(strX1)) {
            l1("Missing appender ref attribute in <appender-ref> tag.");
            return;
        }
        Appender appender = (Appender) ((HashMap) interpretationContext.f13563e.get("APPENDER_BAG")).get(strX1);
        if (appender == null) {
            l1("Could not find an appender named [" + strX1 + "]. Did you define it below instead of above in the configuration file?");
            l1("See http://logback.qos.ch/codes.html#appender_order for more details.");
            return;
        }
        s1("Attaching appender named [" + strX1 + "] to " + appenderAttachable);
        appenderAttachable.r0(appender);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
