using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Adapter
{
    class Program
    {
        static void Main(string[] args)
        {
            PictureToVideo2 ptv2 = new PictureToVideo2();
                    ptv2.showVideo();
            Console.ReadKey();
        }
    }

    interface Video
    {
        void showVideo();
    }

    class Picture
    {
        public string namePicture = "Моє фото";
        public void showPicture()
        {
            Console.WriteLine("Показати картинку: " + namePicture);
        }
    }

    class PictureToVideo2 : Video
    {
            Picture p = new Picture();
            public void showVideo() {
                p.showPicture();
            }
        }
    }
