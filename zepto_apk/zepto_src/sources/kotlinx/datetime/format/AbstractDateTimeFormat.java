package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.parser.Copyable;
import kotlinx.datetime.internal.format.parser.ParseException;
import kotlinx.datetime.internal.format.parser.Parser;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class AbstractDateTimeFormat<T, U extends Copyable<U>> implements DateTimeFormat<T> {
    public abstract CachedFormatStructure a();

    public abstract Copyable b();

    public abstract Object c(Copyable copyable);

    @Override // kotlinx.datetime.format.DateTimeFormat
    public final Object parse(String input) {
        String str;
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            ParserStructure commands = a().f55531c;
            Intrinsics.checkNotNullParameter(commands, "commands");
            try {
                return c(Parser.a(commands, input, b()));
            } catch (IllegalArgumentException e2) {
                String message = e2.getMessage();
                if (message == null) {
                    str = "The value parsed from '" + ((Object) input) + "' is invalid";
                } else {
                    str = message + " (when parsing '" + ((Object) input) + "')";
                }
                throw new DateTimeFormatException(str, e2);
            }
        } catch (ParseException e3) {
            throw new DateTimeFormatException("Failed to parse value from '" + ((Object) input) + '\'', e3);
        }
    }
}
