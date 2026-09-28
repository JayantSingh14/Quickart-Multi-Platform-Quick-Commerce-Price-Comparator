package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes4.dex */
public class BroadcastReceiverConnectivityReceiver extends ConnectivityReceiver {

    public class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                throw null;
            }
        }
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    public final void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f46183d.registerReceiver(null, intentFilter);
        throw null;
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    public final void d() {
        throw null;
    }
}
