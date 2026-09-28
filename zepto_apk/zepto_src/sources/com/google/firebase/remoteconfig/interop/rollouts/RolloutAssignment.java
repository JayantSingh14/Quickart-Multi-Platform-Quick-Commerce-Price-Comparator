package com.google.firebase.remoteconfig.interop.rollouts;

import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.remoteconfig.interop.rollouts.AutoRolloutAssignmentEncoder;

@AutoValue
@Encodable
/* loaded from: classes4.dex */
public abstract class RolloutAssignment {

    /* renamed from: a, reason: collision with root package name */
    public static final DataEncoder f44917a;

    @AutoValue.Builder
    public static abstract class Builder {
    }

    static {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoRolloutAssignmentEncoder.RolloutAssignmentEncoder rolloutAssignmentEncoder = AutoRolloutAssignmentEncoder.RolloutAssignmentEncoder.f44911a;
        jsonDataEncoderBuilder.b(RolloutAssignment.class, rolloutAssignmentEncoder);
        jsonDataEncoderBuilder.b(AutoValue_RolloutAssignment.class, rolloutAssignmentEncoder);
        f44917a = jsonDataEncoderBuilder.a();
    }
}
