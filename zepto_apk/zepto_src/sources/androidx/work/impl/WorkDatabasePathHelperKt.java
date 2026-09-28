package androidx.work.impl;

import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WorkDatabasePathHelperKt {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12642a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f12643b;

    static {
        String strG = Logger.g("WrkDbPathHelper");
        Intrinsics.checkNotNullExpressionValue(strG, "tagWithPrefix(\"WrkDbPathHelper\")");
        f12642a = strG;
        f12643b = new String[]{"-journal", "-shm", "-wal"};
    }
}
