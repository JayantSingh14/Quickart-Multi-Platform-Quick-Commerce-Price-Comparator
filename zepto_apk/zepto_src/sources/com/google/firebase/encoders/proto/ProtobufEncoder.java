package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class ProtobufEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f44530a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f44531b;

    /* renamed from: c, reason: collision with root package name */
    public final a f44532c;

    public static final class Builder implements EncoderConfig<Builder> {

        /* renamed from: d, reason: collision with root package name */
        public static final a f44533d = new a(1);

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f44534a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f44535b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final a f44536c = f44533d;

        public final EncoderConfig a(Class cls, ObjectEncoder objectEncoder) {
            this.f44534a.put(cls, objectEncoder);
            this.f44535b.remove(cls);
            return this;
        }
    }

    public ProtobufEncoder(HashMap map, HashMap map2, a aVar) {
        this.f44530a = map;
        this.f44531b = map2;
        this.f44532c = aVar;
    }

    public final void a(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap map = this.f44531b;
        HashMap map2 = this.f44530a;
        ProtobufDataEncoderContext protobufDataEncoderContext = new ProtobufDataEncoderContext(byteArrayOutputStream, map2, map, this.f44532c);
        if (obj == null) {
            return;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) map2.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.a(obj, protobufDataEncoderContext);
        } else {
            throw new EncodingException("No encoder for " + obj.getClass());
        }
    }
}
