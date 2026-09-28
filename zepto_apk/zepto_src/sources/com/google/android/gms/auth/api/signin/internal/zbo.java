package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import org.json.JSONException;

/* loaded from: classes4.dex */
public abstract class zbo extends com.google.android.gms.internal.p000authapi.zbb implements zbp {
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        PendingResult pendingResultExecute;
        String strD;
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            zbt zbtVar = (zbt) this;
            zbtVar.z0();
            zbn.a(zbtVar.f22219a).b();
            return true;
        }
        zbt zbtVar2 = (zbt) this;
        zbtVar2.z0();
        RevocationBoundService revocationBoundService = zbtVar2.f22219a;
        Storage storageA = Storage.a(revocationBoundService);
        GoogleSignInAccount googleSignInAccountB = storageA.b();
        GoogleSignInOptions googleSignInOptionsB = GoogleSignInOptions.f22165k;
        if (googleSignInAccountB != null) {
            String strD2 = storageA.d("defaultGoogleSignInAccount");
            if (TextUtils.isEmpty(strD2) || (strD = storageA.d(Storage.g("googleSignInOptions", strD2))) == null) {
                googleSignInOptionsB = null;
            } else {
                try {
                    googleSignInOptionsB = GoogleSignInOptions.b(strD);
                } catch (JSONException unused) {
                }
            }
        }
        GoogleSignInClient googleSignInClient = new GoogleSignInClient(revocationBoundService, Auth.f22022a, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptionsB), new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
        if (googleSignInAccountB != null) {
            GoogleApiClient googleApiClientAsGoogleApiClient = googleSignInClient.asGoogleApiClient();
            Context applicationContext = googleSignInClient.getApplicationContext();
            boolean z = googleSignInClient.b() == 3;
            zbm.f22216a.d("Revoking access", new Object[0]);
            String strD3 = Storage.a(applicationContext).d("refreshToken");
            zbm.a(applicationContext);
            if (!z) {
                pendingResultExecute = googleApiClientAsGoogleApiClient.execute(new zbk(googleApiClientAsGoogleApiClient));
            } else if (strD3 == null) {
                Logger logger = zbb.f22207c;
                pendingResultExecute = PendingResults.immediateFailedResult(new Status(4), null);
            } else {
                zbb zbbVar = new zbb(strD3);
                new Thread(zbbVar).start();
                pendingResultExecute = zbbVar.f22209b;
            }
            PendingResultUtil.toVoidTask(pendingResultExecute);
        } else {
            GoogleApiClient googleApiClientAsGoogleApiClient2 = googleSignInClient.asGoogleApiClient();
            Context applicationContext2 = googleSignInClient.getApplicationContext();
            boolean z2 = googleSignInClient.b() == 3;
            zbm.f22216a.d("Signing out", new Object[0]);
            zbm.a(applicationContext2);
            PendingResultUtil.toVoidTask(z2 ? PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClientAsGoogleApiClient2) : googleApiClientAsGoogleApiClient2.execute(new zbi(googleApiClientAsGoogleApiClient2)));
        }
        return true;
    }
}
