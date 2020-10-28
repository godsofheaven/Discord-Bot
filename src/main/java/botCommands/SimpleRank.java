package botCommands;

public enum  SimpleRank {
    BANNED_USER("Will be ignored"),
    BOT("Will be ignored"),
    USER("Regular user"),
    INTERACTION_BOT("Bot can interact"),
    GUILD_BOT_ADMIN("Bot admin for a guild"),
    GUILD_ADMIN("Admin in a guild"),
    GUILD_OWNER("Owner of a guild"),
    CONTRIBUTOR("Contributor"),
    BOT_ADMIN("Bot administrator"),
    SYSTEM_ADMIN("System admin"),
    CREATOR("Creator");
    private final String description;

    SimpleRank(String description) {
        this.description = description;
    }

    /**
     * find a rank by name
     *
     * @param search the role to search for
     * @return rank || null
     */
    public static SimpleRank findRank(String search) {
        for (SimpleRank simpleRank : values()) {
            if (simpleRank.name().equalsIgnoreCase(search)) {
                return simpleRank;
            }
        }
        return null;
    }

    public boolean isAtLeast(SimpleRank rank) {
        return this.ordinal() >= rank.ordinal();
    }

    public boolean isHigherThan(SimpleRank rank) {
        return this.ordinal() > rank.ordinal();
    }

    public String getDescription() {
        return description;
    }
}
