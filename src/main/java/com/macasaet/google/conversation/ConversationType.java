package com.macasaet.google.conversation;


public enum ConversationType {

    TYPE_UNSPECIFIED,
    NEW,
    ACTIVE,
    EXPIRED,
    ARCHIVED;

    public static ConversationType forString(final String string) {
        for (final ConversationType candidate : values()) {
            if (candidate.name().equalsIgnoreCase(string)) {
                return candidate;
            }
        }
        return TYPE_UNSPECIFIED;
    }
}