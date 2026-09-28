package io.invertase.firebase.messaging;

/* loaded from: classes4.dex */
public class ReactNativeFirebaseMessagingStoreHelper {

    /* renamed from: b, reason: collision with root package name */
    public static ReactNativeFirebaseMessagingStoreHelper f49253b;

    /* renamed from: a, reason: collision with root package name */
    public ReactNativeFirebaseMessagingStoreImpl f49254a;

    public static ReactNativeFirebaseMessagingStoreHelper a() {
        if (f49253b == null) {
            ReactNativeFirebaseMessagingStoreHelper reactNativeFirebaseMessagingStoreHelper = new ReactNativeFirebaseMessagingStoreHelper();
            reactNativeFirebaseMessagingStoreHelper.f49254a = new ReactNativeFirebaseMessagingStoreImpl();
            f49253b = reactNativeFirebaseMessagingStoreHelper;
        }
        return f49253b;
    }

    public final ReactNativeFirebaseMessagingStoreImpl b() {
        return this.f49254a;
    }
}
