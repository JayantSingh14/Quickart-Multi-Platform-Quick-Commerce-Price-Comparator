package com.rt2zz.reactnativecontacts.impl;

import com.facebook.react.bridge.Promise;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46698a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContactsManagerImpl f46699b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Promise f46700c;

    public /* synthetic */ b(ContactsManagerImpl contactsManagerImpl, Promise promise, int i2) {
        this.f46698a = i2;
        this.f46699b = contactsManagerImpl;
        this.f46700c = promise;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f46698a) {
            case 0:
                this.f46699b.lambda$getCount$1(this.f46700c);
                break;
            default:
                this.f46699b.lambda$getAllContacts$0(this.f46700c);
                break;
        }
    }
}
