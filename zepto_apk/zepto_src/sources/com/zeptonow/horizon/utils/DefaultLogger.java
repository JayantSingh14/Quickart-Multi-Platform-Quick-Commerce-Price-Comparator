package com.zeptonow.horizon.utils;

import co.touchlab.kermit.BaseLoggerKt;
import co.touchlab.kermit.CommonWriter;
import co.touchlab.kermit.LogWriter;
import co.touchlab.kermit.Logger;
import co.touchlab.kermit.LoggerConfig;
import co.touchlab.kermit.Severity;
import co.touchlab.kermit.StaticConfig;
import com.horizon.HorizonModule;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DefaultLogger implements CustomLogger {

    /* renamed from: a, reason: collision with root package name */
    public final HorizonModule f48235a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f48236b;

    /* renamed from: c, reason: collision with root package name */
    public LogLevel f48237c;

    /* renamed from: d, reason: collision with root package name */
    public final Logger f48238d;

    public DefaultLogger(HorizonModule rnLogger) {
        Intrinsics.checkNotNullParameter(rnLogger, "rnLogger");
        this.f48235a = rnLogger;
        this.f48236b = true;
        this.f48237c = LogLevel.f48263a;
        LogWriter[] logWriters = {new CommonWriter(0)};
        Severity minSeverity = BaseLoggerKt.f13841a;
        Intrinsics.checkNotNullParameter(logWriters, "logWriters");
        Intrinsics.checkNotNullParameter(minSeverity, "minSeverity");
        this.f48238d = new Logger(new StaticConfig(minSeverity, ArraysKt.F(logWriters)), HorizonModule.NAME);
    }

    public final void a(LogLevel logLevel, Function0 block) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(block, "block");
        if (logLevel.compareTo(this.f48237c) <= 0) {
            String message = (String) block.invoke();
            Logger logger = this.f48238d;
            String tag = logger.f13848b;
            Severity severity = Severity.f13850b;
            LoggerConfig loggerConfig = logger.f13840a;
            if (loggerConfig.a().compareTo(severity) <= 0) {
                Intrinsics.checkNotNullParameter(severity, "severity");
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(message, "message");
                for (LogWriter logWriter : loggerConfig.b()) {
                    logWriter.getClass();
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    Intrinsics.checkNotNullParameter(severity, "severity");
                    logWriter.a(message, tag);
                }
            }
            if (this.f48236b) {
                this.f48235a.emit(RNBridgeEvent.f48275a, message);
            }
        }
    }
}
