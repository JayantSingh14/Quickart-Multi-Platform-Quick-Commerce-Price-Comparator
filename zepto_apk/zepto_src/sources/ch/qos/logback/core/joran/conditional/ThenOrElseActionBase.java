package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public abstract class ThenOrElseActionBase extends Action {

    /* renamed from: d, reason: collision with root package name */
    public final Stack f13538d = new Stack();

    public static boolean Z1(InterpretationContext interpretationContext) {
        Stack stack;
        Object objPeek = interpretationContext.f13562d.peek();
        if (!(objPeek instanceof IfAction) || (stack = ((IfAction) objPeek).f13530d) == null || stack.isEmpty()) {
            return false;
        }
        return ((IfState) stack.peek()).f13534d;
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        if (Z1(interpretationContext)) {
            ThenActionState thenActionState = new ThenActionState();
            thenActionState.f13536a = new ArrayList();
            thenActionState.f13537b = false;
            if (interpretationContext.f13566h.isEmpty()) {
                interpretationContext.T1(thenActionState);
                thenActionState.f13537b = true;
            }
            this.f13538d.push(thenActionState);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (Z1(interpretationContext)) {
            ThenActionState thenActionState = (ThenActionState) this.f13538d.pop();
            if (thenActionState.f13537b) {
                interpretationContext.f13566h.remove(thenActionState);
                Object objPeek = interpretationContext.f13562d.peek();
                if (!(objPeek instanceof IfAction)) {
                    throw new IllegalStateException("Missing IfAction on top of stack");
                }
                ArrayList arrayList = thenActionState.f13536a;
                arrayList.remove(0);
                arrayList.remove(arrayList.size() - 1);
                Y1((IfAction) objPeek, arrayList);
            }
        }
    }

    public abstract void Y1(IfAction ifAction, ArrayList arrayList);
}
