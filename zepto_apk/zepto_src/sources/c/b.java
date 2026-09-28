package c;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.User;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.shared.APIListener;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class b implements APIListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Listener f13230a;

    public b(Listener listener) {
        this.f13230a = listener;
    }

    @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public final void onError(AuthError authError) {
        this.f13230a.onError(authError);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public final void onSuccess(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(AuthzConstants.BUNDLE_KEY.PROFILE.val);
        HashMap map = new HashMap(bundle2.size());
        for (String str : bundle2.keySet()) {
            map.put(str, bundle2.getString(str));
        }
        this.f13230a.onSuccess(new User(map));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.shared.APIListener
    public final void onError(AuthError authError) {
        this.f13230a.onError(authError);
    }
}
