package in.juspay.hyperinteg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import in.juspay.hypersdk.core.JuspayWebViewConfigurationCallback;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import in.juspay.services.HyperServices;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public class HyperServiceHolder extends HyperPaymentsCallbackAdapter {
    private static HyperPaymentsCallback callback;
    private static final Queue<Pair<JSONObject, JuspayResponseHandler>> events = new LinkedList();

    @SuppressLint({"StaticFieldLeak"})
    private static HyperServices hyperServices;

    @NonNull
    private final FragmentActivity fragmentActivity;

    @Keep
    public HyperServiceHolder(@NonNull FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
        if (hyperServices == null) {
            hyperServices = new HyperServices(fragmentActivity);
        }
    }

    private void runQueuedEvents() {
        while (true) {
            Queue<Pair<JSONObject, JuspayResponseHandler>> queue = events;
            if (queue.peek() == null) {
                return;
            }
            Pair<JSONObject, JuspayResponseHandler> pairPoll = queue.poll();
            if (pairPoll != null) {
                callback.onEvent((JSONObject) pairPoll.first, (JuspayResponseHandler) pairPoll.second);
            }
        }
    }

    @Keep
    public HyperServices getHyperServices() {
        if (hyperServices == null) {
            hyperServices = new HyperServices(this.fragmentActivity);
        }
        return hyperServices;
    }

    @Override // in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter, in.juspay.hypersdk.ui.HyperPaymentsCallback
    @Nullable
    public View getMerchantView(@NonNull ViewGroup viewGroup, @NonNull MerchantViewType merchantViewType) {
        HyperPaymentsCallback hyperPaymentsCallback = callback;
        if (hyperPaymentsCallback != null) {
            return hyperPaymentsCallback.getMerchantView(viewGroup, merchantViewType);
        }
        return null;
    }

    @Keep
    public void initiate(JSONObject jSONObject) throws JSONException {
        getHyperServices().initiate(this.fragmentActivity, jSONObject, this);
    }

    @Keep
    public boolean isInitialised() {
        return getHyperServices().isInitialised();
    }

    @Keep
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        getHyperServices().onActivityResult(i2, i3, intent);
    }

    @Keep
    public boolean onBackPressed() {
        return getHyperServices().onBackPressed();
    }

    @Override // in.juspay.hypersdk.ui.HyperPaymentsCallback
    public void onEvent(@NonNull JSONObject jSONObject, @NonNull JuspayResponseHandler juspayResponseHandler) {
        HyperPaymentsCallback hyperPaymentsCallback = callback;
        if (hyperPaymentsCallback != null) {
            hyperPaymentsCallback.onEvent(jSONObject, juspayResponseHandler);
        } else {
            events.add(new Pair<>(jSONObject, juspayResponseHandler));
        }
    }

    @Keep
    public void preFetch(Context context, JSONObject jSONObject) {
        HyperServices.preFetch(context, jSONObject);
    }

    @Keep
    public void process(ViewGroup viewGroup, JSONObject jSONObject) throws JSONException {
        getHyperServices().process(this.fragmentActivity, viewGroup, jSONObject);
    }

    @Keep
    public void resetActivity() {
        HyperServices hyperServices2 = hyperServices;
        if (hyperServices2 != null) {
            hyperServices2.resetActivity(this.fragmentActivity);
        }
    }

    @Keep
    public void setCallback(HyperPaymentsCallback hyperPaymentsCallback) {
        callback = hyperPaymentsCallback;
        runQueuedEvents();
    }

    @Keep
    public void setIntentSenderDelegate(IntentSenderDelegate intentSenderDelegate) {
        getHyperServices().setIntentSenderDelegate(intentSenderDelegate);
    }

    @Keep
    public void setRequestPermissionDelegate(RequestPermissionDelegate requestPermissionDelegate) {
        getHyperServices().setRequestPermissionDelegate(requestPermissionDelegate);
    }

    @Keep
    public void setWebViewConfigurationCallback(JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback) {
        getHyperServices().setWebViewConfigurationCallback(juspayWebViewConfigurationCallback);
    }

    @Keep
    public void terminate() {
        getHyperServices().terminate();
    }

    @Keep
    public void process(JSONObject jSONObject) {
        getHyperServices().process(this.fragmentActivity, jSONObject);
    }

    @Keep
    public HyperServiceHolder(@NonNull FragmentActivity fragmentActivity, HyperPaymentsCallback hyperPaymentsCallback) {
        this(fragmentActivity);
        callback = hyperPaymentsCallback;
        runQueuedEvents();
    }

    @Keep
    public HyperServiceHolder(@NonNull FragmentActivity fragmentActivity, @NonNull String str) {
        this.fragmentActivity = fragmentActivity;
        if (hyperServices == null) {
            hyperServices = new HyperServices(fragmentActivity, str);
        }
    }

    @Keep
    public HyperServiceHolder(@NonNull FragmentActivity fragmentActivity, @NonNull String str, @NonNull String str2) {
        this.fragmentActivity = fragmentActivity;
        if (hyperServices == null) {
            hyperServices = new HyperServices(fragmentActivity, str, str2);
        }
    }
}
