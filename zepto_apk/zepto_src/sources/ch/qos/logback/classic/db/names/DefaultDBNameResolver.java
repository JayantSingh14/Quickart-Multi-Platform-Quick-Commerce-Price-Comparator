package ch.qos.logback.classic.db.names;

/* loaded from: classes3.dex */
public class DefaultDBNameResolver implements DBNameResolver {
    public final String a(TableName tableName) {
        return tableName.toString().toLowerCase();
    }
}
