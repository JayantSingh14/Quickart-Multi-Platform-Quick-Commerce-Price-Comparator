package ch.qos.logback.core.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.core.hook.ShutdownHookBase;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ShutdownHookAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public ShutdownHookBase f13524d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13525e;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws ActionException {
        this.f13524d = null;
        this.f13525e = false;
        String value = attributesImpl.getValue("class");
        if (OptionHelper.b(value)) {
            StringBuilder sbY = b.y("Missing class name for shutdown hook. Near [", str, "] line ");
            sbY.append(Action.X1(interpretationContext));
            l1(sbY.toString());
            this.f13525e = true;
            return;
        }
        try {
            s1("About to instantiate shutdown hook of type [" + value + "]");
            ShutdownHookBase shutdownHookBase = (ShutdownHookBase) OptionHelper.a(value, ShutdownHookBase.class, this.f13733b);
            this.f13524d = shutdownHookBase;
            shutdownHookBase.V(this.f13733b);
            interpretationContext.W1(this.f13524d);
        } catch (Exception e2) {
            this.f13525e = true;
            o1("Could not create a shutdown hook of type [" + value + "].", e2);
            throw new ActionException(e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13525e) {
            return;
        }
        if (interpretationContext.f13562d.peek() != this.f13524d) {
            J1("The object at the of the stack is not the hook pushed earlier.");
            return;
        }
        interpretationContext.V1();
        Thread thread = new Thread(this.f13524d, "Logback shutdown hook [" + this.f13733b.getName() + "]");
        this.f13733b.O(thread, "SHUTDOWN_HOOK");
        Runtime.getRuntime().addShutdownHook(thread);
    }
}
