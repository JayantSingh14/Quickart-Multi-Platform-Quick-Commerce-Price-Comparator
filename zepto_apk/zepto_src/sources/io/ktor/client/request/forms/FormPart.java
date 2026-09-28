package io.ktor.client.request.forms;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class FormPart<T> {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormPart)) {
            return false;
        }
        ((FormPart) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "FormPart(key=null, value=null, headers=null)";
    }
}
