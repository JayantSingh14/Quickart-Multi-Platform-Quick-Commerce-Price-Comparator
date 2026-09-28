package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ConversionRuleAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        String value = attributesImpl.getValue("conversionWord");
        String value2 = attributesImpl.getValue("converterClass");
        if (OptionHelper.b(value)) {
            l1("No 'conversionWord' attribute in <conversionRule>");
            return;
        }
        if (OptionHelper.b(value2)) {
            interpretationContext.l1("No 'converterClass' attribute in <conversionRule>");
            return;
        }
        try {
            Map map = (Map) this.f13733b.n0("PATTERN_RULE_REGISTRY");
            if (map == null) {
                map = new HashMap();
                this.f13733b.O(map, "PATTERN_RULE_REGISTRY");
            }
            s1("registering conversion word " + value + " with class [" + value2 + "]");
            map.put(value, value2);
        } catch (Exception unused) {
            l1("Could not add conversion rule to PatternLayout.");
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
