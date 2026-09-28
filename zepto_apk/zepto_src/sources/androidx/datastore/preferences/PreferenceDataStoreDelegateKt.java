package androidx.datastore.preferences;

import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@JvmName
/* loaded from: classes.dex */
public final class PreferenceDataStoreDelegateKt {
    public static PreferenceDataStoreSingletonDelegate a(ReplaceFileCorruptionHandler replaceFileCorruptionHandler) {
        PreferenceDataStoreDelegateKt$preferencesDataStore$1 produceMigrations = PreferenceDataStoreDelegateKt$preferencesDataStore$1.f3694c;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        ContextScope scope = CoroutineScopeKt.a(DefaultIoScheduler.f55150b.plus(SupervisorKt.b()));
        Intrinsics.checkNotNullParameter("secure_prefs", CLConstants.FIELD_PAY_INFO_NAME);
        Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new PreferenceDataStoreSingletonDelegate("secure_prefs", replaceFileCorruptionHandler, produceMigrations, scope);
    }
}
