package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public abstract class AbstractEventEvaluatorAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public EventEvaluator f13495d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13496e = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        this.f13496e = false;
        this.f13495d = null;
        String value = attributesImpl.getValue("class");
        if (OptionHelper.b(value)) {
            value = Y1();
            s1("Assuming default evaluator class [" + value + "]");
        }
        if (OptionHelper.b(value)) {
            this.f13496e = true;
            l1("Mandatory \"class\" attribute not set for <evaluator>");
            return;
        }
        String value2 = attributesImpl.getValue(CLConstants.FIELD_PAY_INFO_NAME);
        if (OptionHelper.b(value2)) {
            this.f13496e = true;
            l1("Mandatory \"name\" attribute not set for <evaluator>");
            return;
        }
        try {
            EventEvaluator eventEvaluator = (EventEvaluator) OptionHelper.a(value, EventEvaluator.class, this.f13733b);
            this.f13495d = eventEvaluator;
            eventEvaluator.V(this.f13733b);
            this.f13495d.a(value2);
            interpretationContext.W1(this.f13495d);
            s1("Adding evaluator named [" + value2 + "] to the object stack");
        } catch (Exception e2) {
            this.f13496e = true;
            o1("Could not create evaluator of type " + value + "].", e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13496e) {
            return;
        }
        EventEvaluator eventEvaluator = this.f13495d;
        if (eventEvaluator != null) {
            eventEvaluator.start();
            s1("Starting evaluator named [" + this.f13495d.getName() + "]");
        }
        if (interpretationContext.f13562d.peek() != this.f13495d) {
            J1("The object on the top the of the stack is not the evaluator pushed earlier.");
            return;
        }
        interpretationContext.V1();
        try {
            Map map = (Map) this.f13733b.n0("EVALUATOR_MAP");
            if (map == null) {
                l1("Could not find EvaluatorMap");
            } else {
                map.put(this.f13495d.getName(), this.f13495d);
            }
        } catch (Exception e2) {
            o1("Could not set evaluator named [" + this.f13495d + "].", e2);
        }
    }

    public abstract String Y1();
}
