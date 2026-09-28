package ch.qos.logback.core.joran;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.event.SaxEventRecorder;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.StatusUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes3.dex */
public abstract class GenericConfigurator extends ContextAwareBase {

    /* renamed from: d, reason: collision with root package name */
    public BeanDescriptionCache f13493d;

    /* renamed from: e, reason: collision with root package name */
    public Interpreter f13494e;

    public static void b2(Context context, URL url) {
        ConfigurationWatchList configurationWatchListA = ConfigurationWatchListUtil.a(context);
        if (configurationWatchListA == null) {
            configurationWatchListA = new ConfigurationWatchList();
            configurationWatchListA.V(context);
            context.O(configurationWatchListA, "CONFIGURATION_WATCH_LIST");
        } else {
            configurationWatchListA.f13548d = null;
            configurationWatchListA.f13550f.clear();
            configurationWatchListA.f13549e.clear();
        }
        configurationWatchListA.f13548d = url;
        if (url != null) {
            configurationWatchListA.T1(url);
        }
    }

    public void T1(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
    }

    public abstract void U1(Interpreter interpreter);

    public abstract void V1(SimpleRuleStore simpleRuleStore);

    public void W1() {
        Context context = this.f13733b;
        SimpleRuleStore simpleRuleStore = new SimpleRuleStore();
        simpleRuleStore.f13578d = new HashMap();
        simpleRuleStore.V(context);
        V1(simpleRuleStore);
        Interpreter interpreter = new Interpreter(this.f13733b, simpleRuleStore, c2());
        this.f13494e = interpreter;
        Context context2 = this.f13733b;
        InterpretationContext interpretationContext = interpreter.f13570b;
        interpretationContext.V(context2);
        U1(this.f13494e);
        T1(interpretationContext.f13567i);
    }

    public final void X1(InputStream inputStream, String str) throws ParserConfigurationException, SAXException, JoranException, IOException {
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.f13733b);
        saxEventRecorder.d(inputSource);
        Z1(saxEventRecorder.f13544b);
        if (new StatusUtil(this.f13733b).b(jCurrentTimeMillis)) {
            return;
        }
        s1("Registering current configuration as safe fallback point");
        this.f13733b.O(saxEventRecorder.f13544b, "SAFE_JORAN_CONFIGURATION");
    }

    public final void Y1(URL url) throws JoranException, IOException {
        InputStream inputStream = null;
        try {
            try {
                b2(this.f13733b, url);
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setUseCaches(false);
                inputStream = uRLConnectionOpenConnection.getInputStream();
                X1(inputStream, url.toExternalForm());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        o1("Could not close input stream", e2);
                        throw new JoranException("Could not close input stream", e2);
                    }
                }
            } catch (IOException e3) {
                String str = "Could not open URL [" + url + "].";
                o1(str, e3);
                throw new JoranException(str, e3);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    o1("Could not close input stream", e4);
                    throw new JoranException("Could not close input stream", e4);
                }
            }
            throw th;
        }
    }

    public void Z1(List list) {
        W1();
        synchronized (this.f13733b.t0()) {
            this.f13494e.f13575g.a(list);
        }
    }

    public final BeanDescriptionCache a2() {
        if (this.f13493d == null) {
            Context context = this.f13733b;
            BeanDescriptionCache beanDescriptionCache = new BeanDescriptionCache();
            beanDescriptionCache.f13588d = new HashMap();
            beanDescriptionCache.V(context);
            this.f13493d = beanDescriptionCache;
        }
        return this.f13493d;
    }

    public ElementPath c2() {
        return new ElementPath();
    }
}
