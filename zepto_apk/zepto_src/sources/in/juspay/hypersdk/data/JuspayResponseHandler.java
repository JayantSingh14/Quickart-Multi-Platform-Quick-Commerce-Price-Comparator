package in.juspay.hypersdk.data;

import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public interface JuspayResponseHandler extends Runnable {
    @Keep
    void onError(String str);

    void onResponse(Bundle bundle);

    void onResponse(String str);
}
