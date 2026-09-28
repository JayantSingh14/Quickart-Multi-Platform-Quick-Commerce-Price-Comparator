package ch.qos.logback.classic.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.jmx.JMXConfigurator;
import ch.qos.logback.classic.jmx.MBeanUtil;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class JMXConfiguratorAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        s1("begin");
        String name = this.f13733b.getName();
        String value = attributesImpl.getValue("contextName");
        if (!OptionHelper.b(value)) {
            name = value;
        }
        String value2 = attributesImpl.getValue("objectName");
        if (OptionHelper.b(value2)) {
            StringBuilder sbY = b.y("ch.qos.logback.classic:Name=", name, ",Type=");
            sbY.append(JMXConfigurator.class.getName());
            value2 = sbY.toString();
        }
        ObjectName objectNameB = MBeanUtil.b(this.f13733b, this, value2);
        if (objectNameB == null) {
            l1("Failed construct ObjectName for [" + value2 + "]");
            return;
        }
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        if (MBeanUtil.a(platformMBeanServer, objectNameB)) {
            return;
        }
        try {
            platformMBeanServer.registerMBean(new JMXConfigurator((LoggerContext) this.f13733b, platformMBeanServer, objectNameB), objectNameB);
        } catch (Exception e2) {
            o1("Failed to create mbean", e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
