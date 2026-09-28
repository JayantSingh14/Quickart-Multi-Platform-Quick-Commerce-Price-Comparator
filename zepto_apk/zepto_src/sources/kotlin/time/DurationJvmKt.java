package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DurationJvmKt {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f54018a = 0;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal();
        }
    }
}
