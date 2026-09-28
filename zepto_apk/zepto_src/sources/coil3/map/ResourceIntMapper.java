package coil3.map;

import android.content.Context;
import androidx.annotation.DrawableRes;
import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ResourceIntMapper implements Mapper<Integer, Uri> {
    private final boolean isApplicable(@DrawableRes int i2, Context context) {
        return context.getResources().getResourceEntryName(i2) != null;
    }

    @Override // coil3.map.Mapper
    public /* bridge */ /* synthetic */ Uri map(Integer num, Options options) {
        return map(num.intValue(), options);
    }

    @Nullable
    public Uri map(@DrawableRes int i2, @NotNull Options options) {
        if (!isApplicable(i2, options.getContext())) {
            return null;
        }
        return UriKt.toUri$default("android.resource://" + options.getContext().getPackageName() + '/' + i2, null, 1, null);
    }
}
