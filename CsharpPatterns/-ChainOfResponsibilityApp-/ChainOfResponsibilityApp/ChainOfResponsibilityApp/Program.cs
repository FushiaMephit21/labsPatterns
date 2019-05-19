using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChainOfResponsibilityApp
{
    class Program
    {
        static void Main(string[] args)
        {
            SMSLogger logger0 = new SMSLogger(Level.ERROR);

            Console.ReadKey();
        }
    }
    class Level
    {
        public static readonly int ERROR = 1;
        public static readonly int DEBUG = 2;
        public static readonly int INFO = 3;
    }

    interface Logger
    {
        void writeMessage(String message, int level);
    }

    class SMSLogger : Logger
    {
        int priority;
        public SMSLogger(int priority) { this.priority = priority; }
        Logger next;
        public void setNext(Logger next) { this.next = next; }
        public void writeMessage(String message, int level)
        {
            if (level <= priority)
            {
                Console.WriteLine("СМС: " + message);
            }
            if (next == null)
            {
                next.writeMessage(message, level);
            }
        }
    }
}
