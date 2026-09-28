package com.zeptonow.horizon.entity.dto;

import java.util.List;
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

@Metadata
@Deprecated
/* loaded from: classes.dex */
public final class EventRequestBody$$serializer implements GeneratedSerializer<EventRequestBody> {

    /* renamed from: a, reason: collision with root package name */
    public static final EventRequestBody$$serializer f48099a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PluginGeneratedSerialDescriptor f48100b;

    static {
        EventRequestBody$$serializer eventRequestBody$$serializer = new EventRequestBody$$serializer();
        f48099a = eventRequestBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.zeptonow.horizon.entity.dto.EventRequestBody", eventRequestBody$$serializer, 1);
        pluginGeneratedSerialDescriptor.k("events", false);
        f48100b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f48100b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48100b;
        CompositeDecoder compositeDecoderB = decoder.b(pluginGeneratedSerialDescriptor);
        KSerializer[] kSerializerArr = EventRequestBody.f48097b;
        List list = null;
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
                list = (List) compositeDecoderB.x(pluginGeneratedSerialDescriptor, 0, kSerializerArr[0], list);
                i2 = 1;
            }
        }
        compositeDecoderB.c(pluginGeneratedSerialDescriptor);
        return new EventRequestBody(i2, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        EventRequestBody value = (EventRequestBody) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48100b;
        CompositeEncoder compositeEncoderB = encoder.b(pluginGeneratedSerialDescriptor);
        compositeEncoderB.B(pluginGeneratedSerialDescriptor, 0, EventRequestBody.f48097b[0], value.f48098a);
        compositeEncoderB.c(pluginGeneratedSerialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] d() {
        return new KSerializer[]{EventRequestBody.f48097b[0]};
    }
}
