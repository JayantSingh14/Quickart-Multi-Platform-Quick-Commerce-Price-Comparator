package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class SystemProperties {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SystemProperties f54003a = new SystemProperties();

    static {
        Intrinsics.c(System.getProperty("line.separator"));
    }
}
