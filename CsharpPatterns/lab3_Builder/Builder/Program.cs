using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Builder
{
    class Program
    {
        static void Main(string[] args)
        {
            Director director = new Director();
            director.setBuilder(new JacobsMonarchBuilder());
            Ad ad = director.BuildAd();
            Console.WriteLine(ad.toString());
            Console.ReadKey();
        }
    }

    enum TypeAd
    {
        Video, PPlacement
    }

    class Ad
    {
        String name;
        TypeAd typeAd;
        int longTime;

        public void setName(String name) { this.name = name; }
        public void setTypeAd(TypeAd typeAd) { this.typeAd = typeAd; }
        public void setLongTime(int longTime) { this.longTime = longTime; }
        public String toString()
        {
            return "Ad [name=" + name + ", typeAd=" + typeAd + ", longTime=" + longTime + "s]";
        }
    }

    abstract class AdBuilder
    {
       public Ad ad;
        public void createAd() { ad = new Ad(); }

        public abstract void buildName();
        public abstract void buildTypeAd();
        public abstract void buildLongTime();

        public Ad getAd() { return ad; }
    }

    class JacobsMonarchBuilder : AdBuilder
    {
        public override void buildName() { ad.setName("Jacobs Monarch Coffe"); }
        public override void buildTypeAd() { ad.setTypeAd(TypeAd.Video); }
        public override void buildLongTime() { ad.setLongTime(15); }
    }

    class LacalutWhiteBuilder : AdBuilder
    {
        public override void buildName() { ad.setName("Lacalut White Toothpaste"); }
        public override void buildTypeAd() { ad.setTypeAd(TypeAd.PPlacement); }
        public override void buildLongTime() { ad.setLongTime(1800); }
    }

    class Director
    {
        AdBuilder builder;
        public void setBuilder(AdBuilder b) { builder = b; }

       public Ad BuildAd()
        {
            builder.createAd();
            builder.buildName();
            builder.buildTypeAd();
            builder.buildLongTime();
            Ad ad = builder.getAd();
            return ad;
        }
    }
}
