package ch.qos.logback.core.db;

/* loaded from: classes3.dex */
public class DataSourceConnectionSource extends ConnectionSourceBase {
    @Override // ch.qos.logback.core.db.ConnectionSourceBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        J1("WARNING: No data source specified");
        this.f13461d = true;
    }
}
