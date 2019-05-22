using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Prototype
{
    class Program
    {
        static void Main(string[] args)
        {
            Ad original = new Ad("Jacobs", 30);
            Console.WriteLine(original.toString());

            Ad copy = (Ad)original.copy();
            Console.WriteLine(copy.toString());

            AdFactory factory = new AdFactory(copy);
            Ad a1 = factory.makeCopy();
            Console.WriteLine(a1.toString());

            factory.setPrototype(new Ad("Nescafe", 180));
            Ad a2 = factory.makeCopy();
            Console.WriteLine(a2.toString());

            Console.ReadKey();
        }
    }

    interface Copyable
    {
        Object copy();
    }



    class Ad : Copyable
    {
        String name;
        int timeLong;

        public Ad(String name, int timeLong)
        {
            this.name = name;
            this.timeLong = timeLong;
        }
        public String toString()
        {
            return "Ad [name=" + name + ", timeLong=" + timeLong + "]";
        }

        public Object copy()
        {
            Ad copy = new Ad(name, timeLong);
            return copy;
        }

    }

    class AdFactory
    {
        Ad ad;
        public AdFactory(Ad ad)
        {
            setPrototype(ad);
        }
        public void setPrototype(Ad ad)
        {
            this.ad = ad;
        }
        public Ad makeCopy()
        {
            return (Ad)ad.copy();
        }
    }
}
