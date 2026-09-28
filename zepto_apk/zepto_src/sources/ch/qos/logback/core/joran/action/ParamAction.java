package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.util.PropertySetter;
import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import java.lang.reflect.InvocationTargetException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ParamAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public final BeanDescriptionCache f13523d;

    public ParamAction(BeanDescriptionCache beanDescriptionCache) {
        this.f13523d = beanDescriptionCache;
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String value = attributesImpl.getValue(CLConstants.FIELD_PAY_INFO_NAME);
        String value2 = attributesImpl.getValue(CLConstants.FIELD_PAY_INFO_VALUE);
        if (value == null) {
            l1("No name attribute in <param> element");
            return;
        }
        if (value2 == null) {
            l1("No value attribute in <param> element");
            return;
        }
        String strTrim = value2.trim();
        PropertySetter propertySetter = new PropertySetter(this.f13523d, interpretationContext.f13562d.peek());
        propertySetter.V(this.f13733b);
        propertySetter.b2(interpretationContext.X1(value), interpretationContext.X1(strTrim));
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
