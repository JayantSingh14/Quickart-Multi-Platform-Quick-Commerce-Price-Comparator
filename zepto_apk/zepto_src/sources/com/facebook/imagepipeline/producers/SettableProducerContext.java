package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ImageRequest imageRequest, String str, InternalRequestListener internalRequestListener, Object obj, ImageRequest.RequestLevel requestLevel, ImagePipelineConfig imagePipelineConfig) {
        super(imageRequest, str, null, internalRequestListener, obj, requestLevel, true, false, Priority.f17783c, imagePipelineConfig);
    }

    public SettableProducerContext(ImageRequest imageRequest, String str, String str2, InternalRequestListener internalRequestListener, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        super(imageRequest, str, str2, internalRequestListener, obj, requestLevel, false, z, priority, imagePipelineConfig);
    }
}
