package W10.B4_MediaPlayer;

import java.util.Objects;


// 1. Các giao diện nhỏ, mỗi giao diện một chức năng (ISP)
interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}

// 2. AudioPlayer chỉ cài đặt chức năng âm thanh
class AudioPlayer implements AudioPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("[AudioPlayer] Đang phát âm thanh: " + file);
    }
}

// 3. VideoPlayer chỉ cài đặt chức năng video
class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("[VideoPlayer] Đang phát video: " + file);
    }
}

// Lớp thêm để minh họa DIP: một trình phát khác có thể thay vào
// mà MediaPlayer không phải sửa. Lớp này làm được cả hai việc,
// nên được phép cài đặt cả hai giao diện.
class VlcPlayer implements AudioPlayable, VideoPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("[VLC]         Đang phát âm thanh: " + file);
    }

    @Override
    public void playVideo(String file) {
        System.out.println("[VLC]         Đang phát video: " + file);
    }
}

// 4. MediaPlayer: lớp cấp cao, chỉ phụ thuộc vào giao diện (DIP)
class MediaPlayer {
    private final AudioPlayable audio;
    private final VideoPlayable video;

    // Nhận phụ thuộc từ bên ngoài, KHÔNG tự new AudioPlayer/VideoPlayer
    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audio = Objects.requireNonNull(audio, "audio không được null");
        this.video = Objects.requireNonNull(video, "video không được null");
    }

    public void playAudio(String file) {
        audio.playAudio(file);
    }

    public void playVideo(String file) {
        video.playVideo(file);
    }
}

public class Main {
    public static void main(String[] args) {
        // Tạo các trình phát cụ thể ở main, rồi "tiêm" vào MediaPlayer
        AudioPlayable audio = new AudioPlayer();
        VideoPlayable video = new VideoPlayer();
        MediaPlayer player = new MediaPlayer(audio, video);

        System.out.println("=== MediaPlayer dùng AudioPlayer + VideoPlayer ===");
        player.playAudio("bai_hat.mp3");
        player.playVideo("phim.mp4");

        // Đổi sang VLC cho phần video: MediaPlayer KHÔNG phải sửa dòng nào
        System.out.println("\n=== MediaPlayer dùng AudioPlayer + VLC cho video ===");
        MediaPlayer player2 = new MediaPlayer(new AudioPlayer(), new VlcPlayer());
        player2.playAudio("podcast.mp3");
        player2.playVideo("bai_giang.mkv");
    }
}
