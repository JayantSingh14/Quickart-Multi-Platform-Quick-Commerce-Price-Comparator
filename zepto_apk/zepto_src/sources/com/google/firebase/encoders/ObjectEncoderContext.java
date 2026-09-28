package com.google.firebase.encoders;

/* loaded from: classes.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext a(FieldDescriptor fieldDescriptor, boolean z);

    ObjectEncoderContext b(FieldDescriptor fieldDescriptor, long j2);

    ObjectEncoderContext c(FieldDescriptor fieldDescriptor, int i2);

    ObjectEncoderContext d(FieldDescriptor fieldDescriptor, double d2);

    ObjectEncoderContext f(FieldDescriptor fieldDescriptor, Object obj);
}
