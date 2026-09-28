package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbwy;

@KeepForSdk
/* loaded from: classes4.dex */
public final class AdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public zzbwy f20980a;

    @Override // android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.Q2(i2, i3, intent);
            }
        } catch (Exception e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                if (!zzbwyVar.zzg()) {
                    return;
                }
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
        super.onBackPressed();
        try {
            zzbwy zzbwyVar2 = this.f20980a;
            if (zzbwyVar2 != null) {
                zzbwyVar2.zze();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.J(new ObjectWrapper(configuration));
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzo.a("AdActivity onCreate");
        zzbwy zzbwyVarG = zzbb.f21141g.f21143b.g(this);
        this.f20980a = zzbwyVarG;
        if (zzbwyVarG == null) {
            zzo.i("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzbwyVarG.t6(bundle);
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        zzo.a("AdActivity onDestroy");
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.B();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        zzo.a("AdActivity onPause");
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.zzl();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.R7(i2, strArr, iArr);
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        zzo.a("AdActivity onRestart");
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.zzi();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        zzo.a("AdActivity onResume");
        super.onResume();
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.zzk();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.n0(bundle);
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        zzo.a("AdActivity onStart");
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.zzj();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        zzo.a("AdActivity onStop");
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.e1();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbwy zzbwyVar = this.f20980a;
            if (zzbwyVar != null) {
                zzbwyVar.zzf();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i2) {
        super.setContentView(i2);
        zzbwy zzbwyVar = this.f20980a;
        if (zzbwyVar != null) {
            try {
                zzbwyVar.zzs();
            } catch (RemoteException e2) {
                zzo.i("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view) {
        super.setContentView(view);
        zzbwy zzbwyVar = this.f20980a;
        if (zzbwyVar != null) {
            try {
                zzbwyVar.zzs();
            } catch (RemoteException e2) {
                zzo.i("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzbwy zzbwyVar = this.f20980a;
        if (zzbwyVar != null) {
            try {
                zzbwyVar.zzs();
            } catch (RemoteException e2) {
                zzo.i("#007 Could not call remote method.", e2);
            }
        }
    }
}
