package ch.qos.logback.core.recovery;

import ch.qos.logback.core.net.SyslogOutputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class ResilientSyslogOutputStream extends ResilientOutputStreamBase {
    @Override // ch.qos.logback.core.recovery.ResilientOutputStreamBase
    public final String e() {
        return "syslog [null:0]";
    }

    @Override // ch.qos.logback.core.recovery.ResilientOutputStreamBase
    public final OutputStream l() {
        return new SyslogOutputStream(0);
    }

    public final String toString() {
        return "c.q.l.c.recovery.ResilientSyslogOutputStream@" + System.identityHashCode(this);
    }
}
