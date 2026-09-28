package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmName
/* loaded from: classes.dex */
public final class PreferencesKeys {
    public static final Preferences.Key a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Preferences.Key(name);
    }
}
