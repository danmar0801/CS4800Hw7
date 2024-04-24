import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CachedSongService implements SongService {
    private final RealSongService realService;
    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();

    public CachedSongService(RealSongService realService) {
        this.realService = realService;
    }

    public Song searchById(Integer songID) {
        return idCache.computeIfAbsent(songID, realService::searchById);
    }

    public List<Song> searchByTitle(String title) {
        return titleCache.computeIfAbsent(title, realService::searchByTitle);
    }

    public List<Song> searchByAlbum(String album) {
        return albumCache.computeIfAbsent(album, realService::searchByAlbum);
    }
}
