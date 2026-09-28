package com.google.firebase.messaging;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: classes4.dex */
public final /* synthetic */ class j implements OnSuccessListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44832a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f44833b;

    public /* synthetic */ j(FirebaseMessaging firebaseMessaging, int i2) {
        this.f44832a = i2;
        this.f44833b = firebaseMessaging;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) throws NumberFormatException {
        FirebaseMessaging firebaseMessaging = this.f44833b;
        switch (this.f44832a) {
            case 0:
                ProxyNotificationPreferences.b(firebaseMessaging.f44702c, firebaseMessaging.f44703d, firebaseMessaging.l());
                break;
            default:
                CloudMessage cloudMessage = (CloudMessage) obj;
                Store store = FirebaseMessaging.f44699m;
                firebaseMessaging.getClass();
                if (cloudMessage != null) {
                    MessagingAnalytics.b(cloudMessage.f22232a);
                    firebaseMessaging.g();
                    break;
                }
                break;
        }
    }
}
