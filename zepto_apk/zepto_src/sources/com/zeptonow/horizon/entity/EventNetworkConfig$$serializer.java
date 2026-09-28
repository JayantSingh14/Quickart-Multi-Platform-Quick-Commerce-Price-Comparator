package com.zeptonow.horizon.entity;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata
@Deprecated
/* loaded from: classes.dex */
public final class EventNetworkConfig$$serializer implements GeneratedSerializer<EventNetworkConfig> {

    /* renamed from: a, reason: collision with root package name */
    public static final EventNetworkConfig$$serializer f48069a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PluginGeneratedSerialDescriptor f48070b;

    static {
        EventNetworkConfig$$serializer eventNetworkConfig$$serializer = new EventNetworkConfig$$serializer();
        f48069a = eventNetworkConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.zeptonow.horizon.entity.EventNetworkConfig", eventNetworkConfig$$serializer, 1);
        pluginGeneratedSerialDescriptor.k("url", false);
        f48070b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f48070b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48070b;
        CompositeDecoder compositeDecoderB = decoder.b(pluginGeneratedSerialDescriptor);
        String strN = null;
        boolean z = true;
        int i2 = 0;
        while (z) {
            int iO = compositeDecoderB.o(pluginGeneratedSerialDescriptor);
            if (iO == -1) {
                z = false;
            } else {
                if (iO != 0) {
                    throw new UnknownFieldException(iO);
                }
                strN = compositeDecoderB.n(pluginGeneratedSerialDescriptor, 0);
                i2 = 1;
            }
        }
        compositeDecoderB.c(pluginGeneratedSerialDescriptor);
        return new EventNetworkConfig(i2, strN);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        EventNetworkConfig value = (EventNetworkConfig) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48070b;
        CompositeEncoder compositeEncoderB = encoder.b(pluginGeneratedSerialDescriptor);
        compositeEncoderB.y(pluginGeneratedSerialDescriptor, 0, value.f48068a);
        compositeEncoderB.c(pluginGeneratedSerialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] d() {
        return new KSerializer[]{StringSerializer.f55902a};
    }
}
