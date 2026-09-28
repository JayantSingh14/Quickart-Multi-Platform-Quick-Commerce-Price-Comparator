package coil3.network;

import coil3.annotation.ExperimentalCoilApi;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata
@ExperimentalCoilApi
/* loaded from: classes.dex */
public interface ConnectivityChecker {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final ConnectivityChecker ONLINE = new ConnectivityChecker() { // from class: coil3.network.a
        @Override // coil3.network.ConnectivityChecker
        public final boolean isOnline() {
            return ConnectivityChecker.ONLINE$lambda$0();
        }
    };

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static boolean ONLINE$lambda$0() {
        return true;
    }

    boolean isOnline();
}
