package androidx.activity;

import android.app.PictureInPictureParams;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@RequiresApi
@Metadata
/* loaded from: classes3.dex */
public final class Api26Impl {
    public static void a(Rect hint) {
        Intrinsics.checkNotNullParameter(null, "activity");
        Intrinsics.checkNotNullParameter(hint, "hint");
        new PictureInPictureParams.Builder().setSourceRectHint(hint).build();
        throw null;
    }
}
