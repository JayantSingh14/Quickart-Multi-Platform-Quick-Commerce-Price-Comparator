package ch.qos.logback.core.db.dialect;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class DBUtil extends ContextAwareBase {

    /* renamed from: ch.qos.logback.core.db.dialect.DBUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13464a;

        static {
            int[] iArr = new int[SQLDialectCode.values().length];
            f13464a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13464a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13464a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13464a[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13464a[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13464a[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13464a[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13464a[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static SQLDialectCode T1(DatabaseMetaData databaseMetaData) {
        String lowerCase;
        SQLDialectCode sQLDialectCode = SQLDialectCode.f13465a;
        try {
            lowerCase = databaseMetaData.getDatabaseProductName().toLowerCase();
        } catch (SQLException unused) {
        }
        if (lowerCase.indexOf("postgresql") != -1) {
            return SQLDialectCode.f13466b;
        }
        if (lowerCase.indexOf("mysql") != -1) {
            return SQLDialectCode.f13467c;
        }
        if (lowerCase.indexOf("oracle") != -1) {
            return SQLDialectCode.f13468d;
        }
        if (lowerCase.indexOf("microsoft") != -1) {
            return SQLDialectCode.f13469e;
        }
        if (lowerCase.indexOf("hsql") != -1) {
            return SQLDialectCode.f13470f;
        }
        if (lowerCase.indexOf("h2") != -1) {
            return SQLDialectCode.f13471g;
        }
        if (lowerCase.indexOf("sql anywhere") != -1) {
            return SQLDialectCode.f13472h;
        }
        if (lowerCase.indexOf("sqlite") != -1) {
            return SQLDialectCode.f13473i;
        }
        return sQLDialectCode;
    }

    public final boolean U1(DatabaseMetaData databaseMetaData) {
        try {
            return ((Boolean) DatabaseMetaData.class.getMethod("supportsGetGeneratedKeys", null).invoke(databaseMetaData, null)).booleanValue();
        } catch (Throwable unused) {
            s1("Could not call supportsGetGeneratedKeys method. This may be recoverable");
            return false;
        }
    }
}
