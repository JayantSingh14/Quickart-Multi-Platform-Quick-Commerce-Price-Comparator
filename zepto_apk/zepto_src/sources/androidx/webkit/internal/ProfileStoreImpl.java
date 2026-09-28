package androidx.webkit.internal;

import androidx.webkit.Profile;
import androidx.webkit.ProfileStore;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.reflect.InvocationHandler;
import java.util.List;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class ProfileStoreImpl implements ProfileStore {

    /* renamed from: b, reason: collision with root package name */
    public static ProfileStoreImpl f12435b;

    /* renamed from: a, reason: collision with root package name */
    public final ProfileStoreBoundaryInterface f12436a;

    public ProfileStoreImpl(ProfileStoreBoundaryInterface profileStoreBoundaryInterface) {
        this.f12436a = profileStoreBoundaryInterface;
    }

    public static ProfileStore getInstance() {
        if (f12435b == null) {
            f12435b = new ProfileStoreImpl(WebViewGlueCommunicator.LAZY_FACTORY_HOLDER.f12462a.getProfileStore());
        }
        return f12435b;
    }

    @Override // androidx.webkit.ProfileStore
    public final boolean deleteProfile(String str) {
        if (WebViewFeatureInternal.n.d()) {
            return this.f12436a.deleteProfile(str);
        }
        throw WebViewFeatureInternal.a();
    }

    @Override // androidx.webkit.ProfileStore
    public final List getAllProfileNames() {
        if (WebViewFeatureInternal.n.d()) {
            return this.f12436a.getAllProfileNames();
        }
        throw WebViewFeatureInternal.a();
    }

    @Override // androidx.webkit.ProfileStore
    public final Profile getOrCreateProfile(String str) {
        if (WebViewFeatureInternal.n.d()) {
            return new ProfileImpl((ProfileBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ProfileBoundaryInterface.class, this.f12436a.getOrCreateProfile(str)));
        }
        throw WebViewFeatureInternal.a();
    }

    @Override // androidx.webkit.ProfileStore
    public final Profile getProfile(String str) {
        if (!WebViewFeatureInternal.n.d()) {
            throw WebViewFeatureInternal.a();
        }
        InvocationHandler profile = this.f12436a.getProfile(str);
        if (profile != null) {
            return new ProfileImpl((ProfileBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ProfileBoundaryInterface.class, profile));
        }
        return null;
    }
}
