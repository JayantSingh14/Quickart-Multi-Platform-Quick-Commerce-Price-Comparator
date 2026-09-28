package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.zbs;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zbap extends GoogleApi implements SignInClient {

    /* renamed from: b, reason: collision with root package name */
    public static final Api f36265b = new Api("Auth.Api.Identity.SignIn.API", new zbak(), new Api.ClientKey());

    /* renamed from: a, reason: collision with root package name */
    public final String f36266a;

    public zbap(Activity activity, zbs zbsVar) {
        super(activity, (Api<zbs>) f36265b, zbsVar, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f36266a = zbas.a();
    }

    public final String b(Intent intent) {
        if (intent == null) {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
        Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, CLConstants.OTP_STATUS, Status.CREATOR);
        if (status == null) {
            throw new ApiException(Status.RESULT_CANCELED);
        }
        if (!status.isSuccess()) {
            throw new ApiException(status);
        }
        String stringExtra = intent.getStringExtra("phone_number_hint_result");
        if (stringExtra != null) {
            return stringExtra;
        }
        throw new ApiException(Status.RESULT_INTERNAL_ERROR);
    }

    public final Task c(final GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        Preconditions.checkNotNull(getPhoneNumberHintIntentRequest);
        return doRead(TaskApiCall.builder().setFeatures(zbar.f36268a).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbag
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zbap zbapVar = this.f36260a;
                zbapVar.getClass();
                zbao zbaoVar = new zbao((TaskCompletionSource) obj2);
                zbv zbvVar = (zbv) ((zbaq) obj).getService();
                Parcel parcelG = zbvVar.g();
                int i2 = zbc.f36271a;
                parcelG.writeStrongBinder(zbaoVar);
                zbc.c(parcelG, getPhoneNumberHintIntentRequest);
                parcelG.writeString(zbapVar.f36266a);
                zbvVar.z0(4, parcelG);
            }
        }).setMethodKey(1653).build());
    }

    public zbap(Context context, zbs zbsVar) {
        super(context, (Api<zbs>) f36265b, zbsVar, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f36266a = zbas.a();
    }
}
