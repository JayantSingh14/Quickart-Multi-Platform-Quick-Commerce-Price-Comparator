package c;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.AuthorizeResult;
import com.amazon.identity.auth.device.api.authorization.User;
import com.amazon.identity.auth.device.interactive.InteractiveListener;

/* loaded from: classes3.dex */
public final class a implements Listener<User, AuthError> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractiveListener f13228a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f13229b;

    public a(InteractiveListener interactiveListener, Bundle bundle) {
        this.f13228a = interactiveListener;
        this.f13229b = bundle;
    }

    @Override // com.amazon.identity.auth.device.api.Listener
    public final void onError(AuthError authError) {
        this.f13228a.onError(authError);
    }

    @Override // com.amazon.identity.auth.device.api.Listener
    public final void onSuccess(User user) {
        this.f13228a.onSuccess(new AuthorizeResult(this.f13229b, user));
    }
}
