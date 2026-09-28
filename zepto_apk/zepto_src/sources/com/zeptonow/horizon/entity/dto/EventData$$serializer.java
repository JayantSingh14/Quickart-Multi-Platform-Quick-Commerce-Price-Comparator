package com.zeptonow.horizon.entity.dto;

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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

@Metadata
@Deprecated
/* loaded from: classes.dex */
public final class EventData$$serializer implements GeneratedSerializer<EventData> {

    /* renamed from: a, reason: collision with root package name */
    public static final EventData$$serializer f48095a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PluginGeneratedSerialDescriptor f48096b;

    static {
        EventData$$serializer eventData$$serializer = new EventData$$serializer();
        f48095a = eventData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.zeptonow.horizon.entity.dto.EventData", eventData$$serializer, 2);
        pluginGeneratedSerialDescriptor.k("event_type", false);
        pluginGeneratedSerialDescriptor.k("data", false);
        f48096b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f48096b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48096b;
        CompositeDecoder compositeDecoderB = decoder.b(pluginGeneratedSerialDescriptor);
        String strN = null;
        boolean z = true;
        JsonElement jsonElement = null;
        int i2 = 0;
        while (z) {
            int iO = compositeDecoderB.o(pluginGeneratedSerialDescriptor);
            if (iO == -1) {
                z = false;
            } else if (iO == 0) {
                strN = compositeDecoderB.n(pluginGeneratedSerialDescriptor, 0);
                i2 |= 1;
            } else {
                if (iO != 1) {
                    throw new UnknownFieldException(iO);
                }
                jsonElement = (JsonElement) compositeDecoderB.x(pluginGeneratedSerialDescriptor, 1, JsonElementSerializer.f55978a, jsonElement);
                i2 |= 2;
            }
        }
        compositeDecoderB.c(pluginGeneratedSerialDescriptor);
        return new EventData(i2, strN, jsonElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        EventData value = (EventData) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48096b;
        CompositeEncoder compositeEncoderB = encoder.b(pluginGeneratedSerialDescriptor);
        compositeEncoderB.y(pluginGeneratedSerialDescriptor, 0, value.f48093a);
        compositeEncoderB.B(pluginGeneratedSerialDescriptor, 1, JsonElementSerializer.f55978a, value.f48094b);
        compositeEncoderB.c(pluginGeneratedSerialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] d() {
        return new KSerializer[]{StringSerializer.f55902a, JsonElementSerializer.f55978a};
    }
}
