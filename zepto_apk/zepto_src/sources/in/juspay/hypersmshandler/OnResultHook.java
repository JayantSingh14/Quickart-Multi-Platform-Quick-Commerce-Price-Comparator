package in.juspay.hypersmshandler;

import android.content.Intent;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public interface OnResultHook {
    boolean onActivityResult(int i2, int i3, @Nullable Intent intent);
}
