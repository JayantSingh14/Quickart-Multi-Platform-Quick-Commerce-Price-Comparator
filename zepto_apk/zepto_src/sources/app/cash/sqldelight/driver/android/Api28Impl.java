package app.cash.sqldelight.driver.android;

import android.database.AbstractWindowedCursor;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.webkit.internal.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@Metadata
/* loaded from: classes3.dex */
final class Api28Impl {
    @JvmStatic
    @DoNotInline
    public static final void a(@NotNull AbstractWindowedCursor abstractWindowedCursor, long j2) {
        Intrinsics.checkNotNullParameter(abstractWindowedCursor, "<this>");
        abstractWindowedCursor.setWindow(b.f(j2));
    }
}
