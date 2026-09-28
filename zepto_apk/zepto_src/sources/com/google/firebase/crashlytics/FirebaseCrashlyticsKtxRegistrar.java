package com.google.firebase.crashlytics;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes.dex */
public final class FirebaseCrashlyticsKtxRegistrar implements ComponentRegistrar {

    @NotNull
    public static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List<Component<?>> getComponents() {
        return EmptyList.f53609a;
    }
}
