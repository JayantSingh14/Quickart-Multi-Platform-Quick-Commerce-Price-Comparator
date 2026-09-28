package com.google.firebase.installations.local;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PersistedInstallation {

    /* renamed from: a, reason: collision with root package name */
    public File f44614a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseApp f44615b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RegistrationStatus {

        /* renamed from: a, reason: collision with root package name */
        public static final RegistrationStatus f44616a;

        /* renamed from: b, reason: collision with root package name */
        public static final RegistrationStatus f44617b;

        /* renamed from: c, reason: collision with root package name */
        public static final RegistrationStatus f44618c;

        /* renamed from: d, reason: collision with root package name */
        public static final RegistrationStatus f44619d;

        /* renamed from: e, reason: collision with root package name */
        public static final RegistrationStatus f44620e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ RegistrationStatus[] f44621f;

        static {
            RegistrationStatus registrationStatus = new RegistrationStatus("ATTEMPT_MIGRATION", 0);
            f44616a = registrationStatus;
            RegistrationStatus registrationStatus2 = new RegistrationStatus("NOT_GENERATED", 1);
            f44617b = registrationStatus2;
            RegistrationStatus registrationStatus3 = new RegistrationStatus("UNREGISTERED", 2);
            f44618c = registrationStatus3;
            RegistrationStatus registrationStatus4 = new RegistrationStatus("REGISTERED", 3);
            f44619d = registrationStatus4;
            RegistrationStatus registrationStatus5 = new RegistrationStatus("REGISTER_ERROR", 4);
            f44620e = registrationStatus5;
            f44621f = new RegistrationStatus[]{registrationStatus, registrationStatus2, registrationStatus3, registrationStatus4, registrationStatus5};
        }

        public static RegistrationStatus valueOf(String str) {
            return (RegistrationStatus) Enum.valueOf(RegistrationStatus.class, str);
        }

        public static RegistrationStatus[] values() {
            return (RegistrationStatus[]) f44621f.clone();
        }
    }

    public PersistedInstallation(FirebaseApp firebaseApp) {
        this.f44615b = firebaseApp;
    }

    public final File a() {
        if (this.f44614a == null) {
            synchronized (this) {
                try {
                    if (this.f44614a == null) {
                        FirebaseApp firebaseApp = this.f44615b;
                        firebaseApp.a();
                        this.f44614a = new File(firebaseApp.f43489a.getFilesDir(), "PersistedInstallation." + this.f44615b.f() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.f44614a;
    }

    public final void b(PersistedInstallationEntry persistedInstallationEntry) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", persistedInstallationEntry.c());
            jSONObject.put("Status", persistedInstallationEntry.f().ordinal());
            jSONObject.put("AuthToken", persistedInstallationEntry.a());
            jSONObject.put("RefreshToken", persistedInstallationEntry.e());
            jSONObject.put("TokenCreationEpochInSecs", persistedInstallationEntry.g());
            jSONObject.put("ExpiresInSecs", persistedInstallationEntry.b());
            jSONObject.put("FisError", persistedInstallationEntry.d());
            FirebaseApp firebaseApp = this.f44615b;
            firebaseApp.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", firebaseApp.f43489a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(a())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public final PersistedInstallationEntry c() throws IOException {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int i2 = fileInputStream.read(bArr, 0, 16384);
                    if (i2 < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i3 = PersistedInstallationEntry.f44622a;
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder();
        builder.f44609f = 0L;
        builder.f44605b = RegistrationStatus.f44616a;
        builder.f44608e = 0L;
        builder.f44604a = strOptString;
        builder.f(RegistrationStatus.values()[iOptInt]);
        builder.f44606c = strOptString2;
        builder.f44607d = strOptString3;
        builder.g(jOptLong);
        builder.c(jOptLong2);
        builder.f44610g = strOptString4;
        return builder.a();
    }
}
