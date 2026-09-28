package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.net.SocketAppender;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ConsolePluginAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws NumberFormatException {
        Integer numValueOf;
        String value = attributesImpl.getValue("port");
        if (value == null) {
            numValueOf = 4321;
        } else {
            try {
                numValueOf = Integer.valueOf(value);
            } catch (NumberFormatException unused) {
                l1("Port " + value + " in ConsolePlugin config is not a correct number");
                numValueOf = null;
            }
        }
        LoggerContext loggerContext = (LoggerContext) interpretationContext.f13733b;
        SocketAppender socketAppender = new SocketAppender();
        socketAppender.V(loggerContext);
        socketAppender.x = true;
        socketAppender.f13592l = "localhost";
        socketAppender.f13593m = numValueOf.intValue();
        socketAppender.start();
        loggerContext.c("ROOT").r0(socketAppender);
        s1("Sending LoggingEvents to the plugin using port " + numValueOf);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
