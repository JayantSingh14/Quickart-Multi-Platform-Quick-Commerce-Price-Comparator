package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class ClientMetrics {

    /* renamed from: a, reason: collision with root package name */
    public final TimeWindow f20801a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20802b;

    /* renamed from: c, reason: collision with root package name */
    public final GlobalMetrics f20803c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20804d;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public TimeWindow f20805a = null;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f20806b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public GlobalMetrics f20807c = null;

        /* renamed from: d, reason: collision with root package name */
        public String f20808d = "";

        public final ClientMetrics a() {
            return new ClientMetrics(this.f20805a, Collections.unmodifiableList(this.f20806b), this.f20807c, this.f20808d);
        }
    }

    static {
        new Builder().a();
    }

    public ClientMetrics(TimeWindow timeWindow, List list, GlobalMetrics globalMetrics, String str) {
        this.f20801a = timeWindow;
        this.f20802b = list;
        this.f20803c = globalMetrics;
        this.f20804d = str;
    }

    public static Builder a() {
        return new Builder();
    }

    public final byte[] b() {
        ProtobufEncoder protobufEncoder = ProtoEncoderDoNotUse.f20748a;
        protobufEncoder.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            protobufEncoder.a(this, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
