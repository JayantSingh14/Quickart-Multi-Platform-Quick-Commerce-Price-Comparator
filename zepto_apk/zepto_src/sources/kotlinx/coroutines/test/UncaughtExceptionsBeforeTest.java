package kotlinx.coroutines.test;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class UncaughtExceptionsBeforeTest extends IllegalStateException {
    public UncaughtExceptionsBeforeTest() {
        super("There were uncaught exceptions before the test started. Please avoid this, as such exceptions are also reported in a platform-dependent manner so that they are not lost.");
    }
}
