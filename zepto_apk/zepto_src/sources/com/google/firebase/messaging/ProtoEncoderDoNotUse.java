package com.google.firebase.messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.AutoProtoEncoderDoNotUseEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.util.HashMap;

@Encodable
/* loaded from: classes4.dex */
public abstract class ProtoEncoderDoNotUse {

    /* renamed from: a, reason: collision with root package name */
    public static final ProtobufEncoder f44731a;

    static {
        ProtobufEncoder.Builder builder = new ProtobufEncoder.Builder();
        builder.a(ProtoEncoderDoNotUse.class, AutoProtoEncoderDoNotUseEncoder.ProtoEncoderDoNotUseEncoder.f44680a);
        builder.a(MessagingClientEventExtension.class, AutoProtoEncoderDoNotUseEncoder.MessagingClientEventExtensionEncoder.f44678a);
        builder.a(MessagingClientEvent.class, AutoProtoEncoderDoNotUseEncoder.MessagingClientEventEncoder.f44665a);
        f44731a = new ProtobufEncoder(new HashMap(builder.f44534a), new HashMap(builder.f44535b), builder.f44536c);
    }

    public abstract MessagingClientEventExtension a();
}
