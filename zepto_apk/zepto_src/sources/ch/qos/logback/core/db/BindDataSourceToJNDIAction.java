package ch.qos.logback.core.db;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.util.PropertySetter;
import ch.qos.logback.core.util.OptionHelper;
import in.juspay.hyper.constants.LogSubCategory;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class BindDataSourceToJNDIAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        String strB = interpretationContext.b("dataSourceClass");
        if (OptionHelper.b(strB)) {
            J1("dsClassName is a required parameter");
            interpretationContext.l1("dsClassName is a required parameter");
            return;
        }
        String strB2 = interpretationContext.b("url");
        String strB3 = interpretationContext.b(LogSubCategory.Action.USER);
        String strB4 = interpretationContext.b("password");
        try {
            DataSource dataSource = (DataSource) OptionHelper.a(strB, DataSource.class, this.f13733b);
            PropertySetter propertySetter = new PropertySetter(null, dataSource);
            propertySetter.V(this.f13733b);
            if (!OptionHelper.b(strB2)) {
                propertySetter.b2("url", strB2);
            }
            if (!OptionHelper.b(strB3)) {
                propertySetter.b2(LogSubCategory.Action.USER, strB3);
            }
            if (!OptionHelper.b(strB4)) {
                propertySetter.b2("password", strB4);
            }
            new InitialContext().rebind("dataSource", dataSource);
        } catch (Exception e2) {
            o1("Could not bind  datasource. Reported error follows.", e2);
            interpretationContext.l1("Could not not bind  datasource of type [" + strB + "].");
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
