package com.zeptoconsumerapp.AutoLogin;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import com.zeptoconsumerapp.modules.event.domain.LogEventUseCase;
import io.sentry.Sentry;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class AutoLoginBackupAgent extends BackupAgent {

    @NotNull
    private static final String BACKUP_METHOD = "backup_method";

    @NotNull
    private static final String CREDENTIALS_KEY = "autologin_credentials";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String DATA = "data";

    @NotNull
    private static final String USER_TOKENS = "userTokens";

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Event {

        @SerializedName("eventData")
        @NotNull
        private final Map<String, Object> eventData;

        @SerializedName("eventType")
        @NotNull
        private final String eventType;

        public Event(LinkedHashMap eventData) {
            Intrinsics.checkNotNullParameter("android_auto_backup_flow", "eventType");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            this.eventType = "android_auto_backup_flow";
            this.eventData = eventData;
        }

        public final Map a() {
            return this.eventData;
        }

        public final String b() {
            return this.eventType;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Event)) {
                return false;
            }
            Event event = (Event) obj;
            return Intrinsics.b(this.eventType, event.eventType) && Intrinsics.b(this.eventData, event.eventData);
        }

        public final int hashCode() {
            return this.eventData.hashCode() + (this.eventType.hashCode() * 31);
        }

        public final String toString() {
            return "Event(eventType=" + this.eventType + ", eventData=" + this.eventData + ")";
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoLoginBackupAgent$onBackup$1", f = "AutoLoginBackupAgent.kt", l = {61}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoLoginBackupAgent$onBackup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public JSONObject f47366a;

        /* renamed from: b, reason: collision with root package name */
        public int f47367b;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BackupDataOutput f47369d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptor f47370e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor, Continuation continuation) {
            super(2, continuation);
            this.f47369d = backupDataOutput;
            this.f47370e = parcelFileDescriptor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutoLoginBackupAgent.this.new AnonymousClass1(this.f47369d, this.f47370e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JSONException, IOException {
            JSONObject jSONObject;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47367b;
            AutoLoginBackupAgent autoLoginBackupAgent = AutoLoginBackupAgent.this;
            if (i2 == 0) {
                ResultKt.b(obj);
                JSONObject jSONObject2 = new JSONObject();
                ContextProvider.f47615b.a().b(autoLoginBackupAgent);
                AutoBackupManager autoBackupManager = AutoBackupManager.INSTANCE;
                this.f47366a = jSONObject2;
                this.f47367b = 1;
                Object obj2 = autoBackupManager.get(autoLoginBackupAgent, AutoLoginBackupAgent.USER_TOKENS, this);
                if (obj2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                jSONObject = jSONObject2;
                obj = obj2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject = this.f47366a;
                ResultKt.b(obj);
            }
            String str = (String) obj;
            if (str != null) {
                jSONObject.put(AutoLoginBackupAgent.USER_TOKENS, str);
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            BackupDataOutput backupDataOutput = this.f47369d;
            if (backupDataOutput != null) {
                new Integer(backupDataOutput.writeEntityHeader(AutoLoginBackupAgent.CREDENTIALS_KEY, bytes.length));
            }
            if (backupDataOutput != null) {
                new Integer(backupDataOutput.writeEntityData(bytes, bytes.length));
            }
            ParcelFileDescriptor parcelFileDescriptor = this.f47370e;
            if (parcelFileDescriptor != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                try {
                    fileOutputStream.write(bytes);
                    Unit unit = Unit.f53572a;
                    fileOutputStream.close();
                } finally {
                }
            }
            Pair pair = new Pair(AutoLoginBackupAgent.BACKUP_METHOD, "onBackup");
            if (str == null) {
                str = "";
            }
            Map mapH = MapsKt.h(pair, new Pair("data", autoLoginBackupAgent.sanitizeTokens(str)));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapH.entrySet()) {
                if (((String) entry.getValue()) != null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Event event = new Event(linkedHashMap);
            Object obj3 = LogEventUseCase.f47644a;
            LogEventUseCase.Companion.b(event.b(), event.a());
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoLoginBackupAgent$onRestore$1", f = "AutoLoginBackupAgent.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoLoginBackupAgent$onRestore$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f47371a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00961(JSONObject jSONObject, Continuation continuation) {
            super(2, continuation);
            this.f47371a = jSONObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C00961(this.f47371a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00961) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JSONException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            JSONObject jSONObject = this.f47371a;
            if (jSONObject.has(AutoLoginBackupAgent.USER_TOKENS)) {
                jSONObject.getString(AutoLoginBackupAgent.USER_TOKENS);
            }
            return Unit.f53572a;
        }
    }

    @Override // android.app.backup.BackupAgent
    @Keep
    public void onBackup(@Nullable ParcelFileDescriptor parcelFileDescriptor, @Nullable BackupDataOutput backupDataOutput, @Nullable ParcelFileDescriptor parcelFileDescriptor2) {
        try {
            BuildersKt.d(new AnonymousClass1(backupDataOutput, parcelFileDescriptor2, null));
        } catch (Throwable th) {
            Sentry.a(th);
        }
    }

    @Override // android.app.backup.BackupAgent
    @Keep
    public void onRestore(@Nullable BackupDataInput backupDataInput, int i2, @Nullable ParcelFileDescriptor parcelFileDescriptor) throws Throwable {
        while (backupDataInput != null) {
            try {
                if (!backupDataInput.readNextHeader()) {
                    return;
                }
                if (Intrinsics.b(backupDataInput.getKey(), CREDENTIALS_KEY)) {
                    int dataSize = backupDataInput.getDataSize();
                    byte[] bArr = new byte[dataSize];
                    backupDataInput.readEntityData(bArr, 0, dataSize);
                    BuildersKt.d(new C00961(new JSONObject(new String(bArr, Charsets.UTF_8)), null));
                }
            } catch (Exception e2) {
                Sentry.a(e2);
                return;
            }
        }
    }

    @NotNull
    public final String sanitizeTokens(@NotNull String jsonString) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            JSONArray jSONArray = new JSONArray(jsonString);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                jSONObject.remove("accessToken");
                jSONObject.remove("refreshToken");
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return jsonString;
        }
    }
}
