package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

/* loaded from: classes4.dex */
class ProtobufValueEncoderContext implements ValueEncoderContext {

    /* renamed from: a, reason: collision with root package name */
    public boolean f44537a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f44538b = false;

    /* renamed from: c, reason: collision with root package name */
    public FieldDescriptor f44539c;

    /* renamed from: d, reason: collision with root package name */
    public final ProtobufDataEncoderContext f44540d;

    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.f44540d = protobufDataEncoderContext;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext e(String str) {
        if (this.f44537a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f44537a = true;
        this.f44540d.i(this.f44539c, str, this.f44538b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext g(boolean z) {
        if (this.f44537a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f44537a = true;
        this.f44540d.g(this.f44539c, z ? 1 : 0, this.f44538b);
        return this;
    }
}
