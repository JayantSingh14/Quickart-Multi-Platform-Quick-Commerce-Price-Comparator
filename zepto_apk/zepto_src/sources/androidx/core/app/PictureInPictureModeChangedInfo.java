package androidx.core.app;

import android.content.res.Configuration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class PictureInPictureModeChangedInfo {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2707a;

    public PictureInPictureModeChangedInfo(boolean z) {
        this.f2707a = z;
    }

    public final boolean a() {
        return this.f2707a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PictureInPictureModeChangedInfo(boolean z, Configuration newConfig) {
        this(z);
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }
}
