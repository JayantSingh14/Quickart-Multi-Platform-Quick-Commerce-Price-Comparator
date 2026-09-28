package in.juspay.hyper.core;

import android.app.Activity;
import android.content.Context;
import in.juspay.hyper.bridge.HyperBridge;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public interface BridgeComponents {
    @Nullable
    Activity getActivity();

    @NotNull
    CallbackInvoker getCallbackInvoker();

    @Nullable
    String getClientId();

    @NotNull
    Context getContext();

    @NotNull
    FileProviderInterface getFileProviderInterface();

    @NotNull
    FragmentHooks getFragmentHooks();

    @Nullable
    JsCallback getJsCallback();

    @NotNull
    JSONObject getSdkConfig();

    @NotNull
    String getSdkName();

    @NotNull
    SessionInfoInterface getSessionInfoInterface();

    @NotNull
    TrackerInterface getTrackerInterface();

    @NotNull
    IWorkspace getWorkspace();

    void registerService(@NotNull String str, @NotNull HyperBridge hyperBridge);
}
