package Zade.Server.TimeSeries;

public class SeriesNotFoundException extends RuntimeException {

    public SeriesNotFoundException(Long id) {
        super("Could not find Series " + id);
    }
}
