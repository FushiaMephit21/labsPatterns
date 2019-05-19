using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Facade
{
    class Program
    {
        static void Main(string[] args)
        {
            Station station = new Station();
            station.copy();

            Console.ReadKey();
        }
    }

    class Station
    {
        Power power = new Power();
        Video v = new Video();
        PlayVideo pv = new PlayVideo();

        public void copy()
        {
            power.on();
            v.load();
            pv.copyFromVideo(v);
        }
    }

    class Power
    {
        public void on()
        {
            Console.WriteLine("Включення живлення");
        }
        public void off()
        {
            Console.WriteLine("Виключення живлення");
        }
    }

    class Video
    {
        private bool data = false;
        public bool hasData()
        {
            return data;
        }
        public void load()
        {
            data = true;
        }
        public void unload()
        {
            data = false;
        }
    }

    class PlayVideo
    {
        public void copyFromVideo(Video v)
        {
            if (v.hasData())
            {
                Console.WriteLine("Відбувається відтворення реклами");
            }
            else {
                Console.WriteLine("Потрібно завантажити реклами");
            }
        }
    }
}
