package ch.qos.logback.classic.db;

import ch.qos.logback.classic.db.names.DefaultDBNameResolver;
import ch.qos.logback.classic.db.names.TableName;
import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.db.DBAppenderBase;
import java.sql.PreparedStatement;

/* loaded from: classes3.dex */
public class DBAppender extends DBAppenderBase<ILoggingEvent> {

    /* renamed from: j, reason: collision with root package name */
    public DefaultDBNameResolver f13259j;

    static {
        String str = CallerData.f13339a;
        new StackTraceElement("?", "?", "?", -1);
        try {
            PreparedStatement.class.getMethod("getGeneratedKeys", null);
        } catch (Exception unused) {
        }
    }

    @Override // ch.qos.logback.core.db.DBAppenderBase, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        if (this.f13259j == null) {
            this.f13259j = new DefaultDBNameResolver();
        }
        this.f13259j.a(TableName.f13263c);
        "EVENT_ID".toLowerCase();
        "I".toLowerCase();
        "TRACE_LINE".toLowerCase();
        this.f13259j.a(TableName.f13262b);
        "EVENT_ID".toLowerCase();
        "MAPPED_KEY".toLowerCase();
        "MAPPED_VALUE".toLowerCase();
        this.f13259j.a(TableName.f13261a);
        "TIMESTMP".toLowerCase();
        "FORMATTED_MESSAGE".toLowerCase();
        "LOGGER_NAME".toLowerCase();
        "LEVEL_STRING".toLowerCase();
        "THREAD_NAME".toLowerCase();
        "REFERENCE_FLAG".toLowerCase();
        "ARG0".toLowerCase();
        "ARG1".toLowerCase();
        "ARG2".toLowerCase();
        "ARG3".toLowerCase();
        "CALLER_FILENAME".toLowerCase();
        "CALLER_CLASS".toLowerCase();
        "CALLER_METHOD".toLowerCase();
        "CALLER_LINE".toLowerCase();
        super.start();
        throw null;
    }
}
