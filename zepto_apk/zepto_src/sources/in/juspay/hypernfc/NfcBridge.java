package in.juspay.hypernfc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.cardreader.card_reader_lib.CardTask;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.CallbackInvoker;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class NfcBridge extends HyperBridge {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NFC_CARD_REQUEST = 121;
    private static final int SETTINGS_REQUEST = 144;

    @Nullable
    private String callback;

    @NotNull
    private final CardTask cardTask;
    private int waitingTime;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NfcBridge(@NotNull BridgeComponents bridgeComponents) {
        super(bridgeComponents);
        Intrinsics.checkNotNullParameter(bridgeComponents, "bridgeComponents");
        this.cardTask = new CardTask();
    }

    private final void showLoadingScreen(String str, int i2) {
        this.callback = str;
        this.waitingTime = i2;
        Intent intent = new Intent(getBridgeComponents().getContext(), (Class<?>) NfcActivity.class);
        intent.putExtra("waitingTime", i2);
        getBridgeComponents().getFragmentHooks().startActivityForResult(intent, 121, null);
    }

    @JavascriptInterface
    public final boolean isNFCEnabled() {
        return this.cardTask.isNFCEnabled(getBridgeComponents().getContext());
    }

    @JavascriptInterface
    public final boolean isNFCSupportPresent() {
        return this.cardTask.isNFCSupported(getBridgeComponents().getContext());
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Bundle extras;
        if (i2 != SETTINGS_REQUEST && i2 != 121) {
            return false;
        }
        if (intent != null) {
            try {
                extras = intent.getExtras();
            } catch (Exception unused) {
                getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, "{\"error\":\"Couldn't read the card! Try again or type your card number\"}");
            }
        } else {
            extras = null;
        }
        if (i2 == 121 && (i3 == -1 || i3 == 0)) {
            if (intent != null && intent.hasExtra("result_data")) {
                getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, extras != null ? extras.getString("result_data") : null);
                return true;
            }
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, "{\"error\":\"Couldn't read the card! Try again or type your card number\"}");
        } else {
            if (i2 == SETTINGS_REQUEST && isNFCEnabled()) {
                openNFCReader(this.callback, this.waitingTime);
                return true;
            }
            if (i2 == SETTINGS_REQUEST && !isNFCEnabled()) {
                getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, "{\"error\":\"Permission denied!\"}");
                return true;
            }
        }
        return false;
    }

    @JavascriptInterface
    public final void openNFCReader(@Nullable String str, int i2) throws JSONException {
        this.callback = str;
        this.waitingTime = i2;
        try {
            if (isNFCSupportPresent() && isNFCEnabled()) {
                showLoadingScreen(str, this.waitingTime);
                return;
            }
            if (isNFCSupportPresent()) {
                getBridgeComponents().getFragmentHooks().startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), SETTINGS_REQUEST, null);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", "Does not support");
            jSONObject.put("data", (Object) null);
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(this.callback, jSONObject.toString());
        } catch (Exception e2) {
            CallbackInvoker callbackInvoker = getBridgeComponents().getCallbackInvoker();
            byte[] bytes = e2.toString().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String str2 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes, 2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            callbackInvoker.invokeCallbackInDUIWebview(str, str2);
        }
    }
}
