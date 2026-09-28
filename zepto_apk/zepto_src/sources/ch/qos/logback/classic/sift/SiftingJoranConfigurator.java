package ch.qos.logback.classic.sift;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.util.DefaultNestedComponentRules;
import ch.qos.logback.core.joran.action.AppenderAction;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import ch.qos.logback.core.sift.SiftingJoranConfiguratorBase;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class SiftingJoranConfigurator extends SiftingJoranConfiguratorBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public final void T1(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        DefaultNestedComponentRules.a(defaultNestedComponentRegistry);
    }

    @Override // ch.qos.logback.core.sift.SiftingJoranConfiguratorBase, ch.qos.logback.core.joran.GenericConfigurator
    public final void V1(SimpleRuleStore simpleRuleStore) {
        super.V1(simpleRuleStore);
        simpleRuleStore.T1(new ElementSelector("configuration/appender"), new AppenderAction());
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public final void W1() {
        super.W1();
        this.f13494e.f13570b.f13563e.put("APPENDER_BAG", new HashMap());
        HashMap map = new HashMap();
        map.putAll(null);
        map.put(null, null);
        this.f13494e.f13570b.f13564f = map;
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public final ElementPath c2() {
        return new ElementPath(CLConstants.INPUT_CONFIGURATION);
    }
}
