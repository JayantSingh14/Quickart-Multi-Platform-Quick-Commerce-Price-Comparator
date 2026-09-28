package ch.qos.logback.core.joran.action;

import androidx.fragment.app.e;
import ch.qos.logback.core.joran.action.ActionUtil;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.CachingDateFormatter;
import ch.qos.logback.core.util.OptionHelper;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class TimestampAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13529d = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        long jCurrentTimeMillis;
        String value = attributesImpl.getValue("key");
        if (OptionHelper.b(value)) {
            l1("Attribute named [key] cannot be empty");
            this.f13529d = true;
        }
        String value2 = attributesImpl.getValue("datePattern");
        if (OptionHelper.b(value2)) {
            l1("Attribute named [datePattern] cannot be empty");
            this.f13529d = true;
        }
        if ("contextBirth".equalsIgnoreCase(attributesImpl.getValue("timeReference"))) {
            s1("Using context birth as time reference.");
            jCurrentTimeMillis = this.f13733b.v0();
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            s1("Using current interpretation time, i.e. now, as time reference.");
        }
        if (this.f13529d) {
            return;
        }
        ActionUtil.Scope scopeB = ActionUtil.b(attributesImpl.getValue(AuthorizationResponseParser.SCOPE));
        String strA = new CachingDateFormatter(value2).a(jCurrentTimeMillis);
        StringBuilder sbV = e.v("Adding property to the context with key=\"", value, "\" and value=\"", strA, "\" to the ");
        sbV.append(scopeB);
        sbV.append(" scope");
        s1(sbV.toString());
        ActionUtil.a(interpretationContext, value, strA, scopeB);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
