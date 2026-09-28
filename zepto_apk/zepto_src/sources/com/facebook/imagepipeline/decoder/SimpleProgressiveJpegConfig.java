package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.List;

@Nullsafe
/* loaded from: classes.dex */
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {

    /* renamed from: a, reason: collision with root package name */
    public final DynamicValueConfig f17944a = new DefaultDynamicValueConfig();

    public static class DefaultDynamicValueConfig implements DynamicValueConfig {
    }

    public interface DynamicValueConfig {
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public final int a(int i2) {
        List list = Collections.EMPTY_LIST;
        if (list == null || list.isEmpty()) {
            return i2 + 1;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (((Integer) list.get(i3)).intValue() > i2) {
                return ((Integer) list.get(i3)).intValue();
            }
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public final ImmutableQualityInfo b(int i2) {
        return ImmutableQualityInfo.d(i2, i2 >= 0, false);
    }
}
