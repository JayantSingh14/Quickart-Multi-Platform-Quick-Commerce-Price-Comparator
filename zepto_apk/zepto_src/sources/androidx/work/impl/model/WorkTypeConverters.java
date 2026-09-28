package androidx.work.impl.model;

import android.net.Uri;
import android.os.Build;
import android.support.v4.media.b;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class WorkTypeConverters {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class BackoffPolicyIds {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class NetworkTypeIds {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class OutOfPolicyIds {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class StateIds {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[WorkInfo.State.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[BackoffPolicy.values().length];
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[NetworkType.values().length];
            try {
                iArr3[0] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[1] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[3] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[4] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr4 = new int[OutOfQuotaPolicy.values().length];
            try {
                iArr4[0] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[1] = 2;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static final LinkedHashSet a(byte[] bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bytes.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        int i2 = objectInputStream.readInt();
                        for (int i3 = 0; i3 < i2; i3++) {
                            Uri uri = Uri.parse(objectInputStream.readUTF());
                            boolean z = objectInputStream.readBoolean();
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            linkedHashSet.add(new Constraints.ContentUriTrigger(z, uri));
                        }
                        Unit unit = Unit.f53572a;
                        objectInputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Unit unit2 = Unit.f53572a;
            byteArrayInputStream.close();
        }
        return linkedHashSet;
    }

    public static final BackoffPolicy b(int i2) {
        if (i2 == 0) {
            return BackoffPolicy.f12471a;
        }
        if (i2 == 1) {
            return BackoffPolicy.f12472b;
        }
        throw new IllegalArgumentException(b.g(i2, "Could not convert ", " to BackoffPolicy"));
    }

    public static final NetworkType c(int i2) {
        if (i2 == 0) {
            return NetworkType.f12536a;
        }
        if (i2 == 1) {
            return NetworkType.f12537b;
        }
        if (i2 == 2) {
            return NetworkType.f12538c;
        }
        if (i2 == 3) {
            return NetworkType.f12539d;
        }
        if (i2 == 4) {
            return NetworkType.f12540e;
        }
        if (Build.VERSION.SDK_INT < 30 || i2 != 5) {
            throw new IllegalArgumentException(b.g(i2, "Could not convert ", " to NetworkType"));
        }
        return NetworkType.f12541f;
    }

    public static final OutOfQuotaPolicy d(int i2) {
        if (i2 == 0) {
            return OutOfQuotaPolicy.f12549a;
        }
        if (i2 == 1) {
            return OutOfQuotaPolicy.f12550b;
        }
        throw new IllegalArgumentException(b.g(i2, "Could not convert ", " to OutOfQuotaPolicy"));
    }

    public static final WorkInfo.State e(int i2) {
        if (i2 == 0) {
            return WorkInfo.State.f12566a;
        }
        if (i2 == 1) {
            return WorkInfo.State.f12567b;
        }
        if (i2 == 2) {
            return WorkInfo.State.f12568c;
        }
        if (i2 == 3) {
            return WorkInfo.State.f12569d;
        }
        if (i2 == 4) {
            return WorkInfo.State.f12570e;
        }
        if (i2 == 5) {
            return WorkInfo.State.f12571f;
        }
        throw new IllegalArgumentException(b.g(i2, "Could not convert ", " to State"));
    }

    public static final int f(NetworkType networkType) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        int iOrdinal = networkType.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (iOrdinal != 1) {
            i2 = 2;
            if (iOrdinal != 2) {
                i2 = 3;
                if (iOrdinal != 3) {
                    i2 = 4;
                    if (iOrdinal != 4) {
                        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.f12541f) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
                    }
                }
            }
        }
        return i2;
    }

    public static final byte[] g(Set triggers) throws IOException {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        if (triggers.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(triggers.size());
                Iterator it = triggers.iterator();
                while (it.hasNext()) {
                    Constraints.ContentUriTrigger contentUriTrigger = (Constraints.ContentUriTrigger) it.next();
                    objectOutputStream.writeUTF(contentUriTrigger.a().toString());
                    objectOutputStream.writeBoolean(contentUriTrigger.b());
                }
                Unit unit = Unit.f53572a;
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static final int h(WorkInfo.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int iOrdinal = state.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (iOrdinal != 1) {
            i2 = 2;
            if (iOrdinal != 2) {
                i2 = 3;
                if (iOrdinal != 3) {
                    i2 = 4;
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            return 5;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
        return i2;
    }
}
