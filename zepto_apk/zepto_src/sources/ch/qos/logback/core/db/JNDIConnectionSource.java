package ch.qos.logback.core.db;

import ch.qos.logback.core.db.dialect.DBUtil;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/* loaded from: classes3.dex */
public class JNDIConnectionSource extends ConnectionSourceBase {

    /* renamed from: f, reason: collision with root package name */
    public DataSource f13463f = null;

    public final Connection T1() throws SQLException {
        try {
            if (this.f13463f == null) {
                this.f13463f = U1();
            }
            return this.f13463f.getConnection();
        } catch (ClassCastException e2) {
            o1("ClassCastException while looking up DataSource.", e2);
            throw new SQLException("ClassCastException while looking up DataSource: " + e2.getMessage());
        } catch (NamingException e3) {
            o1("Error while getting data source", e3);
            throw new SQLException("NamingException while looking up DataSource: " + e3.getMessage());
        }
    }

    public final DataSource U1() throws SQLException {
        s1("Looking up [null] in JNDI");
        DataSource dataSource = (DataSource) new InitialContext().lookup((String) null);
        if (dataSource != null) {
            return dataSource;
        }
        throw new SQLException("Failed to obtain data source from JNDI location null");
    }

    @Override // ch.qos.logback.core.db.ConnectionSourceBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() throws SQLException {
        l1("No JNDI location specified for JNDIConnectionSource.");
        Connection connectionT1 = null;
        try {
            try {
                try {
                    connectionT1 = T1();
                } catch (SQLException e2) {
                    O1("Could not discover the dialect to use.", e2);
                    if (0 == 0) {
                        return;
                    }
                }
                if (connectionT1 == null) {
                    J1("Could not get a connection");
                    if (connectionT1 != null) {
                        connectionT1.close();
                        return;
                    }
                    return;
                }
                DatabaseMetaData metaData = connectionT1.getMetaData();
                DBUtil dBUtil = new DBUtil();
                dBUtil.V(this.f13733b);
                this.f13462e = dBUtil.U1(metaData);
                try {
                    metaData.supportsBatchUpdates();
                } catch (Throwable unused) {
                    dBUtil.s1("Missing DatabaseMetaData.supportsBatchUpdates method.");
                }
                DBUtil.T1(metaData);
                s1("Driver name=" + metaData.getDriverName());
                s1("Driver version=" + metaData.getDriverVersion());
                s1("supportsGetGeneratedKeys=" + this.f13462e);
                connectionT1.close();
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        connectionT1.close();
                    } catch (SQLException unused2) {
                    }
                }
                throw th;
            }
        } catch (SQLException unused3) {
        }
    }
}
