package com.amazon.android.apay.commonlibrary.commonlib.arcus;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.amazon.android.apay.commonlibrary.commonlib.utils.c;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class AppConfigWorker extends Worker {

    /* renamed from: f, reason: collision with root package name */
    public final Context f14862f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppConfigWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f14862f = context;
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        Context context = this.f14862f;
        try {
            c.f14881a.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("lpaconfig", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…EY, Context.MODE_PRIVATE)");
            String string = sharedPreferences.getString(PaymentConstants.MERCHANT_ID, Rule.ALL);
            Intrinsics.c(string);
            c.a(context, string).sync(new a(context));
            ListenableWorker.Result.Success success = new ListenableWorker.Result.Success();
            Intrinsics.checkNotNullExpressionValue(success, "{\n            val mercha…esult.success()\n        }");
            return success;
        } catch (Exception e2) {
            e2.getMessage();
            ListenableWorker.Result.Failure failure = new ListenableWorker.Result.Failure();
            Intrinsics.checkNotNullExpressionValue(failure, "{\n            Log.w(\n   …esult.failure()\n        }");
            return failure;
        }
    }
}
