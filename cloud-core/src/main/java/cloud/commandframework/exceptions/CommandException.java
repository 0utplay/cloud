package cloud.commandframework.exceptions;

import cloud.commandframework.captions.Caption;
import cloud.commandframework.captions.CaptionVariableReplacementHandler;

public class CommandException extends RuntimeException {

    private static final long serialVersionUID = -2437839110795163839L;
    private final String message;

    public CommandException(
            final Caption caption,
            final CaptionVariableReplacementHandler replacementHandler,
            final Object... captionVariables
    ) {
        this.message = replacementHandler.replaceVariables(caption, captionVariables);
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public final Throwable initCause(final Throwable cause) {
        return this;
    }

}
