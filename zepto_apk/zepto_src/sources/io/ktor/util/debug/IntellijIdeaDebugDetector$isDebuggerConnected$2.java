package io.ktor.util.debug;

import java.lang.management.ManagementFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class IntellijIdeaDebugDetector$isDebuggerConnected$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final IntellijIdeaDebugDetector$isDebuggerConnected$2 f50557c = new IntellijIdeaDebugDetector$isDebuggerConnected$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        boolean zN = false;
        try {
            zN = StringsKt.n(ManagementFactory.getRuntimeMXBean().getInputArguments().toString(), "jdwp", false);
        } catch (Throwable unused) {
        }
        return Boolean.valueOf(zN);
    }
}
