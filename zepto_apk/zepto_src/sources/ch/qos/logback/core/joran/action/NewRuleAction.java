package ch.qos.logback.core.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class NewRuleAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        Action action;
        String value = attributesImpl.getValue("pattern");
        String value2 = attributesImpl.getValue("actionClass");
        if (OptionHelper.b(value)) {
            l1("No 'pattern' attribute in <newRule>");
            return;
        }
        if (OptionHelper.b(value2)) {
            l1("No 'actionClass' attribute in <newRule>");
            return;
        }
        try {
            s1("About to add new Joran parsing rule [" + value + "," + value2 + "].");
            SimpleRuleStore simpleRuleStore = interpretationContext.f13565g.f13569a;
            ElementSelector elementSelector = new ElementSelector(value);
            try {
                action = (Action) OptionHelper.a(value2, Action.class, simpleRuleStore.f13733b);
            } catch (Exception e2) {
                simpleRuleStore.o1("Could not instantiate class [" + value2 + "]", e2);
                action = null;
            }
            if (action != null) {
                simpleRuleStore.T1(elementSelector, action);
            }
        } catch (Exception unused) {
            l1(b.m("Could not add new Joran parsing rule [", value, ",", value2, "]"));
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
