package com.facebook.imagepipeline.producers;

import com.facebook.fresco.middleware.HasExtraData;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface ProducerContext extends HasExtraData {
    Priority A();

    ImageRequest D();

    boolean O();

    ImageRequest.RequestLevel Z();

    Object a();

    void b(BaseProducerContextCallbacks baseProducerContextCallbacks);

    ImagePipelineConfigInterface c();

    void e(String str, String str2);

    String getId();

    String l();

    void r(String str);

    ProducerListener2 s();

    boolean x();
}
