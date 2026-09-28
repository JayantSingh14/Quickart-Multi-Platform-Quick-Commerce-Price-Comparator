package ch.qos.logback.core.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class AppenderAction<E> extends Action {

    /* renamed from: d, reason: collision with root package name */
    public Appender f13502d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13503e = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws ActionException {
        this.f13502d = null;
        this.f13503e = false;
        String value = attributesImpl.getValue("class");
        if (OptionHelper.b(value)) {
            StringBuilder sbY = b.y("Missing class name for appender. Near [", str, "] line ");
            sbY.append(Action.X1(interpretationContext));
            l1(sbY.toString());
            this.f13503e = true;
            return;
        }
        try {
            s1("About to instantiate appender of type [" + value + "]");
            Appender appender = (Appender) OptionHelper.a(value, Appender.class, this.f13733b);
            this.f13502d = appender;
            appender.V(this.f13733b);
            String strX1 = interpretationContext.X1(attributesImpl.getValue(CLConstants.FIELD_PAY_INFO_NAME));
            if (OptionHelper.b(strX1)) {
                J1("No appender name given for appender of type " + value + "].");
            } else {
                this.f13502d.a(strX1);
                s1("Naming appender as [" + strX1 + "]");
            }
            ((HashMap) interpretationContext.f13563e.get("APPENDER_BAG")).put(strX1, this.f13502d);
            interpretationContext.W1(this.f13502d);
        } catch (Exception e2) {
            this.f13503e = true;
            o1("Could not create an Appender of type [" + value + "].", e2);
            throw new ActionException(e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13503e) {
            return;
        }
        Appender appender = this.f13502d;
        if (appender != null) {
            appender.start();
        }
        if (interpretationContext.f13562d.peek() == this.f13502d) {
            interpretationContext.V1();
            return;
        }
        J1("The object at the of the stack is not the appender named [" + this.f13502d.getName() + "] pushed earlier.");
    }
}
