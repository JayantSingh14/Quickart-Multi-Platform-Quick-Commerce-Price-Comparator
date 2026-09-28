package com.rt2zz.reactnativecontacts;

import android.app.Activity;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.rt2zz.reactnativecontacts.impl.ContactsManagerImpl;

/* loaded from: classes.dex */
public class ContactsManager extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final ContactsManagerImpl contactsManagerImpl;

    public ContactsManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.contactsManagerImpl = new ContactsManagerImpl(reactApplicationContext, true);
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void addContact(ReadableMap readableMap, Promise promise) throws RemoteException, OperationApplicationException {
        this.contactsManagerImpl.addContact(readableMap, promise);
    }

    @ReactMethod
    public void checkPermission(Promise promise) {
        this.contactsManagerImpl.checkPermission(promise);
    }

    @ReactMethod
    public void deleteContact(ReadableMap readableMap, Promise promise) {
        this.contactsManagerImpl.deleteContact(readableMap, promise);
    }

    @ReactMethod
    public void editExistingContact(ReadableMap readableMap, Promise promise) {
        this.contactsManagerImpl.editExistingContact(readableMap, promise);
    }

    @ReactMethod
    public void getAll(Promise promise) {
        this.contactsManagerImpl.getAll(promise);
    }

    @ReactMethod
    public void getAllWithoutPhotos(Promise promise) {
        this.contactsManagerImpl.getAllWithoutPhotos(promise);
    }

    @ReactMethod
    public void getContactById(String str, Promise promise) {
        this.contactsManagerImpl.getContactById(str, promise);
    }

    @ReactMethod
    public void getContactsByEmailAddress(String str, Promise promise) {
        this.contactsManagerImpl.getContactsByEmailAddress(str, promise);
    }

    @ReactMethod
    public void getContactsByPhoneNumber(String str, Promise promise) {
        this.contactsManagerImpl.getContactsByPhoneNumber(str, promise);
    }

    @ReactMethod
    public void getContactsMatchingString(String str, Promise promise) {
        this.contactsManagerImpl.getContactsMatchingString(str, promise);
    }

    @ReactMethod
    public void getCount(Promise promise) {
        this.contactsManagerImpl.getCount(promise);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return ContactsProvider.NAME;
    }

    @ReactMethod
    public void getPhotoForId(String str, Promise promise) {
        this.contactsManagerImpl.getPhotoForId(str, promise);
    }

    @ReactMethod
    public void iosEnableNotesUsage(boolean z) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        this.contactsManagerImpl.onActivityResult(activity, i2, i3, intent);
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
        this.contactsManagerImpl.onNewIntent(intent);
    }

    @ReactMethod
    public void openContactForm(ReadableMap readableMap, Promise promise) {
        this.contactsManagerImpl.openContactForm(readableMap, promise);
    }

    @ReactMethod
    public void openExistingContact(ReadableMap readableMap, Promise promise) {
        this.contactsManagerImpl.openExistingContact(readableMap, promise);
    }

    @ReactMethod
    public void requestPermission(Promise promise) {
        this.contactsManagerImpl.requestPermission(promise);
    }

    @ReactMethod
    public void updateContact(ReadableMap readableMap, Promise promise) throws RemoteException, OperationApplicationException {
        this.contactsManagerImpl.updateContact(readableMap, promise);
    }

    @ReactMethod
    public void viewExistingContact(ReadableMap readableMap, Promise promise) {
        this.contactsManagerImpl.viewExistingContact(readableMap, promise);
    }

    @ReactMethod
    public void writePhotoToPath(String str, String str2, Promise promise) {
        this.contactsManagerImpl.writePhotoToPath(str, str2, promise);
    }
}
