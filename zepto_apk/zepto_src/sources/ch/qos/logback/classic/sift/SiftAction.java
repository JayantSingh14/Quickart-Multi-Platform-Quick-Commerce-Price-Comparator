package ch.qos.logback.classic.sift;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.event.InPlayListener;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class SiftAction extends Action implements InPlayListener {

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f13338d;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        this.f13338d = new ArrayList();
        interpretationContext.T1(this);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        interpretationContext.f13566h.remove(this);
        Object objPeek = interpretationContext.f13562d.peek();
        if (objPeek instanceof SiftingAppender) {
            HashMap map = new HashMap(interpretationContext.f13564f);
            ArrayList arrayList = this.f13338d;
            ((SiftingAppender) objPeek).getClass();
            new AppenderFactoryUsingJoran(arrayList, map);
        }
    }

    @Override // ch.qos.logback.core.joran.event.InPlayListener
    public final void x(SaxEvent saxEvent) {
        this.f13338d.add(saxEvent);
    }
}
