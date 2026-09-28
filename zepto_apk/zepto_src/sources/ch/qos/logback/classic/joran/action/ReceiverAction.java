package ch.qos.logback.classic.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.classic.net.ReceiverBase;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ReceiverAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public ReceiverBase f13286d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13287e;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws ActionException {
        String value = attributesImpl.getValue("class");
        if (OptionHelper.b(value)) {
            StringBuilder sbY = b.y("Missing class name for receiver. Near [", str, "] line ");
            sbY.append(Action.X1(interpretationContext));
            l1(sbY.toString());
            this.f13287e = true;
            return;
        }
        try {
            s1("About to instantiate receiver of type [" + value + "]");
            ReceiverBase receiverBase = (ReceiverBase) OptionHelper.a(value, ReceiverBase.class, this.f13733b);
            this.f13286d = receiverBase;
            receiverBase.V(this.f13733b);
            interpretationContext.W1(this.f13286d);
        } catch (Exception e2) {
            this.f13287e = true;
            o1("Could not create a receiver of type [" + value + "].", e2);
            throw new ActionException(e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13287e) {
            return;
        }
        interpretationContext.f13733b.N(this.f13286d);
        this.f13286d.start();
        if (interpretationContext.f13562d.peek() != this.f13286d) {
            J1("The object at the of the stack is not the remote pushed earlier.");
        } else {
            interpretationContext.V1();
        }
    }
}
