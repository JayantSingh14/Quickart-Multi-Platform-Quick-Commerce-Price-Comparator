package androidx.fragment.app;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f4729a;

    public /* synthetic */ d(Fragment fragment) {
        this.f4729a = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Fragment fragment = this.f4729a;
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = fragment.mViewLifecycleOwner;
        fragmentViewLifecycleOwner.f4685f.b(fragment.mSavedViewRegistryState);
        fragment.mSavedViewRegistryState = null;
    }
}
