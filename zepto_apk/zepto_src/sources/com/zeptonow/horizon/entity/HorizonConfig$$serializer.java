package com.zeptonow.horizon.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata
@Deprecated
/* loaded from: classes.dex */
public final class HorizonConfig$$serializer implements GeneratedSerializer<HorizonConfig> {

    /* renamed from: a, reason: collision with root package name */
    public static final HorizonConfig$$serializer f48091a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PluginGeneratedSerialDescriptor f48092b;

    static {
        HorizonConfig$$serializer horizonConfig$$serializer = new HorizonConfig$$serializer();
        f48091a = horizonConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.zeptonow.horizon.entity.HorizonConfig", horizonConfig$$serializer, 10);
        pluginGeneratedSerialDescriptor.k("maxParallelRequests", false);
        pluginGeneratedSerialDescriptor.k("batchSize", false);
        pluginGeneratedSerialDescriptor.k("maxBatchSize", false);
        pluginGeneratedSerialDescriptor.k("batchIntervalInMs", false);
        pluginGeneratedSerialDescriptor.k("retryIntervalInMs", false);
        pluginGeneratedSerialDescriptor.k("retryCount", false);
        pluginGeneratedSerialDescriptor.k("defaultUrl", false);
        pluginGeneratedSerialDescriptor.k("compressionEnabled", false);
        pluginGeneratedSerialDescriptor.k("eventNetworkConfigs", true);
        pluginGeneratedSerialDescriptor.k("blackListedEventPropertiesMap", true);
        f48092b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f48092b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48092b;
        CompositeDecoder compositeDecoderB = decoder.b(pluginGeneratedSerialDescriptor);
        KSerializer[] kSerializerArr = HorizonConfig.f48080k;
        Map map = null;
        String strN = null;
        long jH = 0;
        long jH2 = 0;
        int i2 = 0;
        int iL = 0;
        int iL2 = 0;
        int iL3 = 0;
        int iL4 = 0;
        boolean z = false;
        boolean z2 = true;
        Map map2 = null;
        while (z2) {
            int iO = compositeDecoderB.o(pluginGeneratedSerialDescriptor);
            switch (iO) {
                case -1:
                    z2 = false;
                    break;
                case 0:
                    iL = compositeDecoderB.l(pluginGeneratedSerialDescriptor, 0);
                    i2 |= 1;
                    break;
                case 1:
                    iL2 = compositeDecoderB.l(pluginGeneratedSerialDescriptor, 1);
                    i2 |= 2;
                    break;
                case 2:
                    iL3 = compositeDecoderB.l(pluginGeneratedSerialDescriptor, 2);
                    i2 |= 4;
                    break;
                case 3:
                    jH = compositeDecoderB.h(pluginGeneratedSerialDescriptor, 3);
                    i2 |= 8;
                    break;
                case 4:
                    jH2 = compositeDecoderB.h(pluginGeneratedSerialDescriptor, 4);
                    i2 |= 16;
                    break;
                case 5:
                    iL4 = compositeDecoderB.l(pluginGeneratedSerialDescriptor, 5);
                    i2 |= 32;
                    break;
                case 6:
                    strN = compositeDecoderB.n(pluginGeneratedSerialDescriptor, 6);
                    i2 |= 64;
                    break;
                case 7:
                    z = compositeDecoderB.z(pluginGeneratedSerialDescriptor, 7);
                    i2 |= 128;
                    break;
                case 8:
                    map = (Map) compositeDecoderB.x(pluginGeneratedSerialDescriptor, 8, kSerializerArr[8], map);
                    i2 |= 256;
                    break;
                case 9:
                    map2 = (Map) compositeDecoderB.x(pluginGeneratedSerialDescriptor, 9, kSerializerArr[9], map2);
                    i2 |= 512;
                    break;
                default:
                    throw new UnknownFieldException(iO);
            }
        }
        compositeDecoderB.c(pluginGeneratedSerialDescriptor);
        return new HorizonConfig(i2, iL, iL2, iL3, jH, jH2, iL4, strN, z, map, map2);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        HorizonConfig value = (HorizonConfig) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = f48092b;
        CompositeEncoder compositeEncoderB = encoder.b(pluginGeneratedSerialDescriptor);
        compositeEncoderB.w(pluginGeneratedSerialDescriptor, 0, value.f48081a);
        compositeEncoderB.w(pluginGeneratedSerialDescriptor, 1, value.f48082b);
        compositeEncoderB.w(pluginGeneratedSerialDescriptor, 2, value.f48083c);
        compositeEncoderB.E(pluginGeneratedSerialDescriptor, 3, value.f48084d);
        compositeEncoderB.E(pluginGeneratedSerialDescriptor, 4, value.f48085e);
        compositeEncoderB.w(pluginGeneratedSerialDescriptor, 5, value.f48086f);
        compositeEncoderB.y(pluginGeneratedSerialDescriptor, 6, value.f48087g);
        compositeEncoderB.x(pluginGeneratedSerialDescriptor, 7, value.f48088h);
        boolean zD = compositeEncoderB.D(pluginGeneratedSerialDescriptor, 8);
        SerializationStrategy[] serializationStrategyArr = HorizonConfig.f48080k;
        Object obj2 = value.f48089i;
        if (zD || !Intrinsics.b(obj2, new LinkedHashMap())) {
            compositeEncoderB.B(pluginGeneratedSerialDescriptor, 8, serializationStrategyArr[8], obj2);
        }
        boolean zD2 = compositeEncoderB.D(pluginGeneratedSerialDescriptor, 9);
        Object obj3 = value.f48090j;
        if (zD2 || !Intrinsics.b(obj3, new LinkedHashMap())) {
            compositeEncoderB.B(pluginGeneratedSerialDescriptor, 9, serializationStrategyArr[9], obj3);
        }
        compositeEncoderB.c(pluginGeneratedSerialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] d() {
        KSerializer[] kSerializerArr = HorizonConfig.f48080k;
        KSerializer kSerializer = kSerializerArr[8];
        KSerializer kSerializer2 = kSerializerArr[9];
        IntSerializer intSerializer = IntSerializer.f55831a;
        LongSerializer longSerializer = LongSerializer.f55842a;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, longSerializer, longSerializer, intSerializer, StringSerializer.f55902a, BooleanSerializer.f55773a, kSerializer, kSerializer2};
    }
}
