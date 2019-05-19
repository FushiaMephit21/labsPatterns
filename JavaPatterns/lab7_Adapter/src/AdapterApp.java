
public class AdapterApp {
    public static void main(String[] args) {
        PictureToVideo ptv = new PictureToVideo();
        System.out.println(ptv.nameVideo);
        ptv.showVideo();

//        PictureToVideo2 ptv2 = new PictureToVideo2();
//        System.out.println(ptv2.nameVideo);
//        ptv2.showVideo();
    }
}

interface Video {
    String nameVideo = "";
    void showVideo();
}

class Picture {
    public String namePicture = "Моє фото";
    void showPicture() {
        System.out.println("Показати картинку: " + namePicture);
    }
}

// 1-й спосіб
class PictureToVideo extends Picture implements Video {
    public String nameVideo = namePicture;

    public void showVideo() {
        showPicture();
    }
}

// 2-й спосіб
//class PictureToVideo2 implements Video {
//    Picture p = new Picture();
//    public String nameVideo = p.namePicture;
//    public void showVideo() {
//        p.showPicture();
//    }
//}