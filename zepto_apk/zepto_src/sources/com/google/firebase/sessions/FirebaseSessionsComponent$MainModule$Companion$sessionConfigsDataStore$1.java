package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes4.dex */
final class FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1 extends Lambda implements Function1<CorruptionException, Preferences> {

    /* renamed from: c, reason: collision with root package name */
    public static final FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1 f44998c = new FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CorruptionException ex = (CorruptionException) obj;
        Intrinsics.checkNotNullParameter(ex, "ex");
        Log.w(FirebaseSessionsRegistrar.TAG, "CorruptionException in settings DataStore in " + ProcessDetailsProvider.b() + ClassUtils.PACKAGE_SEPARATOR_CHAR, ex);
        return new MutablePreferences(true, 1);
    }
}
