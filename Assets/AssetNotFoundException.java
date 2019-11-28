package Zade.Server.Assets;

public class AssetNotFoundException extends RuntimeException {

    public AssetNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}