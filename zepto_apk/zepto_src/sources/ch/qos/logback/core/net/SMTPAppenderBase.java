package ch.qos.logback.core.net;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.boolex.OnErrorEvaluator;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.sift.DefaultDiscriminator;
import ch.qos.logback.core.spi.CyclicBufferTracker;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

/* loaded from: classes3.dex */
public abstract class SMTPAppenderBase<E> extends AppenderBase<E> {

    /* renamed from: j, reason: collision with root package name */
    public Layout f13604j;

    /* renamed from: k, reason: collision with root package name */
    public final int f13605k;

    /* renamed from: l, reason: collision with root package name */
    public OnErrorEvaluator f13606l;

    /* renamed from: m, reason: collision with root package name */
    public CyclicBufferTracker f13607m;

    public class SenderRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    static {
        InternetAddress[] internetAddressArr = new InternetAddress[0];
    }

    public SMTPAppenderBase() {
        new ArrayList();
        this.f13605k = 25;
        new DefaultDiscriminator();
    }

    @Override // ch.qos.logback.core.AppenderBase
    public final void T1(Object obj) {
        if (!this.f13415d) {
            l1("Attempting to append to a non-started appender: " + this.f13417f);
        } else {
            if (this.f13606l == null) {
                l1("No EventEvaluator is set for appender [" + this.f13417f + "].");
                return;
            }
            l1("No layout set for appender named [" + this.f13417f + "]. For more information, please visit http://logback.qos.ch/codes.html#smtp_no_layout");
        }
    }

    public final Session U1() {
        Properties properties;
        try {
            properties = System.getProperties();
        } catch (SecurityException unused) {
            properties = new Properties();
        }
        Properties properties2 = new Properties(properties);
        properties2.put("mail.smtp.port", Integer.toString(this.f13605k));
        return Session.getInstance(properties2, (Authenticator) null);
    }

    public abstract PatternLayout V1();

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.f13607m == null) {
            this.f13607m = new CyclicBufferTracker();
        }
        if (U1() == null) {
            l1("Failed to obtain javax.mail.Session. Cannot start.");
        } else {
            this.f13604j = V1();
            this.f13415d = true;
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final synchronized void stop() {
        this.f13415d = false;
    }
}
