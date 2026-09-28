package in.juspay.hypersdk.lifecycle;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public enum FragmentEvent {
    ON_PAUSE("onPause"),
    ON_RESUME("onResume"),
    ON_STOP("onStop"),
    ON_DESTROY("onDestroy"),
    ON_SAVED_STATE_INSTANCE("OnSavedStateInstance"),
    ON_ACTIVITY_RESULT("onActivityResult"),
    ON_REQUEST_PERMISSION_RESULT("onRequestPermissionResult"),
    ON_ATTACH("onAttach");


    @NotNull
    private final String key;

    FragmentEvent(String str) {
        this.key = str;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
