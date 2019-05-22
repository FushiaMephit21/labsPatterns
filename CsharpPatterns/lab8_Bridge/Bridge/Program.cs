using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Bridge
{
    class Program
    {
        static void Main(string[] args)
        {
            Ad c = new ProdPlace(new Twix());
            c.showDetails();

            Console.ReadKey();
        }
    }
    class Ad
    {
        public Make make;
        public Ad(Make m) { make = m; }
        public virtual void showDetails() { }

    }

    class Video : Ad
    {
        public Video(Make m) : base(m) { }
        public override void showDetails()
        {
            Console.WriteLine("Video");
            make.setMake();
        }
    }

    class ProdPlace : Ad
    {
        public ProdPlace(Make m) : base(m) { }
        public override void showDetails()
        {
            Console.WriteLine("Product placement");
            make.setMake();
        }
    }

    interface Make
    {
        void setMake();
    }

    class Jacobs : Make
    {
        public void setMake()
        {
            Console.WriteLine("Jacobs");
        }
    }

    class Twix : Make
    {
        public void setMake()
        {
            Console.WriteLine("Twix");
        }
    }
}