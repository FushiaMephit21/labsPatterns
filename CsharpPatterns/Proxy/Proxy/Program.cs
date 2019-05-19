using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proxy
{
    class Program
    {
        static void Main(string[] args)
        {
            Ad ad = new ProxyAd("D:/adVideo/jacobs.mp4");
            ad.display();

            Console.ReadKey();
        }
    }

    interface Ad
    {
        void display();
    }

    class RealAd :Ad
    {
        string file;
        public RealAd(string file)
        {
            this.file = file;
            load();
        }

        void load()
        {
            Console.WriteLine("Загрузка " + file);
        }

        public void display()
        {
            Console.WriteLine("Показ " + file);
        }
    }

    class ProxyAd : Ad
    {
        String file;
        RealAd add;
        public ProxyAd(String file)
        {
            this.file = file;
        }
        public void display()
        {
            if (add == null)
            {
                add = new RealAd(file);
            }
            add.display();
        }
    }
}
