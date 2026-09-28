package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f5011f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static LocalBroadcastManager f5012g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5013a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f5014b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f5015c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f5016d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f5017e;

    /* loaded from: classes3.dex */
    public static final class BroadcastRecord {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f5019a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f5020b;

        public BroadcastRecord(Intent intent, ArrayList arrayList) {
            this.f5019a = intent;
            this.f5020b = arrayList;
        }
    }

    public static final class ReceiverRecord {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f5021a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f5022b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f5023c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f5024d;

        public ReceiverRecord(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            this.f5021a = intentFilter;
            this.f5022b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f5022b);
            sb.append(" filter=");
            sb.append(this.f5021a);
            if (this.f5024d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public LocalBroadcastManager(Context context) {
        this.f5013a = context;
        this.f5017e = new Handler(context.getMainLooper()) { // from class: androidx.localbroadcastmanager.content.LocalBroadcastManager.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int size;
                BroadcastRecord[] broadcastRecordArr;
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.this;
                while (true) {
                    synchronized (localBroadcastManager.f5014b) {
                        try {
                            size = localBroadcastManager.f5016d.size();
                            if (size <= 0) {
                                return;
                            }
                            broadcastRecordArr = new BroadcastRecord[size];
                            localBroadcastManager.f5016d.toArray(broadcastRecordArr);
                            localBroadcastManager.f5016d.clear();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        BroadcastRecord broadcastRecord = broadcastRecordArr[i2];
                        int size2 = broadcastRecord.f5020b.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            ReceiverRecord receiverRecord = (ReceiverRecord) broadcastRecord.f5020b.get(i3);
                            if (!receiverRecord.f5024d) {
                                receiverRecord.f5022b.onReceive(localBroadcastManager.f5013a, broadcastRecord.f5019a);
                            }
                        }
                    }
                }
            }
        };
    }

    public static LocalBroadcastManager a(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f5011f) {
            try {
                if (f5012g == null) {
                    f5012g = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = f5012g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    public final void b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f5014b) {
            try {
                ReceiverRecord receiverRecord = new ReceiverRecord(broadcastReceiver, intentFilter);
                ArrayList arrayList = (ArrayList) this.f5014b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f5014b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(receiverRecord);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.f5015c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f5015c.put(action, arrayList2);
                    }
                    arrayList2.add(receiverRecord);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Intent intent) {
        ArrayList arrayList;
        synchronized (this.f5014b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f5013a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList2 = (ArrayList) this.f5015c.get(intent.getAction());
                if (arrayList2 != null) {
                    if (z) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                    }
                    ArrayList arrayList3 = null;
                    int i2 = 0;
                    while (i2 < arrayList2.size()) {
                        ReceiverRecord receiverRecord = (ReceiverRecord) arrayList2.get(i2);
                        if (z) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.f5021a);
                        }
                        if (receiverRecord.f5023c) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            arrayList = arrayList2;
                        } else {
                            int iMatch = receiverRecord.f5021a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z) {
                                    StringBuilder sb = new StringBuilder();
                                    arrayList = arrayList2;
                                    sb.append("  Filter matched!  match=0x");
                                    sb.append(Integer.toHexString(iMatch));
                                    Log.v("LocalBroadcastManager", sb.toString());
                                } else {
                                    arrayList = arrayList2;
                                }
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(receiverRecord);
                                receiverRecord.f5023c = true;
                            } else {
                                arrayList = arrayList2;
                                if (z) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                                }
                            }
                        }
                        i2++;
                        arrayList2 = arrayList;
                    }
                    if (arrayList3 != null) {
                        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                            ((ReceiverRecord) arrayList3.get(i3)).f5023c = false;
                        }
                        this.f5016d.add(new BroadcastRecord(intent, arrayList3));
                        if (!this.f5017e.hasMessages(1)) {
                            this.f5017e.sendEmptyMessage(1);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f5014b) {
            try {
                ArrayList arrayList = (ArrayList) this.f5014b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(size);
                    receiverRecord.f5024d = true;
                    for (int i2 = 0; i2 < receiverRecord.f5021a.countActions(); i2++) {
                        String action = receiverRecord.f5021a.getAction(i2);
                        ArrayList arrayList2 = (ArrayList) this.f5015c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList2.get(size2);
                                if (receiverRecord2.f5022b == broadcastReceiver) {
                                    receiverRecord2.f5024d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f5015c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
