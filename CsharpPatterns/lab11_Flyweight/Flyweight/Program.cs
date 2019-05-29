using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace Flyweight
{
    public class FlyweightApp
    {
        public static void Main(String[] args)
        {

            BroadcastingFactory broadcastingFactory = new BroadcastingFactory();
            List<Broadcasting> broadcastings = new List<Broadcasting>();

            broadcastings.Add(broadcastingFactory.getBroadcasting("video"));
            broadcastings.Add(broadcastingFactory.getBroadcasting("advrtismnt"));
            broadcastings.Add(broadcastingFactory.getBroadcasting("advrtismnt"));
            broadcastings.Add(broadcastingFactory.getBroadcasting("pp"));
            broadcastings.Add(broadcastingFactory.getBroadcasting("video"));
            broadcastings.Add(broadcastingFactory.getBroadcasting("pp"));

            Random rand = new Random();
            foreach (Broadcasting broadcasting in broadcastings)
            {
                int y = (rand.Next(3));
                switch (y)
                {
                    case 1:
                        broadcasting.play("Jacobs Coffe");
                        break;
                    case 2:
                        broadcasting.play("Nescafe Coffe");
                        break;
                    default:
                        broadcasting.play("MacCoffe");
                        break;
                }
            }
            Console.ReadKey();
        }
    }

    interface Broadcasting
    {
        void play(String x);
    }

    class AdVideo : Broadcasting
    {
    int t = 30;
    public void play(String x)
    {
        template.templ("рекламний відео-ролик", x, t);
    }
}

class TVShowWthAdTM : Broadcasting
{
    int t = 1200;
    public void play(String x)
{
    template.templ("телешоу з рекламними вставками", x, t);
}
}

class TVShowWthPP : Broadcasting
{
    int t=1800;
    public void play(String x)
{
    template.templ("телешоу з продукт-плейсментом", x, t);
}
}

class BroadcastingFactory
{
    
    private static Dictionary<String, Broadcasting> broadcastings = new Dictionary<String, Broadcasting>();
    public Broadcasting getBroadcasting(String broadcastingName)
    {
        Broadcasting broadcasting;
        broadcastings.TryGetValue(broadcastingName, out broadcasting);
        if (broadcasting == null)
        {
            switch (broadcastingName)
            {
                case "video":
                    broadcasting = new AdVideo();
                    break;
                case "advrtismnt":
                    broadcasting = new TVShowWthAdTM();
                    break;
                case "pp":
                    broadcasting = new TVShowWthPP();
                    break;
            }
            broadcastings[broadcastingName] = broadcasting;
        }
        return broadcasting;
    }
}


//========================================================
class template
{
    public static void templ(String a, String b, int c)
    {
        Console.WriteLine("Відтворюється: " + a);
        Console.WriteLine("Спонсор: " + b);
        Console.WriteLine("Тривалість: " + c + " секунд");
        Console.WriteLine("------------------------------");
    }
}
}
