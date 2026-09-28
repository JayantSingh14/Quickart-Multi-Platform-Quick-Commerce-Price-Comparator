package ch.qos.logback.core.db;

/* loaded from: classes3.dex */
public class DriverManagerConnectionSource extends ConnectionSourceBase {
    @Override // ch.qos.logback.core.db.ConnectionSourceBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        try {
            l1("WARNING: No JDBC driver specified for logback DriverManagerConnectionSource.");
        } catch (ClassNotFoundException e2) {
            o1("Could not load JDBC driver class: null", e2);
        }
    }
}
