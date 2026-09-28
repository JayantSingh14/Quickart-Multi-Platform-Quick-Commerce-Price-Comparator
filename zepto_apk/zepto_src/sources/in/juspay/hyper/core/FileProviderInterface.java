package in.juspay.hyper.core;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public interface FileProviderInterface {
    @NotNull
    String readFromFile(@NotNull Context context, @NotNull String str);

    void renewFile(@NotNull String str, @NotNull String str2, long j2);
}
