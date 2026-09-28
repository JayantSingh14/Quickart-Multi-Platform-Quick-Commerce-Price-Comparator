package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata
@SuppressLint({"all"})
@IgnoreJRERequirement
/* loaded from: classes3.dex */
public final class AgentPremain {

    @Metadata
    public static final class DebugProbesTransformer implements ClassFileTransformer {
    }

    static {
        Object objA;
        try {
            Result.Companion companion = Result.f53538b;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            objA = property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        if (((Boolean) (objA instanceof Result.Failure ? null : objA)) != null) {
            return;
        }
        ConcurrentWeakMap concurrentWeakMap = DebugProbesImpl.f54465a;
    }
}
