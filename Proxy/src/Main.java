import java.util.List;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        RealSongService realService = new RealSongService();
        CachedSongService proxyService = new CachedSongService(realService);

        // Creating 5 fake songs
        realService.addSong(new Song(1, "Echoes of Silence", "The Weeknight", "Starless Sky", 210));
        realService.addSong(new Song(2, "Rivers in Reverse", "Ellie Rogue", "Flowing Streams", 165));
        realService.addSong(new Song(3, "Midnight Drive", "Neon Visions", "City Lights", 180));
        realService.addSong(new Song(4, "Chasing Shadows", "Luna Daydream", "Shifting Sands", 200));
        realService.addSong(new Song(5, "Whispers and Wishes", "Harper Echo", "Quiet Corners", 190));

        // Simulate song search by ID
        System.out.println("Fetching song with ID 3...");
        Song song = proxyService.searchById(3);
        System.out.println("Song fetched: " + song.getTitle());

        // Simulate song search by title
        String title = "Echoes of Silence";
        System.out.println("Fetching songs with title: " + title);
        List<Song> songsByTitle = proxyService.searchByTitle(title);
        System.out.println("Songs fetched: " + songsByTitle.size());

        // Simulate song search by album
        String album = "City Lights";
        System.out.println("Fetching songs from album: " + album);
        List<Song> songsByAlbum = proxyService.searchByAlbum(album);
        System.out.println("Songs fetched: " + songsByAlbum.size());

        // Additional search by Title
        String additionalTitleSearch = "Chasing Shadows";
        System.out.println("\nFetching songs with title: " + additionalTitleSearch);
        List<Song> additionalSongsByTitle = proxyService.searchByTitle(additionalTitleSearch);
        System.out.println("Additional songs fetched by title: " + additionalSongsByTitle.stream().map(Song::getTitle).collect(
                Collectors.joining(", ")));

        // Additional search by Album
        String additionalAlbumSearch = "Quiet Corners";
        System.out.println("\nFetching songs from album: " + additionalAlbumSearch);
        List<Song> additionalSongsByAlbum = proxyService.searchByAlbum(additionalAlbumSearch);
        System.out.println("Additional songs fetched by album: " + additionalSongsByAlbum.stream().map(Song::getTitle).collect(
                Collectors.joining(", ")));

    }
}