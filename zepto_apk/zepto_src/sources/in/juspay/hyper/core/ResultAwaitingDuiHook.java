package in.juspay.hyper.core;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public interface ResultAwaitingDuiHook {
    boolean onActivityResult(int i2, int i3, @Nullable Intent intent);
}
