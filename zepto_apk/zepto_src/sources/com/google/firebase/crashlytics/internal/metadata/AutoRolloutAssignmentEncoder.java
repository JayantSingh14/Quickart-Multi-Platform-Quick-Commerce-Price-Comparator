package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;

/* loaded from: classes4.dex */
public final class AutoRolloutAssignmentEncoder implements Configurator {

    public static final class RolloutAssignmentEncoder implements ObjectEncoder<RolloutAssignment> {

        /* renamed from: a, reason: collision with root package name */
        public static final RolloutAssignmentEncoder f43883a = new RolloutAssignmentEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43884b = FieldDescriptor.a("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43885c = FieldDescriptor.a("parameterKey");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f43886d = FieldDescriptor.a("parameterValue");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f43887e = FieldDescriptor.a("variantId");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f43888f = FieldDescriptor.a("templateVersion");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            RolloutAssignment rolloutAssignment = (RolloutAssignment) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f43884b, rolloutAssignment.d());
            objectEncoderContext.f(f43885c, rolloutAssignment.b());
            objectEncoderContext.f(f43886d, rolloutAssignment.c());
            objectEncoderContext.f(f43887e, rolloutAssignment.f());
            objectEncoderContext.b(f43888f, rolloutAssignment.e());
        }
    }
}
