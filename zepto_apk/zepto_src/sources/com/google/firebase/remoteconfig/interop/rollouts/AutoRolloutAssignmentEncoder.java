package com.google.firebase.remoteconfig.interop.rollouts;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;

/* loaded from: classes4.dex */
public final class AutoRolloutAssignmentEncoder implements Configurator {

    public static final class RolloutAssignmentEncoder implements ObjectEncoder<RolloutAssignment> {

        /* renamed from: a, reason: collision with root package name */
        public static final RolloutAssignmentEncoder f44911a = new RolloutAssignmentEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44912b = FieldDescriptor.a("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44913c = FieldDescriptor.a("variantId");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44914d = FieldDescriptor.a("parameterKey");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44915e = FieldDescriptor.a("parameterValue");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44916f = FieldDescriptor.a("templateVersion");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            ((RolloutAssignment) obj).getClass();
            objectEncoderContext.f(f44912b, null);
            objectEncoderContext.f(f44913c, null);
            objectEncoderContext.f(f44914d, null);
            objectEncoderContext.f(f44915e, null);
            objectEncoderContext.b(f44916f, 0L);
        }
    }
}
