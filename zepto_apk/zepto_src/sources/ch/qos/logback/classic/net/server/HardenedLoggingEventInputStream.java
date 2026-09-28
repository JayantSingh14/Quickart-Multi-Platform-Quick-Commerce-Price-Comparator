package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ClassPackagingData;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;
import ch.qos.logback.classic.spi.LoggerRemoteView;
import ch.qos.logback.classic.spi.LoggingEventVO;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.classic.spi.ThrowableProxyVO;
import ch.qos.logback.core.net.HardenedObjectInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.slf4j.helpers.BasicMarker;

/* loaded from: classes3.dex */
public class HardenedLoggingEventInputStream extends HardenedObjectInputStream {
    public HardenedLoggingEventInputStream(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(LoggingEventVO.class.getName());
        arrayList.add(LoggerContextVO.class.getName());
        arrayList.add(LoggerRemoteView.class.getName());
        arrayList.add(ThrowableProxyVO.class.getName());
        arrayList.add(BasicMarker.class.getName());
        arrayList.add(Level.class.getName());
        arrayList.add(Logger.class.getName());
        arrayList.add(StackTraceElement.class.getName());
        arrayList.add(StackTraceElement[].class.getName());
        arrayList.add(ThrowableProxy.class.getName());
        arrayList.add(ThrowableProxy[].class.getName());
        arrayList.add(IThrowableProxy.class.getName());
        arrayList.add(IThrowableProxy[].class.getName());
        arrayList.add(StackTraceElementProxy.class.getName());
        arrayList.add(StackTraceElementProxy[].class.getName());
        arrayList.add(ClassPackagingData.class.getName());
        super(inputStream, arrayList);
    }
}
