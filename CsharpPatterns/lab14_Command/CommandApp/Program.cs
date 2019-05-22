using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CommandApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Ad c = new Ad();
            User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));

            u.startShowAd();
            u.stopShowAd();
            u.resetShowAd();

            Console.ReadKey();
        }
    }

    interface Command
    {
        void execute();
    }

    class Ad
    {
        public void start()
        {
            Console.WriteLine("Start");
        }
        public void stop()
        {
            Console.WriteLine("Stop");
        }
        public void reset()
        {
            Console.WriteLine("Reset");
        }
    }

    class StartCommand : Command
    {
        Ad ad;
        public StartCommand(Ad ad) { this.ad = ad; }
        public void execute()
        {
            ad.start();
        }
    }

    class User
    {
        Command start;
        Command stop;
        Command reset;
        public User(Command start, Command stop, Command reset)
        {
            this.start = start;
            this.stop = stop;
            this.reset = reset;
        }
        public void startShowAd()
        {
            start.execute();
        }
        public void stopShowAd()
        {
            stop.execute();
        }
        public void resetShowAd()
        {
            reset.execute();
        }

    }

    class ResetCommand : Command
    {
        Ad ad;
        public ResetCommand(Ad ad) { this.ad = ad; }
        public void execute()
        {
            ad.reset();
        }
    }

    class StopCommand : Command
    {
        Ad ad;
        public StopCommand(Ad ad) { this.ad = ad; }
        public void execute()
        {
            ad.stop();
        }
    }
}
