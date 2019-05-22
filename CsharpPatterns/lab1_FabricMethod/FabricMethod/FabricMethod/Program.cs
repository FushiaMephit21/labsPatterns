using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FabricMethod
{
    class Program
    {
        static void Main(string[] args)
        {

            AdFabric item = new adVideo();
            Ad addver = item.adf();
            addver.type();

            Console.ReadKey();
        }

    }

    interface Ad
    {
        void type();
    }

    class Video : Ad
    {
        public void type()
        {
            Console.WriteLine("Video");
        }
    }

    class Ppment:Ad
    {
        public void type()
        {
            Console.WriteLine("Product placement");
        }
    }

    interface AdFabric
    {
        Ad adf();
    }

    class adVideo : AdFabric
    {
        public Ad adf()
        {
            return new Video();
        }
    }

    class adPpment:AdFabric
    {
        public Ad adf()
        {
            return new Ppment();
        }
    }
}
