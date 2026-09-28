package com.rt2zz.reactnativecontacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.media.b;
import android.text.TextUtils;
import com.appsflyer.AdRevenueScheme;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class ContactsProvider {
    public static final int ID_FOR_PROFILE_CONTACT = -1;
    public static final String NAME = "RCTContacts";
    private final ContentResolver contentResolver;
    private static final List<String> JUST_ME_PROJECTION = new ArrayList<String>() { // from class: com.rt2zz.reactnativecontacts.ContactsProvider.1
        {
            add("_id");
            add("contact_id");
            add("raw_contact_id");
            add("lookup");
            add("starred");
            add("mimetype");
            add("display_name");
            add("photo_uri");
            add("data1");
            add("data2");
            add("data5");
            add("data3");
            add("data4");
            add("data6");
            add("data1");
            add("data4");
            add("data2");
            add("data3");
            add("data1");
            add("data1");
            add("data2");
            add("data3");
            add("data1");
            add("data4");
            add("data5");
            add("data1");
            add("data2");
            add("data3");
            add("data4");
            add("data5");
            add("data6");
            add("data7");
            add("data8");
            add("data9");
            add("data10");
            add("data1");
            add("data1");
            add("data1");
            add("data1");
            add("data2");
        }
    };
    private static final List<String> FULL_PROJECTION = new ArrayList<String>() { // from class: com.rt2zz.reactnativecontacts.ContactsProvider.2
        {
            addAll(ContactsProvider.JUST_ME_PROJECTION);
        }
    };
    private static final List<String> PHOTO_PROJECTION = new ArrayList<String>() { // from class: com.rt2zz.reactnativecontacts.ContactsProvider.3
        {
            add("photo_uri");
        }
    };

    public ContactsProvider(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    private Boolean cursorMoveToNext(Cursor cursor) {
        try {
            return Boolean.valueOf(cursor.moveToNext());
        } catch (RuntimeException unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0141  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, com.rt2zz.reactnativecontacts.ContactsProvider.Contact> loadContactsFrom(android.database.Cursor r19) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rt2zz.reactnativecontacts.ContactsProvider.loadContactsFrom(android.database.Cursor):java.util.Map");
    }

    public WritableMap getContactById(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            if (mapLoadContactsFrom.values().size() > 0) {
                return mapLoadContactsFrom.values().iterator().next().toMap();
            }
            return null;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public WritableMap getContactByRawId(String str) {
        int columnIndex;
        Cursor cursorQuery = this.contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id= ?", new String[]{str}, null);
        cursorQuery.getCount();
        String string = (!cursorMoveToNext(cursorQuery).booleanValue() || (columnIndex = cursorQuery.getColumnIndex("contact_id")) == -1) ? null : cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return getContactById(string);
    }

    public WritableArray getContacts() {
        ContentResolver contentResolver = this.contentResolver;
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        List<String> list = JUST_ME_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, (String[]) list.toArray(new String[list.size()]), null, null, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            ContentResolver contentResolver2 = this.contentResolver;
            Uri uri = ContactsContract.Data.CONTENT_URI;
            List<String> list2 = FULL_PROJECTION;
            cursorQuery = contentResolver2.query(uri, (String[]) list2.toArray(new String[list2.size()]), "mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=?", new String[]{"vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/note", "vnd.android.cursor.item/website", "vnd.android.cursor.item/im", "vnd.android.cursor.item/contact_event"}, null);
            try {
                Map<String, Contact> mapLoadContactsFrom2 = loadContactsFrom(cursorQuery);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Contact> it = mapLoadContactsFrom.values().iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushMap(it.next().toMap());
                }
                Iterator<Contact> it2 = mapLoadContactsFrom2.values().iterator();
                while (it2.hasNext()) {
                    writableArrayCreateArray.pushMap(it2.next().toMap());
                }
                return writableArrayCreateArray;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public WritableArray getContactsByEmailAddress(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ?", new String[]{b.D("%", str, "%")}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<Contact> it = mapLoadContactsFrom.values().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(it.next().toMap());
            }
            return writableArrayCreateArray;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public WritableArray getContactsByPhoneNumber(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ? OR data4 LIKE ?", new String[]{b.D("%", str, "%"), b.D("%", str, "%")}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<Contact> it = mapLoadContactsFrom.values().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(it.next().toMap());
            }
            return writableArrayCreateArray;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public Integer getContactsCount() {
        return Integer.valueOf(this.contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null).getCount());
    }

    public WritableArray getContactsMatchingString(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "display_name LIKE ? OR data1 LIKE ?", new String[]{b.D("%", str, "%"), b.D("%", str, "%")}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<Contact> it = mapLoadContactsFrom.values().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(it.next().toMap());
            }
            return writableArrayCreateArray;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public String getPhotoUriFromContactId(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = PHOTO_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorMoveToNext(cursorQuery).booleanValue()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("photo_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
        return cursorQuery != null ? null : null;
    }

    public static class Contact {
        private Birthday birthday;
        private String contactId;
        private String displayName;
        private String photoUri;
        private String rawContactId;
        private String givenName = "";
        private String middleName = "";
        private String familyName = "";
        private String prefix = "";
        private String suffix = "";
        private String company = "";
        private String jobTitle = "";
        private String department = "";
        private String note = "";
        private List<Item> urls = new ArrayList();
        private List<Item> instantMessengers = new ArrayList();
        private boolean hasPhoto = false;
        private boolean isStarred = false;
        private List<Item> emails = new ArrayList();
        private List<Item> phones = new ArrayList();
        private List<PostalAddressItem> postalAddresses = new ArrayList();

        public static class PostalAddressItem {
            public final WritableMap map;

            public PostalAddressItem(Cursor cursor) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                this.map = writableMapCreateMap;
                writableMapCreateMap.putString("label", getLabel(cursor));
                putString(cursor, "formattedAddress", "data1");
                putString(cursor, "street", "data4");
                putString(cursor, "pobox", "data5");
                putString(cursor, "neighborhood", "data6");
                putString(cursor, "city", "data7");
                putString(cursor, "region", "data8");
                putString(cursor, "state", "data8");
                putString(cursor, "postCode", "data9");
                putString(cursor, AdRevenueScheme.COUNTRY, "data10");
            }

            public static String getLabel(Cursor cursor) {
                int i2 = cursor.getInt(cursor.getColumnIndex("data2"));
                if (i2 != 0) {
                    return i2 != 1 ? i2 != 2 ? "other" : "work" : "home";
                }
                String string = cursor.getString(cursor.getColumnIndex("data3"));
                return string != null ? string : "";
            }

            private void putString(Cursor cursor, String str, String str2) {
                String string = cursor.getString(cursor.getColumnIndex(str2));
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                this.map.putString(str, string);
            }
        }

        public Contact(String str) {
            this.contactId = str;
        }

        public WritableMap toMap() {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("recordID", this.contactId);
            writableMapCreateMap.putString("rawContactId", this.rawContactId);
            writableMapCreateMap.putString("givenName", TextUtils.isEmpty(this.givenName) ? this.displayName : this.givenName);
            writableMapCreateMap.putString("displayName", this.displayName);
            writableMapCreateMap.putString("middleName", this.middleName);
            writableMapCreateMap.putString("familyName", this.familyName);
            writableMapCreateMap.putString("prefix", this.prefix);
            writableMapCreateMap.putString("suffix", this.suffix);
            writableMapCreateMap.putString("company", this.company);
            writableMapCreateMap.putString("jobTitle", this.jobTitle);
            writableMapCreateMap.putString("department", this.department);
            writableMapCreateMap.putString(CLConstants.LABEL_NOTE, this.note);
            writableMapCreateMap.putBoolean("hasThumbnail", this.hasPhoto);
            String str = this.photoUri;
            if (str == null) {
                str = "";
            }
            writableMapCreateMap.putString("thumbnailPath", str);
            writableMapCreateMap.putBoolean("isStarred", this.isStarred);
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (Item item : this.phones) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putString("number", item.value);
                writableMapCreateMap2.putString("label", item.label);
                writableMapCreateMap2.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, item.id);
                writableArrayCreateArray.pushMap(writableMapCreateMap2);
            }
            writableMapCreateMap.putArray("phoneNumbers", writableArrayCreateArray);
            WritableArray writableArrayCreateArray2 = Arguments.createArray();
            for (Item item2 : this.urls) {
                WritableMap writableMapCreateMap3 = Arguments.createMap();
                writableMapCreateMap3.putString("url", item2.value);
                writableMapCreateMap3.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, item2.id);
                writableArrayCreateArray2.pushMap(writableMapCreateMap3);
            }
            writableMapCreateMap.putArray("urlAddresses", writableArrayCreateArray2);
            WritableArray writableArrayCreateArray3 = Arguments.createArray();
            for (Item item3 : this.instantMessengers) {
                WritableMap writableMapCreateMap4 = Arguments.createMap();
                writableMapCreateMap4.putString("username", item3.value);
                writableMapCreateMap4.putString(PaymentConstants.SERVICE, item3.label);
                writableArrayCreateArray3.pushMap(writableMapCreateMap4);
            }
            writableMapCreateMap.putArray("imAddresses", writableArrayCreateArray3);
            WritableArray writableArrayCreateArray4 = Arguments.createArray();
            for (Item item4 : this.emails) {
                WritableMap writableMapCreateMap5 = Arguments.createMap();
                writableMapCreateMap5.putString(Scopes.EMAIL, item4.value);
                writableMapCreateMap5.putString("label", item4.label);
                writableMapCreateMap5.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, item4.id);
                writableArrayCreateArray4.pushMap(writableMapCreateMap5);
            }
            writableMapCreateMap.putArray("emailAddresses", writableArrayCreateArray4);
            WritableArray writableArrayCreateArray5 = Arguments.createArray();
            Iterator<PostalAddressItem> it = this.postalAddresses.iterator();
            while (it.hasNext()) {
                writableArrayCreateArray5.pushMap(it.next().map);
            }
            writableMapCreateMap.putArray("postalAddresses", writableArrayCreateArray5);
            WritableMap writableMapCreateMap6 = Arguments.createMap();
            Birthday birthday = this.birthday;
            if (birthday != null) {
                int i2 = birthday.year;
                if (i2 > 0) {
                    writableMapCreateMap6.putInt("year", i2);
                }
                writableMapCreateMap6.putInt("month", this.birthday.month);
                writableMapCreateMap6.putInt("day", this.birthday.day);
                writableMapCreateMap.putMap("birthday", writableMapCreateMap6);
            }
            return writableMapCreateMap;
        }

        public static class Birthday {
            public int day;
            public int month;
            public int year;

            public Birthday(int i2, int i3, int i4) {
                this.year = i2;
                this.month = i3;
                this.day = i4;
            }

            public Birthday(int i2, int i3) {
                this.year = 0;
                this.month = i2;
                this.day = i3;
            }
        }

        public static class Item {
            public String id;
            public String label;
            public String value;

            public Item(String str, String str2, String str3) {
                this.id = str3;
                this.label = str;
                this.value = str2;
            }

            public Item(String str, String str2) {
                this.label = str;
                this.value = str2;
            }
        }
    }
}
