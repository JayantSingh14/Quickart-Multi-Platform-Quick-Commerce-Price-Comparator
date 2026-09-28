package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public abstract class StructureKind extends SerialKind {

    @Metadata
    public static final class CLASS extends StructureKind {

        /* renamed from: a, reason: collision with root package name */
        public static final CLASS f55765a = new CLASS();
    }

    @Metadata
    public static final class LIST extends StructureKind {

        /* renamed from: a, reason: collision with root package name */
        public static final LIST f55766a = new LIST();
    }

    @Metadata
    public static final class MAP extends StructureKind {

        /* renamed from: a, reason: collision with root package name */
        public static final MAP f55767a = new MAP();
    }

    @Metadata
    public static final class OBJECT extends StructureKind {

        /* renamed from: a, reason: collision with root package name */
        public static final OBJECT f55768a = new OBJECT();
    }
}
