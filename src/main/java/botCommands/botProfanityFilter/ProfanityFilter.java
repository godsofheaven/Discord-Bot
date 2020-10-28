package botCommands.botProfanityFilter;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ProfanityFilter extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        String[] LIST_OF_CURSE_WORDS = {"anal",
                "anus",
                "arse",
                "ass",
                "bastard",
                "bitch",
                "biatch",
                "blowjob",
                "blow job",
                "bollock",
                "bollok",
                "boner",
                "butt",
                "buttplug",
                "clitoris",
                "cock",
                "coon",
                "crap",
                "cunt",
                "dick",
                "dildo",
                "dyke",
                "fag",
                "feck",
                "fellate",
                "fellatio",
                "felching",
                "fuck",
                "f u c k",
                "fudgepacker",
                "fudge packer",
                "flange",
                "homo",
                "jerk",
                "jizz",
                "knobend",
                "knob end",
                "labia",
                "muff",
                "nigger",
                "nigga",
                "penis",
                "piss",
                "poop",
                "prick",
                "pube",
                "pussy",
                "queer",
                "scrotum",
                "sex",
                "shit",
                "s hit",
                "sh1t",
                "slut",
                "smegma",
                "spunk",
                "tit",
                "tosser",
                "turd",
                "twat",
                "vagina",
                "wank",
                "whore"};



        String [] message = e.getMessage().getContentRaw().split(" ");
        for (int i = 0; i < message.length; i++){
            for (int b = 0; b<LIST_OF_CURSE_WORDS.length; b++)
                if (message[i].equalsIgnoreCase(LIST_OF_CURSE_WORDS[b])){
                    e.getMessage().delete().queue();
                    e.getChannel().sendMessage("Your message has been removed for containing inappropriate language").queue();
                }
        }
    }
}


