package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStore;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate implements ReadOnlyProperty<Context, DataStore<Preferences>> {

    /* renamed from: a, reason: collision with root package name */
    public final String f3695a;

    /* renamed from: b, reason: collision with root package name */
    public final ReplaceFileCorruptionHandler f3696b;

    /* renamed from: c, reason: collision with root package name */
    public final Function1 f3697c;

    /* renamed from: d, reason: collision with root package name */
    public final CoroutineScope f3698d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f3699e;

    /* renamed from: f, reason: collision with root package name */
    public volatile PreferenceDataStore f3700f;

    public PreferenceDataStoreSingletonDelegate(String name, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, Function1 produceMigrations, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f3695a = name;
        this.f3696b = replaceFileCorruptionHandler;
        this.f3697c = produceMigrations;
        this.f3698d = scope;
        this.f3699e = new Object();
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        PreferenceDataStore preferenceDataStore;
        Context thisRef = (Context) obj;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        PreferenceDataStore preferenceDataStore2 = this.f3700f;
        if (preferenceDataStore2 != null) {
            return preferenceDataStore2;
        }
        synchronized (this.f3699e) {
            try {
                if (this.f3700f == null) {
                    final Context applicationContext = thisRef.getApplicationContext();
                    ReplaceFileCorruptionHandler replaceFileCorruptionHandler = this.f3696b;
                    Function1 function1 = this.f3697c;
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    this.f3700f = PreferenceDataStoreFactory.a(replaceFileCorruptionHandler, (List) function1.invoke(applicationContext), this.f3698d, new Function0<File>() { // from class: androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate$getValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Context applicationContext2 = applicationContext;
                            Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                            return PreferenceDataStoreFile.a(applicationContext2, this.f3695a);
                        }
                    });
                }
                preferenceDataStore = this.f3700f;
                Intrinsics.c(preferenceDataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferenceDataStore;
    }
}
