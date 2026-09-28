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
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@Deprecated
/* loaded from: classes4.dex */
public final class Event$$serializer implements GeneratedSerializer<Event> {

    /* renamed from: a, reason: collision with root package name */
    public static final Event$$serializer f48066a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PluginGeneratedSerialDescriptor f48067b;

    static {
        Event$$serializer event$$serializer = new Event$$serializer();
        f48066a = event$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.zeptonow.horizon.entity.Event", event$$serializer, 3);
        pluginGeneratedSerialDescriptor.k(CLConstants.FIELD_PAY_INFO_NAME, false);
        pluginGeneratedSerialDescriptor.k("properties", true);
        pluginGeneratedSerialDescriptor.k("type", true);
        f48067b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f48067b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48067b;
        CompositeDecoder compositeDecoderB = decoder.b(pluginGeneratedSerialDescriptor);
        KSerializer[] kSerializerArr = Event.f48062d;
        String strN = null;
        boolean z = true;
        String strN2 = null;
        EventType eventType = null;
        int i2 = 0;
        while (z) {
            int iO = compositeDecoderB.o(pluginGeneratedSerialDescriptor);
            if (iO == -1) {
                z = false;
            } else if (iO == 0) {
                strN = compositeDecoderB.n(pluginGeneratedSerialDescriptor, 0);
                i2 |= 1;
            } else if (iO == 1) {
                strN2 = compositeDecoderB.n(pluginGeneratedSerialDescriptor, 1);
                i2 |= 2;
            } else {
                if (iO != 2) {
                    throw new UnknownFieldException(iO);
                }
                eventType = (EventType) compositeDecoderB.x(pluginGeneratedSerialDescriptor, 2, kSerializerArr[2], eventType);
                i2 |= 4;
            }
        }
        compositeDecoderB.c(pluginGeneratedSerialDescriptor);
        return new Event(i2, strN, strN2, eventType);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Event value = (Event) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48067b;
        CompositeEncoder compositeEncoderB = encoder.b(pluginGeneratedSerialDescriptor);
        compositeEncoderB.y(pluginGeneratedSerialDescriptor, 0, value.f48063a);
        boolean zD = compositeEncoderB.D(pluginGeneratedSerialDescriptor, 1);
        String str = value.f48064b;
        if (zD || !Intrinsics.b(str, "{}")) {
            compositeEncoderB.y(pluginGeneratedSerialDescriptor, 1, str);
        }
        boolean zD2 = compositeEncoderB.D(pluginGeneratedSerialDescriptor, 2);
        Object obj2 = value.f48065c;
        if (zD2 || obj2 != EventType.f48076a) {
            compositeEncoderB.B(pluginGeneratedSerialDescriptor, 2, Event.f48062d[2], obj2);
        }
        compositeEncoderB.c(pluginGeneratedSerialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] d() {
        KSerializer kSerializer = Event.f48062d[2];
        StringSerializer stringSerializer = StringSerializer.f55902a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializer};
    }
}
