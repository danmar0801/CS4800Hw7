import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RealSongService implements SongService {
    private final Map<Integer, Song> songsDatabase = new HashMap<>();
    public Song searchById(Integer songID) {
        return songsDatabase.get(songID);
    }
    public List<Song> searchByTitle(String title) {
        return songsDatabase.values().stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    public List<Song> searchByAlbum(String album) {
        return songsDatabase.values().stream()
                .filter(song -> song.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }
    public void addSong(Song song) {
        songsDatabase.put(song.getId(), song);
    }
    // Helper method to simulate network latency
    private void simulateNetworkLatency() {
        try {
            Thread.sleep(1000); // Simulates 1 second of network latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
