package com.google.firebase.remoteconfig.interop.rollouts;

import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;

/* loaded from: classes4.dex */
final class AutoValue_RolloutAssignment extends RolloutAssignment {

    public static final class Builder extends RolloutAssignment.Builder {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RolloutAssignment)) {
            return false;
        }
        ((RolloutAssignment) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "RolloutAssignment{rolloutId=null, variantId=null, parameterKey=null, parameterValue=null, templateVersion=0}";
    }
}
