package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.EventPlayer;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.EnvUtil;
import ch.qos.logback.core.util.OptionHelper;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class IfAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public final Stack f13530d = new Stack();

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        Condition conditionT1;
        IfState ifState = new IfState();
        Stack stack = this.f13530d;
        boolean zIsEmpty = stack.isEmpty();
        stack.push(ifState);
        if (zIsEmpty) {
            interpretationContext.W1(this);
            try {
                if (EnvUtil.class.getClassLoader().loadClass("org.codehaus.janino.ScriptEvaluator") != null) {
                    ifState.f13534d = true;
                    String value = attributesImpl.getValue("condition");
                    if (OptionHelper.b(value)) {
                        return;
                    }
                    String strC = OptionHelper.c(value, interpretationContext, this.f13733b);
                    PropertyEvalScriptBuilder propertyEvalScriptBuilder = new PropertyEvalScriptBuilder(interpretationContext);
                    propertyEvalScriptBuilder.V(this.f13733b);
                    try {
                        conditionT1 = propertyEvalScriptBuilder.T1(strC);
                    } catch (Exception e2) {
                        o1("Failed to parse condition [" + strC + "]", e2);
                        conditionT1 = null;
                    }
                    if (conditionT1 != null) {
                        ifState.f13531a = Boolean.valueOf(conditionT1.a());
                        return;
                    }
                    return;
                }
            } catch (ClassNotFoundException unused) {
            }
            l1("Could not find Janino library on the class path. Skipping conditional processing.");
            l1("See also http://logback.qos.ch/codes.html#ifJanino");
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        IfState ifState = (IfState) this.f13530d.pop();
        if (ifState.f13534d) {
            Object objPeek = interpretationContext.f13562d.peek();
            if (objPeek == null) {
                throw new IllegalStateException("Unexpected null object on stack");
            }
            if (!(objPeek instanceof IfAction)) {
                throw new IllegalStateException("Unexpected object of type [" + objPeek.getClass() + "] on stack");
            }
            if (objPeek != this) {
                throw new IllegalStateException("IfAction different then current one on stack");
            }
            interpretationContext.V1();
            Boolean bool = ifState.f13531a;
            if (bool == null) {
                l1("Failed to determine \"if then else\" result");
                return;
            }
            ArrayList arrayList = ifState.f13532b;
            if (!bool.booleanValue()) {
                arrayList = ifState.f13533c;
            }
            if (arrayList != null) {
                EventPlayer eventPlayer = interpretationContext.f13565g.f13575g;
                eventPlayer.f13558b.addAll(eventPlayer.f13559c + 1, arrayList);
            }
        }
    }
}
