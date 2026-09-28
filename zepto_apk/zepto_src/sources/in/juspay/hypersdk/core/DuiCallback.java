package in.juspay.hypersdk.core;

import in.juspay.hyper.core.JsCallback;

/* loaded from: classes4.dex */
public interface DuiCallback extends JsCallback {
    InflateView getInflateView();

    DuiLogger getLogger();

    void setInGlobalState(String str, Object obj);
}
