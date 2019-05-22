using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Singleton
{
    class Program
    {
        static void Main(string[] args)
        {
            const int SIZE = 1000;

            Thread[] t = new Thread[SIZE];

            Singleton[] arr = new Singleton[SIZE];

            for (int i = 0; i < SIZE; i++)
            {
                t[i] = new Thread(new R());
                t[i].Start();
            }

            for (int i = 0; i < SIZE; i++)
            {
                t[i].Join();
            }

            Console.WriteLine(Singleton.counter);
            Console.ReadKey();
        }
    }



    class R : ThreadStart
    {
        public override void Run()
        {
            Singleton.getInstance();
        }
    }

    class Singleton
    {
        private readonly static object sync = new object();
        public static int counter = 0;
        private static volatile Singleton instance = null;

        public Singleton()
        {
            counter++;
        }

        public static Singleton getInstance()
        {
            if (instance == null)
            {
                /*         public void SyncMethod() {
                     lock (sync) {
                         if (instance == null)
                             instance = new Singleton();
                     }
                 }   */


                return instance;
            }
            return instance;
        }
    }
}
