package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;

@AutoValue
/* loaded from: classes3.dex */
public abstract class BackendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract BackendRequest a();

        public abstract Builder b(ArrayList arrayList);

        public abstract Builder c(byte[] bArr);
    }

    public static Builder a() {
        return new AutoValue_BackendRequest.Builder();
    }

    public abstract Iterable b();

    public abstract byte[] c();
}
