package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.util.HashMap;

@Encodable
/* loaded from: classes3.dex */
public abstract class ProtoEncoderDoNotUse {

    /* renamed from: a, reason: collision with root package name */
    public static final ProtobufEncoder f20748a;

    static {
        ProtobufEncoder.Builder builder = new ProtobufEncoder.Builder();
        builder.a(ProtoEncoderDoNotUse.class, AutoProtoEncoderDoNotUseEncoder.ProtoEncoderDoNotUseEncoder.f20689a);
        builder.a(ClientMetrics.class, AutoProtoEncoderDoNotUseEncoder.ClientMetricsEncoder.f20676a);
        builder.a(TimeWindow.class, AutoProtoEncoderDoNotUseEncoder.TimeWindowEncoder.f20694a);
        builder.a(LogSourceMetrics.class, AutoProtoEncoderDoNotUseEncoder.LogSourceMetricsEncoder.f20686a);
        builder.a(LogEventDropped.class, AutoProtoEncoderDoNotUseEncoder.LogEventDroppedEncoder.f20683a);
        builder.a(GlobalMetrics.class, AutoProtoEncoderDoNotUseEncoder.GlobalMetricsEncoder.f20681a);
        builder.a(StorageMetrics.class, AutoProtoEncoderDoNotUseEncoder.StorageMetricsEncoder.f20691a);
        f20748a = new ProtobufEncoder(new HashMap(builder.f44534a), new HashMap(builder.f44535b), builder.f44536c);
    }

    public abstract ClientMetrics a();
}
