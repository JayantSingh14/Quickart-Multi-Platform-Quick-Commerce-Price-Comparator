package in.juspay.hypersdk.core;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public interface DUIMerchantView {
    @Nullable
    View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType);
}
