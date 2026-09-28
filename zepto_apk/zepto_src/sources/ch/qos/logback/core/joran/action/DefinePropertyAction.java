package ch.qos.logback.core.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.spi.PropertyDefiner;
import ch.qos.logback.core.util.OptionHelper;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class DefinePropertyAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public String f13504d;

    /* renamed from: e, reason: collision with root package name */
    public PropertyDefiner f13505e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13506f;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws ActionException {
        this.f13504d = null;
        this.f13505e = null;
        this.f13506f = false;
        this.f13504d = attributesImpl.getValue(CLConstants.FIELD_PAY_INFO_NAME);
        ActionUtil.b(attributesImpl.getValue(AuthorizationResponseParser.SCOPE));
        if (OptionHelper.b(this.f13504d)) {
            StringBuilder sbY = b.y("Missing property name for property definer. Near [", str, "] line ");
            sbY.append(Action.X1(interpretationContext));
            l1(sbY.toString());
            this.f13506f = true;
            return;
        }
        String value = attributesImpl.getValue("class");
        if (OptionHelper.b(value)) {
            StringBuilder sbY2 = b.y("Missing class name for property definer. Near [", str, "] line ");
            sbY2.append(Action.X1(interpretationContext));
            l1(sbY2.toString());
            this.f13506f = true;
            return;
        }
        try {
            s1("About to instantiate property definer of type [" + value + "]");
            PropertyDefiner propertyDefiner = (PropertyDefiner) OptionHelper.a(value, PropertyDefiner.class, this.f13733b);
            this.f13505e = propertyDefiner;
            propertyDefiner.V(this.f13733b);
            PropertyDefiner propertyDefiner2 = this.f13505e;
            if (propertyDefiner2 instanceof LifeCycle) {
                ((LifeCycle) propertyDefiner2).start();
            }
            interpretationContext.W1(this.f13505e);
        } catch (Exception e2) {
            this.f13506f = true;
            o1("Could not create an PropertyDefiner of type [" + value + "].", e2);
            throw new ActionException(e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13506f) {
            return;
        }
        if (interpretationContext.f13562d.peek() != this.f13505e) {
            J1("The object at the of the stack is not the property definer for property named [" + this.f13504d + "] pushed earlier.");
            return;
        }
        s1("Popping property definer for property named [" + this.f13504d + "] from the object stack");
        interpretationContext.V1();
        this.f13505e.y0();
    }
}
