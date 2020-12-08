package botCommands.Miscellaneous;

import botCommands.BaseCommand;
import botCommands.CommandCategory;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.dv8tion.jda.api.entities.Guild;

import java.text.DecimalFormat;
import java.util.Objects;

public class WeatherCommand extends BaseCommand {
    //YOUR_API_KEY_HERE https://home.openweathermap.org/api_keys
    OWM owm = new OWM("");

    public String getWeather(String city) throws APIException {
        DecimalFormat df = new DecimalFormat("#");
        CurrentWeather currentWeather = owm.currentWeatherByCityName(city);
        String currentTemp = df.format(Objects.requireNonNull(currentWeather.getMainData()).getTemp() - 273.15);
        return (currentWeather.getCityName() + "\n" + currentTemp + "°C");
    }

    @Override
    public String run() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getUsage(Guild guild) {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public CommandCategory getParentCategory() {
        return null;
    }
}
