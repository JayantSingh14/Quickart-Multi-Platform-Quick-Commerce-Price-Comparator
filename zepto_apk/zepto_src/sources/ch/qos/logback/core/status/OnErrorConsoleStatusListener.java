package ch.qos.logback.core.status;

import java.io.PrintStream;

/* loaded from: classes3.dex */
public class OnErrorConsoleStatusListener extends OnPrintStreamStatusListenerBase {
    @Override // ch.qos.logback.core.status.OnPrintStreamStatusListenerBase
    public final PrintStream T1() {
        return System.err;
    }
}
