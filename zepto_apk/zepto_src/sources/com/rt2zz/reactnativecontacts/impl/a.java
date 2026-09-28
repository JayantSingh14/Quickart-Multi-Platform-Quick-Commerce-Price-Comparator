package com.rt2zz.reactnativecontacts.impl;

import com.facebook.react.bridge.Promise;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46694a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContactsManagerImpl f46695b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f46696c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Promise f46697d;

    public /* synthetic */ a(ContactsManagerImpl contactsManagerImpl, String str, Promise promise, int i2) {
        this.f46694a = i2;
        this.f46695b = contactsManagerImpl;
        this.f46696c = str;
        this.f46697d = promise;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f46694a) {
            case 0:
                this.f46695b.lambda$getContactsByEmailAddress$3(this.f46696c, this.f46697d);
                break;
            case 1:
                this.f46695b.lambda$getContactById$5(this.f46696c, this.f46697d);
                break;
            case 2:
                this.f46695b.lambda$getPhotoForId$4(this.f46696c, this.f46697d);
                break;
            default:
                this.f46695b.lambda$getContactsMatchingString$2(this.f46696c, this.f46697d);
                break;
        }
    }
}
