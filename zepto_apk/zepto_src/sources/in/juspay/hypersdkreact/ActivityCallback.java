package in.juspay.hypersdkreact;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes4.dex */
public interface ActivityCallback {
    boolean onBackPressed();

    void onCreated(@NonNull FragmentActivity fragmentActivity);

    void resetActivity(@NonNull FragmentActivity fragmentActivity);
}
