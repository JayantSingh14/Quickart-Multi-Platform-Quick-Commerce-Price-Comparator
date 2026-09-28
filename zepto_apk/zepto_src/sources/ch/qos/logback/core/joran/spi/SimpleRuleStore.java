package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class SimpleRuleStore extends ContextAwareBase implements RuleStore {

    /* renamed from: d, reason: collision with root package name */
    public HashMap f13578d;

    public final void T1(ElementSelector elementSelector, Action action) {
        action.V(this.f13733b);
        HashMap map = this.f13578d;
        List arrayList = (List) map.get(elementSelector);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(elementSelector, arrayList);
        }
        arrayList.add(action);
    }

    public final String toString() {
        return "SimpleRuleStore ( rules = " + this.f13578d + "   )";
    }
}
