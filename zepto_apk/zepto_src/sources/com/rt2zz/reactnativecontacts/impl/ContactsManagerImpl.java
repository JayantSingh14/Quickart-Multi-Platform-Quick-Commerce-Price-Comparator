package com.rt2zz.reactnativecontacts.impl;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.source.h;
import com.appsflyer.AdRevenueScheme;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import com.rt2zz.reactnativecontacts.ContactsProvider;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class ContactsManagerImpl {
    private static final String PERMISSION_AUTHORIZED = "authorized";
    private static final String PERMISSION_DENIED = "denied";
    private static final String PERMISSION_READ_CONTACTS = "android.permission.READ_CONTACTS";
    private static final int PERMISSION_REQUEST_CODE = 888;
    private static final int REQUEST_OPEN_CONTACT_FORM = 52941;
    private static final int REQUEST_OPEN_EXISTING_CONTACT = 52942;
    private static Promise requestPromise;
    private static Promise updateContactPromise;
    private Executor executor;
    private final ReactApplicationContext reactApplicationContext;

    public ContactsManagerImpl(ReactApplicationContext reactApplicationContext, boolean z) {
        this.reactApplicationContext = reactApplicationContext;
        this.executor = initializeExecutor(z);
    }

    private void getAllContacts(Promise promise) {
        getExecutor().execute(new b(this, promise, 1));
    }

    private Bitmap getThumbnailBitmap(String str) throws IOException {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile == null) {
            try {
                InputStream inputStreamOpen = getReactApplicationContext().getAssets().open(str);
                bitmapDecodeFile = BitmapFactory.decodeStream(inputStreamOpen);
                inputStreamOpen.close();
                return bitmapDecodeFile;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return bitmapDecodeFile;
    }

    private String getValueFromKey(ReadableMap readableMap, String str) {
        return readableMap.hasKey(str) ? readableMap.getString(str) : "";
    }

    private Executor initializeExecutor(boolean z) {
        return z ? Executors.newSingleThreadExecutor() : Executors.newCachedThreadPool();
    }

    private String isPermissionGranted() {
        return ContextCompat.a(getReactApplicationContext(), PERMISSION_READ_CONTACTS) == 0 ? PERMISSION_AUTHORIZED : PERMISSION_DENIED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllContacts$0(Promise promise) {
        promise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getContacts());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getContactById$5(String str, Promise promise) {
        promise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getContactById(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getContactsByEmailAddress$3(String str, Promise promise) {
        promise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getContactsByEmailAddress(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getContactsMatchingString$2(String str, Promise promise) {
        promise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getContactsMatchingString(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCount$1(Promise promise) {
        try {
            promise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getContactsCount());
        } catch (Exception e2) {
            promise.reject(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhotoForId$4(String str, Promise promise) {
        promise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getPhotoUriFromContactId(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$writePhotoToPath$6(String str, String str2, Promise promise) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(getReactApplicationContext().getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.parseLong(str)));
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenContactPhotoInputStream);
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                bitmapDecodeStream.compress(compressFormat, 100, fileOutputStream);
                promise.resolve(Boolean.TRUE);
                fileOutputStream.close();
                fileOutputStream2 = compressFormat;
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                promise.reject(e.toString());
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    fileOutputStream2 = fileOutputStream2;
                }
                inputStreamOpenContactPhotoInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            inputStreamOpenContactPhotoInputStream.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private int mapStringToEmailType(String str) {
        str.getClass();
        switch (str) {
            case "mobile":
                return 4;
            case "home":
                return 1;
            case "work":
                return 2;
            case "other":
                return 3;
            case "personal":
                return 1;
            default:
                return 0;
        }
    }

    private int mapStringToPhoneType(String str) {
        str.getClass();
        switch (str) {
            case "mobile":
                return 2;
            case "work_pager":
                return 18;
            case "home fax":
                return 5;
            case "work_mobile":
                return 17;
            case "cell":
                return 2;
            case "home":
                return 1;
            case "main":
                return 12;
            case "work":
                return 3;
            case "work fax":
                return 4;
            case "other":
                return 7;
            case "pager":
                return 6;
            default:
                return 0;
        }
    }

    private int mapStringToPostalAddressType(String str) {
        str.getClass();
        if (str.equals("home")) {
            return 1;
        }
        return !str.equals("work") ? 0 : 2;
    }

    public static void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Promise promise = requestPromise;
        if (promise == null) {
            return;
        }
        if (i2 != PERMISSION_REQUEST_CODE) {
            promise.resolve(PERMISSION_DENIED);
            return;
        }
        Hashtable hashtable = new Hashtable();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            hashtable.put(strArr[i3], Boolean.valueOf(iArr[i3] == 0));
        }
        if (hashtable.containsKey(PERMISSION_READ_CONTACTS) && ((Boolean) hashtable.get(PERMISSION_READ_CONTACTS)).booleanValue()) {
            requestPromise.resolve(PERMISSION_AUTHORIZED);
        } else {
            requestPromise.resolve(PERMISSION_DENIED);
        }
        requestPromise = null;
    }

    private void requestReadContactsPermission(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(PERMISSION_DENIED);
        } else if (isPermissionGranted().equals(PERMISSION_AUTHORIZED)) {
            promise.resolve(PERMISSION_AUTHORIZED);
        } else {
            requestPromise = promise;
            ActivityCompat.i(currentActivity, new String[]{PERMISSION_READ_CONTACTS}, PERMISSION_REQUEST_CODE);
        }
    }

    public void addContact(ReadableMap readableMap, Promise promise) throws RemoteException, OperationApplicationException {
        String[] strArr;
        int size;
        Integer[] numArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        int i2;
        int i3;
        int size2;
        String[] strArr5;
        Integer[] numArr2;
        String[] strArr6;
        String[] strArr7;
        String[] strArr8;
        int size3;
        String[] strArr9;
        Promise promise2;
        Bitmap thumbnailBitmap;
        int i4;
        if (readableMap == null) {
            promise.reject("New contact cannot be null.");
            return;
        }
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string4 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string5 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string6 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string7 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string8 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string9 = readableMap.hasKey(CLConstants.LABEL_NOTE) ? readableMap.getString(CLConstants.LABEL_NOTE) : null;
        String string10 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        String str = "label";
        if (array != null) {
            size = array.size();
            String[] strArr10 = new String[size];
            numArr = new Integer[size];
            strArr2 = new String[size];
            int i5 = 0;
            while (true) {
                int i6 = size;
                if (i5 >= size) {
                    break;
                }
                strArr10[i5] = array.getMap(i5).getString("number");
                String string11 = array.getMap(i5).getString("label");
                numArr[i5] = Integer.valueOf(mapStringToPhoneType(string11));
                strArr2[i5] = string11;
                i5++;
                size = i6;
                string10 = string10;
            }
            strArr = strArr10;
        } else {
            strArr = null;
            size = 0;
            numArr = null;
            strArr2 = null;
        }
        String str2 = string10;
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            int size4 = array2.size();
            strArr3 = strArr;
            String[] strArr11 = new String[size4];
            int i7 = 0;
            while (true) {
                i4 = size4;
                if (i7 >= size4) {
                    break;
                }
                int i8 = i7;
                strArr11[i8] = array2.getMap(i7).getString("url");
                i7 = i8 + 1;
                size4 = i4;
            }
            strArr4 = strArr11;
            i2 = i4;
        } else {
            strArr3 = strArr;
            strArr4 = null;
            i2 = 0;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        String[] strArr12 = strArr4;
        if (array3 != null) {
            size2 = array3.size();
            i3 = i2;
            String[] strArr13 = new String[size2];
            numArr2 = new Integer[size2];
            strArr6 = new String[size2];
            int i9 = 0;
            while (true) {
                int i10 = size2;
                if (i9 >= size2) {
                    break;
                }
                strArr13[i9] = array3.getMap(i9).getString(Scopes.EMAIL);
                String string12 = array3.getMap(i9).getString("label");
                numArr2[i9] = Integer.valueOf(mapStringToEmailType(string12));
                strArr6[i9] = string12;
                i9++;
                size2 = i10;
                size = size;
            }
            strArr5 = strArr13;
        } else {
            i3 = i2;
            size2 = 0;
            strArr5 = null;
            numArr2 = null;
            strArr6 = null;
        }
        int i11 = size;
        ReadableArray array4 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array4 != null) {
            size3 = array4.size();
            strArr7 = strArr5;
            String[] strArr14 = new String[size3];
            strArr9 = new String[size3];
            int i12 = 0;
            while (true) {
                int i13 = size3;
                if (i12 >= size3) {
                    break;
                }
                strArr14[i12] = array4.getMap(i12).getString("username");
                strArr9[i12] = array4.getMap(i12).getString(PaymentConstants.SERVICE);
                i12++;
                size3 = i13;
                str = str;
            }
            strArr8 = strArr14;
        } else {
            strArr7 = strArr5;
            strArr8 = null;
            size3 = 0;
            strArr9 = null;
        }
        String str3 = str;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        String[] strArr15 = strArr8;
        int i14 = size3;
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        Uri uri = ContactsContract.Data.CONTENT_URI;
        arrayList.add(ContentProviderOperation.newInsert(uri).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string).withValue("data5", string2).withValue("data3", string3).withValue("data4", string4).withValue("data6", string5).build());
        arrayList.add(ContentProviderOperation.newInsert(uri).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", string9).build());
        ContentProviderOperation.Builder builderWithValue = ContentProviderOperation.newInsert(uri).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", string6).withValue("data4", string7).withValue("data5", string8);
        arrayList.add(builderWithValue.build());
        int i15 = 1;
        builderWithValue.withYieldAllowed(true);
        for (int i16 = 0; i16 < i11; i16++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr3[i16]).withValue("data2", numArr[i16]).withValue("data3", strArr2[i16]).build());
        }
        int i17 = i3;
        for (int i18 = 0; i18 < i17; i18++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", strArr12[i18]).build());
        }
        for (int i19 = 0; i19 < size2; i19++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr7[i19]).withValue("data2", numArr2[i19]).withValue("data3", strArr6[i19]).build());
        }
        if (str2 != null && !str2.isEmpty() && (thumbnailBitmap = getThumbnailBitmap(str2)) != null) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", toByteArray(thumbnailBitmap)).build());
        }
        ReadableArray array5 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array5 != null) {
            int i20 = 0;
            while (i20 < array5.size()) {
                ReadableMap map = array5.getMap(i20);
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(mapStringToPostalAddressType(map.getString(str3)))).withValue("data3", map.getString(str3)).withValue("data4", map.getString("street")).withValue("data7", map.getString("city")).withValue("data8", map.getString("state")).withValue("data9", map.getString("postCode")).withValue("data10", map.getString(AdRevenueScheme.COUNTRY)).build());
                i20++;
                i15 = i15;
            }
        }
        int i21 = i15;
        for (int i22 = 0; i22 < i14; i22++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", strArr15[i22]).withValue("data2", Integer.valueOf(i21)).withValue("data5", -1).withValue("data6", strArr9[i22]).build());
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] contentProviderResultArrApplyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (contentProviderResultArrApplyBatch == null || contentProviderResultArrApplyBatch.length <= 0) {
                return;
            }
            WritableMap contactByRawId = new ContactsProvider(contentResolver).getContactByRawId(String.valueOf(ContentUris.parseId(contentProviderResultArrApplyBatch[0].uri)));
            promise2 = promise;
            try {
                promise2.resolve(contactByRawId);
            } catch (Exception e2) {
                e = e2;
                promise2.reject(e.toString());
            }
        } catch (Exception e3) {
            e = e3;
            promise2 = promise;
        }
    }

    public void checkPermission(Promise promise) {
        promise.resolve(isPermissionGranted());
    }

    public void deleteContact(ReadableMap readableMap, Promise promise) {
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        try {
            if (getReactApplicationContext().getContentResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, string), null, null) > 0) {
                promise.resolve(string);
            } else {
                promise.resolve(null);
            }
        } catch (Exception e2) {
            promise.reject(e2.toString());
        }
    }

    public void editExistingContact(ReadableMap readableMap, Promise promise) {
        int size;
        Integer[] numArr;
        String[] strArr = null;
        try {
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
            if (array != null) {
                size = array.size();
                strArr = new String[size];
                numArr = new Integer[size];
                for (int i2 = 0; i2 < size; i2++) {
                    strArr[i2] = array.getMap(i2).getString("number");
                    numArr[i2] = Integer.valueOf(mapStringToPhoneType(array.getMap(i2).getString("label")));
                }
            } else {
                size = 0;
                numArr = null;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < size; i3++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                contentValues.put("data2", numArr[i3]);
                contentValues.put("data1", strArr[i3]);
                arrayList.add(contentValues);
            }
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setDataAndType(uriWithAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            intent.putParcelableArrayListExtra("data", arrayList);
            updateContactPromise = promise;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e2) {
            promise.reject(e2.toString());
        }
    }

    public void getAll(Promise promise) {
        getAllContacts(promise);
    }

    public void getAllWithoutPhotos(Promise promise) {
        getAllContacts(promise);
    }

    public void getContactById(String str, Promise promise) {
        getExecutor().execute(new a(this, str, promise, 1));
    }

    public void getContactsByEmailAddress(String str, Promise promise) {
        getExecutor().execute(new a(this, str, promise, 0));
    }

    public void getContactsByPhoneNumber(final String str, final Promise promise) {
        getExecutor().execute(new Runnable() { // from class: com.rt2zz.reactnativecontacts.impl.ContactsManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                promise.resolve(new ContactsProvider(ContactsManagerImpl.this.getReactApplicationContext().getContentResolver()).getContactsByPhoneNumber(str));
            }
        });
    }

    public void getContactsMatchingString(String str, Promise promise) {
        getExecutor().execute(new a(this, str, promise, 3));
    }

    public void getCount(Promise promise) {
        getExecutor().execute(new b(this, promise, 0));
    }

    @Nullable
    public final Activity getCurrentActivity() {
        return this.reactApplicationContext.getCurrentActivity();
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public void getPhotoForId(String str, Promise promise) {
        getExecutor().execute(new a(this, str, promise, 2));
    }

    @NonNull
    public ReactApplicationContext getReactApplicationContext() {
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        Objects.requireNonNull(reactApplicationContext, "Context not initialized");
        return reactApplicationContext;
    }

    public void iosEnableNotesUsage(boolean z) {
    }

    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        Promise promise;
        Uri data;
        if ((i2 == REQUEST_OPEN_CONTACT_FORM || i2 == REQUEST_OPEN_EXISTING_CONTACT) && (promise = updateContactPromise) != null) {
            if (i3 != -1) {
                promise.resolve(null);
                updateContactPromise = null;
                return;
            }
            if (intent == null) {
                promise.reject("Error received activity result with no data!");
                updateContactPromise = null;
                return;
            }
            try {
                data = intent.getData();
            } catch (Exception e2) {
                updateContactPromise.reject(e2.getMessage());
            }
            if (data == null) {
                updateContactPromise.reject("Error wrong data. No content uri found!");
                updateContactPromise = null;
            } else {
                updateContactPromise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getContactById(data.getLastPathSegment()));
                updateContactPromise = null;
            }
        }
    }

    public void onNewIntent(Intent intent) {
    }

    public void openContactForm(ReadableMap readableMap, Promise promise) {
        String str;
        int size;
        String[] strArr;
        String[] strArr2;
        Integer[] numArr;
        String[] strArr3;
        int size2;
        String[] strArr4;
        String str2;
        int size3;
        String[] strArr5;
        Integer[] numArr2;
        String[] strArr6;
        int size4;
        String[] strArr7;
        String[] strArr8;
        String[] strArr9;
        String[] strArr10;
        String[] strArr11;
        String[] strArr12;
        String[] strArr13;
        Integer[] numArr3;
        int size5;
        String[] strArr14;
        String[] strArr15;
        Bitmap thumbnailBitmap;
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("displayName") ? readableMap.getString("displayName") : null;
        String string4 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string5 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string6 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string7 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string8 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string9 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string10 = readableMap.hasKey(CLConstants.LABEL_NOTE) ? readableMap.getString(CLConstants.LABEL_NOTE) : null;
        String string11 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        if (array != null) {
            size = array.size();
            str = string3;
            String[] strArr16 = new String[size];
            strArr2 = new String[size];
            numArr = new Integer[size];
            int i2 = 0;
            while (true) {
                int i3 = size;
                if (i2 >= size) {
                    break;
                }
                strArr16[i2] = array.getMap(i2).getString("number");
                String string12 = array.getMap(i2).getString("label");
                strArr2[i2] = string12;
                numArr[i2] = Integer.valueOf(mapStringToPhoneType(string12));
                i2++;
                size = i3;
                string11 = string11;
            }
            strArr = strArr16;
        } else {
            str = string3;
            size = 0;
            strArr = null;
            strArr2 = null;
            numArr = null;
        }
        String str3 = string11;
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            size2 = array2.size();
            strArr3 = strArr;
            String[] strArr17 = new String[size2];
            int i4 = 0;
            while (true) {
                int i5 = size2;
                if (i4 >= size2) {
                    break;
                }
                int i6 = i4;
                strArr17[i6] = array2.getMap(i4).getString("url");
                i4 = i6 + 1;
                size2 = i5;
            }
            strArr4 = strArr17;
        } else {
            strArr3 = strArr;
            size2 = 0;
            strArr4 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        String[] strArr18 = strArr4;
        if (array3 != null) {
            size3 = array3.size();
            str2 = string10;
            String[] strArr19 = new String[size3];
            numArr2 = new Integer[size3];
            int i7 = 0;
            while (true) {
                int i8 = size3;
                if (i7 >= size3) {
                    break;
                }
                strArr19[i7] = array3.getMap(i7).getString(Scopes.EMAIL);
                numArr2[i7] = Integer.valueOf(mapStringToEmailType(array3.getMap(i7).getString("label")));
                i7++;
                size3 = i8;
                size = size;
            }
            strArr5 = strArr19;
        } else {
            str2 = string10;
            size3 = 0;
            strArr5 = null;
            numArr2 = null;
        }
        int i9 = size;
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array4 != null) {
            size4 = array4.size();
            strArr6 = strArr5;
            strArr8 = new String[size4];
            strArr9 = new String[size4];
            String[] strArr20 = new String[size4];
            strArr10 = new String[size4];
            String[] strArr21 = new String[size4];
            strArr11 = new String[size4];
            strArr12 = new String[size4];
            strArr13 = new String[size4];
            numArr3 = new Integer[size4];
            int i10 = 0;
            while (true) {
                int i11 = size4;
                if (i10 >= size4) {
                    break;
                }
                strArr8[i10] = array4.getMap(i10).getString("street");
                strArr9[i10] = array4.getMap(i10).getString("city");
                strArr20[i10] = array4.getMap(i10).getString("state");
                strArr10[i10] = array4.getMap(i10).getString("region");
                strArr21[i10] = array4.getMap(i10).getString("postCode");
                strArr11[i10] = array4.getMap(i10).getString(AdRevenueScheme.COUNTRY);
                strArr12[i10] = array4.getMap(i10).getString("formattedAddress");
                strArr13[i10] = array4.getMap(i10).getString("label");
                numArr3[i10] = Integer.valueOf(mapStringToPostalAddressType(array4.getMap(i10).getString("label")));
                i10++;
                size4 = i11;
                size3 = size3;
            }
            strArr7 = strArr21;
        } else {
            strArr6 = strArr5;
            size4 = 0;
            strArr7 = null;
            strArr8 = null;
            strArr9 = null;
            strArr10 = null;
            strArr11 = null;
            strArr12 = null;
            strArr13 = null;
            numArr3 = null;
        }
        int i12 = size3;
        ReadableArray array5 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array5 != null) {
            size5 = array5.size();
            strArr14 = new String[size5];
            strArr15 = new String[size5];
            int i13 = 0;
            while (true) {
                int i14 = size5;
                if (i13 >= size5) {
                    break;
                }
                strArr15[i13] = array5.getMap(i13).getString("username");
                strArr14[i13] = array5.getMap(i13).getString(PaymentConstants.SERVICE);
                i13++;
                size5 = i14;
                strArr7 = strArr7;
            }
        } else {
            size5 = 0;
            strArr14 = null;
            strArr15 = null;
        }
        String[] strArr22 = strArr7;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ContentValues contentValues = new ContentValues();
        String[] strArr23 = strArr14;
        contentValues.put("mimetype", "vnd.android.cursor.item/identity");
        contentValues.put("data2", string);
        contentValues.put("data3", string4);
        contentValues.put("data5", string2);
        contentValues.put("data4", string5);
        contentValues.put("data6", string6);
        arrayList.add(contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues2.put("data1", string7);
        contentValues2.put("data4", string8);
        contentValues2.put("data5", string9);
        arrayList.add(contentValues2);
        for (int i15 = 0; i15 < size2; i15++) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/website");
            contentValues3.put("data1", strArr18[i15]);
            arrayList.add(contentValues3);
        }
        for (int i16 = 0; i16 < i12; i16++) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("mimetype", "vnd.android.cursor.item/email_v2");
            contentValues4.put("data2", numArr2[i16]);
            contentValues4.put("data1", strArr6[i16]);
            arrayList.add(contentValues4);
        }
        for (int i17 = 0; i17 < i9; i17++) {
            ContentValues contentValues5 = new ContentValues();
            contentValues5.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues5.put("data2", numArr[i17]);
            contentValues5.put("data3", strArr2[i17]);
            contentValues5.put("data1", strArr3[i17]);
            arrayList.add(contentValues5);
        }
        for (int i18 = 0; i18 < size4; i18++) {
            ContentValues contentValues6 = new ContentValues();
            contentValues6.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues6.put("data4", strArr8[i18]);
            contentValues6.put("data7", strArr9[i18]);
            contentValues6.put("data8", strArr10[i18]);
            contentValues6.put("data10", strArr11[i18]);
            contentValues6.put("data9", strArr22[i18]);
            contentValues6.put("data1", strArr12[i18]);
            contentValues6.put("data3", strArr13[i18]);
            contentValues6.put("data2", numArr3[i18]);
            arrayList.add(contentValues6);
        }
        for (int i19 = 0; i19 < size5; i19++) {
            ContentValues contentValues7 = new ContentValues();
            contentValues7.put("mimetype", "vnd.android.cursor.item/im");
            contentValues7.put("data1", strArr15[i19]);
            contentValues7.put("data2", (Integer) 1);
            contentValues7.put("data5", (Integer) (-1));
            contentValues7.put("data6", strArr23[i19]);
            arrayList.add(contentValues7);
        }
        if (str2 != null) {
            ContentValues contentValues8 = new ContentValues();
            contentValues8.put("mimetype", "vnd.android.cursor.item/note");
            contentValues8.put("data1", str2);
            arrayList.add(contentValues8);
        }
        if (str3 != null && !str3.isEmpty() && (thumbnailBitmap = getThumbnailBitmap(str3)) != null) {
            ContentValues contentValues9 = new ContentValues();
            contentValues9.put("raw_contact_id", (Integer) 0);
            contentValues9.put("is_super_primary", (Integer) 1);
            contentValues9.put("data15", toByteArray(thumbnailBitmap));
            contentValues9.put("mimetype", "vnd.android.cursor.item/photo");
            arrayList.add(contentValues9);
        }
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra(CLConstants.FIELD_PAY_INFO_NAME, str);
        intent.putExtra("finishActivityOnSaveCompleted", true);
        intent.putParcelableArrayListExtra("data", arrayList);
        updateContactPromise = promise;
        getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_CONTACT_FORM, Bundle.EMPTY);
    }

    public void openExistingContact(ReadableMap readableMap, Promise promise) {
        try {
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setDataAndType(uriWithAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            updateContactPromise = promise;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e2) {
            promise.reject(e2.toString());
        }
    }

    public void requestPermission(Promise promise) {
        requestReadContactsPermission(promise);
    }

    public byte[] toByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void updateContact(ReadableMap readableMap, Promise promise) throws RemoteException, OperationApplicationException {
        String str;
        int size;
        String[] strArr;
        Integer[] numArr;
        String[] strArr2;
        int i2;
        int size2;
        String[] strArr3;
        String[] strArr4;
        int i3;
        String[] strArr5;
        String[] strArr6;
        int size3;
        Integer[] numArr2;
        String[] strArr7;
        int i4;
        int size4;
        String[] strArr8;
        String[] strArr9;
        String[] strArr10;
        String[] strArr11;
        String[] strArr12;
        Integer[] numArr3;
        String[] strArr13;
        ReadableArray readableArray;
        int size5;
        String[] strArr14;
        String[] strArr15;
        int i5;
        String[] strArr16;
        String str2;
        Uri uri;
        Promise promise2;
        Bitmap thumbnailBitmap;
        int i6;
        String str3;
        ContentProviderOperation.Builder builderWithValue;
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        String string2 = readableMap.hasKey("rawContactId") ? readableMap.getString("rawContactId") : null;
        if (string2 == null || string == null) {
            promise.reject("Invalid recordId or rawContactId");
            return;
        }
        String string3 = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string4 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string5 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string6 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string7 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string8 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string9 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string10 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string11 = readableMap.hasKey(CLConstants.LABEL_NOTE) ? readableMap.getString(CLConstants.LABEL_NOTE) : null;
        String string12 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        String str4 = "label";
        String str5 = string12;
        String str6 = string11;
        if (array != null) {
            size = array.size();
            str = string2;
            strArr = new String[size];
            numArr = new Integer[size];
            strArr2 = new String[size];
            String[] strArr17 = new String[size];
            int i7 = 0;
            while (true) {
                int i8 = size;
                if (i7 >= size) {
                    break;
                }
                ReadableMap map = array.getMap(i7);
                int i9 = i7;
                String string13 = map.getString("number");
                String string14 = map.getString("label");
                String string15 = map.hasKey(CLConstants.SHARED_PREFERENCE_ITEM_ID) ? map.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID) : null;
                strArr[i9] = string13;
                numArr[i9] = Integer.valueOf(mapStringToPhoneType(string14));
                strArr2[i9] = string14;
                strArr17[i9] = string15;
                i7 = i9 + 1;
                size = i8;
            }
        } else {
            str = string2;
            size = 0;
            strArr = null;
            numArr = null;
            strArr2 = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        ReadableArray readableArray2 = array;
        if (array2 != null) {
            size2 = array2.size();
            i2 = size;
            String[] strArr18 = new String[size2];
            strArr4 = new String[size2];
            int i10 = 0;
            while (true) {
                int i11 = size2;
                if (i10 >= size2) {
                    break;
                }
                ReadableMap map2 = array2.getMap(i10);
                ReadableArray readableArray3 = array2;
                strArr18[i10] = map2.getString("url");
                strArr4[i10] = map2.hasKey(CLConstants.SHARED_PREFERENCE_ITEM_ID) ? map2.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID) : null;
                i10++;
                size2 = i11;
                array2 = readableArray3;
            }
            strArr3 = strArr18;
        } else {
            i2 = size;
            size2 = 0;
            strArr3 = null;
            strArr4 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            strArr5 = strArr3;
            size3 = array3.size();
            i3 = size2;
            String[] strArr19 = new String[size3];
            String[] strArr20 = new String[size3];
            numArr2 = new Integer[size3];
            strArr7 = new String[size3];
            int i12 = 0;
            while (true) {
                int i13 = size3;
                if (i12 >= size3) {
                    break;
                }
                ReadableMap map3 = array3.getMap(i12);
                ReadableArray readableArray4 = array3;
                strArr19[i12] = map3.getString(Scopes.EMAIL);
                String string16 = map3.getString("label");
                numArr2[i12] = Integer.valueOf(mapStringToEmailType(string16));
                strArr7[i12] = string16;
                strArr20[i12] = map3.hasKey(CLConstants.SHARED_PREFERENCE_ITEM_ID) ? map3.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID) : null;
                i12++;
                size3 = i13;
                array3 = readableArray4;
            }
            strArr6 = strArr19;
        } else {
            i3 = size2;
            strArr5 = strArr3;
            strArr6 = null;
            size3 = 0;
            numArr2 = null;
            strArr7 = null;
        }
        ReadableArray readableArray5 = array3;
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        String[] strArr21 = strArr6;
        if (array4 != null) {
            size4 = array4.size();
            i4 = size3;
            String[] strArr22 = new String[size4];
            strArr9 = new String[size4];
            strArr10 = new String[size4];
            String[] strArr23 = new String[size4];
            strArr11 = new String[size4];
            strArr12 = new String[size4];
            numArr3 = new Integer[size4];
            strArr13 = new String[size4];
            int i14 = 0;
            while (true) {
                int i15 = size4;
                if (i14 >= size4) {
                    break;
                }
                String valueFromKey = getValueFromKey(array4.getMap(i14), str4);
                strArr22[i14] = getValueFromKey(array4.getMap(i14), "street");
                strArr9[i14] = getValueFromKey(array4.getMap(i14), "city");
                strArr10[i14] = getValueFromKey(array4.getMap(i14), "state");
                strArr23[i14] = getValueFromKey(array4.getMap(i14), "region");
                strArr11[i14] = getValueFromKey(array4.getMap(i14), "postCode");
                strArr12[i14] = getValueFromKey(array4.getMap(i14), AdRevenueScheme.COUNTRY);
                numArr3[i14] = Integer.valueOf(mapStringToPostalAddressType(valueFromKey));
                strArr13[i14] = valueFromKey;
                i14++;
                size4 = i15;
                str4 = str4;
                string10 = string10;
            }
            strArr8 = strArr22;
        } else {
            i4 = size3;
            size4 = 0;
            strArr8 = null;
            strArr9 = null;
            strArr10 = null;
            strArr11 = null;
            strArr12 = null;
            numArr3 = null;
            strArr13 = null;
        }
        String str7 = string10;
        ReadableArray array5 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array5 != null) {
            size5 = array5.size();
            strArr14 = new String[size5];
            readableArray = array4;
            String[] strArr24 = new String[size5];
            String[] strArr25 = new String[size5];
            int i16 = 0;
            while (true) {
                int i17 = size5;
                if (i16 >= size5) {
                    break;
                }
                ReadableMap map4 = array5.getMap(i16);
                ReadableArray readableArray6 = array5;
                strArr14[i16] = map4.getString("username");
                strArr24[i16] = map4.getString(PaymentConstants.SERVICE);
                strArr25[i16] = map4.hasKey(CLConstants.SHARED_PREFERENCE_ITEM_ID) ? map4.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID) : null;
                i16++;
                size5 = i17;
                array5 = readableArray6;
            }
            strArr15 = strArr24;
        } else {
            readableArray = array4;
            size5 = 0;
            strArr14 = null;
            strArr15 = null;
        }
        ReadableArray readableArray7 = array5;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Uri uri2 = ContactsContract.Data.CONTENT_URI;
        String[] strArr26 = strArr14;
        arrayList.add(ContentProviderOperation.newUpdate(uri2).withSelection("contact_id=?", new String[]{string}).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string3).withValue("data5", string4).withValue("data3", string5).withValue("data4", string6).withValue("data6", string7).build());
        ContentProviderOperation.Builder builderWithValue2 = ContentProviderOperation.newUpdate(uri2).withSelection("contact_id=? AND mimetype = ?", new String[]{string, "vnd.android.cursor.item/organization"}).withValue("data1", string8).withValue("data4", string9).withValue("data5", str7);
        arrayList.add(builderWithValue2.build());
        builderWithValue2.withYieldAllowed(true);
        if (readableArray2 != null) {
            i5 = 1;
            strArr16 = strArr8;
            str2 = str;
            arrayList.add(ContentProviderOperation.newDelete(uri2).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/phone_v2", str2}).build());
            int i18 = 0;
            while (true) {
                int i19 = i2;
                if (i18 >= i19) {
                    break;
                }
                i2 = i19;
                int i20 = i18;
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str2).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr[i20]).withValue("data2", numArr[i20]).withValue("data3", strArr2[i20]).build());
                i18 = i20 + 1;
            }
        } else {
            i5 = 1;
            strArr16 = strArr8;
            str2 = str;
        }
        int i21 = 0;
        while (true) {
            int i22 = i3;
            if (i21 >= i22) {
                break;
            }
            if (strArr4[i21] == null) {
                i3 = i22;
                i6 = i21;
                builderWithValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str2).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", strArr5[i6]);
                str3 = string;
            } else {
                i3 = i22;
                i6 = i21;
                str3 = string;
                builderWithValue = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=?", new String[]{String.valueOf(strArr4[i6])}).withValue("data1", strArr5[i6]);
            }
            arrayList.add(builderWithValue.build());
            i21 = i6 + 1;
            string = str3;
        }
        String str8 = string;
        if (readableArray5 != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/email_v2", str2}).build());
            int i23 = 0;
            while (true) {
                int i24 = i4;
                if (i23 >= i24) {
                    break;
                }
                i4 = i24;
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str2).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr21[i23]).withValue("data2", numArr2[i23]).withValue("data3", strArr7[i23]).build());
                i23++;
            }
        }
        Uri uri3 = ContactsContract.Data.CONTENT_URI;
        arrayList.add(ContentProviderOperation.newDelete(uri3).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/note", str2}).build());
        if (str6 != null) {
            arrayList.add(ContentProviderOperation.newInsert(uri3).withValue("raw_contact_id", str2).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", str6).build());
        }
        if (str5 == null || str5.isEmpty() || (thumbnailBitmap = getThumbnailBitmap(str5)) == null) {
            uri = uri3;
        } else {
            uri = uri3;
            arrayList.add(ContentProviderOperation.newInsert(uri3).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", toByteArray(thumbnailBitmap)).build());
        }
        if (readableArray != null) {
            arrayList.add(ContentProviderOperation.newDelete(uri).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/postal-address_v2", str2}).build());
            for (int i25 = 0; i25 < size4; i25++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str2).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", numArr3[i25]).withValue("data3", strArr13[i25]).withValue("data4", strArr16[i25]).withValue("data7", strArr9[i25]).withValue("data8", strArr10[i25]).withValue("data9", strArr11[i25]).withValue("data10", strArr12[i25]).build());
            }
        }
        if (readableArray7 != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/im", str2}).build());
            for (int i26 = 0; i26 < size5; i26++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", str2).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", strArr26[i26]).withValue("data2", Integer.valueOf(i5)).withValue("data5", -1).withValue("data6", strArr15[i26]).build());
            }
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] contentProviderResultArrApplyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (contentProviderResultArrApplyBatch == null || contentProviderResultArrApplyBatch.length <= 0) {
                return;
            }
            promise2 = promise;
            try {
                promise2.resolve(new ContactsProvider(contentResolver).getContactById(str8));
            } catch (Exception e2) {
                e = e2;
                promise2.reject(e.toString());
            }
        } catch (Exception e3) {
            e = e3;
            promise2 = promise;
        }
    }

    public void viewExistingContact(ReadableMap readableMap, Promise promise) {
        try {
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriWithAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            updateContactPromise = promise;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e2) {
            promise.reject(e2.toString());
        }
    }

    public void writePhotoToPath(String str, String str2, Promise promise) {
        getExecutor().execute(new h(this, str, str2, promise, 8));
    }
}
