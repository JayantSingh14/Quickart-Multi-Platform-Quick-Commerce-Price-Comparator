package androidx.core.app;

import android.content.res.Configuration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class MultiWindowModeChangedInfo {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2646a;

    public MultiWindowModeChangedInfo(boolean z) {
        this.f2646a = z;
    }

    public final boolean a() {
        return this.f2646a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiWindowModeChangedInfo(boolean z, Configuration newConfig) {
        this(z);
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }
}
